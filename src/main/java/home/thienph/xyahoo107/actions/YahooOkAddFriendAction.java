package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.components.UIComponent;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.data.media.BuddyGroup;
import home.thienph.xyahoo107.data.media.BuddyInfo;
import home.thienph.xyahoo107.data.media.BuddyGroupList;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;
import home.thienph.xyahoo107.screens.YahooScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class YahooOkAddFriendAction implements Action {
    private final YahooScreen yahooScreen;
    private final TextInputComponent b;
    private final TextInputComponent c;
    private final DialogScreen d;

    public YahooOkAddFriendAction(final YahooScreen yahooScreen, final TextInputComponent b, final TextInputComponent c, final DialogScreen d) {
        this.yahooScreen = yahooScreen;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public void action() {
        final String lowerCase = this.b.getText().trim().toLowerCase();
        String trim = this.c.getText().trim();
        if (lowerCase.equals("")) {
            UIUtils.focusComponent(this.d, (UIComponent) this.b);
            return;
        }
        if (trim.equals("")) {
            UIUtils.focusComponent(this.d, (UIComponent) this.c);
            return;
        }
        final BuddyGroupList a = GameManager.instance.yahooChat.contactList.getContactData();
        final String s = trim;
        final BuddyGroupList buddyGroupList = a;
        int i = a.contactGroups.size() - 1;
        while (true) {
            while (i >= 0) {
                BuddyGroup ContactGroup = (BuddyGroup) buddyGroupList.contactGroups.elementAt(i);
                if (ContactGroup.getGroupName().equalsIgnoreCase(s)) {
                    final String a2;
                    final String s2 = a2 = ContactGroup.getGroupName();
                    final String s3 = a2;
                    if (s2 != null) {
                        trim = s3;
                    }
                    if (GameManager.instance.yahooChat.contactList.getContactData().findDownloadFile(lowerCase, null, 0L) != null) {
                        GameManager.instance.showWrappedTextDialog("ID đã tồn tại.");
                        return;
                    }
                    PacketSender.g(lowerCase, trim);
                    this.yahooScreen.contactList.contactData.addContactToGroup(trim, new BuddyInfo(lowerCase, "", 0, "", new int[0], 0, 0, null));
                    this.yahooScreen.contactList.refreshDisplayList();
                    this.yahooScreen.contactList.resetAnimation();
                    GameManager.instance.removeScreen(this.d);
                    return;
                } else {
                    --i;
                }
            }
            String a2;
            final String s2 = a2 = null;
            continue;
        }
    }
}
