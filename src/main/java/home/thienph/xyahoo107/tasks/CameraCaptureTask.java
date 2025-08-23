package home.thienph.xyahoo107.tasks;

import home.thienph.xyahoo107.canvas.CameraCanvas;

public final class CameraCaptureTask implements Runnable {
    private final CameraCanvas cameraCanvas;

    public CameraCaptureTask(CameraCanvas var1) {
        this.cameraCanvas = var1;
    }

    public void run() {
        if (this.cameraCanvas.completionAction != null) {
            this.cameraCanvas.completionAction.action();
        }

        this.cameraCanvas.stopPlayer();
        CameraCanvas.cleanup(this.cameraCanvas);
    }
}
