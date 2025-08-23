import java.io.UnsupportedEncodingException;

public final class Base64Encoder {
   private static final byte[] STANDARD_ENCODE_ALPHABET = new byte[]{
      65,
      66,
      67,
      68,
      69,
      70,
      71,
      72,
      73,
      74,
      75,
      76,
      77,
      78,
      79,
      80,
      81,
      82,
      83,
      84,
      85,
      86,
      87,
      88,
      89,
      90,
      97,
      98,
      99,
      100,
      101,
      102,
      103,
      104,
      105,
      106,
      107,
      108,
      109,
      110,
      111,
      112,
      113,
      114,
      115,
      116,
      117,
      118,
      119,
      120,
      121,
      122,
      48,
      49,
      50,
      51,
      52,
      53,
      54,
      55,
      56,
      57,
      43,
      47
   };
   private static final byte[] STANDARD_DECODE_ALPHABET = new byte[]{
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -5,
      -5,
      -9,
      -9,
      -5,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -5,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      62,
      -9,
      -9,
      -9,
      63,
      52,
      53,
      54,
      55,
      56,
      57,
      58,
      59,
      60,
      61,
      -9,
      -9,
      -9,
      -1,
      -9,
      -9,
      -9,
      0,
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9,
      10,
      11,
      12,
      13,
      14,
      15,
      16,
      17,
      18,
      19,
      20,
      21,
      22,
      23,
      24,
      25,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      26,
      27,
      28,
      29,
      30,
      31,
      32,
      33,
      34,
      35,
      36,
      37,
      38,
      39,
      40,
      41,
      42,
      43,
      44,
      45,
      46,
      47,
      48,
      49,
      50,
      51,
      -9,
      -9,
      -9,
      -9
   };
   private static final byte[] URL_SAFE_ENCODE_ALPHABET = new byte[]{
      65,
      66,
      67,
      68,
      69,
      70,
      71,
      72,
      73,
      74,
      75,
      76,
      77,
      78,
      79,
      80,
      81,
      82,
      83,
      84,
      85,
      86,
      87,
      88,
      89,
      90,
      97,
      98,
      99,
      100,
      101,
      102,
      103,
      104,
      105,
      106,
      107,
      108,
      109,
      110,
      111,
      112,
      113,
      114,
      115,
      116,
      117,
      118,
      119,
      120,
      121,
      122,
      48,
      49,
      50,
      51,
      52,
      53,
      54,
      55,
      56,
      57,
      45,
      95
   };
   private static final byte[] URL_SAFE_DECODE_ALPHABET = new byte[]{
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -5,
      -5,
      -9,
      -9,
      -5,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -5,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      62,
      -9,
      -9,
      52,
      53,
      54,
      55,
      56,
      57,
      58,
      59,
      60,
      61,
      -9,
      -9,
      -9,
      -1,
      -9,
      -9,
      -9,
      0,
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9,
      10,
      11,
      12,
      13,
      14,
      15,
      16,
      17,
      18,
      19,
      20,
      21,
      22,
      23,
      24,
      25,
      -9,
      -9,
      -9,
      -9,
      63,
      -9,
      26,
      27,
      28,
      29,
      30,
      31,
      32,
      33,
      34,
      35,
      36,
      37,
      38,
      39,
      40,
      41,
      42,
      43,
      44,
      45,
      46,
      47,
      48,
      49,
      50,
      51,
      -9,
      -9,
      -9,
      -9
   };
   private static final byte[] ORDERED_ENCODE_ALPHABET = new byte[]{
      45,
      48,
      49,
      50,
      51,
      52,
      53,
      54,
      55,
      56,
      57,
      65,
      66,
      67,
      68,
      69,
      70,
      71,
      72,
      73,
      74,
      75,
      76,
      77,
      78,
      79,
      80,
      81,
      82,
      83,
      84,
      85,
      86,
      87,
      88,
      89,
      90,
      95,
      97,
      98,
      99,
      100,
      101,
      102,
      103,
      104,
      105,
      106,
      107,
      108,
      109,
      110,
      111,
      112,
      113,
      114,
      115,
      116,
      117,
      118,
      119,
      120,
      121,
      122
   };
   private static final byte[] ORDERED_DECODE_ALPHABET = new byte[]{
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -5,
      -5,
      -9,
      -9,
      -5,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -5,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      -9,
      0,
      -9,
      -9,
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9,
      10,
      -9,
      -9,
      -9,
      -1,
      -9,
      -9,
      -9,
      11,
      12,
      13,
      14,
      15,
      16,
      17,
      18,
      19,
      20,
      21,
      22,
      23,
      24,
      25,
      26,
      27,
      28,
      29,
      30,
      31,
      32,
      33,
      34,
      35,
      36,
      -9,
      -9,
      -9,
      -9,
      37,
      -9,
      38,
      39,
      40,
      41,
      42,
      43,
      44,
      45,
      46,
      47,
      48,
      49,
      50,
      51,
      52,
      53,
      54,
      55,
      56,
      57,
      58,
      59,
      60,
      61,
      62,
      63,
      -9,
      -9,
      -9,
      -9
   };

   private static final byte[] getDecodeLookupTable(int var0) {
      if ((var0 & 16) == 16) {
         return URL_SAFE_DECODE_ALPHABET;
      } else {
         return (var0 & 32) == 32 ? ORDERED_DECODE_ALPHABET : STANDARD_DECODE_ALPHABET;
      }
   }

