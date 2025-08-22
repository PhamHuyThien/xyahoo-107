final class quyen_hh implements Action {
   private ChatScreen a;

   quyen_hh(ChatScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().removeScreen(this.a);
   }
}
