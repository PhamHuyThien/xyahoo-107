final class quyen_au implements Action {
   private final byte[] a;

   quyen_au(byte[] var1) {
      this.a = var1;
   }

   public final void action() {
      MessageProcessor.a(this.a);
   }
}
