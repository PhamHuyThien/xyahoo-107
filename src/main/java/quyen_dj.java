final class quyen_dj implements Action {
   private GameScreen a;

   quyen_dj(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.a(false, false);
      if (!this.a.gameFinished) {
         this.a.prepareFinalResults();
      }

      this.a.initializeGameRoom((byte)this.a.finalPlayerCount, this.a.finalPlayerNames2, this.a.finalPlayerMoney, this.a.playerAvatarIds);
   }
}
