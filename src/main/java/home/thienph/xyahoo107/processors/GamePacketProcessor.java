package home.thienph.xyahoo107.processors;

import home.thienph.xyahoo107.connections.PacketHandler;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.data.game.CardInfo;
import home.thienph.xyahoo107.data.game.GameRoom;
import home.thienph.xyahoo107.data.media.BuddyInfo;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.data.media.BuddyGroupList;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.GameScreen;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.PacketUtils;
import home.thienph.xyahoo107.utils.TextValidator;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Image;
import java.util.Vector;

public final class GamePacketProcessor extends PacketHandler {
    public static GameManager gameManager;
    private static GamePacketProcessor instance = null;
    private static String serverMessage;

    private GamePacketProcessor() {
    }

    public static GamePacketProcessor getInstance() {
        if (instance == null) {
            instance = new GamePacketProcessor();
        }

        return instance;
    }

    public void onConnectionError() {
        gameManager.onConnectionError();
    }

    public void onConnectionLost() {
        gameManager.onConnectionLost();
    }

    public void resetConnectionFlag() {
        GameManager.resetConnectionFlag();
    }

    public void handlePacket(Packet packet, int commandId) {
        int var3 = packet.getTypeId();
        switch (commandId) {
            /*
             * Case -5 - Do Nothing:
             * Ý nghĩa: Không thực hiện hành động gì
             */
            case -5:
                GameManager.doNothing();
                return;

            /*
             * Case -3 - Register Failed:
             * Ý nghĩa: Thông báo đăng ký thất bại
             */
            case -3:
                gameManager.onRegisterFailed();
                return;

            /*
             * Case -2 - Register Success:
             * Ý nghĩa: Thông báo đăng ký thành công
             */
            case -2:
                gameManager.onRegisterSuccess();
                return;

            /*
             * Case -1 - Login Failed:
             * Ý nghĩa: Thông báo đăng nhập thất bại
             */
            case -1:
                gameManager.onLoginFailed();
                return;

            /*
             * Case 2 - Update Server Config:
             * Ý nghĩa: Cập nhật cấu hình server với danh sách IP và port
             *
             * Dữ liệu packet:
             *     int: serverCount - số lượng server
             *     [serverCount lần]:
             *         string: serverIP - địa chỉ IP server
             *         int: serverPort - port của server
             */
            case 2:
                int serverCount;
                String[] serverIPs = new String[serverCount = PacketUtils.readInt(packet)];
                int[] serverPorts = new int[serverCount];
                System.out.println("IPs:");

                for (int serverIndex = 0; serverIndex < serverCount; serverIndex++) {
                    serverIPs[serverIndex] = PacketUtils.readString(packet);
                    System.out.println(serverIPs[serverIndex]);
                    serverPorts[serverIndex] = PacketUtils.readInt(packet);
                    System.out.println(serverPorts[serverIndex]);
                }

                GameManager.updateServerConfig(serverIPs, serverPorts);
                return;

            /*
             * Case 3 - Update User Avatar:
             * Ý nghĩa: Cập nhật avatar của người dùng
             *
             * Dữ liệu packet:
             *     long: userId - ID của người dùng
             *     byte: avatarPartCount - số lượng phần avatar
             *     [avatarPartCount lần]: int avatarPartId - ID từng phần avatar
             */
            case 3:
                long userId = PacketUtils.readLong(packet);
                byte avatarPartCount;
                int[] avatarPartIds = new int[avatarPartCount = packet.getPayload().readByte()];

                for (byte partIndex = 0; partIndex < avatarPartCount; partIndex += 1) {
                    avatarPartIds[partIndex] = PacketUtils.readInt(packet);
                }

                gameManager.updateUserAvatar(userId, avatarPartIds);
                return;

            /*
             * Case 39 - Show Notification or Message:
             * Ý nghĩa: Hiển thị thông báo hoặc tin nhắn
             *
             * Dữ liệu packet:
             *     string: messageText - nội dung tin nhắn
             *     int: messageType - loại tin nhắn (0=notification, 1=message)
             */
            case 39:
                String messageText = PacketUtils.readString(packet);
                int messageType;
                if ((messageType = PacketUtils.readInt(packet)) == 0) {
                    gameManager.addNotification(0, messageText, null, 180, 2, null);
                    return;
                }

                if (messageType == 1) {
                    gameManager.showMessage(messageText);
                    return;
                }
                break;

            /*
             * Case 44 - Set Server Message:
             * Ý nghĩa: Thiết lập tin nhắn từ server
             *
             * Dữ liệu packet:
             *     string: serverMessage - tin nhắn từ server
             */
            case 44:
                serverMessage = PacketUtils.readString(packet);
                return;

            /*
             * Case 45 - Show SMS Confirm Dialog:
             * Ý nghĩa: Hiển thị dialog xác nhận SMS
             *
             * Dữ liệu packet:
             *     string: phoneNumber - số điện thoại
             *     string: smsCode - mã SMS
             *     string: confirmMessage - tin nhắn xác nhận
             */
            /*
             * Case 45 - Show SMS Confirm Dialog:
             * Ý nghĩa: Hiển thị dialog xác nhận SMS
             *
             * Dữ liệu packet:
             *     string: phoneNumber - số điện thoại
             *     string: smsCode - mã SMS
             *     string: confirmMessage - tin nhắn xác nhận
             */
            case 45:
                String phoneNumber = PacketUtils.readString(packet);
                String smsCode = PacketUtils.readString(packet);
                String confirmMessage = PacketUtils.readString(packet);
                gameManager.showSMSConfirmDialog(confirmMessage, phoneNumber, smsCode);
                return;

            /*
             * Case 64 - Password Change Result:
             * Ý nghĩa: Hiển thị kết quả thay đổi mật khẩu
             *
             * Dữ liệu packet:
             *     boolean: isSuccessful - kết quả thay đổi mật khẩu
             */
            case 64:
                boolean isPasswordChangeSuccessful = PacketUtils.readBoolean(packet);
                gameManager.showPasswordChangeResult(isPasswordChangeSuccessful);
                return;

            /*
             * Case 113 - Update Banned Words List:
             * Ý nghĩa: Cập nhật danh sách từ cấm
             *
             * Dữ liệu packet:
             *     int: bannedWordCount - số lượng từ cấm
             *     [bannedWordCount lần]: string bannedWord - từ cấm
             */
            case 113:
                int bannedWordCount;
                TextValidator.BANNED_WORDS = new String[bannedWordCount = PacketUtils.readInt(packet)];

                for (int wordIndex = 0; wordIndex < bannedWordCount; wordIndex++) {
                    TextValidator.BANNED_WORDS[wordIndex] = PacketUtils.readString(packet);
                }

                return;

            /*
             * Case 120 - Cache Image Data:
             * Ý nghĩa: Lưu cache dữ liệu hình ảnh
             *
             * Dữ liệu packet:
             *     int: imageId - ID của hình ảnh
             *     bytes: imageData - dữ liệu hình ảnh
             */
            case 120:
                Integer imageId = new Integer(PacketUtils.readInt(packet));
                byte[] imageData = PacketUtils.readBytes(packet);
                GameManager.cacheImageData(imageId, imageData);
                return;

            /*
             * Case 121 - Process Received Data:
             * Ý nghĩa: Xử lý dữ liệu nhận được
             *
             * Dữ liệu packet:
             *     bytes: receivedData - dữ liệu nhận được
             */
            case 121:
                System.gc();
                byte[] receivedData = PacketUtils.readBytes(packet);
                gameManager.processReceivedData(receivedData);
                return;

            /*
             * Case 122 - Load Cached Data:
             * Ý nghĩa: Tải dữ liệu từ cache
             *
             * Dữ liệu packet:
             *     int: cacheId1 - ID cache thứ nhất
             *     int: cacheId2 - ID cache thứ hai
             */
            case 122:
                int cachedId = PacketUtils.readInt(packet);
                int dataVersion = PacketUtils.readInt(packet);
                gameManager.loadCachedData(cachedId, dataVersion);
                return;

            /*
             * Case 123 - Save Cached Data:
             * Ý nghĩa: Lưu dữ liệu vào cache
             *
             * Dữ liệu packet:
             *     int: saveId1 - ID lưu thứ nhất
             *     int: dataVersion1 - version data
             *     bytes: dataToSave - dữ liệu cần lưu
             */
            case 123:
                System.gc();
                int saveId1 = PacketUtils.readInt(packet);
                int dataVersion1 = PacketUtils.readInt(packet);
                byte[] dataToSave = PacketUtils.readBytes(packet);
                gameManager.saveCachedData(saveId1, dataVersion1, dataToSave);
                return;

            /*
             * Case 269 - SMS for Password Reset:
             * Ý nghĩa: Thiết lập SMS cho việc đặt lại mật khẩu
             *
             * Dữ liệu packet:
             *     string: resetPhoneNumber - số điện thoại đặt lại
             *     string: resetSmsCode - mã SMS đặt lại
             */
            case 269:
                String resetPhoneNumber = PacketUtils.readString(packet);
                String resetSmsCode = PacketUtils.readString(packet);
                GameManager.instance.setLoadingState(false);
                gameManager.setSMSForPasswordReset(resetPhoneNumber, resetSmsCode);
                return;

            /*
             * Case 500 - Show Update Dialog:
             * Ý nghĩa: Hiển thị dialog cập nhật ứng dụng
             *
             * Dữ liệu packet:
             *     int: updateVersion - phiên bản cập nhật
             *     string: updateMessage - tin nhắn cập nhật
             */
            case 500:
                int updateVersion = PacketUtils.readInt(packet);
                String updateMessage = PacketUtils.readString(packet);
                gameManager.showUpdateDialog(updateVersion, updateMessage);
                return;

            /*
             * Case 1009 - Show Add Friend Dialog:
             * Ý nghĩa: Hiển thị dialog thêm bạn
             *
             * Dữ liệu packet:
             *     string: friendUsername - tên người dùng muốn kết bạn
             */
            case 1009:
                String friendUsername = PacketUtils.readString(packet);
                long friendId = PacketUtils.readLong(packet);
                gameManager.showAddFriendDialog(friendUsername, friendId, false);
                return;

            /*
             * Case 1029 - Add Friend Error:
             * Ý nghĩa: Xử lý lỗi khi thêm bạn
             *
             * Dữ liệu packet:
             *     string: errorMessage - tin nhắn lỗi
             */
            case 1029:
                String addFriendErrorMessage = PacketUtils.readString(packet);
                gameManager.onAddFriendError(addFriendErrorMessage);
                return;

            /*
             * Case 3403 - Join Game Room:
             * Ý nghĩa: Tham gia phòng chơi game
             *
             * Dữ liệu packet:
             *     string: roomId - ID phòng
             *     boolean: joinSuccessful - kết quả tham gia
             *     [nếu joinSuccessful = true]:
             *         string: roomType - loại phòng
             *         string: roomName - tên phòng
             *         long: hostId - ID chủ phòng
             *         int: playerCount - số lượng người chơi
             *         [playerCount lần]:
             *             string: playerName - tên người chơi
             *             boolean: isReady - trạng thái sẵn sàng
             *             long: playerId - ID người chơi
             *             int: playerAvatar - avatar người chơi
             *         boolean: isGoldGame - có phải game vàng
             *         string: gameMode - chế độ game
             *         string: gameSettings - cài đặt game
             */
            case 3403:
                String roomId = PacketUtils.readString(packet);
                boolean joinSuccessful = PacketUtils.readBoolean(packet);
                Object roomName = null;
                long hostId = 0L;
                if (joinSuccessful) {
                    if (GameScreen.isInGame && !GameScreen.currentRoomId.equals(roomId)) {
                        return;
                    }

                    PacketUtils.readString(packet);
                    roomName = PacketUtils.readString(packet);
                    hostId = PacketUtils.readLong(packet);
                    int playerCount;
                    String[] playerNames = new String[playerCount = PacketUtils.readInt(packet)];
                    long[] playerIds = new long[playerCount];
                    int[] playerAvatars = new int[playerCount];
                    boolean[] playersReady = new boolean[playerCount];

                    for (int playerIndex = 0; playerIndex < playerCount; playerIndex++) {
                        playerNames[playerIndex] = PacketUtils.readString(packet);
                        playersReady[playerIndex] = PacketUtils.readBoolean(packet);
                        playerIds[playerIndex] = PacketUtils.readLong(packet);
                        playerAvatars[playerIndex] = PacketUtils.readInt(packet);
                        if (playerAvatars[playerIndex] != -1) {
                            playerAvatars[playerIndex] = (short) playerAvatars[playerIndex];
                        }
                    }

                    GameScreen.instance.isGoldGame = PacketUtils.readBoolean(packet);
                    GameScreen gameScreen = GameScreen.instance;
                    String gameMode = PacketUtils.readString(packet);
                    String gameSettings = PacketUtils.readString(packet);
                    UIUtils.setScreenSubtitleText(gameScreen, UIUtils.concatStrings(gameMode, " - ", gameSettings, null));
                    gameManager.joinGameRoom(roomId, hostId, playerNames, playerIds, playerAvatars, playersReady, (String) roomName);
                } else {
                    showErrorNotification(packet);
                }

                GameManager.instance.setLoadingState(false);
                return;
            case 3405:
                String var104 = PacketUtils.readString(packet);
                int var105;
                String[] var106 = new String[var105 = PacketUtils.readInt(packet)];
                boolean[] var107 = new boolean[var105];

                for (int var256 = 0; var256 < var105; var256++) {
                    var106[var256] = PacketUtils.readString(packet);
                    var107[var256] = PacketUtils.readBoolean(packet);
                }

                GameManager.updatePlayerReadyStates(var104, var106, var107);
                return;
            case 3406:
                String var108 = PacketUtils.readString(packet);
                if (PacketUtils.readBoolean(packet)) {
                    PacketUtils.readString(packet);
                    byte[] var259 = PacketUtils.readBytes(packet);
                    String var260 = PacketUtils.readString(packet);
                    boolean var261 = PacketUtils.readBoolean(packet);
                    PacketUtils.readLong(packet);
                    long var102 = 0L;
                    GameManager.handleSpecialGameStart(var108, var259, var260, var261);
                    return;
                }

                showErrorNotification(packet);
                return;
            case 3407:
                String var119 = PacketUtils.readString(packet);
                if (PacketUtils.readBoolean(packet)) {
                    String var265 = PacketUtils.readString(packet);
                    String var122 = PacketUtils.readString(packet);
                    boolean var268 = PacketUtils.readBoolean(packet);
                    if (PacketUtils.readBoolean(packet)) {
                        PacketUtils.readString(packet);
                        PacketUtils.readString(packet);
                        PacketUtils.readLong(packet);
                    }

                    GameManager.updatePlayerTurn(var119, var265, var122, var268);
                    return;
                }
                break;
            case 3408:
                String var121 = PacketUtils.readString(packet);
                if (PacketUtils.readBoolean(packet)) {
                    String var267 = PacketUtils.readString(packet);
                    int var269 = PacketUtils.readInt(packet);
                    byte[] var270 = PacketUtils.readBytes(packet);
                    String var271 = PacketUtils.readString(packet);
                    boolean var272 = PacketUtils.readBoolean(packet);
                    if (PacketUtils.readBoolean(packet)) {
                        int var273 = PacketUtils.readInt(packet);
                        gameManager.handlePlayerMoveWithState(var121, var267, var269, var270, var271, var272, var273);
                        return;
                    }

                    gameManager.handlePlayerMove(var121, var267, var269, var270, var271, var272);
                    return;
                }

                String var266 = PacketUtils.readString(packet);
                GameManager.getInstance().showNotification(var266, (Image) null, 1);
                PacketUtils.readInt(packet);
                PacketUtils.readBytes(packet);
                if (GameScreen.currentRoomId.equals(var121)) {
                    GameManager.deselectAllCards();
                    return;
                }
                break;
            case 3409:
                String var274 = PacketUtils.readString(packet);
                if (PacketUtils.readBoolean(packet)) {
                    String var275 = PacketUtils.readString(packet);
                    if (PacketUtils.readBoolean(packet)) {
                        String var277 = PacketUtils.readString(packet);
                        boolean var279 = PacketUtils.readBoolean(packet);
                        PacketUtils.readBytes(packet);
                        if (PacketUtils.readBoolean(packet)) {
                            PacketUtils.readString(packet);
                            PacketUtils.readString(packet);
                            PacketUtils.readLong(packet);
                        }

                        GameManager.updatePlayerTurnHidden(var274, var275, var277, var279);
                        return;
                    }

                    String var137 = PacketUtils.readString(packet);
                    int var276;
                    String[] var278 = new String[var276 = PacketUtils.readInt(packet)];

                    for (byte var280 = 0; var280 < var276; var280 += 1) {
                        var278[var280] = PacketUtils.readString(packet);
                    }

                    String var281 = PacketUtils.readString(packet);
                    gameManager.handlePlayerLeaveRoom(var274, var275, var137, var278, var281);
                    return;
                }
                break;
            case 3410:
                PacketUtils.readString(packet);
                if (!PacketUtils.readBoolean(packet)) {
                    showErrorNotification(packet);
                    return;
                }

                PacketUtils.readString(packet);
                long var289 = PacketUtils.readLong(packet);
                if (var3 != 39) {
                    return;
                }

                GameScreen.instance.setBetAmount(var289);
                break;
            case 3411:
                String var164 = PacketUtils.readString(packet);
                String var165 = PacketUtils.readString(packet);
                String var166 = PacketUtils.readString(packet);
                GameManager.handlePlayerChat(var164, var165, var166, var3);
                break;
            case 3412:
                String var152 = PacketUtils.readString(packet);
                if (!PacketUtils.readBoolean(packet)) {
                    showErrorNotification(packet);
                    return;
                }

                String var154 = PacketUtils.readString(packet);
                int var155;
                String[] var156 = new String[var155 = PacketUtils.readInt(packet)];

                for (byte var157 = 0; var157 < var155; var157 += 1) {
                    var156[var157] = PacketUtils.readString(packet);
                }

                String var286 = PacketUtils.readString(packet);
                gameManager.handlePlayerLeaveRoom(var152, var154, GameScreen.instance.roomOwner, var156, var286);
                return;
            case 3416:
                PacketUtils.readString(packet);
                long var282 = PacketUtils.readLong(packet);
                PacketUtils.readLong(packet);
                gameManager.showMoneyNotification(var282);
                return;
            case 3417:
                showErrorNotification(packet);
                return;
            case 3418:
                String var195 = PacketUtils.readString(packet);
                byte var204 = packet.getPayload().readByte();
                int var216 = PacketUtils.readInt(packet);
                String var221 = PacketUtils.readString(packet);
                Integer var222 = new Integer(PacketUtils.readInt(packet));
                Integer var7 = new Integer(PacketUtils.readInt(packet));
                String var181 = PacketUtils.readString(packet);
                gameManager.setResource(var195, new CardInfo(var204, var216, var221, var222, var7, var181), 0);
                return;
            case 4801:
                if (PacketUtils.readBoolean(packet)) {
                    String roomName1 = UIUtils.concatStrings("P. ", PacketUtils.readString(packet), null, null);
                    String roomId3 = PacketUtils.readString(packet);
                    long ownerRoom = PacketUtils.readLong(packet);
                    PacketUtils.readLong(packet);
                    PacketUtils.readString(packet);
                    gameManager.handleChatRoomInvite(roomName1, roomId3, ownerRoom);
                    return;
                }

                showErrorNotification(packet);
                return;
            case 4802:
                showErrorNotification(packet);
                return;
            case 4803:
                String var214 = UIUtils.concatStrings("P. ", PacketUtils.readString(packet), null, null);
                Screen var219;
                if ((var219 = GameManager.instance.setActiveScreen(var214)) != null) {
                    GameManager.instance.currentChatRoom = null;
                    GameManager.instance.removeScreen(var219);
                }

                showErrorNotification(packet);
                return;
            case 4804:
                PacketUtils.readLong(packet);
                String senderName = PacketUtils.readString(packet);
                String messageContent = PacketUtils.readString(packet);
                PacketUtils.readInt(packet);
                int messageType1 = PacketUtils.readInt(packet);
                gameManager.receiveChatRoomMessage(senderName, messageContent, messageType1);
                return;
            case 4807:
                String var194 = PacketUtils.readString(packet);
                String var203 = UIUtils.concatStrings("P. ", PacketUtils.readString(packet), null, null);
                String var213 = PacketUtils.readString(packet);
                String var179 = PacketUtils.readString(packet);
                gameManager.showChatRoomInviteDialog(var194, var203, var213, var179);
                return;
            case 4809:
                showErrorNotification(packet);
                return;
            case 4813:
                String var192 = UIUtils.concatStrings("P. ", PacketUtils.readString(packet), null, null);
                String var178 = UIUtils.concatStrings("P. ", PacketUtils.readString(packet), null, null);
                Screen var193;
                if ((var193 = GameManager.instance.setActiveScreen(var192)) != null) {
                    var193.title = var178;
                    UIUtils.setScreenSubtitleText(var193, var178);
                    GameManager.instance.currentChatRoom = var178;
                    return;
                }
                break;
            case 5001:
                byte var91 = packet.getPayload().readByte();
                byte var177 = packet.getPayload().readByte();
                gameManager.initializeMediaCapture(var91, var177);
                return;
            case 5002:
                String var92 = PacketUtils.readString(packet);
                int var93 = PacketUtils.readInt(packet);
                gameManager.handleFileSendResponse(var92, var93);
                return;
            case 5003:
                boolean var94 = PacketUtils.readBoolean(packet);
                gameManager.handleFileSendContinue(var94);
                return;
            case 5004:
                String var191 = PacketUtils.readString(packet);
                String var202 = PacketUtils.readString(packet);
                int var212 = PacketUtils.readInt(packet);
                byte var176 = packet.getPayload().readByte();
                gameManager.startDownload(var191, var202, var212, var176);
                return;
            case 5005:
                String var190 = PacketUtils.readString(packet);
                byte[] var175 = PacketUtils.readBytes(packet);
                gameManager.setLoadingState(false);
                gameManager.onFileDownloaded(var190, var175);
                return;
            case 34061:
                String var110 = PacketUtils.readString(packet);
                String var111 = PacketUtils.readString(packet);
                int var112;
                String[] var113 = new String[var112 = PacketUtils.readInt(packet)];
                int[] var114 = new int[var112];
                long[] var115 = new long[var112];
                long[] var116 = new long[var112];
                byte[][] var117 = new byte[var112][];

                for (int var263 = 0; var263 < var112; var263++) {
                    var113[var263] = PacketUtils.readString(packet);
                    var114[var263] = PacketUtils.readInt(packet);
                    var115[var263] = PacketUtils.readLong(packet);
                    var116[var263] = PacketUtils.readLong(packet);
                    var117[var263] = PacketUtils.readBytes(packet);
                }

                CardInfo[] var264 = parseCardInfoArray(packet, var112, var113, 0);
                GameManager.handleGameStart(var110, var111, (byte) var112, var113, var114, var115, var116, var117, var264);
                return;
            case 34081:
                String var123 = PacketUtils.readString(packet);
                String var124 = PacketUtils.readString(packet);
                int var125 = PacketUtils.readInt(packet);
                byte[] var126 = PacketUtils.readBytes(packet);
                int var127 = PacketUtils.readInt(packet);
                String var101 = PacketUtils.readString(packet);
                GameScreen.instance.roomOwner = var101;
                int var128;
                String[] var129 = new String[var128 = PacketUtils.readInt(packet)];
                int[] var130 = new int[var128];
                long[] var131 = new long[var128];
                long[] var132 = new long[var128];
                byte[][] var133 = new byte[var128][];
                boolean[] var134 = new boolean[var128];

                for (byte var135 = 0; var135 < var128; var135 += 1) {
                    var129[var135] = PacketUtils.readString(packet);
                    var130[var135] = PacketUtils.readInt(packet);
                    var131[var135] = PacketUtils.readLong(packet);
                    var132[var135] = PacketUtils.readLong(packet);
                    var133[var135] = PacketUtils.readBytes(packet);
                    var134[var135] = PacketUtils.readBoolean(packet);
                }

                CardInfo[] var262 = parseCardInfoArray(packet, var128, var129, 0);
                GameManager.handleGameUpdate(var123, var124, var125, var126, var127, var129, var130, var131, var132, var133, var134, var262);
                return;
            case 34091:
                String var138 = PacketUtils.readString(packet);
                String var139 = PacketUtils.readString(packet);
                int var140 = PacketUtils.readInt(packet);
                String var141 = PacketUtils.readString(packet);
                GameScreen.instance.roomOwner = var141;
                byte[] var142 = new byte[0];
                int var143;
                String[] var144 = new String[var143 = PacketUtils.readInt(packet)];
                int[] var145 = new int[var143];
                long[] var146 = new long[var143];
                long[] var147 = new long[var143];
                byte[][] var148 = new byte[var143][];
                boolean[] var149 = new boolean[var143];

                for (byte var150 = 0; var150 < var143; var150 += 1) {
                    var144[var150] = PacketUtils.readString(packet);
                    var145[var150] = PacketUtils.readInt(packet);
                    var146[var150] = PacketUtils.readLong(packet);
                    var147[var150] = PacketUtils.readLong(packet);
                    var148[var150] = PacketUtils.readBytes(packet);
                    var149[var150] = PacketUtils.readBoolean(packet);
                }

                CardInfo[] var118 = parseCardInfoArray(packet, var143, var144, 0);
                GameManager.handleGameUpdate(var138, var139, 0, var142, var140, var144, var145, var146, var147, var148, var149, var118);
                return;
            case 5000009:
                StringBuffer scoreBuffer = null;
                BuddyGroupList gameLobbyList = new BuddyGroupList();
                int playerCount;
                BuddyInfo[] playerInfos = new BuddyInfo[playerCount = PacketUtils.readInt(packet)];
                String[] groupNames = new String[playerCount];

                for (int playerIndex = 0; playerIndex < playerCount; playerIndex++) {
                    try {
                        groupNames[playerIndex] = PacketUtils.readString(packet);
                    } catch (Exception readException) {
                        groupNames[playerIndex] = "";
                    }

                    String playerUsername = PacketUtils.readString(packet);
                    String playerDisplayName = PacketUtils.readString(packet);
                    int currentScore = PacketUtils.readInt(packet);
                    int maxScore = PacketUtils.readInt(packet);
                    if (scoreBuffer == null) {
                        scoreBuffer = new StringBuffer(0);
                    } else {
                        scoreBuffer.delete(0, scoreBuffer.length());
                    }

                    scoreBuffer.append(currentScore);
                    scoreBuffer.append("/");
                    scoreBuffer.append(maxScore);
                    byte playerStatus;
                    int scorePercentage;
                    if ((scorePercentage = currentScore * 100 / maxScore) < 30) {
                        playerStatus = 2;
                    } else if (scorePercentage < 80) {
                        playerStatus = 3;
                    } else {
                        playerStatus = 4;
                    }

                    playerInfos[playerIndex] = new BuddyInfo(playerUsername, playerDisplayName, playerStatus, null, null, -1, playerIndex, scoreBuffer.toString());
                    gameLobbyList.addContactToGroup(groupNames[playerIndex], playerInfos[playerIndex]);
                }

                System.gc();
                GameManager.instance.setLoadingState(false);
                gameManager.showGameLobby(gameLobbyList);
                return;
            case 5000011:
                String var95 = PacketUtils.readString(packet);
                String var96 = PacketUtils.readString(packet);
                int var97;
                GameRoom[] var98 = new GameRoom[var97 = PacketUtils.readInt(packet)];

                for (int var99 = 0; var99 < var97; var99++) {
                    var98[var99] = new GameRoom();
                    var98[var99].roomId = PacketUtils.readString(packet);
                    var98[var99].roomStatus = packet.getPayload().readByte();
                    GameRoom var10000 = var98[var99];
                    long var162 = PacketUtils.readLong(packet);
                    var10000.roomName = UIUtils.concatStrings(UIUtils.formatNumberWithDots(var162), " $", null, null);
                    var98[var99].setPlayerCount((byte) PacketUtils.readInt(packet));
                }

                GameManager.instance.setLoadingState(false);
                gameManager.startCardGame(var95, var98, 0, var96);
                return;
            case 5000015:
                long accountId = PacketUtils.readLong(packet);
                int friendIdSize = PacketUtils.readInt(packet);
                long[] listFriendAccountId = null;
                if (friendIdSize > 0) {
                    listFriendAccountId = new long[friendIdSize];

                    for (int var210 = 0; var210 < friendIdSize; var210++) {
                        listFriendAccountId[var210] = PacketUtils.readLong(packet);
                    }
                }

                int var211 = -1;

                try {
                    var211 = PacketUtils.readInt(packet);
                } catch (Exception var170) {
                }

                gameManager.updateUserProfile(accountId, listFriendAccountId, var211);
                return;
            case 5000016:
                long var228 = PacketUtils.readLong(packet);
                gameManager.receiveBuzz(var228);
                return;
            case 5000018:
                int friendIdRequestSize = PacketUtils.readInt(packet);
                long[] var200 = null;
                String[] var209 = null;
                if (friendIdRequestSize > 0) {
                    var200 = new long[friendIdRequestSize];
                    var209 = new String[friendIdRequestSize];

                    for (int var218 = 0; var218 < friendIdRequestSize; var218++) {
                        var200[var218] = PacketUtils.readLong(packet);
                        var209[var218] = PacketUtils.readString(packet);
                    }
                }

                gameManager.handleFriendRequests(var200, var209);
                return;
            case 5000019:
                gameManager.blockUser(PacketUtils.readLong(packet), PacketUtils.readInt(packet));
                return;
            case 5000021:
                int var217 = PacketUtils.readInt(packet);
                long[] var186 = null;
                if (var217 > 0) {
                    var186 = new long[var217];

                    for (int var223 = 0; var223 < var217; var223++) {
                        var186[var223] = PacketUtils.readLong(packet);
                    }
                }

                gameManager.setBlockedUsers(var186);
                return;
            case 5000022:
                long var26 = PacketUtils.readLong(packet);
                String var174 = PacketUtils.readString(packet);
                gameManager.storeUserAndProcessInvite(var26, var174);
                return;
            case 5000023:
                long var40 = PacketUtils.readLong(packet);
                String var173 = PacketUtils.readString(packet);
                gameManager.receiveMessage(var40, var173);
                return;
            case 5000024:
                gameManager.removeFriend(PacketUtils.readLong(packet), PacketUtils.readInt(packet));
                return;
            case 5000026:
                if (PacketUtils.readBoolean(packet)) {
                    long var229 = PacketUtils.readLong(packet);
                    String var185 = PacketUtils.readString(packet);
                    var3 = PacketUtils.readInt(packet);
                    int var208 = PacketUtils.readInt(packet);
                    gameManager.handleFriendAccepted(var229, var185, var3, var208);
                    return;
                }
                break;
            case 5000028:
                int listFriendsSzie= PacketUtils.readInt(packet);
                BuddyInfo[] var224 = new BuddyInfo[listFriendsSzie ];
                BuddyGroupList var32 = new BuddyGroupList();

                for (int i = 0; i < listFriendsSzie; i++) {
                    long var226 = PacketUtils.readLong(packet);
                    String var207 = PacketUtils.readString(packet);
                    String var227 = PacketUtils.readString(packet);
                    var224[i] = new BuddyInfo(var207, "", 0, var227, new int[0], 0, i, null);
                    var224[i].contactId = var226;
                    if (FriendScreen.currentViewMode == 1) {
                        var32.addContactToGroup("Bạn Bè", var224[i]);
                    } else if (FriendScreen.currentViewMode == 2) {
                        var32.addContactToGroup("Danh sách từ chối", var224[i]);
                    } else {
                        var32.addContactToGroup("Danh sách kết bạn", var224[i]);
                    }
                }

                if (FriendScreen.currentViewMode == 1) {
                    gameManager.loadContactData(var32);
                    return;
                }

                if (FriendScreen.currentViewMode == 2) {
                    gameManager.loadSecondaryContactsMode2(var32);
                    return;
                }

                gameManager.loadSecondaryContactsMode3(var32);
                return;
            case 5000029:
                if ((var3 = PacketUtils.readInt(packet)) > 0) {
                    long[] var225 = new long[var3];
                    String[] var35 = new String[var3];

                    for (int var206 = 0; var206 < var3; var206++) {
                        var225[var206] = PacketUtils.readLong(packet);
                        var35[var206] = PacketUtils.readString(packet);
                    }

                    gameManager.updateContactsStatus(var225, var35);
                    return;
                }
                break;
            case 5000031:
                long var34 = PacketUtils.readLong(packet);
                byte var205 = packet.getPayload().readByte();
                gameManager.handleUserStatusChange(var34, var205);
                return;
            case 5000032:
                int var44;
                if ((var44 = PacketUtils.readInt(packet)) != 0) {
                    Vector var45 = new Vector();
                    BuddyGroupList var183 = new BuddyGroupList();

                    for (int var196 = 0; var196 < var44; var196++) {
                        String var4 = PacketUtils.readString(packet);
                        String var5;
                        String[] var50 = FontRenderer.wrapTextToLines(var5 = PacketUtils.readString(packet), Screen.screenWidth - 30);
                        String var51 = PacketUtils.readString(packet);
                        long var52 = PacketUtils.readLong(packet);
                        if (!var45.contains(var4)) {
                            BuddyInfo var6;
                            (var6 = new BuddyInfo(var4, "", 0, var50[0] + (var50.length > 1 ? ".." : ""), new int[0], 0, 0, null)).contactId = var52;
                            var183.addContactToGroup("", var6);
                            var45.addElement(var4);
                        }

                        gameManager.addOfflineMessage(var4, UIUtils.concatStrings(var5, " (", var51, ")"));
                    }

                    gameManager.showOfflineMessages(var183);
                    return;
                }
                break;
            case 5000033:
                GameManager.firstRun = PacketUtils.readBoolean(packet);
                return;
            case 5000034:
                int var77 = PacketUtils.readInt(packet);

                for (int var78 = 0; var78 < var77; var78++) {
                    int var79 = PacketUtils.readInt(packet);
                    String var80 = PacketUtils.readString(packet);
                    byte[] var81 = PacketUtils.readBytes(packet);
                    int var82 = PacketUtils.readInt(packet);
                    int var83 = PacketUtils.readInt(packet);
                    String var84 = PacketUtils.readString(packet);
                    gameManager.addNotification(var79, var80, var81, var83, var82, var84);
                }

                return;
            case 5000035:
                long var37 = PacketUtils.readLong(packet);
                String var172 = PacketUtils.readString(packet);
                gameManager.updateUserStatusMessage(var37, var172);
                return;
            case 5000036:
                gameManager.setEmptyContactMessage(PacketUtils.readString(packet));
                return;
            case 5000038:
                GameManager.instance.isLoading = false;
                if (PacketUtils.readBoolean(packet)) {
                    String var182 = PacketUtils.readString(packet);
                    long var31 = PacketUtils.readLong(packet);
                    gameManager.openChatWithUser(var31, var182);
                    return;
                }

                GameManager.instance.showWrappedTextDialog(PacketUtils.readString(packet));
                return;
            case 5000040:
                UIUtils.clearRecordStores(true);
                return;
            case 6000000:
                PacketSender.requestSendDataUIComponent(Xuka.refCode);
                return;
            case 11712001:
                GameManager.instance.setLoadingState(false);
                gameManager.showAppInfo(PacketUtils.readString(packet));
                return;
            case 11712002:
                GameManager.instance.setLoadingState(false);
                GameManager.makePhoneCall(PacketUtils.readString(packet));
        }
    }

