package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;

public final class quyen_hi implements Action {
   private ChatScreen a;

   public quyen_hi(ChatScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().showContextMenu(ChatScreen.getContextMenu(this.a), 0);
   }
}
