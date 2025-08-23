package home.thienph.xyahoo107.data.packet;

public final class ByteBuffer {
    private byte[] buffer;
    private int length;
    private int position;

    public ByteBuffer() {
        this.buffer = new byte[32];
        this.position = 0;
    }

    public ByteBuffer(byte[] var1) {
        this.buffer = var1;
        this.position = 0;
        this.length = var1.length;
    }

    public void writeByte(byte var1) {
        this.buffer[this.position++] = var1;
        this.updateLength();
    }

    private void updateLength() {
        if (this.position > this.length) {
            this.length = this.position;
        }
    }

    public void ensureCapacity(int var1) {
        if ((var1 = this.position + var1) > this.buffer.length) {
            byte[] var3 = new byte[var1];
            System.arraycopy(this.buffer, 0, var3, 0, this.length);
            this.buffer = var3;
        }
    }

    public void writeBytes(byte[] var1, int var2, int var3) {
        System.arraycopy(var1, var2, this.buffer, this.position, var3);
        this.position += var3;
        this.updateLength();
    }

    public byte readByte() {
        return this.buffer[this.position++];
    }

    public byte[] readBytes(int var1) {
        byte[] var2 = new byte[var1];
        System.arraycopy(this.buffer, this.position, var2, 0, var1);
        this.position += var1;
        return var2;
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public int getLength() {
        return this.length;
    }
}
