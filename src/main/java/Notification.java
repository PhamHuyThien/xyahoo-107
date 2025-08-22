import javax.microedition.lcdui.Image;

public class Notification {
    public String a;
    public Image b;
    public long c;
    public long d;
    public boolean e = true;

    public Notification(int var1, String var2, byte[] var3, long var4, long var6, String var8, boolean var9) {
        try {
            this.b = Image.createImage(var3, 0, var3.length);
        } catch (Exception var10) {
        }

        this.a = var2;
        if (var8 != null && var8.length() > 0) {
            UIUtils.concatStrings(this.a, " ", var8, null);
            System.gc();
        }

        this.c = var4;
        this.d = var6;
        this.e = true;
    }
}
