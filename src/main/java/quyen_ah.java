final class quyen_ah implements Action {
   private final byte[] a;

   quyen_ah(byte[] var1) {
      this.a = var1;
   }

   public final void action() {
      MessageProcessor.a(this.a);
   }
}
