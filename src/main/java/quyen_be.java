import java.util.Vector;

public final class quyen_be extends quyen_cj {
   public quyen_ch a;
   public quyen_bb b;
   private Vector d;
   public quyen_ci c;

   public quyen_be() {
      super.s = true;
      super.j = "Tải Về";
      this.a = new quyen_ch(0, 0, quyen_cj.h, quyen_cj.i - quyen_et.e);
      this.a(this.a);
      quyen_hr.a(this, this.a);
      this.b = new quyen_bb();
      this.a.a(1, 10, 10);
      this.a.a(this.b, 1, false);
      super.n = quyen_et.a(this, false, null);
      this.d = new Vector();
      this.d.addElement(new quyen_bw("Xem", new quyen_bf(this)));
      this.d.addElement(new quyen_bw("Xóa", new quyen_bg(this)));
      this.d.addElement(new quyen_bw("Xóa tất cả", new quyen_bh(this)));
      this.c = new quyen_ci(this.d);
      this.a.d = new quyen_bi(this);
   }

   public final void a() {
      int var1 = this.a.c.size();

      while (--var1 >= 0) {
         quyen_bj var2 = (quyen_bj)this.a.c.elementAt(var1);
         this.b.b(var2.c, 0L);
      }

      this.a.b();
   }

   public final void a(byte var1) {
      int var2 = 0;
      int var3 = this.a.c.size();

      while (--var3 >= 0) {
         quyen_ba var4 = ((quyen_bj)this.a.c.elementAt(var3)).i;
         if (var1 == 0) {
            if (var4.e == 0) {
               if (++var2 > 4) {
                  this.b.b(var4.a, 0L);
               }
            }
         } else if (var4.e == 1) {
            if (++var2 > 3) {
               this.b.b(var4.a, 0L);
            }
         }
      }
   }
}
