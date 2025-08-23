package home.thienph.xyahoo107.managers;

import home.thienph.xyahoo107.connections.ConnectionTask;
import home.thienph.xyahoo107.connections.PacketHandler;
import home.thienph.xyahoo107.connections.PacketWriter;
import home.thienph.xyahoo107.data.packet.Packet;

import javax.microedition.io.SocketConnection;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.util.Hashtable;

public final class NetworkManager {
    private static DataOutputStream outputStream;
    public static InputStream inputStream;
    public static PacketHandler packetHandler;
    private static SocketConnection socketConnection;
    public static boolean isConnected;
    public static boolean isConnecting;
    private static final PacketWriter packetWriter = new PacketWriter();
    private static Thread connectThread;
    public static Thread readThread;
    public static Thread writeThread;
    public static int bytesSent;
    public static int bytesReceived;
    private static final int packetHeaderSize = 4;
    private static final Hashtable handlerMap = new Hashtable();
    public static boolean forceDisconnect;

    public static boolean isConnected() {
        return isConnected;
    }

    public static void registerHandler(int var0, PacketHandler var1) {
        Integer var2 = new Integer(var0);
        handlerMap.put(var2, var1);
    }

    public static void connect(String var0, String var1, int var2, int var3) {
        if (!isConnected && !isConnecting) {
            socketConnection = null;
            connectThread = new Thread(new ConnectionTask(var0, var1, var2, var3));
            connectThread.start();
        }
    }

    public static void sendPacket(Packet var0) {
        packetWriter.addQueue(var0);
    }

    public static void disconnect() {
        try {
            if (!forceDisconnect && packetHandler != null) {
                try {
                    packetHandler.onConnectionLost();
                } catch (Exception var1) {
                    System.err.println("[NetworkManager.disconnect] handler ex " + var1);
                    var1.printStackTrace();
                }
            }

            if (socketConnection != null) {
                cleanup();
            }
        } catch (Exception var2) {
            System.err.println("[NetworkManager.disconnect] con ex " + var2);
            var2.printStackTrace();
        }
    }

    public static void forceDisconnect() {
        cleanup();
    }

    public static void cleanup() {
        try {
            isConnected = false;
            isConnecting = false;
            if (socketConnection != null) {
                try {
                    socketConnection.close();
                } catch (Exception var3) {
                }

                socketConnection = null;
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception var2) {
                }

                outputStream = null;
            }

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception var1) {
                }

                inputStream = null;
            }

            writeThread = null;
            readThread = null;
            if (packetWriter != null && packetWriter.packetQueue != null) {
                packetWriter.packetQueue.removeAllElements();
            }

            System.gc();
        } catch (Exception var4) {
            var4.printStackTrace();
        }
    }

    public static void setSocketConnection(SocketConnection var0) {
        socketConnection = var0;
    }

    public static SocketConnection getSocketConnection() {
        return socketConnection;
    }

    public static void getOutputStream(DataOutputStream var0) {
        outputStream = var0;
    }

    public static PacketWriter getPacketWriter() {
        return packetWriter;
    }

    public static DataOutputStream getOutputStream() {
        return outputStream;
    }

    public static Hashtable getHandlerMap() {
        return handlerMap;
    }

    public static int getPacketHeaderSize() {
        return packetHeaderSize;
    }
}
