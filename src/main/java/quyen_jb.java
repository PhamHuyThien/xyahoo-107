import javax.microedition.io.Connector;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

final class quyen_jb implements Runnable {
   private final String a;
   private final String b;
   private final quyen_ca c;
   private final boolean d;
   private final quyen_ca e;

   quyen_jb(String var1, String var2, quyen_ca var3, boolean var4, quyen_ca var5) {
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
            quyen_et.c.f();
            quyen_et.c.d("Gửi SMS thành công");
         } else {
            this.c.a();
         }
      } catch (Exception var3) {
         if (this.d) {
            quyen_et.c.f();
         }

         if (this.e == null) {
            quyen_et.c.d("Lỗi gửi SMS");
         } else {
            this.e.a();
         }
      }
   }
}
