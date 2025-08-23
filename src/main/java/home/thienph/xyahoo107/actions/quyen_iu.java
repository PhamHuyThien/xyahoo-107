package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.UIFactory;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class quyen_iu implements Action {
   final FriendScreen a;

   public quyen_iu(FriendScreen var1) {
      this.a = var1;
   }

   public final void action() {
      if (this.a.isSearchMode) {
         FriendScreen.getSearchInput(this.a).setText("");
         this.a.mainContactList.setSearchFilter("");
         FriendScreen.exitSearchMode(this.a);
      }

      if (FriendScreen.getActiveTextInput(this.a) == null) {
         FriendScreen.setActiveTextInput(this.a, UIFactory.createPopupDialog(this.a, "Vui lòng nhập Xubi ID", 0, null));
      }

      if (FriendScreen.getPrimaryAction(this.a) == null) {
         FriendScreen.setPrimaryAction(this.a, new quyen_iv(this));
      }

      FriendScreen.getActiveTextInput(this.a).alternateAction = FriendScreen.getPrimaryAction(this.a);
      this.a.addComponent(FriendScreen.getActiveTextInput(this.a));
      UIUtils.showTextInput(this.a, FriendScreen.getActiveTextInput(this.a));
   }
}
