import java.io.DataInputStream;
import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class quyen_af {
   private static Vector b;
   private static quyen_ci c;
   private static byte d;
   private static int[] e;
   private static DataInputStream f;
   public static int a;
   private static boolean g;

   private static String a(quyen_ju var0) {
      return quyen_a.g(var0);
   }

   public static void a(byte[] var0) {
      if (var0 != null && var0.length >= 2) {
         quyen_ju var1;
         (var1 = new quyen_ju(0, 0)).a(new quyen_jt(var0));

         while (true) {
            int var148;
            switch (var148 = quyen_a.d(var1)) {
               case 0:
                  int var170 = quyen_a.d(var1);
                  quyen_et.c.d(quyen_et.c.b(var170));
                  break;
               case 1:
                  boolean var217 = quyen_a.e(var1);
                  String var169 = a(var1);
                  quyen_et.c.c(var169).a(var217);
                  break;
               case 2:
               case 9:
               case 10:
               case 11:
               case 25:
               case 27:
               case 32:
               case 33:
               case 34:
               case 35:
               case 36:
               case 37:
               case 38:
               case 40:
               case 41:
               case 42:
               case 43:
               case 44:
               case 45:
               case 46:
               case 51:
               case 55:
               default:
                  System.gc();
                  return;
               case 3:
                  int var167 = quyen_a.d(var1);
                  quyen_ju var183 = new quyen_ju(0, 0);
                  quyen_a.a(var167, var183);
                  int var168 = quyen_a.d(var1);
                  int var193 = 0;

                  for (; var193 < var168; var193++) {
                     byte var212 = var1.b().a();
                     int var232 = var1.b().a();
                     if (var212 == 0) {
                        if (var232 == 0) {
                           quyen_a.a(quyen_a.d(var1), var183);
                        } else if (var232 == 1) {
                           var232 = quyen_a.d(var1);
                           quyen_cj var256 = quyen_et.c.b(var232);
                           int var274 = quyen_a.d(var1);
                           boolean var216 = quyen_a.e(var1);
                           var232 = 0;
                           quyen_bx var275;
                           if ((var275 = var256.d(var274)) != null) {
                              if (var275 instanceof quyen_cs) {
                                 String var283 = ((quyen_cs)var275).c();
                                 if (var216 && var283.equals("")) {
                                    quyen_hr.a(var256, var275);
                                    return;
                                 }

                                 try {
                                    var232 = Integer.parseInt(var283);
                                 } catch (Exception var145) {
                                    quyen_hr.a(var256, var275);
                                    return;
                                 }
                              } else if (var275 instanceof quyen_bv) {
                                 var232 = ((quyen_bv)var275).a();
                              } else if (var275 instanceof quyen_cb) {
                                 var232 = ((quyen_cb)var275).a();
                              } else if (var275 instanceof quyen_bz) {
                                 var232 = ((quyen_bz)var275).a;
                              }
                           }

                           quyen_a.a(var232, var183);
                        }
                     } else if (var212 == 1) {
                        if (var232 == 0) {
                           quyen_a.a(a(var1), var183);
                        } else if (var232 == 1) {
                           var232 = quyen_a.d(var1);
                           quyen_cj var255 = quyen_et.c.b(var232);
                           int var272 = quyen_a.d(var1);
                           boolean var215 = quyen_a.e(var1);
                           quyen_bx var238 = var255.d(var272);
                           String var273 = "";
                           if (var238 instanceof quyen_cs) {
                              var273 = ((quyen_cs)var238).c();
                              if (var215 && var273.equals("")) {
                                 quyen_hr.a(var255, var238);
                                 return;
                              }
                           } else if (var238 instanceof quyen_bv) {
                              var273 = ((quyen_bv)var238).b();
                           } else if (var238 instanceof quyen_ch) {
                              quyen_ch var282;
                              var273 = (var282 = (quyen_ch)var238).c().j;
                           }

                           quyen_a.a(var273, var183);
                        }
                     } else if (var212 == 2) {
                        if (var232 == 0) {
                           quyen_a.a(quyen_a.e(var1), var183);
                        } else if (var232 == 1) {
                           var232 = quyen_a.d(var1);
                           quyen_cj var254 = quyen_et.c.b(var232);
                           int var271 = quyen_a.d(var1);
                           quyen_bx var214;
                           if ((var214 = var254.d(var271)) instanceof quyen_bu) {
                              boolean var236 = ((quyen_bu)var214).a;
                              quyen_a.a(((quyen_bu)var214).a, var183);
                           }
                        }
                     } else if (var212 == 3 && var232 == 1) {
                        var232 = quyen_a.d(var1);
                        quyen_cj var253 = quyen_et.c.b(var232);
                        int var269 = quyen_a.d(var1);
                        quyen_bx var213;
                        if ((var213 = var253.d(var269)) instanceof quyen_ch) {
                           String[] var234;
                           if ((var234 = ((quyen_ch)var213).f()) != null) {
                              quyen_a.a(var269 = var234.length, var183);

                              for (int var281 = 0; var281 < var269; var281++) {
                                 quyen_a.a(var234[var281], var183);
                              }
                           } else {
                              quyen_a.a(0, var183);
                           }
                        } else {
                           quyen_a.a(0, var183);
                        }
                     }
                  }

                  quyen_a.a(d, var183);
                  quyen_a.a(var183.b().b());
                  break;
               case 4:
                  quyen_co var331;
                  (var331 = new quyen_co()).w = true;
                  String var332 = quyen_a.g(var1);
                  var331.j = var332;
                  int var333 = quyen_a.d(var1);
                  var331.v = var333;
                  quyen_et.c.d(quyen_et.c.b(var333));
                  var331.b(1);
                  boolean var334 = quyen_a.e(var1);
                  quyen_et.c.a((quyen_cj)var331);
                  if (var334) {
                     quyen_et.c.o();
                  }

                  if (var333 == 11111) {
                     quyen_et.c.a(var331);
                  }
                  break;
               case 5:
                  int var192 = quyen_a.d(var1);
                  quyen_cj var211 = quyen_et.c.b(var192);
                  switch (var1.b().a()) {
                     case 0:
                        quyen_bw var231 = b(var1);
                        if (quyen_et.d(var192)) {
                           Vector var252;
                           (var252 = new Vector()).addElement(new quyen_bw("Biểu cảm", new quyen_ax()));
                           var252.addElement(var231);
                           quyen_ci var268 = new quyen_ci(var252);
                           var211.m = new quyen_bw("Menu", new quyen_ay(var268));
                        } else {
                           var211.m = var231;
                        }
                        break;
                     case 1:
                        var211.o = b(var1);
                        break;
                     case 2:
                        var211.n = b(var1);
                  }

                  var211.p = true;
                  break;
               case 6:
                  int var165 = quyen_a.d(var1);
                  quyen_co var166 = (quyen_co)quyen_et.c.b(var165);
                  byte var251 = var1.b().a();
                  Object var180 = null;
                  switch (var251) {
                     case 0:
                        String var305 = quyen_a.g(var1);
                        int var307 = quyen_a.d(var1);
                        int var308 = quyen_a.d(var1);
                        quyen_cs var309;
                        var180 = var309 = quyen_bw.b(var166, var305, var307, var308);
                        a(var166, (quyen_bx)var180, var1);
                        var309.a.j = var309.j;
                        break;
                     case 1:
                        String var310 = a(var1);
                        int var70 = quyen_a.d(var1);
                        if (var310.equals("")) {
                           quyen_ce var311;
                           (var311 = quyen_bw.a(var166, var70)).b = new Integer(quyen_hr.a(quyen_a.d(var1)));
                           var311.h = !var310.trim().equals("");
                           var180 = var311;
                           var1.b().a();
                        } else {
                           var180 = quyen_bw.a(var310, var166, var70, quyen_hr.a(quyen_a.d(var1)), true, true)[0];
                           a(var166, (quyen_bx)var180, var1);
                        }
                     case 2:
                     case 3:
                     case 9:
                     case 10:
                     default:
                        break;
                     case 4:
                        String var312 = a(var1);
                        int var73 = quyen_a.d(var1);
                        int var74 = quyen_hr.a(quyen_a.d(var1));
                        byte[] var75 = quyen_a.b(var1);
                        quyen_cf var76;
                        (var76 = quyen_bw.a(var166, var312, var73, new quyen_ah(var75), var166.A, var166.B, var166.C)).b = new Integer(var74);
                        var180 = var76;
                        a(var166, var76, var1);
                        break;
                     case 5:
                        String var80 = a(var1);
                        quyen_a.d(var1);
                        var180 = quyen_bw.a(var166, var80)[0];
                        break;
                     case 6:
                     case 12:
                        Image var82 = null;
                        int var83 = -1;
                        int var313 = 0;
                        int var314 = 0;
                        if (var251 == 12) {
                           byte[] var315;
                           var313 = (var82 = Image.createImage(var315 = quyen_a.b(var1), 0, var315.length)).getWidth();
                           var314 = var82.getHeight();
                        } else if (var251 == 6) {
                           var83 = quyen_a.d(var1);
                           var313 = quyen_a.d(var1);
                           var314 = quyen_a.d(var1);
                        }

                        boolean var316 = quyen_a.e(var1);
                        boolean var317 = quyen_a.e(var1);
                        String var318 = quyen_a.g(var1);
                        byte[] var89 = quyen_a.b(var1);
                        quyen_cc var90 = quyen_bw.a(var166, var83, var82, var313, var314, var316, var317);
                        if (var89 != null && var89.length > 1) {
                           var90.a(var318, new quyen_aj(var89));
                        }

                        var180 = var90;
                        a(var166, var90, var1);
                        break;
                     case 7:
                        String var118 = a(var1);
                        int var119 = quyen_a.d(var1);
                        int var120;
                        String[] var121 = new String[var120 = quyen_a.d(var1)];

                        for (int var122 = 0; var122 < var120; var122++) {
                           var121[var122] = a(var1);
                        }

                        byte[] var328 = quyen_a.b(var1);
                        quyen_bv var123 = quyen_bw.a(var166, var118, var121, var119);
                        if (var328 != null && var328.length > 1) {
                           var123.a(new quyen_an(var328));
                        }

                        int var124 = quyen_a.d(var1);
                        var180 = var123;
                        a(var166, var123, var1);
                        var123.a.j = var123.j;
                        var123.c(var124);
                        break;
                     case 8:
                        byte var91;
                        int[] var92 = new int[var91 = var1.b().a()];

                        for (int var93 = 0; var93 < var91; var93++) {
                           var92[var93] = quyen_a.d(var1);
                        }

                        int var84 = quyen_a.d(var1);
                        int var85 = quyen_a.d(var1);
                        boolean var86 = quyen_a.e(var1);
                        boolean var87 = quyen_a.e(var1);
                        String var88 = quyen_a.g(var1);
                        byte[] var319 = quyen_a.b(var1);
                        quyen_cc var335;
                        (var335 = new quyen_cc()).e(var84, var85);
                        var335.h = var86;
                        var335.a(var92);
                        var335.d(quyen_cj.h - var84 >> 1, var166.B == 6 ? var166.B : var166.B + 2);
                        var335.a = var87;
                        var166.a(var335);
                        var166.B += 2;
                        if (var88.length() > 0 && var319 != null && var319.length > 1) {
                           var335.a(var88, new quyen_ak(var319));
                        }

                        var180 = var335;
                        a(var166, var335, var1);
                        break;
                     case 11:
                        boolean var94 = quyen_a.e(var1);
                        byte var95 = var1.b().a();
                        byte var96 = var1.b().a();
                        int var97 = -1;
                        int var98 = -1;
                        if (var96 == 2) {
                           var97 = quyen_a.d(var1);
                           var98 = quyen_a.d(var1);
                        }

                        byte var99 = var1.b().a();
                        int var100 = quyen_a.d(var1);
                        quyen_bb var101 = new quyen_bb();
                        quyen_ba[] var102 = new quyen_ba[var100];
                        String[] var103 = new String[var100];

                        for (int var104 = 0; var104 < var100; var104++) {
                           var103[var104] = quyen_a.g(var1);
                           String var105 = quyen_a.g(var1);
                           String var321 = quyen_a.g(var1);
                           String var322 = null;
                           if (var95 == 1) {
                              var322 = quyen_a.g(var1);
                           }

                           Integer var323 = null;
                           Image var324 = null;
                           if (var96 == 2) {
                              var323 = new Integer(quyen_a.d(var1));
                           } else if (var96 == 3) {
                              var324 = quyen_hr.a(quyen_a.b(var1));
                              if (var97 == -1) {
                                 var97 = var324.getWidth();
                                 var98 = var324.getHeight();
                              }
                           }

                           byte var325 = 0;
                           if (var99 == 1) {
                              if ((var325 = var1.b().a()) == 0) {
                                 var325 = 2;
                              } else if (var325 == 1) {
                                 var325 = 3;
                              } else {
                                 var325 = 4;
                              }
                           }

                           String var327;
                           if ((var327 = quyen_a.g(var1)) != null && var327.length() == 0) {
                              var327 = null;
                           }

                           var102[var104] = new quyen_ba("", var321, var325, var322, null, -1, var104, var327);
                           var102[var104].h = var105;
                           var102[var104].m = var323;
                           var102[var104].n = var324;
                           var101.a(var103[var104], var102[var104]);
                        }

                        byte[] var320 = quyen_a.b(var1);
                        if (var97 == -1) {
                           var97 = 10;
                           var98 = 10;
                        }

                        quyen_ch var330 = new quyen_ch(0, 0, quyen_cj.h, quyen_cj.i - quyen_et.e);
                        var166.a(var330);
                        quyen_hr.a(var166, var330);
                        var330.a(var96, var97, var98);
                        var330.c(var99);
                        var330.a(var101, var95, var94);
                        if (var320 != null && var320.length > 1) {
                           var330.d = new quyen_al(var320);
                        }

                        if (var320 == null || var320.length <= 1) {
                           var330.a.a = "";
                        }

                        var180 = var330;
                        var166.s = true;
                        break;
                     case 13:
                        int var106 = quyen_a.d(var1);
                        int var107 = quyen_a.d(var1);
                        int var108 = quyen_a.d(var1);
                        boolean var109 = quyen_a.e(var1);
                        int[] var110 = new int[var106];
                        Integer[] var111 = new Integer[var106];
                        String[] var112 = new String[var106];
                        boolean[] var113 = null;
                        if (var109) {
                           var113 = new boolean[var106];
                        }

                        for (int var114 = 0; var114 < var106; var114++) {
                           var112[var114] = quyen_a.g(var1);
                           var110[var114] = quyen_a.d(var1);
                           var111[var114] = new Integer(quyen_a.d(var1));
                           if (var109) {
                              var113[var114] = quyen_a.e(var1);
                           }
                        }

                        quyen_cb var336 = new quyen_cb(0, 0, quyen_cj.h, quyen_cj.i - quyen_et.e, var106, var112, var110, var111, var107, var108, false, 2);
                        var166.a(var336);
                        quyen_hr.a(var166, var336);
                        byte[] var116 = quyen_a.b(var1);
                        quyen_bw var329 = new quyen_bw("Chọn", new quyen_am(var109, var336, var113, var116));
                        var336.r = var329;
                        var180 = var336;
                        var166.s = true;
                        break;
                     case 14:
                        String var190 = quyen_a.g(var1);
                        boolean var182 = quyen_a.e(var1);
                        var180 = quyen_bw.a(var166, var190, var182);
                        a(var166, (quyen_bx)var180, var1);
                        break;
                     case 15:
                        String var69;
                        quyen_ce var71;
                        (var71 = quyen_bw.a(var69 = a(var1), var166, -1)).b = new Integer(quyen_hr.a(quyen_a.d(var1)));
                        var71.h = !var69.trim().equals("");
                        var71.c = true;
                        var180 = var71;
                        a(var166, var71, var1);
                        break;
                     case 16:
                        String var189 = quyen_a.g(var1);
                        byte var181 = var1.b().a();
                        byte[] var304 = quyen_a.b(var1);
                        var180 = quyen_bw.a(var166, var189, var181, new quyen_az(var304));
                        break;
                     case 17:
                        String var72 = a(var1);
                        int var77 = quyen_a.d(var1);
                        byte[] var78 = quyen_a.b(var1);
                        var180 = quyen_bw.a(var166, var72, new quyen_ai(var78), var166.B, var77);
                        a(var166, (quyen_bx)var180, var1);
                  }

                  int var191 = quyen_a.d(var1);
                  ((quyen_bx)var180).n = var191;
                  if (((quyen_bx)var180).n > 1000 && var180 instanceof quyen_cs) {
                     ((quyen_cs)var180).f = true;
                  }
                  break;
               case 7:
                  int var178 = quyen_a.d(var1);
                  quyen_cj var179 = quyen_et.c.b(var178);
                  int var64 = quyen_a.d(var1);
                  quyen_bx var65 = var179.d(var64);
                  quyen_hr.a(var179, var65);
                  if (var179.equals(quyen_et.c.y())) {
                     var179.b();
                  }
                  break;
               case 8:
                  System.gc();
                  return;
               case 12:
                  int var164 = quyen_a.d(var1);
                  quyen_co var230 = (quyen_co)quyen_et.c.b(var164);
                  int var250;
                  String[] var267 = new String[var250 = quyen_a.d(var1)];

                  for (int var210 = 0; var210 < var250; var210++) {
                     var267[var210] = a(var1);
                  }

                  var230.a(var267);
                  break;
               case 13:
                  int var306 = quyen_a.d(var1);
                  quyen_co var67 = (quyen_co)quyen_et.c.b(var306);
                  int var68 = quyen_a.d(var1);
                  var67.e(var68);
                  break;
               case 14:
                  byte var160 = var1.b().a();
                  String var177 = "";
                  if (var160 == 0) {
                     var177 = a(var1);
                  } else {
                     int var161 = quyen_a.d(var1);
                     quyen_cj var188 = quyen_et.c.b(var161);
                     int var207 = quyen_a.d(var1);
                     boolean var162 = quyen_a.e(var1);
                     quyen_bx var208;
                     if ((var208 = var188.d(var207)) instanceof quyen_cs) {
                        var177 = ((quyen_cs)var208).c();
                        if (var162 && var177.equals("")) {
                           quyen_hr.a(var188, var208);
                           return;
                        }
                     }
                  }

                  String var163 = a(var1);
                  String var209 = quyen_hr.a("Gửi tin: ", var177, Xuka.f, "\nĐến số: ");
                  quyen_et.c.a(quyen_hr.a(var209, var163.substring(6), null, null), new quyen_aw(var177, var163));
                  break;
               case 15:
                  try {
                     Xuka.i.platformRequest(a(var1));
                  } catch (ConnectionNotFoundException var146) {
                  }
                  break;
               case 16:
               case 17:
                  quyen_co var266;
                  quyen_bx var206 = (var266 = (quyen_co)quyen_et.c.b(quyen_a.d(var1))).d(quyen_a.d(var1));
                  quyen_bx var228 = null;
                  if (var148 == 16) {
                     var206.j = quyen_a.d(var1);
                  } else {
                     var228 = var266.d(quyen_a.d(var1));
                     if (var148 == 17) {
                        var206.j = var228.j + var228.l + 6;
                     }
                  }
                  break;
               case 18:
               case 19:
               case 20:
                  quyen_co var265;
                  quyen_bx var205 = (var265 = (quyen_co)quyen_et.c.b(quyen_a.d(var1))).d(quyen_a.d(var1));
                  quyen_bx var226 = null;
                  if (var148 == 18) {
                     var205.k = quyen_a.d(var1);
                     var265.B = var205.k + var205.m + 2;
                  } else {
                     var226 = var265.d(quyen_a.d(var1));
                     if (var148 == 19) {
                        var205.k = var226.k + var226.m + 2;
                     } else if (var148 == 20) {
                        var205.k = var226.k;
                     }
                  }

                  var265.B = var205.k + var205.m + 2;
                  var265.d();
                  break;
               case 21:
                  String var176 = a(var1);
                  quyen_ju var159 = new quyen_ju(0, 0);
                  quyen_a.a(0, var159);
                  quyen_a.a(var176, var159);
                  quyen_a.a(var159.b().b());
                  break;
               case 22:
                  quyen_et.c.d(quyen_et.c.e(a(var1)));
                  break;
               case 23:
                  quyen_et.c.f();
                  break;
               case 24:
                  int var158 = quyen_a.d(var1);
                  int var204 = quyen_a.d(var1);
                  String var225 = a(var1);

                  try {
                     ((quyen_cs)quyen_et.c.b(var158).d(var204)).c(var225);
                  } catch (Exception var144) {
                  }
                  break;
               case 26:
                  String var203 = a(var1);
                  long var302 = quyen_a.c(var1);
                  quyen_hg var298;
                  (var298 = quyen_et.e().n(var203)).a(var302);
                  quyen_et.e().f(var298.j);
                  break;
               case 28:
                  quyen_et.c.d(a(var1));
                  break;
               case 29:
               case 60:
               case 61:
                  String var264 = null;
                  byte var279 = 0;
                  byte var285 = 0;
                  byte var287 = 0;
                  Vector var224 = null;
                  String var249 = null;
                  if (var148 == 29) {
                     var249 = a(var1);
                  } else if (var148 == 60 || var148 == 61) {
                     var264 = quyen_a.g(var1);
                     var279 = var1.b().a();
                     var285 = var1.b().a();
                     var287 = var1.b().a();
                     var224 = new Vector();

                     for (int var289 = 0; var289 < var279; var289++) {
                        String[] var292 = new String[var285];

                        for (int var295 = 0; var295 < var285; var295++) {
                           var292[var295] = quyen_a.g(var1);
                        }

                        var224.addElement(var292);
                     }

                     if (var264 != null && var264.length() == 0) {
                        var264 = null;
                     }
                  }

                  quyen_bw var290 = null;
                  quyen_bw var293 = null;
                  quyen_bw var296 = null;
                  if (var148 == 29 || var148 == 61) {
                     String var202 = a(var1);
                     byte[] var301 = quyen_a.b(var1);
                     String var303 = a(var1);
                     byte[] var297 = quyen_a.b(var1);
                     String var300 = a(var1);
                     byte[] var175 = quyen_a.b(var1);
                     if (var301 != null && var301.length > 1) {
                        var290 = new quyen_bw(var202, new quyen_at(var301));
                     }

                     if (var297 != null && var297.length > 1) {
                        var293 = new quyen_bw(var303, new quyen_au(var297));
                     }

                     if (var175 != null && var175.length > 1) {
                        var296 = new quyen_bw(var300, new quyen_av(var175));
                     }
                  }

                  if (var148 == 29) {
                     quyen_et.c.a(var249, var290, var293, var296);
                  } else if (var148 == 60) {
                     quyen_et.c.a(var264, var287, var224, var285, quyen_et.c.l(), quyen_et.c.b("OK"), null);
                  } else if (var148 == 61) {
                     quyen_et.c.a(var264, var287, var224, var285, var290, var293, var296);
                  }
                  break;
               case 30:
                  int var157 = quyen_a.d(var1);
                  int var263 = quyen_a.d(var1);
                  boolean var278 = quyen_a.e(var1);

                  try {
                     ((quyen_ch)quyen_et.c.b(var157).d(var263)).a(var278);
                  } catch (Exception var142) {
                  }
                  break;
               case 31:
                  int var156 = quyen_a.d(var1);
                  int var174 = quyen_a.d(var1);

                  try {
                     ((quyen_ch)quyen_et.c.b(var156).d(var174)).g();
                  } catch (Exception var141) {
                  }
                  break;
               case 39:
                  a(quyen_a.b(var1));
                  break;
               case 47:
                  int var126 = quyen_a.d(var1);
                  quyen_co var127;
                  if ((var127 = (quyen_co)quyen_et.c.b(var126)) != null) {
                     int var128 = var1 == null ? 1 : quyen_a.d(var1);
                     int var129 = var1 == null ? 20 : quyen_a.d(var1);
                     String var130 = quyen_hr.a(" / ", Integer.toString(var129), null, null);
                     int var131 = quyen_bt.b(" 99 ") + 6;
                     int var132 = quyen_cj.h - quyen_bt.b(quyen_hr.a("<<   >>   ", var130, null, null)) - var131 >> 1;
                     quyen_cf var133 = new quyen_cf("<<", var132, quyen_cj.i - quyen_et.e - quyen_bt.e - 6, quyen_bt.e + 4);
                     quyen_cf var134 = new quyen_cf(">>", var133.j + quyen_bt.b("<<   "), var133.k, quyen_bt.e + 4);
                     quyen_cs var135;
                     (var135 = new quyen_cs()).b = true;
                     var135.a(var134.j + quyen_bt.b(">>   "), var133.k - 1, var131, quyen_bt.e + 3);
                     var135.d(1);
                     var135.c(Integer.toString(var128));
                     quyen_ce var136 = new quyen_ce(var130, var135.j + var135.l, var135.k + 2, quyen_bt.e + 2);
                     if (var1 != null) {
                        var133.n = quyen_a.d(var1);
                        byte[] var137 = quyen_a.b(var1);
                        var134.n = quyen_a.d(var1);
                        byte[] var138 = quyen_a.b(var1);
                        var135.n = quyen_a.d(var1);
                        byte[] var139 = quyen_a.b(var1);
                        var133.c = new quyen_ao(var137);
                        var134.c = new quyen_ap(var138);
                        var135.r = new quyen_bw("Đến trang", new quyen_aq(var135, var129, var139));
                     }

                     var127.a(var133);
                     var127.a(var134);
                     var127.a(var135);
                     var127.a(var136);
                     System.gc();
                  }
                  break;
               case 48:
                  if (b == null) {
                     b = new Vector();
                  } else {
                     b.removeAllElements();
                  }

                  System.gc();
                  byte var223 = var1.b().a();
                  byte var248 = var1.b().a();

                  for (int var201 = 0; var201 < var248; var201++) {
                     String var262 = quyen_a.g(var1);
                     byte[] var277 = quyen_a.b(var1);
                     byte var284 = (byte)var201;
                     quyen_bw var286 = new quyen_bw(var262, new quyen_ar(var284, var277));
                     b.addElement(var286);
                  }

                  if (c == null) {
                     c = new quyen_ci(b);
                  }

                  quyen_et.c.a(c, var223);
                  break;
               case 49:
                  String var299 = a(var1);
                  quyen_a.c(var1);
                  quyen_et.c.h.d(var299);
                  break;
               case 50:
                  int var66 = quyen_a.d(var1);
                  quyen_co var155;
                  (var155 = (quyen_co)quyen_et.c.b(var66)).b(1);
                  quyen_et.c.e(var155);
                  break;
               case 52:
                  quyen_et.c.c(true);
                  break;
               case 53:
                  quyen_et.c.c(false);
                  break;
               case 54:
                  int var187 = quyen_a.d(var1);
                  quyen_et.c.d(quyen_et.c.b(var187));
                  quyen_go var200;
                  (var200 = new quyen_go()).v = var187;
                  var200.a(quyen_a.g(var1));
                  var200.b(quyen_a.g(var1));
                  var200.c.a = quyen_a.d(var1);
                  var200.a(quyen_a.b(var1));
                  var200.c.n = quyen_a.d(var1);
                  var200.f(1);
                  var200.b(1);
                  quyen_et.c.a(var200);
                  quyen_et.c.o();
                  break;
               case 56:
                  int var154 = quyen_a.d(var1);
                  int var199 = quyen_a.d(var1);

                  try {
                     quyen_cj var261;
                     quyen_cs var276 = (quyen_cs)(var261 = quyen_et.c.b(var154)).d(var199);
                     quyen_hr.a(var261, var276);
                  } catch (Exception var143) {
                  }
                  break;
               case 57:
                  int var152 = quyen_a.d(var1);
                  quyen_co var153 = (quyen_co)quyen_et.c.b(var152);
                  byte var173;
                  int[] var186;
                  (var186 = new int[var173 = var1.b().a()])[0] = quyen_a.d(var1);
                  quyen_bx var197;
                  int var221 = (var197 = var153.d(var186[0])).l;

                  for (int var246 = 1; var246 < var173; var246++) {
                     var186[var246] = quyen_a.d(var1);
                     quyen_bx var259;
                     (var259 = var153.d(var186[var246])).k = var197.k;
                     var221 += var259.l;
                  }

                  var153.B = var197.k + var197.m + 2;
                  int var247 = (quyen_cj.h - var221) / (var173 + 1);
                  var197.j = quyen_cj.h - (var221 + var247 * (var173 - 1)) >> 1;

                  for (int var260 = 1; var260 < var173; var260++) {
                     var197 = var153.d(var186[var260]);
                     quyen_bx var222 = var153.d(var186[var260 - 1]);
                     var197.j = var222.j + var222.l + var247;
                  }

                  var153.d();
                  break;
               case 58:
                  quyen_co var258 = (quyen_co)quyen_et.c.b(quyen_a.d(var1));
                  int var151 = quyen_a.d(var1);
                  byte var172 = var1.b().a();

                  for (int var185 = 0; var185 < var172; var185++) {
                     var258.d(quyen_a.d(var1)).j = var151;
                  }
                  break;
               case 59:
                  quyen_co var257;
                  quyen_bx var220 = (var257 = (quyen_co)quyen_et.c.b(quyen_a.d(var1))).d(quyen_a.d(var1));
                  byte var171 = var1.b().a();
                  quyen_bx var196 = null;
                  int[] var184 = new int[var171];

                  for (int var150 = 0; var150 < var171; var150++) {
                     var184[var150] = quyen_a.d(var1);
                     (var196 = var257.d(var184[var150])).j = var220.j + var220.l + 6;
                     if (var150 == 0) {
                        var196.k = var220.k;
                     } else {
                        quyen_bx var245 = var257.d(var184[var150 - 1]);
                        var196.k = var245.k + var245.m + 2;
                     }
                  }

                  var257.B = var196.k + var196.m + 2;
                  var257.d();
                  break;
               case 62:
                  int var149 = quyen_a.d(var1);
                  byte var2 = var1.b().a();

                  try {
                     for (int var3 = 0; var3 < var2; var3++) {
                        int var4 = quyen_a.d(var1);
                        int var5 = var1.b().a();
                        quyen_cj var6;
                        quyen_bx var194 = (var6 = quyen_et.c.b(var149)).d(var4);
                        switch (var5) {
                           case 0:
                              String var219 = quyen_a.g(var1);
                              String var244 = quyen_a.g(var1);
                              ((quyen_cs)var194).a.a = var219;
                              ((quyen_cs)var194).c(var244);
                              break;
                           case 1:
                              String var243 = quyen_a.g(var1);
                              ((quyen_ce)var194).a(var243);
                              break;
                           case 4:
                              String var242 = quyen_a.g(var1);
                              byte[] var294 = quyen_a.b(var1);
                              ((quyen_cf)var194).a = var242;
                              ((quyen_cf)var194).a(new quyen_ag(var294));
                              break;
                           case 7:
                              short var288 = quyen_a.a(var1);
                              ((quyen_bv)var194).c(var288);
                              break;
                           case 11:
                              quyen_ch var8;
                              quyen_bb var9 = (var8 = (quyen_ch)var194).b;
                              byte var10 = var1.b().a();
                              var5 = 0;

                              for (; var5 < var10; var5++) {
                                 String var241 = quyen_a.g(var1);
                                 int var11 = quyen_a.d(var1);
                                 byte[] var291 = quyen_a.b(var1);
                                 Integer var13 = null;
                                 Image var195 = null;
                                 if (var8.a() == 2) {
                                    var13 = new Integer(var11);
                                 } else {
                                    var195 = quyen_hr.a(var291);
                                 }

                                 String var20 = quyen_a.g(var1);
                                 String var21 = quyen_a.g(var1);
                                 String var14 = quyen_a.g(var1);
                                 quyen_ba var15 = var9.a(null, var241, 0L);
                                 if (var11 != 0) {
                                    var15.m = var13;
                                 }

                                 if (var291 != null && var291.length != 0) {
                                    var15.n = var195;
                                 }

                                 if (var20.length() > 0) {
                                    var15.b = var20;
                                 }

                                 if (var21.length() > 0) {
                                    var15.f = var21;
                                 }

                                 if (var14.length() > 0) {
                                    var15.d = var14;
                                 }
                              }

                              var8.b();
                              break;
                           case 14:
                              boolean var12 = quyen_a.e(var1);
                              ((quyen_bu)var194).a = var12;
                              break;
                           case 18:
                              quyen_go var7;
                              (var7 = (quyen_go)var6).a(quyen_a.g(var1));
                              var7.b(quyen_a.g(var1));
                              var7.c.a = quyen_a.d(var1);
                              var7.a(quyen_a.b(var1));
                        }
                     }
                  } catch (Exception var147) {
                     var147.printStackTrace();
                  }
            }
         }
      }
   }

   private static int a(quyen_co var0, quyen_bx var1, quyen_ju var2) {
      byte var4 = var2.b().a();
      if (var4 == 0) {
         var1.j = 6;
      } else if (var4 == 1) {
         var1.j = quyen_cj.h - var1.l >> 1;
      } else if (var4 == 2) {
         var1.j = quyen_cj.h - var1.l - 6;
      } else if (var4 == 3) {
         var1.j = var0.A;
      }

      return var4;
   }

   private static quyen_bw b(quyen_ju var0) {
      byte[] var1 = quyen_a.b(var0);
      return new quyen_bw(a(var0), new quyen_as(var1));
   }

   static void a(byte var0) {
      d = var0;
   }

   public static void a(int var0) {
      try {
         String var1 = null;
         byte[] var2 = new byte[1];
         if (var0 == 0) {
            var1 = "/Data0.tak";
         } else if (var0 == 1) {
            var1 = "/Data1.tak";
         } else if (var0 == 2) {
            var1 = "/Data2.tak";
         }

         e = new int[var0 = (f = new DataInputStream(var2.getClass().getResourceAsStream(var1))).readInt()];
         boolean var6 = false;
         int var8 = (var0 << 2) + 4;

         for (int var3 = 0; var3 < var0; var3++) {
            int var7 = f.readInt();
            e[var3] = var7 + var8;
         }
      } catch (Exception var4) {
         System.out.println("imgex3 " + var4.toString());
      }
   }

   public static byte[] b(int var0) {
      byte[] var1 = new byte[1];

      try {
         var1 = new byte[e[var0 + 1] - e[var0]];
         f.read(var1);
      } catch (Exception var2) {
         System.out.println("imgex1 " + var2.toString());
      }

      return var1;
   }

   public static void a() {
      e = null;

      try {
         f.close();
      } catch (Exception var1) {
         System.out.println("imgex2 " + var1.toString());
      }

      f = null;
      System.gc();
   }

   public static void a(Graphics var0) {
      var0.setColor(1055519);
      var0.fillRect(0, 0, quyen_n.j, quyen_n.k);
      if (quyen_n.m) {
         if (quyen_cp.d > -125) {
            quyen_cp.d = quyen_cp.d - quyen_cp.b;
         }

         if (quyen_cp.c > -46) {
            quyen_cp.c = quyen_cp.c - quyen_cp.b;
         }

         if (quyen_cp.d < -70) {
            g = true;
         }

         quyen_cp.b++;
      }

      var0.drawImage(quyen_cp.c(), quyen_cp.d, (quyen_n.k >> 1) - 15, 3);
      quyen_et.c.a(var0, quyen_cp.d, (quyen_n.k + quyen_cp.a >> 1) + 3);
      quyen_et.c.f++;
   }

   public static void b() {
      quyen_n.j = quyen_n.a.getWidth();
      quyen_n.k = quyen_n.a.getHeight();
      if (a == 35) {
         quyen_et.e().a(quyen_n.j, quyen_n.k);
      }

      if (quyen_n.m && g) {
         quyen_cp.d = quyen_n.j >> 1;
         quyen_cp.c = quyen_n.k >> 1;
         System.gc();
         quyen_n.i = 1;
      }

      a++;
   }
}
