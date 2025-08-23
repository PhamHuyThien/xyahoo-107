package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ImageComponent;

public final class quyen_cd implements Action {
    private final ImageComponent a;

    public quyen_cd(ImageComponent var1) {
        this.a = var1;
    }

    public void action() {
        this.a.handlePointerPress(0, 0);
    }
}
