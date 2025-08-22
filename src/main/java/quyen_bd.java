import java.util.Vector;

public final class quyen_bd {
   public Vector a;
   private String c;
   public int b;

   public quyen_bd(String var1) {
      this.c = var1;
      this.a = new Vector();
   }

   public final void a(quyen_ba var1) {
      this.a.addElement(var1);
   }

   public final void a(quyen_ba var1, int var2) {
      this.a.insertElementAt(var1, 0);
   }

   public final quyen_ba a(String var1) {
      int var2 = this.a.size();

      while (--var2 >= 0) {
         quyen_ba var3;
         if ((var3 = (quyen_ba)this.a.elementAt(var2)).a.equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   public final String a() {
      return this.c;
   }
}
