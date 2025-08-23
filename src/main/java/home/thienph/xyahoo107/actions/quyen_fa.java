package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;

final class quyen_fa implements Action {
   private quyen_ez a;

   quyen_fa(quyen_ez var1) {
      this.a = var1;
   }

   public final void action() {
      quyen_ez var1 = this.a;
      if (GameManager.getInputHandler(this.a.a).getText() != null) {
         var1 = this.a;
         if (GameManager.getInputHandler(this.a.a).getText().length() > 0) {
            var1 = this.a;
            PacketSender.f(GameManager.getInputHandler(this.a.a).getText());
         }
      }
   }
}
