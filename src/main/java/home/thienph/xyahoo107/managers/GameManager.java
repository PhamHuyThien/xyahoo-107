package home.thienph.xyahoo107.managers;

import home.thienph.xyahoo107.actions.*;
import home.thienph.xyahoo107.canvas.CameraCanvas;
import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.components.*;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.data.game.*;
import home.thienph.xyahoo107.data.media.BuddyInfo;
import home.thienph.xyahoo107.data.media.BuddyGroup;
import home.thienph.xyahoo107.data.media.BuddyGroupList;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.forms.FileBrowserList;
import home.thienph.xyahoo107.forms.FileSystemInterface;
import home.thienph.xyahoo107.forms.MediaPlayerForm;
import home.thienph.xyahoo107.forms.SaveFileForm;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.processors.GameProcessor;
import home.thienph.xyahoo107.screens.*;
import home.thienph.xyahoo107.tasks.FileOperationTask;
import home.thienph.xyahoo107.tasks.ProcessDataTask;
import home.thienph.xyahoo107.utils.*;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public final class GameManager {
    public static boolean isLocalTest;
    public static String version;
    private Hashtable resourceCache;
    private String smsNumber; // số điện thoại SMS, 95%
    private String smsMessage;
    private static final String defaultString = "";
    public static GameManager instance = new GameManager();
    private Vector notificationQueue; // hàng đợi thông báo, 88%
    private Vector screenStack; //, ngăn xếp màn hình, 95%
    private int itemHeight;
    public static int headerHeight;
    public static int footerHeight;
    private static int marginTop;
    private static int defaultHeight;
    private static final int touchThreshold = 15; // ngưỡng cảm ứng, 80%
    public int frameCounter;
    private int titleBarHeight; // chiều cao thanh tiêu đề, 85%
    private int iconOffset;
    private int animationFrame;
    private int animationCounter = 1;
    private int screenWidth;
    private int screenHeight;
    public Action gameController;
    private int currentScreenIndex;
    public FriendScreen friendScreen;
    public YahooScreen yahooChat;
    public LoginScreen loginScreen;
    private RegistrationScreen registrationScreen;
    private boolean showingDialog;
    private final Vector dialogQueue = new Vector();
    private final int[] notificationStates = new int[3];
    private final String[] notificationTexts = new String[3];
    private final int[] notificationWidths = new int[3];
    private final int[] notificationX = new int[3];
    private final int[] notificationY = new int[3];
    private final int[] notificationHeights = new int[3];
    private final int[] notificationTargetY = new int[3];
    private final int[] notificationSpeeds = new int[3];
    private final Image[] notificationImages = new Image[3];
    private boolean isMenuVisible;
    private Vector menuStack;
    public static String emptyString = "";
    private boolean isInfoVisible;
    private Image infoImage;
    private String[] infoLines;
    private int infoTimer;
    private boolean isEmojiVisible;
    private int emojiSelectedX;
    private int emojiSelectedY;
    private int emojiPanelX;
    private int emojiPanelY;
    private int emojiPanelWidth;
    private int emojiPanelHeight;
    private int emojiTargetY;
    public static boolean soundEnabled = false;
    public static boolean vibrateEnabled = true; //, bật/tắt rung, 98%
    public static boolean autoLogin = true;
    public static boolean autoLoginYahoo = false;
    private static Image loadingAnimation;
    private static Image backgroundBuffer;
    private int titleOffset;
    private int titleX;
    private int menuRightX;
    public static Image gameIcons;
    public static Image headerImage;
    public static Image backgroundImage;
    public static Image dialogBackground;
    public static Image loadingImage;
    public static Image[] statusIcons;
    public static Image[] arrowIcons;
    public static Image chatBackground;
    public static Image gameBackground;
    public static Image cardImage;
    public static Image buttonImage;
    public static Image menuImage;
    public static Image avatarImage;
    public static Image emojiImage;
    public static Image decorationImage; //hình trang trí, 80%
    private static Image splashImage;
    public static Image friendListIcon; //biểu tượng danh sách bạn, 90%
    public static Image roomIcon; //biểu tượng phòng, 90%
    public static Image settingsIcon;
    public boolean isLoading;
    private ButtonAction backButton;
    private ButtonAction selectButton;
    private Action menuHandler;
    private Screen currentScreen;
    private int screenCount;
    private int leftArrowAnim = 0; //, animation mũi tên trái, 85%
    private int rightArrowAnim = 0;
    private boolean isRightAligned; // căn phải, 80%
    private static int menuWidth;
    public static boolean showConnectionStatus;
    private static int connectionTimer; //, bộ đếm kết nối, 85%
    private int notificationTimer; // bo dem thong bao
    private static final byte[] nullByte;
    private int reconnectCount;
    private int timeoutCounter;
    private boolean isTimeout;
    public static String smsContent; //nội dung SMS, 90%
    public static String currentMessage; //tin nhắn hiện tại, 90%
    public static byte loginType;
    public static boolean firstRun; // lần chạy đầu tiên, 95%
    private static ButtonAction closeButton;
    public DialogScreen mainMenu;
    private TextInputComponent inputHandler;
    private ContextMenu mainMenuList;
    private ContextMenu gameMenuList;
    public static boolean isConnected;
    public static ButtonAction helpButton;
    public static ButtonAction infoButton;
    public static ButtonAction forumButton;
    public PhotoViewerScreen fileManager;
    private String currentFileName;
    private int fileBufferSize;
    private boolean isFileSending;
    private int fileSentBytes;
    private int fileProgress;
    private String uploadFileName;
    private byte[] uploadData;
    private byte uploadType;
    private boolean hasDownloaded;
    private DownloadScreen downloadManager;
    public static GameLobbyScreen gameRoom;
    public String currentChatRoom = null; //phòng chat hiện tại, 95%

    static {
        try {
            loadingAnimation = Image.createImage("/Load.png");
        } catch (Exception var0) {
        }

        nullByte = new byte[1];
        firstRun = true;
    }

    private void initResourceCache() {
        if (this.resourceCache == null) {
            this.resourceCache = new Hashtable();
        }
    }

    private BuddyInfo getResource(String var1) {
        this.initResourceCache();
        return (BuddyInfo) this.resourceCache.get(var1);
    }

    public CardInfo getCardInfoResource(String var1, int var2) {
        BuddyInfo var3;
        if ((var3 = this.getResource(var1)) == null) {
            var3 = FriendScreen.instance.findContactById(var1);
        }

        if (var3 != null && var3.cardInfo != null) {
            return var3.cardInfo;
        } else {
            PacketSender.requestSendDataUIComponent(var1, 0);
            return null;
        }
    }

    public void setResource(String var1, CardInfo var2, int var3) {
        CardInfo var5 = var2;
        String var4 = var1;
        if (var3 == 0 && GameScreen.instance != null && GameScreen.instance.playerComponents != null) {
            int var6 = GameScreen.instance.playerComponents.length;

            while (--var6 >= 0) {
                if (GameScreen.instance.playerComponents[var6].playerName.equals(var4)) {
                    GameScreen.instance.playerComponents[var6].setCardInfo(var5);
                }
            }
        }

        BuddyInfo var7;
        if ((var7 = this.getResource(var1)) != null && var3 == 0) {
            var7.cardInfo = var2;
        }

        BuddyInfo var8;
        if ((var8 = FriendScreen.instance.findContactById(var1)) != null) {
            if (var3 == 0) {
                var8.cardInfo = var2;
            }
        } else {
            BuddyInfo var9;
            (var9 = new BuddyInfo()).username = var1;
            if (var3 == 0) {
                var9.cardInfo = var2;
            }

            this.initResourceCache();
            this.resourceCache.put(var9.username, var9);
        }
    }

    public static void showAlert(String var0, String var1, boolean var2) {
        Alert var3;
        (var3 = new Alert(var0)).setString(var1);
        var3.setTimeout(-2);
        Display.getDisplay(Xuka.instance).setCurrent(var3);
    }

    public static void showMainScreen() {
        Display.getDisplay(Xuka.instance).setCurrent(Xuka.gameGraphics);
        Xuka.gameGraphics.setFullScreenMode(true);
    }

    private void addScreen(Screen var1) {
        this.screenStack.addElement(var1);
        this.screenCount = this.screenStack.size();
        UIUtils.setScreenSubtitle(var1, this.screenWidth - 30);
        if (this.screenCount == 1) {
            this.currentScreenIndex = 0;
            this.switchToCurrentScreen();
        }
    }

    private void switchToCurrentScreen() {
        this.currentScreen = (Screen) this.screenStack.elementAt(this.currentScreenIndex);
        if (this.currentScreen.showInNavigation) {
            this.currentScreen.showInNavigation = false;
            this.leftArrowAnim = 0;
            this.rightArrowAnim = 0;
        }

        ScrollBar.isVisible = false;
        this.currentScreen.focusFirstComponent();
        this.updateTitlePosition();
        this.currentScreen.needsUpdate = true;
    }

    public void updateTitlePosition() {
        if (this.currentScreen != null) {
            this.titleX = Screen.screenWidth - FontRenderer.getTextWidth(this.currentScreen.subtitle) >> 1;
        }
    }

    public void addScreenToStack(Screen var1) {
        Screen var3 = var1;
        GameManager var2 = this;
        int var4 = this.screenCount;

        boolean var10000;
        while (true) {
            if (--var4 < 0) {
                var10000 = false;
                break;
            }

            if (((Screen) var2.screenStack.elementAt(var4)).title.equals(var3.title)) {
                var10000 = true;
                break;
            }
        }

        if (!var10000) {
            this.addScreen(var1);
        }
    }

    public void drawLoading(Graphics var1, int var2, int var3) {
        var1.setClip(0, 0, GameGraphics.screenWidth, GameGraphics.screenHeight);
        var1.drawRegion(loadingAnimation, 0, this.frameCounter % 4 == 0 ? this.animationFrame++ * 6 : this.animationFrame * 6, 46, 6, 0, var2, var3, 3);
        this.animationFrame = this.animationFrame > 4 ? 0 : this.animationFrame;
    }

    private void drawEmojiPicker(Graphics var1) {
        if (this.isEmojiVisible) {
            var1.setClip(this.emojiPanelX + 1, this.emojiPanelY + 1, this.emojiPanelWidth - 1, this.emojiPanelHeight - 1);
            int var2 = this.emojiPanelWidth / 50 + 1;

            while (--var2 >= 0) {
                int var3 = this.emojiPanelHeight / 50 + 1;

                while (--var3 >= 0) {
                    var1.drawImage(backgroundImage, this.emojiPanelX + var2 * 50, this.emojiTargetY + var3 * 50, 0);
                }
            }

            var1.setClip(this.emojiPanelX - 1, this.emojiPanelY, this.emojiPanelWidth + 2, this.emojiPanelHeight + 2);
            var1.setColor(14545919);
            ButtonComponent.drawRoundedBorder(var1, this.emojiPanelX, this.emojiTargetY, this.emojiPanelWidth, this.emojiPanelHeight);
            var1.setColor(10278388);
            var1.fillRoundRect(5 + this.emojiPanelX + this.emojiSelectedX * 20, 5 + this.emojiTargetY + this.emojiSelectedY * 20, 20, 20, 5, 5);
            int var5 = 7;

            while (--var5 >= 0) {
                var2 = 6;

                while (--var2 >= 0) {
                    var1.drawRegion(gameIcons, (var5 * 6 + var2) * 18, 0, 18, 18, 0, 5 + this.emojiPanelX + var2 * 20 + 10, 5 + this.emojiTargetY + var5 * 20 + 10, 3);
                }
            }

            var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
            var1.setClip(-1000, -1000, 2000, 2000);
            Screen.renderHeader(var1);
            FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText("Chọn", 4, Screen.softkeyY, var1);
            FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(TextConstant.close(), this.menuRightX, Screen.softkeyY, var1);
        }
    }

    public void showNotification(String var1, Image var2, int var3) {
        if (this.notificationStates[1] == 0 || var3 != 1) {
            this.notificationImages[var3] = var2;
            int var4 = this.notificationImages[var3] != null ? this.notificationImages[var3].getWidth() : 0;
            this.notificationTexts[var3] = var1;
            this.notificationWidths[var3] = FontRenderer.getTextWidth(var1) + 15 + var4;
            this.notificationHeights[var3] = FontRenderer.fontHeight + 6;
            if (this.notificationImages[var3] != null && this.notificationHeights[var3] < this.notificationImages[var3].getHeight() + 6) {
                this.notificationHeights[var3] = this.notificationImages[var3].getHeight() + 6;
            }

            if (this.notificationStates[var3] == 0) {
                this.notificationStates[var3] = 1;
            }

            if (var3 == 0) {
                this.notificationX[var3] = GameGraphics.screenWidth - this.notificationWidths[var3] - 2;
                if (this.notificationStates[var3] > 1) {
                    this.notificationStates[var3] = 1;
                } else {
                    this.notificationTargetY[var3] = this.notificationY[var3] + this.notificationHeights[var3];
                }
            } else if (var3 == 1) {
                this.notificationSpeeds[1] = 2;
                this.notificationX[var3] = GameGraphics.screenWidth;
                this.notificationTargetY[var3] = this.notificationY[var3];
            } else {
                this.notificationX[var3] = GameGraphics.screenWidth - this.notificationWidths[var3] - 2;
                if (this.notificationStates[var3] > 1) {
                    this.notificationStates[var3] = 1;
                } else {
                    this.notificationTargetY[var3] = this.notificationY[var3] - this.notificationHeights[var3] + 1;
                }
            }
        }
    }

    public static void garbageCollect() {
        System.gc();
    }

    public void vibrate() {
        if (vibrateEnabled) {
            Display.getDisplay(Xuka.instance).vibrate(500);
        }
    }

    public void showEmojiPicker(int var1) {
        if (!this.showingDialog) {
            this.emojiPanelWidth = 129;
            this.emojiPanelHeight = 149;
            this.emojiPanelX = 2;
            this.emojiPanelY = this.screenHeight - footerHeight - this.emojiPanelHeight - 1;
            this.emojiTargetY = this.screenHeight - footerHeight - 1;
            this.isEmojiVisible = true;
        }
    }

    public static GameManager getInstance() {
        return instance;
    }

    public DialogBox createDialog(String var1, int var2, Vector var3, int var4, ButtonAction var5, ButtonAction var6, ButtonAction var7) {
        DialogBox var8 = new DialogBox(var1, var2, var3, var4, var5, var6, var7);
        this.dialogQueue.addElement(var8);
        this.isMenuVisible = false;
        this.showingDialog = true;
        return var8;
    }

    public DialogBox createSimpleDialog(String var1, ButtonAction var2, ButtonAction var3, ButtonAction var4) {
        DialogBox var5 = new DialogBox(var1, var2, var3, var4);
        this.dialogQueue.addElement(var5);
        this.isMenuVisible = false;
        this.showingDialog = true;
        return var5;
    }

    private DialogBox createMultiTextDialog(String[] var1, ButtonAction var2, ButtonAction var3, ButtonAction var4) {
        DialogBox var5 = new DialogBox(var1, var2, var3, var4);
        this.dialogQueue.addElement(var5);
        this.isMenuVisible = false;
        this.showingDialog = true;
        return var5;
    }

    public void closeDialog() {
        if (this.dialogQueue.size() > 0) {
            DialogBox var1 = (DialogBox) this.dialogQueue.elementAt(0);
            this.dialogQueue.removeElementAt(0);
            var1.centerSoftkey = null;
            var1.leftSoftkey = null;
            var1.rightSoftkey = null;
            System.gc();
        }

        if (this.dialogQueue.size() == 0) {
            this.showingDialog = false;
        }
    }

    public boolean hasScreen(String var1) {
        int var2 = this.screenCount;

        while (--var2 >= 0) {
            if (((Screen) this.screenStack.elementAt(var2)).title.equals(var1)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsScreen(Screen var1) {
        return this.screenStack.contains(var1);
    }

    private GameManager() {
    }

    public void initialize(int var1, int var2) {
        if (isLocalTest = Xuka.serverIPs[0].startsWith("10.") || Xuka.serverIPs[0].endsWith("127.0.0.1") || Xuka.serverPorts[0] == 11112) {
            System.out.println("LOCAL TEST");
        }

        System.gc();
        this.screenWidth = var1;
        this.screenHeight = var2;
        this.screenStack = new Vector();
        this.menuStack = new Vector();
        this.notificationQueue = new Vector();
        if (helpButton == null) {
            helpButton = new ButtonAction("Gọi CSKH", new CallSupportAction(this));
            infoButton = new ButtonAction("Thông tin", new GetInfomationAction(this));
            forumButton = new ButtonAction("Diễn đàn", new ForumAction(this));
        }

        menuWidth = GameGraphics.screenWidth < 130 ? 126 : 130;
        UIUtils.layoutParam1 = GameGraphics.screenWidth < 250 ? 70 : 80;
        UIUtils.layoutParam2 = GameGraphics.screenWidth < 250 ? 150 : 160;
        this.itemHeight = FontRenderer.fontHeight + 3;
        marginTop = 1;
        headerHeight = footerHeight = FontRenderer.isCustomFontEnabled ? 18 : FontRenderer.fontHeight + 3;
        defaultHeight = footerHeight;
        this.titleOffset = (headerHeight - FontRenderer.fontHeight >> 1) - 1;
        this.notificationY[0] = GameGraphics.screenHeight - footerHeight - FontRenderer.fontHeight - 8;
        this.notificationY[1] = this.notificationY[2] = marginTop + footerHeight + 1;
        this.notificationSpeeds[0] = 1;
        this.notificationSpeeds[1] = 2;
        this.notificationSpeeds[2] = 1;
        soundEnabled = Xuka.loadBooleanSetting("sound", false);
        vibrateEnabled = Xuka.loadBooleanSetting("vibrate", true);
        autoLogin = Xuka.loadBooleanSetting("atlog", true);
        autoLoginYahoo = Xuka.loadBooleanSetting("atlogY", false);
        statusIcons = new Image[7];
        arrowIcons = new Image[3];
        GameProcessor.loadImageData(0);
        byte[] var3 = GameProcessor.getImageBytes(0);
        Image var11 = Image.createImage(var3, 0, var3.length);
        byte[] var4 = GameProcessor.getImageBytes(1);
        loadingImage = Image.createImage(var4, 0, var4.length);
        var4 = GameProcessor.getImageBytes(2);
        byte[] var5 = GameProcessor.getImageBytes(3);
        dialogBackground = Image.createImage(var5, 0, var5.length);
        backgroundImage = Image.createImage(var4, 0, var4.length);
        var4 = GameProcessor.getImageBytes(4);
        var5 = GameProcessor.getImageBytes(5);
        byte[] var6 = GameProcessor.getImageBytes(6);
        arrowIcons[0] = Image.createImage(var4, 0, var4.length);
        arrowIcons[1] = Image.createImage(var5, 0, var5.length);
        arrowIcons[2] = Image.createImage(var6, 0, var6.length);
        System.gc();
        gameIcons = Image.createImage(var4 = GameProcessor.getImageBytes(7), 0, var4.length);
        var4 = GameProcessor.getImageBytes(8);
        var5 = GameProcessor.getImageBytes(9);
        var6 = GameProcessor.getImageBytes(10);
        byte[] var7 = GameProcessor.getImageBytes(11);
        byte[] var8 = GameProcessor.getImageBytes(12);
        byte[] var9 = GameProcessor.getImageBytes(13);
        byte[] var10 = GameProcessor.getImageBytes(14);
        statusIcons[0] = Image.createImage(var4, 0, var4.length);
        statusIcons[1] = Image.createImage(var5, 0, var5.length);
        statusIcons[2] = Image.createImage(var6, 0, var6.length);
        statusIcons[3] = Image.createImage(var7, 0, var7.length);
        statusIcons[4] = Image.createImage(var8, 0, var8.length);
        statusIcons[5] = Image.createImage(var9, 0, var9.length);
        statusIcons[6] = Image.createImage(var10, 0, var10.length);
        Image var17 = Image.createImage(var4 = GameProcessor.getImageBytes(15), 0, var4.length);
        GameProcessor.cleanup();
        int var20 = GameGraphics.screenHeight - (footerHeight << 1) + 2;
        Graphics var23 = (backgroundBuffer = Image.createImage(GameGraphics.screenWidth, var20)).getGraphics();
        int var24 = (GameGraphics.screenWidth >> 5) + 1;

        for (int var25 = 0; var25 < var24; var25++) {
            var23.drawImage(var11, var25 << 5, var20 - var11.getHeight(), 0);
        }

        int var26 = var20 - var11.getHeight() - 32;
        int var21 = (var20 - var11.getHeight() >> 5) + 1;

        for (int var27 = 0; var27 < var24; var27++) {
            for (int var29 = 0; var29 < var21; var29++) {
                var23.drawRegion(var11, 0, 0, 32, 32, 0, var27 << 5, var26 - (var29 << 5), 0);
            }
        }

        System.gc();
        Graphics var28 = (headerImage = Image.createImage(GameGraphics.screenWidth, 18)).getGraphics();
        int var30 = (GameGraphics.screenWidth - 128 >> 5) + 1;

        while (--var30 >= 0) {
            var28.drawRegion(var17, 64, 0, 32, 18, 0, 64 + (var30 << 5), 0, 20);
        }

        var28.drawRegion(var17, 0, 0, 64, 18, 0, 0, 0, 20);
        var28.drawRegion(var17, 0, 0, 64, 18, 2, GameGraphics.screenWidth - 64, 0, 20);
        System.gc();
        backgroundBuffer.getHeight();
        this.titleBarHeight = footerHeight;
        this.iconOffset = (footerHeight - 7 >> 1) + 1;
        this.currentScreenIndex = 0;
        Screen.screenX = 0;
        Screen.screenY = defaultHeight;
        Screen.screenWidth = var1;
        Screen.screenHeight = var2 - defaultHeight;
        Screen.softkeyY = defaultHeight + Screen.screenHeight - (footerHeight >> 1) - (FontRenderer.fontHeight >> 1) + (FontRenderer.isCustomFontEnabled ? 0 : 1);
        this.menuRightX = Screen.screenWidth - FontRenderer.getTextWidth(TextConstant.close()) - 4;
        this.loginScreen = new LoginScreen();
        this.loginScreen.startSlideAnimation(1);
        this.addScreenToStack((Screen) this.loginScreen);
        this.switchToCurrentScreen();
        if (GameGraphics.isNokiaDevice) {
            TextInputComponent.setKeyboardLayout(1);
        } else if (Xuka.platform != null && Xuka.platform.toLowerCase().indexOf("nokia") != -1) {
            TextInputComponent.setKeyboardLayout(0);
        } else {
            TextInputComponent.setKeyboardLayout(2);
        }

        TextInputComponent.currentCanvas = GameGraphics.instance;
        TextInputComponent.parentMidlet = Xuka.instance;
        TextInputComponent.inputModeIndex = Xuka.loadCaret();
        GameGraphics.isDebugMode = true;
    }

    public void checkConnection() {
        if (NetworkManager.isConnecting) {
            this.createSimpleDialog("Đang kiểm tra kết nối..", null, null, new ButtonAction(TextConstant.close(), new LoginCloseCheckConnectionAction(this))).setLoadingVisible(true);
        }
    }

    public void showRegisterScreen() {
        if (this.registrationScreen == null) {
            this.registrationScreen = new RegistrationScreen();
        }

        this.registrationScreen.initializeComponents();
        this.addScreenToStack((Screen) this.registrationScreen);
        this.switchToScreen(this.registrationScreen);
        this.removeScreen(this.loginScreen);
        this.registrationScreen.startSlideAnimation(1);
    }

    public static void loadChatImages() {
        if (chatBackground == null) {
            GameProcessor.loadImageData(2);
            byte[] var0;
            cardImage = Image.createImage(var0 = GameProcessor.getImageBytes(0), 0, var0.length);
            System.gc();
            chatBackground = Image.createImage(var0 = GameProcessor.getImageBytes(1), 0, var0.length);
            System.gc();
            avatarImage = Image.createImage(var0 = GameProcessor.getImageBytes(2), 0, var0.length);
            System.gc();
            menuImage = Image.createImage(var0 = GameProcessor.getImageBytes(3), 0, var0.length);
            decorationImage = Image.createImage(var0 = GameProcessor.getImageBytes(4), 0, var0.length);
            System.gc();
            buttonImage = Image.createImage(var0 = GameProcessor.getImageBytes(5), 0, var0.length);
            gameBackground = Image.createImage(var0 = GameProcessor.getImageBytes(6), 0, var0.length);
            System.gc();
            emojiImage = Image.createImage(var0 = GameProcessor.getImageBytes(7), 0, var0.length);
            System.gc();
            GameProcessor.cleanup();
        }
    }

    public static void loadGameImages() {
        if (splashImage == null) {
            GameProcessor.loadImageData(1);
            byte[] var0;
            splashImage = Image.createImage(var0 = GameProcessor.getImageBytes(0), 0, var0.length);
            System.gc();
            roomIcon = Image.createImage(var0 = GameProcessor.getImageBytes(1), 0, var0.length);
            settingsIcon = Image.createImage(var0 = GameProcessor.getImageBytes(2), 0, var0.length);
            friendListIcon = Image.createImage(var0 = GameProcessor.getImageBytes(3), 0, var0.length);
            System.gc();
            GameProcessor.cleanup();
        }
    }

    public void drawHeader(Graphics var1) {
        GameManager var2 = this;
        if (FontRenderer.isCustomFontEnabled) {
            var1.drawImage(headerImage, 0, 0, 20);
        } else {
            int var5 = footerHeight >> 1;
            var1.setColor(1404853);
            var1.fillRect(0, 0, Screen.screenWidth, var5);
            var1.setColor(1334695);
            var1.fillRect(0, var5, Screen.screenWidth, var5);
            var1.setColor(537185);
            var1.fillRect(0, 2 * var5, Screen.screenWidth, 1);
            var1.setColor(6796786);
            var1.fillRect(0, 1, Screen.screenWidth, 1);
        }

        FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.currentScreen.subtitle, this.titleX, this.titleOffset, var1);
        if (this.screenCount > 1) {
            for (int var4 = 0; var4 < var2.screenCount; var4++) {
                if (((Screen) var2.screenStack.elementAt(var4)).showInNavigation) {
                    if (var4 < var2.currentScreenIndex) {
                        if (var2.leftArrowAnim++ > 20) {
                            var2.leftArrowAnim = 0;
                        }
                    } else if (var2.rightArrowAnim++ > 20) {
                        var2.rightArrowAnim = 0;
                    }
                }
            }

            if (var2.currentScreenIndex > 0 && var2.leftArrowAnim < 10) {
                var1.drawRegion(arrowIcons[2], 0, 0, 7, 7, 0, 4, var2.iconOffset, 20);
            }

            if (var2.currentScreenIndex < var2.screenCount - 1 && var2.rightArrowAnim < 10) {
                var1.drawRegion(arrowIcons[2], 7, 0, 7, 7, 0, var2.screenWidth - 10, var2.iconOffset, 20);
            }
        }

        var1.setClip(0, footerHeight, this.screenWidth, this.screenHeight);
        if (this.currentScreen.isAtBottom) {
            var1.setColor(396304);
            var1.fillRect(0, 0, this.screenWidth, this.screenHeight);
            int var29 = this.screenWidth - 248 >> 1;
            int var3 = this.screenHeight - 248 >> 1;
            int var11 = var29;
            var1.drawImage(splashImage, var11, var3, 20);
            var1.drawRegion(splashImage, 0, 0, 124, 248, 2, var11 + 124, var3, 20);
        } else {
            var1.drawImage(backgroundBuffer, 0, this.titleBarHeight, 0);
        }

        if (this.currentScreen.isAnimating) {
            var1.translate(-this.currentScreen.animationOffset, 0);
        }

        this.currentScreen.render(var1);
        var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
        Graphics var16 = var1;
        var2 = this;

        for (int var20 = 0; var20 < 3; var20++) {
            if (var2.notificationStates[var20] != 0) {
                var16.setClip(0, var2.notificationY[var20], GameGraphics.screenWidth, var2.notificationHeights[var20] + 2);
                var16.setColor(872315);
                var16.fillRect(var2.notificationX[var20] + 1, var2.notificationTargetY[var20] + 1, var2.notificationWidths[var20] - 1, var2.notificationHeights[var20] - 1);
                var16.setColor(14545919);
                ButtonComponent.drawRoundedBorder(var16, var2.notificationX[var20], var2.notificationTargetY[var20], var2.notificationWidths[var20], var2.notificationHeights[var20]);
                int var24 = 5;
                if (var2.notificationImages[var20] != null) {
                    var16.drawImage(var2.notificationImages[var20], var2.notificationX[var20] + 7 + (var2.notificationImages[var20].getWidth() >> 1), var2.notificationTargetY[var20] + (var2.notificationHeights[var20] >> 1), 3);
                    var24 = 5 + var2.notificationImages[var20].getWidth() + 1;
                }

                FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(var2.notificationTexts[var20], var2.notificationX[var20] + 3 + var24, var2.notificationTargetY[var20] + 3, var16);
            }
        }

        var1.setClip(-1000, -1000, 2000, 2000);
        if (this.showingDialog) {
            ((DialogBox) this.dialogQueue.elementAt(0)).render(var1);
        } else if (this.isMenuVisible) {
            var16 = var1;
            var2 = this;
            int var21 = 0;
            int var25 = this.menuStack.size();

            for (int var6 = 0; var6 < var25; var6++) {
                ContextMenu var7 = (ContextMenu) var2.menuStack.elementAt(var6);
                var21 = var2.isRightAligned ? ContactListComponent.abs(var7.width + var7.selectedIndex - var7.maxScrollY) : ContactListComponent.abs(var7.selectedIndex - (var7.width - var7.maxScrollY));
                var16.setClip((var2.isRightAligned ? var7.maxScrollY : var7.width) + 2, var7.itemHeight + 2, var21 - 3, var7.scrollY - 3);
                int var8 = var7.selectedIndex / 50 + 1;

                while (--var8 >= 0) {
                    int var9 = var7.scrollY / 50 + 1;

                    while (--var9 >= 0) {
                        var16.drawImage(backgroundImage, (var2.isRightAligned ? var7.maxScrollY : var7.width) + var8 * 50, var7.itemHeight + var9 * 50, 0);
                    }
                }

                var16.drawImage(dialogBackground, (var2.isRightAligned ? var7.maxScrollY : var7.width) + (var7.selectedIndex >> 1), var7.itemHeight, 17);
                var16.setClip(var7.width, var7.height, var7.selectedIndex + 1, var7.scrollY + 1);
                var16.setColor(14545919);
                ButtonComponent.drawRoundedBorder(
                        var16,
                        (var2.isRightAligned ? var7.maxScrollY : var7.width) + 1,
                        var7.itemHeight + 1,
                        (var2.isRightAligned ? ContactListComponent.abs(var7.width + var7.selectedIndex - var7.maxScrollY) : ContactListComponent.abs(var7.selectedIndex - (var7.width - var7.maxScrollY))) - 2,
                        var7.scrollY - 2
                );
                var16.setClip(var2.isRightAligned ? var7.width : var7.width + 2, var7.height, var2.isRightAligned ? var7.selectedIndex - 1 : var7.selectedIndex, var7.scrollY);
                var16.translate(var7.maxScrollY + 5, var7.itemHeight + 5);
                var8 = var7.menuItems.size();

                for (int var27 = 0; var27 < var8; var27++) {
                    var21 = 1 + var27 * var2.itemHeight + (FontRenderer.isCustomFontEnabled ? 0 : 2);
                    String var10 = ((ButtonAction) var7.menuItems.elementAt(var27)).text;
                    if (((ButtonAction) var7.menuItems.elementAt(var27)).parentContainer != null) {
                        var10 = var10 + " >";
                    }

                    if (var27 == var7.y) {
                        var16.setColor(136997);
                        var16.fillRoundRect(-1, var27 * var2.itemHeight - 1, (var2.isRightAligned ? ContactListComponent.abs(var7.width + var7.selectedIndex - var7.maxScrollY) : var7.selectedIndex) - 7, var2.itemHeight + 2, 5, 5);
                    }

                    FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(var10, 3, var21, var16);
                }

                var16.translate(-(var7.maxScrollY + 5), -(var7.itemHeight + 5));
            }

            var16.setClip(-1000, -1000, 5000, 5000);
            Screen.renderHeader(var16);
            FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText("Chọn", 4, Screen.softkeyY, var16);
            FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(TextConstant.close(), var2.menuRightX, Screen.softkeyY, var16);
        } else if (this.isEmojiVisible) {
            this.drawEmojiPicker(var1);
        }

        if (this.isInfoVisible) {
            int var14 = footerHeight + 8;
            int var18 = FontRenderer.isCustomFontEnabled ? 0 : 1;
            var1.setColor(1055519);
            var1.fillRect(8, var14 + 1, GameGraphics.screenWidth - 16, GameGraphics.screenHeight - (var14 << 1) + 3);
            var1.setColor(9478569);
            ButtonComponent.drawRoundedBorder(var1, 7, var14, GameGraphics.screenWidth - 15, GameGraphics.screenHeight - (var14 << 1) + 2);
            var1.setClip(9, 9, GameGraphics.screenWidth - 18, GameGraphics.screenHeight - 18);
            int var15 = var14 + 6;
            if (this.infoImage != null) {
                var1.drawImage(this.infoImage, GameGraphics.screenWidth - this.infoImage.getWidth() >> 1, var15 + 6, 0);
                var15 += this.infoImage.getHeight() + FontRenderer.fontHeight + var18;
            }

            for (int var19 = 0; var19 < this.infoLines.length; var19++) {
                FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(this.infoLines[var19], GameGraphics.screenWidth - 20 - FontRenderer.getTextWidth(this.infoLines[var19]) >> 1, var15 + var19 * FontRenderer.fontHeight, var1);
            }
        }

        if (this.isLoading) {
            var1.setClip(0, 0, GameGraphics.screenWidth, GameGraphics.screenHeight);
            var1.drawRegion(loadingAnimation, 8, this.frameCounter % 4 == 0 ? this.animationCounter++ * 6 : this.animationCounter * 6, 30, 6, 0, GameGraphics.screenWidth - 30, (footerHeight >> 1) + 1, 3);
            this.animationCounter = this.animationCounter > 3 ? 1 : this.animationCounter;
        }

        var1.setClip(-1000, -1000, 2000, 2000);
    }

    private void resetToLoginScreen() {
        isConnected = false;
        GameScreen.instance = null;
        GameScreen.currentRoomId = "";
        this.currentChatRoom = null;
        boolean var2 = false;
        this.isLoading = var2;
        this.completeFileSend();
        this.screenStack.removeAllElements();
        this.currentScreenIndex = 0;
        this.screenCount = 0;
        this.currentScreen = null;
        if (this.notificationQueue != null) {
            this.notificationQueue.removeAllElements();
        }

        System.gc();
        if (this.loginScreen == null) {
            this.loginScreen = new LoginScreen();
        }

        this.addScreenToStack((Screen) this.loginScreen);
        this.loginScreen.startSlideAnimation(-1);
        if (this.friendScreen != null) {
            this.friendScreen.clearContactData();
            this.friendScreen = null;
        }

        if (this.yahooChat != null) {
            this.yahooChat.clearContactData();
            this.yahooChat = null;
        }

        if (this.downloadManager != null) {
            this.downloadManager.deleteAllDownloads();
            this.downloadManager = null;
        }

        System.gc();
    }

    public void disconnect() {
        NetworkManager.forceDisconnect = true;
        this.resetToLoginScreen();
        int var1 = NetworkManager.bytesSent;
        int var2 = NetworkManager.bytesReceived;
        if (var1 > 0) {
            var1 = var1 / 1024 + 1;
        }

        if (var2 > 0) {
            var2 = var2 / 1024 + 1;
        }

        this.showMultiLineDialog(new String[]{"Dung lượng internet", var1 + var2 + " Kb"});
        NetworkManager.bytesSent = 0;
        NetworkManager.bytesReceived = 0;
        NetworkManager.forceDisconnect();

        try {
            Thread.sleep(50L);
        } catch (InterruptedException var3) {
        }

        System.gc();
    }

    private Action getMenuHandler() {
        if (this.menuHandler == null) {
            this.menuHandler = new quyen_gj(this);
        }

        return this.menuHandler;
    }

    public ButtonAction createBackButton(String var1) {
        if (this.backButton == null) {
            this.backButton = new ButtonAction("", this.getMenuHandler());
        }

        this.backButton.text = var1;
        return this.backButton;
    }

    public ButtonAction getSelectButton() {
        if (this.selectButton == null) {
            this.selectButton = new ButtonAction("", this.getMenuHandler());
        }

        return this.selectButton;
    }

    public DialogBox showInfoDialog(String var1) {
        return this.createSimpleDialog(var1, null, this.createBackButton(TextConstant.close()), null);
    }

    public DialogBox showConfirmDialog(String var1, Action var2) {
        return this.createMultiTextDialog(FontRenderer.wrapTextToLines(var1, GameGraphics.screenWidth - 30), new ButtonAction("OK", var2), new ButtonAction("", var2), this.createBackButton(TextConstant.close()));
    }

    public void showOKDialog(String var1, Action var2) {
        this.createSimpleDialog(var1, null, new ButtonAction("OK", var2), null);
    }

    public void showWrappedTextDialog(String var1) {
        this.showMultiLineDialog(FontRenderer.wrapTextToLines(var1, GameGraphics.screenWidth - 30));
    }

    private void showMultiLineDialog(String[] var1) {
        this.createMultiTextDialog(var1, this.getSelectButton(), this.createBackButton("OK"), null);
    }

    public void removeScreen(Screen var1) {
        if (var1 != null) {
            int var2 = this.screenStack.size();

            while (--var2 >= 0) {
                if (this.screenStack.elementAt(var2).equals(var1)) {
                    if (var2 <= this.currentScreenIndex) {
                        this.currentScreenIndex--;
                        if (this.currentScreenIndex < 0) {
                            this.currentScreenIndex = 0;
                        }
                    }

                    this.screenStack.removeElementAt(var2);
                    System.gc();
                    this.screenCount = this.screenStack.size();
                }
            }

            this.switchToCurrentScreen();
            this.currentScreen.startSlideAnimation(-1);
            System.gc();
        }
    }

    public void destroyScreen(Screen var1) {
        this.removeScreen(var1);
        System.gc();
    }

    public Screen setActiveScreen(String var1) {
        int var2 = this.screenCount;

        while (--var2 >= 0) {
            if (((Screen) this.screenStack.elementAt(var2)).title.equals(var1)) {
                return (Screen) this.screenStack.elementAt(var2);
            }
        }

        return null;
    }

    private void closeMenu(boolean var1) {
        if (!var1 && this.menuStack.size() > 1) {
            this.menuStack.removeElementAt(this.menuStack.size() - 1);
        } else {
            this.menuStack.removeAllElements();
            this.isMenuVisible = false;
        }
    }

    public void showContextMenu(ContextMenu var1, int var2) {
        if (!this.showingDialog) {
            if (!this.isMenuVisible) {
                this.menuStack.removeAllElements();
            }

            this.isMenuVisible = true;
            var1.x = var2;
            int var3;
            if (this.screenWidth > 300) {
                var3 = 0;
            } else if (this.screenWidth <= 300 && this.screenWidth >= 170) {
                var3 = menuWidth >> 1;
            } else {
                var3 = menuWidth;
            }

            int var4 = 0;
            int var5 = 0;
            if (this.menuStack.size() > 0) {
                ContextMenu var6;
                var4 = (var6 = (ContextMenu) this.menuStack.lastElement()).width;
                var5 = var6.height;
            }

            var1.scrollY = 9 + var1.menuItems.size() * this.itemHeight;
            var1.selectedIndex = menuWidth;
            if (this.menuStack.size() == 0) {
                if (var2 == 0) {
                    this.isRightAligned = false;
                    var1.width = 1;
                } else if (var2 == 2) {
                    this.isRightAligned = true;
                    var1.width = this.screenWidth - var1.selectedIndex - 2;
                } else if (var2 == 1) {
                    this.isRightAligned = false;
                    var1.width = (this.screenWidth >> 1) - (var1.selectedIndex >> 1);
                }

                var1.height = this.screenHeight - footerHeight - var1.scrollY;
                var1.maxScrollY = var1.width;
                var1.itemHeight = this.screenHeight - footerHeight;
            } else if (this.menuStack.size() > 0) {
                if (this.isRightAligned) {
                    if (this.menuStack.size() > 1 && var4 - var1.selectedIndex + var3 < 0) {
                        this.isRightAligned = false;
                        var1.width = var4 + menuWidth - var3;
                    } else {
                        var1.width = var4 - var1.selectedIndex + var3;
                    }
                } else {
                    if (this.menuStack.size() > 1 && var4 + menuWidth - var3 + var1.selectedIndex > this.screenWidth) {
                        this.isRightAligned = true;
                        var1.width = var4 - var1.selectedIndex + var3;
                    } else {
                        var1.width = var4 + menuWidth - var3;
                    }

                    if (((ContextMenu) this.menuStack.firstElement()).x == 2) {
                        var1.width = (this.screenWidth >> 1) - (var1.selectedIndex >> 1);
                    }
                }

                if (var1.width < 0) {
                    var1.width = 0;
                }

                ContextMenu var8 = (ContextMenu) this.menuStack.lastElement();
                if ((var2 = var5 + var8.y * this.itemHeight) + var1.scrollY > this.screenHeight - footerHeight) {
                    var1.height = this.screenHeight - footerHeight - var1.scrollY;
                } else {
                    var1.height = var2;
                }

                var1.itemHeight = var1.height;
                if (this.isRightAligned) {
                    var1.maxScrollY = var1.width + var1.selectedIndex;
                } else {
                    var1.maxScrollY = var1.width - var1.selectedIndex;
                }
            }

            var1.y = 0;
            this.menuStack.addElement(var1);
        }
    }

    public void handleInput(boolean[] var1, boolean[] var2, int[] var3) {
        this.frameCounter++;
        if (this.frameCounter >= 100000) {
            this.frameCounter = 0;
        }

        if (this.frameCounter % 3000 == 0 && NetworkManager.isConnected) {
            NetworkManager.sendPacket(new Packet(50, 2));
        }

        if (this.isTimeout && this.timeoutCounter++ >= 100) {
            this.resetConnectionCounters();
        }

        if (this.gameController != null) {
            this.gameController.action();
            this.gameController = null;
        }

        if (showConnectionStatus && ++connectionTimer == 270) {
            connectionTimer = 0;
            showConnectionStatus = false;
        }

        GameManager var4 = this;
        if (this.isInfoVisible) {
            this.infoTimer--;
            if (this.infoTimer <= 0) {
                this.isInfoVisible = false;
            }
        }

        if (this.notificationQueue != null) {
            this.notificationTimer++;
            if (this.notificationTimer >= 100000) {
                this.notificationTimer = 0;
            }

            int var5 = this.notificationQueue.size();

            while (--var5 >= 0) {
                Notification var6;
                if ((var6 = (Notification) var4.notificationQueue.elementAt(var5)) != null) {
                    if ((long) var4.notificationTimer % var6.c == 0L) {
                        var6.e = true;
                    }

                    if (var6.e && var4.notificationStates[1] == 0) {
                        var6.e = false;
                        var4.showNotification(var6.a, var6.b, 1);
                        var4.notificationSpeeds[1] = (int) var6.d;
                    }
                }
            }
        }

        var4 = this;

        for (int var15 = 0; var15 < 3; var15++) {
            if (var4.notificationStates[var15] > 0) {
                if (var15 == 1) {
                    var4.notificationX[var15] = var4.notificationX[var15] - var4.notificationSpeeds[var15];
                    if (var4.notificationX[var15] < -var4.notificationWidths[var15]) {
                        var4.notificationStates[var15] = 0;
                    }
                } else if (var15 == 0) {
                    if (var4.notificationStates[var15] <= var4.notificationHeights[var15]) {
                        if (var4.notificationTargetY[var15] > var4.notificationY[var15]) {
                            var4.notificationTargetY[var15]--;
                        }
                    } else if (var4.notificationStates[var15] > 100 - var4.notificationHeights[var15]) {
                        var4.notificationTargetY[var15]++;
                    }

                    var4.notificationStates[var15]++;
                    if (var4.notificationStates[var15] > 100) {
                        var4.notificationStates[var15] = 0;
                    }
                } else if (var15 == 2) {
                    if (var4.notificationStates[var15] <= var4.notificationHeights[var15]) {
                        if (var4.notificationTargetY[var15] < var4.notificationY[var15]) {
                            var4.notificationTargetY[var15]++;
                        }
                    } else if (var4.notificationStates[var15] > 100 - var4.notificationHeights[var15]) {
                        var4.notificationTargetY[var15]--;
                    }

                    var4.notificationStates[var15]++;
                    if (var4.notificationStates[var15] > 100) {
                        var4.notificationStates[var15] = 0;
                    }
                }
            }
        }

        if (this.menuStack.size() > 0) {
            ContextMenu var16;
            if ((var16 = (ContextMenu) this.menuStack.lastElement()).itemHeight > var16.height) {
                int var21;
                if ((var21 = var16.itemHeight - var16.height >> 1) <= 0) {
                    var21 = 1;
                }

                var16.itemHeight -= var21;
            }

            if (var16.maxScrollY != var16.width) {
                int var22;
                if ((var22 = ContactListComponent.abs(var16.width - var16.maxScrollY) >> 1) <= 0) {
                    var22 = 1;
                }

                var16.maxScrollY = var16.maxScrollY + (this.isRightAligned ? -var22 : var22);
            }
        }

        if (this.emojiTargetY > this.emojiPanelY) {
            int var17;
            if ((var17 = this.emojiTargetY - this.emojiPanelY >> 1) <= 0) {
                var17 = 1;
            }

            this.emojiTargetY -= var17;
        }

        this.currentScreen.updateAnimation();
        if (GameGraphics.isPointerReleased) {
            if (GameGraphics.pointerY > GameGraphics.screenHeight - footerHeight) {
                if (GameGraphics.pointerX < GameGraphics.screenWidth / 3) {
                    var1[17] = true;
                } else if (GameGraphics.pointerX > 2 * GameGraphics.screenWidth / 3) {
                    var1[18] = true;
                } else {
                    var1[16] = true;
                }
            } else if (!this.showingDialog) {
                if (this.isMenuVisible) {
                    ContextMenu var13 = (ContextMenu) this.menuStack.lastElement();
                    if (GameGraphics.pointerX >= var13.width && GameGraphics.pointerX <= var13.width + var13.selectedIndex && GameGraphics.pointerY <= var13.height + var13.scrollY && GameGraphics.pointerY >= var13.height) {
                        int var19;
                        if ((var19 = (GameGraphics.pointerY - var13.height - 3) / this.itemHeight) < 0) {
                            var19 = 0;
                        }

                        if (var19 >= var13.menuItems.size()) {
                            var19 = var13.menuItems.size() - 1;
                        }

                        var13.y = var19;
                        var1[16] = true;
                    } else {
                        this.closeMenu(false);
                    }
                } else if (this.isEmojiVisible) {
                    if (GameGraphics.pointerX >= this.emojiPanelX && GameGraphics.pointerX <= this.emojiPanelX + this.emojiPanelWidth && GameGraphics.pointerY <= this.emojiPanelY + this.emojiPanelHeight && GameGraphics.pointerY >= this.emojiPanelY) {
                        int var12 = (GameGraphics.pointerX - this.emojiPanelX - 7) / 20;
                        int var18 = (GameGraphics.pointerY - this.emojiPanelY - 7) / 20;
                        if (var12 < 0) {
                            var12 = 0;
                        }

                        if (var12 > 5) {
                            var12 = 5;
                        }

                        if (var18 < 0) {
                            var18 = 0;
                        }

                        if (var18 > 6) {
                            var18 = 6;
                        }

                        if (var12 == this.emojiSelectedX && var18 == this.emojiSelectedY) {
                            var1[16] = true;
                        } else {
                            this.emojiSelectedX = var12;
                            this.emojiSelectedY = var18;
                        }
                    } else {
                        this.isEmojiVisible = false;
                    }
                } else if (GameGraphics.pointerY <= 0 || GameGraphics.pointerY >= footerHeight) {
                    this.currentScreen.onPointerPressed(GameGraphics.pointerX, GameGraphics.pointerY - Screen.screenY);
                } else if (GameGraphics.pointerX < touchThreshold) {
                    this.previousScreen();
                    var1[14] = false;
                } else if (GameGraphics.pointerX > GameGraphics.screenWidth - touchThreshold) {
                    this.nextScreen();
                    var1[15] = false;
                }
            }

            GameGraphics.isPointerReleased = false;
        }

        if (GameGraphics.isPointerPressed && !this.showingDialog) {
            this.currentScreen.onPointerReleased(GameGraphics.pointerX, GameGraphics.pointerY - Screen.screenY);
            GameGraphics.isPointerPressed = false;
        }

        if (GameGraphics.isPointerDown && !this.showingDialog) {
            this.currentScreen.onPointerDragged(GameGraphics.pointerX, GameGraphics.pointerY - Screen.screenY);
        }

        if (GameGraphics.isPointerDragged && !this.showingDialog) {
            this.currentScreen.onPointerMoved(GameGraphics.pointerX, GameGraphics.pointerY - Screen.screenY);
            GameGraphics.isPointerDragged = false;
        }

        boolean var14 = var1[14];
        boolean var20 = var1[15];
        boolean var23 = var1[12];
        boolean var7 = var1[13];
        if (var14 || var20 || var23) {
            this.notificationSpeeds[1] = this.notificationSpeeds[1] == 2 ? 6 : 2;
            if (this.notificationStates[0] > 1) {
                this.notificationStates[0] = 101 - this.notificationHeights[0];
            }

            if (this.notificationStates[2] > 1) {
                this.notificationStates[2] = 101 - this.notificationHeights[2];
            }
        }

        if (this.showingDialog) {
            DialogBox var8 = (DialogBox) this.dialogQueue.elementAt(0);
            if (var1[17] && var8.leftSoftkey != null) {
                var8.leftSoftkey.action.action();
                this.closeDialog();
            }

            if (var1[18] && var8.rightSoftkey != null) {
                var8.rightSoftkey.action.action();
                this.closeDialog();
            }

            if (var1[16] && var8.centerSoftkey != null) {
                var8.centerSoftkey.action.action();
                this.closeDialog();
            }

            GameGraphics.clearKeyStates();
        }

        if (this.isMenuVisible) {
            if (var23 || var2[12]) {
                ContextMenu var27;
                (var27 = (ContextMenu) this.menuStack.lastElement()).y--;
                if (var27.y < 0) {
                    var27.y = var27.menuItems.size() - 1;
                }
            } else if (var7 || var2[13]) {
                ContextMenu var26;
                (var26 = (ContextMenu) this.menuStack.lastElement()).y++;
                if (var26.y > var26.menuItems.size() - 1) {
                    var26.y = 0;
                }
            } else if (var14) {
                this.closeMenu(false);
            } else if (var20) {
                ContextMenu var25;
                ButtonAction var29;
                if ((var29 = (ButtonAction) (var25 = (ContextMenu) this.menuStack.lastElement()).menuItems.elementAt(var25.y)).parentContainer != null) {
                    this.showContextMenu(var29.parentContainer, -1);
                }
            } else if (var1[16] || var1[17]) {
                ButtonAction var9;
                ContextMenu var24;
                if ((var9 = (ButtonAction) (var24 = (ContextMenu) this.menuStack.lastElement()).menuItems.elementAt(var24.y)).parentContainer == null) {
                    if (var9.action != null) {
                        var9.action.action();
                        this.closeMenu(true);
                    }
                } else {
                    this.showContextMenu(var9.parentContainer, -1);
                }
            } else if (var1[18]) {
                this.closeMenu(true);
            }

            GameGraphics.clearKeyStates();
        }

        if (this.isEmojiVisible) {
            if (var1[17] || var1[16]) {
                this.isEmojiVisible = false;

                try {
                    Screen var28 = this.currentScreen;
                    if (this.currentScreen == GameScreen.instance && GameScreen.isInGame) {
                        String var30 = FontRenderer.emoticons[this.emojiSelectedY * 6 + this.emojiSelectedX];
                        if (GameScreen.totalRooms == 0) {
                            PacketSender.requestSendDataUIComponent(0, GameScreen.currentRoomId, FriendScreen.username, var30);
                        }
                    }

                    if (isValidErrorCode(var28.dialogId)) {
                        ((TextInputComponent) var28.findComponentByID(2)).insertText(FontRenderer.emoticons[this.emojiSelectedY * 6 + this.emojiSelectedX]);
                    } else if (var28 instanceof ChatRoomScreen) {
                        ((ChatRoomScreen) var28).textInputComponent.insertText(FontRenderer.emoticons[this.emojiSelectedY * 6 + this.emojiSelectedX]);
                    } else {
                        ChatScreen var31;
                        (var31 = (ChatScreen) this.currentScreen).textInputComponent.insertText(FontRenderer.emoticons[this.emojiSelectedY * 6 + this.emojiSelectedX]);
                    }
                } catch (Exception var10) {
                }
            }

            if (var1[18]) {
                this.isEmojiVisible = false;
            }

            if (var23 || var2[12]) {
                this.moveEmojiSelectionUp(true);
            }

            if (var7 || var2[13]) {
                this.emojiSelectedY++;
                if (this.emojiSelectedY > 6) {
                    this.emojiSelectedY = 0;
                    this.moveEmojiSelectionRight(false);
                }
            }

            if (var14 || var2[14]) {
                this.emojiSelectedX--;
                if (this.emojiSelectedX < 0) {
                    this.emojiSelectedX = 5;
                    this.moveEmojiSelectionUp(false);
                }
            }

            if (var20 || var2[15]) {
                this.moveEmojiSelectionRight(true);
            }

            GameGraphics.clearKeyStates();
        }

        this.currentScreen.isActive = false;
        if (this.currentScreen.handleInput(var1, var2, var3)) {
            if (var14) {
                var1[14] = false;
                this.previousScreen();
                return;
            }

            if (var20) {
                var1[15] = false;
                this.nextScreen();
            }
        }
    }

    private void moveEmojiSelectionUp(boolean var1) {
        this.emojiSelectedY--;
        if (this.emojiSelectedY < 0) {
            this.emojiSelectedY = 6;
            if (var1) {
                this.emojiSelectedX--;
                if (this.emojiSelectedX < 0) {
                    this.emojiSelectedX = 5;
                }
            }
        }
    }

    private void moveEmojiSelectionRight(boolean var1) {
        this.emojiSelectedX++;
        if (this.emojiSelectedX > 5) {
            this.emojiSelectedX = 0;
            if (var1) {
                this.emojiSelectedY++;
                if (this.emojiSelectedY > 6) {
                    this.emojiSelectedY = 0;
                }
            }
        }
    }

    public void nextScreen() {
        if (this.screenCount > 1) {
            this.currentScreenIndex++;
            if (this.currentScreenIndex >= this.screenCount) {
                this.currentScreenIndex = 0;
            }

            this.switchToCurrentScreen();
            this.currentScreen.startSlideAnimation(1);
        }
    }

    public void previousScreen() {
        if (this.screenCount > 1) {
            this.currentScreenIndex--;
            if (this.currentScreenIndex < 0) {
                this.currentScreenIndex = this.screenCount - 1;
            }

            this.switchToCurrentScreen();
            this.currentScreen.startSlideAnimation(-1);
        }
    }

    private void switchToScreenAt(int var1) {
        if (var1 >= 0) {
            this.currentScreenIndex = var1;
            this.switchToCurrentScreen();
        }
    }

    public void switchToLastScreen() {
        this.switchToScreenAt(this.screenCount - 1);
    }

    public void switchToScreenByTitle(String var1) {
        int var2 = this.screenCount;

        do {
            var2--;
        } while (var2 >= 0 && !((Screen) this.screenStack.elementAt(var2)).title.equals(var1));

        this.currentScreenIndex = var2;
        this.switchToCurrentScreen();
    }

    public void switchToScreen(Screen var1) {
        if (var1 == null) {
            this.switchToScreenAt(0);
        } else {
            int var2 = this.screenCount;

            do {
                var2--;
            } while (var2 >= 0 && !((Screen) this.screenStack.elementAt(var2)).equals(var1));

            if (var2 == -1) {
                this.switchToScreenAt(0);
            } else {
                this.currentScreenIndex = var2;
                this.switchToCurrentScreen();
            }
        }
    }

    public boolean containsScreenInstance(Screen var1) {
        int var2 = this.screenCount;

        while (--var2 >= 0) {
            if (((Screen) this.screenStack.elementAt(var2)).equals(var1)) {
                return true;
            }
        }

        return false;
    }

    public static int bytesToInt(byte var0, byte var1, byte var2, byte var3) {
        return var0 << 24 & 0xFF000000 | var1 << 16 & 0xFF0000 | var2 << 8 & 0xFF00 | var3 & 0xFF;
    }

    private static byte[] intToBytes(int var0) {
        byte[] var1;
        (var1 = new byte[4])[0] = (byte) (var0 >> 24);
        var1[1] = (byte) (var0 >> 16 & 0xFF);
        var1[2] = (byte) (var0 >> 8 & 0xFF);
        var1[3] = (byte) var0;
        return var1;
    }

    private static void writeStringToStream(ByteArrayOutputStream var0, String var1) throws IOException {
        var0.write(var1.getBytes());
        var0.write(nullByte);
    }

    private static void writeIntToStream(ByteArrayOutputStream var0, int var1) throws IOException {
        var0.write(intToBytes(var1));
    }

    private static int readIntFromStream(ByteArrayInputStream var0) {
        return bytesToInt((byte) var0.read(), (byte) var0.read(), (byte) var0.read(), (byte) var0.read());
    }

    private static byte[] longToBytes(long var0) {
        byte[] var2;
        (var2 = new byte[8])[0] = (byte) ((int) (255L & var0 >> 56));
        var2[1] = (byte) ((int) (255L & var0 >> 48));
        var2[2] = (byte) ((int) (255L & var0 >> 40));
        var2[3] = (byte) ((int) (255L & var0 >> 32));
        var2[4] = (byte) ((int) (255L & var0 >> 24));
        var2[5] = (byte) ((int) (255L & var0 >> 16));
        var2[6] = (byte) ((int) (255L & var0 >> 8));
        var2[7] = (byte) ((int) (255L & var0));
        return var2;
    }

    public static long bytesToLong(byte[] var0) {
        return (long) (var0[0] & 255) << 56
                | (long) (var0[1] & 255) << 48
                | (long) (var0[2] & 255) << 40
                | (long) (var0[3] & 255) << 32
                | (long) (var0[4] & 255) << 24
                | (long) (var0[5] & 255) << 16
                | (long) (var0[6] & 255) << 8
                | (long) (var0[7] & 255);
    }

    private static void writeLongToStream(ByteArrayOutputStream var0, long var1) throws IOException {
        var0.write(longToBytes(var1));
    }

    private static long readLongFromStream(ByteArrayInputStream var0) {
        byte[] var1 = new byte[8];

        for (byte var2 = 0; var2 < 8; var2++) {
            var1[var2] = (byte) var0.read();
        }

        return bytesToLong(var1);
    }

    private static String readStringFromStream(ByteArrayInputStream var0) {
        String var1 = "";

        int var2;
        while ((var2 = var0.read()) != 0) {
            var1 = var1 + (char) ((byte) var2);
        }

        return var1;
    }

    public static long getUserId(String var0) {
        return Xuka.loadLongData("xkmyid" + var0);
    }

    private static void saveContactStatus(int data, boolean isYahoo) {
        Xuka.saveData(isYahoo ? "yahoocs" : "xubics" + FriendScreen.username, intToBytes(data), "xkown");
    }

    public static int loadContactStatus(boolean isYahooContact) {
        return Xuka.loadIntData(isYahooContact ? "yahoocs" : "xubics" + FriendScreen.username, "xkown");
    }

    public static boolean saveBuddyList(BuddyGroupList var0, boolean var1, String var2) {
        ByteArrayOutputStream var3 = new ByteArrayOutputStream();
        Vector var9 = var0.contactGroups;

        try {
            writeIntToStream(var3, var9.size());

            for (int var4 = 0; var4 < var9.size(); var4++) {
                BuddyGroup var5 = (BuddyGroup) var9.elementAt(var4);
                writeStringToStream(var3, var5.getGroupName());
                Vector var10 = var5.contacts;
                writeIntToStream(var3, var10.size());

                for (int var6 = 0; var6 < var10.size(); var6++) {
                    BuddyInfo var7 = (BuddyInfo) var10.elementAt(var6);
                    writeStringToStream(var3, var7.username);
                    writeStringToStream(var3, var7.displayName);
                    writeIntToStream(var3, var7.dataSize);
                    if (!var1) {
                        writeLongToStream(var3, var7.contactId);
                    }
                }
            }

            Xuka.saveData((var1 ? "ybuddy" : "vbuddy") + var2, var3.toByteArray(), "xkown");
            return true;
        } catch (Exception var8) {
            return false;
        }
    }

    public static BuddyGroupList loadBuddyList(boolean var0, String var1) {
        byte[] var10;
        if ((var10 = Xuka.loadData((var0 ? "ybuddy" : "vbuddy") + var1, "xkown")) == null) {
            return null;
        } else {
            ByteArrayInputStream var11 = new ByteArrayInputStream(var10);
            BuddyGroupList var2 = new BuddyGroupList();

            try {
                var2.contactGroups = new Vector();
                int var3 = readIntFromStream(var11);

                for (int var4 = 0; var4 < var3; var4++) {
                    String var5 = readStringFromStream(var11);
                    BuddyGroup var12;
                    (var12 = new BuddyGroup(var5)).contacts = new Vector();
                    int var6 = readIntFromStream(var11);

                    for (int var7 = 0; var7 < var6; var7++) {
                        BuddyInfo var8;
                        (var8 = new BuddyInfo()).username = readStringFromStream(var11);
                        var8.displayName = readStringFromStream(var11);
                        var8.dataSize = readIntFromStream(var11);
                        if (!var0) {
                            var8.contactId = readLongFromStream(var11);
                        }

                        var12.addContact(var8);
                    }

                    var2.contactGroups.addElement(var12);
                }

                return var2;
            } catch (Exception var9) {
                return null;
            }
        }
    }

    public static boolean saveUserStorage(Hashtable var0) {
        if (var0.size() == 0) {
            return false;
        } else {
            ByteArrayOutputStream var1 = new ByteArrayOutputStream();

            try {
                writeIntToStream(var1, var0.size());
                Enumeration var2 = var0.keys();

                while (var2.hasMoreElements()) {
                    Long var3 = (Long) var2.nextElement();
                    writeLongToStream(var1, var3.longValue());
                    writeStringToStream(var1, (String) var0.get(var3));
                }

                Xuka.saveData("userstorage", var1.toByteArray(), "xkown");
                return true;
            } catch (Exception var4) {
                return false;
            }
        }
    }

    public static Hashtable loadUserStorage() {
        byte[] var0;
        if ((var0 = Xuka.loadData("userstorage", "xkown")) == null) {
            return null;
        } else {
            ByteArrayInputStream var4 = new ByteArrayInputStream(var0);
            Hashtable var1 = new Hashtable();

            try {
                int var2 = readIntFromStream(var4);

                while (--var2 >= 0) {
                    var1.put(new Long(readLongFromStream(var4)), readStringFromStream(var4));
                }

                return var1;
            } catch (Exception var3) {
                return null;
            }
        }
    }

    public void addChatMessage(String var1, String var2, String var3) {
        String var4 = "Y! " + var1;
        ChatScreen var5;
        if ((var5 = (ChatScreen) this.setActiveScreen(var4)) == null) {
            (var5 = new ChatScreen(var4, true, null, var1)).chatTitle = var1;
            this.addScreenToStack(var5);
        }

        if (!var5.title.equals(this.currentScreen.title)) {
            String var8 = FontRenderer.getFirstLineWrapped(var2, GameGraphics.screenWidth - GameGraphics.screenWidth / 3);
            this.showNotification(var1 + " chat: " + var8 + "...", (Image) null, 1);
            var5.showInNavigation = true;
            this.vibrate();
        }

        var5.chatComponent.addPlayerMessage(var1 + " (" + var3 + ")", var2, 1);
        var5.chatComponent.scrollToBottom();
        var5.isActive = true;
    }

    public void addSimpleMessage(String var1, String var2) {
        String var3 = "Y! " + var1;
        ChatScreen var4;
        if ((var4 = (ChatScreen) this.setActiveScreen(var3)) == null) {
            (var4 = new ChatScreen(var3, true, null, var1)).chatTitle = var1;
            this.addScreenToStack(var4);
        }

        if (!var4.title.equals(this.currentScreen.title)) {
            var3 = FontRenderer.getFirstLineWrapped(var2, GameGraphics.screenWidth - GameGraphics.screenWidth / 3);
            this.showNotification(var1 + " chat: " + var3 + "...", (Image) null, 1);
            var4.showInNavigation = true;
            this.vibrate();
        }

        boolean var6 = var4.chatComponent.isNearBottom();
        var4.chatComponent.addPlayerMessage(var1, var2, 1);
        if (var6) {
            var4.chatComponent.scrollToBottom();
        }

        var4.isActive = true;
    }

    public void onRegisterFailed() {
        this.closeDialog();
        this.showWrappedTextDialog("Lỗi đăng ký. Vui lòng chọn tên khác.");
    }

    public void onRegisterSuccess() {
        this.closeDialog();
        this.showNotification("Đăng ký thành công", (Image) null, 0);
        this.loginScreen.usernameInput.setText(this.registrationScreen.finalUsername);
        this.loginScreen.passwordInput.setText(this.registrationScreen.finalPassword);
        Xuka.saveUserID(this.registrationScreen.finalUsername);
        Xuka.savePassword(this.registrationScreen.finalPassword);
        this.addScreenToStack((Screen) this.loginScreen);
        UIUtils.focusComponent(this.loginScreen, (UIComponent) this.loginScreen.usernameInput);
        this.removeScreen(this.registrationScreen);
        this.registrationScreen = null;
        System.gc();
    }

    public void onLoginFailed() {
        this.closeDialog();
        this.showWrappedTextDialog("Sai tên hoặc mật khẩu.");
    }

    public void onConnectionError() {
        boolean var2 = false;
        this.isLoading = var2;
        this.closeDialog();
        if (isConnected) {
            Xuka.instance.makePhoneCall("0084969728701");
            isConnected = false;
        } else {
            if (GameGraphics.gameState == 1) {
                this.createSimpleDialog("Lỗi kết nối\nVui lòng kiểm tra kết nối internet", null, null, this.createBackButton(TextConstant.close()));
            }
        }
    }

    public void updateContactMessage(String var1, String var2, int var3) {
        var2 = TextValidator.filterBadWords(var2);

        try {
            this.yahooChat.contactList.updateContactSubtext(var1, var2, 1);
        } catch (Exception var4) {
        }
    }

    public void friendStatusChanged(String var1, int var2, int var3) {
        String var11 = var2 == 1 ? " đã đăng nhập" : " đã thoát";
        if (this.yahooChat != null) {
            try {
                boolean var4;
                if ((var4 = this.yahooChat.contactList.updateContactStatus(var1, var2)) || !var4 && this.yahooChat.contactList.isFilterActive) {
                    byte var5 = 2;
                    int var9 = this.currentScreen instanceof ChatScreen ? 2 : 0;
                    this.showNotification(var5 == 1 ? var1 + var11 : "Y! " + var1 + var11, var2 == 1 ? statusIcons[1] : statusIcons[0], var9);
                }

                ChatScreen var12;
                if ((var12 = (ChatScreen) this.setActiveScreen("Y! " + var1)) != null) {
                    var12.chatComponent.addSystemMessage(var1 + var11, var2 == 1 ? 1 : 2);
                    var12.chatComponent.scrollToBottom();
                }
            } catch (Exception var10) {
            }
        }
    }

    public void showMessage(String var1) {
        this.showWrappedTextDialog(var1);
    }

    public void onConnectionLost() {
        boolean var2 = false;
        this.isLoading = var2;
        this.closeDialog();
        isConnected = false;
        this.createSimpleDialog("Mất kết nối\nVui lòng thoát và đăng nhập lại", new ButtonAction("Thoát", new quyen_gk(this)), null, this.createBackButton(TextConstant.close()));
    }

    public void onAddFriendError(String var1) {
        this.showWrappedTextDialog("Lỗi thêm bạn " + var1);
    }

    public void onYahooDisconnect() {
        this.yahooChat.isConnectionReady = false;
        this.yahooChat.switchToMode(false);
        this.reconnectCount++;
        if (this.hasExceededReconnectLimit()) {
            this.showWrappedTextDialog("Tài khoản Yahoo của bạn bị khóa. Vui lòng đăng nhập lại sau.");
            this.isTimeout = true;
        } else {
            this.showNotification("Mất kết nối Yahoo!", (Image) null, 0);
        }
    }

    public boolean hasExceededReconnectLimit() {
        return this.reconnectCount > 3;
    }

    public void resetConnectionCounters() {
        this.reconnectCount = 0;
        this.timeoutCounter = 0;
        this.isTimeout = false;
    }

    public void sendBuzz(String var1) {
        this.addSimpleMessage(var1, "BUZZ!");
        this.vibrate();
    }

    public Screen getCurrentScreen() {
        return this.currentScreen;
    }

    public void receiveBuzz(long var1) {
        this.receiveMessage(var1, "BUZZ!");
        if (!this.friendScreen.isUserBlocked(var1)) {
            this.vibrate();
        }
    }

    public void showUpdateDialog(int var1, String var2) {
        this.createSimpleDialog("Cập nhật phiên bản mới X Yahoo!: " + Xuka.formatVersion(var1), new ButtonAction("Tải về", new quyen_gl(this, var2)), null, this.createBackButton(TextConstant.close()));
    }

    public String getSmsMessage() {
        return this.smsMessage == null ? defaultString : this.smsMessage;
    }

    public String getSmsNumber() {
        return this.smsNumber == null ? defaultString : this.smsNumber;
    }

    public void showSMSConfirmDialog(String var1, String var2, String var3) {
        this.smsMessage = var2;
        quyen_gm var4 = new quyen_gm(this);
        quyen_gn var5 = new quyen_gn(this, var3, var4);
        String var7 = var3 + Xuka.refCode;
        this.createMultiTextDialog(
                FontRenderer.wrapTextToLines(var1 + "Gửi tin: " + var7 + "\nĐến số: " + var2.substring(6), GameGraphics.screenWidth - 30),
                new ButtonAction("OK", var5),
                null,
                new ButtonAction(TextConstant.close(), var4)
        );
    }

    public void setSMSForPasswordReset(String var1, String var2) {
        this.smsNumber = var1;
        smsContent = var2;
        if (this.loginScreen != null) {
            this.loginScreen.showForgotPasswordSMS();
        }
    }

    public void initializeFriendManager() {
        if (this.friendScreen == null) {
            this.friendScreen = new FriendScreen();
            this.friendScreen.dialogId = 11113;
        }

        this.friendScreen.startSlideAnimation(1);
    }

    private void initializeYahooChat() {
        if (this.yahooChat == null) {
            this.yahooChat = new YahooScreen();
            this.yahooChat.switchToMode(false);
        }

        this.yahooChat.startSlideAnimation(1);
    }

    private void autoLoginYahoo() {
        String var1 = Xuka.loadYahooID();
        String var2 = Xuka.loadYahooPassword();
        if (var1 != null && var1.length() > 0 && var2 != null && var2.length() > 0) {
            this.initializeYahooChat();
            this.yahooChat.switchToMode(false);
            this.addScreenToStack(this.yahooChat);
            this.yahooChat.performLogin();
        }
    }

    public static void doNothing() {
    }

    public void joinScreenByActionId(int actionId, boolean shouldSendPacket) {
        if (actionId == 11112) {
            this.initializeYahooChat();
            if (!this.containsScreenInstance(this.yahooChat)) {
                this.addScreenToStack(this.yahooChat);
            }

            this.switchToScreen(this.yahooChat);
        } else {
            if (actionId == 11113) {
                this.initializeFriendManager();
                if (!this.containsScreenInstance(this.friendScreen)) {
                    if (this.friendScreen.friendsComponent.contactData != null) {
                        this.friendScreen.friendsComponent.isLoading = false;
                    }

                    if (this.friendScreen.onlineFriends.size() > 0) {
                        long[] onlineFriendIds = FriendScreen.vectorToLongArray(this.friendScreen.onlineFriends);
                        Packet statusRequestPacket = new Packet(5000029, 2);
                        PacketUtils.writeInt(onlineFriendIds.length, statusRequestPacket);
                        int friendIndex = 0;

                        for (int totalFriends = onlineFriendIds.length; friendIndex < totalFriends; friendIndex++) {
                            PacketUtils.writeLong(onlineFriendIds[friendIndex], statusRequestPacket);
                        }

                        NetworkManager.sendPacket(statusRequestPacket);
                    } else {
                        PacketSender.requestGetListContactByType(1);
                    }
                    this.addScreenToStack(this.friendScreen);
                    this.switchToScreen(this.friendScreen);
                    return;
                }
                this.switchToScreen(this.friendScreen);
            } else if (actionId == 11114) {
                if (gameRoom == null || !this.containsScreenInstance(gameRoom)) {
                    PacketSender.d();
                    return;
                }

                gameRoom.startSlideAnimation(1);
                this.switchToScreen(gameRoom);
            } else {
                Screen targetScreen;
                if ((targetScreen = this.findScreenById(actionId)) != null) {
                    targetScreen.startSlideAnimation(1);
                    this.switchToScreen(targetScreen);
                    return;
                }

                this.isLoading = true;
                if (shouldSendPacket) {
                    Packet screenRequestPacket = new Packet(122, 2);
                    PacketUtils.writeInt(actionId, screenRequestPacket);
                    NetworkManager.sendPacket(screenRequestPacket);
                    return;
                }

                PacketSender.requestSendDataUIComponent(actionId);
            }
        }
    }

    public Screen findScreenById(int var1) {
        int var2 = this.screenCount;

        while (--var2 >= 0) {
            Screen var3;
            if ((var3 = (Screen) this.screenStack.elementAt(var2)).dialogId == var1) {
                return var3;
            }
        }

        return null;
    }

    public void setupMainMenu(DialogScreen var1) {
        this.closeDialog();
        this.mainMenu = var1;
        if (this.mainMenuList == null) {
            createCloseButton();
            ButtonAction var2 = new ButtonAction("Cấu hình", new quyen_ey(this));
            ButtonAction var3 = new ButtonAction("Gửi góp ý", new quyen_ez(this));
            ButtonAction var4 = new ButtonAction("Trạng thái", new quyen_fb(this));
            ButtonAction var5 = new ButtonAction("Thoát", new quyen_fc(this));
            Vector var6;
            (var6 = new Vector()).addElement(infoButton);
            var6.addElement(var3);
            var6.addElement(helpButton);
            var6.addElement(forumButton);
            (var3 = new ButtonAction("Hỗ trợ", null)).parentContainer = new ContextMenu(var6);
            (var6 = new Vector()).addElement(var2);
            var6.addElement(var3);
            var6.addElement(var5);
            this.mainMenuList = new ContextMenu(var6);
            Vector var8;
            (var8 = new Vector()).addElement(var4);
            var8.addElement(this.friendScreen.createPendingRequestsButton());
            var8.addElement(new ButtonAction("Tải về", new GameManagerClickDownloadAction(this)));
            this.gameMenuList = new ContextMenu(var8);
        }

        this.mainMenu.leftSoftkey = new ButtonAction("Menu", new GameManagerClickMenuAction(this));
        this.mainMenu.rightSoftkey = new ButtonAction("Quản lý", new GameManagerClickManagerAction(this));
        this.removeScreen(this.loginScreen);
        this.loginScreen = null;
        boolean var7 = false;
        if (firstRun && loginType != 0 && loginType == 1 && autoLoginYahoo) {
            this.autoLoginYahoo();
            var7 = true;
        }

        if (firstRun && autoLoginYahoo && !var7) {
            this.autoLoginYahoo();
        }

        TextRenderer.clearLogoCache();
    }

    public static ButtonAction createCloseButton() {
        if (closeButton == null) {
            closeButton = new ButtonAction("", new EmptyAction());
        }

        return closeButton;
    }

    public void replaceMainMenuItem(ButtonAction var1, int var2) {
        if (this.mainMenuList != null) {
            this.mainMenuList.menuItems.setElementAt(var1, var2);
        }
    }

    public void showAppInfo(String var1) {
        StringBuffer var2;
        (var2 = new StringBuffer("X Yahoo!")).append(" - ");
        var2.append(version);
        var2.append("\n");
        var2.append("Build ID: ");
        var2.append(Xuka.buildID);
        var2.append("\n");
        var2.append(var1);
        this.showWrappedTextDialog(var2.toString());
        System.gc();
    }

    public static void makePhoneCall(String var0) {
        Xuka.instance.makePhoneCall(var0);
    }

    public static void saveYahooContactStatus(int var0) {
        saveContactStatus(var0, true);
    }

    public void onYahooConnected() {
        this.resetConnectionCounters();
        if (YahooScreen.yahooStatus == 0 && YahooScreen.statusMessage != null && YahooScreen.statusMessage.length() > 0) {
            PacketSender.c(YahooScreen.statusMessage, 2);
        }

        this.yahooChat.isConnectionReady = true;
        if (Xuka.checkSpamFlag(YahooScreen.yahooUsername) == 0) {
            this.yahooChat.showInviteFriendDialog();
        }
    }

    public void loadYahooBuddyList(BuddyGroupList var1) {
        saveBuddyList(var1, true, YahooScreen.yahooUsername);
        this.yahooChat.contactList.setContactData(var1, -1);
        this.yahooChat.isActive = true;
        this.yahooChat.contactList.isLoading = false;
    }

    public void handleFriendRequestResponse(String var1, int var2) {
        var1 = UIUtils.concatStrings("Y! ", var1, var2 == 0 ? " từ chối" : " đồng ý", " bạn thêm vào danh sách bạn bè");
        if (var2 == 0) {
            this.showWrappedTextDialog(var1);
        } else {
            this.showNotification(var1, (Image) null, 1);
        }

        System.gc();
    }

    public void showAddFriendDialog(String username, long userId, boolean isYahoo) {
        if (isYahoo) {
            if (this.yahooChat == null || this.yahooChat.contactList.isLoading) {
                return;
            }
        } else if (userId == 0L) {
            return;
        }

        DialogScreen dialogScreenAddFriend = new DialogScreen();
        dialogScreenAddFriend.showInNavigation = true;
        dialogScreenAddFriend.title = "Thêm bạn";
        ButtonAction.createSimpleText(dialogScreenAddFriend, UIUtils.concatStrings(username, " thêm bạn vào danh sách. Bạn có đồng ý?", null, null));
        if (isYahoo) {
            TextInputComponent textInputNewGroupName = ButtonAction.createTextInput(dialogScreenAddFriend, "Vào nhóm mới:", 0);
            DropdownComponent dropdownOtherGroup = ButtonAction.createChoiceBox(dialogScreenAddFriend, "hoặc đã có:", this.yahooChat.contactList.getGroupNames());
            dropdownOtherGroup.setChangeAction(new quyen_fi(this, dropdownOtherGroup, textInputNewGroupName));
            if (dropdownOtherGroup.optionList != null && dropdownOtherGroup.optionList.length != 0) {
                textInputNewGroupName.setText(dropdownOtherGroup.getSelectedText());
            } else {
                textInputNewGroupName.setText("Friends");
            }

            dialogScreenAddFriend.leftSoftkey = new ButtonAction(TextConstant.decline(), new YahooRejectAddContactGroupAction(this, username, textInputNewGroupName, dialogScreenAddFriend));
            dialogScreenAddFriend.centerSoftkey = new ButtonAction("OK", new YahooDoneAddContactGroupAction(this, textInputNewGroupName, username, dialogScreenAddFriend));
        } else {
            dialogScreenAddFriend.leftSoftkey = new ButtonAction(TextConstant.decline(), new FriendRejectAddUserGroupAction(this, userId, dialogScreenAddFriend));
            dialogScreenAddFriend.centerSoftkey = new ButtonAction("OK", new FriendApproveAddUserGroupAction(this, userId, dialogScreenAddFriend));
        }

        dialogScreenAddFriend.rightSoftkey = new ButtonAction(TextConstant.close(), new FriendCloseAddUserGroupAction(this, isYahoo, userId, dialogScreenAddFriend));
        UIUtils.focusComponent(dialogScreenAddFriend, (UIComponent) dialogScreenAddFriend.components.elementAt(0));
        this.addScreen(dialogScreenAddFriend);
    }

    public void showPasswordChangeResult(boolean var1) {
        if (var1) {
            this.showWrappedTextDialog("Đã đổi thành công.");
        } else {
            this.showWrappedTextDialog("Sai mật khẩu cũ.");
        }
    }

    public static boolean isValidErrorCode(int var0) {
        return var0 == 2000 || var0 == 2002 || var0 == 2003 || var0 == 2001;
    }

    public void addNotification(int var1, String var2, byte[] var3, int var4, int var5, String var6) {
        this.notificationTimer = 0;

        try {
            if (var1 == 0) {
                if (var4 <= 0) {
                    var4 = 1;
                }

                Notification var8 = new Notification(var1, var2, var3, (long) (var4 * 25L), (long) var5, var6, true);
                this.notificationQueue.addElement(var8);
                return;
            }

            if (var1 != 1) {
                if (var1 == 2) {
                    currentMessage = var2;
                    if (var6 != null && var6.length() > 0) {
                        currentMessage = currentMessage + " " + var6;
                        System.gc();
                    }
                } else if (var1 == 3) {
                    this.isInfoVisible = true;
                    this.infoImage = Image.createImage(var3, 0, var3.length);
                    this.infoLines = FontRenderer.wrapTextToLines(var2, GameGraphics.screenWidth - 50);
                    this.infoTimer = var4 * 25;
                }
            }
        } catch (Exception var7) {
        }
    }

    public static void updateServerConfig(String[] var0, int[] var1) {
        Xuka.saveServerIPs(var0);
        Xuka.saveServerPorts(var1);
        if (!Xuka.loadBooleanSetting("report", false)) {
            Xuka.saveBooleanSetting("report", true);
            if (Xuka.platform == null) {
                Xuka.platform = "null";
            }

            PacketSender.requestSendDataUIComponent(0, Xuka.platform, GameGraphics.screenHeight, Xuka.versionCode);
        }

        PacketSender.sendAppInfo();
    }

    public void processReceivedData(byte[] var1) {
        this.processDataInThread(var1);
    }

    public static void resetConnectionFlag() {
        isConnected = false;
    }

    public void setLoadingState(boolean var1) {
        this.isLoading = var1;
    }

    public static void cacheImageData(Integer var0, byte[] var1) {
        ImageCache.cacheImage(var0, var1);
    }

    public void updateUserAvatar(long var1, int[] var3) {
        if (var1 == FriendScreen.currentUserAccountId) {
            FriendScreen.avatarData = var3;
        }

        this.friendScreen.updateContactAvatar(var1, var3);
    }

    public void handleFileSendResponse(String var1, int var2) {
        this.closeDialog();
        if (var2 < 0) {
            this.cancelFileSend();
            this.showWrappedTextDialog("Lỗi gửi file");
        } else {
            if (this.isFileSending) {
                this.currentFileName = var1 == null ? "" : var1;
                this.isFileSending = true;
                this.fileSentBytes = 0;
                this.fileProgress = 0;
                if (this.fileBufferSize < 1024) {
                    this.fileBufferSize = 5120;
                }

                this.continueFileSend();
            }
        }
    }

    public void handleFileSendContinue(boolean var1) {
        if (var1) {
            this.continueFileSend();
        } else {
            this.cancelFileSend();
            this.showWrappedTextDialog("Lỗi gửi file");
        }
    }

    public void setUploadData(String var1, byte[] var2, byte var3) {
        this.uploadFileName = var1;
        this.uploadData = var2;
        this.uploadType = var3;
    }

    public static void playMediaFile(byte[] var0, String var1, boolean var2, int var3) {
        MediaPlayerForm var4 = MediaPlayerForm.getInstance();
        if (var2) {
            var4.addSaveCommand();
        } else {
            var4.removeSaveCommand();
        }

        var4.setReturnMode(var3);
        var4.playMedia(var0, var1);
    }

    public void showPhotoViewer(byte[] var1, String var2, boolean var3, PhotoViewerScreen var4) {
        if (var3) {
            var4.showSaveButton(1);
        } else {
            var4.hideSendButton();
        }

        var4.setImageData(var1);
        var4.setTitle(var2);
        var4.startSlideAnimation(1);
        this.addScreenToStack(var4);
        this.switchToScreen(var4);
    }

    private void continueFileSend() {
        try {
            if (this.isFileSending && this.uploadData != null) {
                if (this.fileSentBytes < this.uploadData.length - this.fileBufferSize) {
                    PacketSender.requestSendDataUIComponent(instance.currentFileName, this.uploadData, this.fileSentBytes, this.fileBufferSize, false);
                    this.fileSentBytes = this.fileSentBytes + this.fileBufferSize;
                    this.fileProgress = 100 * this.fileSentBytes / this.uploadData.length;
                    if (this.fileSentBytes >= this.uploadData.length) {
                        this.completeFileSend();
                    }
                } else {
                    PacketSender.requestSendDataUIComponent(instance.currentFileName, this.uploadData, this.fileSentBytes, this.uploadData.length - this.fileSentBytes, true);
                    this.completeFileSend();
                    this.fileProgress = 100;
                }

                this.showNotification(UIUtils.concatStrings(TextConstant.sending(), Integer.toString(this.fileProgress), "%", null), (Image) null, 0);
                this.notificationTargetY[2] = instance.notificationY[2];
            }
        } catch (Exception var1) {
        }
    }

    public void cancelFileSend() {
        this.isFileSending = false;
        this.fileSentBytes = 0;
        this.fileProgress = 0;
    }

    public void completeFileSend() {
        this.cancelFileSend();
        FileBrowserList.instance = null;
        this.uploadFileName = null;
        this.uploadData = null;
        if (this.uploadType == 0) {
            if (this.fileManager != null) {
                this.fileManager.imageBytes = null;
                this.destroyScreen(this.fileManager);
            }
        } else if (this.uploadType == 1 && SaveFileForm.instance != null) {
            SaveFileForm.instance.cleanup();
        }

        System.gc();
    }

    public void showFileSizeConfirmDialog(int var1, Action var2, Action var3) {
        this.createSimpleDialog(
                UIUtils.concatStrings(FileBrowserList.getInstance().getSelectedFilePath(false), " có kích thước ", Integer.toString(var1 / 1000), " KBs. Bạn có muốn tiếp tục?"),
                new ButtonAction("Gửi", new quyen_fs(this, var3)),
                new ButtonAction("Mở", new quyen_ft(this, var2)),
                new ButtonAction(TextConstant.close(), new quyen_fu(this))
        );
    }

    public void startFileOperation(boolean var1) {
        new Thread(new FileOperationTask(this, var1)).start();
    }

    public void startFileSend() {
        if (!this.isFileSending) {
            this.isFileSending = true;
            PacketSender.requestSendDataUIComponent(this.uploadData.length, this.uploadType, this.uploadFileName);
            this.showNotification("Đang gửi file..", (Image) null, 2);
        } else {
            this.createSimpleDialog("Đang gửi file khác.\nBạn có muốn hủy bỏ file đang gửi?", new ButtonAction("Hủy bỏ", new quyen_fz(this)), null, this.createBackButton(TextConstant.close()));
        }
    }

    public static ButtonAction createCloseButton(Screen var0, boolean var1, Action var2) {
        Object var3;
        if (var1) {
            var3 = new quyen_ga(var2, var0);
        } else {
            var3 = new quyen_gc(var0);
        }

        return new ButtonAction(TextConstant.close(), (Action) var3);
    }

    public void initializeMediaCapture(byte var1, byte var2) {
        if (this.fileManager == null) {
            this.fileManager = new PhotoViewerScreen();
            this.fileManager.showSendButton(0);
        }

        this.uploadType = var2;
        if (var1 == 1) {
            GameManager var6 = this;

            try {
                FileSystemInterface var7 = FileSystemInterface.getInstance();
                FileBrowserList var3;
                (var3 = FileBrowserList.getInstance()).setReturnScreen(2);
                var3.selectedAction = new quyen_fv(var6, var3, var7);
                var3.showBrowser("Chọn file", -1);
            } catch (ClassNotFoundException var4) {
                showMainScreen();
                instance.showWrappedTextDialog("Điện thoại không hỗ trợ chức năng này");
            } catch (Exception var5) {
                showMainScreen();
            }
        } else if (var1 == 0) {
            if (var2 == 0) {
                CameraCanvas.getInstance().completionAction = new quyen_fr(this);
                CameraCanvas.getInstance().initializeCamera(0);
                return;
            }

            if (var2 == 1) {
                CameraCanvas.getInstance().completionAction = new quyen_fo(this);
                CameraCanvas.getInstance().cancelAction = new quyen_fp(this);
                CameraCanvas.getInstance().initializeCamera(1);
            }
        }
    }

    public void onFileDownloaded(String var1, byte[] var2) {
        if (this.downloadManager != null) {
            int var3 = this.downloadManager.downloadListComponent.listItems.size();

            while (--var3 >= 0) {
                BuddyListItem var4;
                BuddyInfo var5;
                if ((var5 = (var4 = (BuddyListItem) this.downloadManager.downloadListComponent.listItems.elementAt(var3)).contactRef).username.equals(var1)) {
                    var5.mediaData = var2;
                    var5.isSelected = true;
                    var4.statusText = UIUtils.concatStrings(Integer.toString(var5.statusCode), " KBs", null, null);
                    if (this.hasDownloaded) {
                        this.showNotification(UIUtils.concatStrings("Đã tải xong ", var5.mediaExtension, null, null), (Image) null, 1);
                    } else {
                        this.hasDownloaded = true;
                        this.showNotification(UIUtils.concatStrings("Đã tải xong ", var5.mediaExtension, ". Vào Quản lý > Tải về. ", null), (Image) null, 1);
                    }
                }
            }

            this.addScreenToStack(this.downloadManager);
        }

        System.gc();
    }

    private void showDownloadManager() {
        this.downloadManager.startSlideAnimation(1);
        this.addScreenToStack(this.downloadManager);
    }

    public void startDownload(String var1, String var2, int var3, byte var4) {
        String var5 = UIUtils.concatStrings("Đang tải về ", var2, null, null);
        if (this.downloadManager == null) {
            this.downloadManager = new DownloadScreen();
            this.showDownloadManager();
            this.switchToScreen(this.downloadManager);
            this.showNotification(UIUtils.concatStrings(var5, ". Vào Quản lý > Tải về. ", "Bạn có thể lưu vào thẻ nhớ.", null), (Image) null, 1);
        } else {
            this.showDownloadManager();
            this.showNotification(var5, (Image) null, 1);
        }

        this.downloadManager.deleteDownloadsByType(var4);
        if (var4 == 0) {
            var5 = UIUtils.concatStrings("Hình", " ", var2, null);
        } else {
            var5 = UIUtils.concatStrings("Video", " ", var2, null);
        }

        BuddyInfo var6 = new BuddyInfo(var1, var5, var3, null, null, -1, -1, null);
        var6.mediaType = var4;
        var6.description = UIUtils.concatStrings("Đang tải - ", Integer.toString(var3), " KBs", null);
        var6.mediaExtension = var2;
        this.downloadManager.buddyGroupList.insertContactToGroup("", var6);
        this.downloadManager.downloadListComponent.buildListItems();
    }

    public static void handleGameUpdate(
            String var0,
            String var1,
            int var2,
            byte[] var3,
            int var4,
            String[] var5,
            int[] var6,
            long[] var7,
            long[] var8,
            byte[][] var9,
            boolean[] var10,
            CardInfo[] var11
    ) {
        if (GameScreen.currentRoomId.equals(var0)) {
            GameScreen.instance.a(true, true);
            GameScreen.instance.handlePlayerMove(var1, var2, var3, null, false);
            GameScreen.instance.playerReadyStates = var10;
            GameScreen.instance.handleGameResult(var0, (byte) var5.length, var5, var7, var8, (byte) var5.length, var5, var9, var6, var11);
        }
    }

    public static void handleGameStart(String var0, String var1, byte var2, String[] var3, int[] var4, long[] var5, long[] var6, byte[][] var7, CardInfo[] var8) {
        if (GameScreen.currentRoomId.equals(var0)) {
            GameScreen.instance.a(true, true);
            GameScreen.instance.playerReadyStates = new boolean[var3.length];

            for (int var9 = 0; var9 < var3.length; var9++) {
                GameScreen.instance.playerReadyStates[var9] = false;
                if (var3[var9].equals(FriendScreen.username)) {
                    for (int var10 = 0; var10 < var3.length; var10++) {
                        if (GameScreen.instance.playerComponents[var10].playerName.equals(var3[var9])) {
                            GameScreen.instance.playerComponents[var10].cardData = var7[var9];
                            GameScreen.instance.startCardGame(var7[var9], var1, false, false);
                            break;
                        }
                    }
                }
            }

            GameScreen.instance.handleGameResult(var0, var2, var3, var5, var6, var2, var3, var7, var4, var8);
            GameScreen.instance.showContinueButton();
        }
    }

    public static void handleSpecialGameStart(String var0, byte[] var1, String var2, boolean var3) {
        if (GameScreen.currentRoomId.equals(var0)) {
            GameScreen.instance.a(false, true);
            GameScreen.instance.isGameStarted = true;
            GameScreen.instance.isSpecialGameMode = true;
            GameScreen.instance.specialModeText = null;
            GameScreen.instance.startCardGame(var1, var2, var3, true);
        }
    }

    public void handlePlayerMove(String var1, String var2, int var3, byte[] var4, String var5, boolean var6) {
        if (GameScreen.currentRoomId.equals(var1)) {
            updateSpecialModeText(var2);
            if (FriendScreen.username.equals(var2)) {
                GameScreen.instance.cardGameComponent.removeCards(var4);
            }

            GameScreen.instance.handlePlayerMove(var2, var3, var4, var5, var6);
        }
    }

    private static void updateSpecialModeText(String var0) {
        if (GameScreen.instance.specialModeText == null) {
            GameScreen.instance.specialModeText = var0;
        } else {
            if (!GameScreen.instance.specialModeText.equals(var0)) {
                GameScreen.instance.isSpecialGameMode = false;
            }
        }
    }

    public void handlePlayerMoveWithState(String var1, String var2, int var3, byte[] var4, String var5, boolean var6, int var7) {
        if (GameScreen.currentRoomId.equals(var1)) {
            updateSpecialModeText(var2);
            this.handlePlayerMove(var1, var2, var3, var4, var5, var6);

            for (int var8 = 0; var8 < GameScreen.instance.playerComponents.length; var8++) {
                if (GameScreen.instance.playerComponents[var8].playerName.equals(var2)) {
                    GameScreen.instance.playerComponents[var8].gameState = var7;
                    GameScreen.instance.playerComponents[var8].isActive = true;
                    if (var2.equals(FriendScreen.username)) {
                        GameScreen.instance.isSpectating = true;
                    }
                }
            }
        }
    }

    public static void deselectAllCards() {
        if (GameScreen.instance != null && GameScreen.instance.cardGameComponent != null) {
            GameScreen.instance.cardGameComponent.deselectAllCards();
        }
    }

    public void handlePlayerLeaveRoom(String var1, String var2, String var3, String[] var4, String var5) {
        if (GameScreen.instance != null) {
            if (GameScreen.currentRoomId.equals(var1)) {
                if (var2.equals(FriendScreen.username)) {
                    if (var5 != null && var5.length() > 0) {
                        this.showNotification(var5, (Image) null, 1);
                    }

                    GameScreen.instance.returnToLobby();
                    GameScreen.requestRoomList();
                    return;
                }

                if (GameScreen.isInGame && var4.length > 0) {
                    GameScreen.instance.playerComponents = createPlayerComponents(var4);
                    GameScreen.instance.roomOwner = var3;
                    long[] var7 = new long[var4.length];
                    int[] var8 = new int[var4.length];
                    GameScreen.instance.playerActiveStates = new boolean[var4.length];

                    for (int var6 = 0; var6 < var4.length; var6++) {
                        var7[var6] = GameScreen.instance.playerComponents[var6].getMoney();
                        var8[var6] = GameScreen.instance.playerComponents[var6].avatarId.intValue();
                        GameScreen.instance.playerActiveStates[var6] = GameScreen.instance.playerComponents[var6].isReady();
                        if (var4[var6].equals(var3)) {
                            GameScreen.instance.removeMenuItem(var2);
                        }
                    }

                    GameScreen.instance.initializeGameRoom((byte) var4.length, var4, var7, var8);
                }
            }
        }
    }

    public static void updatePlayerTurn(String var0, String var1, String var2, boolean var3) {
        if (GameScreen.currentRoomId.equals(var0) && GameScreen.instance != null) {
            GameScreen.instance.updatePlayerTurn(var1, var2, var3);
        }
    }

    public void joinGameRoom(String var1, long var2, String[] var4, long[] var5, int[] var6, boolean[] var7, String var8) {
        GameScreen var9 = GameScreen.instance;
        if (GameScreen.instance != null) {
            if (GameScreen.isInGame) {
                if (!GameScreen.currentRoomId.equals(var1)) {
                    return;
                }

                if (!(this.currentScreen instanceof GameScreen)) {
                    this.showNotification("Có người chơi vào bàn", (Image) null, 2);
                }
            }

            GameScreen.currentRoomId = var1;
            var9.gameFinished = true;
            var9.finalPlayerCount = var4.length;
            var9.finalPlayerNames2 = var4;
            var9.finalPlayerMoney = var5;
            var9.playerAvatarIds = var6;
            var9.roomOwner = var8;
            var9.playerActiveStates = new boolean[var4.length];
            if (var9.canStartGame) {
                var9.playerCount = (byte) var4.length;
                var9.setBetAmount(var2);
                var9.playerNames = new String[var4.length];

                for (byte var10 = 0; var10 < var4.length; var10++) {
                    var9.playerNames[var10] = var4[var10];
                    var9.playerAvatarIds[var10] = var6[var10];
                    var9.playerActiveStates[var10] = var7[var10];
                    if (!GameScreen.isInGame) {
                        var9.startSlideAnimation(1);
                    }
                }

                System.gc();
                var9.initializeGameRoom((byte) var4.length, var4, var5, var6);
            }
        }
    }

    public static void updatePlayerReadyStates(String var0, String[] var1, boolean[] var2) {
        if (GameScreen.currentRoomId.equals(var0)) {
            for (byte var4 = 0; var4 < GameScreen.instance.playerComponents.length; var4++) {
                for (int var3 = 0; var3 < var1.length; var3++) {
                    if (GameScreen.instance.playerComponents[var4].playerName.equals(var1[var3])) {
                        GameScreen.instance.playerActiveStates[var4] = var2[var3];
                        GameScreen.instance.playerComponents[var4].setReady(var2[var3]);
                        if (FriendScreen.username.equals(var1[var3]) && !var2[var3] && !FriendScreen.username.equals(GameScreen.instance.roomOwner) && GameScreen.instance.centerSoftkey != null) {
                            GameScreen.instance.centerSoftkey.text = "Sẵn sàng";
                        }
                    }
                }
            }
        }
    }

    public static PlayerComponent[] createPlayerComponents(String[] var0) {
        PlayerComponent[] var1 = new PlayerComponent[var0.length];

        for (byte var2 = 0; var2 < var0.length; var2++) {
            for (byte var3 = 0; var3 < GameScreen.instance.playerComponents.length; var3++) {
                if (var0[var2].equals(GameScreen.instance.playerComponents[var3].playerName)) {
                    var1[var2] = GameScreen.instance.playerComponents[var3];
                }
            }
        }

        return var1;
    }

    public static void updatePlayerTurnHidden(String var0, String var1, String var2, boolean var3) {
        if (GameScreen.currentRoomId.equals(var0)) {
            GameScreen.instance.updateTurnWithHidden(var1, var2, var3);
        }
    }

    public void showMoneyNotification(long var1) {
        this.showNotification(UIUtils.concatStrings("Số tiền của bạn: ", Long.toString(var1), " ", "xu"), (Image) null, 1);
    }

    public static void handlePlayerChat(String var0, String var1, String var2, int var3) {
        if (GameScreen.currentRoomId.equals(var0)) {
            PlayerComponent[] var6 = null;
            if (var3 == 39) {
                var6 = GameScreen.instance.playerComponents;
            }

            if (var2.length() < 5 && (var3 = FontRenderer.findEmoticonIndex(var2)) != 100 && var6 != null) {
                int var4 = 0;

                for (int var5 = var6.length; var4 < var5; var4++) {
                    if (var6[var4].playerName.equals(var1)) {
                        var6[var4].showCountdown = true;
                        var6[var4].countdownValue = var3;
                        var6[var4].countdownStart = (byte) ((int) (System.currentTimeMillis() / 1000L));
                        System.gc();
                        return;
                    }
                }
            }

            if (var6 != null) {
                var3 = 0;

                for (int var9 = var6.length; var3 < var9; var3++) {
                    if (var6[var3].playerName.equals(var1)) {
                        var6[var3].showChatMessage(var2);
                        System.gc();
                        return;
                    }
                }
            }
        }
    }

    public void startCardGame(String var1, GameRoom[] var2, int var3, String var4) {
        GameScreen.gameTypeId = var1;
        GameScreen.getInstance().gameTitle = var4;
        GameScreen.instance.showRoomList(var2, 0);
        if (!this.currentScreen.equals(GameScreen.instance)) {
            GameScreen.instance.startSlideAnimation(1);
        }

        this.addScreenToStack(GameScreen.instance);
        this.switchToScreen(GameScreen.instance);
    }

    /*
     * Ý nghĩa: Tạo cache key cho việc lưu trữ dữ liệu
     * Tạo key với prefix khác nhau tùy theo loại dữ liệu:
     * - "cs" + dataId: cho checksum data (kiểm tra tính toàn vẹn)
     * - "dt" + dataId: cho actual data (dữ liệu thực tế)
     *
     * @param dataId - ID của dữ liệu
     * @param isChecksum - true nếu tạo key cho checksum, false cho data
     * @return String cache key được tạo
     */
    private static String generateCacheKey(int dataId, boolean isChecksum) {
        return (isChecksum ? "cs" : "dt") + dataId;
    }

    private void processDataInThread(byte[] var1) {
        new Thread(new ProcessDataTask(this, var1), "GameManager.processDataInThread").start();
    }

    /*
     * Ý nghĩa: Tải dữ liệu từ cache và xử lý
     * Kiểm tra tính hợp lệ của cache bằng cách so sánh checksum
     * Nếu cache hợp lệ thì xử lý dữ liệu, không thì yêu cầu tải lại từ server
     *
     * @param dataId - ID của dữ liệu cần tải
     * @param expectedChecksum - checksum mong đợi để kiểm tra tính toàn vẹn
     */
    public void loadCachedData(int dataId, int dataVersion) {
        byte[] cachedData = Xuka.loadData(generateCacheKey(dataId, false), "xkcsp");
        int serverDataVersion = Xuka.loadIntData(generateCacheKey(dataId, true), "xkcsp");
        if (serverDataVersion == dataVersion && cachedData != null) {
            this.processDataInThread(cachedData);
        } else {
            PacketSender.requestSendDataUIComponent(dataId);
        }
    }

    /*
     * Ý nghĩa: Lưu dữ liệu vào cache với checksum để kiểm tra tính toàn vẹn
     * Xử lý dữ liệu ngay lập tức và lưu cả checksum và dữ liệu thực tế vào cache
     *
     * @param dataId - ID của dữ liệu cần lưu cache
     * @param checksum - checksum để kiểm tra tính toàn vẹn dữ liệu
     * @param dataToCache - dữ liệu thực tế cần cache
     */
    public void saveCachedData(int dataId, int dataVersion, byte[] dataToCache) {
        this.processDataInThread(dataToCache);
        Xuka.saveData(generateCacheKey(dataId, true), intToBytes(dataVersion), "xkcsp");
        Xuka.saveData(generateCacheKey(dataId, false), dataToCache, "xkcsp");
    }

    public void showGameLobby(BuddyGroupList var1) {
        if (gameRoom == null) {
            (gameRoom = new GameLobbyScreen()).gameListComponent.itemAction = new quyen_gd(this);
            gameRoom.gameListComponent.selectAction.text = "Vào phòng";
            gameRoom.title = "Tiến Lên Miền Nam";
            gameRoom.selectedGameIndex = 0;
            UIUtils.setScreenSubtitleText(gameRoom, gameRoom.title);
        }

        gameRoom.gameListComponent.setIconSettings(1, 10, 10);
        gameRoom.gameListComponent.setEnableIconStatus(1);
        gameRoom.gameListComponent.setDataSource(var1, 0, false);
        gameRoom.startSlideAnimation(1);
        if (!this.containsScreenInstance(gameRoom)) {
            this.addScreenToStack(gameRoom);
        }

        this.switchToScreen(gameRoom);
    }

    public void updateUserProfile(long userAccountId, long[] onlineFriendIds, int contactStatus) {
        if (this.friendScreen != null) {
            FriendScreen.currentUserAccountId = userAccountId;
            String currentUsername = FriendScreen.username;
            Xuka.saveData("xkmyid" + currentUsername, longToBytes(userAccountId), "xkown");
            if (onlineFriendIds != null) {
                if (loadContactStatus(false) != contactStatus) {
                    saveContactStatus(contactStatus, false);
                    FriendScreen.setVectorFromArray(onlineFriendIds, this.friendScreen.onlineFriends);
                    this.friendScreen.sendBulkRequest(this.friendScreen.onlineFriends);
                }
            } else {
                this.friendScreen.friendsComponent.isLoading = false;
                if (this.friendScreen.friendsComponent.contactData != null) {
                    this.friendScreen.friendsComponent.contactData = null;
                }
            }
        }
    }

    public void setEmptyContactMessage(String var1) {
        if (this.friendScreen != null) {
            this.friendScreen.friendsComponent.emptyMessageLines = FontRenderer.wrapTextToLines(var1, GameGraphics.screenWidth - 30);
        }
    }

    public void loadContactData(BuddyGroupList var1) {
        this.friendScreen.friendsComponent.setContactData(var1, -1);
        saveBuddyList(var1, false, FriendScreen.username);
        this.friendScreen.friendsComponent.isLoading = false;
    }

    public void handleFriendRequests(long[] UserIds, String[] requesterNames) {
        if (this.friendScreen != null && UserIds != null) {
            if (this.friendScreen.isInitialized) {
                Vector filteredRequests = new Vector();
                int userIdCount = UserIds.length;

                while (--userIdCount >= 0) {
                    if (!this.friendScreen.isUserOnline(UserIds[userIdCount]) && !this.friendScreen.isUserBlocked(UserIds[userIdCount])) {
                        filteredRequests.addElement(new Long(UserIds[userIdCount]));
                    }
                }

                if (filteredRequests.size() > 0) {
                    Long[] longArray = new Long[filteredRequests.size()];
                    filteredRequests.copyInto(longArray);
                    UserIds = new long[filteredRequests.size()];
                    int arrayIndex = filteredRequests.size();

                    while (--arrayIndex >= 0) {
                        UserIds[arrayIndex] = longArray[arrayIndex].longValue();
                    }
                }

                FriendScreen.setVectorFromArray(UserIds, this.friendScreen.pendingRequests);
                if (UserIds.length > 0) {
                    int totalRequests = UserIds.length;
                    this.showNotification("Bạn có " + totalRequests + " lời mời kết bạn. Xin vào Quản lý => Chờ kết bạn", (Image) null, 1);
                    this.friendScreen.updatePendingRequestsButton();
                }

                this.friendScreen.isInitialized = false;
                return;
            }

            int requestIndex = 0;

            for (int totalRequestCount = UserIds.length; requestIndex < totalRequestCount; requestIndex++) {
                if (!this.friendScreen.isUserOnline(UserIds[requestIndex]) && !this.friendScreen.isUserBlocked(UserIds[requestIndex]) && !this.friendScreen.isRequestPending(UserIds[requestIndex])) {
                    this.showAddFriendDialog(requesterNames[requestIndex], UserIds[requestIndex], false);
                    this.showNotification(requesterNames[requestIndex] + " muốn kết bạn với bạn.", (Image) null, 1);
                }
            }
        }
    }

    public void loadSecondaryContactsMode3(BuddyGroupList var1) {
        if (FriendScreen.currentViewMode == 3) {
            this.friendScreen.friendsRequestComponent.setContactData(var1, -1);
            this.friendScreen.friendsRequestComponent.isLoading = false;
        }
    }

    public void setBlockedUsers(long[] var1) {
        if (this.friendScreen != null && var1 != null) {
            FriendScreen.setVectorFromArray(var1, this.friendScreen.blockedUsers);
        }
    }

    public void loadSecondaryContactsMode2(BuddyGroupList var1) {
        if (FriendScreen.currentViewMode == 2) {
            this.friendScreen.friendsRequestComponent.setContactData(var1, -1);
            this.friendScreen.friendsRequestComponent.isLoading = false;
        }
    }

    public void storeUserAndProcessInvite(long var1, String var3) {
        this.friendScreen.storeUserData(var1, var3);
        if (this.friendScreen.pendingInvitations.size() > 0) {
            this.friendScreen.processPendingInvitation(var1);
        }
    }

    public void openChatWithUser(long var1, String var3) {
        this.friendScreen.storeUserData(var1, var3);
        ChatScreen var4;
        (var4 = new ChatScreen(var3, false, null, null)).chatTitle = var3;
        var4.setChatId(var1);
        var4.startSlideAnimation(1);
        instance.addScreenToStack(var4);
        instance.switchToScreenByTitle(var4.title);
    }

    public void handleFriendAccepted(long var1, String var3, int var4, int var5) {
        if (this.friendScreen != null) {
            if (this.friendScreen.isUserBlocked(var1)) {
                this.friendScreen.removeFromBlockedAndRefresh(var1);
            } else {
                this.showNotification(UIUtils.concatStrings(var3, " đồng ý kết bạn với bạn.", null, null), (Image) null, 1);
            }

            BuddyInfo var10;
            (var10 = new BuddyInfo(var3, "", var4, "", new int[0], 0, 0, null)).contactId = var1;
            FriendScreen.addContactToList("Bạn Bè", var10, this.friendScreen.friendsComponent);
            saveBuddyList(this.friendScreen.friendsComponent.contactData, false, FriendScreen.username);
            this.friendScreen.addToOnlineList(var1);
            saveContactStatus(var5, false);
            if (this.friendScreen.isRequestPending(var1)) {
                this.friendScreen.removeFromPendingList(var1);
            }

            System.gc();
        }
    }

    public void removeFriend(long var1, int var3) {
        if (this.friendScreen != null) {
            String var4 = this.friendScreen.getUserNameById(var1);
            FriendScreen.removeContactFromList(var1, this.friendScreen.friendsComponent);
            this.friendScreen.removeFromOnlineList(var1);
            this.friendScreen.removeFromBlockedList(var1);
            if (this.friendScreen.onlineFriends.size() > 0) {
                saveBuddyList(this.friendScreen.friendsComponent.contactData, false, FriendScreen.username);
            } else {
                var3 = -1;
            }

            saveContactStatus(var3, false);
            if (var4 != null) {
                this.showNotification(UIUtils.concatStrings("Đã xóa ", var4, null, null), (Image) null, 1);
            }

            System.gc();
        }
    }

    public void blockUser(long userId, int dataSave) {
        if (this.friendScreen != null) {
            FriendScreen.removeContactFromList(userId, this.friendScreen.friendsComponent);
            this.friendScreen.removeFromOnlineList(userId);
            this.friendScreen.addToBlockedList(userId);
            if (this.friendScreen.onlineFriends.size() > 0) {
                saveBuddyList(this.friendScreen.friendsComponent.contactData, false, FriendScreen.username);
            } else {
                dataSave = -1;
            }

            this.showNotification("Đã chuyển ID vào danh sách đen.", (Image) null, 1);
            saveContactStatus(dataSave, false);
            System.gc();
        }
    }

    public void receiveMessage(long var1, String var3) {
        if (!this.friendScreen.isUserBlocked(var1)) {
            String var4;
            if ((var4 = this.friendScreen.getUserNameById(var1)) == null) {
                this.friendScreen.addPendingInvitation(var1, var3);
            } else {
                ChatScreen var5;
                (var5 = this.getOrCreateChatScreen(var4)).setChatId(var1);
                if (!var5.title.equals(this.currentScreen.title)) {
                    String var6 = FontRenderer.getFirstLineWrapped(var3, GameGraphics.screenWidth - GameGraphics.screenWidth / 3);
                    this.showNotification(UIUtils.concatStrings(var4, ": ", var6, ".."), (Image) null, 1);
                    var5.showInNavigation = true;
                    this.vibrate();
                    System.gc();
                }

                boolean var7 = var5.chatComponent.isNearBottom();
                var5.chatComponent.addPlayerMessage(var5.chatTitle, var3, 1);
                if (var7) {
                    var5.chatComponent.scrollToBottom();
                }

                var5.isActive = true;
            }
        }
    }

    public ChatScreen getOrCreateChatScreen(String var1) {
        ChatScreen var2;
        if ((var2 = (ChatScreen) this.setActiveScreen(var1)) == null) {
            (var2 = new ChatScreen(var1, false, null, null)).chatTitle = var1;
            var2.showInNavigation = true;
            this.addScreenToStack(var2);
        }

        return var2;
    }

    public void updateContactsStatus(long[] var1, String[] var2) {
        if (this.friendScreen != null) {
            this.friendScreen.updateContactsStatus(var1, var2);
        }
    }

    public void handleUserStatusChange(long var1, int var3) {
        if (this.friendScreen != null && this.friendScreen.friendsComponent.updateContactStatus(var1, var3)) {
            this.friendScreen.updateFavoriteStatus(var1, var3);
            int var4 = this.currentScreen instanceof ChatScreen ? 2 : 0;
            BuddyInfo var6;
            if ((var6 = this.friendScreen.friendsComponent.contactData.findDownloadFile(null, null, var1)) != null) {
                String var2 = UIUtils.concatStrings(var6.username, var3 == 1 ? " đã đăng nhập" : " đã thoát", null, null);
                this.showNotification(var2, var3 == 1 ? statusIcons[1] : statusIcons[0], var4);

                try {
                    ChatScreen var7;
                    if ((var7 = (ChatScreen) this.setActiveScreen(var6.username)) != null) {
                        var7.chatComponent.addSystemMessage(var2, var3 == 1 ? 1 : 2);
                        var7.chatComponent.scrollToBottom();
                    }
                } catch (Exception var5) {
                }
            }
        }
    }

    public void updateUserStatusMessage(long var1, String var3) {
        if (this.friendScreen != null && this.friendScreen.friendsComponent.updateContactSubtext(var1, var3)) {
            int var4 = this.currentScreen instanceof ChatScreen ? 2 : 0;
            BuddyInfo var5 = this.friendScreen.friendsComponent.contactData.findDownloadFile(null, null, var1);
            String var6 = FontRenderer.getFirstLineWrapped(var3, GameGraphics.screenWidth);
            this.showNotification(UIUtils.concatStrings(var5.username, ": ", var6, var3.equals(var6) ? null : ".."), statusIcons[1], var4);
            if (var1 == FriendScreen.currentUserAccountId) {
                FriendScreen.statusMessage = var3;
                Xuka.saveStringData(FriendScreen.username, var3, false);
            }
        }
    }

    public void addOfflineMessage(String var1, String var2) {
        this.friendScreen.addOfflineMessage(var1, var2);
    }

    public void showOfflineMessages(BuddyGroupList var1) {
        this.friendScreen.createOfflineMessageScreen(var1);
        this.friendScreen.offlineMessageScreen.startSlideAnimation(1);
        this.addScreenToStack(this.friendScreen.offlineMessageScreen);
        this.switchToScreen(this.friendScreen.offlineMessageScreen);
    }

    public void showChatWithMessages(String var1, Vector var2, long var3) {
        ChatScreen var6;
        (var6 = this.getOrCreateChatScreen(var1)).setChatId(var3);
        int var7 = 0;

        for (int var4 = var2.size(); var7 < var4; var7++) {
            String var5 = (String) var2.elementAt(var7);
            var6.chatComponent.addPlayerMessage(var6.chatTitle, var5, 1);
        }

        var6.chatComponent.scrollToBottom();
        var6.isActive = true;
        var6.startSlideAnimation(1);
        this.switchToScreen(var6);
    }

    public void handleChatRoomInvite(String roomName, String roomId, long accountId) {
        if (roomName.equals(this.currentChatRoom)) {
            this.switchToScreenByTitle(roomName);
        } else if (this.currentChatRoom != null) {
            this.showConfirmDialog("Bạn có muốn thoát phòng đang chat?", new ClickLeaveRoomAction(this, roomName, roomId, accountId));
        } else {
            this.joinChatRoom(roomName, roomId, accountId);
        }
    }

    public void joinChatRoom(String roomName, String roomId, long accountId) {
        if ((ChatRoomScreen) this.setActiveScreen(roomName) == null) {
            ChatRoomScreen var5 = new ChatRoomScreen(roomName, roomId, accountId == FriendScreen.currentUserAccountId);
            this.currentChatRoom = roomName;
            var5.startSlideAnimation(1);
            this.addScreenToStack((Screen) var5);
            this.switchToScreen(var5);
            this.removeScreen(this.findScreenById(910001));
        } else {
            this.switchToScreenByTitle(roomName);
        }
    }

    public void showChatRoomInviteDialog(String usernameInvite, String roomName, String var3, String var4) {
        String var5 = UIUtils.concatStrings(usernameInvite, " mời bạn", null, null);
        if (this.hasScreen(var5)) {
            this.setActiveScreen(var5).showInNavigation = true;
        } else {
            DialogScreen dialogScreen = new DialogScreen();
            dialogScreen.title = var5;
            dialogScreen.showInNavigation = true;
            usernameInvite = UIUtils.concatStrings(usernameInvite, " mời bạn tham gia phòng chat ", roomName, null);
            ButtonAction.createSimpleText(dialogScreen, usernameInvite);
            this.showNotification(usernameInvite, (Image) null, 1);
            dialogScreen.leftSoftkey = new ButtonAction("Đồng ý", new quyen_gh(this, var3, var4, dialogScreen));
            dialogScreen.rightSoftkey = new ButtonAction(TextConstant.close(), new quyen_gi(this, dialogScreen));
            UIUtils.focusComponent(dialogScreen, (UIComponent) dialogScreen.components.elementAt(0));
            this.addScreen(dialogScreen);
        }
    }

    public void receiveChatRoomMessage(String senderName, String messageContent, int messageType) {
        if (this.currentChatRoom != null) {
            try {
                ChatRoomScreen chatRoomScreen;
                if ((chatRoomScreen = (ChatRoomScreen) this.setActiveScreen(this.currentChatRoom)) != null) {
                    if (!chatRoomScreen.title.equals(this.currentScreen.title)) {
                        String truncatedMessage = FontRenderer.getFirstLineWrapped(messageContent, GameGraphics.screenWidth - GameGraphics.screenWidth / 3);
                        this.showNotification(UIUtils.concatStrings(senderName, ": ", truncatedMessage, ".."), (Image) null, 1);
                        chatRoomScreen.showInNavigation = true;
                        this.vibrate();
                        System.gc();
                    }

                    if (chatRoomScreen.showWelcomeMessage) {
                        chatRoomScreen.hideWelcomeAndShowChat();
                    }

                    boolean wasNearBottom = chatRoomScreen.chatComponent.isNearBottom();
                    chatRoomScreen.chatComponent.addPlayerMessage(senderName, messageContent, messageType != 3 ? (senderName.equals(FriendScreen.username) ? 0 : 1) : messageType);
                    if (wasNearBottom) {
                        chatRoomScreen.chatComponent.scrollToBottom();
                    }

                    chatRoomScreen.isActive = true;
                }
            } catch (Exception exception) {
            }
        }
    }

    public static void resetToLoginScreen(GameManager var0) {
        var0.resetToLoginScreen();
    }

    public static TextInputComponent getInputHandler(GameManager var0) {
        return var0.inputHandler;
    }

    public static void setInputHandler(GameManager var0, TextInputComponent var1) {
        var0.inputHandler = var1;
    }

    public static void initAndShowDownloadManager(GameManager var0) {
        if (var0.downloadManager == null) {
            var0.downloadManager = new DownloadScreen();
        }

        var0.showDownloadManager();
        var0.switchToScreen(var0.downloadManager);
    }

    public static ContextMenu getMainMenuList(GameManager var0) {
        return var0.mainMenuList;
    }

    public static ContextMenu getGameMenuList(GameManager var0) {
        return var0.gameMenuList;
    }

    public static void setUploadType(GameManager var0, byte var1) {
        var0.uploadType = var1;
    }

    public static byte getUploadType(GameManager var0) {
        return var0.uploadType;
    }

    public static void setUploadFileName(GameManager var0, String var1) {
        var0.uploadFileName = var1;
    }

    public static boolean isSendingFile(GameManager var0) {
        return var0.isFileSending;
    }

    public static String getUploadFileName(GameManager var0) {
        return var0.uploadFileName;
    }
}
