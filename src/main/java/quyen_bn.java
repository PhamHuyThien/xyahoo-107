import javax.microedition.media.Manager;
import java.util.Vector;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.List;

public final class quyen_bn extends List implements CommandListener
{
   public static quyen_bn a;
   public static boolean b;
   private int d;
   private static String e;
   public quyen_ca c;
   private Command f;
   private Command g;
   private Command h;
   private Command i;
   private Command j;
   private String[] k;
   private String[] l;
   private int m;

   public static quyen_bn a() {
      if (quyen_bn.a == null) {
         quyen_bn.a = new quyen_bn();
      }
      return quyen_bn.a;
   }

   public final void a(final String title, final int d) {
      if (quyen_bn.b) {
         quyen_et.e().d("Vui l\u00f2ng ch\u1edd");
         return;
      }
      this.removeCommand(this.f);
      this.removeCommand(this.g);
      this.removeCommand(this.h);
      this.removeCommand(this.i);
      this.removeCommand(this.j);
      ((Displayable)this).addCommand(this.h);
      ((Displayable)this).addCommand(this.g);
      if ((this.d = d) == 2) {
         this.setSelectCommand(this.j);
      }
      else if (d == 0) {
         this.setSelectCommand(this.f);
      }
      else if (d == 1) {
         this.setSelectCommand(this.i);
      }
      this.setTitle(title);
      Display.getDisplay((MIDlet)Xuka.i).setCurrent((Displayable)this);
      new Thread(new quyen_bo(this)).start();
   }

   protected quyen_bn() {
      super("", 3);
      this.k = new String[] { ".png", ".jpg", ".jpeg", ".gif", ".psd", ".tif", ".bmp" };
      this.l = new String[] { ".3g2", ".3gp", ".asf", ".avi", ".flv", ".mov", ".mp4", ".mpg", ".mpeg", ".rm", ".wmv", "swf" };
      quyen_bn.e = "/";
      this.h = new Command("M\u1edf", 1, 1);
      this.g = new Command(quyen_cr.c(), 2, 1);
      this.f = new Command("G\u1eedi", 4, 1);
      this.i = new Command("Chia s\u1ebb", 4, 1);
      this.j = new Command("L\u01b0u", 4, 1);
      ((Displayable)this).setCommandListener((CommandListener)this);
   }

   private void h(String s) {
      s = s;
      new Thread(new quyen_bp(this, s)).start();
   }

   private void a(quyen_ca quyen_ca) {
      if ((quyen_ca = quyen_ca) != null) {
         new Thread(new quyen_bq(this, quyen_ca)).start();
      }
   }

   public static boolean a(final String s) {
      return s != null && s.length() != 0 && !s.endsWith("/") && !s.equals("..");
   }

   public final byte b(String lowerCase) {
      lowerCase = lowerCase.toLowerCase();
      for (int i = 0; i < this.k.length; ++i) {
         if (lowerCase.endsWith(this.k[i])) {
            return 0;
         }
      }
      for (int j = 0; j < this.l.length; ++j) {
         if (lowerCase.endsWith(this.l[j])) {
            return 1;
         }
      }
      return -1;
   }

   public final boolean c(String lowerCase) {
      lowerCase = lowerCase.toLowerCase();
      return this.d(lowerCase) || this.e(lowerCase) || a(lowerCase, this.k) || a(lowerCase, this.l);
   }

   private static boolean a(String lowerCase, final String[] array) {
      lowerCase = lowerCase.toLowerCase();
      for (int i = 0; i < array.length; ++i) {
         if (lowerCase.endsWith(array[i])) {
            return true;
         }
      }
      return false;
   }

   public final boolean d(final String s) {
      return a(s, new String[] { ".png" });
   }

   public final boolean e(final String s) {
      final String[] d;
      int length = (d = d()).length;
      while (--length >= 0) {
         d[length] = this.f(d[length]);
      }
      System.gc();
      return a(s, d);
   }

   public final void a(final int m) {
      this.m = m;
   }

