package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.CardGameComponent;
import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_dr implements Action {
   private GameScreen a;

   public quyen_dr(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      int var1 = 0;

      boolean var10000;
      while (true) {
         if (var1 >= CardGameComponent.handCardCount) {
            var10000 = false;
            break;
         }

         if (CardGameComponent.handCards[var1].isSelected) {
            var10000 = true;
            break;
         }

         var1++;
      }

      if (var10000) {
         this.a.cardGameComponent.deselectAllCards();
      } else {
         this.a.cardGameComponent.selectAllCards();
      }
   }
}
