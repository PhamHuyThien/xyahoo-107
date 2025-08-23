import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;

final class quyen_hu implements ItemStateListener {
   private MediaPlayerForm a;

   quyen_hu(MediaPlayerForm var1) {
      this.a = var1;
   }

   public final void itemStateChanged(Item var1) {
      MediaPlayerForm.getVolumeControl(this.a).setLevel(MediaPlayerForm.getVolumeGauge(this.a).getValue());
      MediaPlayerForm.getVolumeGauge(this.a).setLabel(UIUtils.concatStrings("Âm lượng", " : ", Integer.toString(MediaPlayerForm.getVolumeControl(this.a).getLevel()), null));
   }
}
