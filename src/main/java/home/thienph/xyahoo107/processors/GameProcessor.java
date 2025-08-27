package home.thienph.xyahoo107.processors;

import home.thienph.xyahoo107.actions.*;
import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.components.*;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.data.game.ContextMenu;
import home.thienph.xyahoo107.data.media.BuddyGroupList;
import home.thienph.xyahoo107.data.media.BuddyInfo;
import home.thienph.xyahoo107.data.packet.ByteBuffer;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.main.Xuka;
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
                        int screenIdRemove = PacketUtils.readInt(packet);
                        GameManager.instance.destroyScreen(GameManager.instance.findScreenById(screenIdRemove));
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
                        System.out.println("[MessageProcessor.processMessage] end processMessage = " + commandId);
                        return;
                    case 3:
                        /*
                         * Ý nghĩa: Xử lý request đọc dữ liệu từ UI components và trả về response packet
                         *
                         * Đọc dữ liệu:
                         * int: requestId - ID để tracking request/response matching, độ chính xác 100%
                         * int: componentCount - số lượng UI components cần xử lý dữ liệu
                         * for: danh sách componentCount lần
                         *      byte: dataType - loại dữ liệu (0=int, 1=string, 2=boolean, 3=array)
                         *      byte: sourceType - nguồn dữ liệu (0=direct value, 1=UI component value)
                         *
                         *      Nếu dataType == 0 (INTEGER):
                         *          - sourceType 0: int directValue
                         *          - sourceType 1: int screenId, int componentId, boolean isRequired
                         *
                         *      Nếu dataType == 1 (STRING):
                         *          - sourceType 0: string directString
                         *          - sourceType 1: int screenId, int componentId, boolean isRequired
                         *
                         *      Nếu dataType == 2 (BOOLEAN):
                         *          - sourceType 0: boolean directBoolean
                         *          - sourceType 1: int screenId, int componentId
                         *
                         *      Nếu dataType == 3 (ARRAY):
                         *          - sourceType 1: int screenId, int componentId
                         *
                         * Ghi response:
                         * int: requestId - copy lại để client mapping
                         * [componentCount lần]: dữ liệu đã xử lý theo từng dataType
                         * byte: dialogType - loại dialog hiện tại
                         */
                        int requestId = PacketUtils.readInt(packet);
                        Packet responsePacket = new Packet(0, 0);
                        PacketUtils.writeInt(requestId, responsePacket);
                        int componentCount = PacketUtils.readInt(packet);

                        for (int componentIndex = 0; componentIndex < componentCount; componentIndex++) {
                            byte dataType = packet.getPayload().readByte();
                            int sourceType = packet.getPayload().readByte();

                            if (dataType == 0) {
                                if (sourceType == 0) {
                                    int directValue = PacketUtils.readInt(packet);
                                    PacketUtils.writeInt(directValue, responsePacket);
                                } else if (sourceType == 1) {
                                    int screenId = PacketUtils.readInt(packet);
                                    Screen targetScreen = GameManager.instance.findScreenById(screenId);
                                    int componentId = PacketUtils.readInt(packet);
                                    boolean isRequired = PacketUtils.readBoolean(packet);
                                    int extractedValue = 0;
                                    UIComponent targetComponent = targetScreen.findComponentByID(componentId);

                                    if (targetComponent != null) {
                                        if (targetComponent instanceof TextInputComponent) {
                                            String inputText = ((TextInputComponent) targetComponent).getText();
                                            if (isRequired && inputText.equals("")) {
                                                UIUtils.focusComponent(targetScreen, targetComponent);
                                                return;
                                            }

                                            try {
                                                extractedValue = Integer.parseInt(inputText);
                                            } catch (Exception parseException) {
                                                UIUtils.focusComponent(targetScreen, targetComponent);
                                                return;
                                            }
                                        } else if (targetComponent instanceof DropdownComponent) {
                                            extractedValue = ((DropdownComponent) targetComponent).getSelectedIndex();
                                        } else if (targetComponent instanceof GridComponent) {
                                            extractedValue = ((GridComponent) targetComponent).getSelectedItemId();
                                        } else if (targetComponent instanceof PhotoViewComponent) {
                                            extractedValue = ((PhotoViewComponent) targetComponent).displayMode;
                                        }
                                    }

                                    PacketUtils.writeInt(extractedValue, responsePacket);
                                }
                            } else if (dataType == 1) {
                                if (sourceType == 0) {
                                    String directString = PacketUtils.readString(packet);
                                    PacketUtils.writeString(directString, responsePacket);
                                } else if (sourceType == 1) {
                                    int screenId = PacketUtils.readInt(packet);
                                    Screen targetScreen = GameManager.instance.findScreenById(screenId);
                                    int componentId = PacketUtils.readInt(packet);
                                    boolean isRequired = PacketUtils.readBoolean(packet);
                                    UIComponent targetComponent = targetScreen.findComponentByID(componentId);
                                    String extractedString = "";

                                    if (targetComponent instanceof TextInputComponent) {
                                        extractedString = ((TextInputComponent) targetComponent).getText();
                                        if (isRequired && extractedString.equals("")) {
                                            UIUtils.focusComponent(targetScreen, targetComponent);
                                            return;
                                        }
                                    } else if (targetComponent instanceof DropdownComponent) {
                                        extractedString = ((DropdownComponent) targetComponent).getSelectedText();
                                    } else if (targetComponent instanceof ListComponent) {
                                        ListComponent listComponent = (ListComponent) targetComponent;
                                        extractedString = listComponent.getSelectedItem().fileName;
                                    }
                                    PacketUtils.writeString(extractedString == null ? "": extractedString, responsePacket);
                                }
                            } else if (dataType == 2) {
                                if (sourceType == 0) {
                                    boolean directBoolean = PacketUtils.readBoolean(packet);
                                    PacketUtils.writeBoolean(directBoolean, responsePacket);
                                } else if (sourceType == 1) {
                                    int screenId = PacketUtils.readInt(packet);
                                    Screen targetScreen = GameManager.instance.findScreenById(screenId);
                                    int componentId = PacketUtils.readInt(packet);
                                    boolean isChecked = false;
                                    UIComponent targetComponent = targetScreen.findComponentByID(componentId);
                                    if (targetComponent instanceof CheckboxComponent) {
                                        isChecked = ((CheckboxComponent) targetComponent).isChecked;
                                    }
                                    PacketUtils.writeBoolean(isChecked, responsePacket);
                                }
                            } else if (dataType == 3 && sourceType == 1) {
                                int screenId = PacketUtils.readInt(packet);
                                Screen targetScreen = GameManager.instance.findScreenById(screenId);
                                int componentId = PacketUtils.readInt(packet);
                                UIComponent targetComponent = targetScreen.findComponentByID(componentId);
                                if (targetComponent instanceof ListComponent) {
                                    String[] selectedItemIds = ((ListComponent) targetComponent).getSelectedItemIds();
                                    if (selectedItemIds != null) {
                                        int arrayLength = selectedItemIds.length;
                                        PacketUtils.writeInt(arrayLength, responsePacket);
                                        for (int itemIndex = 0; itemIndex < arrayLength; itemIndex++) {
                                            PacketUtils.writeString(selectedItemIds[itemIndex], responsePacket);
                                        }
                                    } else {
                                        PacketUtils.writeInt(0, responsePacket);
                                    }
                                } else {
                                    PacketUtils.writeInt(0, responsePacket);
                                }
                            }
                        }

                        PacketUtils.writeByte(dialogType, responsePacket);
                        PacketSender.requestSendDataUIComponent(responsePacket.getPayload().getBuffer());
                        break;
                    case 4:
                        /*
                         * Ý nghĩa: Tạo và hiển thị dialog screen mới với animation slide-in
                         *
                         * Đọc dữ liệu:
                         * string: title - tiêu đề của dialog screen
                         * int: dialogId - ID duy nhất của dialog, dùng để identify và destroy screen cũ
                         * boolean: isSwitchLastScreen - có chuyển về screen trước đó hay không
                         *
                         */
                        DialogScreen newDialogScreen = new DialogScreen();
                        newDialogScreen.showInNavigation = true;
                        newDialogScreen.title = PacketUtils.readString(packet);
                        int dialogId = PacketUtils.readInt(packet);
                        newDialogScreen.dialogId = dialogId;

                        GameManager.instance.destroyScreen(GameManager.instance.findScreenById(dialogId));
                        newDialogScreen.startSlideAnimation(1);

                        boolean isSwitchLastScreen = PacketUtils.readBoolean(packet);
                        GameManager.instance.addScreenToStack((Screen) newDialogScreen);

                        if (isSwitchLastScreen) {
                            GameManager.instance.switchToLastScreen();
                        }

                        if (dialogId == 11111) {
                            GameManager.instance.setupMainMenu(newDialogScreen);
                        }
                        break;
                    case 5:
                        /*
                         * Ý nghĩa: Cấu hình softkey (left/center/right) cho screen với ButtonAction
                         *
                         * Đọc dữ liệu:
                         * int: screenId - ID của screen cần cấu hình softkey
                         * byte: softkeyType - loại softkey (0=left, 1=center, 2=right)
                         *
                         * Với softkeyType = 0 (LEFT SOFTKEY):
                         *     ButtonAction từ createButtonAction(packet)
                         *     - Nếu screenId là error code: tạo context menu với 2 items
                         *       + Item 1: "Biểu cảm" với action quyen_ax()
                         *       + Item 2: ButtonAction đã đọc
                         *       + Gán leftSoftkey = "Menu" với action quyen_ay(contextMenu)
                         *     - Nếu không phải error code: gán trực tiếp ButtonAction cho leftSoftkey
                         *
                         * Với softkeyType = 1 (CENTER SOFTKEY):
                         *     ButtonAction từ createButtonAction(packet)
                         *     Gán trực tiếp cho centerSoftkey
                         *
                         * Với softkeyType = 2 (RIGHT SOFTKEY):
                         *     ButtonAction từ createButtonAction(packet)
                         *     Gán trực tiếp cho rightSoftkey
                         *
                         * Cuối cùng: đánh dấu screen.needsUpdate = true
                         */
                        int screenId = PacketUtils.readInt(packet);
                        Screen targetScreen = GameManager.instance.findScreenById(screenId);

                        switch (packet.getPayload().readByte()) {
                            case 0: // LEFT SOFTKEY
                                ButtonAction leftButtonAction = createButtonAction(packet);
                                if (GameManager.isValidErrorCode(screenId)) {
                                    Vector menuItems = new Vector();
                                    menuItems.addElement(new ButtonAction("Biểu cảm", new quyen_ax()));
                                    menuItems.addElement(leftButtonAction);
                                    ContextMenu contextMenu = new ContextMenu(menuItems);
                                    targetScreen.leftSoftkey = new ButtonAction("Menu", new quyen_ay(contextMenu));
                                } else {
                                    targetScreen.leftSoftkey = leftButtonAction;
                                }
                                break;

                            case 1: // CENTER SOFTKEY
                                targetScreen.centerSoftkey = createButtonAction(packet);
                                break;

                            case 2: // RIGHT SOFTKEY
                                targetScreen.rightSoftkey = createButtonAction(packet);
                        }

                        targetScreen.needsUpdate = true;
                        break;
                    case 6:
                        /*
                         * Ý nghĩa: Factory pattern tạo và thêm UI component vào DialogScreen theo componentType
                         *
                         * Đọc dữ liệu:
                         * int: dialogId - ID của DialogScreen cần thêm component
                         * byte: componentType - loại component cần tạo
                         *
                         * int: componentId - ID duy nhất cho component (đọc cuối cùng)
                         *
                         * componentType = 0 (TextInputComponent):
                         *     string: label - nhãn hiển thị
                         *     int: maxLength - độ dài tối đa
                         *     int: inputType - loại input
                         *     byte: alignment - căn chỉnh component
                         *
                         * componentType = 1 (TextComponent/Spacer):
                         *     string: text - nội dung text (nếu rỗng thì tạo spacer)
                         *     int: width - chiều rộng
                         *     int: textColor - màu chữ
                         *     byte: alignment - căn chỉnh (nếu không phải spacer)
                         *
                         * componentType = 4 (TextLinkComponent/CustomButton):
                         *     string: text - text hiển thị
                         *     int: width - chiều rộng
                         *     int: textColor - màu chữ
                         *     bytes: actionData - dữ liệu cho action handler
                         *     byte: alignment - căn chỉnh component
                         *
                         * componentType = 5 (SimpleTextComponent):
                         *     string: text - nội dung text
                         *     int: unused - giá trị không dùng
                         *
                         * componentType = 6 (ImageComponent từ resourceId):
                         *     int: imageResourceId - ID resource image
                         *     int: width - chiều rộng
                         *     int: height - chiều cao
                         *     boolean: isVisible - hiển thị hay không
                         *     boolean: hasBorder - có border hay không
                         *     string: clickActionName - tên action khi click
                         *     bytes: clickActionData - dữ liệu cho click action
                         *     byte: alignment - căn chỉnh component
                         *
                         * componentType = 7 (DropdownComponent):
                         *     string: label - nhãn hiển thị
                         *     int: selectedIndex - index được chọn ban đầu
                         *     int: optionCount - số lượng options
                         *     [optionCount lần]: string option - từng option
                         *     bytes: changeActionData - dữ liệu cho change action
                         *     int: finalSelectedIndex - index được set cuối cùng
                         *     byte: alignment - căn chỉnh component
                         *
                         * componentType = 8 (ImageComponent từ multiple images):
                         *     byte: imageCount - số lượng image IDs
                         *     [imageCount lần]: int imageId - ID từng image
                         *     int: width - chiều rộng
                         *     int: height - chiều cao
                         *     boolean: isVisible - hiển thị hay không
                         *     boolean: hasBorder - có border hay không
                         *     string: clickActionName - tên action khi click
                         *     bytes: clickActionData - dữ liệu cho click action
                         *     byte: alignment - căn chỉnh component
                         *
                         * componentType = 11 (ListComponent/BuddyList):
                         *     boolean: showGroups - hiển thị groups hay không
                         *     byte: displayMode - chế độ hiển thị (có thêm field hay không)
                         *     byte: iconType - loại icon (0=none, 2=color, 3=image)
                         *     int: iconWidth, iconHeight - kích thước icon (nếu iconType = 2)
                         *     byte: statusIconType - loại status icon
                         *     int: contactCount - số lượng contacts
                         *     [contactCount lần]:
                         *         string: groupName - tên nhóm
                         *         string: mediaType - tên file
                         *         string: displayName - tên hiển thị
                         *         string: extraField - field phụ (nếu displayMode = 1)
                         *         int/bytes: iconData - dữ liệu icon (tùy iconType)
                         *         byte: status - trạng thái (nếu statusIconType = 1)
                         *         string: tooltip - tooltip text
                         *     bytes: itemActionData - dữ liệu cho item action
                         *
                         * componentType = 12 (ImageComponent từ bytes):
                         *     bytes: imageData - dữ liệu image
                         *     boolean: isVisible - hiển thị hay không
                         *     boolean: hasBorder - có border hay không
                         *     string: clickActionName - tên action khi click
                         *     bytes: clickActionData - dữ liệu cho click action
                         *     byte: alignment - căn chỉnh component
                         *
                         * componentType = 13 (GridComponent):
                         *     int: itemCount - số lượng items
                         *     int: itemWidth - rộng item
                         *     int: itemHeight - cao item
                         *     boolean: hasCheckboxes - có checkboxes hay không
                         *     [itemCount lần]:
                         *         string: itemText - text của item
                         *         int: itemId - ID của item
                         *         int: itemColor - màu của item
                         *         boolean: isChecked - trạng thái checked (nếu hasCheckboxes = true)
                         *     bytes: selectActionData - dữ liệu cho select action
                         *
                         * componentType = 14 (CheckboxComponent):
                         *     string: label - nhãn hiển thị
                         *     boolean: isChecked - trạng thái checked ban đầu
                         *     byte: alignment - căn chỉnh component
                         *
                         * componentType = 15 (LabelComponent):
                         *     string: text - nội dung label
                         *     int: textColor - màu chữ
                         *     byte: alignment - căn chỉnh component
                         *
                         * componentType = 16 (PopupDialogComponent):
                         *     string: message - nội dung popup
                         *     byte: dialogType - loại dialog
                         *     bytes: actionData - dữ liệu cho action
                         *
                         * componentType = 17 (ButtonComponent):
                         *     string: text - text hiển thị trên button
                         *     int: width - chiều rộng button
                         *     bytes: actionData - dữ liệu cho button action
                         *     byte: alignment - căn chỉnh component
                         */
                        int dialogId1 = PacketUtils.readInt(packet);
                        DialogScreen targetDialog = (DialogScreen) GameManager.instance.findScreenById(dialogId1);
                        byte componentType = packet.getPayload().readByte();
                        Object createdComponent = null;

                        System.out.println("[UIComponentFactory] screen id: " + dialogId1 + ", component type: " + componentType);

                        switch (componentType) {
                            case 0: // TextInputComponent
                                String label = PacketUtils.readString(packet);
                                int maxLength = PacketUtils.readInt(packet);
                                int inputType = PacketUtils.readInt(packet);
                                TextInputComponent textInput = ButtonAction.createLabeledTextInput(targetDialog, label, maxLength, inputType);
                                createdComponent = textInput;
                                setComponentAlignment(targetDialog, (UIComponent) createdComponent, packet);
                                textInput.textInputHandler.posX = textInput.posX;
                                break;

                            case 1: // TextComponent or Spacer
                                String text = PacketUtils.readString(packet);
                                int width = PacketUtils.readInt(packet);
                                if (text.equals("")) {
                                    TextComponent spacer = ButtonAction.createSpacer(targetDialog, width);
                                    spacer.textColor = new Integer(UIUtils.validateColor(PacketUtils.readInt(packet)));
                                    spacer.isVisible = !text.trim().equals("");
                                    createdComponent = spacer;
                                    packet.getPayload().readByte(); // Skip alignment
                                } else {
                                    createdComponent = ButtonAction.createWrappedText(text, targetDialog, width, UIUtils.validateColor(PacketUtils.readInt(packet)), true, true)[0];
                                    setComponentAlignment(targetDialog, (UIComponent) createdComponent, packet);
                                }
                                break;

                            case 2:
                            case 3:
                            case 9:
                            case 10:
                            default:
                                break;

                            case 4: // TextLinkComponent/CustomButton
                                String buttonText = PacketUtils.readString(packet);
                                int buttonWidth = PacketUtils.readInt(packet);
                                int textColor = UIUtils.validateColor(PacketUtils.readInt(packet));
                                byte[] actionData = PacketUtils.readBytes(packet);
                                TextLinkComponent customButton = ButtonAction.createCustomButton(targetDialog, buttonText, buttonWidth, new TextLinkAction(actionData), targetDialog.dialogX, targetDialog.nextComponentY, targetDialog.dialogWidth);
                                customButton.textColor = new Integer(textColor);
                                createdComponent = customButton;
                                setComponentAlignment(targetDialog, customButton, packet);
                                break;

                            case 5: // SimpleTextComponent
                                String simpleText = PacketUtils.readString(packet);
                                PacketUtils.readInt(packet); // Unused parameter
                                createdComponent = ButtonAction.createSimpleText(targetDialog, simpleText)[0];
                                break;

                            case 6: // ImageComponent from resource ID
                            case 12: // ImageComponent from bytes
                                Image image = null;
                                int imageResourceId = -1;
                                int imageWidth = 0;
                                int imageHeight = 0;

                                if (componentType == 12) {
                                    byte[] imageBytes = PacketUtils.readBytes(packet);
                                    image = Image.createImage(imageBytes, 0, imageBytes.length);
                                    imageWidth = image.getWidth();
                                    imageHeight = image.getHeight();
                                } else if (componentType == 6) {
                                    imageResourceId = PacketUtils.readInt(packet);
                                    imageWidth = PacketUtils.readInt(packet);
                                    imageHeight = PacketUtils.readInt(packet);
                                }

                                boolean isVisible = PacketUtils.readBoolean(packet);
                                boolean hasBorder = PacketUtils.readBoolean(packet);
                                String clickActionName = PacketUtils.readString(packet);
                                byte[] clickActionData = PacketUtils.readBytes(packet);

                                ImageComponent imageComponent = ButtonAction.createImageComponent(targetDialog, imageResourceId, image, imageWidth, imageHeight, isVisible, hasBorder);
                                if (clickActionData != null && clickActionData.length > 1) {
                                    imageComponent.setClickAction(clickActionName, new ImageClickAction(clickActionData));
                                }

                                createdComponent = imageComponent;
                                setComponentAlignment(targetDialog, imageComponent, packet);
                                break;

                            case 7: // DropdownComponent
                                String dropdownLabel = PacketUtils.readString(packet);
                                int selectedIndex = PacketUtils.readInt(packet);
                                int optionCount = PacketUtils.readInt(packet);
                                String[] options = new String[optionCount];

                                for (int i = 0; i < optionCount; i++) {
                                    options[i] = PacketUtils.readString(packet);
                                }

                                byte[] changeActionData = PacketUtils.readBytes(packet);
                                DropdownComponent dropdown = ButtonAction.createChoiceBoxWithID(targetDialog, dropdownLabel, options, selectedIndex);
                                if (changeActionData != null && changeActionData.length > 1) {
                                    dropdown.setChangeAction(new DropdownChangeAction(changeActionData));
                                }

                                int finalSelectedIndex = PacketUtils.readInt(packet);
                                createdComponent = dropdown;
                                setComponentAlignment(targetDialog, dropdown, packet);
                                dropdown.textInputHandler.posX = dropdown.posX;
                                dropdown.setSelectedIndex(finalSelectedIndex);
                                break;

                            case 8: // ImageComponent with multiple images
                                byte imageCount = packet.getPayload().readByte();
                                int[] imageIds = new int[imageCount];

                                for (int i = 0; i < imageCount; i++) {
                                    imageIds[i] = PacketUtils.readInt(packet);
                                }

                                int multiImageWidth = PacketUtils.readInt(packet);
                                int multiImageHeight = PacketUtils.readInt(packet);
                                boolean multiImageVisible = PacketUtils.readBoolean(packet);
                                boolean multiImageBorder = PacketUtils.readBoolean(packet);
                                String multiImageClickAction = PacketUtils.readString(packet);
                                byte[] multiImageActionData = PacketUtils.readBytes(packet);

                                ImageComponent multiImageComponent = new ImageComponent();
                                multiImageComponent.setSize(multiImageWidth, multiImageHeight);
                                multiImageComponent.isVisible = multiImageVisible;
                                multiImageComponent.setMultipleImages(imageIds);
                                multiImageComponent.setPosition(Screen.screenWidth - multiImageWidth >> 1, targetDialog.nextComponentY == 6 ? targetDialog.nextComponentY : targetDialog.nextComponentY + 2);
                                multiImageComponent.hasBorder = multiImageBorder;
                                targetDialog.addComponent(multiImageComponent);
                                targetDialog.nextComponentY += 2;

                                if (multiImageClickAction.length() > 0 && multiImageActionData != null && multiImageActionData.length > 1) {
                                    multiImageComponent.setClickAction(multiImageClickAction, new MultiImageClickAction(multiImageActionData));
                                }

                                createdComponent = multiImageComponent;
                                setComponentAlignment(targetDialog, multiImageComponent, packet);
                                break;

                            case 11: // ListComponent/BuddyList
                                boolean adjustHeight = PacketUtils.readBoolean(packet);
                                byte enableDescription = packet.getPayload().readByte();
                                byte iconType = packet.getPayload().readByte();
                                int iconWidth = -1;
                                int iconHeight = -1;

                                if (iconType == 2) {
                                    iconWidth = PacketUtils.readInt(packet);
                                    iconHeight = PacketUtils.readInt(packet);
                                }

                                byte enableStatusIcon = packet.getPayload().readByte();
                                int contactCount = PacketUtils.readInt(packet);
                                BuddyGroupList buddyManager = new BuddyGroupList();
                                BuddyInfo[] contacts = new BuddyInfo[contactCount];
                                String[] groupNames = new String[contactCount];

                                for (int i = 0; i < contactCount; i++) {
                                    groupNames[i] = PacketUtils.readString(packet);
                                    String fileName = PacketUtils.readString(packet);
                                    String displayName = PacketUtils.readString(packet);
                                    String description = null;

                                    if (enableDescription == 1) {
                                        description = PacketUtils.readString(packet);
                                    }

                                    Integer imageSourceId = null;
                                    Image thumbnailImage = null;

                                    if (iconType == 2) {
                                        imageSourceId = new Integer(PacketUtils.readInt(packet));
                                    } else if (iconType == 3) {
                                        thumbnailImage = UIUtils.createImageFromBytes(PacketUtils.readBytes(packet));
                                        if (iconWidth == -1) {
                                            iconWidth = thumbnailImage.getWidth();
                                            iconHeight = thumbnailImage.getHeight();
                                        }
                                    }

                                    byte status = 0;
                                    if (enableStatusIcon == 1) {
                                        status = packet.getPayload().readByte();
                                        if (status == 0) {
                                            status = 2;
                                        } else if (status == 1) {
                                            status = 3;
                                        } else {
                                            status = 4;
                                        }
                                    }

                                    String statusDescription = PacketUtils.readString(packet);
                                    if (statusDescription != null && statusDescription.length() == 0) {
                                        statusDescription = null;
                                    }

                                    contacts[i] = new BuddyInfo("", displayName, status, description, null, -1, i, statusDescription);
                                    contacts[i].mediaExtension = fileName;
                                    contacts[i].imageSourceId = imageSourceId;
                                    contacts[i].thumbnailImage = thumbnailImage;
                                    buddyManager.addContactToGroup(groupNames[i], contacts[i]);
                                }

                                byte[] itemActionData = PacketUtils.readBytes(packet);
                                if (iconWidth == -1) {
                                    iconWidth = 10;
                                    iconHeight = 10;
                                }

                                ListComponent listComponent = new ListComponent(0, 0, Screen.screenWidth, Screen.screenHeight - GameManager.footerHeight);
                                targetDialog.addComponent(listComponent);
                                UIUtils.focusComponent(targetDialog, listComponent);
                                listComponent.setIconSettings(iconType, iconWidth, iconHeight);
                                listComponent.setEnableIconStatus(enableStatusIcon);
                                listComponent.setDataSource(buddyManager, enableDescription, adjustHeight);

                                if (itemActionData != null && itemActionData.length > 1) {
                                    listComponent.itemAction = new ListBuddyListClickAction(itemActionData);
                                }

                                if (itemActionData == null || itemActionData.length <= 1) {
                                    listComponent.selectAction.text = "";
                                }

                                createdComponent = listComponent;
                                targetDialog.isScrollLocked = true;
                                break;

                            case 13: // GridComponent
                                int itemCount = PacketUtils.readInt(packet);
                                int itemWidth = PacketUtils.readInt(packet);
                                int itemHeight = PacketUtils.readInt(packet);
                                boolean hasCheckboxes = PacketUtils.readBoolean(packet);

                                int[] actionIds = new int[itemCount];
                                Integer[] itemImageIds = new Integer[itemCount];
                                String[] itemTexts = new String[itemCount];
                                boolean[] checkedStates = null;

                                if (hasCheckboxes) {
                                    checkedStates = new boolean[itemCount];
                                }

                                for (int i = 0; i < itemCount; i++) {
                                    itemTexts[i] = PacketUtils.readString(packet);
                                    actionIds[i] = PacketUtils.readInt(packet);
                                    itemImageIds[i] = new Integer(PacketUtils.readInt(packet));
                                    if (hasCheckboxes) {
                                        checkedStates[i] = PacketUtils.readBoolean(packet);
                                    }
                                }

                                GridComponent gridComponent = new GridComponent(0, 0, Screen.screenWidth, Screen.screenHeight - GameManager.footerHeight, itemCount, itemTexts, actionIds, itemImageIds, itemWidth, itemHeight, false, 2);
                                targetDialog.addComponent(gridComponent);
                                UIUtils.focusComponent(targetDialog, gridComponent);

                                byte[] selectActionData = PacketUtils.readBytes(packet);
                                ButtonAction gridSelectAction = new ButtonAction("Chọn", new GridClickAction(hasCheckboxes, gridComponent, checkedStates, selectActionData));
                                gridComponent.middleSoftKey = gridSelectAction;
                                createdComponent = gridComponent;
                                targetDialog.isScrollLocked = true;
                                break;

                            case 14: // CheckboxComponent
                                String checkboxLabel = PacketUtils.readString(packet);
                                boolean isChecked = PacketUtils.readBoolean(packet);
                                createdComponent = ButtonAction.createCheckbox(targetDialog, checkboxLabel, isChecked);
                                setComponentAlignment(targetDialog, (UIComponent) createdComponent, packet);
                                break;

                            case 15: // LabelComponent
                                String labelText = PacketUtils.readString(packet);
                                TextComponent labelComponent = ButtonAction.createLabel(labelText, targetDialog, -1);
                                labelComponent.textColor = new Integer(UIUtils.validateColor(PacketUtils.readInt(packet)));
                                labelComponent.isVisible = !labelText.trim().equals("");
                                labelComponent.enableScrolling = true;
                                createdComponent = labelComponent;
                                setComponentAlignment(targetDialog, labelComponent, packet);
                                break;

                            case 16: // PopupDialogComponent
                                String popupMessage = PacketUtils.readString(packet);
                                byte dialogType = packet.getPayload().readByte();
                                byte[] popupActionData = PacketUtils.readBytes(packet);
                                createdComponent = ButtonAction.createTextInputPopup(targetDialog, popupMessage, dialogType, new PopupDialogClickAction(popupActionData));
//                                UIUtils.showTextInputPopup((Screen) targetDialog, (TextInputComponent) createdComponent);
                                break;

                            case 17: // ButtonComponent
                                String buttonLabel = PacketUtils.readString(packet);
                                int buttonWidthParam = PacketUtils.readInt(packet);
                                byte[] buttonActionData = PacketUtils.readBytes(packet);
                                createdComponent = ButtonAction.createButton(targetDialog, buttonLabel, new ButtonClickAction(buttonActionData), targetDialog.nextComponentY, buttonWidthParam);
                                setComponentAlignment(targetDialog, (UIComponent) createdComponent, packet);
                        }

                        int componentId = PacketUtils.readInt(packet);
                        ((UIComponent) createdComponent).id = componentId;

                        if (((UIComponent) createdComponent).id > 1000 && createdComponent instanceof TextInputComponent) {
                            ((TextInputComponent) createdComponent).useNativeInput = true;
                        }
                        break;
                    case 7:
                        /*
                         * Ý nghĩa: Focus vào một UI component cụ thể trong screen
                         *
                         * Đọc dữ liệu:
                         * int: screenId - ID của screen chứa component
                         * int: componentId - ID của component cần focus
                         */
                        int screenId2 = PacketUtils.readInt(packet);
                        Screen targetScreen2 = GameManager.instance.findScreenById(screenId2);
                        int componentId2 = PacketUtils.readInt(packet);
                        UIComponent targetComponent = targetScreen2.findComponentByID(componentId2);

                        UIUtils.focusComponent(targetScreen2, targetComponent);
                        if (targetScreen2.equals(GameManager.instance.getCurrentScreen())) {
                            targetScreen2.focusFirstComponent();
                        }
                        break;

                    case 8:
                        /*
                         * Ý nghĩa: Thực hiện garbage collection và return khỏi method
                         *
                         * Đọc dữ liệu: không có
                         */
                        System.gc();
                        return;

                    case 12:
                        /*
                         * Ý nghĩa: Tạo menu items cho DialogScreen từ danh sách string
                         *
                         * Đọc dữ liệu:
                         * int: dialogId - ID của DialogScreen cần tạo menu
                         * int: menuItemCount - số lượng menu items
                         * [menuItemCount lần]: string menuItem - text của từng menu item
                         */
                        int dialogId3 = PacketUtils.readInt(packet);
                        DialogScreen targetDialog3 = (DialogScreen) GameManager.instance.findScreenById(dialogId3);
                        int menuItemCount = PacketUtils.readInt(packet);
                        String[] menuItems = new String[menuItemCount];

                        for (int i = 0; i < menuItemCount; i++) {
                            menuItems[i] = PacketUtils.readString(packet);
                        }

                        targetDialog3.createMenuItems(menuItems);
                        break;

                    case 13:
                        /*
                         * Ý nghĩa: Mở rộng menu item tại index cụ thể trong DialogScreen
                         *
                         * Đọc dữ liệu:
                         * int: dialogId - ID của DialogScreen chứa menu
                         * int: menuIndex - index của menu item cần expand
                         */
                        int expandDialogId = PacketUtils.readInt(packet);
                        DialogScreen expandDialog = (DialogScreen) GameManager.instance.findScreenById(expandDialogId);
                        int menuIndex = PacketUtils.readInt(packet);
                        expandDialog.expandMenu(menuIndex);
                        break;

                    case 14:
                        /*
                         * Ý nghĩa: Hiển thị confirmation dialog cho SMS với text từ direct hoặc UI component
                         *
                         * Đọc dữ liệu:
                         * byte: textSourceType - nguồn text (0=direct string, 1=từ UI component)
                         *
                         * Nếu textSourceType = 0:
                         *     string: messageText - nội dung tin nhắn trực tiếp
                         *
                         * Nếu textSourceType = 1:
                         *     int: sourceScreenId - ID screen chứa TextInputComponent
                         *     int: sourceComponentId - ID của TextInputComponent
                         *     boolean: isRequired - có bắt buộc nhập hay không
                         *
                         * string: phoneNumber - số điện thoại đích (format: "SEND: xxxxxxxxxx")
                         */
                        byte textSourceType = packet.getPayload().readByte();
                        String messageText = "";

                        if (textSourceType == 0) {
                            messageText = PacketUtils.readString(packet);
                        } else {
                            int sourceScreenId = PacketUtils.readInt(packet);
                            Screen sourceScreen = GameManager.instance.findScreenById(sourceScreenId);
                            int sourceComponentId = PacketUtils.readInt(packet);
                            boolean isRequired = PacketUtils.readBoolean(packet);

                            UIComponent sourceComponent = sourceScreen.findComponentByID(sourceComponentId);
                            if (sourceComponent instanceof TextInputComponent) {
                                messageText = ((TextInputComponent) sourceComponent).getText();
                                if (isRequired && messageText.equals("")) {
                                    UIUtils.focusComponent(sourceScreen, sourceComponent);
                                    return;
                                }
                            }
                        }

                        String phoneNumber = PacketUtils.readString(packet);
                        String confirmMessage = UIUtils.concatStrings("Gửi tin: ", messageText, Xuka.refCode, "\nĐến số: ");
                        GameManager.instance.showConfirmDialog(UIUtils.concatStrings(confirmMessage, phoneNumber.substring(6), null, null), new quyen_aw(messageText, phoneNumber));
                        break;

                    case 15:
                        /*
                         * Ý nghĩa: Mở URL bằng platform request (browser/external app)
                         *
                         * Đọc dữ liệu:
                         * string: url - URL cần mở
                         */
                        try {
                            String url = PacketUtils.readString(packet);
                            Xuka.instance.platformRequest(url);
                        } catch (ConnectionNotFoundException connectionException) {
                            // Ignore exception
                        }
                        break;

                    case 16:
                    case 17:
                        /*
                         * Ý nghĩa: Điều chỉnh vị trí X (horizontal) của UI component
                         *
                         * Đọc dữ liệu:
                         * int: dialogId - ID của DialogScreen
                         * int: targetComponentId - ID component cần điều chỉnh vị trí
                         *
                         * Case 16 - Set absolute position X:
                         *     int: absoluteX - vị trí X tuyệt đối
                         *
                         * Case 17 - Set relative position X:
                         *     int: referenceComponentId - ID component làm tham chiếu
                         *     Vị trí X = referenceComponent.posX + referenceComponent.width + 6
                         */
                        DialogScreen positionDialog = (DialogScreen) GameManager.instance.findScreenById(PacketUtils.readInt(packet));
                        UIComponent targetPositionComponent = positionDialog.findComponentByID(PacketUtils.readInt(packet));
                        UIComponent referenceComponent = null;

                        if (commandId == 16) {
                            int absoluteX = PacketUtils.readInt(packet);
                            targetPositionComponent.posX = absoluteX;
                        } else {
                            int referenceComponentId = PacketUtils.readInt(packet);
                            referenceComponent = positionDialog.findComponentByID(referenceComponentId);
                            if (commandId == 17) {
                                targetPositionComponent.posX = referenceComponent.posX + referenceComponent.width + 6;
                            }
                        }
                        break;

                    case 18:
                    case 19:
                    case 20:
                        /*
                         * Ý nghĩa: Điều chỉnh vị trí Y (vertical) của UI component và update layout
                         *
                         * Đọc dữ liệu:
                         * int: dialogId - ID của DialogScreen
                         * int: targetComponentId - ID component cần điều chỉnh vị trí
                         *
                         * Case 18 - Set absolute position Y:
                         *     int: absoluteY - vị trí Y tuyệt đối
                         *
                         * Case 19 - Set position below reference component:
                         *     int: referenceComponentId - ID component làm tham chiếu
                         *     Vị trí Y = referenceComponent.posY + referenceComponent.height + 2
                         *
                         * Case 20 - Set position same Y as reference component:
                         *     int: referenceComponentId - ID component làm tham chiếu
                         *     Vị trí Y = referenceComponent.posY
                         *
                         * Sau khi set: dialog.nextComponentY = targetComponent.posY + targetComponent.height + 2
                         * Cuối cùng: dialog.updateLayout()
                         */
                        DialogScreen layoutDialog = (DialogScreen) GameManager.instance.findScreenById(PacketUtils.readInt(packet));
                        UIComponent targetLayoutComponent = layoutDialog.findComponentByID(PacketUtils.readInt(packet));
                        UIComponent layoutReferenceComponent = null;

                        if (commandId == 18) {
                            int absoluteY = PacketUtils.readInt(packet);
                            targetLayoutComponent.posY = absoluteY;
                            layoutDialog.nextComponentY = targetLayoutComponent.posY + targetLayoutComponent.height + 2;
                        } else {
                            int referenceComponentId = PacketUtils.readInt(packet);
                            layoutReferenceComponent = layoutDialog.findComponentByID(referenceComponentId);

                            if (commandId == 19) {
                                targetLayoutComponent.posY = layoutReferenceComponent.posY + layoutReferenceComponent.height + 2;
                            } else if (commandId == 20) {
                                targetLayoutComponent.posY = layoutReferenceComponent.posY;
                            }
                        }

                        layoutDialog.nextComponentY = targetLayoutComponent.posY + targetLayoutComponent.height + 2;
                        layoutDialog.updateLayout();
                        break;
                    case 21:
                        /*
                         * Ý nghĩa: Gửi response packet với string data
                         *
                         * Đọc dữ liệu:
                         * string: responseData - dữ liệu cần gửi trong response
                         */
                        String responseData = PacketUtils.readString(packet);
                        Packet responsePacket2 = new Packet(0, 0);
                        PacketUtils.writeInt(0, responsePacket2);
                        PacketUtils.writeString(responseData, responsePacket2);
                        PacketSender.requestSendDataUIComponent(responsePacket2.getPayload().getBuffer());
                        break;

                    case 22:
                        /*
                         * Ý nghĩa: Kích hoạt screen theo title và destroy screen hiện tại
                         *
                         * Đọc dữ liệu:
                         * string: screenTitle - title của screen cần kích hoạt
                         */
                        String screenTitle = PacketUtils.readString(packet);
                        GameManager.instance.destroyScreen(GameManager.instance.setActiveScreen(screenTitle));
                        break;

                    case 23:
                        /*
                         * Ý nghĩa: Đóng dialog hiện tại
                         *
                         * Đọc dữ liệu: không có
                         */
                        GameManager.instance.closeDialog();
                        break;

                    case 24:
                        /*
                         * Ý nghĩa: Set text cho TextInputComponent cụ thể
                         *
                         * Đọc dữ liệu:
                         * int: screenId - ID của screen chứa component
                         * int: componentId - ID của TextInputComponent
                         * string: newText - text mới cần set
                         */
                        int textScreenId = PacketUtils.readInt(packet);
                        int textComponentId = PacketUtils.readInt(packet);
                        String newText = PacketUtils.readString(packet);

                        try {
                            TextInputComponent textInput = (TextInputComponent) GameManager.instance.findScreenById(textScreenId).findComponentByID(textComponentId);
                            textInput.setText(newText);
                        } catch (Exception textException) {
                            // Ignore exception if component not found or wrong type
                        }
                        break;

                    case 26:
                        /*
                         * Ý nghĩa: Tạo hoặc lấy ChatScreen và chuyển đến chat với chatId
                         *
                         * Đọc dữ liệu:
                         * string: chatTitle - title của chat screen
                         * long: chatId - ID duy nhất của chat session
                         */
                        String chatTitle = PacketUtils.readString(packet);
                        long chatId = PacketUtils.readLong(packet);

                        ChatScreen chatScreen = GameManager.getInstance().getOrCreateChatScreen(chatTitle);
                        chatScreen.setChatId(chatId);
                        GameManager.getInstance().switchToScreenByTitle(chatScreen.title);
                        break;

                    case 28:
                        /*
                         * Ý nghĩa: Hiển thị dialog với wrapped text
                         *
                         * Đọc dữ liệu:
                         * string: dialogText - nội dung text cần hiển thị trong dialog
                         */
                        String dialogText = PacketUtils.readString(packet);
                        GameManager.instance.showWrappedTextDialog(dialogText);
                        break;

                    case 29:
                    case 60:
                    case 61:
                        /*
                         * Ý nghĩa: Tạo dialog với các loại khác nhau
                         *
                         * Case 29 - Simple Dialog:
                         *     string: dialogMessage - nội dung dialog
                         *     string: leftButtonText - text button trái
                         *     bytes: leftButtonAction - action data cho button trái
                         *     string: centerButtonText - text button giữa
                         *     bytes: centerButtonAction - action data cho button giữa
                         *     string: rightButtonText - text button phải
                         *     bytes: rightButtonAction - action data cho button phải
                         *
                         * Case 60 - Table Dialog (chỉ select/back):
                         *     string: dialogTitle - tiêu đề dialog
                         *     byte: rowCount - số hàng
                         *     byte: columnCount - số cột
                         *     byte: tableType - loại table
                         *     [rowCount lần]:
                         *         [columnCount lần]: string cellData - dữ liệu từng cell
                         *
                         * Case 61 - Table Dialog với custom buttons:
                         *     string: dialogTitle - tiêu đề dialog
                         *     byte: rowCount - số hàng
                         *     byte: columnCount - số cột
                         *     byte: tableType - loại table
                         *     [rowCount lần]:
                         *         [columnCount lần]: string cellData - dữ liệu từng cell
                         *     string: leftButtonText - text button trái
                         *     bytes: leftButtonAction - action data cho button trái
                         *     string: centerButtonText - text button giữa
                         *     bytes: centerButtonAction - action data cho button giữa
                         *     string: rightButtonText - text button phải
                         *     bytes: rightButtonAction - action data cho button phải
                         */
                        String dialogTitle = null;
                        byte rowCount = 0;
                        byte columnCount = 0;
                        byte tableType = 0;
                        Vector tableData = null;
                        String simpleMessage = null;

                        if (commandId == 29) {
                            simpleMessage = PacketUtils.readString(packet);
                        } else if (commandId == 60 || commandId == 61) {
                            dialogTitle = PacketUtils.readString(packet);
                            rowCount = packet.getPayload().readByte();
                            columnCount = packet.getPayload().readByte();
                            tableType = packet.getPayload().readByte();
                            tableData = new Vector();

                            for (int row = 0; row < rowCount; row++) {
                                String[] rowData = new String[columnCount];
                                for (int col = 0; col < columnCount; col++) {
                                    rowData[col] = PacketUtils.readString(packet);
                                }
                                tableData.addElement(rowData);
                            }

                            if (dialogTitle != null && dialogTitle.length() == 0) {
                                dialogTitle = null;
                            }
                        }

                        ButtonAction leftButton = null;
                        ButtonAction centerButton = null;
                        ButtonAction rightButton = null;

                        if (commandId == 29 || commandId == 61) {
                            String leftButtonText = PacketUtils.readString(packet);
                            byte[] leftButtonAction = PacketUtils.readBytes(packet);
                            String centerButtonText = PacketUtils.readString(packet);
                            byte[] centerButtonAction = PacketUtils.readBytes(packet);
                            String rightButtonText = PacketUtils.readString(packet);
                            byte[] rightButtonAction = PacketUtils.readBytes(packet);

                            if (leftButtonAction != null && leftButtonAction.length > 1) {
                                leftButton = new ButtonAction(leftButtonText, new quyen_at(leftButtonAction));
                            }

                            if (centerButtonAction != null && centerButtonAction.length > 1) {
                                centerButton = new ButtonAction(centerButtonText, new quyen_au(centerButtonAction));
                            }

                            if (rightButtonAction != null && rightButtonAction.length > 1) {
                                rightButton = new ButtonAction(rightButtonText, new quyen_av(rightButtonAction));
                            }
                        }

                        if (commandId == 29) {
                            GameManager.instance.createSimpleDialog(simpleMessage, leftButton, centerButton, rightButton);
                        } else if (commandId == 60) {
                            GameManager.instance.createDialog(dialogTitle, tableType, tableData, columnCount, GameManager.instance.getSelectButton(), GameManager.instance.createBackButton("OK"), null);
                        } else if (commandId == 61) {
                            GameManager.instance.createDialog(dialogTitle, tableType, tableData, columnCount, leftButton, centerButton, rightButton);
                        }
                        break;

                    case 30:
                        /*
                         * Ý nghĩa: Set multi-select mode cho ListComponent
                         *
                         * Đọc dữ liệu:
                         * int: screenId - ID của screen chứa ListComponent
                         * int: componentId - ID của ListComponent
                         * boolean: multiSelectEnabled - bật/tắt multi-select mode
                         */
                        int listScreenId = PacketUtils.readInt(packet);
                        int listComponentId = PacketUtils.readInt(packet);
                        boolean multiSelectEnabled = PacketUtils.readBoolean(packet);

                        try {
                            ListComponent listComponent = (ListComponent) GameManager.instance.findScreenById(listScreenId).findComponentByID(listComponentId);
                            listComponent.setMultiSelectMode(multiSelectEnabled);
                        } catch (Exception listException) {
                            // Ignore exception if component not found or wrong type
                        }
                        break;

                    case 31:
                        /*
                         * Ý nghĩa: Toggle select all items trong ListComponent
                         *
                         * Đọc dữ liệu:
                         * int: screenId - ID của screen chứa ListComponent
                         * int: componentId - ID của ListComponent
                         */
                        int toggleScreenId = PacketUtils.readInt(packet);
                        int toggleComponentId = PacketUtils.readInt(packet);

                        try {
                            ListComponent toggleListComponent = (ListComponent) GameManager.instance.findScreenById(toggleScreenId).findComponentByID(toggleComponentId);
                            toggleListComponent.toggleSelectAll();
                        } catch (Exception toggleException) {
                            // Ignore exception if component not found or wrong type
                        }
                        break;

                    case 39:
                        /*
                         * Ý nghĩa: Xử lý message từ byte array (recursive call)
                         *
                         * Đọc dữ liệu:
                         * bytes: messageData - dữ liệu message cần xử lý tiếp
                         */
                        byte[] messageData = PacketUtils.readBytes(packet);
                        processMessage(messageData);
                        break;

                    case 47:
                        /*
                         * Ý nghĩa: Tạo pagination component với << >> và input field cho DialogScreen
                         *
                         * Đọc dữ liệu:
                         * int: dialogId - ID của DialogScreen cần thêm pagination
                         * int: currentPage - trang hiện tại
                         * int: totalPages - tổng số trang
                         * int: prevButtonId - ID cho button "<<"
                         * bytes: prevButtonAction - action data cho button "<<"
                         * int: nextButtonId - ID cho button ">>"
                         * bytes: nextButtonAction - action data cho button ">>"
                         * int: inputFieldId - ID cho input field
                         * bytes: inputFieldAction - action data cho input field ("Đến trang")
                         */
                        int paginationDialogId = PacketUtils.readInt(packet);
                        DialogScreen paginationDialog = (DialogScreen) GameManager.instance.findScreenById(paginationDialogId);

                        if (paginationDialog != null) {
                            int currentPage = packet == null ? 1 : PacketUtils.readInt(packet);
                            int totalPages = packet == null ? 20 : PacketUtils.readInt(packet);

                            String pageInfo = UIUtils.concatStrings(" / ", Integer.toString(totalPages), null, null);
                            int inputWidth = FontRenderer.getTextWidth(" 99 ") + 6;
                            int startX = Screen.screenWidth - FontRenderer.getTextWidth(UIUtils.concatStrings("<<   >>   ", pageInfo, null, null)) - inputWidth >> 1;

                            // Create << button
                            TextLinkComponent prevButton = new TextLinkComponent("<<", startX, Screen.screenHeight - GameManager.footerHeight - FontRenderer.fontHeight - 6, FontRenderer.fontHeight + 4);

                            // Create >> button
                            TextLinkComponent nextButton = new TextLinkComponent(">>", prevButton.posX + FontRenderer.getTextWidth("<<   "), prevButton.posY, FontRenderer.fontHeight + 4);

                            // Create page input field
                            TextInputComponent pageInput = new TextInputComponent();
                            pageInput.isReadOnly = true;
                            pageInput.setBounds(nextButton.posX + FontRenderer.getTextWidth(">>   "), prevButton.posY - 1, inputWidth, FontRenderer.fontHeight + 3);
                            pageInput.setInputConstraint(1); // Numeric input
                            pageInput.setText(Integer.toString(currentPage));

                            // Create page info label
                            TextComponent pageInfoLabel = new TextComponent(pageInfo, pageInput.posX + pageInput.width, pageInput.posY + 2, FontRenderer.fontHeight + 2);

                            if (packet != null) {
                                // Set IDs and actions
                                int prevButtonId = PacketUtils.readInt(packet);
                                byte[] prevButtonAction = PacketUtils.readBytes(packet);
                                int nextButtonId = PacketUtils.readInt(packet);
                                byte[] nextButtonAction = PacketUtils.readBytes(packet);
                                int inputFieldId = PacketUtils.readInt(packet);
                                byte[] inputFieldAction = PacketUtils.readBytes(packet);

                                prevButton.id = prevButtonId;
                                nextButton.id = nextButtonId;
                                pageInput.id = inputFieldId;

                                prevButton.linkAction = new quyen_ao(prevButtonAction);
                                nextButton.linkAction = new quyen_ap(nextButtonAction);
                                pageInput.middleSoftKey = new ButtonAction("Đến trang", new quyen_aq(pageInput, totalPages, inputFieldAction));
                            }

                            paginationDialog.addComponent(prevButton);
                            paginationDialog.addComponent(nextButton);
                            paginationDialog.addComponent(pageInput);
                            paginationDialog.addComponent(pageInfoLabel);
                            System.gc();
                        }
                        break;
                    /*
                     * Case 48 - Context Menu:
                     * Ý nghĩa: Tạo và hiển thị context menu
                     *
                     * Dữ liệu packet:
                     *     byte: menuType - loại menu
                     *     byte: itemCount - số lượng item trong menu
                     *     [itemCount lần]:
                     *         string: itemText - text hiển thị của item
                     *         bytes: actionData - action data khi click item
                     */
                    case 48:
                        if (contextMenuItems == null) {
                            contextMenuItems = new Vector();
                        } else {
                            contextMenuItems.removeAllElements();
                        }

                        System.gc();
                        byte menuType = packet.getPayload().readByte();
                        byte itemCount = packet.getPayload().readByte();

                        for (int itemIndex = 0; itemIndex < itemCount; itemIndex++) {
                            String itemText = PacketUtils.readString(packet);
                            byte[] actionData = PacketUtils.readBytes(packet);
                            byte itemIndexByte = (byte) itemIndex;
                            ButtonAction buttonAction = new ButtonAction(itemText, new quyen_ar(itemIndexByte, actionData));
                            contextMenuItems.addElement(buttonAction);
                        }

                        if (contextMenu == null) {
                            contextMenu = new ContextMenu(contextMenuItems);
                        }

                        GameManager.instance.showContextMenu(contextMenu, menuType);
                        break;

                    /*
                     * Case 49 - Friend Request:
                     * Ý nghĩa: Gửi yêu cầu kết bạn
                     *
                     * Dữ liệu packet:
                     *     string: friendName - tên người bạn
                     *     long: friendId - ID của người bạn
                     */
                    case 49:
                        String friendName = PacketUtils.readString(packet);
                        PacketUtils.readLong(packet);
                        GameManager.instance.friendScreen.sendFriendRequest(friendName);
                        break;

                    /*
                     * Case 50 - Switch To Dialog Screen:
                     * Ý nghĩa: Chuyển đến màn hình dialog với animation
                     *
                     * Dữ liệu packet:
                     *     int: screenId - ID của screen cần chuyển đến
                     */
                    case 50:
                        int screenId5 = PacketUtils.readInt(packet);
                        DialogScreen dialogScreen = (DialogScreen) GameManager.instance.findScreenById(screenId5);
                        dialogScreen.startSlideAnimation(1);
                        GameManager.instance.switchToScreen(dialogScreen);
                        break;

                    /*
                     * Case 52 - Show Loading:
                     * Ý nghĩa: Hiển thị trạng thái loading
                     */
                    case 52:
                        GameManager.instance.setLoadingState(true);
                        break;

                    /*
                     * Case 53 - Hide Loading:
                     * Ý nghĩa: Ẩn trạng thái loading
                     */
                    case 53:
                        GameManager.instance.setLoadingState(false);
                        break;

                    /*
                     * Case 54 - Photo Viewer:
                     * Ý nghĩa: Tạo và hiển thị màn hình xem ảnh
                     *
                     * Dữ liệu packet:
                     *     int: dialogId - ID của dialog
                     *     string: photoTitle - tiêu đề ảnh
                     *     string: photoCaption - mô tả ảnh
                     *     int: displayMode - chế độ hiển thị
                     *     bytes: imageData - dữ liệu ảnh
                     *     int: photoId - ID của ảnh
                     */
                    case 54:
                        int dialogId5 = PacketUtils.readInt(packet);
                        GameManager.instance.destroyScreen(GameManager.instance.findScreenById(dialogId5));
                        PhotoViewerScreen photoViewerScreen;
                        (photoViewerScreen = new PhotoViewerScreen()).dialogId = dialogId5;
                        photoViewerScreen.setTitle(PacketUtils.readString(packet));
                        photoViewerScreen.setCaption(PacketUtils.readString(packet));
                        photoViewerScreen.photoComponent.displayMode = PacketUtils.readInt(packet);
                        photoViewerScreen.setImageData(PacketUtils.readBytes(packet));
                        photoViewerScreen.photoComponent.id = PacketUtils.readInt(packet);
                        photoViewerScreen.showSaveButton(1);
                        photoViewerScreen.startSlideAnimation(1);
                        GameManager.instance.addScreenToStack(photoViewerScreen);
                        GameManager.instance.switchToLastScreen();
                        break;

                    /*
                     * Case 56 - Show Text Input:
                     * Ý nghĩa: Hiển thị text input dialog
                     *
                     * Dữ liệu packet:
                     *     int: screenId - ID của screen
                     *     int: componentId - ID của text input component
                     */
                    case 56:
                        int inputScreenId = PacketUtils.readInt(packet);
                        int inputComponentId = PacketUtils.readInt(packet);

                        try {
                            Screen targetScreen4 = GameManager.instance.findScreenById(inputScreenId);
                            TextInputComponent textInputComponent = (TextInputComponent) targetScreen4.findComponentByID(inputComponentId);
                            UIUtils.showTextInputPopup(targetScreen4, textInputComponent);
                        } catch (Exception exception) {
                        }
                        break;

                    /*
                     * Case 57 - Layout Components Horizontally:
                     * Ý nghĩa: Sắp xếp các component theo hàng ngang
                     *
                     * Dữ liệu packet:
                     *     int: screenId - ID của screen
                     *     byte: componentCount - số lượng component
                     *     [componentCount lần]: int componentId - ID của từng component
                     */
                    case 57:
                        int layoutScreenId = PacketUtils.readInt(packet);
                        DialogScreen layoutDialogScreen = (DialogScreen) GameManager.instance.findScreenById(layoutScreenId);
                        byte componentCount1;
                        int[] componentIds;
                        (componentIds = new int[componentCount1 = packet.getPayload().readByte()])[0] = PacketUtils.readInt(packet);
                        UIComponent firstComponent;
                        int totalWidth = (firstComponent = layoutDialogScreen.findComponentByID(componentIds[0])).width;

                        for (int componentIndex = 1; componentIndex < componentCount1; componentIndex++) {
                            componentIds[componentIndex] = PacketUtils.readInt(packet);
                            UIComponent currentComponent;
                            (currentComponent = layoutDialogScreen.findComponentByID(componentIds[componentIndex])).posY = firstComponent.posY;
                            totalWidth += currentComponent.width;
                        }

                        layoutDialogScreen.nextComponentY = firstComponent.posY + firstComponent.height + 2;
                        int spacing = (Screen.screenWidth - totalWidth) / (componentCount1 + 1);
                        firstComponent.posX = Screen.screenWidth - (totalWidth + spacing * (componentCount1 - 1)) >> 1;

                        for (int componentIndex = 1; componentIndex < componentCount1; componentIndex++) {
                            firstComponent = layoutDialogScreen.findComponentByID(componentIds[componentIndex]);
                            UIComponent previousComponent = layoutDialogScreen.findComponentByID(componentIds[componentIndex - 1]);
                            firstComponent.posX = previousComponent.posX + previousComponent.width + spacing;
                        }

                        layoutDialogScreen.updateLayout();
                        break;

                    /*
                     * Case 58 - Set Components X Position:
                     * Ý nghĩa: Thiết lập vị trí X cho các component
                     *
                     * Dữ liệu packet:
                     *     int: screenId - ID của screen
                     *     int: xPosition - vị trí x mới
                     *     byte: componentCount - số lượng component
                     *     [componentCount lần]: int componentId - ID của từng component
                     */
                    case 58:
                        DialogScreen xPositionDialogScreen = (DialogScreen) GameManager.instance.findScreenById(PacketUtils.readInt(packet));
                        int xPosition = PacketUtils.readInt(packet);
                        byte xComponentCount = packet.getPayload().readByte();

                        for (int xIndex = 0; xIndex < xComponentCount; xIndex++) {
                            xPositionDialogScreen.findComponentByID(PacketUtils.readInt(packet)).posX = xPosition;
                        }
                        break;

                    /*
                     * Case 59 - Layout Components Vertically:
                     * Ý nghĩa: Sắp xếp các component theo hàng dọc
                     *
                     * Dữ liệu packet:
                     *     int: screenId - ID của screen
                     *     int: anchorComponentId - ID của component làm gốc
                     *     byte: componentCount - số lượng component
                     *     [componentCount lần]: int componentId - ID của từng component
                     */
                    case 59:
                        DialogScreen verticalLayoutScreen;
                        UIComponent anchorComponent = (verticalLayoutScreen = (DialogScreen) GameManager.instance.findScreenById(PacketUtils.readInt(packet))).findComponentByID(PacketUtils.readInt(packet));
                        byte verticalComponentCount = packet.getPayload().readByte();
                        UIComponent lastComponent = null;
                        int[] verticalComponentIds = new int[verticalComponentCount];

                        for (int verticalIndex = 0; verticalIndex < verticalComponentCount; verticalIndex++) {
                            verticalComponentIds[verticalIndex] = PacketUtils.readInt(packet);
                            (lastComponent = verticalLayoutScreen.findComponentByID(verticalComponentIds[verticalIndex])).posX = anchorComponent.posX + anchorComponent.width + 6;
                            if (verticalIndex == 0) {
                                lastComponent.posY = anchorComponent.posY;
                            } else {
                                UIComponent previousVerticalComponent = verticalLayoutScreen.findComponentByID(verticalComponentIds[verticalIndex - 1]);
                                lastComponent.posY = previousVerticalComponent.posY + previousVerticalComponent.height + 2;
                            }
                        }

                        verticalLayoutScreen.nextComponentY = lastComponent.posY + lastComponent.height + 2;
                        verticalLayoutScreen.updateLayout();
                        break;

                    /*
                     * Case 62 - Update Component Properties:
                     * Ý nghĩa: Cập nhật thuộc tính của các component
                     *
                     * Dữ liệu packet:
                     *     int: screenId - ID của screen
                     *     byte: updateCount - số lượng update
                     *     [updateCount lần]:
                     *         int: componentId - ID của component
                     *         byte: updateType - loại update (0=TextInput, 1=Text, 4=TextLink, 7=Dropdown, 11=List, 14=Checkbox, 18=PhotoViewer)
                     *         [data tùy theo updateType]
                     */
                    case 62:
                        int updateScreenId = PacketUtils.readInt(packet);
                        byte updateCount = packet.getPayload().readByte();

                        try {
                            for (int updateIndex = 0; updateIndex < updateCount; updateIndex++) {
                                int updateComponentId = PacketUtils.readInt(packet);
                                int updateType = packet.getPayload().readByte();
                                Screen updateTargetScreen;
                                UIComponent updateComponent = (updateTargetScreen = GameManager.instance.findScreenById(updateScreenId)).findComponentByID(updateComponentId);
                                switch (updateType) {
                                    case 0:
                                        String inputText = PacketUtils.readString(packet);
                                        String displayText = PacketUtils.readString(packet);
                                        ((TextInputComponent) updateComponent).textInputHandler.text = inputText;
                                        ((TextInputComponent) updateComponent).setText(displayText);
                                        break;
                                    case 1:
                                        String newText1 = PacketUtils.readString(packet);
                                        ((TextComponent) updateComponent).updateText(newText1);
                                        break;
                                    case 4:
                                        String linkText = PacketUtils.readString(packet);
                                        byte[] linkActionData = PacketUtils.readBytes(packet);
                                        ((TextLinkComponent) updateComponent).linkText = linkText;
                                        ((TextLinkComponent) updateComponent).setLinkAction(new quyen_ag(linkActionData));
                                        break;
                                    case 7:
                                        short selectedIndex = PacketUtils.readShort(packet);
                                        ((DropdownComponent) updateComponent).setSelectedIndex(selectedIndex);
                                        break;
                                    case 11:
                                        ListComponent listComponent;
                                        BuddyGroupList dataSource = (listComponent = (ListComponent) updateComponent).dataSource;
                                        byte listItemCount = packet.getPayload().readByte();
                                        updateType = 0;

                                        for (; updateType < listItemCount; updateType++) {
                                            String contactName = PacketUtils.readString(packet);
                                            int iconId = PacketUtils.readInt(packet);
                                            byte[] iconData = PacketUtils.readBytes(packet);
                                            Integer iconIdObj = null;
                                            Image iconImage = null;
                                            if (listComponent.getIconType() == 2) {
                                                iconIdObj = new Integer(iconId);
                                            } else {
                                                iconImage = UIUtils.createImageFromBytes(iconData);
                                            }

                                            String displayName = PacketUtils.readString(packet);
                                            String downloadText = PacketUtils.readString(packet);
                                            String description = PacketUtils.readString(packet);
                                            BuddyInfo contact = dataSource.findDownloadFile(null, contactName, 0L);
                                            if (iconId != 0) {
                                                contact.imageSourceId = iconIdObj;
                                            }

                                            if (iconData != null && iconData.length != 0) {
                                                contact.thumbnailImage = iconImage;
                                            }

                                            if (displayName.length() > 0) {
                                                contact.displayName = displayName;
                                            }

                                            if (downloadText.length() > 0) {
                                                contact.description = downloadText;
                                            }

                                            if (description.length() > 0) {
                                                contact.statusDescription = description;
                                            }
                                        }

                                        listComponent.buildListItems();
                                        break;
                                    case 14:
                                        boolean isChecked = PacketUtils.readBoolean(packet);
                                        ((CheckboxComponent) updateComponent).isChecked = isChecked;
                                        break;
                                    case 18:
                                        PhotoViewerScreen photoScreen = (PhotoViewerScreen) updateTargetScreen;
                                        photoScreen.setTitle(PacketUtils.readString(packet));
                                        photoScreen.setCaption(PacketUtils.readString(packet));
                                        photoScreen.photoComponent.displayMode = PacketUtils.readInt(packet);
                                        photoScreen.setImageData(PacketUtils.readBytes(packet));
                                        break;
                                }
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
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

    private static ButtonAction createButtonAction(Packet data) {
        byte[] payload = PacketUtils.readBytes(data);
        return new ButtonAction(PacketUtils.readString(data), new CreateButtonAction(payload));
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
