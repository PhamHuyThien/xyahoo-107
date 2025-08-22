import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

public final class quyen_eb extends Form implements CommandListener {
   public static quyen_eb a;
   private int d;
   public TextField b = new TextField("", "", 1024, 0);
   quyen_ca c;

   public static final quyen_eb a() {
      if (a == null) {
         a = new quyen_eb();
      }

      return a;
   }

   public quyen_eb() {
      super("");
      this.append(this.b);
      this.addCommand(new Command("OK", 4, 1));
      this.addCommand(new Command(quyen_cr.c(), 2, 1));
      this.setCommandListener(this);
   }

   public final void a(String var1, String var2, String var3, int var4) {
      this.setTitle(var1);
      this.d = 0;
      this.b.setLabel(var2);
      this.b.setString(var3);
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (var1.getLabel().equals("OK")) {
         if (this.d == 0) {
            if (!a(this.b.getString())) {
               quyen_et.e();
               quyen_et.a("Xubi", "Tên file không hợp lệ", true);
               return;
            }

            quyen_et.e();
            quyen_et.a();
            if (this.c != null) {
               this.c.a();
               return;
            }
         }
      } else if (var1.getLabel().equals(quyen_cr.c())) {
         quyen_et.e();
         quyen_et.a();
      }
   }

   public static boolean a(String var0) {
      if (var0 != null && var0.length() > 0) {
         for (int var1 = 0; var1 < quyen_hr.a.length; var1++) {
            if (var0.indexOf(quyen_hr.a[var1]) >= 0) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }
}
