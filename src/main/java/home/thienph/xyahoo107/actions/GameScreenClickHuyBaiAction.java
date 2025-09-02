package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.CardGameComponent;
import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenClickHuyBaiAction implements Action {
    private final GameScreen gameScreen;

    public GameScreenClickHuyBaiAction(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void action() {
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
            this.gameScreen.cardGameComponent.deselectAllCards();
        } else {
            this.gameScreen.cardGameComponent.selectAllCards();
        }
    }
}
