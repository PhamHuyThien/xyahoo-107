package home.thienph.xyahoo107.managers;

import home.thienph.xyahoo107.data.media.DownloadCategory;
import home.thienph.xyahoo107.data.media.DownloadData;

import java.util.Vector;

public final class DownloadDataManager {
    public Vector downloadCategories = new Vector();

    public boolean isDownloadExists(String var1, long var2) {
        DownloadCategory var5;
        if ((var5 = this.findCategoryById(var1)) != null) {
            int var4 = var5.downloads.size();

            while (--var4 >= 0) {
                if (((DownloadData) var5.downloads.elementAt(var4)).timestamp == var2) {
                    return true;
                }
            }
        }

        return false;
    }

    public DownloadCategory findCategoryById(String var1) {
        int var2 = this.downloadCategories.size();

        while (--var2 >= 0) {
            DownloadCategory var3;
            if ((var3 = (DownloadCategory) this.downloadCategories.elementAt(var2)).getCategoryId().equals(var1)) {
                return var3;
            }
        }

        return null;
    }

    public DownloadData findDownload(String var1, String var2, long var3) {
        int var5 = this.downloadCategories.size();

        while (--var5 >= 0) {
            DownloadCategory var6;
            int var7 = (var6 = (DownloadCategory) this.downloadCategories.elementAt(var5)).downloads.size();

            while (--var7 >= 0) {
                DownloadData var8 = (DownloadData) var6.downloads.elementAt(var7);
                if (var1 != null) {
                    if (var8.downloadId.equals(var1)) {
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

    public void addDownloadToCategory(String var1, DownloadData var2) {
        for (int var3 = this.downloadCategories.size() - 1; var3 >= 0; var3--) {
            if (((DownloadCategory) this.downloadCategories.elementAt(var3)).getCategoryId().equals(var1)) {
                ((DownloadCategory) this.downloadCategories.elementAt(var3)).addDownload(var2);
                return;
            }
        }

        DownloadCategory var4;
        (var4 = new DownloadCategory(var1)).addDownload(var2);
        this.downloadCategories.addElement(var4);
    }

    public void insertDownloadToCategory(String var1, DownloadData var2) {
        int var3 = this.downloadCategories.size();

        while (--var3 >= 0) {
            if (((DownloadCategory) this.downloadCategories.elementAt(var3)).getCategoryId().equals(var1)) {
                ((DownloadCategory) this.downloadCategories.elementAt(var3)).insertDownload(var2, 0);
                return;
            }
        }

        DownloadCategory var4;
        (var4 = new DownloadCategory(var1)).insertDownload(var2, 0);
        this.downloadCategories.insertElementAt(var4, 0);
    }

    private static void cleanupDownloadData(DownloadData var0) {
        var0.imageBytes = null;
        var0.processedDataArray = null;
        System.gc();
    }

    public void removeDownload(String var1, long var2) {
        for (int var4 = this.downloadCategories.size() - 1; var4 >= 0; var4--) {
            DownloadCategory var5;
            for (int var6 = (var5 = (DownloadCategory) this.downloadCategories.elementAt(var4)).downloads.size() - 1; var6 >= 0; var6--) {
                DownloadData var7 = (DownloadData) var5.downloads.elementAt(var6);
                if (var1 != null) {
                    if (var7.downloadId.equals(var1)) {
                        var5.downloads.removeElementAt(var6);
                        cleanupDownloadData(var7);
                    }
                } else if (var7.timestamp == var2) {
                    var5.downloads.removeElementAt(var6);
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
                DownloadCategory var6;
                if ((var6 = (DownloadCategory) this.downloadCategories.elementAt(var5)).getCategoryId().equals(var1)) {
                    int var7 = 0;

                    for (int var8 = var6.downloads.size(); var7 < var8; var7++) {
                        DownloadData var9;
                        if ((var9 = (DownloadData) var6.downloads.elementAt(var7)).timestamp == var2[var4]) {
                            var9.downloadStatus = 1;
                            var9.filePath = var3[var4];
                            if (var4 < var2.length - 1) {
                                var4++;
                            }
                        } else {
                            var9.downloadStatus = 0;
                        }
                    }
                }
            }
        }
    }
}
