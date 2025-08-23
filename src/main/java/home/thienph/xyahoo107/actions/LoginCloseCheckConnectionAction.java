package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;

public final class LoginCloseCheckConnectionAction implements Action {
    public LoginCloseCheckConnectionAction(GameManager var1) {
    }

    public void action() {
        Xuka.shutdown();
    }
}
