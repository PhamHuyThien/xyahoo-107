import java.util.Date;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class ChatComponent extends UIComponent {
   private int targetScrollY;
   private int scrollVelocity;
   private int scrollMomentum;
   private int currentScrollY;
   private int maxScrollY;
   private Vector chatMessages;
   private int visibleLines;
   private int firstVisibleLine;
   private int selectedLine = -1;
   private int wrappedLineCount;
   private int lineLength;
   private int totalLines;
   private Integer currentTextColor;
   private String textSegment;
   private int segmentStartIndex;
   private int renderX;
   private int animationCounter;
   private boolean isDragging;
   private int lastTouchX;
   private int lastTouchY;

   static {
      new Date();
   }

   public final boolean isNearBottom() {
      return this.currentScrollY > this.maxScrollY - 50;
   }

   public ChatComponent(int var1, int var2, int var3, int var4) {
      super(0, 0, var3, var4, true);
      super.isFocused = true;
      super.isVisible = false;
      this.visibleLines = var4 / FontRenderer.lineHeight + 2;
      this.chatMessages = new Vector();
      super.middleSoftKey = new UIFactory("Chat", null);
   }

   public final void addSystemMessage(String var1, int var2) {
      int var3;
      while ((var3 = var1.indexOf("http://")) > 0 || (var3 = var1.indexOf("vtp://")) > 0) {
         this.addSystemMessage(var1.substring(0, var3), var2);
         if ((var3 = (var1 = var1.substring(var3)).indexOf(" ")) == -1) {
            break;
         }

         this.addSystemMessage(var1.substring(0, var3), var2);
         var1 = var1.substring(var3);
      }

      if (!var1.startsWith("http://") && !var1.startsWith("vtp://")) {
         String[] var8 = FontRenderer.wrapTextToLines(var1, super.width - 100);
         this.wrappedLineCount = var8.length;

         for (int var5 = 0; var5 < this.wrappedLineCount; var5++) {
            var8[var5] = (char)(var2 + 31000) + var8[var5];
         }

         for (int var6 = 0; var6 < this.wrappedLineCount; var6++) {
            if (var8[var6].length() > 0) {
               this.chatMessages.addElement(var8[var6]);
            }
         }

         this.updateScrollBounds();
      } else {
         var1 = "祼" + var1;
         this.chatMessages.addElement(var1);
         this.updateScrollBounds();
      }
   }

   public final void addPlayerMessage(String var1, String var2, int var3) {
      var1 = FontRenderer.truncateText(var1, 16);
      if ((var2 = TextValidator.filterBadWords(var2)).startsWith("http")) {
         this.addPlayerMessage(var1, quyen_cr.d(), var3);
         var2 = "祼" + var2;
         this.chatMessages.addElement(var2);
         this.updateScrollBounds();
      } else {
         var2 = FontRenderer.replaceEmoticons(var2, true);
         String[] var5;
         if ((var5 = FontRenderer.wrapTextToLines(UIUtils.concatStrings(UIUtils.concatStrings(String.valueOf((char)(var3 + 31000)), var1, ": ", "紀"), var2, null, null), super.width - 8)) != null
            && var5.length > 0) {
            this.wrappedLineCount = var5.length;

            for (int var8 = 0; var8 < this.wrappedLineCount; var8++) {
               if (var5[var8].length() > 0) {
                  this.chatMessages.addElement(var5[var8]);
               }
            }

            this.updateScrollBounds();
         }
      }
   }

   private void updateScrollBounds() {
      this.totalLines = this.chatMessages.size();
      this.maxScrollY = (this.totalLines - this.visibleLines + 2) * FontRenderer.lineHeight + 8;
      this.onFocusGained();
   }

   public final boolean handleKeyPress(int var1) {
      if (var1 == 12) {
         if (this.selectedLine > 0) {
            this.selectedLine--;
         }

         this.targetScrollY = this.targetScrollY - FontRenderer.lineHeight;
         if (this.targetScrollY < -FontRenderer.lineHeight) {
            this.targetScrollY = -FontRenderer.lineHeight;
         }

         quyen_cq.a(true);
      } else if (var1 == 13) {
         if (this.selectedLine < this.totalLines - 1) {
            this.selectedLine++;
         }

         this.targetScrollY = this.targetScrollY + FontRenderer.lineHeight;
         if (this.targetScrollY > this.maxScrollY) {
            this.targetScrollY = this.maxScrollY;
         }

         quyen_cq.a(true);
      }

      return true;
   }

   public final boolean handleDirectKeyPress(int var1) {
      this.handleKeyPress(var1);
      return true;
   }

   public final void render(Graphics var1) {
      var1.setClip(super.posX, super.posY, super.width, super.height);
      var1.translate(0, -this.currentScrollY + 3);
      if (this.selectedLine != -1) {
         this.currentTextColor = FontRenderer.COLOR_WHITE;
         var1.setColor(66826);
         var1.fillRoundRect(3, this.selectedLine * FontRenderer.lineHeight, super.width - 6, FontRenderer.lineHeight, 5, 5);
      }

      this.wrappedLineCount = this.firstVisibleLine + this.visibleLines;

      for (int var2 = this.firstVisibleLine - 1; var2 < this.wrappedLineCount; var2++) {
         if (var2 >= 0) {
            if (var2 >= this.totalLines) {
               break;
            }

            String var3 = (String)this.chatMessages.elementAt(var2);
            this.lineLength = var3.length();
            if (this.lineLength != 0) {
               byte var4 = 0;
               this.currentTextColor = FontRenderer.COLOR_WHITE;
               int var5 = 0;
               if (var3.charAt(0) >= 31000) {
                  if ((var5 = var3.charAt(0) - 31000) == 0 || var5 == 100) {
                     this.currentTextColor = FontRenderer.COLOR_BROWN;
                  } else if (var5 == 3) {
                     this.currentTextColor = FontRenderer.COLOR_ORANGE;
                  } else if (var5 == 1 || var5 == 2) {
                     this.currentTextColor = FontRenderer.COLOR_WHITE;
                  }

                  var4 = 1;
               }

               this.renderX = 6;
               this.segmentStartIndex = 0;

               for (int var6 = var4; var6 < this.lineLength; var6++) {
                  char var8;
                  if ((var8 = var3.charAt(var6)) == 32000) {
                     this.textSegment = var3.substring(1, var6);
                     FontRenderer.getFontInstance(this.currentTextColor).drawText(this.textSegment, this.renderX, var2 * FontRenderer.lineHeight, var1);
                     this.renderX = this.renderX + FontRenderer.getTextWidth(this.textSegment);
                     this.currentTextColor = FontRenderer.COLOR_WHITE;
                     this.segmentStartIndex = var6;
                  } else if (var8 >= 30000) {
                     this.textSegment = var3.substring(this.segmentStartIndex, var6);
                     FontRenderer.getFontInstance(this.currentTextColor).drawText(this.textSegment, this.renderX, var2 * FontRenderer.lineHeight, var1);
                     this.renderX = this.renderX + FontRenderer.getTextWidth(this.textSegment);
                     var1.drawRegion(
                        GameManager.gameIcons, (var8 - 30000) * 18, 0, 18, 18, 0, this.renderX + 10, var2 * FontRenderer.lineHeight + (FontRenderer.lineHeight >> 1) + (this.animationCounter < 11 ? -1 : 0), 3
                     );
                     this.renderX += 20;
                     this.segmentStartIndex = var6;
                  }
               }

               FontRenderer.getFontInstance(this.currentTextColor).drawText(var3.substring(this.segmentStartIndex, this.lineLength), this.renderX, var2 * FontRenderer.lineHeight, var1);
            }
         }
      }

      var1.translate(0, this.currentScrollY - 3);
   }

   public final void update() {
      if (this.currentScrollY != this.targetScrollY) {
         this.scrollVelocity = this.targetScrollY - this.currentScrollY << 2;
         this.scrollMomentum = this.scrollMomentum + this.scrollVelocity;
         this.currentScrollY = this.currentScrollY + (this.scrollMomentum >> 3);
         this.scrollMomentum &= 15;
         if (this.currentScrollY > this.maxScrollY) {
            this.currentScrollY = this.maxScrollY;
         }

         if (this.currentScrollY < 0) {
            this.currentScrollY = 0;
         }

         this.firstVisibleLine = this.currentScrollY / FontRenderer.lineHeight - 1;
         if (this.firstVisibleLine < 0) {
            this.firstVisibleLine = 0;
         }
      }

      if (this.animationCounter++ > 21) {
         this.animationCounter = 0;
      }
   }

   public final void onFocusGained() {
      if (super.posY + this.totalLines * (FontRenderer.lineHeight + 2) >= super.height) {
         quyen_cq.a = true;
         quyen_cq.a(this.totalLines);
      } else {
         quyen_cq.a = false;
      }
   }

   public final void renderFocusIndicator(Graphics var1) {
      quyen_cq.a(var1, this.selectedLine);
   }

   public final void handlePointerRelease(int var1, int var2) {
      this.lastTouchX = var1;
      this.lastTouchY = var2;
   }

   public final void handlePointerPress(int var1, int var2) {
      if (this.isDragging) {
         this.isDragging = false;
         this.targetScrollY = this.targetScrollY - (var2 - this.lastTouchY << 3);
         if (this.targetScrollY < 0) {
            this.targetScrollY = 0;
         } else if (this.targetScrollY > this.maxScrollY) {
            this.targetScrollY = this.maxScrollY;
         }
      }

      quyen_cq.a(true);
   }

   public final void handlePointerDrag(int var1, int var2) {
      if (ContactListComponent.abs(var1 - this.lastTouchX) > 1 || ContactListComponent.abs(var2 - this.lastTouchY) > 1) {
         this.isDragging = true;
         this.targetScrollY = this.targetScrollY - (var2 - this.lastTouchY);
         if (this.targetScrollY < 0) {
            this.targetScrollY = 0;
         } else if (this.targetScrollY > this.maxScrollY) {
            this.targetScrollY = this.maxScrollY;
         }

         this.currentScrollY = this.targetScrollY;
         this.firstVisibleLine = this.currentScrollY / FontRenderer.lineHeight - 1;
         if (this.firstVisibleLine < 0) {
            this.firstVisibleLine = 0;
         }

         this.lastTouchX = var1;
         this.lastTouchY = var2;
      }

      quyen_cq.a(true);
   }

   public final void scrollToBottom() {
      this.firstVisibleLine = this.totalLines - this.visibleLines;
      this.selectedLine = this.totalLines - 1;
      this.targetScrollY = this.maxScrollY;
   }

   public final String getSelectedMessage() {
      return this.selectedLine == -1 ? "" : (String)this.chatMessages.elementAt(this.selectedLine);
   }

   public final String getFullSelectedMessage() {
      if (this.selectedLine == -1) {
         return "";
      } else {
         int var1 = this.selectedLine;
         int var2 = this.selectedLine;

         for (var1 = var1; ((String)this.chatMessages.elementAt(var2)).charAt(0) < 31000; var2--) {
            if (var2 <= 0) {
               var2 = 0;
               break;
            }
         }

         while (true) {
            if (((String)this.chatMessages.elementAt(var1)).charAt(0) >= 31000) {
               if (--var1 < 0) {
                  var1 = 0;
               }
               break;
            }

            if (var1 >= this.totalLines - 1) {
               var1 = this.totalLines - 1;
               break;
            }

            var1++;
         }

         if (var1 < var2) {
            var1 = var2;
         }

         String var3 = "";

         for (int var7 = var2; var7 <= var1; var7++) {
            var3 = var3 + (String)this.chatMessages.elementAt(var7) + " ";
         }

         for (int var8 = 0; var8 < var3.length(); var8++) {
            if (var3.charAt(var8) == 32000) {
               var3 = var3.substring(var8 + 1);
            }
         }

         try {
            for (int var9 = 0; var9 < var3.length(); var9++) {
               if (var3.charAt(var9) >= 30000) {
                  var3 = var3.substring(0, var9) + FontRenderer.emoticons[var3.charAt(var9) - 30000] + var3.substring(var9 + 1);
               }
            }
         } catch (Exception var4) {
         }

         return var3;
      }
   }
}
