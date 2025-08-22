final class quyen_ap implements Action {
   private final byte[] a;

   quyen_ap(byte[] var1) {
      this.a = var1;
   }

   public final void action() {
      MessageProcessor.a(this.a);
   }
}
