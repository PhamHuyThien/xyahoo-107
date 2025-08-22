final class quyen_gf implements Runnable {
   private final byte[] a;

   quyen_gf(GameManager var1, byte[] var2) {
      this.a = var2;
   }

   public final void run() {
      quyen_af.a(this.a);
      System.gc();
   }
}
