package home.thienph.xyahoo107.screens;

import home.thienph.xyahoo107.actions.*;
import home.thienph.xyahoo107.components.ChatComponent;
import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.components.UIComponent;
import home.thienph.xyahoo107.components.ButtonAction;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.data.game.ContextMenu;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.TextValidator;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Graphics;
import java.util.Vector;

public final class ChatRoomScreen extends DialogScreen {
    public String roomId;
    private final boolean isRoomOwner;
    public ChatComponent chatComponent;
    public TextInputComponent textInputComponent;
    public boolean showWelcomeMessage = true;
    private final ContextMenu contextMenu;
    private final Vector menuActions;
    private final ButtonAction backSoftkey = new ButtonAction(TextConstant.close(), new ChatRoomClickLeaveRoomAction(this));

    public ChatRoomScreen(String var1, String var2, boolean var3) {
        super.isScrollLocked = true;
        super.title = var1;
        this.roomId = var2;
        this.isRoomOwner = var3;
        this.textInputComponent = new TextInputComponent();
        this.textInputComponent.isEnabled = false;
        this.textInputComponent.setBounds(1, screenHeight - GameManager.footerHeight - FontRenderer.paragraphSpacing - 1, screenWidth - 3, FontRenderer.fontHeight + 6);
        this.textInputComponent.rightSoftKey = this.backSoftkey;
        this.textInputComponent.onCompleteAction = new quyen_y(this);
        ButtonAction.createWrappedText(UIUtils.concatStrings("Chào mừng bạn vào ", var1, null, null), this, -1, 16777215, false, true);
        this.chatComponent = new ChatComponent(0, 0, screenWidth, screenHeight - (GameManager.footerHeight + FontRenderer.paragraphSpacing));
        this.addComponent(this.textInputComponent);
        UIUtils.focusComponent(this, (UIComponent) this.textInputComponent);
        this.menuActions = new Vector();
        this.menuActions.addElement(new ButtonAction("Biểu cảm", new ChatRoomClickEmojiAction(this)));
        this.menuActions.addElement(new ButtonAction("Copy", new ChatRoomClickCopyAction(this)));
        this.menuActions.addElement(new ButtonAction("Dán", new ChatRoomClickPasteAction(this)));
        this.menuActions.addElement(new ButtonAction("Bạn trong phòng", new ChatRoomViewUserInRoomAction(this)));
        if (this.isRoomOwner) {
            ButtonAction var4 = new ButtonAction("Chức năng khác", null);
            Vector var5;
            (var5 = new Vector()).addElement(new ButtonAction("Mời bạn chat", new ChatRoomInviteUserAction(this)));
            var5.addElement(new ButtonAction("Đá khỏi phòng", new ChatRoomKickUserAction(this)));
            var5.addElement(new ButtonAction("Đổi tên phòng", new ChatRoomChangeNameRoomAction(this)));
            var5.addElement(new ButtonAction("Đổi mật khẩu", new ChatRoomChangePasswordRoomAction(this)));
            var5.addElement(new ButtonAction("Gia hạn phòng", new ChatRoomExtendRoomAction(this)));
            var5.addElement(new ButtonAction("Xóa phòng", new ChatRoomDeleteRoomAction(this)));
            var4.parentContainer = new ContextMenu(var5);
            this.menuActions.addElement(var4);
        }

        this.contextMenu = new ContextMenu(this.menuActions);
        super.leftSoftkey = new ButtonAction("Menu", new ChatRoomClickMenuAction(this));
        super.centerSoftkey = new ButtonAction("Chat", null);
    }

    public void hideWelcomeAndShowChat() {
        this.removeAllComponents();
        this.addComponent(this.chatComponent);
        this.addComponent(this.textInputComponent);
        UIUtils.focusComponent(this, (UIComponent) this.textInputComponent);
        this.showWelcomeMessage = false;
    }

    public boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
        if (var1[16]) {
            var1[16] = false;
            this.textInputComponent.setText(TextValidator.filterBadWords(this.textInputComponent.getText()));
            if (this.textInputComponent.getText().equals("")) {
                String var5;
                int var7;
                if ((var7 = (var5 = this.chatComponent.getFullSelectedMessage()).indexOf("http://")) >= 0) {
                    String var6 = var5.substring(var7);

                    try {
                        Xuka.instance.platformRequest(var6);
                    } catch (ConnectionNotFoundException var4) {
                    }

                    return false;
                } else {
                    this.textInputComponent.openNativeTextBox();
                    return false;
                }
            } else {
                PacketSender.requestSendDataUIComponent(this.roomId, this.textInputComponent.getText());
                this.textInputComponent.setText("");
                return false;
            }
        } else if (var1[12] || var2[12]) {
            var1[12] = false;
            this.chatComponent.handleDirectKeyPress(12);
            return false;
        } else if (!var1[13] && !var2[13]) {
            return super.handleInput(var1, var2, var3);
        } else {
            var1[13] = false;
            this.chatComponent.handleDirectKeyPress(13);
            return false;
        }
    }

    public void focusFirstComponent() {
        this.chatComponent.onFocusGained();
    }

    public void renderSpecialComponent(Graphics var1) {
        this.chatComponent.renderFocusIndicator(var1);
    }

    public static ButtonAction getBackSoftkey(ChatRoomScreen var0) {
        return var0.backSoftkey;
    }

    public static ContextMenu getContextMenu(ChatRoomScreen var0) {
        return var0.contextMenu;
    }
}
