import javax.microedition.lcdui.Graphics;

public final class TextLinkComponent extends UIComponent {
   public String linkText;
   public Integer textColor;
   private int clickDelay;
   private int textWidth;
   public Action linkAction;
   private boolean needsScrolling;
   private boolean scrollingLeft;
   private int scrollX;
   private int scrollCounter;
   private int maxWidth;
   private int renderX;

   public TextLinkComponent() {
   }

   public TextLinkComponent(String var1, int var2, int var3, int var4) {
      this.clickDelay = 0;
      this.linkText = var1;
      this.textColor = FontRenderer.COLOR_BROWN;
      this.textWidth = FontRenderer.getTextWidth(var1);
      super.posX = var2;
      super.posY = var3;
      super.width = this.textWidth;
      super.height = var4;
      super.middleSoftKey = new UIFactory("Chọn", null);
   }

   public final boolean handleKeyPress(int var1) {
      if (var1 == 16) {
         this.clickDelay = 2;
         return false;
      } else {
         return true;
      }
   }

   public final void handlePointerPress(int var1, int var2) {
      if (this.isFocused()) {
         if (this.linkAction != null) {
            this.linkAction.action();
            return;
         }
      } else {
         UIUtils.focusComponent(super.parentScreen, this);
      }
   }

   public final void render(Graphics var1) {
      boolean var2;
      if (var2 = this.isFocused()) {
         var1.setClip(super.posX - 2, super.posY - 2, super.width + 11, super.height + 10);
         var1.setColor(66826);
         var1.fillRoundRect(super.posX - 1, super.posY - 1, super.width + 7, super.height + 1, 8, 8);
         if (this.maxWidth == 0) {
            this.scrollX = super.posX;
            this.maxWidth = Screen.screenWidth - super.posX;
            if (super.posX + super.width > Screen.screenWidth) {
               this.needsScrolling = this.scrollingLeft = true;
            }
         }

         if (this.needsScrolling && this.scrollCounter++ > 20) {
            this.scrollCounter = 21;
            if (this.scrollingLeft) {
               if (this.scrollX > -(this.textWidth - this.maxWidth) + super.posX - 10) {
                  this.scrollX--;
               } else {
                  this.scrollCounter = 10;
                  this.scrollingLeft = false;
               }
            } else if (this.scrollX < super.posX) {
               this.scrollX++;
            } else {
               this.scrollCounter = 10;
               this.scrollingLeft = true;
            }
         }
      } else {
         this.scrollCounter = 0;
         this.scrollX = super.posX;
      }

      this.renderX = this.scrollX + 2;
      FontRenderer.getFontInstance(this.textColor).drawText(this.linkText, this.renderX, super.posY, var1);
      if (var2) {
         var1.setColor(8111862);
         var1.fillRect(this.renderX, super.posY + FontRenderer.fontHeight, this.textWidth + 2, 1);
      }
   }

   public final void setLinkAction(Action var1) {
      this.linkAction = var1;
      super.middleSoftKey.action = new quyen_cg(this);
   }

   public final void update() {
      if (this.clickDelay > 0) {
         this.clickDelay--;
         if (this.clickDelay == 0 && this.linkAction != null) {
            this.linkAction.action();
         }
      }
   }

   public final boolean handleDirectKeyPress(int var1) {
      return true;
   }
}
