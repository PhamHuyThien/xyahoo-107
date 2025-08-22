import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Display;

final class quyen_fo implements Action
{
   private GameManager a;

   quyen_fo(final GameManager a) {
      this.a = a;
   }

   public final void action() {
      GameGraphics.clearKeyStates();
      this.a.closeDialog();
      final quyen_hy a;
      (a = quyen_hy.a()).a(UIUtils.generateTimestampString((String)null));
      a.b = quyen_l.a().c.toByteArray();
      Display.getDisplay((MIDlet)Xuka.instance).setCurrent((Displayable)a);
   }
}
