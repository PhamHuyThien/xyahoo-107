final class quyen_bq implements Runnable {
   private final quyen_ca a;

   quyen_bq(quyen_bn var1, quyen_ca var2) {
      this.a = var2;
   }

   public final void run() {
      quyen_bn.b = true;
      this.a.a();
      quyen_bn.b = false;
   }
}
