package home.thienph.xyahoo107.actions;



import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Image;

public final class quyen_ee implements Action {
   public final void action() {
      UIUtils.clearRecordStores(false);
      GameManager.instance.showNotification(UIUtils.concatStrings("Đã xóa", " dữ liệu cá nhân", null, null), (Image)null, 2);
   }
}
