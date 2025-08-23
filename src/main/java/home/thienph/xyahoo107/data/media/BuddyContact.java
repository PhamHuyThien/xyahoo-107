package home.thienph.xyahoo107.data.media;

import home.thienph.xyahoo107.data.game.CardInfo;

import javax.microedition.lcdui.Image;

public final class BuddyContact {
    public String username;
    public String displayName;
    public int statusCode;
    public String description;
    public int downloadType;
    public String downloadText;
    public boolean isSelected;
    public String fileName;
    private int[] rawDataArray;
    public Integer[] processedDataArray;
    public byte[] imageBytes;
    public int dataSize;
    public long timestamp;
    public Integer priority;
    private final int defaultColor = 16777215;
    public Image thumbnailImage;
    public CardInfo cardInfo;

    public int[] getRawDataArray() {
        return this.rawDataArray;
    }

    public void setRawDataArray(int[] var1) {
        this.rawDataArray = var1;
        if (var1 != null && var1.length > 0) {
            this.processedDataArray = new Integer[var1.length];

            for (int var2 = 0; var2 < var1.length; var2++) {
                this.processedDataArray[var2] = new Integer((short) ((short) var1[var2]));
            }
        }
    }

    public BuddyContact() {
    }

    public BuddyContact(String var1, String var2, int var3, String var4, int[] var5, int var6, int var7, String var8) {
        this.username = var1;
        this.displayName = !var2.equals("") && var2 != null ? var2 : var1;
        this.statusCode = var3;
        this.downloadText = var4;
        this.rawDataArray = var5;
        this.dataSize = var7;
        this.description = var8;
    }

    public int getDefaultColor() {
        return this.defaultColor;
    }
}
