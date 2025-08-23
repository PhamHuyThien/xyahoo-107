package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;

final class quyen_ei implements Action {
   quyen_ei(quyen_eh var1) {
   }

   public final void action() {
      GameManager.instance.showWrappedTextDialog("Bạn sẽ nhận mật khẩu qua tin nhắn.");
   }
}
