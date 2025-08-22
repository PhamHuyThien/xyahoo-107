final class quyen_am implements Action {
   private final boolean a;
   private final GridComponent b;
   private final boolean[] c;
   private final byte[] d;

   quyen_am(boolean var1, GridComponent var2, boolean[] var3, byte[] var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void action() {
      if (this.a) {
         GameManager var10000 = GameManager.instance;
         int var10001 = this.b.getSelectedItemId();
         GridComponent var1 = this.b;
         var10000.joinGame(var10001, this.c[this.b.selectedRowIndex * var1.columnsPerRow + var1.selectedColumnIndex]);
      } else {
         quyen_af.a(this.d);
      }
   }
}
