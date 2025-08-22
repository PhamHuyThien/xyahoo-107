final class quyen_gs implements Action {
   final quyen_gr a;
   private final quyen_eb b;
   private final quyen_bn c;
   private final FileSystemInterface d;

   quyen_gs(quyen_gr var1, quyen_eb var2, quyen_bn var3, FileSystemInterface var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void action() {
      GameGraphics.clearKeyStates();
      quyen_gr var1 = this.a;
      this.a.a.setTitle(this.b.b.getString().trim());
      this.c.c = new quyen_gt(this, this.c, this.d);
      this.c.a("Chọn thư mục", 2);
   }
}
