import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class DialogBox {
   public UIFactory leftSoftkey;
   public UIFactory centerSoftkey;
   public UIFactory rightSoftkey;
   private String[] textLines;
   private boolean showLoading = false;
   private Vector dataVector;
   private int columnsCount;
   private int textAlignment;
   private int rowsCount;
   private String dialogTitle;
   private int textLinesCount;
   private int dialogX;
   private int contentY;
   private int contentWidth;
   private int contentHeight;
   private int textAreaHeight;
   private int dialogHeight;
   private int dialogWidth;
   private int dialogY;
   private int textStartY;
   private int centerSoftkeyX;
   private int rightSoftkeyX;

   public DialogBox(String var1, int var2, Vector var3, int var4, UIFactory var5, UIFactory var6, UIFactory var7) {
      this.dialogTitle = var1;
      this.dataVector = var3;
      this.columnsCount = var4;
      this.textAlignment = var2;
      this.rowsCount = var3.size();
      this.setSoftkeys(var5, var6, var7);
      this.calculateLayout();
   }

   public DialogBox(String var1, UIFactory var2, UIFactory var3, UIFactory var4) {
      this.textLines = FontRenderer.wrapTextToLines(var1, GameGraphics.screenWidth - 30);
      this.setSoftkeys(var2, var3, var4);
      this.calculateLayout();
   }

   public DialogBox(String[] var1, UIFactory var2, UIFactory var3, UIFactory var4) {
      this.textLines = var1;
      this.setSoftkeys(var2, var3, var4);
      this.calculateLayout();
   }

   private void setSoftkeys(UIFactory var1, UIFactory var2, UIFactory var3) {
      this.leftSoftkey = var1;
      this.rightSoftkey = var3;
      this.centerSoftkey = var2;
      if (this.centerSoftkey != null) {
         this.centerSoftkeyX = GameGraphics.screenWidth - FontRenderer.getTextWidth(this.centerSoftkey.text) >> 1;
      }

      if (this.rightSoftkey != null) {
         this.rightSoftkeyX = GameGraphics.screenWidth - FontRenderer.getTextWidth(this.rightSoftkey.text) - 4;
      }
   }

   public final void setLoadingVisible(boolean var1) {
      this.showLoading = var1;
      this.calculateLayout();
   }

   private void calculateLayout() {
      if (this.dataVector == null) {
         this.textLinesCount = this.textLines.length;
         this.textAreaHeight = this.textLinesCount * (FontRenderer.fontHeight + 2) + (this.showLoading ? 20 : 0);
         this.dialogHeight = this.textAreaHeight + (FontRenderer.fontHeight << 1) - 1;
         if (this.dialogHeight < 30) {
            this.dialogHeight = 30;
         }

         if (this.dialogHeight > GameGraphics.screenHeight - 35) {
            this.dialogHeight = this.textAreaHeight = GameGraphics.screenHeight - 35;
         }

         for (int var1 = 0; var1 < this.textLinesCount; var1++) {
            int var2 = FontRenderer.getTextWidth(this.textLines[var1]) + 10;
            if (this.dialogWidth < var2) {
               this.dialogWidth = var2;
            }
         }
      } else {
         for (int var4 = 0; var4 < this.rowsCount; var4++) {
            for (int var6 = 0; var6 < this.columnsCount; var6++) {
               int var3 = FontRenderer.getTextWidth(((String[])this.dataVector.elementAt(var4))[var6]) + 10;
               if (this.dialogWidth < var3) {
                  this.dialogWidth = var3;
               }
            }
         }

         this.dialogHeight = 0;
         if (this.dialogTitle != null) {
            this.dialogHeight = this.dialogHeight + FontRenderer.fontHeight + 11;
         }

         for (int var5 = 0; var5 < this.rowsCount; var5++) {
            for (int var7 = 0; var7 < this.columnsCount; var7++) {
               this.dialogHeight = this.dialogHeight + FontRenderer.fontHeight + 2;
            }

            this.dialogHeight += 12;
         }
      }

      this.dialogWidth += 60;
      if (this.dialogWidth < 100) {
         this.dialogWidth = 100;
      }

      if (this.dialogWidth > GameGraphics.screenWidth - 15) {
         this.dialogWidth = GameGraphics.screenWidth - 15;
      }

      this.dialogY = GameGraphics.screenHeight - this.dialogHeight >> 1;
      DialogBox var10000;
      int var10001;
      int var10002;
      if (this.dataVector == null) {
         var10000 = this;
         var10001 = this.dialogY + (this.dialogHeight - this.textAreaHeight >> 1);
         var10002 = 1;
      } else {
         var10000 = this;
         var10001 = this.dialogY;
         var10002 = this.dialogTitle != null ? 5 : 6;
      }

      var10000.textStartY = var10001 + var10002;
      this.contentY = this.dialogY + 1;
      this.contentWidth = this.dialogWidth - 2;
      this.contentHeight = this.dialogHeight - 2;
   }

   public final void render(Graphics var1) {
      this.dialogX = (GameGraphics.screenWidth - this.dialogWidth >> 1) + 1;
      var1.setClip(this.dialogX, this.contentY, this.contentWidth, this.contentHeight);
      int var2 = this.dialogWidth / 50 + 1;

      while (--var2 >= 0) {
         int var3 = this.dialogHeight / 50 + 1;

         while (--var3 >= 0) {
            var1.drawImage(GameManager.backgroundImage, this.dialogX + var2 * 50, this.contentY + var3 * 50, 0);
         }
      }

      if (this.dialogWidth > 110) {
         var1.drawRegion(GameManager.dialogBackground, 0, 0, 55, 20, 0, this.dialogX, this.contentY, 0);
         var1.drawRegion(GameManager.dialogBackground, 87, 0, 55, 20, 0, this.dialogX + this.contentWidth - 55, this.contentY, 0);
         var1.setClip(this.dialogX + 55, this.contentY, this.contentWidth - 110, 20);
         int var9 = (this.contentWidth - 110 >> 5) + 1;

         while (--var9 >= 0) {
            var1.drawRegion(GameManager.dialogBackground, 55, 0, 32, 20, 0, this.dialogX + 55 + var9 * 32, this.contentY, 0);
         }
      }

      var1.setClip(-1000, -1000, 5000, 5000);
      var1.setColor(14545919);
      ButtonComponent.drawRoundedBorder(var1, this.dialogX - 1, this.dialogY, this.dialogWidth - 1, this.dialogHeight - 1);
      var1.drawRect(this.dialogX - 1, this.dialogY, this.dialogWidth - 1, this.dialogHeight - 1);
      ButtonComponent.drawRoundedBorder(var1, this.dialogX - 2, this.dialogY - 1, this.dialogWidth + 1, this.dialogHeight + 1);
      var1.setClip(-1000, -1000, 5000, 5000);
      if (this.dataVector == null) {
         for (int var6 = 0; var6 < this.textLinesCount; var6++) {
            FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.textLines[var6], GameGraphics.screenWidth - FontRenderer.getTextWidth(this.textLines[var6]) >> 1, this.textStartY + var6 * (FontRenderer.fontHeight + 2), var1);
         }

         if (this.showLoading) {
            GameManager.instance.drawLoading(var1, TextRenderer.logoCenterX, this.textStartY + this.textLinesCount * FontRenderer.fontHeight + FontRenderer.fontHeight + 3);
         }
      } else {
         var1.setColor(11320516);
         if (this.dialogTitle != null) {
            FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.dialogTitle, GameGraphics.screenWidth - FontRenderer.getTextWidth(this.dialogTitle) >> 1, this.textStartY, var1);
            var2 = this.textStartY + FontRenderer.fontHeight;
            var1.fillRect(this.dialogX, var2 + 5, this.contentWidth, 2);
            var2 += 12;
         } else {
            var2 = this.textStartY;
         }

         for (int var10 = 0; var10 < this.rowsCount; var10++) {
            for (int var4 = 0; var4 < this.columnsCount; var4++) {
               String[] var5 = (String[])this.dataVector.elementAt(var10);
               FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(var5[var4], this.textAlignment == 0 ? this.dialogX + 10 : GameGraphics.screenWidth - FontRenderer.getTextWidth(var5[var4]) >> 1, var2, var1);
               var2 += FontRenderer.fontHeight + 2;
            }

            if (var10 < this.rowsCount - 1) {
               var1.fillRect(this.dialogX, var2 + 5, this.contentWidth, 1);
            }

            var2 += 12;
         }
      }

      Screen.renderHeader(var1);
      if (this.leftSoftkey != null) {
         FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.leftSoftkey.text, 4, Screen.softkeyY, var1);
      }

      if (this.centerSoftkey != null) {
         FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.centerSoftkey.text, this.centerSoftkeyX, Screen.softkeyY, var1);
      }

      if (this.rightSoftkey != null) {
         FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.rightSoftkey.text, this.rightSoftkeyX, Screen.softkeyY, var1);
      }
   }
}