   private static byte[] encodeGroup(byte[] var0, int var1, int var2, byte[] var3, int var4, int var5) {
      byte[] var7 = (var5 & 16) == 16 ? URL_SAFE_ENCODE_ALPHABET : ((var5 & 32) == 32 ? ORDERED_ENCODE_ALPHABET : STANDARD_ENCODE_ALPHABET);
      int var6 = (var2 > 0 ? var0[var1] << 24 >>> 8 : 0) | (var2 > 1 ? var0[var1 + 1] << 24 >>> 16 : 0) | (var2 > 2 ? var0[var1 + 2] << 24 >>> 24 : 0);
      switch (var2) {
         case 1:
            var3[var4] = var7[var6 >>> 18];
            var3[var4 + 1] = var7[var6 >>> 12 & 63];
            var3[var4 + 2] = 61;
            var3[var4 + 3] = 61;
            return var3;
         case 2:
            var3[var4] = var7[var6 >>> 18];
            var3[var4 + 1] = var7[var6 >>> 12 & 63];
            var3[var4 + 2] = var7[var6 >>> 6 & 63];
            var3[var4 + 3] = 61;
            return var3;
         case 3:
            var3[var4] = var7[var6 >>> 18];
            var3[var4 + 1] = var7[var6 >>> 12 & 63];
            var3[var4 + 2] = var7[var6 >>> 6 & 63];
            var3[var4 + 3] = var7[var6 & 63];
            return var3;
         default:
            return var3;
      }
   }

   private static String encodeToString(byte[] var0, int var1, int var2, int var3) {
      byte[] var9 = new byte[(var1 = (var2 << 2) / 3) + (var2 % 3 > 0 ? 4 : 0) + var1 / 76];
      byte var10 = 0;
      int var4 = 0;
      int var5 = var2 - 2;

      for (byte var6 = 0; var10 < var5; var4 += 4) {
         encodeGroup(var0, var10, 3, var9, var4, 0);
         var6 += 4;
         if (var6 == 76) {
            var9[var4 + 4] = 10;
            var4++;
            var6 = 0;
         }

         var10 += 3;
      }

      if (var10 < var2) {
         encodeGroup(var0, var10, var2 - var10, var9, var4, 0);
         var4 += 4;
      }

      try {
         return new String(var9, 0, var4, "UTF-8");
      } catch (UnsupportedEncodingException var7) {
         return new String(var9, 0, var4);
      }
   }

   private static int decodeGroup(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      byte[] var6 = getDecodeLookupTable(var4);
      if (var0[2] == 61) {
         var4 = (var6[var0[0]] & 255) << 18 | (var6[var0[1]] & 255) << 12;
         var2[var3] = (byte)(var4 >>> 16);
         return 1;
      } else if (var0[3] == 61) {
         var4 = (var6[var0[0]] & 255) << 18 | (var6[var0[1]] & 255) << 12 | (var6[var0[2]] & 255) << 6;
         var2[var3] = (byte)(var4 >>> 16);
         var2[var3 + 1] = (byte)(var4 >>> 8);
         return 2;
      } else {
         try {
            var4 = (var6[var0[0]] & 255) << 18 | (var6[var0[1]] & 255) << 12 | (var6[var0[2]] & 255) << 6 | var6[var0[3]] & 255;
            var2[var3] = (byte)(var4 >> 16);
            var2[var3 + 1] = (byte)(var4 >> 8);
            var2[var3 + 2] = (byte)var4;
            return 3;
         } catch (Exception var5) {
            System.out.println(var0[0] + ": " + var6[var0[0]]);
            System.out.println(var0[1] + ": " + var6[var0[1]]);
            System.out.println(var0[2] + ": " + var6[var0[2]]);
            System.out.println(var0[3] + ": " + var6[var0[3]]);
            return -1;
         }
      }
   }

   private static byte[] decodeFromString(final String s, int n) {
      byte[] array;
      try {
         array = s.getBytes("UTF-8");
      }
      catch (final UnsupportedEncodingException ex) {
         array = s.getBytes();
      }
      final byte[] array2 = array;
      final int length = array.length;
      final int n2 = 0;
      n = length;
      final byte[] array3 = array2;
      final byte[] a = getDecodeLookupTable(n2);
      final byte[] array4 = new byte[n * 3 / 4];
      int n3 = 0;
      final byte[] array5 = new byte[4];
      int n4 = 0;
      for (int i = 0; i < n + 0; ++i) {
         final byte b = (byte)(array3[i] & 0x7F);
         final byte b2;
         if ((b2 = a[b]) < -5) {
            System.err.println("Bad Base64 input character at " + i + ": " + array3[i] + "(decimal)");
            final byte[] array7;
            return array7 = null;
         }
         if (b2 >= -1) {
            array5[n4++] = b;
            if (n4 > 3) {
               n3 += decodeGroup(array5, 0, array4, n3, n2);
               n4 = 0;
               if (b == 61) {
                  break;
               }
            }
         }
      }
      final byte[] array8 = new byte[n3];
      System.arraycopy(array4, 0, array8, 0, n3);
      byte[] array7;
      return array7 = array8;
   }

   public static String encodeWithReverse(String var0) {
      byte[] var1;
      return reverseString(encodeToString(var1 = var0.getBytes(), 0, var1.length, 0));
   }

   private static String reverseString(String var0) {
      char[] var1 = var0.toCharArray();
      int var2 = var0.length() - 1;
      int var5 = var0.length() / 2;

      for (int var4 = 0; var4 < var5; var4++) {
         char var3 = var1[var4];
         var1[var4] = var1[var2 - var4];
         var1[var2 - var4] = var3;
      }

      return new String(var1);
   }

   public static String decodeWithReverse(String var0) {
      byte[] var1 = decodeFromString(reverseString(var0), 0);
      return new String(var1);
   }
}
