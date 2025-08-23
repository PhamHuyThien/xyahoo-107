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
      final SaveFileForm a;
      (a = SaveFileForm.getInstance()).setFileName(UIUtils.generateTimestampString((String)null));
      a.fileData = CameraCanvas.getInstance().recordOutputStream.toByteArray();
      Display.getDisplay((MIDlet)Xuka.instance).setCurrent((Displayable)a);
   }
}
