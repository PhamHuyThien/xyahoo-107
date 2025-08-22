final class quyen_an implements Action {
   private final byte[] a;

   quyen_an(byte[] var1) {
      this.a = var1;
   }

   public final void action() {
      MessageProcessor.a(this.a);
   }
}
