import javax.microedition.lcdui.Image;
import java.util.Vector;

public final class quyen_he extends quyen_jz {
   public static quyen_et a;
   private static quyen_he b = null;
   private static String c;

   private quyen_he() {
   }

   public static quyen_he a() {
      if (b == null) {
         b = new quyen_he();
      }

      return b;
   }

   public final void b() {
      a.t();
   }

   public final void c() {
      a.u();
   }

   public final void d() {
      quyen_et.F();
   }

   public final void a(quyen_ju var1, int var2) {
      int var3 = var1.c();
      switch (var2) {
         case -5:
            quyen_et.C();
            return;
         case -3:
            a.q();
            return;
         case -2:
            a.r();
            return;
         case -1:
            a.s();
            return;
         case 2:
            int var240;
            String[] var241 = new String[var240 = quyen_a.d(var1)];
            int[] var242 = new int[var240];
            System.out.println("IPs:");

            for (int var244 = 0; var244 < var240; var244++) {
               var241[var244] = quyen_a.g(var1);
               System.out.println(var241[var244]);
               var242[var244] = quyen_a.d(var1);
               System.out.println(var242[var244]);
            }

            quyen_et.a(var241, var242);
            return;
         case 3:
            long var285 = quyen_a.c(var1);
            byte var158;
            int[] var159 = new int[var158 = var1.b().a()];

            for (byte var160 = 0; var160 < var158; var160 += 1) {
               var159[var160] = quyen_a.d(var1);
            }

            a.a(var285, var159);
            return;
         case 39:
            String var236 = quyen_a.g(var1);
            int var237;
            if ((var237 = quyen_a.d(var1)) == 0) {
               a.a(0, var236, null, 180, 2, null);
               return;
            }

            if (var237 == 1) {
               a.h(var236);
               return;
            }
            break;
         case 44:
            c = quyen_a.g(var1);
            return;
         case 45:
            String var238 = quyen_a.g(var1);
            String var75 = quyen_a.g(var1);
            String var76 = quyen_a.g(var1);
            a.b(var76, var238, var75);
            return;
         case 64:
            boolean var239 = quyen_a.e(var1);
            a.b(var239);
            return;
         case 113:
            int var243;
            quyen_hs.a = new String[var243 = quyen_a.d(var1)];

            for (int var246 = 0; var246 < var243; var246++) {
               quyen_hs.a[var246] = quyen_a.g(var1);
            }

            return;
         case 120:
            Integer var89 = new Integer(quyen_a.d(var1));
            byte[] var90 = quyen_a.b(var1);
            quyen_et.a(var89, var90);
            return;
         case 121:
            System.gc();
            byte[] var245 = quyen_a.b(var1);
            a.b(var245);
            return;
         case 122:
            int var247 = quyen_a.d(var1);
            int var85 = quyen_a.d(var1);
            a.b(var247, var85);
            return;
         case 123:
            System.gc();
            int var86 = quyen_a.d(var1);
            int var87 = quyen_a.d(var1);
            byte[] var88 = quyen_a.b(var1);
            a.a(var86, var87, var88);
            return;
         case 269:
            String var232 = quyen_a.g(var1);
            String var233 = quyen_a.g(var1);
            quyen_et.c.c(false);
            a.b(var232, var233);
            return;
         case 500:
            int var234 = quyen_a.d(var1);
            String var235 = quyen_a.g(var1);
            a.a(var234, var235);
            return;
         case 1009:
            String var284 = quyen_a.g(var1);
            a.a(var284, 0L, false);
            return;
         case 1029:
            String var283 = quyen_a.g(var1);
            a.i(var283);
            return;
         case 3403:
            String var248 = quyen_a.g(var1);
            boolean var100 = quyen_a.e(var1);
            Object var249 = null;
            long var251 = 0L;
            if (var100) {
               if (quyen_cz.b && !quyen_cz.d.equals(var248)) {
                  return;
               }

               quyen_a.g(var1);
               var249 = quyen_a.g(var1);
               var251 = quyen_a.c(var1);
               int var253;
               String[] var254 = new String[var253 = quyen_a.d(var1)];
               long[] var255 = new long[var253];
               int[] var257 = new int[var253];
               boolean[] var109 = new boolean[var253];

               for (int var258 = 0; var258 < var253; var258++) {
                  var254[var258] = quyen_a.g(var1);
                  var109[var258] = quyen_a.e(var1);
                  var255[var258] = quyen_a.c(var1);
                  var257[var258] = quyen_a.d(var1);
                  if (var257[var258] != -1) {
                     var257[var258] = (short)var257[var258];
                  }
               }

               quyen_cz.O.N = quyen_a.e(var1);
               quyen_cz var287 = quyen_cz.O;
               String var288 = quyen_a.g(var1);
               String var290 = quyen_a.g(var1);
               quyen_hr.b(var287, quyen_hr.a(var288, " - ", var290, null));
               a.a(var248, var251, var254, var255, var257, var109, (String)var249);
            } else {
               b(var1);
            }

            quyen_et.c.c(false);
            return;
         case 3405:
            String var104 = quyen_a.g(var1);
            int var105;
            String[] var106 = new String[var105 = quyen_a.d(var1)];
            boolean[] var107 = new boolean[var105];

            for (int var256 = 0; var256 < var105; var256++) {
               var106[var256] = quyen_a.g(var1);
               var107[var256] = quyen_a.e(var1);
            }

            quyen_et.a(var104, var106, var107);
            return;
         case 3406:
            String var108 = quyen_a.g(var1);
            if (quyen_a.e(var1)) {
               quyen_a.g(var1);
               byte[] var259 = quyen_a.b(var1);
               String var260 = quyen_a.g(var1);
               boolean var261 = quyen_a.e(var1);
               quyen_a.c(var1);
               long var102 = 0L;
               quyen_et.a(var108, var259, var260, var261);
               return;
            }

            b(var1);
            return;
         case 3407:
            String var119 = quyen_a.g(var1);
            if (quyen_a.e(var1)) {
               String var265 = quyen_a.g(var1);
               String var122 = quyen_a.g(var1);
               boolean var268 = quyen_a.e(var1);
               if (quyen_a.e(var1)) {
                  quyen_a.g(var1);
                  quyen_a.g(var1);
                  quyen_a.c(var1);
               }

               quyen_et.a(var119, var265, var122, var268);
               return;
            }
            break;
         case 3408:
            String var121 = quyen_a.g(var1);
            if (quyen_a.e(var1)) {
               String var267 = quyen_a.g(var1);
               int var269 = quyen_a.d(var1);
               byte[] var270 = quyen_a.b(var1);
               String var271 = quyen_a.g(var1);
               boolean var272 = quyen_a.e(var1);
               if (quyen_a.e(var1)) {
                  int var273 = quyen_a.d(var1);
                  a.a(var121, var267, var269, var270, var271, var272, var273);
                  return;
               }

               a.a(var121, var267, var269, var270, var271, var272);
               return;
            }

            String var266 = quyen_a.g(var1);
            quyen_et.e().a(var266, (Image) null, 1);
            quyen_a.d(var1);
            quyen_a.b(var1);
            if (quyen_cz.d.equals(var121)) {
               quyen_et.J();
               return;
            }
            break;
         case 3409:
            String var274 = quyen_a.g(var1);
            if (quyen_a.e(var1)) {
               String var275 = quyen_a.g(var1);
               if (quyen_a.e(var1)) {
                  String var277 = quyen_a.g(var1);
                  boolean var279 = quyen_a.e(var1);
                  quyen_a.b(var1);
                  if (quyen_a.e(var1)) {
                     quyen_a.g(var1);
                     quyen_a.g(var1);
                     quyen_a.c(var1);
                  }

                  quyen_et.b(var274, var275, var277, var279);
                  return;
               }

               String var137 = quyen_a.g(var1);
               int var276;
               String[] var278 = new String[var276 = quyen_a.d(var1)];

               for (byte var280 = 0; var280 < var276; var280 += 1) {
                  var278[var280] = quyen_a.g(var1);
               }

               String var281 = quyen_a.g(var1);
               a.a(var274, var275, var137, var278, var281);
               return;
            }
            break;
         case 3410:
            quyen_a.g(var1);
            if (!quyen_a.e(var1)) {
               b(var1);
               return;
            }

            quyen_a.g(var1);
            long var289 = quyen_a.c(var1);
            if (var3 != 39) {
               return;
            }

            quyen_cz.O.a(var289);
            break;
         case 3411:
            String var164 = quyen_a.g(var1);
            String var165 = quyen_a.g(var1);
            String var166 = quyen_a.g(var1);
            quyen_et.a(var164, var165, var166, var3);
            break;
         case 3412:
            String var152 = quyen_a.g(var1);
            if (!quyen_a.e(var1)) {
               b(var1);
               return;
            }

            String var154 = quyen_a.g(var1);
            int var155;
            String[] var156 = new String[var155 = quyen_a.d(var1)];

            for (byte var157 = 0; var157 < var155; var157 += 1) {
               var156[var157] = quyen_a.g(var1);
            }

            String var286 = quyen_a.g(var1);
            a.a(var152, var154, quyen_cz.O.a, var156, var286);
            return;
         case 3416:
            quyen_a.g(var1);
            long var282 = quyen_a.c(var1);
            quyen_a.c(var1);
            a.b(var282);
            return;
         case 3417:
            b(var1);
            return;
         case 3418:
            String var195 = quyen_a.g(var1);
            byte var204 = var1.b().a();
            int var216 = quyen_a.d(var1);
            String var221 = quyen_a.g(var1);
            Integer var222 = new Integer(quyen_a.d(var1));
            Integer var7 = new Integer(quyen_a.d(var1));
            String var181 = quyen_a.g(var1);
            a.a(var195, new quyen_bc(var204, var216, var221, var222, var7, var181), 0);
            return;
         case 4801:
            if (quyen_a.e(var1)) {
               String var215 = quyen_hr.a("P. ", quyen_a.g(var1), null, null);
               String var220 = quyen_a.g(var1);
               long var230 = quyen_a.c(var1);
               quyen_a.c(var1);
               quyen_a.g(var1);
               a.a(var215, var220, var230);
               return;
            }

            b(var1);
            return;
         case 4802:
            b(var1);
            return;
         case 4803:
            String var214 = quyen_hr.a("P. ", quyen_a.g(var1), null, null);
            quyen_cj var219;
            if ((var219 = quyen_et.c.e(var214)) != null) {
               quyen_et.c.U = null;
               quyen_et.c.c(var219);
            }

            b(var1);
            return;
         case 4804:
            quyen_a.c(var1);
            String var231 = quyen_a.g(var1);
            String var53 = quyen_a.g(var1);
            quyen_a.d(var1);
            int var180 = quyen_a.d(var1);
            a.b(var231, var53, var180);
            return;
         case 4807:
            String var194 = quyen_a.g(var1);
            String var203 = quyen_hr.a("P. ", quyen_a.g(var1), null, null);
            String var213 = quyen_a.g(var1);
            String var179 = quyen_a.g(var1);
            a.a(var194, var203, var213, var179);
            return;
         case 4809:
            b(var1);
            return;
         case 4813:
            String var192 = quyen_hr.a("P. ", quyen_a.g(var1), null, null);
            String var178 = quyen_hr.a("P. ", quyen_a.g(var1), null, null);
            quyen_cj var193;
            if ((var193 = quyen_et.c.e(var192)) != null) {
               var193.j = var178;
               quyen_hr.b(var193, var178);
               quyen_et.c.U = var178;
               return;
            }
            break;
         case 5001:
            byte var91 = var1.b().a();
            byte var177 = var1.b().a();
            a.a(var91, var177);
            return;
         case 5002:
            String var92 = quyen_a.g(var1);
            int var93 = quyen_a.d(var1);
            a.c(var92, var93);
            return;
         case 5003:
            boolean var94 = quyen_a.e(var1);
            a.d(var94);
            return;
         case 5004:
            String var191 = quyen_a.g(var1);
            String var202 = quyen_a.g(var1);
            int var212 = quyen_a.d(var1);
            byte var176 = var1.b().a();
            a.a(var191, var202, var212, var176);
            return;
         case 5005:
            String var190 = quyen_a.g(var1);
            byte[] var175 = quyen_a.b(var1);
            a.c(false);
            a.a(var190, var175);
            return;
         case 34061:
            String var110 = quyen_a.g(var1);
            String var111 = quyen_a.g(var1);
            int var112;
            String[] var113 = new String[var112 = quyen_a.d(var1)];
            int[] var114 = new int[var112];
            long[] var115 = new long[var112];
            long[] var116 = new long[var112];
            byte[][] var117 = new byte[var112][];

            for (int var263 = 0; var263 < var112; var263++) {
               var113[var263] = quyen_a.g(var1);
               var114[var263] = quyen_a.d(var1);
               var115[var263] = quyen_a.c(var1);
               var116[var263] = quyen_a.c(var1);
               var117[var263] = quyen_a.b(var1);
            }

            quyen_bc[] var264 = a(var1, var112, var113, 0);
            quyen_et.a(var110, var111, (byte)var112, var113, var114, var115, var116, var117, var264);
            return;
         case 34081:
            String var123 = quyen_a.g(var1);
            String var124 = quyen_a.g(var1);
            int var125 = quyen_a.d(var1);
            byte[] var126 = quyen_a.b(var1);
            int var127 = quyen_a.d(var1);
            String var101 = quyen_a.g(var1);
            quyen_cz.O.a = var101;
            int var128;
            String[] var129 = new String[var128 = quyen_a.d(var1)];
            int[] var130 = new int[var128];
            long[] var131 = new long[var128];
            long[] var132 = new long[var128];
            byte[][] var133 = new byte[var128][];
            boolean[] var134 = new boolean[var128];

            for (byte var135 = 0; var135 < var128; var135 += 1) {
               var129[var135] = quyen_a.g(var1);
               var130[var135] = quyen_a.d(var1);
               var131[var135] = quyen_a.c(var1);
               var132[var135] = quyen_a.c(var1);
               var133[var135] = quyen_a.b(var1);
               var134[var135] = quyen_a.e(var1);
            }

            quyen_bc[] var262 = a(var1, var128, var129, 0);
            quyen_et.a(var123, var124, var125, var126, var127, var129, var130, var131, var132, var133, var134, var262);
            return;
         case 34091:
            String var138 = quyen_a.g(var1);
            String var139 = quyen_a.g(var1);
            int var140 = quyen_a.d(var1);
            String var141 = quyen_a.g(var1);
            quyen_cz.O.a = var141;
            byte[] var142 = new byte[0];
            int var143;
            String[] var144 = new String[var143 = quyen_a.d(var1)];
            int[] var145 = new int[var143];
            long[] var146 = new long[var143];
            long[] var147 = new long[var143];
            byte[][] var148 = new byte[var143][];
            boolean[] var149 = new boolean[var143];

            for (byte var150 = 0; var150 < var143; var150 += 1) {
               var144[var150] = quyen_a.g(var1);
               var145[var150] = quyen_a.d(var1);
               var146[var150] = quyen_a.c(var1);
               var147[var150] = quyen_a.c(var1);
               var148[var150] = quyen_a.b(var1);
               var149[var150] = quyen_a.e(var1);
            }

            quyen_bc[] var118 = a(var1, var143, var144, 0);
            quyen_et.a(var138, var139, 0, var142, var140, var144, var145, var146, var147, var148, var149, var118);
            return;
         case 5000009:
            StringBuffer var189 = null;
            quyen_bb var64 = new quyen_bb();
            int var65;
            quyen_ba[] var66 = new quyen_ba[var65 = quyen_a.d(var1)];
            String[] var67 = new String[var65];

            for (int var68 = 0; var68 < var65; var68++) {
               try {
                  var67[var68] = quyen_a.g(var1);
               } catch (Exception var171) {
                  var67[var68] = "";
               }

               String var69 = quyen_a.g(var1);
               String var70 = quyen_a.g(var1);
               int var72 = quyen_a.d(var1);
               int var73 = quyen_a.d(var1);
               if (var189 == null) {
                  var189 = new StringBuffer(0);
               } else {
                  var189.delete(0, var189.length());
               }

               var189.append(var72);
               var189.append("/");
               var189.append(var73);
               byte var71;
               int var74;
               if ((var74 = var72 * 100 / var73) < 30) {
                  var71 = 2;
               } else if (var74 < 80) {
                  var71 = 3;
               } else {
                  var71 = 4;
               }

               var66[var68] = new quyen_ba(var69, var70, var71, null, null, -1, var68, var189.toString());
               var64.a(var67[var68], var66[var68]);
            }

            System.gc();
            quyen_et.c.c(false);
            a.b(var64);
            return;
         case 5000011:
            String var95 = quyen_a.g(var1);
            String var96 = quyen_a.g(var1);
            int var97;
            quyen_cv[] var98 = new quyen_cv[var97 = quyen_a.d(var1)];

            for (int var99 = 0; var99 < var97; var99++) {
               var98[var99] = new quyen_cv();
               var98[var99].a = quyen_a.g(var1);
               var98[var99].b = var1.b().a();
               quyen_cv var10000 = var98[var99];
               long var162 = quyen_a.c(var1);
               var10000.c = quyen_hr.a(quyen_hr.a(var162), " $", null, null);
               var98[var99].a((byte)quyen_a.d(var1));
            }

            quyen_et.c.c(false);
            a.a(var95, var98, 0, var96);
            return;
         case 5000015:
            long var16 = quyen_a.c(var1);
            var2 = quyen_a.d(var1);
            long[] var201 = null;
            if (var2 > 0) {
               var201 = new long[var2];

               for (int var210 = 0; var210 < var2; var210++) {
                  var201[var210] = quyen_a.c(var1);
               }
            }

            int var211 = -1;

            try {
               var211 = quyen_a.d(var1);
            } catch (Exception var170) {
            }

            a.a(var16, var201, var211);
            return;
         case 5000016:
            long var228 = quyen_a.c(var1);
            a.a(var228);
            return;
         case 5000018:
            var2 = quyen_a.d(var1);
            long[] var200 = null;
            String[] var209 = null;
            if (var2 > 0) {
               var200 = new long[var2];
               var209 = new String[var2];

               for (int var218 = 0; var218 < var2; var218++) {
                  var200[var218] = quyen_a.c(var1);
                  var209[var218] = quyen_a.g(var1);
               }
            }

            a.a(var200, var209);
            return;
         case 5000019:
            a.b(quyen_a.c(var1), quyen_a.d(var1));
            return;
         case 5000021:
            int var217 = quyen_a.d(var1);
            long[] var186 = null;
            if (var217 > 0) {
               var186 = new long[var217];

               for (int var223 = 0; var223 < var217; var223++) {
                  var186[var223] = quyen_a.c(var1);
               }
            }

            a.a(var186);
            return;
         case 5000022:
            long var26 = quyen_a.c(var1);
            String var174 = quyen_a.g(var1);
            a.a(var26, var174);
            return;
         case 5000023:
            long var40 = quyen_a.c(var1);
            String var173 = quyen_a.g(var1);
            a.c(var40, var173);
            return;
         case 5000024:
            a.a(quyen_a.c(var1), quyen_a.d(var1));
            return;
         case 5000026:
            if (quyen_a.e(var1)) {
               long var229 = quyen_a.c(var1);
               String var185 = quyen_a.g(var1);
               var3 = quyen_a.d(var1);
               int var208 = quyen_a.d(var1);
               a.a(var229, var185, var3, var208);
               return;
            }
            break;
         case 5000028:
            quyen_ba[] var224 = new quyen_ba[var2 = quyen_a.d(var1)];
            quyen_bb var32 = new quyen_bb();

            for (int var198 = 0; var198 < var2; var198++) {
               long var226 = quyen_a.c(var1);
               String var207 = quyen_a.g(var1);
               String var227 = quyen_a.g(var1);
               var224[var198] = new quyen_ba(var207, "", 0, var227, new int[0], 0, var198, null);
               var224[var198].l = var226;
               if (quyen_ia.I == 1) {
                  var32.a("Ban Be", var224[var198]);
               } else if (quyen_ia.I == 2) {
                  var32.a("Danh sách từ chối", var224[var198]);
               } else {
                  var32.a("Danh sách kết bạn", var224[var198]);
               }
            }

            if (quyen_ia.I == 1) {
               a.c(var32);
               return;
            }

            if (quyen_ia.I == 2) {
               a.e(var32);
               return;
            }

            a.d(var32);
            return;
         case 5000029:
            if ((var3 = quyen_a.d(var1)) > 0) {
               long[] var225 = new long[var3];
               String[] var35 = new String[var3];

               for (int var206 = 0; var206 < var3; var206++) {
                  var225[var206] = quyen_a.c(var1);
                  var35[var206] = quyen_a.g(var1);
               }

               a.b(var225, var35);
               return;
            }
            break;
         case 5000031:
            long var34 = quyen_a.c(var1);
            byte var205 = var1.b().a();
            a.c(var34, var205);
            return;
         case 5000032:
            int var44;
            if ((var44 = quyen_a.d(var1)) != 0) {
               Vector var45 = new Vector();
               quyen_bb var183 = new quyen_bb();

               for (int var196 = 0; var196 < var44; var196++) {
                  String var4 = quyen_a.g(var1);
                  String var5;
                  String[] var50 = quyen_bt.c(var5 = quyen_a.g(var1), quyen_cj.h - 30);
                  String var51 = quyen_a.g(var1);
                  long var52 = quyen_a.c(var1);
                  if (!var45.contains(var4)) {
                     quyen_ba var6;
                     (var6 = new quyen_ba(var4, "", 0, var50[0] + (var50.length > 1 ? ".." : ""), new int[0], 0, 0, null)).l = var52;
                     var183.a("", var6);
                     var45.addElement(var4);
                  }

                  a.c(var4, quyen_hr.a(var5, " (", var51, ")"));
               }

               a.f(var183);
               return;
            }
            break;
         case 5000033:
            quyen_et.M = quyen_a.e(var1);
            return;
         case 5000034:
            int var77 = quyen_a.d(var1);

            for (int var78 = 0; var78 < var77; var78++) {
               int var79 = quyen_a.d(var1);
               String var80 = quyen_a.g(var1);
               byte[] var81 = quyen_a.b(var1);
               int var82 = quyen_a.d(var1);
               int var83 = quyen_a.d(var1);
               String var84 = quyen_a.g(var1);
               a.a(var79, var80, var81, var83, var82, var84);
            }

            return;
         case 5000035:
            long var37 = quyen_a.c(var1);
            String var172 = quyen_a.g(var1);
            a.d(var37, var172);
            return;
         case 5000036:
            a.m(quyen_a.g(var1));
            return;
         case 5000038:
            quyen_et.c.H = false;
            if (quyen_a.e(var1)) {
               String var182 = quyen_a.g(var1);
               long var31 = quyen_a.c(var1);
               a.b(var31, var182);
               return;
            }

            quyen_et.c.d(quyen_a.g(var1));
            return;
         case 5000040:
            quyen_hr.a(true);
            return;
         case 6000000:
            quyen_a.a(Xuka.f);
            return;
         case 11712001:
            quyen_et.c.c(false);
            a.k(quyen_a.g(var1));
            return;
         case 11712002:
            quyen_et.c.c(false);
            quyen_et.l(quyen_a.g(var1));
            return;
      }
   }

   private static quyen_bc[] a(quyen_ju var0, int var1, String[] var2, int var3) {
      byte[] var13 = new byte[var1];
      int[] var4 = new int[var1];
      String[] var5 = new String[var1];
      String[] var6 = new String[var1];
      Integer[] var7 = new Integer[var1];
      Integer[] var8 = new Integer[var1];
      String[] var9 = new String[var1];
      quyen_bc[] var10 = new quyen_bc[var1];

      for (int var11 = 0; var11 < var1; var11++) {
         var13[var11] = var0.b().a();
         var4[var11] = quyen_a.d(var0);
         var5[var11] = quyen_a.g(var0);
         var6[var11] = quyen_a.g(var0);
         var7[var11] = new Integer(quyen_a.d(var0));
         var8[var11] = new Integer(quyen_a.d(var0));
         var9[var11] = quyen_a.g(var0);
         var10[var11] = new quyen_bc(var13[var11], var4[var11], var5[var11], var7[var11], var8[1], var9[var11]);
         a.a(var2[var11], var10[var11], 0);
      }

      return var10;
   }

   private static void b(quyen_ju var0) {
      String var1 = quyen_a.g(var0);
      quyen_et.c.a(var1, (Image) null, 1);
   }
}
