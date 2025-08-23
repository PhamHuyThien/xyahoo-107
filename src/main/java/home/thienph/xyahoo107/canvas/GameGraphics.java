package home.thienph.xyahoo107.canvas;

import home.thienph.xyahoo107.connections.ChatPacketHandler;
import home.thienph.xyahoo107.connections.GamePacketHandler;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.managers.NetworkManager;
import home.thienph.xyahoo107.messages.MessageProcessor;
import home.thienph.xyahoo107.utils.FontRenderer;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

public final class GameGraphics extends Canvas implements Runnable {
   public static GameGraphics instance;
   public static boolean isRunning;
   private static boolean[] keyPressed = new boolean[21];
   private static boolean[] keyRepeated = new boolean[21];
   private static int[] charInput = new int[1];
   public static boolean isPointerDown;
   public static boolean isPointerReleased;
   public static boolean isPointerPressed;
   public static boolean isPointerDragged;
   public static int pointerX;
   public static int pointerY;
   public static int gameState;
   public static int screenWidth;
   public static int screenHeight;
   public static boolean isNokiaDevice;
   private static int debugCounter;
   public static boolean isDebugMode = false;

   static {
      new Object();
   }

   public GameGraphics() {
      System.gc();
      this.setFullScreenMode(true);
      instance = this;
      isNokiaDevice = this.getKeyCode(8) == -20;
      screenWidth = this.getWidth();
      screenHeight = this.getHeight();
      gameState = 0;
      FontRenderer.initializeFonts();
      GamePacketHandler var1 = GamePacketHandler.getInstance();
      NetworkManager.registerHandler(2, var1);
      NetworkManager.registerHandler(4, ChatPacketHandler.getInstance());
      NetworkManager.registerHandler(39, var1);
      NetworkManager.registerHandler(5, var1);
      NetworkManager.registerHandler(6, var1);
      NetworkManager.registerHandler(37, var1);
      NetworkManager.registerHandler(48, var1);
      NetworkManager.packetHandler = var1;
      GameManager var2 = GameManager.getInstance();
      GamePacketHandler.gameManager = var2 ;
      ChatPacketHandler.gameManager = var2;
      NetworkManager.sendPacket(new Packet(2, 5));
      new Thread(this).start();
   }

   public final void initializeConnection() {
      if (!NetworkManager.isConnected && !NetworkManager.isConnecting) {
         String[] var1 = Xuka.loadServerIPs();
         int[] var2 = Xuka.loadServerPorts();
         System.out.println("Loaded IPs");
         System.out.println(var1.length);

         for (int var3 = 0; var3 < var1.length; var3++) {
            System.out.println(var1[var3]);
            System.out.println(var2[var3]);
         }

         if (var1.length == 0 || GameManager.isLocalTest || !GameManager.isLocalTest && var2.length > 0 && var2[0] == 11112) {
            var1 = Xuka.serverIPs;
            var2 = Xuka.serverPorts;
         }

         int var5 = (int)(System.currentTimeMillis() % (long)var1.length);
         int var4 = (int)(System.currentTimeMillis() % (long) Xuka.serverIPs.length);
         NetworkManager.connect(var1[var5], Xuka.serverIPs[var4], var2[var5], Xuka.serverPorts[var4]);
      }
   }

