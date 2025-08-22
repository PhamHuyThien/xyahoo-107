import javax.microedition.lcdui.Image;
import java.util.Vector;

public final class GamePacketHandler extends PacketHandler {
   public static GameManager gameManager;
   private static GamePacketHandler instance = null;
   private static String serverMessage;

   private GamePacketHandler() {
   }

   public static GamePacketHandler getInstance() {
      if (instance == null) {
         instance = new GamePacketHandler();
      }

      return instance;
   }

   public final void onConnectionError() {
      gameManager.onConnectionError();
   }

   public final void onConnectionLost() {
      gameManager.onConnectionLost();
   }

   public final void resetConnectionFlag() {
      GameManager.resetConnectionFlag();
   }

   public final void handlePacket(Packet var1, int var2) {
      int var3 = var1.getTypeId();
      switch (var2) {
         case -5:
            GameManager.doNothing();
            return;
         case -3:
            gameManager.onRegisterFailed();
            return;
         case -2:
            gameManager.onRegisterSuccess();
            return;
         case -1:
            gameManager.onLoginFailed();
            return;
         case 2:
            int var240;
            String[] var241 = new String[var240 = PacketUtils.readInt(var1)];
            int[] var242 = new int[var240];
            System.out.println("IPs:");

            for (int var244 = 0; var244 < var240; var244++) {
               var241[var244] = PacketUtils.readString(var1);
               System.out.println(var241[var244]);
               var242[var244] = PacketUtils.readInt(var1);
               System.out.println(var242[var244]);
            }

            GameManager.a(var241, var242);
            return;
         case 3:
            long var285 = PacketUtils.readLong(var1);
            byte var158;
            int[] var159 = new int[var158 = var1.getPayload().readByte()];

            for (byte var160 = 0; var160 < var158; var160 += 1) {
               var159[var160] = PacketUtils.readInt(var1);
            }

            gameManager.a(var285, var159);
            return;
         case 39:
            String var236 = PacketUtils.readString(var1);
            int var237;
            if ((var237 = PacketUtils.readInt(var1)) == 0) {
               gameManager.a(0, var236, null, 180, 2, null);
               return;
            }

            if (var237 == 1) {
               gameManager.h(var236);
               return;
            }
            break;
         case 44:
            serverMessage = PacketUtils.readString(var1);
            return;
         case 45:
            String var238 = PacketUtils.readString(var1);
            String var75 = PacketUtils.readString(var1);
            String var76 = PacketUtils.readString(var1);
            gameManager.b(var76, var238, var75);
            return;
         case 64:
            boolean var239 = PacketUtils.readBoolean(var1);
            gameManager.b(var239);
            return;
         case 113:
            int var243;
            TextValidator.BANNED_WORDS = new String[var243 = PacketUtils.readInt(var1)];

            for (int var246 = 0; var246 < var243; var246++) {
               TextValidator.BANNED_WORDS[var246] = PacketUtils.readString(var1);
            }

            return;
         case 120:
            Integer var89 = new Integer(PacketUtils.readInt(var1));
            byte[] var90 = PacketUtils.readBytes(var1);
            GameManager.a(var89, var90);
            return;
         case 121:
            System.gc();
            byte[] var245 = PacketUtils.readBytes(var1);
            gameManager.b(var245);
            return;
         case 122:
            int var247 = PacketUtils.readInt(var1);
            int var85 = PacketUtils.readInt(var1);
            gameManager.b(var247, var85);
            return;
         case 123:
            System.gc();
            int var86 = PacketUtils.readInt(var1);
            int var87 = PacketUtils.readInt(var1);
            byte[] var88 = PacketUtils.readBytes(var1);
            gameManager.a(var86, var87, var88);
            return;
         case 269:
            String var232 = PacketUtils.readString(var1);
            String var233 = PacketUtils.readString(var1);
            GameManager.instance.c(false);
            gameManager.b(var232, var233);
            return;
         case 500:
            int var234 = PacketUtils.readInt(var1);
            String var235 = PacketUtils.readString(var1);
            gameManager.a(var234, var235);
            return;
         case 1009:
            String var284 = PacketUtils.readString(var1);
            gameManager.showAddFriendDialog(var284, 0L, false);
            return;
         case 1029:
            String var283 = PacketUtils.readString(var1);
            gameManager.onAddFriendError(var283);
            return;
         case 3403:
            String var248 = PacketUtils.readString(var1);
            boolean var100 = PacketUtils.readBoolean(var1);
            Object var249 = null;
            long var251 = 0L;
            if (var100) {
               if (GameScreen.isInGame && !GameScreen.currentRoomId.equals(var248)) {
                  return;
               }

               PacketUtils.readString(var1);
               var249 = PacketUtils.readString(var1);
               var251 = PacketUtils.readLong(var1);
               int var253;
               String[] var254 = new String[var253 = PacketUtils.readInt(var1)];
               long[] var255 = new long[var253];
               int[] var257 = new int[var253];
               boolean[] var109 = new boolean[var253];

               for (int var258 = 0; var258 < var253; var258++) {
                  var254[var258] = PacketUtils.readString(var1);
                  var109[var258] = PacketUtils.readBoolean(var1);
                  var255[var258] = PacketUtils.readLong(var1);
                  var257[var258] = PacketUtils.readInt(var1);
                  if (var257[var258] != -1) {
                     var257[var258] = (short)var257[var258];
                  }
               }

               GameScreen.instance.isGoldGame = PacketUtils.readBoolean(var1);
               GameScreen var287 = GameScreen.instance;
               String var288 = PacketUtils.readString(var1);
               String var290 = PacketUtils.readString(var1);
               UIUtils.setScreenSubtitleText(var287, UIUtils.concatStrings(var288, " - ", var290, null));
               gameManager.a(var248, var251, var254, var255, var257, var109, (String)var249);
            } else {
               showErrorNotification(var1);
            }

            GameManager.instance.c(false);
            return;
         case 3405:
            String var104 = PacketUtils.readString(var1);
            int var105;
            String[] var106 = new String[var105 = PacketUtils.readInt(var1)];
            boolean[] var107 = new boolean[var105];

            for (int var256 = 0; var256 < var105; var256++) {
               var106[var256] = PacketUtils.readString(var1);
               var107[var256] = PacketUtils.readBoolean(var1);
            }

            GameManager.a(var104, var106, var107);
            return;
         case 3406:
            String var108 = PacketUtils.readString(var1);
            if (PacketUtils.readBoolean(var1)) {
               PacketUtils.readString(var1);
               byte[] var259 = PacketUtils.readBytes(var1);
               String var260 = PacketUtils.readString(var1);
               boolean var261 = PacketUtils.readBoolean(var1);
               PacketUtils.readLong(var1);
               long var102 = 0L;
               GameManager.a(var108, var259, var260, var261);
               return;
            }

            showErrorNotification(var1);
            return;
         case 3407:
            String var119 = PacketUtils.readString(var1);
            if (PacketUtils.readBoolean(var1)) {
               String var265 = PacketUtils.readString(var1);
               String var122 = PacketUtils.readString(var1);
               boolean var268 = PacketUtils.readBoolean(var1);
               if (PacketUtils.readBoolean(var1)) {
                  PacketUtils.readString(var1);
                  PacketUtils.readString(var1);
                  PacketUtils.readLong(var1);
               }

               GameManager.a(var119, var265, var122, var268);
               return;
            }
            break;
         case 3408:
            String var121 = PacketUtils.readString(var1);
            if (PacketUtils.readBoolean(var1)) {
               String var267 = PacketUtils.readString(var1);
               int var269 = PacketUtils.readInt(var1);
               byte[] var270 = PacketUtils.readBytes(var1);
               String var271 = PacketUtils.readString(var1);
               boolean var272 = PacketUtils.readBoolean(var1);
               if (PacketUtils.readBoolean(var1)) {
                  int var273 = PacketUtils.readInt(var1);
                  gameManager.a(var121, var267, var269, var270, var271, var272, var273);
                  return;
               }

               gameManager.a(var121, var267, var269, var270, var271, var272);
               return;
            }

            String var266 = PacketUtils.readString(var1);
            GameManager.getInstance().showNotification(var266, (Image) null, 1);
            PacketUtils.readInt(var1);
            PacketUtils.readBytes(var1);
            if (GameScreen.currentRoomId.equals(var121)) {
               GameManager.J();
               return;
            }
            break;
         case 3409:
            String var274 = PacketUtils.readString(var1);
            if (PacketUtils.readBoolean(var1)) {
               String var275 = PacketUtils.readString(var1);
               if (PacketUtils.readBoolean(var1)) {
                  String var277 = PacketUtils.readString(var1);
                  boolean var279 = PacketUtils.readBoolean(var1);
                  PacketUtils.readBytes(var1);
                  if (PacketUtils.readBoolean(var1)) {
                     PacketUtils.readString(var1);
                     PacketUtils.readString(var1);
                     PacketUtils.readLong(var1);
                  }

                  GameManager.b(var274, var275, var277, var279);
                  return;
               }

               String var137 = PacketUtils.readString(var1);
               int var276;
               String[] var278 = new String[var276 = PacketUtils.readInt(var1)];

               for (byte var280 = 0; var280 < var276; var280 += 1) {
                  var278[var280] = PacketUtils.readString(var1);
               }

               String var281 = PacketUtils.readString(var1);
               gameManager.a(var274, var275, var137, var278, var281);
               return;
            }
            break;
         case 3410:
            PacketUtils.readString(var1);
            if (!PacketUtils.readBoolean(var1)) {
               showErrorNotification(var1);
               return;
            }

            PacketUtils.readString(var1);
            long var289 = PacketUtils.readLong(var1);
            if (var3 != 39) {
               return;
            }

            GameScreen.instance.setBetAmount(var289);
            break;
         case 3411:
            String var164 = PacketUtils.readString(var1);
            String var165 = PacketUtils.readString(var1);
            String var166 = PacketUtils.readString(var1);
            GameManager.a(var164, var165, var166, var3);
            break;
         case 3412:
            String var152 = PacketUtils.readString(var1);
            if (!PacketUtils.readBoolean(var1)) {
               showErrorNotification(var1);
               return;
            }

            String var154 = PacketUtils.readString(var1);
            int var155;
            String[] var156 = new String[var155 = PacketUtils.readInt(var1)];

            for (byte var157 = 0; var157 < var155; var157 += 1) {
               var156[var157] = PacketUtils.readString(var1);
            }

            String var286 = PacketUtils.readString(var1);
            gameManager.a(var152, var154, GameScreen.instance.roomOwner, var156, var286);
            return;
         case 3416:
            PacketUtils.readString(var1);
            long var282 = PacketUtils.readLong(var1);
            PacketUtils.readLong(var1);
            gameManager.b(var282);
            return;
         case 3417:
            showErrorNotification(var1);
            return;
         case 3418:
            String var195 = PacketUtils.readString(var1);
            byte var204 = var1.getPayload().readByte();
            int var216 = PacketUtils.readInt(var1);
            String var221 = PacketUtils.readString(var1);
            Integer var222 = new Integer(PacketUtils.readInt(var1));
            Integer var7 = new Integer(PacketUtils.readInt(var1));
            String var181 = PacketUtils.readString(var1);
            gameManager.setResource(var195, new CardInfo(var204, var216, var221, var222, var7, var181), 0);
            return;
         case 4801:
            if (PacketUtils.readBoolean(var1)) {
               String var215 = UIUtils.concatStrings("P. ", PacketUtils.readString(var1), null, null);
               String var220 = PacketUtils.readString(var1);
               long var230 = PacketUtils.readLong(var1);
               PacketUtils.readLong(var1);
               PacketUtils.readString(var1);
               gameManager.a(var215, var220, var230);
               return;
            }

            showErrorNotification(var1);
            return;
         case 4802:
            showErrorNotification(var1);
            return;
         case 4803:
            String var214 = UIUtils.concatStrings("P. ", PacketUtils.readString(var1), null, null);
            Screen var219;
            if ((var219 = GameManager.instance.setActiveScreen(var214)) != null) {
               GameManager.instance.currentChatRoom = null;
               GameManager.instance.removeScreen(var219);
            }

            showErrorNotification(var1);
            return;
         case 4804:
            PacketUtils.readLong(var1);
            String var231 = PacketUtils.readString(var1);
            String var53 = PacketUtils.readString(var1);
            PacketUtils.readInt(var1);
            int var180 = PacketUtils.readInt(var1);
            gameManager.b(var231, var53, var180);
            return;
         case 4807:
            String var194 = PacketUtils.readString(var1);
            String var203 = UIUtils.concatStrings("P. ", PacketUtils.readString(var1), null, null);
            String var213 = PacketUtils.readString(var1);
            String var179 = PacketUtils.readString(var1);
            gameManager.a(var194, var203, var213, var179);
            return;
         case 4809:
            showErrorNotification(var1);
            return;
         case 4813:
            String var192 = UIUtils.concatStrings("P. ", PacketUtils.readString(var1), null, null);
            String var178 = UIUtils.concatStrings("P. ", PacketUtils.readString(var1), null, null);
            Screen var193;
            if ((var193 = GameManager.instance.setActiveScreen(var192)) != null) {
               var193.title = var178;
               UIUtils.setScreenSubtitleText(var193, var178);
               GameManager.instance.currentChatRoom = var178;
               return;
            }
            break;
         case 5001:
            byte var91 = var1.getPayload().readByte();
            byte var177 = var1.getPayload().readByte();
            gameManager.a(var91, var177);
            return;
         case 5002:
            String var92 = PacketUtils.readString(var1);
            int var93 = PacketUtils.readInt(var1);
            gameManager.c(var92, var93);
            return;
         case 5003:
            boolean var94 = PacketUtils.readBoolean(var1);
            gameManager.d(var94);
            return;
         case 5004:
            String var191 = PacketUtils.readString(var1);
            String var202 = PacketUtils.readString(var1);
            int var212 = PacketUtils.readInt(var1);
            byte var176 = var1.getPayload().readByte();
            gameManager.a(var191, var202, var212, var176);
            return;
         case 5005:
            String var190 = PacketUtils.readString(var1);
            byte[] var175 = PacketUtils.readBytes(var1);
            gameManager.c(false);
            gameManager.onFileDownloaded(var190, var175);
            return;
         case 34061:
            String var110 = PacketUtils.readString(var1);
            String var111 = PacketUtils.readString(var1);
            int var112;
            String[] var113 = new String[var112 = PacketUtils.readInt(var1)];
            int[] var114 = new int[var112];
            long[] var115 = new long[var112];
            long[] var116 = new long[var112];
            byte[][] var117 = new byte[var112][];

            for (int var263 = 0; var263 < var112; var263++) {
               var113[var263] = PacketUtils.readString(var1);
               var114[var263] = PacketUtils.readInt(var1);
               var115[var263] = PacketUtils.readLong(var1);
               var116[var263] = PacketUtils.readLong(var1);
               var117[var263] = PacketUtils.readBytes(var1);
            }

            CardInfo[] var264 = parseCardInfoArray(var1, var112, var113, 0);
            GameManager.a(var110, var111, (byte)var112, var113, var114, var115, var116, var117, var264);
            return;
         case 34081:
            String var123 = PacketUtils.readString(var1);
            String var124 = PacketUtils.readString(var1);
            int var125 = PacketUtils.readInt(var1);
            byte[] var126 = PacketUtils.readBytes(var1);
            int var127 = PacketUtils.readInt(var1);
            String var101 = PacketUtils.readString(var1);
            GameScreen.instance.roomOwner = var101;
            int var128;
            String[] var129 = new String[var128 = PacketUtils.readInt(var1)];
            int[] var130 = new int[var128];
            long[] var131 = new long[var128];
            long[] var132 = new long[var128];
            byte[][] var133 = new byte[var128][];
            boolean[] var134 = new boolean[var128];

            for (byte var135 = 0; var135 < var128; var135 += 1) {
               var129[var135] = PacketUtils.readString(var1);
               var130[var135] = PacketUtils.readInt(var1);
               var131[var135] = PacketUtils.readLong(var1);
               var132[var135] = PacketUtils.readLong(var1);
               var133[var135] = PacketUtils.readBytes(var1);
               var134[var135] = PacketUtils.readBoolean(var1);
            }

            CardInfo[] var262 = parseCardInfoArray(var1, var128, var129, 0);
            GameManager.a(var123, var124, var125, var126, var127, var129, var130, var131, var132, var133, var134, var262);
            return;
         case 34091:
            String var138 = PacketUtils.readString(var1);
            String var139 = PacketUtils.readString(var1);
            int var140 = PacketUtils.readInt(var1);
            String var141 = PacketUtils.readString(var1);
            GameScreen.instance.roomOwner = var141;
            byte[] var142 = new byte[0];
            int var143;
            String[] var144 = new String[var143 = PacketUtils.readInt(var1)];
            int[] var145 = new int[var143];
            long[] var146 = new long[var143];
            long[] var147 = new long[var143];
            byte[][] var148 = new byte[var143][];
            boolean[] var149 = new boolean[var143];

            for (byte var150 = 0; var150 < var143; var150 += 1) {
               var144[var150] = PacketUtils.readString(var1);
               var145[var150] = PacketUtils.readInt(var1);
               var146[var150] = PacketUtils.readLong(var1);
               var147[var150] = PacketUtils.readLong(var1);
               var148[var150] = PacketUtils.readBytes(var1);
               var149[var150] = PacketUtils.readBoolean(var1);
            }

            CardInfo[] var118 = parseCardInfoArray(var1, var143, var144, 0);
            GameManager.a(var138, var139, 0, var142, var140, var144, var145, var146, var147, var148, var149, var118);
            return;
         case 5000009:
            StringBuffer var189 = null;
            DownloadDataManager var64 = new DownloadDataManager();
            int var65;
            DownloadData[] var66 = new DownloadData[var65 = PacketUtils.readInt(var1)];
            String[] var67 = new String[var65];

            for (int var68 = 0; var68 < var65; var68++) {
               try {
                  var67[var68] = PacketUtils.readString(var1);
               } catch (Exception var171) {
                  var67[var68] = "";
               }

               String var69 = PacketUtils.readString(var1);
               String var70 = PacketUtils.readString(var1);
               int var72 = PacketUtils.readInt(var1);
               int var73 = PacketUtils.readInt(var1);
               if (var189 == null) {
                  var189 = new StringBuffer(0);
               } else {
                  var189.delete(0, var189.length());
               }

               var189.append(var72);
               var189.append("/");
               var189.append(var73);
               byte var71;
               int var74;
               if ((var74 = var72 * 100 / var73) < 30) {
                  var71 = 2;
               } else if (var74 < 80) {
                  var71 = 3;
               } else {
                  var71 = 4;
               }

               var66[var68] = new DownloadData(var69, var70, var71, null, null, -1, var68, var189.toString());
               var64.addDownloadToCategory(var67[var68], var66[var68]);
            }

            System.gc();
            GameManager.instance.c(false);
            gameManager.showGameLobby(var64);
            return;
         case 5000011:
            String var95 = PacketUtils.readString(var1);
            String var96 = PacketUtils.readString(var1);
            int var97;
            GameRoom[] var98 = new GameRoom[var97 = PacketUtils.readInt(var1)];

            for (int var99 = 0; var99 < var97; var99++) {
               var98[var99] = new GameRoom();
               var98[var99].roomId = PacketUtils.readString(var1);
               var98[var99].roomStatus = var1.getPayload().readByte();
               GameRoom var10000 = var98[var99];
               long var162 = PacketUtils.readLong(var1);
               var10000.roomName = UIUtils.concatStrings(UIUtils.formatNumberWithDots(var162), " $", null, null);
               var98[var99].setPlayerCount((byte) PacketUtils.readInt(var1));
            }

            GameManager.instance.c(false);
            gameManager.startCardGame(var95, var98, 0, var96);
            return;
         case 5000015:
            long var16 = PacketUtils.readLong(var1);
            var2 = PacketUtils.readInt(var1);
            long[] var201 = null;
            if (var2 > 0) {
               var201 = new long[var2];

               for (int var210 = 0; var210 < var2; var210++) {
                  var201[var210] = PacketUtils.readLong(var1);
               }
            }

            int var211 = -1;

            try {
               var211 = PacketUtils.readInt(var1);
            } catch (Exception var170) {
            }

            gameManager.a(var16, var201, var211);
            return;
         case 5000016:
            long var228 = PacketUtils.readLong(var1);
            gameManager.receiveBuzz(var228);
            return;
         case 5000018:
            var2 = PacketUtils.readInt(var1);
            long[] var200 = null;
            String[] var209 = null;
            if (var2 > 0) {
               var200 = new long[var2];
               var209 = new String[var2];

               for (int var218 = 0; var218 < var2; var218++) {
                  var200[var218] = PacketUtils.readLong(var1);
                  var209[var218] = PacketUtils.readString(var1);
               }
            }

            gameManager.a(var200, var209);
            return;
         case 5000019:
            gameManager.b(PacketUtils.readLong(var1), PacketUtils.readInt(var1));
            return;
         case 5000021:
            int var217 = PacketUtils.readInt(var1);
            long[] var186 = null;
            if (var217 > 0) {
               var186 = new long[var217];

               for (int var223 = 0; var223 < var217; var223++) {
                  var186[var223] = PacketUtils.readLong(var1);
               }
            }

            gameManager.a(var186);
            return;
         case 5000022:
            long var26 = PacketUtils.readLong(var1);
            String var174 = PacketUtils.readString(var1);
            gameManager.a(var26, var174);
            return;
         case 5000023:
            long var40 = PacketUtils.readLong(var1);
            String var173 = PacketUtils.readString(var1);
            gameManager.c(var40, var173);
            return;
         case 5000024:
            gameManager.a(PacketUtils.readLong(var1), PacketUtils.readInt(var1));
            return;
         case 5000026:
            if (PacketUtils.readBoolean(var1)) {
               long var229 = PacketUtils.readLong(var1);
               String var185 = PacketUtils.readString(var1);
               var3 = PacketUtils.readInt(var1);
               int var208 = PacketUtils.readInt(var1);
               gameManager.a(var229, var185, var3, var208);
               return;
            }
            break;
         case 5000028:
            DownloadData[] var224 = new DownloadData[var2 = PacketUtils.readInt(var1)];
            DownloadDataManager var32 = new DownloadDataManager();

            for (int var198 = 0; var198 < var2; var198++) {
               long var226 = PacketUtils.readLong(var1);
               String var207 = PacketUtils.readString(var1);
               String var227 = PacketUtils.readString(var1);
               var224[var198] = new DownloadData(var207, "", 0, var227, new int[0], 0, var198, null);
               var224[var198].timestamp = var226;
               if (FriendScreen.currentViewMode == 1) {
                  var32.addDownloadToCategory("Ban Be", var224[var198]);
               } else if (FriendScreen.currentViewMode == 2) {
                  var32.addDownloadToCategory("Danh sách từ chối", var224[var198]);
               } else {
                  var32.addDownloadToCategory("Danh sách kết bạn", var224[var198]);
               }
            }

            if (FriendScreen.currentViewMode == 1) {
               gameManager.c(var32);
               return;
            }

            if (FriendScreen.currentViewMode == 2) {
               gameManager.e(var32);
               return;
            }

            gameManager.d(var32);
            return;
         case 5000029:
            if ((var3 = PacketUtils.readInt(var1)) > 0) {
               long[] var225 = new long[var3];
               String[] var35 = new String[var3];

               for (int var206 = 0; var206 < var3; var206++) {
                  var225[var206] = PacketUtils.readLong(var1);
                  var35[var206] = PacketUtils.readString(var1);
               }

               gameManager.b(var225, var35);
               return;
            }
            break;
         case 5000031:
            long var34 = PacketUtils.readLong(var1);
            byte var205 = var1.getPayload().readByte();
            gameManager.c(var34, var205);
            return;
         case 5000032:
            int var44;
            if ((var44 = PacketUtils.readInt(var1)) != 0) {
               Vector var45 = new Vector();
               DownloadDataManager var183 = new DownloadDataManager();

               for (int var196 = 0; var196 < var44; var196++) {
                  String var4 = PacketUtils.readString(var1);
                  String var5;
                  String[] var50 = FontRenderer.wrapTextToLines(var5 = PacketUtils.readString(var1), Screen.screenWidth - 30);
                  String var51 = PacketUtils.readString(var1);
                  long var52 = PacketUtils.readLong(var1);
                  if (!var45.contains(var4)) {
                     DownloadData var6;
                     (var6 = new DownloadData(var4, "", 0, var50[0] + (var50.length > 1 ? ".." : ""), new int[0], 0, 0, null)).timestamp = var52;
                     var183.addDownloadToCategory("", var6);
                     var45.addElement(var4);
                  }

                  gameManager.c(var4, UIUtils.concatStrings(var5, " (", var51, ")"));
               }

               gameManager.f(var183);
               return;
            }
            break;
         case 5000033:
            GameManager.firstRun = PacketUtils.readBoolean(var1);
            return;
         case 5000034:
            int var77 = PacketUtils.readInt(var1);

            for (int var78 = 0; var78 < var77; var78++) {
               int var79 = PacketUtils.readInt(var1);
               String var80 = PacketUtils.readString(var1);
               byte[] var81 = PacketUtils.readBytes(var1);
               int var82 = PacketUtils.readInt(var1);
               int var83 = PacketUtils.readInt(var1);
               String var84 = PacketUtils.readString(var1);
               gameManager.a(var79, var80, var81, var83, var82, var84);
            }

            return;
         case 5000035:
            long var37 = PacketUtils.readLong(var1);
            String var172 = PacketUtils.readString(var1);
            gameManager.d(var37, var172);
            return;
         case 5000036:
            gameManager.m(PacketUtils.readString(var1));
            return;
         case 5000038:
            GameManager.instance.isLoading = false;
            if (PacketUtils.readBoolean(var1)) {
               String var182 = PacketUtils.readString(var1);
               long var31 = PacketUtils.readLong(var1);
               gameManager.b(var31, var182);
               return;
            }

            GameManager.instance.d(PacketUtils.readString(var1));
            return;
         case 5000040:
            UIUtils.clearRecordStores(true);
            return;
         case 6000000:
            PacketSender.a(Xuka.refCode);
            return;
         case 11712001:
            GameManager.instance.c(false);
            gameManager.k(PacketUtils.readString(var1));
            return;
         case 11712002:
            GameManager.instance.c(false);
            GameManager.l(PacketUtils.readString(var1));
            return;
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
