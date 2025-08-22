import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;

final class quyen_cu implements CommandListener {
   private TextInputComponent a;
   private final TextBox b;

   quyen_cu(TextInputComponent var1, TextBox var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (var1.getLabel().equals("OK")) {
         this.a.setText(this.b.getString());
      }

      Display.getDisplay(TextInputComponent.parentMidlet).setCurrent(TextInputComponent.currentCanvas);
      TextInputComponent.currentCanvas.setFullScreenMode(true);
   }
}
