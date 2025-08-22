final class quyen_ej implements Action {
   quyen_ej(quyen_ec var1) {
   }

   public final void action() {
      NetworkManager.forceDisconnect = true;
      NetworkManager.forceDisconnect();
   }
}
