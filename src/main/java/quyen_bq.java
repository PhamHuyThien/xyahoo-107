final class quyen_bq implements Runnable {
   private final Action a;

   quyen_bq(quyen_bn var1, Action var2) {
      this.a = var2;
   }

   public final void run() {
      quyen_bn.b = true;
      this.a.action();
      quyen_bn.b = false;
   }
}
