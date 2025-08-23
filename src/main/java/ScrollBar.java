import javax.microedition.lcdui.Graphics;

public final class ScrollBar {
   private static int thumbSize = 15;
   public static boolean isVisible = false;
   private static final int scrollAreaHeight = Screen.screenHeight - GameManager.footerHeight;
   private static int scrollRatio;
   private static int maxThumbPosition;
   private static int scrollBarX = Screen.screenWidth - 4 - 1;
   private static int scrollBarY = GameManager.footerHeight + 2;
   private static boolean isScrolling = false;
   private static int hideCounter = 0;

   public static void initialize(int var0) {
      thumbSize = (scrollRatio = 100 * scrollAreaHeight / var0) > 600 ? scrollRatio / 100 : 5;
      maxThumbPosition = scrollBarY + scrollAreaHeight - thumbSize;
   }

   public static void setScrolling(boolean var0) {
      if (isVisible) {
         isScrolling = var0;
         hideCounter = 0;
      }
   }

   public static void render(Graphics var0, int var1) {
      if (isScrolling && scrollRatio > 1 && isVisible) {
         if ((var1 = scrollBarY + var1 * scrollRatio / 100) > maxThumbPosition) {
            var1 = maxThumbPosition;
         }

         var0.setColor(5218244);
         var0.fillRect(scrollBarX, var1 + 1, 3, thumbSize - 2);
         var0.fillRect(scrollBarX + 1, var1, 1, thumbSize);
         if (++hideCounter > 10) {
            setScrolling(false);
         }
      }
   }
}
