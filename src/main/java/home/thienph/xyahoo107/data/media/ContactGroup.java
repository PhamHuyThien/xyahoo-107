package home.thienph.xyahoo107.data.media;

import java.util.Vector;

public final class ContactGroup {
    public Vector contacts;
    private final String name;
    public int status;// (0=collapsed, 1=expanded), 90%

    public ContactGroup(String var1) {
        this.name = var1;
        this.contacts = new Vector();
    }

    public void addContact(Contact var1) {
        this.contacts.addElement(var1);
    }

    public void insertContact(Contact var1, int var2) {
        this.contacts.insertElementAt(var1, 0);
    }

    public Contact findContactById(String var1) {
        int var2 = this.contacts.size();

        while (--var2 >= 0) {
            Contact var3;
            if ((var3 = (Contact) this.contacts.elementAt(var2)).contactId.equals(var1)) {
                return var3;
            }
        }

        return null;
    }

    public String getName() {
        return this.name;
    }
}
