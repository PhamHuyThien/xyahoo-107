package home.thienph.xyahoo107.connections;

import home.thienph.xyahoo107.data.media.DownloadCategory;
import home.thienph.xyahoo107.data.media.DownloadData;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.managers.DownloadDataManager;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.PacketUtils;

public final class ChatPacketHandler extends PacketHandler {
   private static ChatPacketHandler instance = null;
   public static GameManager gameManager;

   public final void onConnectionError() {
      gameManager.onConnectionError();
   }

   public final void onConnectionLost() {
      gameManager.onConnectionLost();
   }

   protected final void handlePacket(Packet var1, int var2) {
      switch (var2) {
         case -5:
            gameManager.onYahooConnected();
            return;
         case 20:
            String var17 = PacketUtils.readString(var1);
            int var20 = PacketUtils.readInt(var1);
            String var21 = PacketUtils.readString(var1);
            PacketUtils.readString(var1);
            PacketUtils.readString(var1);
            PacketUtils.readString(var1);
            gameManager.friendStatusChanged(var17, var20, 2);
            gameManager.updateContactMessage(var17, var21, 2);
            return;
         case 22:
            String var14 = PacketUtils.readString(var1);
            gameManager.sendBuzz(var14);
            return;
         case 24:
            DownloadDataManager var16 = new DownloadDataManager();
            int var3 = PacketUtils.readInt(var1);

            for (int var4 = 0; var4 < var3; var4++) {
               String var18 = PacketUtils.readString(var1);
               DownloadCategory var6 = new DownloadCategory(var18);
               int var19 = PacketUtils.readInt(var1);

               for (int var22 = 0; var22 < var19; var22++) {
                  String var23 = PacketUtils.readString(var1);
                  int var24 = PacketUtils.readInt(var1);
                  String var25 = PacketUtils.readString(var1);
                  PacketUtils.readString(var1);
                  String var26 = PacketUtils.readString(var1);
                  PacketUtils.readString(var1);
                  var6.addDownload(new DownloadData(var23, var26, var24, var25, new int[0], 0, 0, null));
               }

               var16.downloadCategories.addElement(var6);
            }

            gameManager.loadYahooBuddyList(var16);
            return;
         case 25:
            String var8 = PacketUtils.readString(var1);
            PacketUtils.readString(var1);
            String var9 = PacketUtils.readString(var1);
            String var10 = PacketUtils.readString(var1);
            gameManager.addChatMessage(var8, var9, var10);
            return;
         case 27:
            if (PacketUtils.readInt(var1) == -1) {
               gameManager.onYahooDisconnect();
               return;
            }
            break;
         case 30:
            String var13 = PacketUtils.readString(var1);
            gameManager.showAddFriendDialog(var13, 0L, true);
            return;
         case 32:
            String var15 = PacketUtils.readString(var1);
            byte var12 = var1.getPayload().readByte();
            gameManager.handleFriendRequestResponse(var15, var12);
            break;
         case 34:
            String var5 = PacketUtils.readString(var1);
            PacketUtils.readString(var1);
            String var7 = PacketUtils.readString(var1);
            gameManager.addSimpleMessage(var5, var7);
            return;
         case 55:
            return;
         case 56:
            int var11 = PacketUtils.readInt(var1);
            GameManager.saveYahooContactStatus(var11);
            return;
      }
   }

   public static ChatPacketHandler getInstance() {
      if (instance == null) {
         instance = new ChatPacketHandler();
      }

      return instance;
   }

   public final void resetConnectionFlag() {
   }
}
