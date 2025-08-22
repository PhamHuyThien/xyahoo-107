import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;

final class quyen_hu implements ItemStateListener {
   private quyen_ht a;

   quyen_hu(quyen_ht var1) {
      this.a = var1;
   }

   public final void itemStateChanged(Item var1) {
      quyen_ht.a(this.a).setLevel(quyen_ht.b(this.a).getValue());
      quyen_ht.b(this.a).setLabel(UIUtils.concatStrings("Âm lượng", " : ", Integer.toString(quyen_ht.a(this.a).getLevel()), null));
   }
}
