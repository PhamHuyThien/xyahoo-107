import javax.microedition.lcdui.Graphics;
import java.util.Vector;
import javax.microedition.lcdui.Image;
import java.util.Hashtable;

public final class FontRenderer
{
   public static boolean isCustomFontEnabled;
   private static Hashtable fontCache;
   public static Integer COLOR_ORANGE;
   public static Integer COLOR_WHITE;
   public static Integer COLOR_BROWN;
   public static int fontHeight;
   public static String[] emoticons;
   private static int emoticonCount;
   public static Image numberImage;
   public static int lineHeight;
   public static int paragraphSpacing;
   public static int emoticonReplaceCount;
   private Image fontImage;
   private static byte[] characterWidths;
   private static String fullCharset;
   private static String normalizedCharset;
   private static FontRenderer instance;
   private static int fallbackFont;
   private static Vector tempStringVector;

   static {
      FontRenderer.isCustomFontEnabled = true;
      FontRenderer.COLOR_ORANGE = new Integer(16726823);
      new Integer(0);
      FontRenderer.COLOR_WHITE = new Integer(16777215);
      FontRenderer.COLOR_BROWN = new Integer(3981823);
      FontRenderer.emoticonCount = (FontRenderer.emoticons = new String[] { ":-BD", ":D", ">:)", "X-(", ":((", ":))", "B-)", ":\">", ";;)", ":-SS", ":-*", ":-W", ":-?", ";))", "~X(", ":-H", ":)", ":-/", ":@)", "3:-O", ":(|)", "~:>", "@};-", "~O)", ":|", ":-O", ":(", ";)", ":X", ":>", ":P", "=P~", "=((", "B-(", ":-\"", ":-&", ":-S", "O:-)", "#-O", "I-)", "8-X", "(*)" }).length;
      FontRenderer.characterWidths = new byte[] { 3, 7, 5, 7, 7, 7, 7, 7, 7, 7, 7, 3, 3, 3, 3, 7, 4, 4, 7, 4, 5, 4, 7, 6, 9, 9, 8, 7, 4, 4, 3, 3, 7, 9, 12, 7, 7, 7, 7, 7, 7, 7, 6, 7, 7, 3, 4, 7, 3, 11, 7, 7, 7, 7, 5, 7, 5, 7, 8, 10, 7, 8, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 4, 4, 4, 5, 3, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 9, 9, 9, 9, 9, 9, 7, 7, 7, 7, 7, 9, 9, 9, 9, 9, 9, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 7, 6, 8, 8, 3, 7, 8, 7, 10, 8, 9, 8, 9, 8, 8, 7, 8, 10, 14, 8, 9, 7 };
      FontRenderer.fullCharset = " 0123456789.':!?()+-*/#$%\u0110_=[];,^&@><abcdefghijklmnopqrstuvwxyz\u00e1\u00e0\u1ea3\u00e3\u1ea1\u0103\u1eaf\u1eb1\u1eb3\u1eb5\u1eb7\u00e2\u1ea5\u1ea7\u1ea9\u1eab\u1ead\u00e9\u00e8\u1ebb\u1ebd\u1eb9\u00ea\u1ebf\u1ec1\u1ec3\u1ec5\u1ec7\u00ed\u00ec\u1ec9\u0129\u1ecb\u00f3\u00f2\u1ecf\u00f5\u1ecd\u00f4\u1ed1\u1ed3\u1ed5\u1ed7\u1ed9\u01a1\u1edb\u1edd\u1edf\u1ee1\u1ee3\u00fa\u00f9\u1ee7\u0169\u1ee5\u01b0\u1ee9\u1eeb\u1eed\u1eef\u1ef1\u00fd\u1ef3\u1ef7\u1ef9\u1ef5\u0111ABCDEFGHIJKLMNOPQRSTUVWXYZ\u00c1\u00c0\u1ea2\u00c3\u1ea0\u0102\u1eae\u1eb0\u1eb2\u1eb4\u1eb6\u00c2\u1ea4\u1ea6\u1ea8\u1eaa\u1eac\u00c9\u00c8\u1eba\u1ebc\u1eb8\u00ca\u1ebe\u1ec0\u1ec2\u1ec4\u1ec6\u00cd\u00cc\u1ec8\u0128\u1eca\u00d3\u00d2\u1ece\u00d5\u1ecc\u00d4\u1ed0\u1ed2\u1ed4\u1ed6\u1ed8\u01a0\u1eda\u1edc\u1ede\u1ee0\u1ee2\u00da\u00d9\u1ee6\u0168\u1ee4\u01af\u1ee8\u1eea\u1eec\u1eee\u1ef0\u00dd\u1ef2\u1ef6\u1ef8\u1ef4|\"/";
      FontRenderer.normalizedCharset = " 0123456789.':!?()+-*/#$%\u0110_=[];,^&@><abcdefghijklmnopqrstuvwxyz\u00e1\u00e0\u1ea3\u00e3\u1ea1\u0103\u1eaf\u1eb1\u1eb3\u1eb5\u1eb7\u00e2\u1ea5\u1ea7\u1ea9\u1eab\u1ead\u00e9\u00e8\u1ebb\u1ebd\u1eb9\u00ea\u1ebf\u1ec1\u1ec3\u1ec5\u1ec7\u00ed\u00ec\u1ec9\u0129\u1ecb\u00f3\u00f2\u1ecf\u00f5\u1ecd\u00f4\u1ed1\u1ed3\u1ed5\u1ed7\u1ed9\u01a1\u1edb\u1edd\u1edf\u1ee1\u1ee3\u00fa\u00f9\u1ee7\u0169\u1ee5\u01b0\u1ee9\u1eeb\u1eed\u1eef\u1ef1\u00fd\u1ef3\u1ef7\u1ef9\u1ef5\u0111ABCDEFGHIJKLMNOPQRSTUVWXYZAAAAAAAAAAAAAAAAAEEEEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUUYYYYY '";
   }

