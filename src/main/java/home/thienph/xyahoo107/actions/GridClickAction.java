package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.GridComponent;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.processors.GameProcessor;

public final class GridClickAction implements Action {
    private final boolean hasCheckboxes;
    private final GridComponent gridComponent;
    private final boolean[] checkedStates;
    private final byte[] selectActionData;

    public GridClickAction(boolean var1, GridComponent var2, boolean[] var3, byte[] var4) {
        this.hasCheckboxes = var1;
        this.gridComponent = var2;
        this.checkedStates = var3;
        this.selectActionData = var4;
    }

    public void action() {
        if (this.hasCheckboxes) {
            GameManager gameManager = GameManager.instance;
            int selectedItemId = this.gridComponent.getSelectedItemId();
            GridComponent var1 = this.gridComponent;
            gameManager.joinGame(selectedItemId, this.checkedStates[this.gridComponent.selectedRowIndex * var1.columnsPerRow + var1.selectedColumnIndex]);
        } else {
            GameProcessor.processMessage(this.selectActionData);
        }
    }
}