   public final void commandAction(final Command command, final Displayable displayable) {
      if (!command.getLabel().equals(quyen_cr.c())) {
         if (command.getLabel().equals("G\u1eedi")) {
            try {
               if (this.d != 0) {
                  return;
               }
               final String string;
               if (!(string = this.getString(this.getSelectedIndex())).endsWith("/") && !string.equals("..")) {
                  this.a((quyen_ca)null);
                  return;
               }
               this.h(string);
               return;
            }
            catch (final Exception ex) {
               return;
            }
         }
         if (command.getLabel().equals("M\u1edf")) {
            try {
               final String string2 = this.getString(this.getSelectedIndex());
               if (this.d == 2) {
                  if (string2.endsWith("/") || string2.equals("..")) {
                     this.h(string2);
                  }
                  return;
               }
               else {
                  if (!string2.endsWith("/") && !string2.equals("..")) {
                     this.a(this.c);
                     return;
                  }
                  this.h(string2);
                  return;
               }
            }
            catch (final Exception ex2) {
               return;
            }
         }
         if (command.getLabel().equals("L\u01b0u")) {
            if (this.d == 2) {
               this.a(this.c);
            }
         }
         else if (command.getLabel().equals("Chia s\u1ebb") && this.d == 1) {
            this.a((quyen_ca)null);
         }
         return;
      }
      if (this.m == 0) {
         Display.getDisplay((MIDlet)Xuka.i).setCurrent((Displayable)quyen_hy.a());
         return;
      }
      if (this.m == 1) {
         quyen_ht.a().a(2);
         Display.getDisplay((MIDlet)Xuka.i).setCurrent((Displayable)quyen_ht.a());
         return;
      }
      quyen_et.e();
      quyen_et.a();
   }

   public final String a(final boolean b) {
      final String string;
      if ((string = this.getString(this.getSelectedIndex())).endsWith("/") || string.equals("..")) {
         return null;
      }
      if (b) {
         return quyen_hr.a("file:///", quyen_bn.e, string, null);
      }
      return string;
   }

   public static String b() {
      return quyen_hr.a("file:///", quyen_bn.e, null, null);
   }

   public final void c() {
      new Thread(new quyen_br(this)).start();
   }

   public final String f(String obj) {
      final String s = obj;
      final String s2 = "/";
      obj = s;
      final Vector vector = new Vector();
      final String s3 = s2;
      for (int i = obj.indexOf(s3); i >= 0; i = (obj = obj.substring(i + s3.length())).indexOf(s3)) {
         vector.addElement(obj.substring(0, i));
      }
      vector.addElement(obj);
      final String[] array = new String[vector.size()];
      if (vector.size() > 0) {
         for (int j = 0; j < vector.size(); ++j) {
            array[j] = (String)vector.elementAt(j);
         }
      }
      if ((obj = array[1]).toLowerCase().equals("mpeg")) {
         obj = ".mpg";
      }
      else if (obj.toLowerCase().equals("3gpp")) {
         obj = ".3gp";
      }
      else if (obj.toLowerCase().equals("3gpp2")) {
         obj = ".3g2";
      }
      else if (obj.toLowerCase().equals("mpeg4")) {
         obj = ".mp4";
      }
      else {
         obj = "." + obj.toLowerCase();
      }
      return obj;
   }

   public static String[] d() {
      final String[] supportedContentTypes;
      final int length;
      final int[] array = new int[length = (supportedContentTypes = Manager.getSupportedContentTypes((String)null)).length];
      int n = 0;
      for (int i = 0; i < length; ++i) {
         if (supportedContentTypes[i].length() != 5 && supportedContentTypes[i].substring(0, 5).toLowerCase().equals("video")) {
            array[n] = i;
            ++n;
         }
      }
      final String[] array2 = new String[n];
      for (int j = 0; j < n; ++j) {
         array2[j] = supportedContentTypes[array[j]];
      }
      return array2;
   }

   static void g(final String e) {
      quyen_bn.e = e;
   }

   static String e() {
      return quyen_bn.e;
   }
}
