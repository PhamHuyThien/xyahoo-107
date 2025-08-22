public class PacketSender {

   public static void a(String var0, int var1) {
      Packet var2 = null;
      if (var1 == 0) {
         var2 = new Packet(3418, 39);
      }

      PacketUtils.writeString(var0, var2);
      NetworkManager.sendPacket(var2);
   }

   public static void a(String var0) {
      Packet var1 = new Packet(6000000, 2);
      PacketUtils.writeString(var0, var1);
      NetworkManager.sendPacket(var1);
   }

   public static void a() {
      b(11712001, 2);
   }

   public static void b() {
      b(11712002, 2);
   }

   public static void c() {
      b(5000039, 2);
   }

   private static void b(int var0, int var1) {
      GameManager.instance.c(true);
      NetworkManager.sendPacket(new Packet(var0, 2));
   }

   public static void b(String var0) {
      Packet var1 = new Packet(5000025, 2);
      PacketUtils.writeString(var0, var1);
      NetworkManager.sendPacket(var1);
   }

   public static void a(long var0, boolean var2) {
      Packet var3 = new Packet(5000017, 2);
      PacketUtils.writeLong(var0, var3);
      PacketUtils.writeBoolean(var2, var3);
      NetworkManager.sendPacket(var3);
   }

   public static void a(long var0) {
      Packet var2 = new Packet(5000022, 2);
      PacketUtils.writeLong(var0, var2);
      NetworkManager.sendPacket(var2);
   }

   public static void c(String var0) {
      Packet var1 = new Packet(5000038, 2);
      PacketUtils.writeString(var0, var1);
      NetworkManager.sendPacket(var1);
   }

   public static void a(long var0, String var2) {
      Packet var3 = new Packet(5000023, 2);
      PacketUtils.writeLong(var0, var3);
      PacketUtils.writeString(var2, var3);
      NetworkManager.sendPacket(var3);
   }

   public static void a(long[] var0, String var1) {
      Packet var2 = new Packet(5000041, 2);
      PacketUtils.writeInt(var0.length, var2);
      int var3 = 0;

      for (int var4 = var0.length; var3 < var4; var3++) {
         PacketUtils.writeLong(var0[var3], var2);
      }

      PacketUtils.writeString(var1, var2);
      NetworkManager.sendPacket(var2);
   }

   public static void d(String var0) {
      Packet var1 = new Packet(4802, 48);
      PacketUtils.writeString(var0, var1);
      NetworkManager.sendPacket(var1);
   }

   public static void a(String var0, String var1) {
      Packet var2 = new Packet(4804, 48);
      PacketUtils.writeString(var0, var2);
      PacketUtils.writeString(var1, var2);
      NetworkManager.sendPacket(var2);
   }

   public static void b(String var0, String var1) {
      Packet var2 = new Packet(4808, 48);
      PacketUtils.writeString(var0, var2);
      PacketUtils.writeString(var1, var2);
      NetworkManager.sendPacket(var2);
   }

   public static void b(String var0, int var1) {
      Packet var2 = new Packet(var1, 48);
      PacketUtils.writeString(var0, var2);
      NetworkManager.sendPacket(var2);
   }

   public static void d() {
      GameManager.instance.c(true);
      NetworkManager.sendPacket(new Packet(5000009, 39));
   }

   public static void e(String var0) {
      GameManager.instance.c(true);
      Packet var1 = new Packet(5000011, 39);
      PacketUtils.writeString(var0, var1);
      NetworkManager.sendPacket(var1);
   }

   public static void a(int var0) {
      Packet var1 = new Packet(123, 2);
      PacketUtils.writeInt(var0, var1);
      NetworkManager.sendPacket(var1);
   }

   public static void f(String var0) {
      Packet var1 = new Packet(5023, 2);
      PacketUtils.writeString(var0, var1);
      NetworkManager.sendPacket(var1);
   }

   public static void c(String var0, String var1) {
      GameManager.instance.c(true);
      Packet var2 = new Packet(3403, 39);
      PacketUtils.writeString(var0, var2);
      PacketUtils.writeString(var1, var2);
      NetworkManager.sendPacket(var2);
   }

   public static void g(String var0) {
      Packet var1 = new Packet(3404, 39);
      PacketUtils.writeString(var0, var1);
      NetworkManager.sendPacket(var1);
   }

   public static void d(String var0, String var1) {
      Packet var2 = new Packet(3405, 39);
      PacketUtils.writeString(var0, var2);
      PacketUtils.writeString(var1, var2);
      NetworkManager.sendPacket(var2);
   }

   public static void e(String var0, String var1) {
      Packet var2 = new Packet(3406, 39);
      PacketUtils.writeString(var0, var2);
      PacketUtils.writeString(var1, var2);
      NetworkManager.sendPacket(var2);
   }

   public static void f(String var0, String var1) {
      Packet var2 = new Packet(3407, 39);
      PacketUtils.writeString(var0, var2);
      PacketUtils.writeString(var1, var2);
      NetworkManager.sendPacket(var2);
   }

   public static void a(String var0, String var1, int var2, byte[] var3) {
      Packet var4 = new Packet(3408, 39);
      PacketUtils.writeString(var0, var4);
      PacketUtils.writeString(var1, var4);
      PacketUtils.writeInt(var2, var4);
      int var5;
      PacketUtils.writeInt(var5 = var3.length, var4);

      for (int var6 = 0; var6 < var5; var6++) {
         PacketUtils.writeByte(var3[var6], var4);
      }

      NetworkManager.sendPacket(var4);
   }

   public static void a(String var0, String var1, String var2) {
      Packet var3 = new Packet(3412, 39);
      PacketUtils.writeString(var0, var3);
      PacketUtils.writeString(var1, var3);
      PacketUtils.writeString(var2, var3);
      NetworkManager.sendPacket(var3);
   }

   public static void a(int var0, String var1, String var2, boolean var3) {
      Packet var4 = new Packet();
      if (var0 == 0) {
         var4 = new Packet(3409, 39);
      }

      PacketUtils.writeString(var1, var4);
      if (var0 == 0) {
         PacketUtils.writeString(var2, var4);
      }

      PacketUtils.writeBoolean(var3, var4);
      NetworkManager.sendPacket(var4);
   }

   public static void a(int var0, String var1, String var2, String var3) {
      Packet var4 = new Packet();
      if (var0 == 0) {
         var4 = new Packet(3411, 39);
      }

      PacketUtils.writeString(var1, var4);
      if (var0 == 0) {
         PacketUtils.writeString(var2, var4);
      }

      PacketUtils.writeString(var3, var4);
      NetworkManager.sendPacket(var4);
   }

   public static void a(int var0, String var1, String var2, long var3) {
      Packet var5 = new Packet();
      if (var0 == 0) {
         var5 = new Packet(3410, 39);
      }

      PacketUtils.writeString(var1, var5);
      PacketUtils.writeString(var2, var5);
      PacketUtils.writeLong(var3, var5);
      NetworkManager.sendPacket(var5);
   }

   public static void e() {
      Packet var0 = new Packet(324, 2);
      PacketUtils.writeInt(Xuka.partnerID, var0);
      PacketUtils.writeInt(Xuka.appID, var0);
      PacketUtils.writeByte((byte)0, var0);
      NetworkManager.sendPacket(var0);
      var0 = new Packet(5030, 2);
      PacketUtils.writeInt(1, var0);
      NetworkManager.sendPacket(var0);
   }

   public static void h(String var0) {
      Packet var1 = new Packet(322, 2);
      PacketUtils.writeString(var0, var1);
      NetworkManager.sendPacket(var1);
   }

   public static void i(String var0) {
      Packet var1 = new Packet(321, 2);
      PacketUtils.writeString(var0, var1);
      NetworkManager.sendPacket(var1);
   }

   public static void a(long var0, String var2, int var3) {
      Packet var4 = new Packet(var3 == 1 ? 5000016 : 22, var3 == 1 ? 2 : 4);
      if (var2 == null) {
         PacketUtils.writeLong(var0, var4);
      } else {
         PacketUtils.writeString(var2, var4);
      }

      NetworkManager.sendPacket(var4);
   }

   public static void g(String var0, String var1) {
      Packet var2 = new Packet(30, 4);
      PacketUtils.writeString(var0, var2);
      PacketUtils.writeString(var1, var2);
      NetworkManager.sendPacket(var2);
   }

   public static void h(String var0, String var1) {
      Packet var2 = new Packet(5000010, 2);
      PacketUtils.writeString(quyen_kb.a(var0), var2);
      PacketUtils.writeString(quyen_kb.a(var1), var2);
      PacketUtils.writeInt(Xuka.partnerID, var2);
      PacketUtils.writeInt(Xuka.appID, var2);
      NetworkManager.sendPacket(var2);
   }

   public static void a(int var0, int var1) {
      Packet var2 = new Packet(var1 == 1 ? 5000031 : 28, var1 == 1 ? 2 : 4);
      PacketUtils.writeInt(var0, var2);
      NetworkManager.sendPacket(var2);
   }

   public static void c(String var0, int var1) {
      Packet var2 = new Packet(var1 == 1 ? 5000035 : 29, var1 == 1 ? 2 : 4);
      if (var1 == 2) {
         YahooScreen.statusMessage = var0;
         Xuka.saveStringData(YahooScreen.yahooUsername, var0, true);
      }

      PacketUtils.writeString(var0, var2);
      NetworkManager.sendPacket(var2);
   }

   public static void a(String var0, String var1, int var2, int var3, int var4, byte var5, String var6) {
      Packet var8;
      if (var3 == 1) {
         var8 = new Packet(1016, 2);
         PacketUtils.writeInt(2, var8);
         NetworkManager.sendPacket(var8);
         var8 = new Packet(5000007, 2);
      } else {
         var8 = new Packet(21, 4);
      }

      PacketUtils.writeString(quyen_kb.a(var0), var8);
      PacketUtils.writeString(quyen_kb.a(var1), var8);
      PacketUtils.writeInt(var2, var8);
      PacketUtils.writeString(var6, var8);
      PacketUtils.writeInt(var4, var8);
      if (var3 == 1) {
         PacketUtils.writeByte(var5, var8);
      }

      NetworkManager.sendPacket(var8);
   }

   public static void a(String var0, String var1, String var2, int var3) {
      Packet var4 = new Packet(34, 4);
      PacketUtils.writeString(var0, var4);
      PacketUtils.writeString(var1, var4);
      PacketUtils.writeString(var2, var4);
      NetworkManager.sendPacket(var4);
   }

   public static void d(String var0, int var1) {
      Packet var2 = new Packet(23, 4);
      PacketUtils.writeString(var0, var2);
      NetworkManager.sendPacket(var2);
   }

   public static void a(String var0, String var1, byte var2) {
      Packet var3 = new Packet(31, 4);
      PacketUtils.writeString(var0, var3);
      PacketUtils.writeByte(var2, var3);
      if (var2 != 1) {
         var1 = "";
      }

      PacketUtils.writeString(var1, var3);
      NetworkManager.sendPacket(var3);
   }

   public static void a(int var0, String var1, int var2, int var3) {
      Packet var4 = new Packet(501, 2);
      PacketUtils.writeInt(0, var4);
      PacketUtils.writeString(var1, var4);
      PacketUtils.writeInt(var2, var4);
      PacketUtils.writeInt(var3, var4);
      NetworkManager.sendPacket(var4);
   }

   public static void a(byte[] var0) {
      Packet var1 = new Packet(115, 2);
      PacketUtils.writeBytes(var0, 0, var0.length, var1);
      NetworkManager.sendPacket(var1);
   }

   public static void a(int var0, byte var1, String var2) {
      Packet var3 = new Packet(5002, 37);
      PacketUtils.writeInt(var0, var3);
      PacketUtils.writeByte(var1, var3);
      PacketUtils.writeString(var2, var3);
      NetworkManager.sendPacket(var3);
   }

   public static void a(String var0, byte[] var1, int var2, int var3, boolean var4) {
      Packet var5 = new Packet(5003, 37);
      PacketUtils.writeString(var0, var5);
      PacketUtils.writeBytes(var1, var2, var3, var5);
      PacketUtils.writeBoolean(var4, var5);
      NetworkManager.sendPacket(var5);
   }

}
