package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class quyen_ab implements Action {
   private ChatRoomScreen a;

   public quyen_ab(ChatRoomScreen var1) {
      this.a = var1;
   }

   public final void action() {
      if (!GameManager.emptyString.equals("")) {
         this.a.textInputComponent.insertText(GameManager.emptyString);
      }
   }
}
