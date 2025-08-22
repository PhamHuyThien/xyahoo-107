final class quyen_jl implements Action {
   private YahooScreen a;

   quyen_jl(YahooScreen var1) {
      this.a = var1;
   }

   public final void action() {
      if (!YahooScreen.checkConnectionReady(this.a)) {
         YahooScreen.showStatusDialog(this.a);
      }
   }
}
