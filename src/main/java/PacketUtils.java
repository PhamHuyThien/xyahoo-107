public class PacketUtils {
    public static short readShort(Packet var0) {
        short var1 = 0;

        for (int var2 = 0; var2 < 2; var2++) {
            short var3;
            var1 = (short)((var3 = (short)(var1 << 8)) | 255 & var0.getPayload().readByte());
        }

        return var1;
    }

    public static byte[] readBytes(Packet var0) {
        int var1 = readInt(var0);
        return var0.getPayload().readBytes(var1);
    }

    public static long readLong(Packet var0) {
        long var1 = 0L;

        for (int var3 = 0; var3 < 8; var3++) {
            long var4;
            var1 = (var4 = var1 << 8) | (long)(255 & var0.getPayload().readByte());
        }

        return var1;
    }

    public static int readInt(Packet var0) {
        int var1 = 0;

        for (int var2 = 0; var2 < 4; var2++) {
            int var3;
            var1 = (var3 = var1 << 8) | 255 & var0.getPayload().readByte();
        }

        return var1;
    }

    public static boolean readBoolean(Packet var0) {
        return var0.getPayload().readByte() == 1;
    }

    public static char readChar(Packet var0) {
        return (char) readShort(var0);
    }

    public static String readString(Packet var0) {
        int var1 = readInt(var0);
        StringBuffer var2 = new StringBuffer(var1);

        for (int var3 = 0; var3 < var1; var3++) {
            var2.append(readChar(var0));
        }

        return var2.toString();
    }

    private static void writeLength(int var0, Packet var1) {
        for (int var2 = 3; var2 >= 0; var2--) {
            var1.getPayload().writeByte((byte)(var0 >> (var2 << 3)));
        }
    }

    public static void writeBytes(byte[] var0, int var1, int var2, Packet var3) {
        var3.getPayload().ensureCapacity(var2 + 4);
        writeLength(var2, var3);
        var3.getPayload().writeBytes(var0, var1, var2);
    }

    public static void writeByte(byte var0, Packet var1) {
        var1.getPayload().ensureCapacity(1);
        var1.getPayload().writeByte(var0);
    }

    public static void writeBoolean(boolean var0, Packet var1) {
        var1.getPayload().ensureCapacity(1);
        if (var0) {
            var1.getPayload().writeByte((byte)1);
        } else {
            var1.getPayload().writeByte((byte)0);
        }
    }

    public static void writeInt(int var0, Packet var1) {
        var1.getPayload().ensureCapacity(4);

        for (int var2 = 3; var2 >= 0; var2--) {
            var1.getPayload().writeByte((byte)(var0 >> (var2 << 3)));
        }
    }

    public static void writeLong(long var0, Packet var2) {
        var2.getPayload().ensureCapacity(8);

        for (int var3 = 7; var3 >= 0; var3--) {
            var2.getPayload().writeByte((byte)((int)(var0 >> (var3 << 3))));
        }
    }

    public static void writeString(String var0, Packet var1) {
        ByteBuffer var2 = var1.getPayload();
        int var3 = var0.length();
        var2.ensureCapacity(4 + 2 * var3);
        writeLength(var3, var1);

        for (int var7 = 0; var7 < var3; var7++) {
            short var10000 = (short)var0.charAt(var7);
            Packet var5 = var1;
            short var4 = var10000;

            for (int var6 = 1; var6 >= 0; var6--) {
                var5.getPayload().writeByte((byte)(var4 >> (var6 << 3)));
            }
        }
    }
}
