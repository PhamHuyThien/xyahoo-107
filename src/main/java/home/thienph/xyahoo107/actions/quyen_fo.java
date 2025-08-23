package home.thienph.xyahoo107.actions;



import home.thienph.xyahoo107.canvas.CameraCanvas;
import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.forms.SaveFileForm;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Display;

public final class quyen_fo implements Action
{
   private GameManager a;

   public quyen_fo(final GameManager a) {
      this.a = a;
   }

   public final void action() {
      GameGraphics.clearKeyStates();
      this.a.closeDialog();
      final SaveFileForm a;
      (a = SaveFileForm.getInstance()).setFileName(UIUtils.generateTimestampString((String)null));
      a.fileData = CameraCanvas.getInstance().recordOutputStream.toByteArray();
      Display.getDisplay((MIDlet) Xuka.instance).setCurrent((Displayable)a);
   }
}
