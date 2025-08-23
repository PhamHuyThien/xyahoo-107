package home.thienph.xyahoo107.screens;

import home.thienph.xyahoo107.components.ButtonComponent;
import home.thienph.xyahoo107.components.MenuItemComponent;
import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.components.UIComponent;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.UIUtils;

import java.util.Vector;

public class DialogScreen extends Screen {
   public int dialogX;
   public int nextComponentY;
   public int dialogWidth;
   private MenuItemComponent[] menuItems;
   private int expandedMenuIndex = -1;
   private Vector dialogComponents = new Vector();

   public DialogScreen() {
      this.calculateDialogDimensions();
   }

   public final void calculateDialogDimensions() {
      this.dialogWidth = Screen.screenWidth - 30;
      if (this.dialogWidth < 100) {
         this.dialogWidth = 100;
      }

      if (this.dialogWidth > 200) {
         this.dialogWidth = 200;
      }

      this.dialogX = Screen.screenWidth - this.dialogWidth >> 1;
      this.nextComponentY = 6;
   }

   public final void addComponent(UIComponent var1) {
      if (!this.dialogComponents.contains(var1)) {
         var1.parentScreen = this;
         this.dialogComponents.addElement(var1);
         super.addComponent(var1);
         this.nextComponentY = var1.posY + var1.height + 2;
      }
   }

   public final void removeComponent(UIComponent var1) {
      this.dialogComponents.removeElement(var1);
      super.removeComponent(var1);
   }

   public final void removeAllComponents() {
      this.dialogComponents.removeAllElements();
      super.removeAllComponents();
   }

   public final void createMenuItems(String[] var1) {
      int var2 = var1.length;
      this.menuItems = new MenuItemComponent[var2];

      for (int var3 = 0; var3 < var2; this.menuItems[var3].itemIndex = var3++) {
         this.menuItems[var3] = new MenuItemComponent(var1[var3], 0, 0, Screen.screenWidth - 1, FontRenderer.fontHeight + 2);
         this.menuItems[var3].parentMenu = this;
      }
   }

   public final void expandMenu(int var1) {
      if (this.expandedMenuIndex != -1) {
         this.menuItems[this.expandedMenuIndex].isExpanded = false;
      }

      if (this.expandedMenuIndex == var1) {
         this.expandedMenuIndex = -1;
      } else {
         this.expandedMenuIndex = var1;
         this.menuItems[this.expandedMenuIndex].isExpanded = true;
      }

      DialogScreen var7 = this;
      super.removeAllComponents();
      int var2 = 5;
      int var3 = 0;
      int var4 = this.dialogComponents.size();

      for (int var5 = 0; var5 < var4; var5++) {
         UIComponent var6;
         if ((var6 = (UIComponent)var7.dialogComponents.elementAt(var5)).selectedIndex == -1) {
            if (var2 < var6.posY + var6.height) {
               var2 = var6.posY + var6.height;
            }

            var7.addComponent(var6);
         } else {
            if (var3 == var6.selectedIndex) {
               if (var7.components.size() > 0 && !(var7.components.lastElement() instanceof MenuItemComponent)) {
                  var2 += 10;
               }

               var7.menuItems[var3].posY = var2;
               var7.addComponent(var7.menuItems[var3]);
               if (var7.expandedMenuIndex == var6.selectedIndex) {
                  UIUtils.focusComponent(var7, var7.menuItems[var3]);
               }

               var2 += var7.menuItems[var3].height;
               var3++;
            }

            if (var7.expandedMenuIndex == var6.selectedIndex) {
               if (var6 instanceof ButtonComponent) {
                  var2++;
               }

               var6.posY = var2;
               var7.addComponent(var6);
               var2 += var6.height;
               if (var6 instanceof TextInputComponent) {
                  var2 += 5;
               }
            }
         }
      }

      var7.scrollToComponent(var7.getSelectedIndex());
      var7.currentScrollY = var7.targetScrollY;
      var7.focusFirstComponent();
   }

   public final UIComponent findComponentByID(int var1) {
      int var2 = this.dialogComponents.size();

      for (int var3 = 0; var3 < var2; var3++) {
         UIComponent var4;
         if ((var4 = (UIComponent)this.dialogComponents.elementAt(var3)).id == var1) {
            return var4;
         }
      }

      return null;
   }
}
