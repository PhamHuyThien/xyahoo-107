package home.thienph.xyahoo107.actions;

import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.messages.MessageProcessor;

public final class quyen_gf implements Runnable {
   private final byte[] a;

   public quyen_gf(GameManager var1, byte[] var2) {
      this.a = var2;
   }

   public final void run() {
      MessageProcessor.a(this.a);
      System.gc();
   }
}
