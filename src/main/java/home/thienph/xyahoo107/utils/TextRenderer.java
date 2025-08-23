package home.thienph.xyahoo107.utils;

import home.thienph.xyahoo107.canvas.GameGraphics;

import java.io.IOException;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class TextRenderer {
   private static Image logoImage;
   public static int CHAR_SPACING = 32;
   private static int CHAR_HEIGHT = 9;
   private static int DEFAULT_CHAR_WIDTH = 4;
   private static int charIndex;
   private static String DIGITS = "0123456789";
   private static byte[] DIGIT_WIDTHS = new byte[]{8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
   private static Font defaultFont;
   public static int centerX;
   public static int centerY;
   public static int logoCenterX;

   static {
      (defaultFont = Font.getFont(0, 0, 8)).getHeight();
      String var0 = " 1234567890_-+=\\~`!@#$%^&*()|qwertyuiop[]{}asdfghjkl;':\"zxcvbnm,./<>?ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      defaultFont.stringWidth(var0);
      var0.length();
   }

   public static int getStringWidth(String var0) {
      return defaultFont.stringWidth(var0);
   }

   public static int getFontHeight() {
      return defaultFont.getHeight();
   }

   public static void clearLogoCache() {
      logoImage = null;
      System.gc();
   }

   public static Image getLogoImage() {
      if (logoImage == null) {
         try {
            logoImage = Image.createImage("/Logo.png");
            logoCenterX = GameGraphics.screenWidth >> 1;
            centerY = GameGraphics.screenHeight >> 1;
         } catch (IOException var0) {
         }
      }

      return logoImage;
   }

   private static int calculateSubstringWidth(String var0, int var1, int var2, int var3) {
      int var4 = 0;
      if ((var2 = var1 + var2) > var0.length()) {
         var2 = var0.length();
      }

      char var5;
      for (int var6 = var1; var6 < var2 && (var5 = var0.charAt(var6)) != '\n'; var6++) {
         var4 += (charIndex = DIGITS.indexOf(var5)) != -1 ? DIGIT_WIDTHS[charIndex] - (var3 == 0 ? 1 : 2) : DEFAULT_CHAR_WIDTH;
      }

      return var4;
   }

   public static void drawStringWithNumbers(String string, int n, int n2, int n3, Graphics graphics, int n4) {
      int n5 = 1;
      Graphics graphics2 = graphics;
      boolean bl = false;
      n3 = n2;
      n2 = n;
      n = string.length();
      boolean bl2 = false;
      int n6 = n + 0;
      String string2 = string;
      if (n6 > string2.length()) {
         n6 = string2.length();
      }
      int n7 = !bl ? n2 : (bl ? n2 - TextRenderer.calculateSubstringWidth(string2, 0, n, n5) : n2 - (TextRenderer.calculateSubstringWidth(string2, 0, n, n5) >> 1));
      int n8 = 0;
      while (n8 < n6) {
         int n9 = string2.charAt(n8);
         if (n9 == 10) {
            n7 = !bl ? n2 : (bl ? n2 - TextRenderer.calculateSubstringWidth(string2, n8 + 1, n - n8 - 1, n5) : n2 - (TextRenderer.calculateSubstringWidth(string2, n8 + 1, n - n8 - 1, n5) >> 1));
            n3 += n5 == 0 ? CHAR_HEIGHT : CHAR_HEIGHT - 1;
         } else if ((n9 = DIGITS.indexOf(n9)) >= 0) {
            graphics2.drawRegion(FontRenderer.numberImage, 0, n9 * (CHAR_HEIGHT - 1), 7, CHAR_HEIGHT - 1, 0, n7, n3, 20);
            n7 += DIGIT_WIDTHS[n9] - (n5 == 0 ? 1 : 2);
         } else {
            n7 += DEFAULT_CHAR_WIDTH;
         }
         ++n8;
      }
   }

   public static void drawPlainString(Graphics var0, String var1, int var2, int var3, int var4) {
      var0.setFont(defaultFont);
      var0.drawString(var1, var2, var3, 20);
   }
}
