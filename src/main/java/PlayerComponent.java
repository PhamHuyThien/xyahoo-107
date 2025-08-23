import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class PlayerComponent extends UIComponent {
   public String playerName;
   private CardInfo cardInfo;
   private int cardTextX;
   private int cardImageX;
   private int cardImageY;
   private long playerMoney;
   private String moneyText;
   private boolean isRoomOwner;
   private String statusText = "";
   public int baseX;
   public int baseY;
   private boolean isReady;
   public boolean isActive;
   public byte[] cardData;
   public boolean isHidden;
   public int position;
   public boolean showButton;
   private String shortName;
   public int gameState;
   public long timestamp;
   public boolean showCountdown;
   public byte countdownStart;
   public int countdownValue;
   private int moneyTextX;
   private int nameTextX;
   private int avatarX;
   private int avatarY;
   public Integer avatarId;
   private int textY;
   public boolean isVerticalLayout;
   private String timerText;
   private int statusTextX;
   private Image avatarImage;
   private String[] chatLines;
   private int chatBoxX;
   private int chatBoxY;
   private int chatBoxWidth;
   private int chatBoxHeight;
   public boolean showChat;
   private byte chatStartTime;
   private long turnDuration;
   boolean isPlayerTurn;
   private int remainingTime;
   private long turnStartTime;

   public final long getMoney() {
      return this.playerMoney;
   }

   public final void setMoney(long var1) {
      this.playerMoney = var1;
      this.moneyText = UIUtils.concatStrings(UIUtils.formatNumberWithDots(var1), " $", null, null);
   }

   public PlayerComponent() {
      new Vector();
      new Vector();
   }

   public PlayerComponent(String var1, long var2, int var4, boolean var5) {
      this.isRoomOwner = var5;
      if (var1 == null) {
         this.playerName = "";
      } else {
         this.playerName = var1;
      }

      this.setMoney(var2);
      this.position = var4;
      int var6 = 32 > FontRenderer.fontHeight << 1 ? 32 : FontRenderer.fontHeight << 1;
      int var7 = Screen.screenHeight - GameManager.headerHeight - 40 - var6 - 7;
      this.isVerticalLayout = var4 == 1 || var4 == 3;
      this.shortName = FontRenderer.truncateText(this.playerName, 9);
      if (!this.isVerticalLayout) {
         this.baseX = (Screen.screenWidth >> 1) - 20;
         this.baseY = var4 == 0 ? var7 : 5;
         this.statusTextX = this.nameTextX = this.moneyTextX = this.baseX + 4 + 40;
         this.avatarX = this.baseX;
         this.avatarY = this.baseY - 11;
      } else {
         this.baseY = (var7 >> 1) - 15;
         this.baseX = this.statusTextX = this.nameTextX = this.avatarX = this.moneyTextX = var4 == 1 ? Screen.screenWidth - 5 : 5;
         if (var4 == 1) {
            this.moneyTextX = this.baseX - FontRenderer.getTextWidth(this.moneyText);
            this.nameTextX = this.baseX - FontRenderer.getTextWidth(this.shortName);
            this.avatarX = this.baseX - 40;
         }

         this.avatarY = this.baseY - 4;
      }

      this.isRoomOwner = var5;
      this.statusText = "Chủ bàn";
      this.statusTextX = this.position == 1 ? this.baseX - FontRenderer.getTextWidth(this.statusText) : this.statusTextX;
   }

   public final void setCardInfo(CardInfo var1) {
      this.cardInfo = var1;
      this.cardImageX = this.avatarX + (this.position == 3 ? 56 : -16);
      if (this.isVerticalLayout) {
         this.cardTextX = this.position == 1 ? this.baseX - FontRenderer.getTextWidth(var1.levelText) : this.nameTextX;
      } else {
         this.cardTextX = this.nameTextX;
      }

      this.cardImageY = this.avatarY + 20;
   }

   public final void setReady(boolean var1) {
      this.isReady = var1;
      if (!this.isRoomOwner) {
         if (var1) {
            this.statusText = "Sẵn sàng";
            this.statusTextX = this.position == 1 ? this.baseX - FontRenderer.getTextWidth(this.statusText) : this.statusTextX;
            return;
         }

         this.statusText = null;
      }
   }

   public final boolean isReady() {
      return this.isReady;
   }

   public final void render(Graphics var1) {
      if (this.playerName != null && !this.isHidden) {
         this.avatarImage = ImageCache.getImage(this.avatarId);
         var1.drawImage(this.avatarImage, this.position == 1 ? this.baseX - this.avatarImage.getWidth() : this.avatarX, this.avatarY, 20);
         if (!GameScreen.instance.isGameStarted && this.statusText != null) {
            if (this.isVerticalLayout) {
               FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.statusText, this.statusTextX, this.avatarY - FontRenderer.fontHeight - 2, var1);
            } else {
               this.textY = this.baseY - 4 + FontRenderer.fontHeight;
               FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.statusText, this.statusTextX, this.textY + FontRenderer.fontHeight, var1);
            }
         }

         if (this.showButton) {
            Graphics var10000;
            Image var10001;
            int var10002;
            int var10003;
            if (this.isVerticalLayout) {
               var10000 = var1;
               var10001 = GameManager.buttonImage;
               var10002 = this.avatarX + 20;
               var10003 = this.avatarY - 11 - 4;
            } else {
               var10000 = var1;
               var10001 = GameManager.buttonImage;
               var10002 = this.avatarX + 20;
               var10003 = this.position == 0 ? this.avatarY - 11 - 4 : this.avatarY + 40 + 4;
            }

            var10000.drawImage(var10001, var10002, var10003, 17);
         }

         if (this.isVerticalLayout) {
            this.textY = this.baseY + 40;
            FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.shortName, this.nameTextX, this.textY, var1);
            if (this.cardInfo != null && this.cardInfo.levelText != null) {
               FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.cardInfo.levelText, this.cardTextX, this.textY + (FontRenderer.fontHeight << 1), var1);
            }

            FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(this.moneyText, this.moneyTextX, this.textY + FontRenderer.fontHeight, var1);
         } else {
            this.textY = this.baseY - 4 - FontRenderer.fontHeight;
            FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.shortName, this.nameTextX, this.textY, var1);
            if (this.cardInfo != null && this.cardInfo.levelText != null) {
               FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.cardInfo.levelText, this.cardTextX, this.textY + (FontRenderer.fontHeight << 1), var1);
            }

            FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(this.moneyText, this.moneyTextX, this.textY + FontRenderer.fontHeight, var1);
         }

         if (this.cardInfo != null && this.cardInfo.cardId.intValue() != -1) {
            var1.drawImage(ImageCache.getImage(this.cardInfo.cardId), this.cardImageX, this.cardImageY, 3);
         }

         if (this.showCountdown) {
            if (14 - (byte)((int)(System.currentTimeMillis() / 1000L - (long)this.countdownStart)) > 0) {
               UIUtils.drawGameIcon(var1, 1 + (this.position == 1 ? this.avatarX : this.baseX), this.baseY - (this.isVerticalLayout ? 22 : (this.position == 2 ? -25 : 33)), this.countdownValue);
            } else {
               this.showCountdown = false;
            }
         }

         if (this.isPlayerTurn && this.remainingTime >= 0) {
            GameScreen.instance.rightSoftkey.text = "";
            GameScreen.instance.centerSoftkey.text = "";
            if (this.isVerticalLayout) {
               FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(this.timerText, this.position == 1 ? this.baseX - 20 : this.avatarX, this.avatarY - FontRenderer.fontHeight - 4, var1);
               return;
            }

            if (this.position == 2) {
               FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(this.timerText, this.avatarX, this.avatarY + 40 + 4, var1);
               return;
            }

            GameScreen.instance.rightSoftkey.text = "Bỏ lượt";
            GameScreen.instance.centerSoftkey.text = "Đánh bài";
            FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(this.timerText, this.avatarX, this.avatarY - FontRenderer.fontHeight - 4, var1);
         }
      }
   }

   public final void showChatMessage(String var1) {
      this.chatLines = FontRenderer.wrapTextToLines(var1, Screen.screenWidth - 30);
      this.chatBoxWidth = 0;
      int var4 = 0;

      for (int var2 = this.chatLines.length; var4 < var2; var4++) {
         int var3 = FontRenderer.getTextWidth(this.chatLines[var4]) + 5;
         if (this.chatBoxWidth < var3) {
            this.chatBoxWidth = var3;
         }
      }

      this.chatBoxHeight = this.chatLines.length * FontRenderer.lineHeight;
      if (this.position == 0 || this.position == 2) {
         this.chatBoxX = (Screen.screenWidth - this.chatBoxWidth >> 1) - 9;
      } else if (this.position == 1) {
         this.chatBoxX = Screen.screenWidth - this.chatBoxWidth - 6;
      } else {
         this.chatBoxX = 11;
      }

      this.chatBoxY = this.baseY + (this.isVerticalLayout ? 21 : (this.position == 2 ? 84 : 15)) - this.chatBoxHeight;
      this.showChat = true;
      this.chatStartTime = (byte)((int)(System.currentTimeMillis() / 1000L));
   }

   public final void renderChat(Graphics var1) {
      if (10 - (byte)((int)(System.currentTimeMillis() / 1000L - (long)this.chatStartTime)) > 0) {
         UIUtils.drawTooltip(var1, this.chatBoxX, this.chatBoxY, this.chatBoxWidth, this.chatBoxHeight, this.chatLines, this.position);
      } else {
         this.showChat = false;
      }
   }

   public final void startTurn(int var1) {
      this.isPlayerTurn = true;
      this.turnDuration = 30L;
      this.turnStartTime = System.currentTimeMillis();
      this.timerText = "";
      UIUtils.markScreenForUpdate(this);
   }

   public final boolean handleKeyPress(int var1) {
      return true;
   }

   public final void update() {
      if (this.isPlayerTurn) {
         this.remainingTime = (int)(this.turnDuration - (System.currentTimeMillis() - this.turnStartTime) / 1000L);
         if (this.remainingTime <= 0) {
            this.isPlayerTurn = false;
            return;
         }

         this.timerText = GameScreen.instance.getNumberString(this.remainingTime);
      }
   }

   public final boolean handleDirectKeyPress(int var1) {
      return false;
   }
}
