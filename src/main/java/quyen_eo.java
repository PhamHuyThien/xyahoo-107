final class quyen_eo implements Action {
   private quyen_ec a;

   quyen_eo(quyen_ec var1) {
      this.a = var1;
   }

   public final void action() {
      for (int var1 = 0; var1 < this.a.componentCount; var1++) {
         UIComponent var2;
         TextComponent var3;
         if ((var2 = (UIComponent)this.a.components.elementAt(var1)) instanceof TextComponent && ((var3 = (TextComponent)var2).text.equals("Xubi ID:") || var3.text.equals("Yahoo! ID:"))) {
            var3.text = this.a.D.getSelectedIndex() == 0 ? "Xubi ID:" : "Yahoo! ID:";
            var3.width = FontRenderer.getTextWidth(var3.text) + 5;
            return;
         }
      }
   }
}
