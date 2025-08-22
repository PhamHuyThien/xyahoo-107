final class quyen_hw implements Action {
   final quyen_hv a;
   private final quyen_eb b;
   private final quyen_bn c;
   private final FileSystemInterface d;

   quyen_hw(quyen_hv var1, quyen_eb var2, quyen_bn var3, FileSystemInterface var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void action() {
      GameGraphics.clearKeyStates();
      String var1 = this.b.b.getString().trim();
      this.c.c = new quyen_hx(this, this.c, this.d, var1);
      this.c.a("Chọn thư mục", 2);
   }
}
