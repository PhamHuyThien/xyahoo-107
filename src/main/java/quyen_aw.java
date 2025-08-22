final class quyen_aw implements Action {
   private final String a;
   private final String b;

   quyen_aw(String var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void action() {
      GameManager.instance.d("Vui lòng chờ");
      Xuka.sendRequest(this.a, this.b, null, null, true);
   }
}
