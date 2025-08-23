package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class quyen_cl implements Action {
   private final Screen a;
   private final TextInputComponent b;

   public quyen_cl(Screen var1, TextInputComponent var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void action() {
      UIUtils.hideTextInput(this.a, this.b);
   }
}