   protected final void paint(Graphics var1) {
      try {
         switch (gameState) {
            case 0:
               MessageProcessor.a(var1);
            default:
               return;
            case 1:
               GameManager.instance.drawHeader(var1);
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   public final void run() {
      isRunning = true;

      while (isRunning) {
         long var1 = System.currentTimeMillis();

         try {
            switch (gameState) {
               case 0:
                  MessageProcessor.b();
                  break;
               case 1:
                  GameManager.instance.handleInput(keyPressed, keyRepeated, charInput);
            }
         } catch (Exception var5) {
            var5.printStackTrace();
         }

         this.repaint();
         this.serviceRepaints();
         long var6;
         var1 = (var6 = System.currentTimeMillis() - var1) < 35L ? 35L - var6 : 1L;

         try {
            Thread.sleep(var1);
         } catch (Exception var4) {
         }
      }

      Xuka.instance.destroyApp(false);
      Xuka.instance.notifyDestroyed();
   }

   protected final void keyPressed(int var1) {
      if (isNokiaDevice) {
         switch (var1) {
            case -23:
               var1 = -8;
               break;
            case -22:
            case 22:
               var1 = -7;
               break;
            case -21:
            case 21:
               var1 = -6;
               break;
            case -20:
               var1 = -5;
               break;
            case -6:
               var1 = -2;
               break;
            case -5:
               var1 = -4;
               break;
            case -2:
               var1 = -3;
         }
      }

      if (var1 >= 32) {
         charInput[0] = var1;
      }

      switch (var1) {
         case -204:
         case -8:
         case 8:
            keyPressed[19] = true;
            return;
         case -203:
         case -22:
         case -7:
            keyPressed[18] = true;
            return;
         case -202:
         case -21:
         case -6:
            keyPressed[17] = true;
            return;
         case -39:
         case -2:
            keyPressed[13] = true;
            return;
         case -38:
         case -1:
            keyPressed[12] = true;
            return;
         case -11:
            keyPressed[20] = true;
            return;
         case -5:
         case 10:
         case 13:
            keyPressed[16] = true;
            return;
         case -4:
            keyPressed[15] = true;
            return;
         case -3:
            keyPressed[14] = true;
            return;
         case 35:
            keyPressed[11] = true;
            return;
         case 42:
            keyPressed[10] = true;
            return;
         case 48:
         case 49:
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
            keyPressed[var1 - 48] = true;
            return;
      }
   }

   protected final void keyRepeated(int var1) {
      if (isNokiaDevice) {
         switch (var1) {
            case -23:
               var1 = -8;
               break;
            case -22:
            case 22:
               var1 = -7;
               break;
            case -21:
            case 21:
               var1 = -6;
               break;
            case -20:
               var1 = -5;
               break;
            case -6:
               var1 = -2;
               break;
            case -5:
               var1 = -4;
               break;
            case -2:
               var1 = -3;
         }
      }

      if (var1 >= 32) {
         charInput[0] = var1;
      }

      switch (var1) {
         case -204:
         case -8:
         case 8:
            keyRepeated[19] = true;
            return;
         case -203:
         case -22:
         case -7:
            keyRepeated[18] = true;
            return;
         case -202:
         case -21:
         case -6:
            keyRepeated[17] = true;
            return;
         case -39:
         case -2:
            keyRepeated[13] = true;
            return;
         case -38:
         case -1:
            keyRepeated[12] = true;
            return;
         case -11:
            keyRepeated[20] = true;
            return;
         case -5:
         case 10:
         case 13:
            keyRepeated[16] = true;
            return;
         case -4:
            keyRepeated[15] = true;
            return;
         case -3:
            keyRepeated[14] = true;
            return;
         case 35:
            keyRepeated[11] = true;
            return;
         case 42:
            keyRepeated[10] = true;
            return;
         case 48:
         case 49:
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
            keyRepeated[var1 - 48] = true;
            return;
      }
   }

   protected final void keyReleased(int var1) {
      if (isNokiaDevice) {
         switch (var1) {
            case -23:
               var1 = -8;
               break;
            case -22:
               var1 = -7;
               break;
            case -21:
               var1 = -6;
               break;
            case -20:
               var1 = -5;
               break;
            case -6:
               var1 = -2;
               break;
            case -5:
               var1 = -4;
               break;
            case -2:
               var1 = -3;
         }
      }

      switch (var1) {
         case -39:
         case -2:
            keyRepeated[13] = false;
            return;
         case -38:
         case -1:
            keyRepeated[12] = false;
            return;
         case -22:
         case -7:
            keyRepeated[18] = false;
            return;
         case -21:
         case -6:
            keyRepeated[17] = false;
            return;
         case -11:
            keyRepeated[20] = false;
            return;
         case -8:
         case 8:
            keyRepeated[19] = false;
            return;
         case -5:
         case 10:
         case 13:
            keyRepeated[16] = false;
            return;
         case -4:
            keyRepeated[15] = false;
            return;
         case -3:
            keyRepeated[14] = false;
            return;
         case 35:
            keyRepeated[11] = false;
            return;
         case 42:
            keyRepeated[10] = false;
            return;
         case 48:
         case 49:
            debugCounter++;
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
            keyRepeated[var1 - 48] = false;
            return;
      }
   }

   public static void clearKeyStates() {
      for (int var0 = 0; var0 < 21; var0++) {
         keyPressed[var0] = false;
      }
   }

   protected final void pointerDragged(int var1, int var2) {
      isPointerDown = true;
      isPointerDragged = true;
      pointerX = var1;
      pointerY = var2;
   }

   protected final void pointerPressed(int var1, int var2) {
      isPointerDown = true;
      isPointerPressed = true;
      pointerX = var1;
      pointerY = var2;
   }

   protected final void pointerReleased(int var1, int var2) {
      isPointerDown = false;
      isPointerReleased = true;
      pointerX = var1;
      pointerY = var2;
   }
}