    private static CardInfo[] parseCardInfoArray(Packet var0, int var1, String[] var2, int var3) {
        byte[] var13 = new byte[var1];
        int[] var4 = new int[var1];
        String[] var5 = new String[var1];
        String[] var6 = new String[var1];
        Integer[] var7 = new Integer[var1];
        Integer[] var8 = new Integer[var1];
        String[] var9 = new String[var1];
        CardInfo[] var10 = new CardInfo[var1];

        for (int var11 = 0; var11 < var1; var11++) {
            var13[var11] = var0.getPayload().readByte();
            var4[var11] = PacketUtils.readInt(var0);
            var5[var11] = PacketUtils.readString(var0);
            var6[var11] = PacketUtils.readString(var0);
            var7[var11] = new Integer(PacketUtils.readInt(var0));
            var8[var11] = new Integer(PacketUtils.readInt(var0));
            var9[var11] = PacketUtils.readString(var0);
            var10[var11] = new CardInfo(var13[var11], var4[var11], var5[var11], var7[var11], var8[1], var9[var11]);
            gameManager.setResource(var2[var11], var10[var11], 0);
        }

        return var10;
    }

    private static void showErrorNotification(Packet var0) {
        String var1 = PacketUtils.readString(var0);
        GameManager.instance.showNotification(var1, (Image) null, 1);
    }
}
