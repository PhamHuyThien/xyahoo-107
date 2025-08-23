package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;
import home.thienph.xyahoo107.screens.FriendScreen;

public final class quyen_io implements Action
{
   private FriendScreen a;
   private final DialogScreen b;

   public quyen_io(final FriendScreen a, final DialogScreen b) {
      this.a = a;
      this.b = b;
   }

   public final void action() {
      GameManager.instance.removeScreen(this.b);
      FriendScreen.setActiveTextInput(this.a, (TextInputComponent)null);
      System.gc();
   }
}
