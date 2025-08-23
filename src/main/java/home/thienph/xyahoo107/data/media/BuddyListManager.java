package home.thienph.xyahoo107.data.media;

import java.util.Vector;

public final class BuddyListManager {
    public Vector contactGroups = new Vector();

    public boolean isDownloadExists(String var1, long var2) {
        BuddyGroup var5;
        if ((var5 = this.findBuddyContactByName(var1)) != null) {
            int var4 = var5.contacts.size();

            while (--var4 >= 0) {
                if (((BuddyContact) var5.contacts.elementAt(var4)).timestamp == var2) {
                    return true;
                }
            }
        }

        return false;
    }

    public BuddyGroup findBuddyContactByName(String var1) {
        int var2 = this.contactGroups.size();

        while (--var2 >= 0) {
            BuddyGroup var3;
            if ((var3 = (BuddyGroup) this.contactGroups.elementAt(var2)).getGroupName().equals(var1)) {
                return var3;
            }
        }

        return null;
    }

    public BuddyContact findDownloadFile(String var1, String var2, long var3) {
        int var5 = this.contactGroups.size();

        while (--var5 >= 0) {
            BuddyGroup var6;
            int var7 = (var6 = (BuddyGroup) this.contactGroups.elementAt(var5)).contacts.size();

            while (--var7 >= 0) {
                BuddyContact var8 = (BuddyContact) var6.contacts.elementAt(var7);
                if (var1 != null) {
                    if (var8.username.equals(var1)) {
                        return var8;
                    }
                } else if (var2 != null) {
                    if (var8.fileName.equals(var2)) {
                        return var8;
                    }
                } else if (var8.timestamp == var3) {
                    return var8;
                }
            }
        }

        return null;
    }

    public void addContactToGroup(String var1, BuddyContact var2) {
        for (int var3 = this.contactGroups.size() - 1; var3 >= 0; var3--) {
            if (((BuddyGroup) this.contactGroups.elementAt(var3)).getGroupName().equals(var1)) {
                ((BuddyGroup) this.contactGroups.elementAt(var3)).addContact(var2);
                return;
            }
        }

        BuddyGroup var4;
        (var4 = new BuddyGroup(var1)).addContact(var2);
        this.contactGroups.addElement(var4);
    }

    public void insertContactToGroup(String var1, BuddyContact var2) {
        int var3 = this.contactGroups.size();

        while (--var3 >= 0) {
            if (((BuddyGroup) this.contactGroups.elementAt(var3)).getGroupName().equals(var1)) {
                ((BuddyGroup) this.contactGroups.elementAt(var3)).insertContact(var2, 0);
                return;
            }
        }

        BuddyGroup var4;
        (var4 = new BuddyGroup(var1)).insertContact(var2, 0);
        this.contactGroups.insertElementAt(var4, 0);
    }

    private static void cleanupDownloadData(BuddyContact var0) {
        var0.imageBytes = null;
        var0.processedDataArray = null;
        System.gc();
    }

    public void removeContact(String var1, long var2) {
        for (int var4 = this.contactGroups.size() - 1; var4 >= 0; var4--) {
            BuddyGroup var5;
            for (int var6 = (var5 = (BuddyGroup) this.contactGroups.elementAt(var4)).contacts.size() - 1; var6 >= 0; var6--) {
                BuddyContact var7 = (BuddyContact) var5.contacts.elementAt(var6);
                if (var1 != null) {
                    if (var7.username.equals(var1)) {
                        var5.contacts.removeElementAt(var6);
                        cleanupDownloadData(var7);
                    }
                } else if (var7.timestamp == var2) {
                    var5.contacts.removeElementAt(var6);
                    cleanupDownloadData(var7);
                }
            }
        }
    }

    public void updateDownloadStatus(String var1, long[] var2, String[] var3) {
        if (var2.length != 0) {
            int var4 = 0;
            int var5 = this.contactGroups.size();

            while (--var5 >= 0) {
                BuddyGroup var6;
                if ((var6 = (BuddyGroup) this.contactGroups.elementAt(var5)).getGroupName().equals(var1)) {
                    int var7 = 0;

                    for (int var8 = var6.contacts.size(); var7 < var8; var7++) {
                        BuddyContact var9;
                        if ((var9 = (BuddyContact) var6.contacts.elementAt(var7)).timestamp == var2[var4]) {
                            var9.statusCode = 1;
                            var9.downloadText = var3[var4];
                            if (var4 < var2.length - 1) {
                                var4++;
                            }
                        } else {
                            var9.statusCode = 0;
                        }
                    }
                }
            }
        }
    }
}
