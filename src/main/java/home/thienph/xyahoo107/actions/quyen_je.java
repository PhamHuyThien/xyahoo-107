package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.components.UIComponent;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.data.media.ContactGroup;
import home.thienph.xyahoo107.data.media.Contact;
import home.thienph.xyahoo107.managers.ContactSource;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;
import home.thienph.xyahoo107.screens.YahooScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class quyen_je implements Action {
    private final YahooScreen a;
    private final TextInputComponent b;
    private final TextInputComponent c;
    private final DialogScreen d;

    public quyen_je(final YahooScreen a, final TextInputComponent b, final TextInputComponent c, final DialogScreen d) {
        this.a = a;
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
        final ContactSource a = GameManager.instance.yahooChat.contactList.getContactData();
        final String s = trim;
        final ContactSource ContactSource = a;
        int i = a.downloadCategories.size() - 1;
        while (true) {
            while (i >= 0) {
                ContactGroup ContactGroup = (ContactGroup) ContactSource.downloadCategories.elementAt(i);
                if (ContactGroup.getName().equalsIgnoreCase(s)) {
                    final String a2;
                    final String s2 = a2 = ContactGroup.getName();
                    final String s3 = a2;
                    if (s2 != null) {
                        trim = s3;
                    }
                    if (GameManager.instance.yahooChat.contactList.getContactData().findDownload(lowerCase, null, 0L) != null) {
                        GameManager.instance.showWrappedTextDialog("ID đã tồn tại.");
                        return;
                    }
                    PacketSender.g(lowerCase, trim);
                    this.a.contactList.contactData.addDownloadToCategory(trim, new Contact(lowerCase, "", 0, "", new int[0], 0, 0, null));
                    this.a.contactList.refreshDisplayList();
                    this.a.contactList.resetAnimation();
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
