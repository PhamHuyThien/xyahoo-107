package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.UIFactory;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.UIUtils;

public final class quyen_ez implements Action {
    final GameManager a;

    public quyen_ez(GameManager var1) {
        this.a = var1;
    }

    public void action() {
        if (GameManager.getInputHandler(this.a) == null || !GameManager.getInputHandler(this.a).isHelpTextEquals("Gửi góp ý")) {
            GameManager.setInputHandler(this.a, UIFactory.createPopupDialog(this.a.mainMenu, "Gửi góp ý", 0, new quyen_fa(this)));
        }

        UIUtils.showTextInput(this.a.mainMenu, GameManager.getInputHandler(this.a));
    }
}
