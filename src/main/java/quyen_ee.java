import javax.microedition.lcdui.Image;

final class quyen_ee implements Action {
   public final void action() {
      UIUtils.clearRecordStores(false);
      GameManager.instance.showNotification(UIUtils.concatStrings("Đã xóa", " dữ liệu cá nhân", null, null), (Image)null, 2);
   }
}
