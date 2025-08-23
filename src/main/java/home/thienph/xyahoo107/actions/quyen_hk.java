package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;

public final class quyen_hk implements Action {
   public quyen_hk(ChatScreen var1) {
   }

   public final void action() {
      GameManager.getInstance().showEmojiPicker(0);
   }
}
