import java.io.DataInputStream;
import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class MessageProcessor {
   private static Vector b;
   private static ContextMenu c;
   private static byte d;
   private static int[] e;
   private static DataInputStream f;
   public static int a;
   private static boolean g;

   private static String a(Packet var0) {
      return PacketUtils.readString(var0);
   }

   public static void a(byte[] var0) {
      if (var0 != null && var0.length >= 2) {
         Packet var1;
         (var1 = new Packet(0, 0)).setPayload(new ByteBuffer(var0));

         while (true) {
            int var148 = PacketUtils.readInt(var1);
            switch (var148) {
               case 0:
                  int var170 = PacketUtils.readInt(var1);
                  GameManager.instance.destroyScreen(GameManager.instance.b(var170));
                  break;
               case 1:
                  boolean var217 = PacketUtils.readBoolean(var1);
                  String var169 = a(var1);
                  GameManager.instance.c(var169).a(var217);
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
                  int var167 = PacketUtils.readInt(var1);
                  Packet var183 = new Packet(0, 0);
                  PacketUtils.writeInt(var167, var183);
                  int var168 = PacketUtils.readInt(var1);
                  int var193 = 0;

                  for (; var193 < var168; var193++) {
                     byte var212 = var1.getPayload().readByte();
                     int var232 = var1.getPayload().readByte();
                     if (var212 == 0) {
                        if (var232 == 0) {
                           PacketUtils.writeInt(PacketUtils.readInt(var1), var183);
                        } else if (var232 == 1) {
                           var232 = PacketUtils.readInt(var1);
                           Screen var256 = GameManager.instance.b(var232);
                           int var274 = PacketUtils.readInt(var1);
                           boolean var216 = PacketUtils.readBoolean(var1);
                           var232 = 0;
                           UIComponent var275;
                           if ((var275 = var256.findComponentByID(var274)) != null) {
                              if (var275 instanceof TextInputComponent) {
                                 String var283 = ((TextInputComponent)var275).getText();
                                 if (var216 && var283.equals("")) {
                                    UIUtils.focusComponent(var256, var275);
                                    return;
                                 }

                                 try {
                                    var232 = Integer.parseInt(var283);
                                 } catch (Exception var145) {
                                    UIUtils.focusComponent(var256, var275);
                                    return;
                                 }
                              } else if (var275 instanceof DropdownComponent) {
                                 var232 = ((DropdownComponent)var275).getSelectedIndex();
                              } else if (var275 instanceof GridComponent) {
                                 var232 = ((GridComponent)var275).getSelectedItemId();
                              } else if (var275 instanceof PhotoViewComponent) {
                                 var232 = ((PhotoViewComponent)var275).displayMode;
                              }
                           }

                           PacketUtils.writeInt(var232, var183);
                        }
                     } else if (var212 == 1) {
                        if (var232 == 0) {
                           PacketUtils.writeString(a(var1), var183);
                        } else if (var232 == 1) {
                           var232 = PacketUtils.readInt(var1);
                           Screen var255 = GameManager.instance.b(var232);
                           int var272 = PacketUtils.readInt(var1);
                           boolean var215 = PacketUtils.readBoolean(var1);
                           UIComponent var238 = var255.findComponentByID(var272);
                           String var273 = "";
                           if (var238 instanceof TextInputComponent) {
                              var273 = ((TextInputComponent)var238).getText();
                              if (var215 && var273.equals("")) {
                                 UIUtils.focusComponent(var255, var238);
                                 return;
                              }
                           } else if (var238 instanceof DropdownComponent) {
                              var273 = ((DropdownComponent)var238).getSelectedText();
                           } else if (var238 instanceof ListComponent) {
                              ListComponent var282;
                              var273 = (var282 = (ListComponent)var238).getSelectedItem().j;
                           }

                           PacketUtils.writeString(var273, var183);
                        }
                     } else if (var212 == 2) {
                        if (var232 == 0) {
                           PacketUtils.writeBoolean(PacketUtils.readBoolean(var1), var183);
                        } else if (var232 == 1) {
                           var232 = PacketUtils.readInt(var1);
                           Screen var254 = GameManager.instance.b(var232);
                           int var271 = PacketUtils.readInt(var1);
                           UIComponent var214;
                           if ((var214 = var254.findComponentByID(var271)) instanceof CheckboxComponent) {
                              boolean var236 = ((CheckboxComponent)var214).isChecked;
                              PacketUtils.writeBoolean(((CheckboxComponent)var214).isChecked, var183);
                           }
                        }
                     } else if (var212 == 3 && var232 == 1) {
                        var232 = PacketUtils.readInt(var1);
                        Screen var253 = GameManager.instance.b(var232);
                        int var269 = PacketUtils.readInt(var1);
                        UIComponent var213;
                        if ((var213 = var253.findComponentByID(var269)) instanceof ListComponent) {
                           String[] var234;
                           if ((var234 = ((ListComponent)var213).getSelectedItemIds()) != null) {
                              PacketUtils.writeInt(var269 = var234.length, var183);

                              for (int var281 = 0; var281 < var269; var281++) {
                                 PacketUtils.writeString(var234[var281], var183);
                              }
                           } else {
                              PacketUtils.writeInt(0, var183);
                           }
                        } else {
                           PacketUtils.writeInt(0, var183);
                        }
                     }
                  }

                  PacketUtils.writeByte(d, var183);
                  PacketSender.a(var183.getPayload().getBuffer());
                  break;
               case 4:
                  DialogScreen var331;
                  (var331 = new DialogScreen()).unused2 = true;
                  String var332 = PacketUtils.readString(var1);
                  var331.title = var332;
                  int var333 = PacketUtils.readInt(var1);
                  var331.unused1 = var333;
                  GameManager.instance.destroyScreen(GameManager.instance.b(var333));
                  var331.startSlideAnimation(1);
                  boolean var334 = PacketUtils.readBoolean(var1);
                  GameManager.instance.addScreenToStack((Screen)var331);
                  if (var334) {
                     GameManager.instance.o();
                  }

                  if (var333 == 11111) {
                     GameManager.instance.a(var331);
                  }
                  break;
               case 5:
                  int var192 = PacketUtils.readInt(var1);
                  Screen var211 = GameManager.instance.b(var192);
                  switch (var1.getPayload().readByte()) {
                     case 0:
                        UIFactory var231 = b(var1);
                        if (GameManager.d(var192)) {
                           Vector var252;
                           (var252 = new Vector()).addElement(new UIFactory("Biểu cảm", new quyen_ax()));
                           var252.addElement(var231);
                           ContextMenu var268 = new ContextMenu(var252);
                           var211.leftSoftkey = new UIFactory("Menu", new quyen_ay(var268));
                        } else {
                           var211.leftSoftkey = var231;
                        }
                        break;
                     case 1:
                        var211.centerSoftkey = b(var1);
                        break;
                     case 2:
                        var211.rightSoftkey = b(var1);
                  }

                  var211.needsUpdate = true;
                  break;
               case 6:
                  int var165 = PacketUtils.readInt(var1);
                  DialogScreen var166 = (DialogScreen) GameManager.instance.b(var165);
                  byte var251 = var1.getPayload().readByte();
                  Object var180 = null;
                  switch (var251) {
                     case 0:
                        String var305 = PacketUtils.readString(var1);
                        int var307 = PacketUtils.readInt(var1);
                        int var308 = PacketUtils.readInt(var1);
                        TextInputComponent var309;
                        var180 = var309 = UIFactory.createLabeledTextInput(var166, var305, var307, var308);
                        a(var166, (UIComponent)var180, var1);
                        var309.textInputHandler.posX = var309.posX;
                        break;
                     case 1:
                        String var310 = a(var1);
                        int var70 = PacketUtils.readInt(var1);
                        if (var310.equals("")) {
                           TextComponent var311;
                           (var311 = UIFactory.createSpacer(var166, var70)).textColor = new Integer(UIUtils.validateColor(PacketUtils.readInt(var1)));
                           var311.isVisible = !var310.trim().equals("");
                           var180 = var311;
                           var1.getPayload().readByte();
                        } else {
                           var180 = UIFactory.createWrappedText(var310, var166, var70, UIUtils.validateColor(PacketUtils.readInt(var1)), true, true)[0];
                           a(var166, (UIComponent)var180, var1);
                        }
                     case 2:
                     case 3:
                     case 9:
                     case 10:
                     default:
                        break;
                     case 4:
                        String var312 = a(var1);
                        int var73 = PacketUtils.readInt(var1);
                        int var74 = UIUtils.validateColor(PacketUtils.readInt(var1));
                        byte[] var75 = PacketUtils.readBytes(var1);
                        TextLinkComponent var76;
                        (var76 = UIFactory.createCustomButton(var166, var312, var73, new quyen_ah(var75), var166.dialogX, var166.nextComponentY, var166.dialogWidth)).textColor = new Integer(var74);
                        var180 = var76;
                        a(var166, var76, var1);
                        break;
                     case 5:
                        String var80 = a(var1);
                        PacketUtils.readInt(var1);
                        var180 = UIFactory.createSimpleText(var166, var80)[0];
                        break;
                     case 6:
                     case 12:
                        Image var82 = null;
                        int var83 = -1;
                        int var313 = 0;
                        int var314 = 0;
                        if (var251 == 12) {
                           byte[] var315;
                           var313 = (var82 = Image.createImage(var315 = PacketUtils.readBytes(var1), 0, var315.length)).getWidth();
                           var314 = var82.getHeight();
                        } else if (var251 == 6) {
                           var83 = PacketUtils.readInt(var1);
                           var313 = PacketUtils.readInt(var1);
                           var314 = PacketUtils.readInt(var1);
                        }

                        boolean var316 = PacketUtils.readBoolean(var1);
                        boolean var317 = PacketUtils.readBoolean(var1);
                        String var318 = PacketUtils.readString(var1);
                        byte[] var89 = PacketUtils.readBytes(var1);
                        ImageComponent var90 = UIFactory.createImageComponent(var166, var83, var82, var313, var314, var316, var317);
                        if (var89 != null && var89.length > 1) {
                           var90.setClickAction(var318, new quyen_aj(var89));
                        }

                        var180 = var90;
                        a(var166, var90, var1);
                        break;
                     case 7:
                        String var118 = a(var1);
                        int var119 = PacketUtils.readInt(var1);
                        int var120;
                        String[] var121 = new String[var120 = PacketUtils.readInt(var1)];

                        for (int var122 = 0; var122 < var120; var122++) {
                           var121[var122] = a(var1);
                        }

                        byte[] var328 = PacketUtils.readBytes(var1);
                        DropdownComponent var123 = UIFactory.createChoiceBoxWithID(var166, var118, var121, var119);
                        if (var328 != null && var328.length > 1) {
                           var123.setChangeAction(new quyen_an(var328));
                        }

                        int var124 = PacketUtils.readInt(var1);
                        var180 = var123;
                        a(var166, var123, var1);
                        var123.textInputHandler.posX = var123.posX;
                        var123.setSelectedIndex(var124);
                        break;
                     case 8:
                        byte var91;
                        int[] var92 = new int[var91 = var1.getPayload().readByte()];

                        for (int var93 = 0; var93 < var91; var93++) {
                           var92[var93] = PacketUtils.readInt(var1);
                        }

                        int var84 = PacketUtils.readInt(var1);
                        int var85 = PacketUtils.readInt(var1);
                        boolean var86 = PacketUtils.readBoolean(var1);
                        boolean var87 = PacketUtils.readBoolean(var1);
                        String var88 = PacketUtils.readString(var1);
                        byte[] var319 = PacketUtils.readBytes(var1);
                        ImageComponent var335;
                        (var335 = new ImageComponent()).setSize(var84, var85);
                        var335.isVisible = var86;
                        var335.setMultipleImages(var92);
                        var335.setPosition(Screen.screenWidth - var84 >> 1, var166.nextComponentY == 6 ? var166.nextComponentY : var166.nextComponentY + 2);
                        var335.hasBorder = var87;
                        var166.addComponent(var335);
                        var166.nextComponentY += 2;
                        if (var88.length() > 0 && var319 != null && var319.length > 1) {
                           var335.setClickAction(var88, new quyen_ak(var319));
                        }

                        var180 = var335;
                        a(var166, var335, var1);
                        break;
                     case 11:
                        boolean var94 = PacketUtils.readBoolean(var1);
                        byte var95 = var1.getPayload().readByte();
                        byte var96 = var1.getPayload().readByte();
                        int var97 = -1;
                        int var98 = -1;
                        if (var96 == 2) {
                           var97 = PacketUtils.readInt(var1);
                           var98 = PacketUtils.readInt(var1);
                        }

                        byte var99 = var1.getPayload().readByte();
                        int var100 = PacketUtils.readInt(var1);
                        DownloadDataManager var101 = new DownloadDataManager();
                        DownloadData[] var102 = new DownloadData[var100];
                        String[] var103 = new String[var100];

                        for (int var104 = 0; var104 < var100; var104++) {
                           var103[var104] = PacketUtils.readString(var1);
                           String var105 = PacketUtils.readString(var1);
                           String var321 = PacketUtils.readString(var1);
                           String var322 = null;
                           if (var95 == 1) {
                              var322 = PacketUtils.readString(var1);
                           }

                           Integer var323 = null;
                           Image var324 = null;
                           if (var96 == 2) {
                              var323 = new Integer(PacketUtils.readInt(var1));
                           } else if (var96 == 3) {
                              var324 = UIUtils.createImageFromBytes(PacketUtils.readBytes(var1));
                              if (var97 == -1) {
                                 var97 = var324.getWidth();
                                 var98 = var324.getHeight();
                              }
                           }

                           byte var325 = 0;
                           if (var99 == 1) {
                              if ((var325 = var1.getPayload().readByte()) == 0) {
                                 var325 = 2;
                              } else if (var325 == 1) {
                                 var325 = 3;
                              } else {
                                 var325 = 4;
                              }
                           }

                           String var327;
                           if ((var327 = PacketUtils.readString(var1)) != null && var327.length() == 0) {
                              var327 = null;
                           }

                           var102[var104] = new DownloadData("", var321, var325, var322, null, -1, var104, var327);
                           var102[var104].fileName = var105;
                           var102[var104].priority = var323;
                           var102[var104].thumbnailImage = var324;
                           var101.addDownloadToCategory(var103[var104], var102[var104]);
                        }

                        byte[] var320 = PacketUtils.readBytes(var1);
                        if (var97 == -1) {
                           var97 = 10;
                           var98 = 10;
                        }

                        ListComponent var330 = new ListComponent(0, 0, Screen.screenWidth, Screen.screenHeight - GameManager.footerHeight);
                        var166.addComponent(var330);
                        UIUtils.focusComponent(var166, var330);
                        var330.setIconSettings(var96, var97, var98);
                        var330.setStatusIconType(var99);
                        var330.setDataSource(var101, var95, var94);
                        if (var320 != null && var320.length > 1) {
                           var330.itemAction = new quyen_al(var320);
                        }

                        if (var320 == null || var320.length <= 1) {
                           var330.selectAction.text = "";
                        }

                        var180 = var330;
                        var166.isScrollLocked = true;
                        break;
                     case 13:
                        int var106 = PacketUtils.readInt(var1);
                        int var107 = PacketUtils.readInt(var1);
                        int var108 = PacketUtils.readInt(var1);
                        boolean var109 = PacketUtils.readBoolean(var1);
                        int[] var110 = new int[var106];
                        Integer[] var111 = new Integer[var106];
                        String[] var112 = new String[var106];
                        boolean[] var113 = null;
                        if (var109) {
                           var113 = new boolean[var106];
                        }

                        for (int var114 = 0; var114 < var106; var114++) {
                           var112[var114] = PacketUtils.readString(var1);
                           var110[var114] = PacketUtils.readInt(var1);
                           var111[var114] = new Integer(PacketUtils.readInt(var1));
                           if (var109) {
                              var113[var114] = PacketUtils.readBoolean(var1);
                           }
                        }

                        GridComponent var336 = new GridComponent(0, 0, Screen.screenWidth, Screen.screenHeight - GameManager.footerHeight, var106, var112, var110, var111, var107, var108, false, 2);
                        var166.addComponent(var336);
                        UIUtils.focusComponent(var166, var336);
                        byte[] var116 = PacketUtils.readBytes(var1);
                        UIFactory var329 = new UIFactory("Chọn", new quyen_am(var109, var336, var113, var116));
                        var336.middleSoftKey = var329;
                        var180 = var336;
                        var166.isScrollLocked = true;
                        break;
                     case 14:
                        String var190 = PacketUtils.readString(var1);
                        boolean var182 = PacketUtils.readBoolean(var1);
                        var180 = UIFactory.createCheckbox(var166, var190, var182);
                        a(var166, (UIComponent)var180, var1);
                        break;
                     case 15:
                        String var69;
                        TextComponent var71;
                        (var71 = UIFactory.createLabel(var69 = a(var1), var166, -1)).textColor = new Integer(UIUtils.validateColor(PacketUtils.readInt(var1)));
                        var71.isVisible = !var69.trim().equals("");
                        var71.enableScrolling = true;
                        var180 = var71;
                        a(var166, var71, var1);
                        break;
                     case 16:
                        String var189 = PacketUtils.readString(var1);
                        byte var181 = var1.getPayload().readByte();
                        byte[] var304 = PacketUtils.readBytes(var1);
                        var180 = UIFactory.createPopupDialog(var166, var189, var181, new quyen_az(var304));
                        break;
                     case 17:
                        String var72 = a(var1);
                        int var77 = PacketUtils.readInt(var1);
                        byte[] var78 = PacketUtils.readBytes(var1);
                        var180 = UIFactory.createButton(var166, var72, new quyen_ai(var78), var166.nextComponentY, var77);
                        a(var166, (UIComponent)var180, var1);
                  }

                  int var191 = PacketUtils.readInt(var1);
                  ((UIComponent)var180).id = var191;
                  if (((UIComponent)var180).id > 1000 && var180 instanceof TextInputComponent) {
                     ((TextInputComponent)var180).useNativeInput = true;
                  }
                  break;
               case 7:
                  int var178 = PacketUtils.readInt(var1);
                  Screen var179 = GameManager.instance.b(var178);
                  int var64 = PacketUtils.readInt(var1);
                  UIComponent var65 = var179.findComponentByID(var64);
                  UIUtils.focusComponent(var179, var65);
                  if (var179.equals(GameManager.instance.y())) {
                     var179.focusFirstComponent();
                  }
                  break;
               case 8:
                  System.gc();
                  return;
               case 12:
                  int var164 = PacketUtils.readInt(var1);
                  DialogScreen var230 = (DialogScreen) GameManager.instance.b(var164);
                  int var250;
                  String[] var267 = new String[var250 = PacketUtils.readInt(var1)];

                  for (int var210 = 0; var210 < var250; var210++) {
                     var267[var210] = a(var1);
                  }

                  var230.createMenuItems(var267);
                  break;
               case 13:
                  int var306 = PacketUtils.readInt(var1);
                  DialogScreen var67 = (DialogScreen) GameManager.instance.b(var306);
                  int var68 = PacketUtils.readInt(var1);
                  var67.expandMenu(var68);
                  break;
               case 14:
                  byte var160 = var1.getPayload().readByte();
                  String var177 = "";
                  if (var160 == 0) {
                     var177 = a(var1);
                  } else {
                     int var161 = PacketUtils.readInt(var1);
                     Screen var188 = GameManager.instance.b(var161);
                     int var207 = PacketUtils.readInt(var1);
                     boolean var162 = PacketUtils.readBoolean(var1);
                     UIComponent var208;
                     if ((var208 = var188.findComponentByID(var207)) instanceof TextInputComponent) {
                        var177 = ((TextInputComponent)var208).getText();
                        if (var162 && var177.equals("")) {
                           UIUtils.focusComponent(var188, var208);
                           return;
                        }
                     }
                  }

                  String var163 = a(var1);
                  String var209 = UIUtils.concatStrings("Gửi tin: ", var177, Xuka.refCode, "\nĐến số: ");
                  GameManager.instance.a(UIUtils.concatStrings(var209, var163.substring(6), null, null), new quyen_aw(var177, var163));
                  break;
               case 15:
                  try {
                     Xuka.instance.platformRequest(a(var1));
                  } catch (ConnectionNotFoundException var146) {
                  }
                  break;
               case 16:
               case 17:
                  DialogScreen var266;
                  UIComponent var206 = (var266 = (DialogScreen) GameManager.instance.b(PacketUtils.readInt(var1))).findComponentByID(PacketUtils.readInt(var1));
                  UIComponent var228 = null;
                  if (var148 == 16) {
                     var206.posX = PacketUtils.readInt(var1);
                  } else {
                     var228 = var266.findComponentByID(PacketUtils.readInt(var1));
                     if (var148 == 17) {
                        var206.posX = var228.posX + var228.width + 6;
                     }
                  }
                  break;
               case 18:
               case 19:
               case 20:
                  DialogScreen var265;
                  UIComponent var205 = (var265 = (DialogScreen) GameManager.instance.b(PacketUtils.readInt(var1))).findComponentByID(PacketUtils.readInt(var1));
                  UIComponent var226 = null;
                  if (var148 == 18) {
                     var205.posY = PacketUtils.readInt(var1);
                     var265.nextComponentY = var205.posY + var205.height + 2;
                  } else {
                     var226 = var265.findComponentByID(PacketUtils.readInt(var1));
                     if (var148 == 19) {
                        var205.posY = var226.posY + var226.height + 2;
                     } else if (var148 == 20) {
                        var205.posY = var226.posY;
                     }
                  }

                  var265.nextComponentY = var205.posY + var205.height + 2;
                  var265.updateLayout();
                  break;
               case 21:
                  String var176 = a(var1);
                  Packet var159 = new Packet(0, 0);
                  PacketUtils.writeInt(0, var159);
                  PacketUtils.writeString(var176, var159);
                  PacketSender.a(var159.getPayload().getBuffer());
                  break;
               case 22:
                  GameManager.instance.destroyScreen(GameManager.instance.setActiveScreen(a(var1)));
                  break;
               case 23:
                  GameManager.instance.closeDialog();
                  break;
               case 24:
                  int var158 = PacketUtils.readInt(var1);
                  int var204 = PacketUtils.readInt(var1);
                  String var225 = a(var1);

                  try {
                     ((TextInputComponent) GameManager.instance.b(var158).findComponentByID(var204)).setText(var225);
                  } catch (Exception var144) {
                  }
                  break;
               case 26:
                  String var203 = a(var1);
                  long var302 = PacketUtils.readLong(var1);
                  ChatScreen var298;
                  (var298 = GameManager.getInstance().n(var203)).setChatId(var302);
                  GameManager.getInstance().f(var298.title);
                  break;
               case 28:
                  GameManager.instance.d(a(var1));
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
                     var264 = PacketUtils.readString(var1);
                     var279 = var1.getPayload().readByte();
                     var285 = var1.getPayload().readByte();
                     var287 = var1.getPayload().readByte();
                     var224 = new Vector();

                     for (int var289 = 0; var289 < var279; var289++) {
                        String[] var292 = new String[var285];

                        for (int var295 = 0; var295 < var285; var295++) {
                           var292[var295] = PacketUtils.readString(var1);
                        }

                        var224.addElement(var292);
                     }

                     if (var264 != null && var264.length() == 0) {
                        var264 = null;
                     }
                  }

                  UIFactory var290 = null;
                  UIFactory var293 = null;
                  UIFactory var296 = null;
                  if (var148 == 29 || var148 == 61) {
                     String var202 = a(var1);
                     byte[] var301 = PacketUtils.readBytes(var1);
                     String var303 = a(var1);
                     byte[] var297 = PacketUtils.readBytes(var1);
                     String var300 = a(var1);
                     byte[] var175 = PacketUtils.readBytes(var1);
                     if (var301 != null && var301.length > 1) {
                        var290 = new UIFactory(var202, new quyen_at(var301));
                     }

                     if (var297 != null && var297.length > 1) {
                        var293 = new UIFactory(var303, new quyen_au(var297));
                     }

                     if (var175 != null && var175.length > 1) {
                        var296 = new UIFactory(var300, new quyen_av(var175));
                     }
                  }

                  if (var148 == 29) {
                     GameManager.instance.a(var249, var290, var293, var296);
                  } else if (var148 == 60) {
                     GameManager.instance.a(var264, var287, var224, var285, GameManager.instance.l(), GameManager.instance.b("OK"), null);
                  } else if (var148 == 61) {
                     GameManager.instance.a(var264, var287, var224, var285, var290, var293, var296);
                  }
                  break;
               case 30:
                  int var157 = PacketUtils.readInt(var1);
                  int var263 = PacketUtils.readInt(var1);
                  boolean var278 = PacketUtils.readBoolean(var1);

                  try {
                     ((ListComponent) GameManager.instance.b(var157).findComponentByID(var263)).setMultiSelectMode(var278);
                  } catch (Exception var142) {
                  }
                  break;
               case 31:
                  int var156 = PacketUtils.readInt(var1);
                  int var174 = PacketUtils.readInt(var1);

                  try {
                     ((ListComponent) GameManager.instance.b(var156).findComponentByID(var174)).toggleSelectAll();
                  } catch (Exception var141) {
                  }
                  break;
               case 39:
                  a(PacketUtils.readBytes(var1));
                  break;
               case 47:
                  int var126 = PacketUtils.readInt(var1);
                  DialogScreen var127;
                  if ((var127 = (DialogScreen) GameManager.instance.b(var126)) != null) {
                     int var128 = var1 == null ? 1 : PacketUtils.readInt(var1);
                     int var129 = var1 == null ? 20 : PacketUtils.readInt(var1);
                     String var130 = UIUtils.concatStrings(" / ", Integer.toString(var129), null, null);
                     int var131 = FontRenderer.getTextWidth(" 99 ") + 6;
                     int var132 = Screen.screenWidth - FontRenderer.getTextWidth(UIUtils.concatStrings("<<   >>   ", var130, null, null)) - var131 >> 1;
                     TextLinkComponent var133 = new TextLinkComponent("<<", var132, Screen.screenHeight - GameManager.footerHeight - FontRenderer.fontHeight - 6, FontRenderer.fontHeight + 4);
                     TextLinkComponent var134 = new TextLinkComponent(">>", var133.posX + FontRenderer.getTextWidth("<<   "), var133.posY, FontRenderer.fontHeight + 4);
                     TextInputComponent var135;
                     (var135 = new TextInputComponent()).isReadOnly = true;
                     var135.setBounds(var134.posX + FontRenderer.getTextWidth(">>   "), var133.posY - 1, var131, FontRenderer.fontHeight + 3);
                     var135.setInputConstraint(1);
                     var135.setText(Integer.toString(var128));
                     TextComponent var136 = new TextComponent(var130, var135.posX + var135.width, var135.posY + 2, FontRenderer.fontHeight + 2);
                     if (var1 != null) {
                        var133.id = PacketUtils.readInt(var1);
                        byte[] var137 = PacketUtils.readBytes(var1);
                        var134.id = PacketUtils.readInt(var1);
                        byte[] var138 = PacketUtils.readBytes(var1);
                        var135.id = PacketUtils.readInt(var1);
                        byte[] var139 = PacketUtils.readBytes(var1);
                        var133.linkAction = new quyen_ao(var137);
                        var134.linkAction = new quyen_ap(var138);
                        var135.middleSoftKey = new UIFactory("Đến trang", new quyen_aq(var135, var129, var139));
                     }

                     var127.addComponent(var133);
                     var127.addComponent(var134);
                     var127.addComponent(var135);
                     var127.addComponent(var136);
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
                  byte var223 = var1.getPayload().readByte();
                  byte var248 = var1.getPayload().readByte();

                  for (int var201 = 0; var201 < var248; var201++) {
                     String var262 = PacketUtils.readString(var1);
                     byte[] var277 = PacketUtils.readBytes(var1);
                     byte var284 = (byte)var201;
                     UIFactory var286 = new UIFactory(var262, new quyen_ar(var284, var277));
                     b.addElement(var286);
                  }

                  if (c == null) {
                     c = new ContextMenu(b);
                  }

                  GameManager.instance.showContextMenu(c, var223);
                  break;
               case 49:
                  String var299 = a(var1);
                  PacketUtils.readLong(var1);
                  GameManager.instance.friendManager.sendFriendRequest(var299);
                  break;
               case 50:
                  int var66 = PacketUtils.readInt(var1);
                  DialogScreen var155;
                  (var155 = (DialogScreen) GameManager.instance.b(var66)).startSlideAnimation(1);
                  GameManager.instance.e(var155);
                  break;
               case 52:
                  GameManager.instance.c(true);
                  break;
               case 53:
                  GameManager.instance.c(false);
                  break;
               case 54:
                  int var187 = PacketUtils.readInt(var1);
                  GameManager.instance.destroyScreen(GameManager.instance.b(var187));
                  PhotoViewerScreen var200;
                  (var200 = new PhotoViewerScreen()).unused1 = var187;
                  var200.setTitle(PacketUtils.readString(var1));
                  var200.setCaption(PacketUtils.readString(var1));
                  var200.photoComponent.displayMode = PacketUtils.readInt(var1);
                  var200.setImageData(PacketUtils.readBytes(var1));
                  var200.photoComponent.id = PacketUtils.readInt(var1);
                  var200.showSaveButton(1);
                  var200.startSlideAnimation(1);
                  GameManager.instance.addScreenToStack(var200);
                  GameManager.instance.o();
                  break;
               case 56:
                  int var154 = PacketUtils.readInt(var1);
                  int var199 = PacketUtils.readInt(var1);

                  try {
                     Screen var261;
                     TextInputComponent var276 = (TextInputComponent)(var261 = GameManager.instance.b(var154)).findComponentByID(var199);
                     UIUtils.showTextInput(var261, var276);
                  } catch (Exception var143) {
                  }
                  break;
               case 57:
                  int var152 = PacketUtils.readInt(var1);
                  DialogScreen var153 = (DialogScreen) GameManager.instance.b(var152);
                  byte var173;
                  int[] var186;
                  (var186 = new int[var173 = var1.getPayload().readByte()])[0] = PacketUtils.readInt(var1);
                  UIComponent var197;
                  int var221 = (var197 = var153.findComponentByID(var186[0])).width;

                  for (int var246 = 1; var246 < var173; var246++) {
                     var186[var246] = PacketUtils.readInt(var1);
                     UIComponent var259;
                     (var259 = var153.findComponentByID(var186[var246])).posY = var197.posY;
                     var221 += var259.width;
                  }

                  var153.nextComponentY = var197.posY + var197.height + 2;
                  int var247 = (Screen.screenWidth - var221) / (var173 + 1);
                  var197.posX = Screen.screenWidth - (var221 + var247 * (var173 - 1)) >> 1;

                  for (int var260 = 1; var260 < var173; var260++) {
                     var197 = var153.findComponentByID(var186[var260]);
                     UIComponent var222 = var153.findComponentByID(var186[var260 - 1]);
                     var197.posX = var222.posX + var222.width + var247;
                  }

                  var153.updateLayout();
                  break;
               case 58:
                  DialogScreen var258 = (DialogScreen) GameManager.instance.b(PacketUtils.readInt(var1));
                  int var151 = PacketUtils.readInt(var1);
                  byte var172 = var1.getPayload().readByte();

                  for (int var185 = 0; var185 < var172; var185++) {
                     var258.findComponentByID(PacketUtils.readInt(var1)).posX = var151;
                  }
                  break;
               case 59:
                  DialogScreen var257;
                  UIComponent var220 = (var257 = (DialogScreen) GameManager.instance.b(PacketUtils.readInt(var1))).findComponentByID(PacketUtils.readInt(var1));
                  byte var171 = var1.getPayload().readByte();
                  UIComponent var196 = null;
                  int[] var184 = new int[var171];

                  for (int var150 = 0; var150 < var171; var150++) {
                     var184[var150] = PacketUtils.readInt(var1);
                     (var196 = var257.findComponentByID(var184[var150])).posX = var220.posX + var220.width + 6;
                     if (var150 == 0) {
                        var196.posY = var220.posY;
                     } else {
                        UIComponent var245 = var257.findComponentByID(var184[var150 - 1]);
                        var196.posY = var245.posY + var245.height + 2;
                     }
                  }

                  var257.nextComponentY = var196.posY + var196.height + 2;
                  var257.updateLayout();
                  break;
               case 62:
                  int var149 = PacketUtils.readInt(var1);
                  byte var2 = var1.getPayload().readByte();

                  try {
                     for (int var3 = 0; var3 < var2; var3++) {
                        int var4 = PacketUtils.readInt(var1);
                        int var5 = var1.getPayload().readByte();
                        Screen var6;
                        UIComponent var194 = (var6 = GameManager.instance.b(var149)).findComponentByID(var4);
                        switch (var5) {
                           case 0:
                              String var219 = PacketUtils.readString(var1);
                              String var244 = PacketUtils.readString(var1);
                              ((TextInputComponent)var194).textInputHandler.text = var219;
                              ((TextInputComponent)var194).setText(var244);
                              break;
                           case 1:
                              String var243 = PacketUtils.readString(var1);
                              ((TextComponent)var194).updateText(var243);
                              break;
                           case 4:
                              String var242 = PacketUtils.readString(var1);
                              byte[] var294 = PacketUtils.readBytes(var1);
                              ((TextLinkComponent)var194).linkText = var242;
                              ((TextLinkComponent)var194).setLinkAction(new quyen_ag(var294));
                              break;
                           case 7:
                              short var288 = PacketUtils.readShort(var1);
                              ((DropdownComponent)var194).setSelectedIndex(var288);
                              break;
                           case 11:
                              ListComponent var8;
                              DownloadDataManager var9 = (var8 = (ListComponent)var194).dataSource;
                              byte var10 = var1.getPayload().readByte();
                              var5 = 0;

                              for (; var5 < var10; var5++) {
                                 String var241 = PacketUtils.readString(var1);
                                 int var11 = PacketUtils.readInt(var1);
                                 byte[] var291 = PacketUtils.readBytes(var1);
                                 Integer var13 = null;
                                 Image var195 = null;
                                 if (var8.getIconType() == 2) {
                                    var13 = new Integer(var11);
                                 } else {
                                    var195 = UIUtils.createImageFromBytes(var291);
                                 }

                                 String var20 = PacketUtils.readString(var1);
                                 String var21 = PacketUtils.readString(var1);
                                 String var14 = PacketUtils.readString(var1);
                                 DownloadData var15 = var9.findDownload(null, var241, 0L);
                                 if (var11 != 0) {
                                    var15.priority = var13;
                                 }

                                 if (var291 != null && var291.length != 0) {
                                    var15.thumbnailImage = var195;
                                 }

                                 if (var20.length() > 0) {
                                    var15.displayName = var20;
                                 }

                                 if (var21.length() > 0) {
                                    var15.filePath = var21;
                                 }

                                 if (var14.length() > 0) {
                                    var15.description = var14;
                                 }
                              }

                              var8.buildListItems();
                              break;
                           case 14:
                              boolean var12 = PacketUtils.readBoolean(var1);
                              ((CheckboxComponent)var194).isChecked = var12;
                              break;
                           case 18:
                              PhotoViewerScreen var7;
                              (var7 = (PhotoViewerScreen)var6).setTitle(PacketUtils.readString(var1));
                              var7.setCaption(PacketUtils.readString(var1));
                              var7.photoComponent.displayMode = PacketUtils.readInt(var1);
                              var7.setImageData(PacketUtils.readBytes(var1));
                        }
                     }
                  } catch (Exception var147) {
                     var147.printStackTrace();
                  }
            }
         }
      }
   }

   private static int a(DialogScreen var0, UIComponent var1, Packet var2) {
      byte var4 = var2.getPayload().readByte();
      if (var4 == 0) {
         var1.posX = 6;
      } else if (var4 == 1) {
         var1.posX = Screen.screenWidth - var1.width >> 1;
      } else if (var4 == 2) {
         var1.posX = Screen.screenWidth - var1.width - 6;
      } else if (var4 == 3) {
         var1.posX = var0.dialogX;
      }

      return var4;
   }

   private static UIFactory b(Packet var0) {
      byte[] var1 = PacketUtils.readBytes(var0);
      return new UIFactory(a(var0), new quyen_as(var1));
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
      var0.fillRect(0, 0, GameGraphics.screenWidth, GameGraphics.screenHeight);
      if (GameGraphics.isDebugMode) {
         if (TextRenderer.logoCenterX > -125) {
            TextRenderer.logoCenterX = TextRenderer.logoCenterX - TextRenderer.centerX;
         }

         if (TextRenderer.centerY > -46) {
            TextRenderer.centerY = TextRenderer.centerY - TextRenderer.centerX;
         }

         if (TextRenderer.logoCenterX < -70) {
            g = true;
         }

         TextRenderer.centerX++;
      }

      var0.drawImage(TextRenderer.getLogoImage(), TextRenderer.logoCenterX, (GameGraphics.screenHeight >> 1) - 15, 3);
      GameManager.instance.drawLoading(var0, TextRenderer.logoCenterX, (GameGraphics.screenHeight + TextRenderer.CHAR_SPACING >> 1) + 3);
      GameManager.instance.f++;
   }

   public static void b() {
      GameGraphics.screenWidth = GameGraphics.instance.getWidth();
      GameGraphics.screenHeight = GameGraphics.instance.getHeight();
      if (a == 35) {
         GameManager.getInstance().a(GameGraphics.screenWidth, GameGraphics.screenHeight);
      }

      if (GameGraphics.isDebugMode && g) {
         TextRenderer.logoCenterX = GameGraphics.screenWidth >> 1;
         TextRenderer.centerY = GameGraphics.screenHeight >> 1;
         System.gc();
         GameGraphics.gameState = 1;
      }

      a++;
   }
}
