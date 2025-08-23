import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;

final class TextBoxCommandListener implements CommandListener {
   private TextInputComponent textInputComponent;
   private final TextBox textBox;

   TextBoxCommandListener(TextInputComponent var1, TextBox var2) {
      this.textInputComponent = var1;
      this.textBox = var2;
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (var1.getLabel().equals("OK")) {
         this.textInputComponent.setText(this.textBox.getString());
      }

      Display.getDisplay(TextInputComponent.parentMidlet).setCurrent(TextInputComponent.currentCanvas);
      TextInputComponent.currentCanvas.setFullScreenMode(true);
   }
}
