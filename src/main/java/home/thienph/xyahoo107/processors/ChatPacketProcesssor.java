package home.thienph.xyahoo107.processors;

import home.thienph.xyahoo107.connections.PacketHandler;
import home.thienph.xyahoo107.data.media.BuddyGroup;
import home.thienph.xyahoo107.data.media.BuddyInfo;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.data.media.BuddyGroupList;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.PacketUtils;

public final class ChatPacketProcesssor extends PacketHandler {
    private static ChatPacketProcesssor instance = null;
    public static GameManager gameManager;

    public void onConnectionError() {
        gameManager.onConnectionError();
    }

    public void onConnectionLost() {
        gameManager.onConnectionLost();
    }

    protected void handlePacket(Packet packet, int commandId) {
        switch (commandId) {
            case -5:
                gameManager.onYahooConnected();
                return;
            case 20:
                String var17 = PacketUtils.readString(packet);
                int var20 = PacketUtils.readInt(packet);
                String var21 = PacketUtils.readString(packet);
                PacketUtils.readString(packet);
                PacketUtils.readString(packet);
                PacketUtils.readString(packet);
                gameManager.friendStatusChanged(var17, var20, 2);
                gameManager.updateContactMessage(var17, var21, 2);
                return;
            case 22:
                String var14 = PacketUtils.readString(packet);
                gameManager.sendBuzz(var14);
                return;
            case 24:
                BuddyGroupList var16 = new BuddyGroupList();
                int var3 = PacketUtils.readInt(packet);

                for (int var4 = 0; var4 < var3; var4++) {
                    String var18 = PacketUtils.readString(packet);
                    BuddyGroup var6 = new BuddyGroup(var18);
                    int var19 = PacketUtils.readInt(packet);

                    for (int var22 = 0; var22 < var19; var22++) {
                        String var23 = PacketUtils.readString(packet);
                        int var24 = PacketUtils.readInt(packet);
                        String var25 = PacketUtils.readString(packet);
                        PacketUtils.readString(packet);
                        String var26 = PacketUtils.readString(packet);
                        PacketUtils.readString(packet);
                        var6.addContact(new BuddyInfo(var23, var26, var24, var25, new int[0], 0, 0, null));
                    }

                    var16.contactGroups.addElement(var6);
                }

                gameManager.loadYahooBuddyList(var16);
                return;
            case 25:
                String var8 = PacketUtils.readString(packet);
                PacketUtils.readString(packet);
                String var9 = PacketUtils.readString(packet);
                String var10 = PacketUtils.readString(packet);
                gameManager.addChatMessage(var8, var9, var10);
                return;
            case 27:
                if (PacketUtils.readInt(packet) == -1) {
                    gameManager.onYahooDisconnect();
                    return;
                }
                break;
            case 30:
                String var13 = PacketUtils.readString(packet);
                gameManager.showAddFriendDialog(var13, 0L, true);
                return;
            case 32:
                String var15 = PacketUtils.readString(packet);
                byte var12 = packet.getPayload().readByte();
                gameManager.handleFriendRequestResponse(var15, var12);
                break;
            case 34:
                String var5 = PacketUtils.readString(packet);
                PacketUtils.readString(packet);
                String var7 = PacketUtils.readString(packet);
                gameManager.addSimpleMessage(var5, var7);
                return;
            case 55:
                return;
            case 56:
                int var11 = PacketUtils.readInt(packet);
                GameManager.saveYahooContactStatus(var11);
        }
    }

    public static ChatPacketProcesssor getInstance() {
        if (instance == null) {
            instance = new ChatPacketProcesssor();
        }

        return instance;
    }

    public void resetConnectionFlag() {
    }
}
