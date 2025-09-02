package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ButtonAction;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.UIUtils;

public final class MainFeedbackAction implements Action {
    final GameManager gameManager;

    public MainFeedbackAction(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void action() {
        if (GameManager.getInputHandler(this.gameManager) == null || !GameManager.getInputHandler(this.gameManager).isHelpTextEquals("Gửi góp ý")) {
            GameManager.setInputHandler(this.gameManager, ButtonAction.createTextInputPopup(this.gameManager.mainMenu, "Gửi góp ý", 0, new quyen_fa(this)));
        }

        UIUtils.showTextInputPopup(this.gameManager.mainMenu, GameManager.getInputHandler(this.gameManager));
    }
}
