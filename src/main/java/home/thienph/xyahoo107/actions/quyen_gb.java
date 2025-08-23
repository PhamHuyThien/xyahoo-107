package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_gb implements Action {
   public quyen_gb(GameManager var1) {
   }

   public final void action() {
      Xuka.shutdown();
   }
}
