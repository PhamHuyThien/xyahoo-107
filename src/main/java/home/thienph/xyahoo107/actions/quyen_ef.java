package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.CheckboxComponent;
import home.thienph.xyahoo107.components.DropdownComponent;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class quyen_ef implements Action {
   private final CheckboxComponent a;
   private final boolean b;
   private final CheckboxComponent c;
   private final boolean d;
   private final CheckboxComponent e;
   private final boolean f;
   private final CheckboxComponent g;
   private final boolean h;
   private final DropdownComponent i;
   private final int j;

   public quyen_ef(CheckboxComponent var1, boolean var2, CheckboxComponent var3, boolean var4, CheckboxComponent var5, boolean var6, CheckboxComponent var7, boolean var8, DropdownComponent var9, int var10) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var7;
      this.h = var8;
      this.i = var9;
      this.j = var10;
   }

   public final void action() {
      GameManager.instance.removeScreen(LoginScreen.getSettingsScreen());
      this.a.isChecked = this.b;
      this.c.isChecked = this.d;
      this.e.isChecked = this.f;
      this.g.isChecked = this.h;
      this.i.setSelectedIndex(this.j);
   }
}
