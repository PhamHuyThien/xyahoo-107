package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;

public final class quyen_ib implements Action {
   public quyen_ib(FriendScreen var1) {
   }

   public final void action() {
      GameManager.instance.removeScreen(FriendScreen.instance);
   }
}