   public static String truncateText(final String s, final int endIndex) {
      if (s.length() > endIndex) {
         return UIUtils.concatStrings(s.substring(0, endIndex), "..", null, null);
      }
      return s;
   }

   public static int findEmoticonIndex(final String s) {
      for (int i = 0; i < FontRenderer.emoticonCount; ++i) {
         if (s.toUpperCase().indexOf(FontRenderer.emoticons[i]) != -1) {
            return i;
         }
      }
      return 100;
   }

   public static String replaceEmoticons(String string, final boolean b) {
      FontRenderer.emoticonReplaceCount = 0;
      int n = 10;
      for (int i = 0; i < FontRenderer.emoticonCount; ++i) {
         int index;
         while ((index = string.toUpperCase().indexOf(FontRenderer.emoticons[i])) != -1) {
            ++FontRenderer.emoticonReplaceCount;
            string = String.valueOf(string.substring(0, index)) + (char)(i + 30000) + string.substring(index + FontRenderer.emoticons[i].length());
            if (--n > 0) {
               continue;
            }
            break;
         }
         if (n <= 0) {
            break;
         }
      }
      if (n == 10 && !b) {
         return null;
      }
      return string;
   }

   public static void initializeFonts() {
      try {
         FontRenderer.numberImage = Image.createImage("/Numbers.png");
      }
      catch (final Exception ex) {}
      if (FontRenderer.isCustomFontEnabled) {
         FontRenderer.fontHeight = 14;
         FontRenderer.fontCache = new Hashtable();
         getFontInstance(FontRenderer.COLOR_BROWN);
         getFontInstance(FontRenderer.COLOR_WHITE);
      }
      else {
         FontRenderer.fontHeight = TextRenderer.getFontHeight();
      }
      FontRenderer.lineHeight = FontRenderer.fontHeight + 2;
      FontRenderer.paragraphSpacing = FontRenderer.fontHeight + 6;
   }

   private FontRenderer(final String tempStringVector, final int characterWidths) {
      if (!FontRenderer.isCustomFontEnabled) {
         return;
      }
      try {
         if (this.fontImage == null) {
            this.fontImage = Image.createImage(tempStringVector);
         }
         if (characterWidths != 16777215) {
            this.fontImage = changeImageColor(this.fontImage, characterWidths);
         }
      }
      catch (final Exception ex) {}
   }

   public static FontRenderer getFontInstance(Integer var0) {
      if (!isCustomFontEnabled) {
         return instance != null ? instance : (instance = new FontRenderer(null, 0));
      } else {
         FontRenderer var1;
         if ((var1 = (FontRenderer) fontCache.get(var0)) != null) {
            return var1;
         } else {
            if (fontCache.size() < 10) {
               fontCache.put(var0, new FontRenderer("/Font.png", var0.intValue()));
            }

            return (FontRenderer) fontCache.get(COLOR_WHITE);
         }
      }
   }

   public static int getTextWidth(String s) {
      if (FontRenderer.isCustomFontEnabled) {
         final String s2 = s;
         final int length = s.length();
         s = s2;
         int n = 0;
         char char1;
         for (int n2 = length + 0, index = 0; index < n2 && (char1 = s.charAt(index)) != '\n'; ++index) {
            n += getCharacterWidth(char1);
         }
         return n;
      }
      return TextRenderer.getStringWidth(s);
   }

   public final void drawText(final String s, final int n, int n2, final Graphics graphics) {
      if (!FontRenderer.isCustomFontEnabled) {
         TextRenderer.drawPlainString(graphics, s, n, n2, 0);
         return;
      }
      int n3 = n;
      n2 = n2;
      for (int length = s.length(), i = 0; i < length; ++i) {
         final char char1;
         if ((char1 = s.charAt(i)) == '\n') {
            n3 = n;
            n2 += FontRenderer.fontHeight;
         }
         else {
            final int a;
            if ((a = getCharacterIndex(char1)) >= 0) {
               graphics.drawRegion(this.fontImage, 0, a * FontRenderer.fontHeight, 15, FontRenderer.fontHeight, 0, n3, n2, 0);
               n3 += FontRenderer.characterWidths[a];
            }
         }
      }
   }

