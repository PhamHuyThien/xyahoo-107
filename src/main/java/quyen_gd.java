final class quyen_gd implements Action {
   private GameManager a;

   quyen_gd(GameManager var1) {
      this.a = var1;
   }

   public final void action() {
      if (this.a.b(GameScreen.getInstance()) && GameScreen.isInGame) {
         this.a.a("Bạn có muốn thoát bàn đang chơi?", new quyen_ge(this));
      } else {
         PacketSender.e(GameManager.gameRoom.gameListComponent.getSelectedItem().c);
      }
   }
}
