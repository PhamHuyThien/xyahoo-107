package home.thienph.xyahoo107.components;

import home.thienph.xyahoo107.actions.quyen_cy;
import home.thienph.xyahoo107.data.game.GameRoom;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.GameScreen;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.TextRenderer;

import javax.microedition.lcdui.Graphics;

public final class GameRoomGridComponent extends UIComponent {
   private int iconWidth;
   private int iconHeight;
   private int iconHalfWidth;
   private int iconHalfHeight;
   private int roomType;
   private int totalRows;
   private int columnsPerRow;
   private int selectedRow;
   private int selectedColumn;
   private int leftMargin;
   private int itemStartX;
   private int topMargin;
   private int scrollOffsetY;
   private int itemSpacingX;
   private int itemSpacingY;
   private int maxScrollOffset;
   private GameRoom[] roomData;
   private int roomCount;
   private boolean isDragging;
   private int lastTouchY;

   public GameRoomGridComponent(int var1, int var2, int var3) {
      super.width = var1;
      super.height = var2;
      super.isFocused = true;
      this.roomType = var3;
      this.iconWidth = GameManager.friendListIcon.getWidth();
      this.iconHeight = GameManager.friendListIcon.getHeight();
      this.iconHalfWidth = this.iconWidth >> 1;
      this.iconHalfHeight = this.iconHeight >> 1;
      super.middleSoftKey = new UIFactory("Vào bàn", new quyen_cy(this));
   }

   public final void setRoomData(GameRoom[] var1) {
      this.roomData = var1;
      this.roomCount = var1.length;
      this.columnsPerRow = Screen.screenWidth / (this.iconWidth + 20);
      this.totalRows = this.roomCount % this.columnsPerRow == 0 ? this.roomCount / this.columnsPerRow : this.roomCount / this.columnsPerRow + 1;
      this.leftMargin = (Screen.screenWidth - this.columnsPerRow * 50) / (this.columnsPerRow + 1);
      this.itemStartX = this.leftMargin + 25;
      this.itemSpacingX = 50 + this.leftMargin;
      this.topMargin = 25;
      this.scrollOffsetY = 0;
      this.itemSpacingY = this.iconHeight << 1;
      this.maxScrollOffset = (this.topMargin + this.totalRows * this.itemSpacingY + this.iconHeight + 15 - super.height) / this.itemSpacingY;
      this.selectedColumn = 0;
      this.selectedRow = 0;
      this.onFocusGained();
   }

   private boolean isSelected(int var1, int var2) {
      return var1 == this.selectedRow && var2 == this.selectedColumn;
   }

   private boolean isValidPosition(int var1, int var2) {
      return var1 * this.columnsPerRow + var2 <= this.roomCount - 1;
   }

