import java.util.Vector;

public final class quyen_gz extends quyen_cj {
   public quyen_ch a;
   public int b;
   private Vector A;
   public quyen_ci c;
   public static quyen_bw d = new quyen_bw("Nạp xu", new quyen_ha());

   public quyen_gz() {
      super.v = 11114;
      super.s = true;
      this.a = new quyen_ch(0, 0, quyen_cj.h, quyen_cj.i - quyen_et.e);
      this.a(this.a);
      quyen_hr.a(this, this.a);
      super.n = quyen_et.a(this, true, null);
      this.A = new Vector();
      this.A.addElement(new quyen_bw("Vào nhanh", new quyen_hb(this)));
      this.A.addElement(new quyen_bw("Cập nhật", new quyen_hc(this)));
      this.A.addElement(d);
      this.c = new quyen_ci(this.A);
      super.m = new quyen_bw("Menu", new quyen_hd(this));
   }
}
