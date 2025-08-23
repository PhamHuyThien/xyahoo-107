package home.thienph.xyahoo107.tasks;

import home.thienph.xyahoo107.connections.PacketReader;
import home.thienph.xyahoo107.managers.NetworkManager;

import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

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

   public final void run() {
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
                  return;
               }
            } catch (Exception var2) {
               var3.printStackTrace();
            }
         }
      }
   }

   private static void connectToHost(String var0, int var1) throws IOException {
      System.out.print("Connecting");
      System.out.println(var0);
      System.out.println(var1);

      try {
         NetworkManager.setSocketConnection((SocketConnection)Connector.open("socket://" + var0 + ":" + var1));
      } catch (Exception var3) {
         System.out.println("soc ex1");
         var3.printStackTrace();
         throw new IOException();
      }

      try {
         NetworkManager.getSocketConnection().setSocketOption((byte)2, 1);
      } catch (Exception var2) {
         System.out.println("soc ex2");
         var2.printStackTrace();
      }

      NetworkManager.getOutputStream(NetworkManager.getSocketConnection().openDataOutputStream());
      NetworkManager.inputStream = NetworkManager.getSocketConnection().openInputStream();
      (NetworkManager.writeThread = new Thread(NetworkManager.getPacketWriter())).start();
      (NetworkManager.readThread = new Thread(new PacketReader())).start();
      NetworkManager.isConnecting = false;
      NetworkManager.packetHandler.resetConnectionFlag();
      System.out.println("Connected!");
   }
}
