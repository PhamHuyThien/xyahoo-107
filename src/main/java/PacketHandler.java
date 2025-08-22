public abstract class PacketHandler {
   protected abstract void handlePacket(Packet var1, int var2);

   public final void processPacket(Packet var1) {
      int var2 = var1.getCommandId();

      try {
         this.handlePacket(var1, var2);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("oops = " + var3.toString());
      }
   }

   public abstract void onConnectionError();

   public abstract void onConnectionLost();

   public abstract void resetConnectionFlag();
}
