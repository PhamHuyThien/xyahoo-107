public final class Packet {
   private int commandId;
   private int typeId;
   private ByteBuffer payload;

   public Packet() {
      this.payload = new ByteBuffer();
   }

   public Packet(int var1, int var2) {
      this.commandId = var1;
      this.typeId = var2;
      this.payload = new ByteBuffer();
   }

   Packet(int var1, int var2, byte[] var3) {
      this.commandId = var1;
      this.typeId = var2;
      this.payload = new ByteBuffer(var3);
   }

   public final int getCommandId() {
      return this.commandId;
   }

   public final ByteBuffer getPayload() {
      return this.payload;
   }

   public final void setPayload(ByteBuffer var1) {
      this.payload = var1;
   }

   public final int getTypeId() {
      return this.typeId;
   }
}
