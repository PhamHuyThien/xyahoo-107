final class quyen_m implements Runnable {
   private quyen_l a;

   quyen_m(quyen_l var1) {
      this.a = var1;
   }

   public final void run() {
      if (this.a.a != null) {
         this.a.a.a();
      }

      this.a.c();
      quyen_l.a(this.a);
   }
}
