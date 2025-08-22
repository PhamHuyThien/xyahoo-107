import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class GameScreen extends Screen {
   public String roomOwner;
   public static boolean isInGame;
   public boolean isSpectating;
   private GameRoom[] gameRooms;
   private GameRoomGridComponent roomGridComponent;
   private int playerBaseX;
   private int playerBaseY;
   public static String currentRoomId = "";
   private String betDisplayText = "";
   public Object currentPlayerTurn;
   public boolean isGameStarted;
   public PlayerComponent[] playerComponents;
   public String[] playerNames;
   private TextInputComponent betInputComponent;
   public boolean isBettingMode;
   public TextInputComponent chatInputComponent;
   public boolean isChatMode;
   public int playerCount;
   public boolean[] playerReadyStates;
   public boolean[] playerActiveStates;
   public CardGameComponent cardGameComponent;
   private String[] numberStrings;
   private boolean isFirstMove;
   public boolean isGameActive;
   public String gameTitle;
   public boolean isGoldGame;
   public static GameScreen instance;
   byte gameResult;
   String[] resultPlayerNames;
   private String[] finalPlayerNames;
   byte[][] playerCards;
   public boolean canStartGame = true;
   public boolean gameFinished;
   public int finalPlayerCount;
   public String[] finalPlayerNames2;
   public long[] finalPlayerMoney;
   public int[] playerAvatarIds;
   public static int totalRooms;
   private UIComponent focusedComponent;
   public static String gameTypeId;
   private UIFactory kickPlayerButton;
   private Vector kickPlayerMenuItems;
   private ContextMenu kickPlayerMenu;
   private UIFactory profileButton;
   private Vector profileMenuItems;
   private ContextMenu profileMenu;
   private Vector lobbyMenuItems;
   private ContextMenu lobbyMenu;
   private UIFactory lobbyMenuButton;
   private Vector gameMenuItems;
   private ContextMenu gameMenu;
   private int statusIconY;
   private UIFactory emotionButton = new UIFactory("Biểu cảm", new quyen_da(this));
   private UIFactory chatButton = new UIFactory("Chat", new quyen_dl(this));
   private UIFactory selectAllCardsButton = new UIFactory("Chọn/hủy hết bài", new quyen_dr(this));
   private UIFactory betButton = new UIFactory("Đặt cược", new quyen_ds(this));
   public boolean isSpecialGameMode;
   public String specialModeText;
   private UIFactory continueButton;
   private UIFactory chatSendButton;
   private UIFactory chatModeButton;
   private UIFactory betSendButton;
   private UIFactory betModeButton;
   private UIFactory refreshButton = new UIFactory("Cập nhật", new quyen_dt(this));
   private UIFactory sendButton = new UIFactory(quyen_cr.c(), new quyen_du(this));
   private UIFactory quickPlayButton = new UIFactory("Chơi nhanh", new quyen_dv(this));

   public final void setBetAmount(long var1) {
      this.betDisplayText = UIUtils.concatStrings("Cược", ": ", UIUtils.formatNumberWithDots(var1), UIUtils.concatStrings(" ", this.isGoldGame ? "gold" : "xu", null, null));
   }

   public static GameScreen getInstance() {
      if (instance == null) {
         instance = new GameScreen();
      }

      return instance;
   }

   public final void removeMenuItem(String var1) {
      Vector var10000 = this.kickPlayerMenuItems;
      String var2 = var1;
      GameScreen var5 = this;
      byte var3 = 0;

      UIFactory var10001;
      while (true) {
         if (var3 >= var5.kickPlayerMenuItems.size()) {
            var10001 = null;
            break;
         }

         UIFactory var4;
         if ((var4 = (UIFactory)var5.kickPlayerMenuItems.elementAt(var3)).text.equals(var2)) {
            var10001 = var4;
            break;
         }

         var3++;
      }

      var10000.removeElement(var10001);
   }

   public GameScreen() {
      this.lobbyMenuItems = new Vector();
      this.lobbyMenu = new ContextMenu(this.lobbyMenuItems);
      this.lobbyMenuButton = new UIFactory("Menu", new quyen_dw(this));
      super.isAtBottom = true;
      GameManager.loadGameImages();
      this.isGoldGame = false;
   }

   public final void a(boolean var1, boolean var2) {
      CardGameComponent.isViewingOtherPlayers = var1;
      this.isSpectating = var1;
      int var3 = this.playerComponents.length;

      while (--var3 >= 0) {
         this.playerComponents[var3].isActive = var1;
         if (var2) {
            this.playerActiveStates[var3] = false;
            this.playerComponents[var3].setReady(false);
         }
      }
   }

   public final void render(Graphics var1) {
      super.render(var1);
      if (isInGame) {
         FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.betDisplayText, 5, Screen.screenY + 3, var1);
         int var2 = this.playerCount;

         while (--var2 >= 0) {
            if (this.playerComponents[var2].isActive) {
               switch (this.playerComponents[var2].gameState) {
                  case 1:
                     this.drawPlayerStatusIcon(var1, 0, 0, 36, 35, var2);
                     break;
                  case 2:
                     if (!this.isSpecialGameMode && this.playerCount != 2) {
                        this.drawPlayerStatusIcon(var1, 36, 0, 35, 35, var2);
                     } else {
                        this.drawPlayerStatusIcon(var1, 106, 0, 35, 35, var2);
                     }
                     break;
                  case 3:
                     if (!this.isSpecialGameMode && this.playerCount != 3) {
                        this.drawPlayerStatusIcon(var1, 71, 0, 35, 35, var2);
                     } else {
                        this.drawPlayerStatusIcon(var1, 106, 0, 35, 35, var2);
                     }
                     break;
                  case 4:
                     this.drawPlayerStatusIcon(var1, 106, 0, 35, 35, var2);
               }
            }

            if (this.playerComponents[var2].showChat) {
               this.playerComponents[var2].renderChat(var1);
            }
         }
      }
   }

   private void drawPlayerStatusIcon(Graphics var1, int var2, int var3, int var4, int var5, int var6) {
      if ((GameManager.instance.f >> 3) % 2 == 0) {
         this.statusIconY = this.playerComponents[var6].baseY - (this.playerComponents[var6].isVerticalLayout ? -10 : 4);
      } else {
         this.statusIconY = this.playerComponents[var6].baseY - (this.playerComponents[var6].isVerticalLayout ? -11 : 3);
      }

      var1.drawRegion(
         GameManager.avatarImage, var2, 0, var4, 35, 0, 0 + this.playerComponents[var6].baseX + (this.playerComponents[var6].isVerticalLayout ? (this.playerComponents[var6].position == 1 ? -50 : 21) : -31), Screen.screenY + this.statusIconY, 20
      );
   }

   public final boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      if (var3[0] > 32 && isInGame && !this.isBettingMode) {
         this.showChatInput();
      }

      return super.handleInput(var1, var2, var3);
   }

   public final void focusFirstComponent() {
   }

   public final void renderSpecialComponent(Graphics var1) {
   }

   public final void showRoomList(GameRoom[] var1, int var2) {
      totalRooms = var2;
      this.isChatMode = false;
      isInGame = false;
      this.canStartGame = true;
      if (var1 != null) {
         this.gameRooms = var1;
      }

      String var3 = this.gameTitle;
      this.gameTitle = var3;
      super.title = var3;
      UIUtils.setScreenSubtitleText(this, var3);
      this.adjustScroll();
      super.isScrollLocked = true;
      this.removeAllComponents();
      System.gc();
      if (this.roomGridComponent == null) {
         this.roomGridComponent = new GameRoomGridComponent(Screen.screenWidth - 3, Screen.screenHeight - 3 - GameManager.footerHeight, totalRooms);
      }

      this.roomGridComponent.setRoomData(this.gameRooms);
      this.addComponent(this.roomGridComponent);
      UIUtils.focusComponent(this, this.roomGridComponent);
      super.rightSoftkey = this.sendButton;
      this.lobbyMenuItems.removeAllElements();
      this.lobbyMenuItems.addElement(this.quickPlayButton);
      this.lobbyMenuItems.addElement(this.refreshButton);
      this.lobbyMenuItems.addElement(GameLobbyScreen.buyCoinsButton);
      super.leftSoftkey = this.lobbyMenuButton;
      System.gc();
   }

   public final void returnToLobby() {
      isInGame = false;
      this.showRoomList(null, totalRooms);
   }

   public static void requestRoomList() {
      quyen_a.e(gameTypeId);
   }

   public final void initializeGameRoom(byte var1, String[] var2, long[] var3, int[] var4) {
      isInGame = true;
      totalRooms = 0;
      this.removeAllComponents();
      this.canStartGame = true;
      this.playerComponents = null;
      System.gc();
      if (this.kickPlayerButton == null) {
         this.kickPlayerMenuItems = new Vector();
         this.kickPlayerMenu = new ContextMenu(this.kickPlayerMenuItems);
         this.kickPlayerButton = new UIFactory("Đá người chơi", null);
         this.kickPlayerButton.parentContainer = this.kickPlayerMenu;
      }

      this.playerComponents = new PlayerComponent[var1];
      this.playerCount = var1;
      this.playerAvatarIds = var4;
      boolean var5 = false;
      byte[] var6 = new byte[var1];
      byte var7 = 0;
      byte var8 = 0;

      for (byte var9 = 0; var9 < var1; var9++) {
         if (FriendScreen.currentUserId.equals(var2[var9])) {
            var7 = var9;
            break;
         }
      }

      for (byte var12 = 0; var12 < var1; var12++) {
         var6[var12] = var7;
         if (var7 == var1 - 1) {
            var7 = 0;
         } else {
            var7++;
         }

         var8 = var6[var12];
         if (var2[var8] != null) {
            this.playerComponents[var12] = new PlayerComponent(var2[var8], var3[var8], var12, var2[var8].equals(this.roomOwner));
            this.playerComponents[var12].setReady(this.playerActiveStates[var8]);
            this.playerComponents[var12].avatarId = new Integer(var4[var8]);
            CardInfo var11;
            if ((var11 = GameManager.instance.a(var2[var8], 0)) != null) {
               this.playerComponents[var12].setCardInfo(var11);
            }
         }

         if (FriendScreen.currentUserId.equals(this.playerComponents[var12].playerName)) {
            this.playerBaseX = this.playerComponents[var12].baseX;
            this.playerBaseY = this.playerComponents[var12].baseY;
            var5 = this.playerComponents[var12].isReady();
         }

         if (this.playerComponents[var12] != null) {
            this.addComponent(this.playerComponents[var12]);
         }
      }

      this.initGameMenu();
      this.gameMenuItems.addElement(this.emotionButton);
      this.gameMenuItems.addElement(this.chatButton);
      if (FriendScreen.currentUserId.equals(this.roomOwner)) {
         this.gameMenuItems.addElement(this.betButton);
      }

      this.gameMenuItems.addElement(GameLobbyScreen.buyCoinsButton);
      if (FriendScreen.currentUserId.equals(this.roomOwner) && this.playerComponents.length > 1) {
         this.kickPlayerMenuItems.removeAllElements();
         System.gc();

         for (byte var13 = 0; var13 < this.playerComponents.length; var13++) {
            if (!FriendScreen.currentUserId.equals(this.playerComponents[var13].playerName)) {
               this.kickPlayerMenuItems.addElement(new UIFactory(this.playerComponents[var13].playerName, new quyen_dx(this, var13)));
            }
         }

         this.gameMenuItems.addElement(this.kickPlayerButton);
      }

      this.initProfileMenu();
      this.gameMenuItems.addElement(new UIFactory("Rời bàn", new quyen_db(this)));
      super.leftSoftkey = new UIFactory("Menu", new quyen_dc(this));
      super.rightSoftkey = null;
      if (super.centerSoftkey == null) {
         super.centerSoftkey = new UIFactory("", new quyen_dd(this));
      }

      if (FriendScreen.currentUserId.equals(this.roomOwner)) {
         super.centerSoftkey.text = "Chơi ngay!";
      } else if (!var5) {
         super.centerSoftkey.text = "Sẵn sàng";
      }

      if (!this.isBettingMode && this.betInputComponent == null) {
         System.gc();
         this.betInputComponent = new TextInputComponent("", 1);
         this.betInputComponent.setBounds(0, Screen.screenHeight - GameManager.footerHeight - (FontRenderer.fontHeight << 1) - 10, Screen.screenWidth - 1, FontRenderer.fontHeight + 6);
         this.betInputComponent.id = 2222;
         this.betInputComponent.leftSoftKey = GameManager.createCloseButton();
         if (this.betSendButton == null) {
            this.betSendButton = new UIFactory(quyen_cr.c(), new quyen_do(this));
         }

         this.betInputComponent.rightSoftKey = this.betSendButton;
         this.betInputComponent.onCompleteAction = new quyen_dp(this);
         if (this.betModeButton == null) {
            this.betModeButton = new UIFactory("Cược", new quyen_dq(this));
         }

         this.betInputComponent.middleSoftKey = this.betModeButton;
      }

      this.initChatInput();
      this.focusedComponent = this.playerComponents[0];
      if (this.isChatMode) {
         this.showChatInput();
      } else if (this.isBettingMode) {
         this.showBetInput();
      } else {
         UIUtils.focusComponent(this, this.focusedComponent);
      }

      this.adjustScroll();
      System.gc();
   }

   private void showChatInput() {
      if (!super.components.contains(this.chatInputComponent)) {
         this.addComponent(this.chatInputComponent);
      }

      UIUtils.focusComponent(this, (UIComponent)this.chatInputComponent);
      this.isChatMode = true;
   }

   private void showBetInput() {
      if (!super.components.contains(this.betInputComponent)) {
         this.addComponent(this.betInputComponent);
      }

      UIUtils.focusComponent(this, (UIComponent)this.betInputComponent);
      this.isBettingMode = true;
      this.adjustScroll();
   }

   private void adjustScroll() {
      super.targetScrollY = -Screen.screenY + 2;
   }

   public final String getNumberString(int var1) {
      if (this.numberStrings == null) {
         this.numberStrings = new String[]{
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "25",
            "26",
            "27",
            "28",
            "29",
            "30"
         };
      }

      return var1 < instance.numberStrings.length && var1 >= 0 ? instance.numberStrings[var1] : Integer.toString(var1);
   }

   public final void startCardGame(byte[] var1, String var2, boolean var3, boolean var4) {
      super.needsUpdate = true;
      System.gc();
      if (this.cardGameComponent == null) {
         this.cardGameComponent = new CardGameComponent();
      }

      this.cardGameComponent.initializeHand(var1);
      CardGameComponent.isAnimating = var4;
      this.cardGameComponent.currentPlayer = var2;
      this.currentPlayerTurn = var2;
      if (FriendScreen.currentUserId.equals(var2)) {
         this.isFirstMove = var3;
         this.cardGameComponent.isFirstMove = var3;
      }

      this.cardGameComponent.isWaiting = true;
      this.cardGameComponent.gameEnded = false;
      this.gameFinished = false;
      this.canStartGame = false;
      this.isGameActive = false;
      if (this.cardGameComponent != null) {
         this.cardGameComponent.isFirstMove = this.isFirstMove;
         this.addComponent(this.cardGameComponent);
         UIUtils.focusComponent(this, this.cardGameComponent);
      }

      System.gc();
      super.rightSoftkey = new UIFactory("Bỏ lượt", new quyen_df(this));
      this.focusedComponent = this.cardGameComponent;
      this.initChatInput();
      this.initGameMenu();
      this.gameMenuItems.addElement(this.emotionButton);
      this.gameMenuItems.addElement(this.chatButton);
      this.gameMenuItems.addElement(this.selectAllCardsButton);
      this.gameMenuItems.addElement(GameLobbyScreen.buyCoinsButton);
      this.initProfileMenu();
      this.gameMenuItems.addElement(new UIFactory("Rời bàn", new quyen_dg(this)));
      super.leftSoftkey = new UIFactory("Menu", new quyen_di(this));
      System.gc();
      if (this.isChatMode) {
         this.removeComponent(this.chatInputComponent);
         this.showChatInput();
      }

      this.adjustScroll();

      for (int var5 = 0; var5 < instance.playerCount; var5++) {
         if (instance.playerComponents[var5].playerName != null && instance.playerComponents[var5].playerName.equals(var2)) {
            instance.playerComponents[var5].startTurn(30);
            return;
         }
      }
   }

   private void initGameMenu() {
      if (this.gameMenuItems == null) {
         this.gameMenuItems = new Vector();
         this.gameMenu = new ContextMenu(this.gameMenuItems);
      } else {
         this.gameMenuItems.removeAllElements();
      }

      System.gc();
   }

   private void initProfileMenu() {
      if (this.profileButton == null) {
         this.profileMenuItems = new Vector();
         this.profileMenu = new ContextMenu(this.profileMenuItems);
         this.profileButton = new UIFactory("Hồ sơ", null);
         this.profileButton.parentContainer = this.profileMenu;
      }

      if (this.playerComponents.length > 1) {
         this.profileMenuItems.removeAllElements();
         System.gc();

         for (byte var1 = 0; var1 < this.playerComponents.length; var1++) {
            if (!FriendScreen.currentUserId.equals(this.playerComponents[var1].playerName) && GameManager.instance.friendManager.findContactById(this.playerComponents[var1].playerName) == null) {
               this.profileMenuItems.addElement(new UIFactory(this.playerComponents[var1].playerName, new quyen_de(this, var1)));
            }
         }

         if (this.profileMenuItems.size() > 0) {
            this.gameMenuItems.addElement(this.profileButton);
         }
      }
   }

   public final void exitGame(boolean var1) {
      this.returnToLobby();
      this.startSlideAnimation(var1 ? -1 : 1);
      quyen_a.a(totalRooms, currentRoomId, FriendScreen.currentUserId, this.isGameStarted);
   }

   public final void handlePlayerMove(String var1, int var2, byte[] var3, String var4, boolean var5) {
      super.needsUpdate = true;
      this.isGameActive = true;
      this.currentPlayerTurn = var4;
      PlayerComponent var6 = null;

      for (byte var7 = 0; var7 < this.playerCount; var7++) {
         if (this.playerComponents[var7].playerName != null && this.playerComponents[var7].playerName.equals(var1)) {
            var6 = this.playerComponents[var7];
         }
      }

      if (this.cardGameComponent != null && var6 != null) {
         this.cardGameComponent.isWaiting = var5;
         this.cardGameComponent.currentPlayer = var4;
         this.cardGameComponent.lastMoveType = var2;
         this.cardGameComponent.isFirstMove = false;
         this.cardGameComponent.moveSentThisTurn = false;
         if (this.cardGameComponent.isWaiting) {
            this.cardGameComponent.gameEnded = false;

            for (int var8 = 0; var8 < instance.playerCount; var8++) {
               this.playerComponents[var8].showButton = false;
            }
         } else {
            var6.showButton = false;
         }

         this.cardGameComponent.startMoveAnimation(var3, var6.position == 1 ? Screen.screenWidth - var3.length * 14 - 35 : var6.baseX, var6.position == 1 ? (Screen.screenHeight >> 1) - 5 : var6.baseY);

         for (byte var9 = 0; var9 < this.playerCount; var9++) {
            if (this.playerComponents[var9].playerName != null) {
               if (this.playerComponents[var9].playerName.equals(this.currentPlayerTurn)) {
                  this.playerComponents[var9].startTurn(30);
               } else {
                  this.playerComponents[var9].isPlayerTurn = false;
               }
            }
         }
      }
   }

   public final void updatePlayerTurn(String var1, String var2, boolean var3) {
      super.needsUpdate = true;
      this.cardGameComponent.isWaiting = var3;
      this.cardGameComponent.currentPlayer = var2;
      this.currentPlayerTurn = var2;
      if (this.cardGameComponent.isFirstMove) {
         this.cardGameComponent.isFirstMove = false;
      }

      if (this.cardGameComponent.isWaiting) {
         this.cardGameComponent.gameEnded = false;
         this.cardGameComponent.animationCards = null;
         this.cardGameComponent.oldAnimationCards = null;

         for (byte var4 = 0; var4 < this.playerCount; var4++) {
            this.playerComponents[var4].showButton = false;
         }
      } else {
         for (byte var5 = 0; var5 < this.playerCount; var5++) {
            if (this.playerComponents[var5].playerName.equals(var1)) {
               this.playerComponents[var5].showButton = true;
               break;
            }
         }
      }

      for (byte var6 = 0; var6 < this.playerCount; var6++) {
         if (this.playerComponents[var6].playerName.equals(var1)) {
            this.playerComponents[var6].isPlayerTurn = false;
         } else if (this.playerComponents[var6].playerName.equals(var2)) {
            this.playerComponents[var6].startTurn(30);
         }
      }
   }

   public final void handleGameResult(String var1, byte var2, String[] var3, long[] var4, long[] var5, byte var6, String[] var7, byte[][] var8, int[] var9, CardInfo[] var10) {
      if (currentRoomId.equals(var1)) {
         this.gameResult = var2;
         this.resultPlayerNames = var3;
         this.finalPlayerNames = var7;

         for (byte var11 = 0; var11 < this.playerCount; var11++) {
            if (this.playerComponents[var11] != null) {
               this.playerComponents[var11].isPlayerTurn = false;

               for (byte var12 = 0; var12 < var3.length; var12++) {
                  if (this.playerComponents[var11].playerName.equals(var3[var12])) {
                     this.playerComponents[var11].setMoney(var5[var12]);
                     this.playerComponents[var11].gameState = var9[var12];
                     this.playerComponents[var11].timestamp = var4[var12];
                     this.playerComponents[var11].setCardInfo(var10[var12]);
                     break;
                  }
               }
            }
         }

         this.isGameStarted = false;
         if (var1.equals(var1)) {
            this.playerCards = var8;
            if (this.cardGameComponent != null) {
               this.cardGameComponent.setupOtherPlayersView();
            }
         }
      }
   }

   public final void showContinueButton() {
      super.centerSoftkey.text = "";
      if (this.continueButton == null) {
         this.continueButton = new UIFactory("Chơi tiếp", new quyen_dj(this));
      }

      super.rightSoftkey = this.continueButton;
      super.needsUpdate = true;
   }

   public final void prepareFinalResults() {
      Vector var1 = new Vector();

      for (int var2 = 0; var2 < this.playerReadyStates.length; var2++) {
         if (!this.playerReadyStates[var2]) {
            var1.addElement(this.finalPlayerNames[var2]);
         }
      }

      String[] var4 = new String[var1.size()];
      var1.copyInto(var4);
      this.playerComponents = GameManager.a(var4);
      this.finalPlayerCount = var4.length;

      for (int var3 = 0; var3 < var4.length; var3++) {
         this.finalPlayerNames2[var3] = this.playerComponents[var3].playerName;
         this.finalPlayerMoney[var3] = this.playerComponents[var3].getMoney();
         this.playerAvatarIds[var3] = this.playerComponents[var3].avatarId.intValue();
      }

      System.gc();
   }

   public final void updateTurnWithHidden(String var1, String var2, boolean var3) {
      this.cardGameComponent.currentPlayer = var2;
      this.cardGameComponent.isWaiting = var3;
      instance.currentPlayerTurn = var2;
      if (this.cardGameComponent.isWaiting) {
         this.cardGameComponent.gameEnded = false;
         this.cardGameComponent.animationCards = null;
         this.cardGameComponent.oldAnimationCards = null;
      }

      if (this.playerComponents != null) {
         for (int var4 = 0; var4 < this.playerComponents.length; var4++) {
            if (this.playerComponents[var4] != null) {
               this.playerComponents[var4].showButton = false;
               if (!this.cardGameComponent.isFirstMove && this.playerComponents[var4].playerName.equals(var2)) {
                  this.playerComponents[var4].startTurn(30);
               }
            }
         }

         for (byte var5 = 0; var5 < this.playerComponents.length; var5++) {
            if (this.playerComponents[var5].playerName.equals(var1)) {
               this.playerComponents[var5].isHidden = true;
            }
         }
      }
   }

   private void initChatInput() {
      if (!this.isChatMode && this.chatInputComponent == null) {
         System.gc();
         this.chatInputComponent = new TextInputComponent("", 0);
         this.chatInputComponent.setBounds(0, Screen.screenHeight - GameManager.footerHeight - (FontRenderer.fontHeight << 1) - 10, Screen.screenWidth - 1, FontRenderer.fontHeight + 6);
         this.chatInputComponent.id = 1111;
         this.chatInputComponent.leftSoftKey = GameManager.createCloseButton();
         if (this.chatSendButton == null) {
            this.chatSendButton = new UIFactory(quyen_cr.c(), new quyen_dk(this));
         }

         this.chatInputComponent.rightSoftKey = this.chatSendButton;
         this.chatInputComponent.onCompleteAction = new quyen_dm(this);
         if (this.chatModeButton == null) {
            this.chatModeButton = new UIFactory("Chat", new quyen_dn(this));
         }

         this.chatInputComponent.middleSoftKey = this.chatModeButton;
      }
   }

   static void showChatInput(GameScreen var0) {
      var0.showChatInput();
   }

   static void showBetInput(GameScreen var0) {
      var0.showBetInput();
   }

   static ContextMenu getLobbyMenu(GameScreen var0) {
      return var0.lobbyMenu;
   }

   static ContextMenu getGameMenu(GameScreen var0) {
      return var0.gameMenu;
   }

   static UIComponent getFocusedComponent(GameScreen var0) {
      return var0.focusedComponent;
   }

   static void adjustScroll(GameScreen var0) {
      var0.adjustScroll();
   }

   static UIFactory getChatSendButton(GameScreen var0) {
      return var0.chatSendButton;
   }

   static TextInputComponent getBetInputComponent(GameScreen var0) {
      return var0.betInputComponent;
   }

   static UIFactory getBetSendButton(GameScreen var0) {
      return var0.betSendButton;
   }
}
