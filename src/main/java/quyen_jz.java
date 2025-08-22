public abstract class quyen_jz {
   protected abstract void a(quyen_ju var1, int var2);

   public final void a(quyen_ju var1) {
      int var2 = var1.a();

      try {
         this.a(var1, var2);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("oops = " + var3.toString());
      }
   }

   public abstract void b();

   public abstract void c();

   public abstract void d();
}
