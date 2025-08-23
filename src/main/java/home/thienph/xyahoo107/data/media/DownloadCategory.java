package home.thienph.xyahoo107.data.media;

import java.util.Vector;

public final class DownloadCategory {
    public Vector downloads;
    private final String categoryId;
    public int categoryType;

    public DownloadCategory(String var1) {
        this.categoryId = var1;
        this.downloads = new Vector();
    }

    public void addDownload(DownloadData var1) {
        this.downloads.addElement(var1);
    }

    public void insertDownload(DownloadData var1, int var2) {
        this.downloads.insertElementAt(var1, 0);
    }

    public DownloadData findDownloadById(String var1) {
        int var2 = this.downloads.size();

        while (--var2 >= 0) {
            DownloadData var3;
            if ((var3 = (DownloadData) this.downloads.elementAt(var2)).downloadId.equals(var1)) {
                return var3;
            }
        }

        return null;
    }

    public String getCategoryId() {
        return this.categoryId;
    }
}
