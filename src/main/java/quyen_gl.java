import javax.microedition.io.ConnectionNotFoundException;

final class quyen_gl implements Action {
   private final String a;

   quyen_gl(GameManager var1, String var2) {
      this.a = var2;
   }

   public final void action() {
      try {
         Xuka.instance.platformRequest(this.a);
      } catch (ConnectionNotFoundException var2) {
      }

      try {
         Thread.sleep(2000L);
      } catch (InterruptedException var1) {
      }

      Xuka.shutdown();
   }
}
