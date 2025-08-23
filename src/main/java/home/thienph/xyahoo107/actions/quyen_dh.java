package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;

final class quyen_dh implements Action {
   private quyen_dg a;

   quyen_dh(quyen_dg var1) {
      this.a = var1;
   }

   public final void action() {
      quyen_dg var1 = this.a;
      this.a.a.exitGame(true);
      var1 = this.a;
      GameScreen.requestRoomList();
   }
}
