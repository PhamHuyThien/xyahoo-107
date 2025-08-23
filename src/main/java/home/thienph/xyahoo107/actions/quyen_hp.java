package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;

public final class quyen_hp implements Action {
   private ChatScreen a;

   public quyen_hp(ChatScreen var1) {
      this.a = var1;
   }

   public final void action() {
      String var1;
      if (!(var1 = this.a.chatComponent.getFullSelectedMessage()).equals("")) {
         GameManager.emptyString = var1;
      }
   }
}
