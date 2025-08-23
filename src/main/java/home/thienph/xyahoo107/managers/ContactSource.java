package home.thienph.xyahoo107.managers;

import home.thienph.xyahoo107.data.media.ContactGroup;
import home.thienph.xyahoo107.data.media.Contact;

import java.util.Vector;

public final class ContactSource {
    public Vector downloadCategories = new Vector();

    public boolean isDownloadExists(String var1, long var2) {
        ContactGroup var5;
        if ((var5 = this.findCategoryById(var1)) != null) {
            int var4 = var5.contacts.size();

            while (--var4 >= 0) {
                if (((Contact) var5.contacts.elementAt(var4)).timestamp == var2) {
                    return true;
                }
            }
        }

        return false;
    }

    public ContactGroup findCategoryById(String var1) {
        int var2 = this.downloadCategories.size();

        while (--var2 >= 0) {
            ContactGroup var3;
            if ((var3 = (ContactGroup) this.downloadCategories.elementAt(var2)).getName().equals(var1)) {
                return var3;
            }
        }

        return null;
    }

    public Contact findDownload(String var1, String var2, long var3) {
        int var5 = this.downloadCategories.size();

        while (--var5 >= 0) {
            ContactGroup var6;
            int var7 = (var6 = (ContactGroup) this.downloadCategories.elementAt(var5)).contacts.size();

            while (--var7 >= 0) {
                Contact var8 = (Contact) var6.contacts.elementAt(var7);
                if (var1 != null) {
                    if (var8.contactId.equals(var1)) {
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

    public void addDownloadToCategory(String var1, Contact var2) {
        for (int var3 = this.downloadCategories.size() - 1; var3 >= 0; var3--) {
            if (((ContactGroup) this.downloadCategories.elementAt(var3)).getName().equals(var1)) {
                ((ContactGroup) this.downloadCategories.elementAt(var3)).addContact(var2);
                return;
            }
        }

        ContactGroup var4;
        (var4 = new ContactGroup(var1)).addContact(var2);
        this.downloadCategories.addElement(var4);
    }

    public void insertDownloadToCategory(String var1, Contact var2) {
        int var3 = this.downloadCategories.size();

        while (--var3 >= 0) {
            if (((ContactGroup) this.downloadCategories.elementAt(var3)).getName().equals(var1)) {
                ((ContactGroup) this.downloadCategories.elementAt(var3)).insertContact(var2, 0);
                return;
            }
        }

        ContactGroup var4;
        (var4 = new ContactGroup(var1)).insertContact(var2, 0);
        this.downloadCategories.insertElementAt(var4, 0);
    }

    private static void cleanupDownloadData(Contact var0) {
        var0.imageBytes = null;
        var0.processedDataArray = null;
        System.gc();
    }

    public void removeDownload(String var1, long var2) {
        for (int var4 = this.downloadCategories.size() - 1; var4 >= 0; var4--) {
            ContactGroup var5;
            for (int var6 = (var5 = (ContactGroup) this.downloadCategories.elementAt(var4)).contacts.size() - 1; var6 >= 0; var6--) {
                Contact var7 = (Contact) var5.contacts.elementAt(var6);
                if (var1 != null) {
                    if (var7.contactId.equals(var1)) {
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
            int var5 = this.downloadCategories.size();

            while (--var5 >= 0) {
                ContactGroup var6;
                if ((var6 = (ContactGroup) this.downloadCategories.elementAt(var5)).getName().equals(var1)) {
                    int var7 = 0;

                    for (int var8 = var6.contacts.size(); var7 < var8; var7++) {
                        Contact var9;
                        if ((var9 = (Contact) var6.contacts.elementAt(var7)).timestamp == var2[var4]) {
                            var9.statusCode = 1;
                            var9.filePath = var3[var4];
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
