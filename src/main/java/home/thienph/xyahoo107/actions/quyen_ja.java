package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.screens.FriendScreen;

public final class quyen_ja implements Action {
    private final FriendScreen a;

    public quyen_ja(FriendScreen var1) {
        this.a = var1;
    }

    public void action() {
        if (FriendScreen.isAvatarEnabled = !FriendScreen.isAvatarEnabled) {
            this.a.mainContactList.resetAnimation();
        }

        Xuka.saveBooleanSetting("onavt", FriendScreen.isAvatarEnabled);
    }
}
