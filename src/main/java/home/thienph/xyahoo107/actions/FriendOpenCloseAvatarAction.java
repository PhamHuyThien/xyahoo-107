package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.screens.FriendScreen;

public final class FriendOpenCloseAvatarAction implements Action {
    private final FriendScreen friendScreen;

    public FriendOpenCloseAvatarAction(FriendScreen var1) {
        this.friendScreen = var1;
    }

    public void action() {
        if (FriendScreen.isAvatarEnabled = !FriendScreen.isAvatarEnabled) {
            this.friendScreen.friendsComponent.resetAnimation();
        }

        Xuka.saveBooleanSetting("onavt", FriendScreen.isAvatarEnabled);
    }
}
