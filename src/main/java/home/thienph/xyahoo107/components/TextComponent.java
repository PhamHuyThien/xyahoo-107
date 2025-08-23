package home.thienph.xyahoo107.components;

import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Graphics;

public final class TextComponent extends UIComponent {
   public String text;
   private boolean hasEmoticons;
   public Integer textColor = FontRenderer.COLOR_WHITE;
   private int textLength;
   private boolean isHidden;
   public boolean enableScrolling;
   private boolean isScrolling;
   private boolean scrollDirection;
   private int currentX;
   private int scrollTimer;
   private int availableWidth;
   private int totalTextWidth;
   public boolean forceScroll;

   public TextComponent() {
      this.isHidden = true;
   }

   private TextComponent(String var1) {
      super.isVisible = false;
      this.setText(var1);
   }

   private void setText(String var1) {
      this.text = FontRenderer.replaceEmoticons(var1, false);
      if (this.text == null) {
         this.hasEmoticons = false;
         this.text = var1;
      } else {
         this.hasEmoticons = true;
      }

      this.textLength = this.text.length();
   }

   public final void updateText(String var1) {
      this.setText(var1);
      this.calculateDimensions();
   }

   private void calculateDimensions() {
      super.width = FontRenderer.getTextWidth(this.text);
      int var1 = FontRenderer.emoticonReplaceCount * 18;
      this.totalTextWidth = FontRenderer.getTextWidth(this.text) + var1;
      super.width += var1;
   }

   public TextComponent(String var1, int var2, int var3, int var4, int var5) {
      this(var1);
      super.posX = var2;
      super.posY = var3;
      super.height = var4;
      super.selectedIndex = var5;
      this.textLength = this.text.length();
      this.calculateDimensions();
   }

   public TextComponent(String var1, int var2, int var3, int var4) {
      this(var1, var2, var3, var4, -1);
      this.calculateDimensions();
   }

   public final boolean handleKeyPress(int var1) {
      return true;
   }

   private void updateScrolling() {
      if (this.availableWidth == 0) {
         this.currentX = super.posX;
         this.availableWidth = Screen.screenWidth - super.posX;
         if (super.posX + super.width > Screen.screenWidth) {
            this.isScrolling = this.scrollDirection = true;
         }
      }

      if (this.isScrolling && this.scrollTimer++ > 20) {
         this.scrollTimer = 21;
         if (this.scrollDirection) {
            if (this.currentX > -(this.totalTextWidth - this.availableWidth) + super.posX - 10) {
               this.currentX--;
               return;
            }

            this.scrollTimer = 10;
            this.scrollDirection = false;
            return;
         }

         if (this.currentX < super.posX) {
            this.currentX++;
            return;
         }

         this.scrollTimer = 10;
         this.scrollDirection = true;
      }
   }

   private void renderBackground(Graphics var1, boolean var2) {
      if (var2) {
         ButtonComponent.drawButtonBackground(var1, super.posX - 3, super.posY - 2, super.width + 9, super.height + 2);
      }

      if (this.enableScrolling) {
         if (this.forceScroll) {
            this.updateScrolling();
            return;
         }

         if (var2) {
            this.updateScrolling();
            return;
         }

         this.scrollTimer = 0;
      }

      this.currentX = super.posX;
   }

   public final void render(Graphics var1) {
      if (!this.isHidden) {
         boolean var2 = this.isFocused();
         if (this.enableScrolling && (var2 || this.forceScroll)) {
            var1.setClip(super.posX - 3, super.posY - 2, super.width + 10, super.height + 10);
         }

         if (!this.hasEmoticons) {
            this.renderBackground(var1, var2);
            this.drawText(var1, this.text, this.currentX + 2, super.posY);
         }

         if (this.textLength == 0) {
            var1.setColor(11320516);
            var1.fillRect(super.posX, super.posY + (super.height >> 1), super.width, 1);
         } else if (this.hasEmoticons) {
            this.renderBackground(var1, var2);
            String var7 = "";
            int var3 = 0;
            int var4 = super.posY;

            for (int var5 = 0; var5 < this.textLength; var5++) {
               char var6;
               if ((var6 = this.text.charAt(var5)) >= 30000) {
                  this.drawText(var1, var7, this.currentX + 2 + var3, var4);
                  var3 += FontRenderer.getTextWidth(var7);
                  var7 = "";
                  var6 -= 30000;
                  var1.drawRegion(GameManager.gameIcons, var6 * 18, 0, 18, 18, 0, this.currentX + 2 + var3 + 10, super.posY + (FontRenderer.fontHeight >> 1), 3);
                  var3 += 20;
               } else {
                  var7 = var7 + var6;
               }
            }

            this.drawText(var1, var7, this.currentX + 2 + var3, var4);
         }
      }
   }

   private void drawText(Graphics var1, String var2, int var3, int var4) {
      FontRenderer.getFontInstance(this.textColor).drawText(var2, var3, var4, var1);
   }

   public final void handlePointerPress(int var1, int var2) {
      if (super.isVisible) {
         UIUtils.focusComponent(super.parentScreen, this);
      }
   }

   public final void update() {
   }

   public final boolean handleDirectKeyPress(int var1) {
      return true;
   }
}
