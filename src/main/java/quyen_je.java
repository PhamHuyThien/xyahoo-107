final class quyen_je implements quyen_ca
{
   private quyen_jc a;
   private final quyen_cs b;
   private final quyen_cs c;
   private final quyen_co d;

   quyen_je(final quyen_jc a, final quyen_cs b, final quyen_cs c, final quyen_co d) {
      this.a = a;
      this.b = b;
      this.c = c;
      this.d = d;
   }

   public final void a() {
      final String lowerCase = this.b.c().trim().toLowerCase();
      String trim = this.c.c().trim();
      if (lowerCase.equals("")) {
         quyen_hr.a(this.d, (quyen_bx)this.b);
         return;
      }
      if (trim.equals("")) {
         quyen_hr.a(this.d, (quyen_bx)this.c);
         return;
      }
      final quyen_bb a = quyen_et.c.i.a.a();
      final String s = trim;
      final quyen_bb quyen_bb = a;
      int i = a.a.size() - 1;
      while (true) {
         while (i >= 0) {
             quyen_bd quyen_bd = (quyen_bd) quyen_bb.a.elementAt(i);
            if (quyen_bd.a().toLowerCase().equals(s.toLowerCase())) {
               final String a2;
               final String s2 = a2 = quyen_bd.a();
               final String s3 = a2;
               if (s2 != null) {
                  trim = s3;
               }
               if (quyen_et.c.i.a.a().a(lowerCase, null, 0L) != null) {
                  quyen_et.c.d("ID đã tồn tại.");
                  return;
               }
               quyen_a.g(lowerCase, trim);
               this.a.a.e.a(trim, new quyen_ba(lowerCase, "", 0, "", new int[0], 0, 0, null));
               this.a.a.b();
               this.a.a.c();
               quyen_et.c.c(this.d);
               return;
            }
            else {
               --i;
            }
         }
         String a2;
         final String s2 = a2 = null;
         continue;
      }
   }
}
