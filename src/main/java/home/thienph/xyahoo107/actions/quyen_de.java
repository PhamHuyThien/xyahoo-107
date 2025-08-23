package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_de implements Action {
   private GameScreen a;
   private final int b;

   public quyen_de(GameScreen var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void action() {
      PacketSender.i(this.a.playerComponents[this.b].playerName);
   }
}
