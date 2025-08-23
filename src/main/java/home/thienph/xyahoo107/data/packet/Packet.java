package home.thienph.xyahoo107.data.packet;

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

    public Packet(int var1, int var2, byte[] var3) {
        this.commandId = var1;
        this.typeId = var2;
        this.payload = new ByteBuffer(var3);
    }

    public int getCommandId() {
        return this.commandId;
    }

    public ByteBuffer getPayload() {
        return this.payload;
    }

    public void setPayload(ByteBuffer var1) {
        this.payload = var1;
    }

    public int getTypeId() {
        return this.typeId;
    }
}
