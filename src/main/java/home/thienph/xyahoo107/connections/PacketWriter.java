package home.thienph.xyahoo107.connections;

import home.thienph.xyahoo107.data.packet.ByteBuffer;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.managers.NetworkManager;

import java.util.Vector;

public final class PacketWriter implements Runnable {
    public final Vector packetQueue = new Vector();

    public PacketWriter() {
    }

    public final void addQueue(Packet var1) {
        this.packetQueue.addElement(var1);
    }

    private static byte[] intToByteArray(int var0) {
        byte[] var1 = new byte[4];

        for (int var2 = 3; var2 >= 0; var2--) {
            var1[var2] = (byte) var0;
            var0 >>= 8;
        }

        return var1;
    }

    public final void run() {
        while (NetworkManager.isConnected()) {
            try {
                while (this.packetQueue.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Packet packet = (Packet) this.packetQueue.elementAt(0);
                    this.packetQueue.removeElementAt(0);
                    ByteBuffer payload = packet.getPayload();
                    int packetLength = 8 + payload.getLength();
                    System.out.println("[OUT]command: " + packet.getCommandId() + " type: " + packet.getTypeId() + " length: " + packetLength);
                    byte[] headerPacketLength = intToByteArray(packetLength);
                    NetworkManager.getOutputStream().write(headerPacketLength, 0, 4);
                    NetworkManager.getOutputStream().write(intToByteArray(packet.getCommandId()), 0, 4);
                    NetworkManager.getOutputStream().write(intToByteArray(packet.getTypeId()), 0, 4);
                    NetworkManager.getOutputStream().write(payload.getBuffer(), 0, packetLength - 8);
                    NetworkManager.bytesSent += packetLength + 4;
                    NetworkManager.getOutputStream().flush();
                    long var7 = 100L - (System.currentTimeMillis() - currentTimeMillis);
                    if (var7 > 0L) Thread.sleep(var7);
                }
                Thread.sleep(50L);
            } catch (Exception var9) {
                System.out.println("write ex");
                var9.printStackTrace();
            }
        }

        NetworkManager.disconnect();
    }
}
