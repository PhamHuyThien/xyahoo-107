package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_ha implements Action {
    public void action() {
        GameManager.instance.joinScreenByActionId(11115, false);
    }
}
