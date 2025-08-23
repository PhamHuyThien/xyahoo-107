package home.thienph.xyahoo107.utils;

public final class TextValidator {
   public static String[] BANNED_WORDS = new String[]{
      "dm",
      "cl",
      "vl",
      "dkm",
      "vkl",
      "clmm",
      "loz",
      "xlon",
      "cailon",
      "dkmm",
      "cai lon",
      "lon me",
      "lon ma",
      "xao lon",
      "vai lon",
      "di me",
      "cho de",
      "du ma",
      "du me",
      "dit me",
      "dis me",
      "dit con me",
      "dis con me",
      "con dj",
      "dj me",
      "djt me",
      "djt con me",
      "djs me",
      "dj.t me",
      "di.t me",
      "bu lon",
      "pu lon",
      "bu cac",
      "pu cac",
      "con cac",
      "l0n",
      "djt",
      "dit",
      "du m",
      "fuck"
   };

   public static final int validateUsername(String var0) {
      if (var0.length() != 0 && var0.length() >= 6 && var0.length() <= 64) {
         for (int var1 = 0; var1 < 9; var1++) {
            String var2 = String.valueOf((char)(var1 + 48));
            if (var0.startsWith(var2)) {
               return 2;
            }
         }

         for (int var3 = 0; var3 < var0.length(); var3++) {
            char var4 = var0.charAt(var3);
            if (('A' > var4 || var4 > 'Z') && ('a' > var4 || var4 > 'z') && ('0' > var4 || var4 > '9')) {
               return 3;
            }
         }

         return 0;
      } else {
         return 1;
      }
   }

   public static String filterBadWords(String var0) {
      String var1 = var0.toLowerCase();

      for (int var2 = 0; var2 < BANNED_WORDS.length; var2++) {
         int var3;
         if ((var3 = var1.indexOf(BANNED_WORDS[var2])) >= 0) {
            boolean var4 = false;
            boolean var5 = false;

            try {
               if (var0.substring(var3 - 1, var3 + BANNED_WORDS[var2].length()).equals(" " + BANNED_WORDS[var2])) {
                  var4 = true;
               }
            } catch (Exception var8) {
               var4 = true;
            }

            try {
               if (var0.substring(var3, var3 + BANNED_WORDS[var2].length() + 1).equals(BANNED_WORDS[var2] + " ")) {
                  var5 = true;
               }
            } catch (Exception var7) {
               var5 = true;
            }

            if (var4 && var5) {
               var0 = var0.substring(0, var3) + "**" + var0.substring(var3 + BANNED_WORDS[var2].length());
               var1 = var1.substring(0, var3) + "**" + var1.substring(var3 + BANNED_WORDS[var2].length());
            }
         }
      }

      return var0;
   }
}
