package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_ds implements Action {
   private GameScreen a;

   public quyen_ds(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameScreen.showBetInput(this.a);
   }
}
