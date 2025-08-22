final class quyen_al implements Action {
   private final byte[] a;

   quyen_al(byte[] var1) {
      this.a = var1;
   }

   public final void action() {
      MessageProcessor.a(this.a);
   }
}
