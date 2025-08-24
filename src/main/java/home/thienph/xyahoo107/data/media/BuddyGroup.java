package home.thienph.xyahoo107.data.media;

import java.util.Vector;

public final class BuddyGroup {
    public Vector contacts;
    private final String groupName;
    public int expansionStatus;// (0=collapsed, 1=expanded), 90%

    public BuddyGroup(String var1) {
        this.groupName = var1;
        this.contacts = new Vector();
    }

    public void addContact(BuddyInfo var1) {
        this.contacts.addElement(var1);
    }

    public void insertContact(BuddyInfo var1, int var2) {
        this.contacts.insertElementAt(var1, 0);
    }

    public BuddyInfo findContactById(String var1) {
        int var2 = this.contacts.size();

        while (--var2 >= 0) {
            BuddyInfo var3;
            if ((var3 = (BuddyInfo) this.contacts.elementAt(var2)).username.equals(var1)) {
                return var3;
            }
        }

        return null;
    }

    public String getGroupName() {
        return this.groupName;
    }
}
