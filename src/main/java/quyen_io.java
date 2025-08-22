final class quyen_io implements Action
{
   private FriendScreen a;
   private final DialogScreen b;

   quyen_io(final FriendScreen a, final DialogScreen b) {
      this.a = a;
      this.b = b;
   }

   public final void action() {
      GameManager.instance.removeScreen(this.b);
      FriendScreen.setActiveTextInput(this.a, (TextInputComponent)null);
      System.gc();
   }
}
