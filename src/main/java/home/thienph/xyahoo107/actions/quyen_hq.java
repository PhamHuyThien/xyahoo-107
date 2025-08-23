package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;

public final class quyen_hq implements Action {
   private ChatScreen a;

   public quyen_hq(ChatScreen var1) {
      this.a = var1;
   }

   public final void action() {
      if (!GameManager.emptyString.equals("")) {
         this.a.textInputComponent.insertText(GameManager.emptyString);
      }
   }
}
