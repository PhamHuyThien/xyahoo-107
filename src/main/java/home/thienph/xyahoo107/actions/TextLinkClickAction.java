package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextLinkComponent;

public final class TextLinkClickAction implements Action {
    private final TextLinkComponent textLinkComponent;

    public TextLinkClickAction(TextLinkComponent var1) {
        this.textLinkComponent = var1;
    }

    public void action() {
        this.textLinkComponent.linkAction.action();
    }
}
