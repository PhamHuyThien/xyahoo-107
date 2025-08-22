import javax.microedition.io.Connector;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

final class quyen_jb implements Runnable {
   private final String a;
   private final String b;
   private final Action c;
   private final boolean d;
   private final Action e;

   quyen_jb(String var1, String var2, Action var3, boolean var4, Action var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public final void run() {
      try {
         MessageConnection var1 = null;
         TextMessage var2;
         (var2 = (TextMessage)(var1 = (MessageConnection)Connector.open(this.a)).newMessage("text")).setAddress(this.a);
         var2.setPayloadText(this.b);
         var1.send(var2);
         if (this.c == null) {
            GameManager.instance.closeDialog();
            GameManager.instance.d("Gửi SMS thành công");
         } else {
            this.c.action();
         }
      } catch (Exception var3) {
         if (this.d) {
            GameManager.instance.closeDialog();
         }

         if (this.e == null) {
            GameManager.instance.d("Lỗi gửi SMS");
         } else {
            this.e.action();
         }
      }
   }
}
