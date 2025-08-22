import javax.microedition.lcdui.Image;

final class quyen_hm implements quyen_ca {
   private quyen_hg a;
   private final boolean b;
   private final String c;
   private final String d;

   quyen_hm(quyen_hg var1, boolean var2, String var3, String var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void a() {
      if (this.b) {
         quyen_et.c.i.a(this.c);
      } else {
         if (!quyen_et.c.h.c(this.a.a) && !quyen_et.c.h.b(this.a.a) && !quyen_et.c.h.d(this.a.a)) {
            quyen_a.b(this.d);
            quyen_et.e().a("Đã gửi yêu cầu kết bạn đến " + this.d, (Image) null, 1);
         } else {
            quyen_et.e().d("ID đã tồn tại trong các danh sách: bạn bè, từ chối hoặc chờ kết bạn.");
         }

         quyen_hg.c(this.a).removeElementAt(2);
      }
   }
}
