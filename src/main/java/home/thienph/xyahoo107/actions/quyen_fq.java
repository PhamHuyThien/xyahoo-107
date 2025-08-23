package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_fq implements Action {
   public quyen_fq(GameManager var1) {
   }

   public final void action() {
      GameGraphics.instance.initializeConnection();
      PacketSender.c();
   }
}
