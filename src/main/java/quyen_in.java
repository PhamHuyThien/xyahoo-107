final class quyen_in implements Action {
    private FriendScreen a;

    quyen_in(FriendScreen var1) {
        this.a = var1;
    }

    public final void action() {
        GameManager.instance.addScreenToStack(this.a.offlineMessageScreen);
        this.a.offlineMessageScreen.startSlideAnimation(1);
        GameManager.instance.e(this.a.offlineMessageScreen);
    }
}
