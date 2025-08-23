package home.thienph.xyahoo107.connections;

import home.thienph.xyahoo107.managers.NetworkManager;

import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;
import java.io.IOException;

public final class ConnectionTask implements Runnable {
    private final String primaryHost;
    private final String fallbackHost;
    private final int primaryPort;
    private final int fallbackPort;

    public ConnectionTask(String var1, String var2, int var3, int var4) {
        this.primaryHost = var1;
        this.fallbackHost = var2;
        this.primaryPort = var3;
        this.fallbackPort = var4;
    }

    public void run() {
        NetworkManager.isConnecting = true;
        NetworkManager.isConnected = true;

        try {
            connectToHost(this.primaryHost, this.primaryPort);
        } catch (Exception var4) {
            try {
                connectToHost(this.fallbackHost, this.fallbackPort);
            } catch (Exception var3) {
                NetworkManager.isConnected = false;

                try {
                    if (NetworkManager.packetHandler != null) {
                        NetworkManager.forceDisconnect();
                        NetworkManager.packetHandler.onConnectionError();
                    }
                } catch (Exception var2) {
                    var3.printStackTrace();
                }
            }
        }
    }

    private static void connectToHost(String ip, int port) throws IOException {
        System.out.print("Connecting");
        System.out.println("[ConnectionTask.connectToHost] ip = " + ip);
        System.out.println("[ConnectionTask.connectToHost] port = " + port);

        try {
            NetworkManager.setSocketConnection((SocketConnection) Connector.open("socket://" + ip + ":" + port));
        } catch (Exception var3) {
            System.err.println("[ConnectionTask.connectToHost] soc ex1");
            var3.printStackTrace();
            throw new IOException();
        }

        try {
            NetworkManager.getSocketConnection().setSocketOption((byte) 2, 1);
        } catch (Exception var2) {
            System.err.println("[ConnectionTask.connectToHost] soc ex2");
            var2.printStackTrace();
        }

        NetworkManager.getOutputStream(NetworkManager.getSocketConnection().openDataOutputStream());
        NetworkManager.inputStream = NetworkManager.getSocketConnection().openInputStream();
        (NetworkManager.writeThread = new Thread(NetworkManager.getPacketWriter())).start();
        (NetworkManager.readThread = new Thread(new PacketReader())).start();
        NetworkManager.isConnecting = false;
        NetworkManager.packetHandler.resetConnectionFlag();
        System.out.println("[ConnectionTask.connectToHost] Connected!");
    }
}
