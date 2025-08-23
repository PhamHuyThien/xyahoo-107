package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.RegistrationScreen;

public final class quyen_gy implements Action {
    private final RegistrationScreen a;

    public quyen_gy(RegistrationScreen var1) {
        this.a = var1;
    }

    public void action() {
        GameGraphics.instance.initializeConnection();
        RegistrationScreen.setSuggestedUsername(this.a, this.a.usernameInput.getText());
        this.a.c = this.a.passwordInput.getText();
        PacketSender.sendAppInfo();
        PacketSender.h(this.a.finalUsername, this.a.passwordInput.getText());
    }
}
