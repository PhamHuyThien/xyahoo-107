final class quyen_dd implements quyen_ca {
   private quyen_cz a;

   quyen_dd(quyen_cz var1) {
      this.a = var1;
   }

   public final void a() {
      if (this.a.o.a.equals("Chơi ngay!")) {
         quyen_a.e(quyen_cz.d, quyen_ia.d);
      } else {
         if (this.a.o.a.equals("Sẵn sàng")) {
            int var1 = this.a.C.length;

            while (--var1 >= 0) {
               if (this.a.C[var1].a.equals(quyen_ia.d)) {
                  this.a.o.a = "";
                  quyen_a.d(quyen_cz.d, quyen_ia.d);
               }
            }
         }
      }
   }
}
