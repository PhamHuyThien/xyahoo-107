final class quyen_gp implements Action {
   private PhotoViewerScreen a;

   quyen_gp(PhotoViewerScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.photoComponent = null;
      this.a.imageBytes = null;
      this.a.displayImage = null;
      PhotoViewerScreen.showSaveButton(this.a, null);
   }
}
