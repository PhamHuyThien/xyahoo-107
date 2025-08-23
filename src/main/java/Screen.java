import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public class Screen {
   private boolean hasSpecialComponent;
   public boolean isActive;
   public static int screenX;
   public static int screenY;
   public static int screenWidth;
   public static int screenHeight;
   public String title;
   public String subtitle = "";
   public Vector components;
   public UIFactory leftSoftkey;
   public UIFactory rightSoftkey;
   public UIFactory centerSoftkey;
   private int selectedIndex;
   public boolean needsUpdate = true;
   public boolean isAnimating;
   public int animationOffset;
   private int animationStep;
   public boolean isScrollLocked;
   public int targetScrollY;
   public int currentScrollY;
   private int scrollVelocity;
   private int scrollAcceleration;
   public int unused1;
   public boolean unused2 = false;
   public int componentCount;
   public boolean isAtBottom = false;
   private String currentLeftText = "";
   private String currentCenterText = "";
   private String currentRightText = "";
   public static int softkeyY;
   private static int keyRepeatCounter = 0;
   private boolean isDragScrolling;
   private int dragStartY;
   private int maxScrollY;

   public final void setSelectedIndex(int var1) {
      this.selectedIndex = var1;
      this.needsUpdate = true;
   }

   public final int getSelectedIndex() {
      return this.selectedIndex;
   }

   public final void startSlideAnimation(int var1) {
      this.isAnimating = true;
      if (var1 == -1) {
         this.animationOffset = screenWidth;
         this.animationStep = -screenWidth >> 2;
      } else {
         this.animationOffset = -screenWidth;
         this.animationStep = screenWidth >> 2;
      }
   }

   public Screen() {
      this.components = new Vector();
      this.setSelectedIndex(-1);
   }

   public void render(Graphics var1) {
      this.renderBackground(var1);
      this.renderComponents(var1);
      var1.setClip(0, 0, 1000, 1000);
      this.renderSpecialComponent(var1);
      this.renderSoftkeys(var1);
   }

   public final void renderSoftkeys(Graphics var1) {
      var1.setClip(0, 0, 1000, 1000);
      renderHeader(var1);
      this.currentLeftText = this.currentCenterText = this.currentRightText = "";
      if (this.leftSoftkey != null) {
         this.currentLeftText = this.leftSoftkey.text;
      }

      if (this.rightSoftkey != null) {
         this.currentCenterText = this.rightSoftkey.text;
      }

      if (this.centerSoftkey != null) {
         this.currentRightText = this.centerSoftkey.text;
      }

      if (this.selectedIndex != -1) {
         UIComponent var2;
         if ((var2 = (UIComponent)this.components.elementAt(this.selectedIndex)).leftSoftKey != null) {
            this.currentLeftText = var2.leftSoftKey.text;
         }

         if (var2.rightSoftKey != null) {
            this.currentCenterText = var2.rightSoftKey.text;
         }

         if (var2.middleSoftKey != null) {
            this.currentRightText = var2.middleSoftKey.text;
         }
      }

      if (this.needsUpdate) {
         this.needsUpdate = false;
         UIUtils.calculateTextPositions(this.currentRightText, this.currentCenterText);
      }

      FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.currentLeftText, 4, softkeyY, var1);
      FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.currentCenterText, UIUtils.rightTextX, softkeyY, var1);
      FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.currentRightText, UIUtils.centerTextX, softkeyY, var1);
   }

   public final void renderComponents(Graphics var1) {
      for (int var2 = 0; var2 < this.componentCount; var2++) {
         var1.setClip(0, screenY, screenWidth, screenHeight - GameManager.footerHeight);
         var1.translate(0, -this.currentScrollY);
         var1.translate(0, screenY);
         UIComponent var3;
         if ((var3 = (UIComponent)this.components.elementAt(var2)).posY - this.currentScrollY + var3.height > 0 && var3.posY - this.currentScrollY < screenHeight - GameManager.footerHeight - 10) {
            var3.render(var1);
         }

         var1.translate(0, -screenY);
         var1.translate(0, this.currentScrollY);
      }

      var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
   }

   public void renderBackground(Graphics var1) {
   }

   public void addComponent(UIComponent var1) {
      if (!this.components.contains(var1)) {
         var1.parentScreen = this;
         this.components.addElement(var1);
         this.updateLayout();
         if (var1 instanceof ListComponent || var1 instanceof GridComponent) {
            this.hasSpecialComponent = true;
         }
      }
   }

   public final void updateLayout() {
      this.componentCount = this.components.size();
      int var2 = 0;
      if (this.componentCount > 1) {
         UIComponent var3;
         var2 = (var3 = (UIComponent)this.components.elementAt(this.componentCount - 1)).posY + var3.height + 6 + GameManager.footerHeight;
      }

      if (var2 > screenHeight) {
         ScrollBar.isVisible = true;
         ScrollBar.initialize(this.componentCount);
         this.maxScrollY = var2 - screenHeight;
      } else {
         ScrollBar.isVisible = false;
      }
   }

   public void removeComponent(UIComponent var1) {
      this.components.removeElement(var1);
      this.updateLayout();
   }

   public void removeAllComponents() {
      this.components.removeAllElements();
      this.updateLayout();
   }

   public final void scrollToComponent(int var1) {
      UIComponent var4;
      int var2 = (var4 = (UIComponent)this.components.elementAt(var1)).posY + screenY + var4.height;
      if (var4.posY < this.targetScrollY + 6 && this.selectedIndex != 0) {
         this.targetScrollY = var4.posY - (FontRenderer.lineHeight << 1);
         if (this.targetScrollY < 0) {
            this.targetScrollY = 0;
            return;
         }
      } else if (var2 > this.targetScrollY + screenHeight + 1 && !this.isAtBottom) {
         this.targetScrollY = var2 - screenHeight + FontRenderer.lineHeight * 3 + 2;
         if (this.targetScrollY > this.maxScrollY) {
            this.targetScrollY = this.maxScrollY;
            return;
         }
      } else if (var4.posY < this.currentScrollY) {
         this.targetScrollY = var4.posY - 6;
      }
   }

   public final void updateAnimation() {
      if (this.isAnimating) {
         this.animationOffset = this.animationOffset + this.animationStep;
         if (this.animationOffset < 10 && this.animationOffset > -10) {
            this.isAnimating = false;
         }
      }
   }

   private void selectPreviousComponent() {
      int var1 = this.selectedIndex;
      if (!UIUtils.isTextInputWithHelpBox((UIComponent)this.components.elementAt(var1))) {
         UIComponent var2;
         do {
            if (--var1 == -1) {
               var1 = this.componentCount - 1;
            }
         } while (UIUtils.isEmptyTextComponent(var2 = (UIComponent)this.components.elementAt(var1)) || !var2.isVisible);

         this.selectAndScrollTo(var1);
      }
   }

   private void selectNextComponent() {
      int var1 = this.selectedIndex;
      if (!UIUtils.isTextInputWithHelpBox((UIComponent)this.components.elementAt(var1))) {
         UIComponent var2;
         do {
            if (++var1 == this.componentCount) {
               var1 = 0;
            }
         } while (UIUtils.isEmptyTextComponent(var2 = (UIComponent)this.components.elementAt(var1)) || !var2.isVisible);

         this.selectAndScrollTo(var1);
      }
   }

   private void selectAndScrollTo(int var1) {
      this.setSelectedIndex(var1);
      this.scrollToComponent(var1);
      ScrollBar.setScrolling(true);
   }

   public boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      boolean var4 = false;
      if (this.currentScrollY != this.targetScrollY) {
         this.scrollAcceleration = this.targetScrollY - this.currentScrollY << 2;
         this.scrollVelocity = this.scrollVelocity + this.scrollAcceleration;
         this.currentScrollY = this.currentScrollY + (this.scrollVelocity >> 4);
         this.scrollVelocity &= 15;
      }

      if (this.selectedIndex != -1) {
         if (var3[0] > 0) {
            ((UIComponent)this.components.elementAt(this.selectedIndex)).handleKeyPress(var3[0]);
            var3[0] = 0;

            for (int var9 = 0; var9 < var1.length; var9++) {
               var1[var9] = false;
            }

            return false;
         }

         for (int var7 = 0; var7 < 21; var7++) {
            if (var2[var7] && ++keyRepeatCounter > 4) {
               if (((UIComponent)this.components.elementAt(this.selectedIndex)).handleDirectKeyPress(var7)) {
                  if (var7 == 12) {
                     this.selectPreviousComponent();
                  } else if (var7 == 13) {
                     this.selectNextComponent();
                  }

                  var2[var7] = false;
               }

               keyRepeatCounter = 4;
            } else if (var1[var7]) {
               if (((UIComponent)this.components.elementAt(this.selectedIndex)).handleKeyPress(var7)) {
                  if (var7 == 12) {
                     this.selectPreviousComponent();
                  } else if (var7 == 13) {
                     this.selectNextComponent();
                  } else {
                     Action var5 = null;
                     if (var7 == 17) {
                        if (this.leftSoftkey != null) {
                           var5 = this.leftSoftkey.action;
                        }

                        UIComponent var10;
                        if (this.selectedIndex != -1 && (var10 = (UIComponent)this.components.elementAt(this.selectedIndex)).leftSoftKey != null) {
                           var5 = var10.leftSoftKey.action;
                        }
                     } else if (var7 == 18) {
                        if (this.rightSoftkey != null) {
                           var5 = this.rightSoftkey.action;
                        }

                        UIComponent var11;
                        if (this.selectedIndex != -1 && (var11 = (UIComponent)this.components.elementAt(this.selectedIndex)).rightSoftKey != null) {
                           var5 = var11.rightSoftKey.action;
                        }
                     } else if (var7 == 16) {
                        if (this.centerSoftkey != null) {
                           var5 = this.centerSoftkey.action;
                        }

                        UIComponent var12;
                        if (this.selectedIndex != -1 && (var12 = (UIComponent)this.components.elementAt(this.selectedIndex)).middleSoftKey != null) {
                           var5 = var12.middleSoftKey.action;
                        }
                     }

                     if (var5 != null) {
                        var5.action();
                     }
                  }

                  var4 = true;
               } else {
                  var4 = false;
               }

               var1[var7] = false;
            }
         }
      }

      int var8 = this.componentCount;

      while (--var8 >= 0) {
         ((UIComponent)this.components.elementAt(var8)).update();
      }

      return var4;
   }

   public void onPointerPressed(int var1, int var2) {
      if (this.isDragScrolling && !this.isScrollLocked) {
         this.isDragScrolling = false;
         this.targetScrollY = this.targetScrollY - (var2 - this.dragStartY) * 5;
      } else {
         int var3 = this.components.size();

         while (--var3 >= 0) {
            UIComponent var4 = (UIComponent)this.components.elementAt(var3);
            if (var1 > var4.posX && var2 + this.currentScrollY > var4.posY && var1 < var4.posX + var4.width && var2 + this.currentScrollY < var4.posY + var4.height) {
               var4.handlePointerPress(var1 - var4.posX, var2 + this.currentScrollY - var4.posY);
               return;
            }
         }

         ScrollBar.setScrolling(true);
      }
   }

   public void onPointerDragged(int var1, int var2) {
      int var3 = this.componentCount;

      while (--var3 >= 0) {
         UIComponent var4 = (UIComponent)this.components.elementAt(var3);
         if (var1 > var4.posX && var2 + this.currentScrollY > var4.posY && var1 < var4.posX + var4.width && var2 + this.currentScrollY < var4.posY + var4.height && var4.isFocused) {
            var4.handlePointerDrag(var1 - var4.posX, var2 + this.currentScrollY - var4.posY);
            return;
         }
      }

      if (!this.isScrollLocked && ContactListComponent.abs(var2 - this.dragStartY) > 1) {
         this.isDragScrolling = true;
         this.targetScrollY = this.targetScrollY - (var2 - this.dragStartY);
         if (this.targetScrollY < 0) {
            this.targetScrollY = 0;
         } else if (this.targetScrollY > this.maxScrollY) {
            this.targetScrollY = this.maxScrollY;
         }

         this.currentScrollY = this.targetScrollY;
         this.dragStartY = var2;
      }

      ScrollBar.setScrolling(true);
   }

   public void onPointerReleased(int var1, int var2) {
      int var3 = this.componentCount;

      while (--var3 >= 0) {
         UIComponent var4 = (UIComponent)this.components.elementAt(var3);
         if (var1 > var4.posX && var2 + this.currentScrollY > var4.posY && var1 < var4.posX + var4.width && var2 + this.currentScrollY < var4.posY + var4.height && var4.isFocused) {
            var4.handlePointerRelease(var1 - var4.posX, var2 + this.currentScrollY - var4.posY);
            return;
         }
      }

      if (!this.isScrollLocked) {
         this.dragStartY = var2;
      }
   }

   public final void onPointerMoved(int var1, int var2) {
      if (!this.isScrollLocked) {
         this.dragStartY = var2;
      }
   }

   public static void renderHeader(Graphics var0) {
      if (FontRenderer.isCustomFontEnabled) {
         var0.drawImage(GameManager.headerImage, 0, screenHeight + 2, 20);
      }
   }

   public UIComponent findComponentByID(int var1) {
      int var2 = this.componentCount;

      while (--var2 >= 0) {
         UIComponent var3;
         if ((var3 = (UIComponent)this.components.elementAt(var2)).id == var1) {
            return var3;
         }
      }

      return null;
   }

   public void focusFirstComponent() {
      if (this.componentCount > 0 && this.hasSpecialComponent && ((UIComponent)this.components.elementAt(0)).isPressed) {
         ((UIComponent)this.components.elementAt(0)).onFocusGained();
      }
   }

   public void renderSpecialComponent(Graphics var1) {
      if (this.componentCount > 0 && this.hasSpecialComponent && ((UIComponent)this.components.elementAt(0)).isPressed) {
         ((UIComponent)this.components.elementAt(0)).renderFocusIndicator(var1);
      } else {
         ScrollBar.render(var1, this.selectedIndex);
      }
   }
}
