package home.thienph.xyahoo107.processors;

import home.thienph.xyahoo107.actions.*;
import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.components.*;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.data.game.ContextMenu;
import home.thienph.xyahoo107.data.media.BuddyContact;
import home.thienph.xyahoo107.data.packet.ByteBuffer;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.data.media.BuddyListManager;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;
import home.thienph.xyahoo107.screens.DialogScreen;
import home.thienph.xyahoo107.screens.PhotoViewerScreen;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.PacketUtils;
import home.thienph.xyahoo107.utils.TextRenderer;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import java.io.DataInputStream;
import java.util.Vector;

public class GameProcessor {
    private static Vector contextMenuItems;
    private static ContextMenu contextMenu;
    private static byte dialogType;
    private static int[] imageOffsets;
    private static DataInputStream imageDataStream;
    public static int splashCounter;
    private static boolean splashCompleted;

    public static void processMessage(byte[] payload) {
        if (payload != null && payload.length >= 2) {
            Packet packet = new Packet(0, 0);
            packet.setPayload(new ByteBuffer(payload));
            while (true) {
                int commandId = PacketUtils.readInt(packet);
                System.out.println("[MessageProcessor.processMessage] commandId = " + commandId + ", length = " + packet.getPayload().getRemaining());
                switch (commandId) {
                    case 0:
                        int var170 = PacketUtils.readInt(packet);
                        GameManager.instance.destroyScreen(GameManager.instance.findScreenById(var170));
                        break;
                    case 1:
                        boolean var217 = PacketUtils.readBoolean(packet);
                        String var169 = PacketUtils.readString(packet);
                        GameManager.instance.showInfoDialog(var169).setLoadingVisible(var217);
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
                        int var167 = PacketUtils.readInt(packet);
                        Packet var183 = new Packet(0, 0);
                        PacketUtils.writeInt(var167, var183);
                        int var168 = PacketUtils.readInt(packet);
                        int var193 = 0;

                        for (; var193 < var168; var193++) {
                            byte var212 = packet.getPayload().readByte();
                            int var232 = packet.getPayload().readByte();
                            if (var212 == 0) {
                                if (var232 == 0) {
                                    PacketUtils.writeInt(PacketUtils.readInt(packet), var183);
                                } else if (var232 == 1) {
                                    var232 = PacketUtils.readInt(packet);
                                    Screen var256 = GameManager.instance.findScreenById(var232);
                                    int var274 = PacketUtils.readInt(packet);
                                    boolean var216 = PacketUtils.readBoolean(packet);
                                    var232 = 0;
                                    UIComponent var275;
                                    if ((var275 = var256.findComponentByID(var274)) != null) {
                                        if (var275 instanceof TextInputComponent) {
                                            String var283 = ((TextInputComponent) var275).getText();
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
                                            var232 = ((DropdownComponent) var275).getSelectedIndex();
                                        } else if (var275 instanceof GridComponent) {
                                            var232 = ((GridComponent) var275).getSelectedItemId();
                                        } else if (var275 instanceof PhotoViewComponent) {
                                            var232 = ((PhotoViewComponent) var275).displayMode;
                                        }
                                    }

                                    PacketUtils.writeInt(var232, var183);
                                }
                            } else if (var212 == 1) {
                                if (var232 == 0) {
                                    PacketUtils.writeString(PacketUtils.readString(packet), var183);
                                } else if (var232 == 1) {
                                    var232 = PacketUtils.readInt(packet);
                                    Screen var255 = GameManager.instance.findScreenById(var232);
                                    int var272 = PacketUtils.readInt(packet);
                                    boolean var215 = PacketUtils.readBoolean(packet);
                                    UIComponent var238 = var255.findComponentByID(var272);
                                    String var273 = "";
                                    if (var238 instanceof TextInputComponent) {
                                        var273 = ((TextInputComponent) var238).getText();
                                        if (var215 && var273.equals("")) {
                                            UIUtils.focusComponent(var255, var238);
                                            return;
                                        }
                                    } else if (var238 instanceof DropdownComponent) {
                                        var273 = ((DropdownComponent) var238).getSelectedText();
                                    } else if (var238 instanceof ListComponent) {
                                        ListComponent var282;
                                        var273 = (var282 = (ListComponent) var238).getSelectedItem().j;
                                    }

                                    PacketUtils.writeString(var273, var183);
                                }
                            } else if (var212 == 2) {
                                if (var232 == 0) {
                                    PacketUtils.writeBoolean(PacketUtils.readBoolean(packet), var183);
                                } else if (var232 == 1) {
                                    var232 = PacketUtils.readInt(packet);
                                    Screen var254 = GameManager.instance.findScreenById(var232);
                                    int var271 = PacketUtils.readInt(packet);
                                    UIComponent var214;
                                    if ((var214 = var254.findComponentByID(var271)) instanceof CheckboxComponent) {
                                        boolean var236 = ((CheckboxComponent) var214).isChecked;
                                        PacketUtils.writeBoolean(((CheckboxComponent) var214).isChecked, var183);
                                    }
                                }
                            } else if (var212 == 3 && var232 == 1) {
                                var232 = PacketUtils.readInt(packet);
                                Screen var253 = GameManager.instance.findScreenById(var232);
                                int var269 = PacketUtils.readInt(packet);
                                UIComponent var213;
                                if ((var213 = var253.findComponentByID(var269)) instanceof ListComponent) {
                                    String[] var234;
                                    if ((var234 = ((ListComponent) var213).getSelectedItemIds()) != null) {
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

                        PacketUtils.writeByte(dialogType, var183);
                        PacketSender.a(var183.getPayload().getBuffer());
                        break;
                    case 4:
                        DialogScreen dialogScreen = new DialogScreen();
                        dialogScreen.showInNavigation = true;
                        dialogScreen.title = PacketUtils.readString(packet);
                        int dialogId = PacketUtils.readInt(packet);
                        dialogScreen.dialogId = dialogId;
                        GameManager.instance.destroyScreen(GameManager.instance.findScreenById(dialogId));
                        dialogScreen.startSlideAnimation(1);
                        boolean isSwitchLastScreen = PacketUtils.readBoolean(packet);
                        GameManager.instance.addScreenToStack((Screen) dialogScreen);
                        if (isSwitchLastScreen) {
                            GameManager.instance.switchToLastScreen();
                        }
                        if (dialogId == 11111) {
                            GameManager.instance.setupMainMenu(dialogScreen);
                        }
                        break;
                    case 5:
                        int var192 = PacketUtils.readInt(packet);
                        Screen var211 = GameManager.instance.findScreenById(var192);
                        switch (packet.getPayload().readByte()) {
                            case 0:
                                ButtonAction var231 = createUIFactory(packet);
                                if (GameManager.isValidErrorCode(var192)) {
                                    Vector var252;
                                    (var252 = new Vector()).addElement(new ButtonAction("Biểu cảm", new quyen_ax()));
                                    var252.addElement(var231);
                                    ContextMenu var268 = new ContextMenu(var252);
                                    var211.leftSoftkey = new ButtonAction("Menu", new quyen_ay(var268));
                                } else {
                                    var211.leftSoftkey = var231;
                                }
                                break;
                            case 1:
                                var211.centerSoftkey = createUIFactory(packet);
                                break;
                            case 2:
                                var211.rightSoftkey = createUIFactory(packet);
                        }

                        var211.needsUpdate = true;
                        break;
                    case 6:
                        int var165 = PacketUtils.readInt(packet);
                        DialogScreen var166 = (DialogScreen) GameManager.instance.findScreenById(var165);
                        byte var251 = packet.getPayload().readByte();
                        Object var180 = null;
                        switch (var251) {
                            case 0:
                                String var305 = PacketUtils.readString(packet);
                                int var307 = PacketUtils.readInt(packet);
                                int var308 = PacketUtils.readInt(packet);
                                TextInputComponent var309;
                                var180 = var309 = ButtonAction.createLabeledTextInput(var166, var305, var307, var308);
                                setComponentAlignment(var166, (UIComponent) var180, packet);
                                var309.textInputHandler.posX = var309.posX;
                                break;
                            case 1:
                                String var310 = PacketUtils.readString(packet);
                                int var70 = PacketUtils.readInt(packet);
                                if (var310.equals("")) {
                                    TextComponent var311;
                                    (var311 = ButtonAction.createSpacer(var166, var70)).textColor = new Integer(UIUtils.validateColor(PacketUtils.readInt(packet)));
                                    var311.isVisible = !var310.trim().equals("");
                                    var180 = var311;
                                    packet.getPayload().readByte();
                                } else {
                                    var180 = ButtonAction.createWrappedText(var310, var166, var70, UIUtils.validateColor(PacketUtils.readInt(packet)), true, true)[0];
                                    setComponentAlignment(var166, (UIComponent) var180, packet);
                                }
                                break;
                            case 2:
                            case 3:
                            case 9:
                            case 10:
                            default:
                                break;
                            case 4:
                                String var312 = PacketUtils.readString(packet);
                                int var73 = PacketUtils.readInt(packet);
                                int var74 = UIUtils.validateColor(PacketUtils.readInt(packet));
                                byte[] var75 = PacketUtils.readBytes(packet);
                                TextLinkComponent var76;
                                (var76 = ButtonAction.createCustomButton(var166, var312, var73, new quyen_ah(var75), var166.dialogX, var166.nextComponentY, var166.dialogWidth)).textColor = new Integer(var74);
                                var180 = var76;
                                setComponentAlignment(var166, var76, packet);
                                break;
                            case 5:
                                String var80 = PacketUtils.readString(packet);
                                PacketUtils.readInt(packet);
                                var180 = ButtonAction.createSimpleText(var166, var80)[0];
                                break;
                            case 6:
                            case 12:
                                Image var82 = null;
                                int var83 = -1;
                                int var313 = 0;
                                int var314 = 0;
                                if (var251 == 12) {
                                    byte[] var315;
                                    var313 = (var82 = Image.createImage(var315 = PacketUtils.readBytes(packet), 0, var315.length)).getWidth();
                                    var314 = var82.getHeight();
                                } else if (var251 == 6) {
                                    var83 = PacketUtils.readInt(packet);
                                    var313 = PacketUtils.readInt(packet);
                                    var314 = PacketUtils.readInt(packet);
                                }

                                boolean var316 = PacketUtils.readBoolean(packet);
                                boolean var317 = PacketUtils.readBoolean(packet);
                                String var318 = PacketUtils.readString(packet);
                                byte[] var89 = PacketUtils.readBytes(packet);
                                ImageComponent var90 = ButtonAction.createImageComponent(var166, var83, var82, var313, var314, var316, var317);
                                if (var89 != null && var89.length > 1) {
                                    var90.setClickAction(var318, new quyen_aj(var89));
                                }

                                var180 = var90;
                                setComponentAlignment(var166, var90, packet);
                                break;
                            case 7:
                                String var118 = PacketUtils.readString(packet);
                                int var119 = PacketUtils.readInt(packet);
                                int var120;
                                String[] var121 = new String[var120 = PacketUtils.readInt(packet)];

                                for (int var122 = 0; var122 < var120; var122++) {
                                    var121[var122] = PacketUtils.readString(packet);
                                }

                                byte[] var328 = PacketUtils.readBytes(packet);
                                DropdownComponent var123 = ButtonAction.createChoiceBoxWithID(var166, var118, var121, var119);
                                if (var328 != null && var328.length > 1) {
                                    var123.setChangeAction(new quyen_an(var328));
                                }

                                int var124 = PacketUtils.readInt(packet);
                                var180 = var123;
                                setComponentAlignment(var166, var123, packet);
                                var123.textInputHandler.posX = var123.posX;
                                var123.setSelectedIndex(var124);
                                break;
                            case 8:
                                byte var91;
                                int[] var92 = new int[var91 = packet.getPayload().readByte()];

                                for (int var93 = 0; var93 < var91; var93++) {
                                    var92[var93] = PacketUtils.readInt(packet);
                                }

                                int var84 = PacketUtils.readInt(packet);
                                int var85 = PacketUtils.readInt(packet);
                                boolean var86 = PacketUtils.readBoolean(packet);
                                boolean var87 = PacketUtils.readBoolean(packet);
                                String var88 = PacketUtils.readString(packet);
                                byte[] var319 = PacketUtils.readBytes(packet);
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
                                setComponentAlignment(var166, var335, packet);
                                break;
                            case 11:
                                boolean var94 = PacketUtils.readBoolean(packet);
                                byte var95 = packet.getPayload().readByte();
                                byte var96 = packet.getPayload().readByte();
                                int var97 = -1;
                                int var98 = -1;
                                if (var96 == 2) {
                                    var97 = PacketUtils.readInt(packet);
                                    var98 = PacketUtils.readInt(packet);
                                }

                                byte var99 = packet.getPayload().readByte();
                                int var100 = PacketUtils.readInt(packet);
                                BuddyListManager var101 = new BuddyListManager();
                                BuddyContact[] var102 = new BuddyContact[var100];
                                String[] var103 = new String[var100];

                                for (int var104 = 0; var104 < var100; var104++) {
                                    var103[var104] = PacketUtils.readString(packet);
                                    String var105 = PacketUtils.readString(packet);
                                    String var321 = PacketUtils.readString(packet);
                                    String var322 = null;
                                    if (var95 == 1) {
                                        var322 = PacketUtils.readString(packet);
                                    }

                                    Integer var323 = null;
                                    Image var324 = null;
                                    if (var96 == 2) {
                                        var323 = new Integer(PacketUtils.readInt(packet));
                                    } else if (var96 == 3) {
                                        var324 = UIUtils.createImageFromBytes(PacketUtils.readBytes(packet));
                                        if (var97 == -1) {
                                            var97 = var324.getWidth();
                                            var98 = var324.getHeight();
                                        }
                                    }

                                    byte var325 = 0;
                                    if (var99 == 1) {
                                        if ((var325 = packet.getPayload().readByte()) == 0) {
                                            var325 = 2;
                                        } else if (var325 == 1) {
                                            var325 = 3;
                                        } else {
                                            var325 = 4;
                                        }
                                    }

                                    String var327;
                                    if ((var327 = PacketUtils.readString(packet)) != null && var327.length() == 0) {
                                        var327 = null;
                                    }

                                    var102[var104] = new BuddyContact("", var321, var325, var322, null, -1, var104, var327);
                                    var102[var104].fileName = var105;
                                    var102[var104].priority = var323;
                                    var102[var104].thumbnailImage = var324;
                                    var101.addContactToGroup(var103[var104], var102[var104]);
                                }

                                byte[] var320 = PacketUtils.readBytes(packet);
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
                                int var106 = PacketUtils.readInt(packet);
                                int var107 = PacketUtils.readInt(packet);
                                int var108 = PacketUtils.readInt(packet);
                                boolean var109 = PacketUtils.readBoolean(packet);
                                int[] var110 = new int[var106];
                                Integer[] var111 = new Integer[var106];
                                String[] var112 = new String[var106];
                                boolean[] var113 = null;
                                if (var109) {
                                    var113 = new boolean[var106];
                                }

                                for (int var114 = 0; var114 < var106; var114++) {
                                    var112[var114] = PacketUtils.readString(packet);
                                    var110[var114] = PacketUtils.readInt(packet);
                                    var111[var114] = new Integer(PacketUtils.readInt(packet));
                                    if (var109) {
                                        var113[var114] = PacketUtils.readBoolean(packet);
                                    }
                                }

                                GridComponent var336 = new GridComponent(0, 0, Screen.screenWidth, Screen.screenHeight - GameManager.footerHeight, var106, var112, var110, var111, var107, var108, false, 2);
                                var166.addComponent(var336);
                                UIUtils.focusComponent(var166, var336);
                                byte[] var116 = PacketUtils.readBytes(packet);
                                ButtonAction var329 = new ButtonAction("Chọn", new quyen_am(var109, var336, var113, var116));
                                var336.middleSoftKey = var329;
                                var180 = var336;
                                var166.isScrollLocked = true;
                                break;
                            case 14:
                                String var190 = PacketUtils.readString(packet);
                                boolean var182 = PacketUtils.readBoolean(packet);
                                var180 = ButtonAction.createCheckbox(var166, var190, var182);
                                setComponentAlignment(var166, (UIComponent) var180, packet);
                                break;
                            case 15:
                                String var69;
                                TextComponent var71;
                                (var71 = ButtonAction.createLabel(var69 = PacketUtils.readString(packet), var166, -1)).textColor = new Integer(UIUtils.validateColor(PacketUtils.readInt(packet)));
                                var71.isVisible = !var69.trim().equals("");
                                var71.enableScrolling = true;
                                var180 = var71;
                                setComponentAlignment(var166, var71, packet);
                                break;
                            case 16:
                                String var189 = PacketUtils.readString(packet);
                                byte var181 = packet.getPayload().readByte();
                                byte[] var304 = PacketUtils.readBytes(packet);
                                var180 = ButtonAction.createPopupDialog(var166, var189, var181, new quyen_az(var304));
                                break;
                            case 17:
                                String var72 = PacketUtils.readString(packet);
                                int var77 = PacketUtils.readInt(packet);
                                byte[] var78 = PacketUtils.readBytes(packet);
                                var180 = ButtonAction.createButton(var166, var72, new quyen_ai(var78), var166.nextComponentY, var77);
                                setComponentAlignment(var166, (UIComponent) var180, packet);
                        }

                        int var191 = PacketUtils.readInt(packet);
                        ((UIComponent) var180).id = var191;
                        if (((UIComponent) var180).id > 1000 && var180 instanceof TextInputComponent) {
                            ((TextInputComponent) var180).useNativeInput = true;
                        }
                        break;
                    case 7:
                        int var178 = PacketUtils.readInt(packet);
                        Screen var179 = GameManager.instance.findScreenById(var178);
                        int var64 = PacketUtils.readInt(packet);
                        UIComponent var65 = var179.findComponentByID(var64);
                        UIUtils.focusComponent(var179, var65);
                        if (var179.equals(GameManager.instance.getCurrentScreen())) {
                            var179.focusFirstComponent();
                        }
                        break;
                    case 8:
                        System.gc();
                        return;
                    case 12:
                        int var164 = PacketUtils.readInt(packet);
                        DialogScreen var230 = (DialogScreen) GameManager.instance.findScreenById(var164);
                        int var250;
                        String[] var267 = new String[var250 = PacketUtils.readInt(packet)];

                        for (int var210 = 0; var210 < var250; var210++) {
                            var267[var210] = PacketUtils.readString(packet);
                        }

                        var230.createMenuItems(var267);
                        break;
                    case 13:
                        int var306 = PacketUtils.readInt(packet);
                        DialogScreen var67 = (DialogScreen) GameManager.instance.findScreenById(var306);
                        int var68 = PacketUtils.readInt(packet);
                        var67.expandMenu(var68);
                        break;
                    case 14:
                        byte var160 = packet.getPayload().readByte();
                        String var177 = "";
                        if (var160 == 0) {
                            var177 = PacketUtils.readString(packet);
                        } else {
                            int var161 = PacketUtils.readInt(packet);
                            Screen var188 = GameManager.instance.findScreenById(var161);
                            int var207 = PacketUtils.readInt(packet);
                            boolean var162 = PacketUtils.readBoolean(packet);
                            UIComponent var208;
                            if ((var208 = var188.findComponentByID(var207)) instanceof TextInputComponent) {
                                var177 = ((TextInputComponent) var208).getText();
                                if (var162 && var177.equals("")) {
                                    UIUtils.focusComponent(var188, var208);
                                    return;
                                }
                            }
                        }

                        String var163 = PacketUtils.readString(packet);
                        String var209 = UIUtils.concatStrings("Gửi tin: ", var177, Xuka.refCode, "\nĐến số: ");
                        GameManager.instance.showConfirmDialog(UIUtils.concatStrings(var209, var163.substring(6), null, null), new quyen_aw(var177, var163));
                        break;
                    case 15:
                        try {
                            Xuka.instance.platformRequest(PacketUtils.readString(packet));
                        } catch (ConnectionNotFoundException var146) {
                        }
                        break;
                    case 16:
                    case 17:
                        DialogScreen var266;
                        UIComponent var206 = (var266 = (DialogScreen) GameManager.instance.findScreenById(PacketUtils.readInt(packet))).findComponentByID(PacketUtils.readInt(packet));
                        UIComponent var228 = null;
                        if (commandId == 16) {
                            var206.posX = PacketUtils.readInt(packet);
                        } else {
                            var228 = var266.findComponentByID(PacketUtils.readInt(packet));
                            if (commandId == 17) {
                                var206.posX = var228.posX + var228.width + 6;
                            }
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                        DialogScreen var265;
                        UIComponent var205 = (var265 = (DialogScreen) GameManager.instance.findScreenById(PacketUtils.readInt(packet))).findComponentByID(PacketUtils.readInt(packet));
                        UIComponent var226 = null;
                        if (commandId == 18) {
                            var205.posY = PacketUtils.readInt(packet);
                            var265.nextComponentY = var205.posY + var205.height + 2;
                        } else {
                            var226 = var265.findComponentByID(PacketUtils.readInt(packet));
                            if (commandId == 19) {
                                var205.posY = var226.posY + var226.height + 2;
                            } else if (commandId == 20) {
                                var205.posY = var226.posY;
                            }
                        }

                        var265.nextComponentY = var205.posY + var205.height + 2;
                        var265.updateLayout();
                        break;
                    case 21:
                        String var176 = PacketUtils.readString(packet);
                        Packet var159 = new Packet(0, 0);
                        PacketUtils.writeInt(0, var159);
                        PacketUtils.writeString(var176, var159);
                        PacketSender.a(var159.getPayload().getBuffer());
                        break;
                    case 22:
                        GameManager.instance.destroyScreen(GameManager.instance.setActiveScreen(PacketUtils.readString(packet)));
                        break;
                    case 23:
                        GameManager.instance.closeDialog();
                        break;
                    case 24:
                        int var158 = PacketUtils.readInt(packet);
                        int var204 = PacketUtils.readInt(packet);
                        String var225 = PacketUtils.readString(packet);

                        try {
                            ((TextInputComponent) GameManager.instance.findScreenById(var158).findComponentByID(var204)).setText(var225);
                        } catch (Exception var144) {
                        }
                        break;
                    case 26:
                        String var203 = PacketUtils.readString(packet);
                        long var302 = PacketUtils.readLong(packet);
                        ChatScreen var298;
                        (var298 = GameManager.getInstance().getOrCreateChatScreen(var203)).setChatId(var302);
                        GameManager.getInstance().switchToScreenByTitle(var298.title);
                        break;
                    case 28:
                        GameManager.instance.showWrappedTextDialog(PacketUtils.readString(packet));
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
                        if (commandId == 29) {
                            var249 = PacketUtils.readString(packet);
                        } else if (commandId == 60 || commandId == 61) {
                            var264 = PacketUtils.readString(packet);
                            var279 = packet.getPayload().readByte();
                            var285 = packet.getPayload().readByte();
                            var287 = packet.getPayload().readByte();
                            var224 = new Vector();

                            for (int var289 = 0; var289 < var279; var289++) {
                                String[] var292 = new String[var285];

                                for (int var295 = 0; var295 < var285; var295++) {
                                    var292[var295] = PacketUtils.readString(packet);
                                }

                                var224.addElement(var292);
                            }

                            if (var264 != null && var264.length() == 0) {
                                var264 = null;
                            }
                        }

                        ButtonAction var290 = null;
                        ButtonAction var293 = null;
                        ButtonAction var296 = null;
                        if (commandId == 29 || commandId == 61) {
                            String var202 = PacketUtils.readString(packet);
                            byte[] var301 = PacketUtils.readBytes(packet);
                            String var303 = PacketUtils.readString(packet);
                            byte[] var297 = PacketUtils.readBytes(packet);
                            String var300 = PacketUtils.readString(packet);
                            byte[] var175 = PacketUtils.readBytes(packet);
                            if (var301 != null && var301.length > 1) {
                                var290 = new ButtonAction(var202, new quyen_at(var301));
                            }

                            if (var297 != null && var297.length > 1) {
                                var293 = new ButtonAction(var303, new quyen_au(var297));
                            }

                            if (var175 != null && var175.length > 1) {
                                var296 = new ButtonAction(var300, new quyen_av(var175));
                            }
                        }

                        if (commandId == 29) {
                            GameManager.instance.createSimpleDialog(var249, var290, var293, var296);
                        } else if (commandId == 60) {
                            GameManager.instance.createDialog(var264, var287, var224, var285, GameManager.instance.getSelectButton(), GameManager.instance.createBackButton("OK"), null);
                        } else if (commandId == 61) {
                            GameManager.instance.createDialog(var264, var287, var224, var285, var290, var293, var296);
                        }
                        break;
                    case 30:
                        int var157 = PacketUtils.readInt(packet);
                        int var263 = PacketUtils.readInt(packet);
                        boolean var278 = PacketUtils.readBoolean(packet);

                        try {
                            ((ListComponent) GameManager.instance.findScreenById(var157).findComponentByID(var263)).setMultiSelectMode(var278);
                        } catch (Exception var142) {
                        }
                        break;
                    case 31:
                        int var156 = PacketUtils.readInt(packet);
                        int var174 = PacketUtils.readInt(packet);

                        try {
                            ((ListComponent) GameManager.instance.findScreenById(var156).findComponentByID(var174)).toggleSelectAll();
                        } catch (Exception var141) {
                        }
                        break;
                    case 39:
                        processMessage(PacketUtils.readBytes(packet));
                        break;
                    case 47:
                        int var126 = PacketUtils.readInt(packet);
                        DialogScreen var127;
                        if ((var127 = (DialogScreen) GameManager.instance.findScreenById(var126)) != null) {
                            int var128 = packet == null ? 1 : PacketUtils.readInt(packet);
                            int var129 = packet == null ? 20 : PacketUtils.readInt(packet);
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
                            if (packet != null) {
                                var133.id = PacketUtils.readInt(packet);
                                byte[] var137 = PacketUtils.readBytes(packet);
                                var134.id = PacketUtils.readInt(packet);
                                byte[] var138 = PacketUtils.readBytes(packet);
                                var135.id = PacketUtils.readInt(packet);
                                byte[] var139 = PacketUtils.readBytes(packet);
                                var133.linkAction = new quyen_ao(var137);
                                var134.linkAction = new quyen_ap(var138);
                                var135.middleSoftKey = new ButtonAction("Đến trang", new quyen_aq(var135, var129, var139));
                            }

                            var127.addComponent(var133);
                            var127.addComponent(var134);
                            var127.addComponent(var135);
                            var127.addComponent(var136);
                            System.gc();
                        }
                        break;
                    case 48:
                        if (contextMenuItems == null) {
                            contextMenuItems = new Vector();
                        } else {
                            contextMenuItems.removeAllElements();
                        }

                        System.gc();
                        byte var223 = packet.getPayload().readByte();
                        byte var248 = packet.getPayload().readByte();

                        for (int var201 = 0; var201 < var248; var201++) {
                            String var262 = PacketUtils.readString(packet);
                            byte[] var277 = PacketUtils.readBytes(packet);
                            byte var284 = (byte) var201;
                            ButtonAction var286 = new ButtonAction(var262, new quyen_ar(var284, var277));
                            contextMenuItems.addElement(var286);
                        }

                        if (contextMenu == null) {
                            contextMenu = new ContextMenu(contextMenuItems);
                        }

                        GameManager.instance.showContextMenu(contextMenu, var223);
                        break;
                    case 49:
                        String var299 = PacketUtils.readString(packet);
                        PacketUtils.readLong(packet);
                        GameManager.instance.friendManager.sendFriendRequest(var299);
                        break;
                    case 50:
                        int var66 = PacketUtils.readInt(packet);
                        DialogScreen var155;
                        (var155 = (DialogScreen) GameManager.instance.findScreenById(var66)).startSlideAnimation(1);
                        GameManager.instance.switchToScreen(var155);
                        break;
                    case 52:
                        GameManager.instance.setLoadingState(true);
                        break;
                    case 53:
                        GameManager.instance.setLoadingState(false);
                        break;
                    case 54:
                        int var187 = PacketUtils.readInt(packet);
                        GameManager.instance.destroyScreen(GameManager.instance.findScreenById(var187));
                        PhotoViewerScreen var200;
                        (var200 = new PhotoViewerScreen()).dialogId = var187;
                        var200.setTitle(PacketUtils.readString(packet));
                        var200.setCaption(PacketUtils.readString(packet));
                        var200.photoComponent.displayMode = PacketUtils.readInt(packet);
                        var200.setImageData(PacketUtils.readBytes(packet));
                        var200.photoComponent.id = PacketUtils.readInt(packet);
                        var200.showSaveButton(1);
                        var200.startSlideAnimation(1);
                        GameManager.instance.addScreenToStack(var200);
                        GameManager.instance.switchToLastScreen();
                        break;
                    case 56:
                        int var154 = PacketUtils.readInt(packet);
                        int var199 = PacketUtils.readInt(packet);

                        try {
                            Screen var261;
                            TextInputComponent var276 = (TextInputComponent) (var261 = GameManager.instance.findScreenById(var154)).findComponentByID(var199);
                            UIUtils.showTextInput(var261, var276);
                        } catch (Exception var143) {
                        }
                        break;
                    case 57:
                        int var152 = PacketUtils.readInt(packet);
                        DialogScreen var153 = (DialogScreen) GameManager.instance.findScreenById(var152);
                        byte var173;
                        int[] var186;
                        (var186 = new int[var173 = packet.getPayload().readByte()])[0] = PacketUtils.readInt(packet);
                        UIComponent var197;
                        int var221 = (var197 = var153.findComponentByID(var186[0])).width;

                        for (int var246 = 1; var246 < var173; var246++) {
                            var186[var246] = PacketUtils.readInt(packet);
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
                        DialogScreen var258 = (DialogScreen) GameManager.instance.findScreenById(PacketUtils.readInt(packet));
                        int var151 = PacketUtils.readInt(packet);
                        byte var172 = packet.getPayload().readByte();

                        for (int var185 = 0; var185 < var172; var185++) {
                            var258.findComponentByID(PacketUtils.readInt(packet)).posX = var151;
                        }
                        break;
                    case 59:
                        DialogScreen var257;
                        UIComponent var220 = (var257 = (DialogScreen) GameManager.instance.findScreenById(PacketUtils.readInt(packet))).findComponentByID(PacketUtils.readInt(packet));
                        byte var171 = packet.getPayload().readByte();
                        UIComponent var196 = null;
                        int[] var184 = new int[var171];

                        for (int var150 = 0; var150 < var171; var150++) {
                            var184[var150] = PacketUtils.readInt(packet);
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
                        int var149 = PacketUtils.readInt(packet);
                        byte var2 = packet.getPayload().readByte();

                        try {
                            for (int var3 = 0; var3 < var2; var3++) {
                                int var4 = PacketUtils.readInt(packet);
                                int var5 = packet.getPayload().readByte();
                                Screen var6;
                                UIComponent var194 = (var6 = GameManager.instance.findScreenById(var149)).findComponentByID(var4);
                                switch (var5) {
                                    case 0:
                                        String var219 = PacketUtils.readString(packet);
                                        String var244 = PacketUtils.readString(packet);
                                        ((TextInputComponent) var194).textInputHandler.text = var219;
                                        ((TextInputComponent) var194).setText(var244);
                                        break;
                                    case 1:
                                        String var243 = PacketUtils.readString(packet);
                                        ((TextComponent) var194).updateText(var243);
                                        break;
                                    case 4:
                                        String var242 = PacketUtils.readString(packet);
                                        byte[] var294 = PacketUtils.readBytes(packet);
                                        ((TextLinkComponent) var194).linkText = var242;
                                        ((TextLinkComponent) var194).setLinkAction(new quyen_ag(var294));
                                        break;
                                    case 7:
                                        short var288 = PacketUtils.readShort(packet);
                                        ((DropdownComponent) var194).setSelectedIndex(var288);
                                        break;
                                    case 11:
                                        ListComponent var8;
                                        BuddyListManager var9 = (var8 = (ListComponent) var194).dataSource;
                                        byte var10 = packet.getPayload().readByte();
                                        var5 = 0;

                                        for (; var5 < var10; var5++) {
                                            String var241 = PacketUtils.readString(packet);
                                            int var11 = PacketUtils.readInt(packet);
                                            byte[] var291 = PacketUtils.readBytes(packet);
                                            Integer var13 = null;
                                            Image var195 = null;
                                            if (var8.getIconType() == 2) {
                                                var13 = new Integer(var11);
                                            } else {
                                                var195 = UIUtils.createImageFromBytes(var291);
                                            }

                                            String var20 = PacketUtils.readString(packet);
                                            String var21 = PacketUtils.readString(packet);
                                            String var14 = PacketUtils.readString(packet);
                                            BuddyContact var15 = var9.findDownloadFile(null, var241, 0L);
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
                                                var15.downloadText = var21;
                                            }

                                            if (var14.length() > 0) {
                                                var15.description = var14;
                                            }
                                        }

                                        var8.buildListItems();
                                        break;
                                    case 14:
                                        boolean var12 = PacketUtils.readBoolean(packet);
                                        ((CheckboxComponent) var194).isChecked = var12;
                                        break;
                                    case 18:
                                        PhotoViewerScreen var7;
                                        (var7 = (PhotoViewerScreen) var6).setTitle(PacketUtils.readString(packet));
                                        var7.setCaption(PacketUtils.readString(packet));
                                        var7.photoComponent.displayMode = PacketUtils.readInt(packet);
                                        var7.setImageData(PacketUtils.readBytes(packet));
                                }
                            }
                        } catch (Exception var147) {
                            var147.printStackTrace();
                        }
                }
            }
        }
    }

    private static int setComponentAlignment(DialogScreen var0, UIComponent var1, Packet var2) {
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

    private static ButtonAction createUIFactory(Packet var0) {
        byte[] var1 = PacketUtils.readBytes(var0);
        return new ButtonAction(PacketUtils.readString(var0), new quyen_as(var1));
    }

    static void setDialogType(byte var0) {
        dialogType = var0;
    }

    public static void loadImageData(int dataImageId) {
        try {
            String fileName = null;
            byte[] var2 = new byte[1];
            if (dataImageId == 0) {
                fileName = "/Data0.tak";
            } else if (dataImageId == 1) {
                fileName = "/Data1.tak";
            } else if (dataImageId == 2) {
                fileName = "/Data2.tak";
            }

            imageDataStream = new DataInputStream(var2.getClass().getResourceAsStream(fileName));
            dataImageId = imageDataStream.readInt();
            imageOffsets = new int[dataImageId];

            int var8 = (dataImageId << 2) + 4;
            for (int i = 0; i < dataImageId; i++) {
                int var7 = imageDataStream.readInt();
                imageOffsets[i] = var7 + var8;
            }
        } catch (Exception var4) {
            System.out.println("[MessageProcessor.loadImageData] error: " + var4);
            var4.printStackTrace();
        }
    }

    public static byte[] getImageBytes(int id) {
        byte[] byteData = new byte[1];
        try {
            byteData = new byte[imageOffsets[id + 1] - imageOffsets[id]];
            imageDataStream.read(byteData);
        } catch (Exception ex) {
            System.out.println("[MessageProcessor.getImageBytes] imgex1 error: " + ex);
            ex.printStackTrace();
        }
        return byteData;
    }

    public static void cleanup() {
        imageOffsets = null;

        try {
            imageDataStream.close();
        } catch (Exception var1) {
            System.out.println("imgex2 " + var1);
        }

        imageDataStream = null;
        System.gc();
    }

    public static void drawSplashScreen(Graphics var0) {
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
                splashCompleted = true;
            }

            TextRenderer.centerX++;
        }

        var0.drawImage(TextRenderer.getLogoImage(), TextRenderer.logoCenterX, (GameGraphics.screenHeight >> 1) - 15, 3);
        GameManager.instance.drawLoading(var0, TextRenderer.logoCenterX, (GameGraphics.screenHeight + TextRenderer.CHAR_SPACING >> 1) + 3);
        GameManager.instance.frameCounter++;
    }

    public static void updateSplashScreen() {
        GameGraphics.screenWidth = GameGraphics.instance.getWidth();
        GameGraphics.screenHeight = GameGraphics.instance.getHeight();
        if (splashCounter == 35) {
            GameManager.getInstance().initialize(GameGraphics.screenWidth, GameGraphics.screenHeight);
        }

        if (GameGraphics.isDebugMode && splashCompleted) {
            TextRenderer.logoCenterX = GameGraphics.screenWidth >> 1;
            TextRenderer.centerY = GameGraphics.screenHeight >> 1;
            System.gc();
            GameGraphics.gameState = 1;
        }

        splashCounter++;
    }
}
