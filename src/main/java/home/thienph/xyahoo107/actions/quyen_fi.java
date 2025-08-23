package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.DropdownComponent;
import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_fi implements Action {
   private final DropdownComponent a;
   private final TextInputComponent b;

   public quyen_fi(GameManager var1, DropdownComponent var2, TextInputComponent var3) {
      this.a = var2;
      this.b = var3;
   }

   public final void action() {
      if (this.a.optionList != null && this.a.optionList.length != 0) {
         this.b.setText(this.a.getSelectedText());
      }
   }
}
