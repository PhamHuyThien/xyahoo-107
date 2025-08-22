import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Display;

final class quyen_fo implements quyen_ca
{
   private quyen_et a;

   quyen_fo(final quyen_et a) {
      this.a = a;
   }

   public final void a() {
      quyen_n.b();
      this.a.f();
      final quyen_hy a;
      (a = quyen_hy.a()).a(quyen_hr.a((String)null));
      a.b = quyen_l.a().c.toByteArray();
      Display.getDisplay((MIDlet)Xuka.i).setCurrent((Displayable)a);
   }
}
