import javax.microedition.lcdui.Image;

public final class quyen_ba {
    public String a;
    public String b;
    public int c;
    public String d;
    public int e;
    public String f;
    public boolean g;
    public String h;
    private int[] p;
    public Integer[] i;
    public byte[] j;
    public int k;
    public long l;
    public Integer m;
    private int q = 16777215;
    public Image n;
    public quyen_bc o;

    public final int[] a() {
        return this.p;
    }

    public final void a(int[] var1) {
        this.p = var1;
        if (var1 != null && var1.length > 0) {
            this.i = new Integer[var1.length];

            for (int var2 = 0; var2 < var1.length; var2++) {
                this.i[var2] = new Integer((short)((short)var1[var2]));
            }
        }
    }

    public quyen_ba() {
    }

    public quyen_ba(String var1, String var2, int var3, String var4, int[] var5, int var6, int var7, String var8) {
        this.a = var1;
        this.b = !var2.equals("") && var2 != null ? var2 : var1;
        this.c = var3;
        this.f = var4;
        this.p = var5;
        this.k = var7;
        this.d = var8;
    }

    public final int b() {
        return this.q;
    }
}
