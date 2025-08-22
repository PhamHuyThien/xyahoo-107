import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class PhotoViewerScreen extends Screen {
   public Image displayImage;
   public byte[] imageBytes;
   private int imageX;
   private int imageY;
   private int targetX;
   private int targetY;
   private int velocityX;
   private int velocityY;
   private int smoothX;
   private int smoothY;
   private int currentX;
   private int currentY;
   private int maxPanX;
   private int maxPanY;
   private TextComponent captionText;
   public PhotoViewComponent photoComponent;
   private boolean isDragging;
   private int lastPointerX;
   private int lastPointerY;
   private UIFactory saveButton;

   public PhotoViewerScreen() {
      this.setTitle((String)null);
      this.photoComponent = new PhotoViewComponent();
      this.photoComponent.isVisible = true;
      this.addComponent(this.photoComponent);
      UIUtils.focusComponent((Screen)this, this.photoComponent);
      this.rightSoftkey = GameManager.a(this, true, new quyen_gp(this));
   }

   private final void setSoftKey(int var1, UIFactory var2) {
      if (var1 == 0) {
         super.leftSoftkey = var2;
      } else if (var1 == 1) {
         super.centerSoftkey = var2;
      } else {
         if (var1 == 2) {
            super.rightSoftkey = var2;
         }
      }
   }

   public final void setImageData(final byte[] b) {
      this.imageBytes = b;
      Image image;
      try {
         image = Image.createImage(b, 0, b.length);
      }
      catch (final Exception ex) {
         image = null;
         ex.printStackTrace();
      }
      if (image != null) {
         final Image a = image;
         this.displayImage = a;
         final int n = 0;
         this.targetX = n;
         this.currentY = n;
         final int n2 = 0;
         this.targetY = n2;
         this.currentY = n2;
         final int width = a.getWidth();
         this.maxPanX = width - Screen.screenWidth;
         this.maxPanY = a.getHeight() - Screen.screenHeight + GameManager.footerHeight + ((this.captionText == null) ? 0 : (GameManager.footerHeight + 2)) - 1;
         this.imageX = ((width > Screen.screenWidth) ? 0 : (Screen.screenWidth - width >> 1));
         this.imageY = Screen.screenY + ((this.captionText == null) ? 0 : (GameManager.footerHeight + 2));
      }
   }

   public final void setTitle(String var1) {
      if (var1 == null || var1.length() == 0) {
         super.title = "Photo";
      } else if (!var1.equals(" ")) {
         super.title = var1;
      }

      UIUtils.setScreenTitle(this, super.title);
   }

   public final void setCaption(String var1) {
      if (var1 != null) {
         int var2 = FontRenderer.getTextWidth(var1);
         int var3 = 3;
         if (Screen.screenWidth > var2 + 3) {
            var3 = Screen.screenWidth - var2 >> 1;
         }

         if (this.captionText == null) {
            this.captionText = new TextComponent(var1, var3, 2, FontRenderer.paragraphSpacing);
            this.captionText.id = 20041987;
            this.captionText.isVisible = false;
            this.captionText.forceScroll = true;
            this.captionText.enableScrolling = true;
            this.captionText.textColor = FontRenderer.COLOR_WHITE;
            this.addComponent(this.captionText);
            return;
         }

         this.captionText.text = var1;
      }
   }

   public final void render(Graphics var1) {
      if (this.displayImage != null) {
         var1.setClip(0, Screen.screenY, Screen.screenWidth, Screen.screenHeight);
         var1.setColor(0);
         var1.translate(-this.currentX, -this.currentY);
         var1.drawImage(this.displayImage, this.imageX, this.imageY, 0);
         var1.translate(this.currentX, this.currentY);
      }

      this.renderComponents(var1);
      this.renderSoftkeys(var1);
   }

   public final boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      if ((!var1[14] || this.currentX > 0) && (!var1[15] || this.currentX < this.maxPanX) && UIUtils.isComponentSelected(this, this.photoComponent)) {
         if (var1[10]) {
            GameGraphics.clearKeyStates();
            GameManager.getInstance().previousScreen();
            return false;
         } else if (var1[11]) {
            GameGraphics.clearKeyStates();
            GameManager.getInstance().nextScreen();
            return false;
         } else {
            if (var2[12] || var1[12]) {
               this.targetY -= 85;
            }

            if (var2[13] || var1[13]) {
               this.targetY += 85;
            }

            if (var2[14] || var1[14]) {
               this.targetX -= 85;
            }

            if (var2[15] || var1[15]) {
               this.targetX += 85;
            }

            if (this.targetX < 0) {
               this.targetX = 0;
            }

            if (this.targetX > this.maxPanX) {
               this.targetX = this.maxPanX;
            }

            if (this.targetY <= 0) {
               this.targetY = 0;
               if (this.captionText != null) {
                  this.captionText.posY = 2;
               }
            }

            if (this.targetY > this.maxPanY) {
               this.targetY = this.maxPanY;
            }

            if (this.targetY > GameManager.footerHeight && this.captionText != null) {
               this.captionText.posY = -100;
            }

            if (this.currentX != this.targetX || this.currentY != this.targetY) {
               this.velocityX = this.targetX - this.currentX << 2;
               this.velocityY = this.targetY - this.currentY << 2;
               this.smoothX = this.smoothX + this.velocityX;
               this.currentX = this.currentX + (this.smoothX >> 4);
               this.smoothX &= 15;
               this.smoothY = this.smoothY + this.velocityY;
               this.currentY = this.currentY + (this.smoothY >> 4);
               this.smoothY &= 15;
               if (this.currentX > this.maxPanX) {
                  this.currentX = this.maxPanX;
               }

               if (this.currentX < 0) {
                  this.currentX = 0;
               }

               if (this.currentY > this.maxPanY) {
                  this.currentY = this.maxPanY;
               }

               if (this.currentY < 0) {
                  this.currentY = 0;
               }
            }

            var1[12] = false;
            var1[13] = false;
            var1[14] = false;
            var1[15] = false;
            return super.handleInput(var1, var2, var3);
         }
      } else {
         return super.handleInput(var1, var2, var3);
      }
   }

   public final void onPointerReleased(int var1, int var2) {
      this.lastPointerX = var1;
      this.lastPointerY = var2;
   }

   public final void onPointerPressed(int var1, int var2) {
      if (this.isDragging) {
         this.isDragging = false;
         this.targetY = this.targetY - (var2 - this.lastPointerY << 3);
         if (this.targetY < 0) {
            this.targetY = 0;
         } else if (this.targetY > this.maxPanY) {
            this.targetY = this.maxPanY;
         }

         this.targetX = this.targetX - (var1 - this.lastPointerX << 3);
         if (this.targetX < 0) {
            this.targetX = 0;
            return;
         }

         if (this.targetX > this.maxPanX) {
            this.targetX = this.maxPanX;
         }
      }
   }

   public final void onPointerDragged(int var1, int var2) {
      if (ContactListComponent.abs(var1 - this.lastPointerX) > 1 || ContactListComponent.abs(var2 - this.lastPointerY) > 1) {
         this.isDragging = true;
         this.targetY = this.targetY - (var2 - this.lastPointerY);
         if (this.targetY < 0) {
            this.targetY = 0;
         } else if (this.targetY > this.maxPanY) {
            this.targetY = this.maxPanY;
         }

         this.targetX = this.targetX - (var1 - this.lastPointerX);
         if (this.targetX < 0) {
            this.targetX = 0;
         } else if (this.targetX > this.maxPanX) {
            this.targetX = this.maxPanX;
         }
      }

      this.lastPointerX = var1;
      this.lastPointerY = var2;
   }

   public final void showSendButton(int var1) {
      UIFactory var2 = new UIFactory("Gửi", new quyen_gq(this));
      this.setSoftKey(0, var2);
   }

   public final void hideSendButton() {
      this.setSoftKey(0, null);
   }

   public final void showSaveButton(int var1) {
      if (this.saveButton == null) {
         this.saveButton = new UIFactory("Lưu", new quyen_gr(this));
      }

      this.setSoftKey(1, this.saveButton);
   }

   static void showSaveButton(PhotoViewerScreen var0, TextComponent var1) {
      var0.captionText = null;
   }
}
