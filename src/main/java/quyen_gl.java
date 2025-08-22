import javax.microedition.io.ConnectionNotFoundException;

final class quyen_gl implements quyen_ca {
   private final String a;

   quyen_gl(quyen_et var1, String var2) {
      this.a = var2;
   }

   public final void a() {
      try {
         Xuka.i.platformRequest(this.a);
      } catch (ConnectionNotFoundException var2) {
      }

      try {
         Thread.sleep(2000L);
      } catch (InterruptedException var1) {
      }

      Xuka.a();
   }
}
