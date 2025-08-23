package home.thienph.xyahoo107.data.game;

public final class CardInfo {
    public Integer cardId;
    public String levelText;

    public CardInfo() {
    }

    public CardInfo(byte var1, int var2, String var3, Integer var4, Integer var5, String var6) {
        this.cardId = var4;
        this.levelText = "Level " + var2 + " " + var3 + "%";
    }
}
