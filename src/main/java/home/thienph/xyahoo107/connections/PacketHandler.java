package home.thienph.xyahoo107.connections;

import home.thienph.xyahoo107.data.packet.Packet;

public abstract class PacketHandler {
    protected abstract void handlePacket(Packet packet, int commandId);

    public final void processPacket(Packet var1) {
        int commandId = var1.getCommandId();
        try {
            this.handlePacket(var1, commandId);
        } catch (Exception ex) {
            System.err.println("[PacketHandler.processPacket] command = " + commandId + ", exception = " + ex);
            ex.printStackTrace();
        }
    }

    public abstract void onConnectionError();

    public abstract void onConnectionLost();

    public abstract void resetConnectionFlag();
}
