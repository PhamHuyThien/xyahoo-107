package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;

public final class quyen_hh implements Action {
   private ChatScreen a;

   public quyen_hh(ChatScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().removeScreen(this.a);
   }
}
