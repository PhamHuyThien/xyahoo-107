final class quyen_eo implements quyen_ca {
   private quyen_ec a;

   quyen_eo(quyen_ec var1) {
      this.a = var1;
   }

   public final void a() {
      for (int var1 = 0; var1 < this.a.x; var1++) {
         quyen_bx var2;
         quyen_ce var3;
         if ((var2 = (quyen_bx)this.a.l.elementAt(var1)) instanceof quyen_ce && ((var3 = (quyen_ce)var2).a.equals("Xubi ID:") || var3.a.equals("Yahoo! ID:"))) {
            var3.a = this.a.D.a() == 0 ? "Xubi ID:" : "Yahoo! ID:";
            var3.l = quyen_bt.b(var3.a) + 5;
            return;
         }
      }
   }
}
