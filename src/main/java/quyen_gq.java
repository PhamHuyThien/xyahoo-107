final class quyen_gq implements Action {
   private PhotoViewerScreen a;

   quyen_gq(PhotoViewerScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.instance.a(this.a.title, this.a.imageBytes, (byte)0);
      GameManager.instance.startFileSend();
   }
}
