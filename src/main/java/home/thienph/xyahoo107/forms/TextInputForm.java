package home.thienph.xyahoo107.forms;

import home.thienph.xyahoo107.actions.Action;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.*;

public final class TextInputForm extends Form implements CommandListener {
    public static TextInputForm instance;
    private int formMode;
    public TextField textField = new TextField("", "", 1024, 0);
    public Action completionAction;

    public static TextInputForm getInstance() {
        if (instance == null) {
            instance = new TextInputForm();
        }

        return instance;
    }

    public TextInputForm() {
        super("");
        this.append(this.textField);
        this.addCommand(new Command("OK", 4, 1));
        this.addCommand(new Command(TextConstant.close(), 2, 1));
        this.setCommandListener(this);
    }

    public void setupForm(String var1, String var2, String var3, int var4) {
        this.setTitle(var1);
        this.formMode = 0;
        this.textField.setLabel(var2);
        this.textField.setString(var3);
    }

    public void commandAction(Command var1, Displayable var2) {
        if (var1.getLabel().equals("OK")) {
            if (this.formMode == 0) {
                if (!isValidFilename(this.textField.getString())) {
                    GameManager.getInstance();
                    GameManager.showAlert("Xubi", "Tên file không hợp lệ", true);
                    return;
                }

                GameManager.getInstance();
                GameManager.showMainScreen();
                if (this.completionAction != null) {
                    this.completionAction.action();
                }
            }
        } else if (var1.getLabel().equals(TextConstant.close())) {
            GameManager.getInstance();
            GameManager.showMainScreen();
        }
    }

    public static boolean isValidFilename(String var0) {
        if (var0 != null && var0.length() > 0) {
            for (int var1 = 0; var1 < UIUtils.INVALID_FILENAME_CHARS.length; var1++) {
                if (var0.indexOf(UIUtils.INVALID_FILENAME_CHARS[var1]) >= 0) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
