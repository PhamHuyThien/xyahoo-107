package home.thienph.xyahoo107.forms;

import home.thienph.xyahoo107.components.TextInputComponent;

import javax.microedition.lcdui.*;

public final class TextBoxCommandListener implements CommandListener {
    private final TextInputComponent textInputComponent;
    private final TextBox textBox;

    public TextBoxCommandListener(TextInputComponent var1, TextBox var2) {
        this.textInputComponent = var1;
        this.textBox = var2;
    }

    public void commandAction(Command var1, Displayable var2) {
        if (var1.getLabel().equals("OK")) {
            this.textInputComponent.setText(this.textBox.getString());
        }

        Display.getDisplay(TextInputComponent.parentMidlet).setCurrent(TextInputComponent.currentCanvas);
        TextInputComponent.currentCanvas.setFullScreenMode(true);
    }
}
