package home.thienph.xyahoo107.data.media;

import home.thienph.xyahoo107.data.game.CardInfo;

import javax.microedition.lcdui.Image;

public final class BuddyInfo {
    public String username;
    public String displayName;
    public int statusCode;
    public String statusDescription;
    public int downloadType;
    public String description;
    public boolean isSelected;
    public String fileName;
    private int[] rawDataArray;
    public Integer[] processedDataArray;
    public byte[] imageBytes;
    public int dataSize;
    public long timestamp;
    public Integer imageSourceId;
    private final int defaultColor = 16777215;
    public Image thumbnailImage;
    public CardInfo cardInfo;

    public int[] getRawDataArray() {
        return this.rawDataArray;
    }

    public void setRawDataArray(int[] rawDataArray) {
        this.rawDataArray = rawDataArray;
        if (rawDataArray != null && rawDataArray.length > 0) {
            this.processedDataArray = new Integer[rawDataArray.length];

            for (int arrayIndex = 0; arrayIndex < rawDataArray.length; arrayIndex++) {
                this.processedDataArray[arrayIndex] = new Integer((short) ((short) rawDataArray[arrayIndex]));
            }
        }
    }

    public BuddyInfo() {
    }

    public BuddyInfo(String username, String displayName, int statusCode, String description, int[] rawDataArray, int downloadType, int dataSize, String statusDescription) {
        this.username = username;
        this.displayName = !displayName.equals("") && displayName != null ? displayName : username;
        this.statusCode = statusCode;
        this.description = description;
        this.rawDataArray = rawDataArray;
        this.dataSize = dataSize;
        this.statusDescription = statusDescription;
    }

    public int getDefaultColor() {
        return this.defaultColor;
    }
}