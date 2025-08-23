package home.thienph.xyahoo107.forms;

import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;

final class VolumeChangeListener implements ItemStateListener {
   private MediaPlayerForm mediaPlayerForm;

   VolumeChangeListener(MediaPlayerForm var1) {
      this.mediaPlayerForm = var1;
   }

   public final void itemStateChanged(Item var1) {
      MediaPlayerForm.getVolumeControl(this.mediaPlayerForm).setLevel(MediaPlayerForm.getVolumeGauge(this.mediaPlayerForm).getValue());
      MediaPlayerForm.getVolumeGauge(this.mediaPlayerForm).setLabel(UIUtils.concatStrings("Âm lượng", " : ", Integer.toString(MediaPlayerForm.getVolumeControl(this.mediaPlayerForm).getLevel()), null));
   }
}
