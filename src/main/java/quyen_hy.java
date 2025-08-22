import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

public final class quyen_hy extends Form implements CommandListener {
   private ChoiceGroup c;
   private TextField d;
   public static quyen_hy a;
   private Command e;
   private Command f;
   private Command g;
   private Command h;
   private String i;
   public byte[] b;

   public static final quyen_hy a() {
      if (a == null) {
         a = new quyen_hy();
      }

      return a;
   }

   public quyen_hy() {
      super("Lưu file");
      quyen_bn.a();
      String[] var1 = quyen_bn.d();
      this.c = new ChoiceGroup("Chọn định dạng của tập tin", 1, var1, null);
      this.d = new TextField("Tên file", "", 1024, 0);
      this.append(this.d);
      this.append(this.c);
      this.e = new Command("Xem lại", 1, 1);
      this.f = new Command("Gửi", 1, 1);
      this.g = new Command("Lưu", 4, 0);
      this.h = new Command(quyen_cr.c(), 3, 0);
      this.addCommand(this.e);
      this.addCommand(this.f);
      this.addCommand(this.g);
      this.addCommand(this.h);
      this.setCommandListener(this);
      Display.getDisplay(Xuka.i).setCurrent(this);
   }

   public final void a(String var1) {
      this.d.setString(var1);
   }

   public final void b() {
      this.c = null;
      this.d = null;
      this.i = null;
      this.b = null;
      a = null;
      quyen_et.c.H();
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (var1.getLabel().equals(quyen_cr.c())) {
         quyen_et.a();
         this.b();
      } else {
         String var3 = this.d.getString().trim();
         String var4 = this.c.getString(this.c.getSelectedIndex()).toString().trim();
         var4 = quyen_bn.a().f(var4);
         this.i = var3 + var4;
         if (var1 == this.g) {
            quyen_eb.a();
            if (quyen_eb.a(this.d.getString())) {
               quyen_n.b();
               quyen_bn var6;
               (var6 = quyen_bn.a()).a(0);

               try {
                  quyen_bk var7 = quyen_bk.a();
                  var6.c = new quyen_hz(this, var6, var7);
                  var6.a("Chọn thư mục", 2);
               } catch (ClassNotFoundException var5) {
                  quyen_et.a("Xubi", "Điện thoại không hỗ trợ chức năng này", true);
               }
            } else {
               quyen_et.e();
               quyen_et.a("Xubi", "Tên file không hợp lệ", true);
            }
         } else if (var1 == this.f) {
            if (this.b != null) {
               quyen_et.c.a(this.i, this.b, (byte)1);
               quyen_et.c.I();
            } else {
               c();
            }
         } else {
            if (var1 == this.e) {
               if (this.b != null) {
                  quyen_et.a(this.b, this.i, false, 0);
                  return;
               }

               c();
            }
         }
      }
   }

   private static void c() {
      Alert var0 = new Alert("X Yahoo!", "Bạn chưa quay video", null, AlertType.ERROR);
      Display.getDisplay(Xuka.i).setCurrent(var0);
   }

   static String a(quyen_hy var0) {
      return var0.i;
   }
}
