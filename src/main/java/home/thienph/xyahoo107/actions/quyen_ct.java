package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;

public final class quyen_ct implements Action {
   private TextInputComponent a;

   public quyen_ct(TextInputComponent var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.deleteCharacterAtCursor();
   }
}
