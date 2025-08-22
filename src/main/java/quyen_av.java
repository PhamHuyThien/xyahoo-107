final class quyen_av implements Action {
   private final byte[] a;

   quyen_av(byte[] var1) {
      this.a = var1;
   }

   public final void action() {
      MessageProcessor.a(this.a);
   }
}
