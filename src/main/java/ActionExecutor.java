final class ActionExecutor implements Runnable {
   private final Action action;

   ActionExecutor(FileBrowserList var1, Action var2) {
      this.action = var2;
   }

   public final void run() {
      FileBrowserList.isLoading = true;
      this.action.action();
      FileBrowserList.isLoading = false;
   }
}
