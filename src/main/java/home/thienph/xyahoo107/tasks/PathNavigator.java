package home.thienph.xyahoo107.tasks;

import home.thienph.xyahoo107.forms.FileBrowserList;
import home.thienph.xyahoo107.managers.GameManager;

public final class PathNavigator implements Runnable {
    private final FileBrowserList fileBrowserList;
    private final String targetPath;

    public PathNavigator(FileBrowserList var1, String var2) {
        this.fileBrowserList = var1;
        this.targetPath = var2;
    }

    public void run() {
        if (FileBrowserList.getCurrentPath().equals("/")) {
            FileBrowserList.setCurrentPath(this.targetPath);
        } else if (this.targetPath.equals("..")) {
            int var1;
            if ((var1 = FileBrowserList.getCurrentPath().lastIndexOf(47, FileBrowserList.getCurrentPath().length() - 2)) != -1) {
                FileBrowserList.setCurrentPath(FileBrowserList.getCurrentPath().substring(0, var1 + 1));
            } else {
                FileBrowserList.setCurrentPath("/");
            }
        } else {
            FileBrowserList.setCurrentPath(FileBrowserList.getCurrentPath() + this.targetPath);
        }

        try {
            this.fileBrowserList.refreshFileList();
        } catch (Exception var2) {
            GameManager.instance.showWrappedTextDialog("ERROR: " + var2);
        }
    }
}
