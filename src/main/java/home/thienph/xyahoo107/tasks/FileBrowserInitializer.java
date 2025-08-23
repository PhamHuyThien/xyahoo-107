package home.thienph.xyahoo107.tasks;

import home.thienph.xyahoo107.forms.FileBrowserList;
import home.thienph.xyahoo107.managers.GameManager;

public final class FileBrowserInitializer implements Runnable {
    private final FileBrowserList fileBrowserList;

    public FileBrowserInitializer(FileBrowserList var1) {
        this.fileBrowserList = var1;
    }

    public void run() {
        try {
            Thread.sleep(150L);

            try {
                FileBrowserList.setCurrentPath("/");
                this.fileBrowserList.refreshFileList();
            } catch (Exception var1) {
                GameManager.getInstance();
                GameManager.showAlert("Xubi", "Điện thoại không hỗ trợ chức năng này", true);
            }
        } catch (Exception var2) {
        }
    }
}
