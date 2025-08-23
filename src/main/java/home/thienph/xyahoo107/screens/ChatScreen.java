package home.thienph.xyahoo107.screens;

import home.thienph.xyahoo107.actions.*;
import home.thienph.xyahoo107.components.ChatComponent;
import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.components.UIComponent;
import home.thienph.xyahoo107.components.UIFactory;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.data.game.ContextMenu;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.TextValidator;
import home.thienph.xyahoo107.utils.UIUtils;

import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Graphics;

public final class ChatScreen extends Screen {
   private UIFactory sendButton = new UIFactory(TextConstant.close(), new quyen_hh(this));
   public long chatId;
   private boolean isYahooChat;
   private String yahooContactId;
   public String chatTitle;
   public ChatComponent chatComponent;
   public TextInputComponent textInputComponent;
   private final ContextMenu contextMenu;
   private final Vector menuItems;

   public ChatScreen(String var1, boolean var2, int[] var3, String var4) {
      super.isScrollLocked = true;
      this.isYahooChat = var2;
      super.title = var1;
      this.yahooContactId = var4;
      this.textInputComponent = new TextInputComponent();
      this.textInputComponent.isEnabled = false;
      this.textInputComponent.setBounds(1, screenHeight - GameManager.footerHeight - FontRenderer.paragraphSpacing - 1, screenWidth - 3, FontRenderer.fontHeight + 6);
      this.textInputComponent.rightSoftKey = this.sendButton;
      this.textInputComponent.onCompleteAction = new quyen_hj(this);
      this.chatComponent = new ChatComponent(0, 0, screenWidth, screenHeight - (GameManager.footerHeight + FontRenderer.paragraphSpacing));
      this.addComponent(this.chatComponent);
      this.addComponent(this.textInputComponent);
      UIUtils.focusComponent(this, (UIComponent) this.textInputComponent);
      this.menuItems = new Vector();
      this.menuItems.addElement(new UIFactory("Biểu cảm", new quyen_hk(this)));
      this.menuItems.addElement(new UIFactory("BUZZ!", new quyen_hl(this, var2)));
      if ((var2 ? !GameManager.instance.yahooChat.contactList.hasContact(var4) : !GameManager.instance.friendManager.mainContactList.hasContact(var1)) && !var1.equals(FriendScreen.currentUserId)) {
         this.menuItems.addElement(new UIFactory("Thêm bạn", new quyen_hm(this, var2, var4, var1)));
      }

      if (!var2) {
         this.menuItems.addElement(new UIFactory("Media", new quyen_hn(this, var1)));
         this.menuItems.addElement(new UIFactory("Hồ sơ", new quyen_ho(this, var1)));
      }

      this.menuItems.addElement(new UIFactory("Copy", new quyen_hp(this)));
      this.menuItems.addElement(new UIFactory("Dán", new quyen_hq(this)));
      this.contextMenu = new ContextMenu(this.menuItems);
      super.leftSoftkey = new UIFactory("Menu", new quyen_hi(this));
      super.centerSoftkey = new UIFactory("Chat", null);
      if (GameManager.currentMessage != null) {
         this.chatComponent.addSystemMessage(GameManager.currentMessage, 2);
      }
   }

   public final void setChatId(long var1) {
      this.chatId = var1;
   }

   public final boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      if (var1[16]) {
         var1[16] = false;
         this.textInputComponent.setText(TextValidator.filterBadWords(this.textInputComponent.getText()));
         if (this.textInputComponent.getText().equals("")) {
            String var7;
            int var9;
            if ((var9 = (var7 = this.chatComponent.getSelectedMessage()).indexOf("http://")) >= 0) {
               String var8 = var7.substring(var9);

               try {
                  Xuka.instance.platformRequest(var8);
               } catch (ConnectionNotFoundException var4) {
               }

               return false;
            } else {
               this.textInputComponent.openNativeTextBox();
               return false;
            }
         } else {
            if (this.textInputComponent.getText().equals("plf")) {
               this.chatComponent.addPlayerMessage("", Xuka.platform, 0);
            }

            Object var5 = null;
            if (this.isYahooChat) {
               PacketSender.a((String)(var5 = YahooScreen.yahooUsername), this.yahooContactId, this.textInputComponent.getText(), 2);
            } else {
               PacketSender.a(this.chatId, this.textInputComponent.getText());
            }

            this.chatComponent.addPlayerMessage(this.isYahooChat ? YahooScreen.originalUsername : FriendScreen.currentUserName, this.textInputComponent.getText(), 0);
            this.chatComponent.scrollToBottom();
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

   public final void focusFirstComponent() {
      this.chatComponent.onFocusGained();
   }

   public final void renderSpecialComponent(Graphics var1) {
      this.chatComponent.renderFocusIndicator(var1);
   }

   public static UIFactory getSendButton(ChatScreen var0) {
      return var0.sendButton;
   }

   public static String getYahooContactId(ChatScreen var0) {
      return var0.yahooContactId;
   }

   public static Vector getMenuItems(ChatScreen var0) {
      return var0.menuItems;
   }

   public static ContextMenu getContextMenu(ChatScreen var0) {
      return var0.contextMenu;
   }
}
