package home.thienph.xyahoo107.tasks;

import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.processors.GameProcessor;

public final class ProcessDataTask implements Runnable {
    private final byte[] payload;

    public ProcessDataTask(GameManager var1, byte[] var2) {
        this.payload = var2;
    }

    public void run() {
        GameProcessor.processMessage(this.payload);
        System.gc();
    }
}
