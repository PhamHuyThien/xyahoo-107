package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.YahooScreen;

public final class quyen_jg implements Action {
   private YahooScreen a;

   public quyen_jg(YahooScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.performLogin();
   }
}
