final class quyen_ho implements Action {
   private final String a;

   quyen_ho(ChatScreen var1, String var2) {
      this.a = var2;
   }

   public final void action() {
      quyen_a.i(this.a);
   }
}
