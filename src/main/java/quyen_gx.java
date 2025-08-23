final class quyen_gx implements Action {
   quyen_gx(RegistrationScreen var1) {
   }

   public final void action() {
      NetworkManager.forceDisconnect = true;
      NetworkManager.forceDisconnect();
   }
}
