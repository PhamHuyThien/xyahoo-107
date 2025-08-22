import java.util.Vector;

public final class quyen_bb {
   public Vector a = new Vector();

   public final boolean a(String var1, long var2) {
      quyen_bd var5;
      if ((var5 = this.a(var1)) != null) {
         int var4 = var5.a.size();

         while (--var4 >= 0) {
            if (((quyen_ba)var5.a.elementAt(var4)).l == var2) {
               return true;
            }
         }
      }

      return false;
   }

   public final quyen_bd a(String var1) {
      int var2 = this.a.size();

      while (--var2 >= 0) {
         quyen_bd var3;
         if ((var3 = (quyen_bd)this.a.elementAt(var2)).a().equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   public final quyen_ba a(String var1, String var2, long var3) {
      int var5 = this.a.size();

      while (--var5 >= 0) {
         quyen_bd var6;
         int var7 = (var6 = (quyen_bd)this.a.elementAt(var5)).a.size();

         while (--var7 >= 0) {
            quyen_ba var8 = (quyen_ba)var6.a.elementAt(var7);
            if (var1 != null) {
               if (var8.a.equals(var1)) {
                  return var8;
               }
            } else if (var2 != null) {
               if (var8.h.equals(var2)) {
                  return var8;
               }
            } else if (var8.l == var3) {
               return var8;
            }
         }
      }

      return null;
   }

   public final void a(String var1, quyen_ba var2) {
      for (int var3 = this.a.size() - 1; var3 >= 0; var3--) {
         if (((quyen_bd)this.a.elementAt(var3)).a().equals(var1)) {
            ((quyen_bd)this.a.elementAt(var3)).a(var2);
            return;
         }
      }

      quyen_bd var4;
      (var4 = new quyen_bd(var1)).a(var2);
      this.a.addElement(var4);
   }

   public final void b(String var1, quyen_ba var2) {
      int var3 = this.a.size();

      while (--var3 >= 0) {
         if (((quyen_bd)this.a.elementAt(var3)).a().equals(var1)) {
            ((quyen_bd)this.a.elementAt(var3)).a(var2, 0);
            return;
         }
      }

      quyen_bd var4;
      (var4 = new quyen_bd(var1)).a(var2, 0);
      this.a.insertElementAt(var4, 0);
   }

   private static void a(quyen_ba var0) {
      var0.j = null;
      var0.i = null;
      System.gc();
   }

   public final void b(String var1, long var2) {
      for (int var4 = this.a.size() - 1; var4 >= 0; var4--) {
         quyen_bd var5;
         for (int var6 = (var5 = (quyen_bd)this.a.elementAt(var4)).a.size() - 1; var6 >= 0; var6--) {
            quyen_ba var7 = (quyen_ba)var5.a.elementAt(var6);
            if (var1 != null) {
               if (var7.a.equals(var1)) {
                  var5.a.removeElementAt(var6);
                  a(var7);
               }
            } else if (var7.l == var2) {
               var5.a.removeElementAt(var6);
               a(var7);
            }
         }
      }
   }

   public final void a(String var1, long[] var2, String[] var3) {
      if (var2.length != 0) {
         int var4 = 0;
         int var5 = this.a.size();

         while (--var5 >= 0) {
            quyen_bd var6;
            if ((var6 = (quyen_bd)this.a.elementAt(var5)).a().equals(var1)) {
               int var7 = 0;

               for (int var8 = var6.a.size(); var7 < var8; var7++) {
                  quyen_ba var9;
                  if ((var9 = (quyen_ba)var6.a.elementAt(var7)).l == var2[var4]) {
                     var9.c = 1;
                     var9.f = var3[var4];
                     if (var4 < var2.length - 1) {
                        var4++;
                     }
                  } else {
                     var9.c = 0;
                  }
               }
            }
         }
      }
   }
}
