package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.connections.PacketSender;

final class quyen_em implements Action {
   private quyen_el a;

   quyen_em(quyen_el var1) {
      this.a = var1;
   }

   public final void action() {
      quyen_el var1 = this.a;
      if (this.a.loginScreen.c.getText() != null) {
         var1 = this.a;
         if (this.a.loginScreen.c.getText().length() > 0) {
            GameGraphics.instance.initializeConnection();
            var1 = this.a;
            PacketSender.f(this.a.loginScreen.c.getText());
         }
      }
   }
}