   private static int getCharacterIndex(final char c) {
      final int index;
      if ((index = FontRenderer.normalizedCharset.indexOf(c)) != -1) {
         return index;
      }
      final int index2;
      if ((index2 = FontRenderer.normalizedCharset.indexOf(((FontRenderer.fallbackFont = FontRenderer.fullCharset.indexOf(c)) != -1) ? FontRenderer.normalizedCharset.charAt(FontRenderer.fallbackFont) : ' ')) != -1) {
         return index2;
      }
      return 0;
   }

   private static int getCharacterWidth(final char c) {
      return FontRenderer.characterWidths[getCharacterIndex(c)];
   }

   public static String getFirstLineWrapped(final String s, final int n) {
      if (s == null) {
         return null;
      }
      if (s.length() == 0) {
         return "...";
      }
      final Vector vector = new Vector();
      int i = 0;
      int n2 = 0;
      int n3 = 0;
      int n4 = -1;
      while (i < s.length()) {
         final char char1;
         if ((char1 = s.charAt(i)) == ' ') {
            n4 = i;
         }
         if ((n3 += getCharacterWidth(char1)) > n || char1 == '\n') {
            if (char1 != '\n' && n4 != -1) {
               i = n4;
            }
            vector.addElement(s.substring(n2, i));
            if (s.charAt(i) == ' ' || char1 == '\n') {
               ++i;
            }
            n2 = i;
            n3 = 0;
            n4 = -1;
         }
         else {
            ++i;
         }
      }
      if (i > n2) {
         vector.addElement(s.substring(n2, i));
      }
      final String[] array = new String[vector.size()];
      for (int j = 0; j < array.length; ++j) {
         array[j] = (String)vector.elementAt(j);
      }
      return array[0];
   }

   private static Image changeImageColor(final Image image, int n) {
      final int[] array = new int[image.getWidth() * image.getHeight()];
      n = n;
      final Image rgbImage = Image.createRGBImage(new int[] { n }, 1, 1, false);
      final int[] array2 = { 0 };
      rgbImage.getRGB(array2, 0, 1, 0, 0, 1, 1);
      n = array2[0];
      image.getRGB(array, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
      for (int i = 0; i < array.length; ++i) {
         if (array[i] == -1) {
            array[i] = n;
         }
      }
      return Image.createRGBImage(array, image.getWidth(), image.getHeight(), true);
   }

   public static String[] wrapTextToLines(final String s, final int n) {
      if (FontRenderer.tempStringVector == null) {
         FontRenderer.tempStringVector = new Vector();
      }
      else {
         FontRenderer.tempStringVector.removeAllElements();
      }
      String[] a;
      for (int length = (a = splitStringByChar(s, (char)10)).length, i = 0; i < length; ++i) {
         final String s2;
         if ((s2 = a[i]).length() > 0) {
            String[] d;
            for (int length2 = (d = splitLineByWords(s2, n)).length, j = 0; j < length2; ++j) {
               FontRenderer.tempStringVector.addElement(d[j]);
            }
         }
         else {
            FontRenderer.tempStringVector.addElement("");
         }
      }
      final String[] anArray = new String[FontRenderer.tempStringVector.size()];
      FontRenderer.tempStringVector.copyInto(anArray);
      System.gc();
      return anArray;
   }

   private static String[] splitLineByWords(final String s, final int n) {
      final Vector vector = new Vector();
      String string = "";
      int beginIndex;
      int i;
      for (beginIndex = 0, i = s.indexOf(32); i >= 0; i = s.indexOf(32, beginIndex)) {
         final String substring = s.substring(beginIndex, i + 1);
         if (getTextWidth(String.valueOf(string) + substring) >= n) {
            vector.addElement(string);
            string = "";
         }
         string = String.valueOf(string) + substring;
         beginIndex = i + 1;
      }
      if (i == -1) {
         final String substring2 = s.substring(beginIndex);
         if (getTextWidth(String.valueOf(string) + substring2) >= n) {
            vector.addElement(string);
            string = "";
         }
         vector.addElement(String.valueOf(string) + substring2);
      }
      final String[] anArray = new String[vector.size()];
      vector.copyInto(anArray);
      return anArray;
   }

   public static String[] splitStringByChar(final String s, final char c) {
      int n = 0;
      int i = s.indexOf(c);
      final Vector vector = new Vector();
      while (i > 0) {
         if (s.charAt(i - 1) == '\r') {
            vector.addElement(s.substring(n, i - 1));
         }
         else {
            vector.addElement(s.substring(n, i));
         }
         n = i + 1;
         i = s.indexOf(c, n);
      }
      if (n < s.length()) {
         vector.addElement(s.substring(n));
      }
      final String[] anArray = new String[vector.size()];
      vector.copyInto(anArray);
      return anArray;
   }
}
