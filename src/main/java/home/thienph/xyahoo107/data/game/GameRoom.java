package home.thienph.xyahoo107.data.game;

public final class GameRoom {
   public String roomId;
   private byte playerCount;
   public byte roomStatus;
   public String roomName;

   public final byte getPlayerCount() {
      return this.playerCount;
   }

   public final void setPlayerCount(byte var1) {
      this.playerCount = var1;
      new StringBuffer(String.valueOf(var1)).toString();
   }
}
