package home.thienph.xyahoo107.tasks;

import home.thienph.xyahoo107.actions.Action;
import home.thienph.xyahoo107.forms.FileBrowserList;

public final class ActionExecutor implements Runnable {
    private final Action action;

    public ActionExecutor(FileBrowserList var1, Action var2) {
        this.action = var2;
    }

    public void run() {
        FileBrowserList.isLoading = true;
        this.action.action();
        FileBrowserList.isLoading = false;
    }
}
