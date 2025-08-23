package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.managers.NetworkManager;
import home.thienph.xyahoo107.screens.LoginScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class LoginClickForgotPasswordAction implements Action {
    private final LoginScreen loginScreen;

    public LoginClickForgotPasswordAction(LoginScreen var1) {
        this.loginScreen = var1;
    }

    public void action() {
        if (this.loginScreen.usernameInput.getText().equals("")) {
            GameManager.getInstance().showWrappedTextDialog(UIUtils.concatStrings("Vui lòng nhập ID. ", "Bạn sẽ nhận mật khẩu qua tin nhắn.", null, null));
        } else {
            GameGraphics.instance.initializeConnection();
            PacketSender.sendAppInfo();
            NetworkManager.sendPacket(new Packet(269, 2));
            GameManager.instance.setLoadingState(true);
        }
    }
}
