final class quyen_dq implements Action {
    private GameScreen a;

    quyen_dq(GameScreen var1) {
        this.a = var1;
    }

    public final void action() {
        if (GameScreen.getBetInputComponent(this.a).getText().length() > 0) {
            this.a.removeComponent(GameScreen.getBetInputComponent(this.a));
            this.a.isBettingMode = false;
            UIUtils.focusComponent(this.a, GameScreen.getFocusedComponent(this.a));

            try {
                long var1 = Long.parseLong(GameScreen.getBetInputComponent(this.a).getText());
                if (GameScreen.totalRooms == 0) {
                    PacketSender.a(GameScreen.totalRooms, GameScreen.currentRoomId, this.a.roomOwner, var1);
                }
            } catch (Exception var3) {
            }

            GameScreen.adjustScroll(this.a);
            GameScreen.getBetInputComponent(this.a).setText("");
        }
    }
}
