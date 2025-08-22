final class quyen_jn implements Action {
   private quyen_jm a;

   quyen_jn(quyen_jm var1) {
      this.a = var1;
   }

   public final void action() {
      StringBuffer var10000 = new StringBuffer("Y! ");
      quyen_jm var1 = this.a;
      String var3 = var10000.append(YahooScreen.getActiveTextInput(this.a.a).getText().trim()).toString();
      ChatScreen var2;
      if ((var2 = (ChatScreen) GameManager.instance.setActiveScreen(var3)) != null) {
         var2.startSlideAnimation(1);
         GameManager.instance.f(var3);
      } else {
         var1 = this.a;
         var2 = new ChatScreen(var3, true, null, YahooScreen.getActiveTextInput(this.a.a).getText().trim());
      }

      var2.startSlideAnimation(1);
      GameManager.instance.addScreenToStack(var2);
      GameManager.instance.f(var2.title);
      System.gc();
   }
}
