final class quyen_dg implements Action {
   final GameScreen a;

   quyen_dg(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.instance.a("Bạn có muốn rời bàn?", new quyen_dh(this));
   }
}
