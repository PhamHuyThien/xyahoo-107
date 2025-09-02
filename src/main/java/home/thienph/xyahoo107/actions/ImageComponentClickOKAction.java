package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ImageComponent;

public final class ImageComponentClickOKAction implements Action {
    private final ImageComponent imageComponent;

    public ImageComponentClickOKAction(ImageComponent var1) {
        this.imageComponent = var1;
    }

    public void action() {
        this.imageComponent.handlePointerPress(0, 0);
    }
}
