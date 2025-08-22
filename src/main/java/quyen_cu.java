import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;

final class quyen_cu implements CommandListener {
   private quyen_cs a;
   private final TextBox b;

   quyen_cu(quyen_cs var1, TextBox var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (var1.getLabel().equals("OK")) {
         this.a.c(this.b.getString());
      }

      Display.getDisplay(quyen_cs.u).setCurrent(quyen_cs.g);
      quyen_cs.g.setFullScreenMode(true);
   }
}
