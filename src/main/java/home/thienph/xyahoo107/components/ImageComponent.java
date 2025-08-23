package home.thienph.xyahoo107.components;

import home.thienph.xyahoo107.actions.Action;
import home.thienph.xyahoo107.actions.quyen_cd;
import home.thienph.xyahoo107.managers.ImageCache;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class ImageComponent extends UIComponent {
   private Action clickAction;
   public boolean hasBorder;
   private int imageRenderX;
   private int imageRenderY;
   private int[] multiImagePositions = null;
   private Integer[] multiImageIds;
   private Integer singleImageId;
   private Image customImage;

   public ImageComponent() {
      super.isVisible = false;
   }

   public final boolean handleKeyPress(int var1) {
      return true;
   }

   public final void setClickAction(String var1, Action var2) {
      if (var2 != null) {
         this.clickAction = var2;
         super.middleSoftKey = new UIFactory(var1, new quyen_cd(this));
      }
   }

   public final void handlePointerPress(int var1, int var2) {
      if (super.isVisible) {
         if (this.isFocused()) {
            if (this.clickAction != null) {
               this.clickAction.action();
               return;
            }
         } else {
            UIUtils.focusComponent(super.parentScreen, this);
         }
      }
   }

   public final void render(Graphics var1) {
      if (this.hasBorder) {
         this.imageRenderX = super.posX + 6;
         this.imageRenderY = super.posY + 6;
         int var10003 = super.width - 1;
         int var10004 = super.height - 1;
         byte var2 = 8;
         int var6 = var10004;
         int var5 = var10003;
         int var4 = super.posY;
         int var3 = super.posX;
         var1.setColor(11320516);
         var1.drawRoundRect(var3, var4, var5, var6, 8, 8);
      } else {
         this.imageRenderX = super.posX;
         this.imageRenderY = super.posY;
      }

      if (this.isFocused()) {
         if (this.hasBorder) {
            ButtonComponent.drawButtonBackground(var1, super.posX, super.posY, super.width - 1, super.height - 1);
         } else {
            ButtonComponent.drawButtonBackground(var1, super.posX - 6, super.posY - 6, super.width + 9, super.height + 9);
         }
      }

      if (this.customImage != null) {
         var1.drawImage(this.customImage, this.imageRenderX, this.imageRenderY, 0);
      } else if (this.multiImagePositions == null) {
         var1.drawImage(ImageCache.getImage(this.singleImageId), this.imageRenderX, this.imageRenderY, 0);
      } else {
         for (int var7 = 0; var7 < this.multiImagePositions.length; var7++) {
            var1.drawImage(ImageCache.getImage(this.multiImageIds[var7]), super.posX + (super.width >> 1) + (this.multiImagePositions[var7] >> 24), super.posY + (super.height >> 1) + (this.multiImagePositions[var7] << 8 >> 24), 0);
         }
      }
   }

   public final void setSingleImageId(int var1) {
      this.singleImageId = new Integer(var1);
   }

   public final void setCustomImage(Image var1) {
      this.customImage = var1;
   }

   public final void setMultipleImages(int[] var1) {
      this.multiImagePositions = var1;
      this.multiImageIds = new Integer[var1.length];

      for (int var2 = 0; var2 < var1.length; var2++) {
         this.multiImageIds[var2] = new Integer((short)var1[var2]);
      }
   }

   public final void update() {
   }

   public final boolean handleDirectKeyPress(int var1) {
      return true;
   }
}
