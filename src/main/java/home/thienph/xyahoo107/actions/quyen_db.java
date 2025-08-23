package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_db implements Action {
   private GameScreen a;

   public quyen_db(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.exitGame(true);
   }
}
