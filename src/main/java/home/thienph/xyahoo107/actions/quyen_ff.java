package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_ff implements Action {
   public quyen_ff(GameManager var1) {
   }

   public final void action() {
      GameGraphics.instance.initializeConnection();
      PacketSender.a();
   }
}
