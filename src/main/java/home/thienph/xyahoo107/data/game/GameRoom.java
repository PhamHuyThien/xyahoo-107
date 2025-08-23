package home.thienph.xyahoo107.data.game;

public final class GameRoom {
    public String roomId;
    private byte playerCount;
    public byte roomStatus;
    public String roomName;

    public byte getPlayerCount() {
        return this.playerCount;
    }

    public void setPlayerCount(byte var1) {
        this.playerCount = var1;
        String.valueOf(var1);
    }
}