   public final void render(Graphics var1) {
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;

      for (int var6 = 0; var6 < this.roomData.length; var6++) {
         var4 = var6 / this.columnsPerRow;
         var5 = var6 % this.columnsPerRow;
         var2 = this.itemStartX + var5 * this.itemSpacingX;
         var3 = this.topMargin + var4 * this.itemSpacingY + this.scrollOffsetY;
         if (this.isSelected(var4, var5)) {
            ButtonComponent.drawButtonBackground(var1, var2 - this.iconHalfWidth - 11, var3 - this.iconHalfHeight - 12, (this.iconHalfWidth << 1) + 21, (this.iconHalfHeight << 1) + 34);
         }

         var1.drawImage(GameManager.friendListIcon, var2, var3, 3);
         if (this.roomData[var6].getPlayerCount() > 0) {
            var1.drawRegion(GameManager.settingsIcon, 0, 18, 18, 22, 0, var2, var3 - 23, 17);
         }

         if (this.roomData[var6].getPlayerCount() > 1) {
            var1.drawRegion(GameManager.settingsIcon, 19, 0, 18, 21, 0, var2, var3 + 1, 17);
         }

         if (this.roomData[var6].getPlayerCount() > 2) {
            var1.drawRegion(GameManager.settingsIcon, 0, 0, 19, 18, 0, var2 - 27, var3, 6);
         }

         if (this.roomData[var6].getPlayerCount() > 3) {
            var1.drawRegion(GameManager.settingsIcon, 18, 21, 22, 18, 0, var2 + 4, var3, 6);
         }

         if (this.roomData[var6].roomStatus == 1) {
            var1.drawImage(GameManager.roomIcon, var2, var3, 3);
         }

         TextRenderer.drawStringWithNumbers(GameScreen.instance.getNumberString(var6 + 1), var2 + this.iconHalfWidth - 6, var3 - this.iconHalfHeight - 7, 0, var1, 1);
         FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.roomData[var6].roomName, var2 - this.iconHalfWidth + (this.iconWidth - FontRenderer.getTextWidth(this.roomData[var6].roomName) >> 1), var3 + this.iconHalfHeight + 7, var1);
      }
   }

   public final boolean handleKeyPress(int var1) {
      boolean var2 = true;
      switch (var1) {
         case 12:
            if (this.selectedRow > 0) {
               this.selectedRow--;
               if (this.scrollOffsetY < 0) {
                  this.scrollOffsetY = this.scrollOffsetY + this.itemSpacingY;
               }
            } else {
               this.selectedRow = this.totalRows - 1;
               var1 = this.maxScrollOffset;
               if (!this.isValidPosition(this.selectedRow, this.selectedColumn)) {
                  this.selectedRow--;
                  var1--;
               }

               this.scrollOffsetY = this.scrollOffsetY - var1 * this.itemSpacingY;
            }

            var2 = false;
            ScrollBar.setScrolling(true);
            break;
         case 13:
            for (var1 = this.selectedColumn; var1 >= 0; var1--) {
               if (this.selectedRow == this.totalRows - 1) {
                  this.selectedRow = 0;
                  this.scrollOffsetY = 0;
                  break;
               }

               if (this.isValidPosition(this.selectedRow + 1, var1)) {
                  this.selectedRow++;
                  this.selectedColumn = var1;
                  var1 = Screen.screenHeight - GameManager.footerHeight - (this.iconHeight << 1);
                  if (this.topMargin + this.selectedRow * this.itemSpacingY > var1) {
                     this.scrollOffsetY = this.scrollOffsetY - this.itemSpacingY;
                  }
                  break;
               }
            }

            var2 = false;
            ScrollBar.setScrolling(true);
            break;
         case 14:
            if (this.selectedColumn > 0) {
               this.selectedColumn--;
               var2 = false;
            }
            break;
         case 15:
            if (this.selectedColumn < this.columnsPerRow - 1 && this.isValidPosition(this.selectedRow, this.selectedColumn + 1)) {
               this.selectedColumn++;
               var2 = false;
            }
      }

      return var2;
   }

   public final void update() {
   }

   public final boolean handleDirectKeyPress(int var1) {
      if (var1 != 13 && var1 != 12) {
         return true;
      } else {
         this.handleKeyPress(var1);
         return false;
      }
   }

   public final void onFocusGained() {
      ScrollBar.isVisible = true;
      ScrollBar.initialize(this.totalRows);
   }

   public final void renderFocusIndicator(Graphics var1) {
      ScrollBar.render(var1, this.selectedRow);
   }

   public final void handlePointerRelease(int var1, int var2) {
      this.lastTouchY = var2;
   }

   public final void handlePointerPress(int var1, int var2) {
      if (this.isDragging) {
         this.isDragging = false;
      } else {
         var2 += Screen.screenY;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;

         for (int var7 = 0; var7 < this.roomCount; var7++) {
            var5 = var7 / this.columnsPerRow;
            var6 = var7 % this.columnsPerRow;
            var3 = this.itemStartX + var6 * this.itemSpacingX;
            var4 = this.topMargin + var5 * this.itemSpacingY + this.scrollOffsetY;
            if (var1 > var3 - 25 && var1 < var3 + this.iconWidth - 15 && var2 > var4 - 10 && var2 < var4 + this.iconHeight + 15) {
               if (this.isSelected(var5, var6)) {
                  super.middleSoftKey.action.action();
               } else {
                  this.selectedRow = var5;
                  this.selectedColumn = var6;
               }
               break;
            }
         }

         ScrollBar.setScrolling(true);
      }
   }

   public final void handlePointerDrag(int var1, int var2) {
      if (ContactListComponent.abs(var1 = var2 - this.lastTouchY) > 10) {
         this.isDragging = true;
         if (var1 > 0) {
            this.scrollOffsetY += var1;
            if (this.scrollOffsetY > 0) {
               this.scrollOffsetY = 0;
            }
         } else {
            this.scrollOffsetY += var1;
            if (this.scrollOffsetY < -this.maxScrollOffset * this.itemSpacingY) {
               this.scrollOffsetY = -this.maxScrollOffset * this.itemSpacingY;
            }
         }

         this.lastTouchY = var2;
      }

      ScrollBar.setScrolling(true);
   }

   public static GameRoom[] getRoomData(GameRoomGridComponent var0) {
      return var0.roomData;
   }

   public static int getSelectedIndex(GameRoomGridComponent var0) {
      return var0.selectedRow * var0.columnsPerRow + var0.selectedColumn;
   }

   public static int getRoomType(GameRoomGridComponent var0) {
      return var0.roomType;
   }
}
