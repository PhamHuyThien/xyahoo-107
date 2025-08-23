package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class quyen_ad implements Action {
   private ChatRoomScreen a;

   public quyen_ad(ChatRoomScreen var1) {
      this.a = var1;
   }

   public final void action() {
      PacketSender.b(this.a.roomId, 4806);
   }
}
