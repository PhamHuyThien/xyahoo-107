final class CameraCaptureTask implements Runnable {
   private CameraCanvas cameraCanvas;

   CameraCaptureTask(CameraCanvas var1) {
      this.cameraCanvas = var1;
   }

   public final void run() {
      if (this.cameraCanvas.completionAction != null) {
         this.cameraCanvas.completionAction.action();
      }

      this.cameraCanvas.stopPlayer();
      CameraCanvas.cleanup(this.cameraCanvas);
   }
}
