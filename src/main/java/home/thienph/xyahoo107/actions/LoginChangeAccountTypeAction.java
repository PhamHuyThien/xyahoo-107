package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextComponent;
import home.thienph.xyahoo107.components.UIComponent;
import home.thienph.xyahoo107.screens.LoginScreen;
import home.thienph.xyahoo107.utils.FontRenderer;

public final class LoginChangeAccountTypeAction implements Action {
    private final LoginScreen loginScreen;

    public LoginChangeAccountTypeAction(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
    }

    public void action() {
        for (int var1 = 0; var1 < this.loginScreen.componentCount; var1++) {
            UIComponent var2;
            TextComponent var3;
            if ((var2 = (UIComponent) this.loginScreen.components.elementAt(var1)) instanceof TextComponent && ((var3 = (TextComponent) var2).text.equals("Xubi ID:") || var3.text.equals("Yahoo! ID:"))) {
                var3.text = this.loginScreen.accountTypeDropdown.getSelectedIndex() == 0 ? "Xubi ID:" : "Yahoo! ID:";
                var3.width = FontRenderer.getTextWidth(var3.text) + 5;
                return;
            }
        }
    }
}
