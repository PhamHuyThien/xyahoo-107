package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class quyen_cn implements Action {
   private final TextInputComponent a;
   private final Screen b;

   public quyen_cn(TextInputComponent var1, Screen var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void action() {
      if (this.a.alternateAction != null) {
         this.a.alternateAction.action();
      }

      UIUtils.hideTextInput(this.b, this.a);
   }
}
