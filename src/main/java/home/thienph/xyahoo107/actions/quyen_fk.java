package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.data.media.Contact;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;

public final class quyen_fk implements Action {
    private final GameManager a;
    private final TextInputComponent b;
    private final String c;
    private final DialogScreen d;

    public quyen_fk(GameManager var1, TextInputComponent var2, String var3, DialogScreen var4) {
        this.a = var1;
        this.b = var2;
        this.c = var3;
        this.d = var4;
    }

    public void action() {
        if (!this.b.getText().equals("")) {
            Contact var1 = new Contact(this.c, "", 0, "", new int[0], 0, 0, null);
            PacketSender.a(this.c, this.b.getText(), (byte) 1);
            if (this.a.yahooChat.contactList.getContactData().findDownload(this.c, null, 0L) == null) {
                this.a.yahooChat.contactList.getContactData().addDownloadToCategory(this.b.getText(), var1);
                this.a.yahooChat.contactList.refreshDisplayList();
                this.a.yahooChat.contactList.resetAnimation();
            }

            this.a.removeScreen(this.d);
        }
    }
}
