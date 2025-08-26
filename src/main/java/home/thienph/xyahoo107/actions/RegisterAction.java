package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.RegistrationScreen;

public final class RegisterAction implements Action {
    private final RegistrationScreen registrationScreen;

    public RegisterAction(RegistrationScreen registrationScreen) {
        this.registrationScreen = registrationScreen;
    }

    public void action() {
        GameGraphics.instance.initializeConnection();
        RegistrationScreen.setSuggestedUsername(this.registrationScreen, this.registrationScreen.usernameInput.getText());
        this.registrationScreen.finalPassword = this.registrationScreen.passwordInput.getText();
        PacketSender.sendAppInfo();
        PacketSender.registerUser(this.registrationScreen.finalUsername, this.registrationScreen.passwordInput.getText());
    }
}
