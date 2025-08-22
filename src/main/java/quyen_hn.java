final class quyen_hn implements Action {
   private final String a;

   quyen_hn(ChatScreen var1, String var2) {
      this.a = var2;
   }

   public final void action() {
      quyen_a.h(this.a);
   }
}
