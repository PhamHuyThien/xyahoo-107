package home.thienph.xyahoo107.screens;

import home.thienph.xyahoo107.actions.Action;
import home.thienph.xyahoo107.components.*;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Graphics;
import java.util.Vector;

public class Screen {
    private boolean hasSpecialComponent;
    public boolean isActive;
    public static int screenX;
    public static int screenY;
    public static int screenWidth;
    public static int screenHeight;
    public String title;
    public String subtitle = "";
    public Vector components;
    public ButtonAction leftSoftkey;
    public ButtonAction rightSoftkey;
    public ButtonAction centerSoftkey;
    private int selectedIndex;
    public boolean needsUpdate = true;
    public boolean isAnimating;
    public int animationOffset;
    private int animationStep;
    public boolean isScrollLocked;
    public int targetScrollY;
    public int currentScrollY;
    private int scrollVelocity;
    private int scrollAcceleration;
    public int dialogId;
    public boolean showInNavigation = false;
    public int componentCount;
    public boolean isAtBottom = false;
    private String currentLeftText = "";
    private String currentCenterText = "";
    private String currentRightText = "";
    public static int softkeyY;
    private static int keyRepeatCounter = 0;
    private boolean isDragScrolling;
    private int dragStartY;
    private int maxScrollY;

    public final void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
        this.needsUpdate = true;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final void startSlideAnimation(int direction) {
        this.isAnimating = true;
        if (direction == -1) {
            this.animationOffset = screenWidth;
            this.animationStep = -screenWidth >> 2;
        } else {
            this.animationOffset = -screenWidth;
            this.animationStep = screenWidth >> 2;
        }
    }

    public Screen() {
        this.components = new Vector();
        this.setSelectedIndex(-1);
    }

    public void render(Graphics graphics) {
        this.renderBackground(graphics);
        this.renderComponents(graphics);
        graphics.setClip(0, 0, 1000, 1000);
        this.renderSpecialComponent(graphics);
        this.renderSoftkeys(graphics);
    }

    public final void renderSoftkeys(Graphics graphics) {
        graphics.setClip(0, 0, 1000, 1000);
        renderHeader(graphics);
        this.currentLeftText = this.currentCenterText = this.currentRightText = "";
        if (this.leftSoftkey != null) {
            this.currentLeftText = this.leftSoftkey.text;
        }

        if (this.rightSoftkey != null) {
            this.currentCenterText = this.rightSoftkey.text;
        }

        if (this.centerSoftkey != null) {
            this.currentRightText = this.centerSoftkey.text;
        }

        if (this.selectedIndex != -1) {
            UIComponent selectedComponent;
            if ((selectedComponent = (UIComponent) this.components.elementAt(this.selectedIndex)).leftSoftKey != null) {
                this.currentLeftText = selectedComponent.leftSoftKey.text;
            }

            if (selectedComponent.rightSoftKey != null) {
                this.currentCenterText = selectedComponent.rightSoftKey.text;
            }

            if (selectedComponent.middleSoftKey != null) {
                this.currentRightText = selectedComponent.middleSoftKey.text;
            }
        }

        if (this.needsUpdate) {
            this.needsUpdate = false;
            UIUtils.calculateTextPositions(this.currentRightText, this.currentCenterText);
        }

        FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.currentLeftText, 4, softkeyY, graphics);
        FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.currentCenterText, UIUtils.rightTextX, softkeyY, graphics);
        FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.currentRightText, UIUtils.centerTextX, softkeyY, graphics);
    }

    public final void renderComponents(Graphics graphics) {
        for (int componentIndex = 0; componentIndex < this.componentCount; componentIndex++) {
            graphics.setClip(0, screenY, screenWidth, screenHeight - GameManager.footerHeight);
            graphics.translate(0, -this.currentScrollY);
            graphics.translate(0, screenY);
            UIComponent currentComponent;
            if ((currentComponent = (UIComponent) this.components.elementAt(componentIndex)).posY - this.currentScrollY + currentComponent.height > 0 && currentComponent.posY - this.currentScrollY < screenHeight - GameManager.footerHeight - 10) {
                currentComponent.render(graphics);
            }

            graphics.translate(0, -screenY);
            graphics.translate(0, this.currentScrollY);
        }

        graphics.translate(-graphics.getTranslateX(), -graphics.getTranslateY());
    }

    public void renderBackground(Graphics graphics) {
    }

    public void addComponent(UIComponent component) {
        if (!this.components.contains(component)) {
            component.parentScreen = this;
            this.components.addElement(component);
            this.updateLayout();
            if (component instanceof ListComponent || component instanceof GridComponent) {
                this.hasSpecialComponent = true;
            }
        }
    }

    public final void updateLayout() {
        this.componentCount = this.components.size();
        int totalHeight = 0;
        if (this.componentCount > 1) {
            UIComponent lastComponent;
            totalHeight = (lastComponent = (UIComponent) this.components.elementAt(this.componentCount - 1)).posY + lastComponent.height + 6 + GameManager.footerHeight;
        }

        if (totalHeight > screenHeight) {
            ScrollBar.isVisible = true;
            ScrollBar.initialize(this.componentCount);
            this.maxScrollY = totalHeight - screenHeight;
        } else {
            ScrollBar.isVisible = false;
        }
    }

    public void removeComponent(UIComponent component) {
        this.components.removeElement(component);
        this.updateLayout();
    }

    public void removeAllComponents() {
        this.components.removeAllElements();
        this.updateLayout();
    }

    public final void scrollToComponent(int componentIndex) {
        UIComponent targetComponent;
        int componentBottomY = (targetComponent = (UIComponent) this.components.elementAt(componentIndex)).posY + screenY + targetComponent.height;
        if (targetComponent.posY < this.targetScrollY + 6 && this.selectedIndex != 0) {
            this.targetScrollY = targetComponent.posY - (FontRenderer.lineHeight << 1);
            if (this.targetScrollY < 0) {
                this.targetScrollY = 0;
            }
        } else if (componentBottomY > this.targetScrollY + screenHeight + 1 && !this.isAtBottom) {
            this.targetScrollY = componentBottomY - screenHeight + FontRenderer.lineHeight * 3 + 2;
            if (this.targetScrollY > this.maxScrollY) {
                this.targetScrollY = this.maxScrollY;
            }
        } else if (targetComponent.posY < this.currentScrollY) {
            this.targetScrollY = targetComponent.posY - 6;
        }
    }

    public final void updateAnimation() {
        if (this.isAnimating) {
            this.animationOffset = this.animationOffset + this.animationStep;
            if (this.animationOffset < 10 && this.animationOffset > -10) {
                this.isAnimating = false;
            }
        }
    }

    private void selectPreviousComponent() {
        int currentIndex = this.selectedIndex;
        if (!UIUtils.isTextInputWithHelpBox((UIComponent) this.components.elementAt(currentIndex))) {
            UIComponent targetComponent;
            do {
                if (--currentIndex == -1) {
                    currentIndex = this.componentCount - 1;
                }
            } while (UIUtils.isEmptyTextComponent(targetComponent = (UIComponent) this.components.elementAt(currentIndex)) || !targetComponent.isVisible);

            this.selectAndScrollTo(currentIndex);
        }
    }

    private void selectNextComponent() {
        int currentIndex = this.selectedIndex;
        if (!UIUtils.isTextInputWithHelpBox((UIComponent) this.components.elementAt(currentIndex))) {
            UIComponent targetComponent;
            do {
                if (++currentIndex == this.componentCount) {
                    currentIndex = 0;
                }
            } while (UIUtils.isEmptyTextComponent(targetComponent = (UIComponent) this.components.elementAt(currentIndex)) || !targetComponent.isVisible);

            this.selectAndScrollTo(currentIndex);
        }
    }

    private void selectAndScrollTo(int componentIndex) {
        this.setSelectedIndex(componentIndex);
        this.scrollToComponent(componentIndex);
        ScrollBar.setScrolling(true);
    }

    public boolean handleInput(boolean[] keyPressed, boolean[] keyHeld, int[] keyCode) {
        boolean inputHandled = false;
        if (this.currentScrollY != this.targetScrollY) {
            this.scrollAcceleration = this.targetScrollY - this.currentScrollY << 2;
            this.scrollVelocity = this.scrollVelocity + this.scrollAcceleration;
            this.currentScrollY = this.currentScrollY + (this.scrollVelocity >> 4);
            this.scrollVelocity &= 15;
        }

        if (this.selectedIndex != -1) {
            if (keyCode[0] > 0) {
                ((UIComponent) this.components.elementAt(this.selectedIndex)).handleKeyPress(keyCode[0]);
                keyCode[0] = 0;

                for (int i = 0; i < keyPressed.length; i++) {
                    keyPressed[i] = false;
                }

                return false;
            }

            for (int currentKey = 0; currentKey < 21; currentKey++) {
                if (keyHeld[currentKey] && ++keyRepeatCounter > 4) {
                    if (((UIComponent) this.components.elementAt(this.selectedIndex)).handleDirectKeyPress(currentKey)) {
                        if (currentKey == 12) {
                            this.selectPreviousComponent();
                        } else if (currentKey == 13) {
                            this.selectNextComponent();
                        }

                        keyHeld[currentKey] = false;
                    }

                    keyRepeatCounter = 4;
                } else if (keyPressed[currentKey]) {
                    if (((UIComponent) this.components.elementAt(this.selectedIndex)).handleKeyPress(currentKey)) {
                        if (currentKey == 12) {
                            this.selectPreviousComponent();
                        } else if (currentKey == 13) {
                            this.selectNextComponent();
                        } else {
                            Action actionToExecute = null;
                            if (currentKey == 17) {
                                if (this.leftSoftkey != null) {
                                    actionToExecute = this.leftSoftkey.action;
                                }

                                UIComponent selectedComponent;
                                if (this.selectedIndex != -1 && (selectedComponent = (UIComponent) this.components.elementAt(this.selectedIndex)).leftSoftKey != null) {
                                    actionToExecute = selectedComponent.leftSoftKey.action;
                                }
                            } else if (currentKey == 18) {
                                if (this.rightSoftkey != null) {
                                    actionToExecute = this.rightSoftkey.action;
                                }

                                UIComponent selectedComponent;
                                if (this.selectedIndex != -1 && (selectedComponent = (UIComponent) this.components.elementAt(this.selectedIndex)).rightSoftKey != null) {
                                    actionToExecute = selectedComponent.rightSoftKey.action;
                                }
                            } else if (currentKey == 16) {
                                if (this.centerSoftkey != null) {
                                    actionToExecute = this.centerSoftkey.action;
                                }

                                UIComponent selectedComponent;
                                if (this.selectedIndex != -1 && (selectedComponent = (UIComponent) this.components.elementAt(this.selectedIndex)).middleSoftKey != null) {
                                    actionToExecute = selectedComponent.middleSoftKey.action;
                                }
                            }

                            if (actionToExecute != null) {
                                actionToExecute.action();
                            }
                        }

                        inputHandled = true;
                    } else {
                        inputHandled = false;
                    }

                    keyPressed[currentKey] = false;
                }
            }
        }

        int componentIndex = this.componentCount;

        while (--componentIndex >= 0) {
            ((UIComponent) this.components.elementAt(componentIndex)).update();
        }

        return inputHandled;
    }

    public void onPointerPressed(int touchX, int touchY) {
        if (this.isDragScrolling && !this.isScrollLocked) {
            this.isDragScrolling = false;
            this.targetScrollY = this.targetScrollY - (touchY - this.dragStartY) * 5;
        } else {
            int componentIndex = this.components.size();

            while (--componentIndex >= 0) {
                UIComponent currentComponent = (UIComponent) this.components.elementAt(componentIndex);
                if (touchX > currentComponent.posX && touchY + this.currentScrollY > currentComponent.posY && touchX < currentComponent.posX + currentComponent.width && touchY + this.currentScrollY < currentComponent.posY + currentComponent.height) {
                    currentComponent.handlePointerPress(touchX - currentComponent.posX, touchY + this.currentScrollY - currentComponent.posY);
                    return;
                }
            }

            ScrollBar.setScrolling(true);
        }
    }

    public void onPointerDragged(int touchX, int touchY) {
        int componentIndex = this.componentCount;

        while (--componentIndex >= 0) {
            UIComponent currentComponent = (UIComponent) this.components.elementAt(componentIndex);
            if (touchX > currentComponent.posX && touchY + this.currentScrollY > currentComponent.posY && touchX < currentComponent.posX + currentComponent.width && touchY + this.currentScrollY < currentComponent.posY + currentComponent.height && currentComponent.isFocused) {
                currentComponent.handlePointerDrag(touchX - currentComponent.posX, touchY + this.currentScrollY - currentComponent.posY);
                return;
            }
        }

        if (!this.isScrollLocked && ContactListComponent.abs(touchY - this.dragStartY) > 1) {
            this.isDragScrolling = true;
            this.targetScrollY = this.targetScrollY - (touchY - this.dragStartY);
            if (this.targetScrollY < 0) {
                this.targetScrollY = 0;
            } else if (this.targetScrollY > this.maxScrollY) {
                this.targetScrollY = this.maxScrollY;
            }

            this.currentScrollY = this.targetScrollY;
            this.dragStartY = touchY;
        }

        ScrollBar.setScrolling(true);
    }

    public void onPointerReleased(int touchX, int touchY) {
        int componentIndex = this.componentCount;

        while (--componentIndex >= 0) {
            UIComponent currentComponent = (UIComponent) this.components.elementAt(componentIndex);
            if (touchX > currentComponent.posX && touchY + this.currentScrollY > currentComponent.posY && touchX < currentComponent.posX + currentComponent.width && touchY + this.currentScrollY < currentComponent.posY + currentComponent.height && currentComponent.isFocused) {
                currentComponent.handlePointerRelease(touchX - currentComponent.posX, touchY + this.currentScrollY - currentComponent.posY);
                return;
            }
        }

        if (!this.isScrollLocked) {
            this.dragStartY = touchY;
        }
    }

    public final void onPointerMoved(int touchX, int touchY) {
        if (!this.isScrollLocked) {
            this.dragStartY = touchY;
        }
    }

    public static void renderHeader(Graphics graphics) {
        if (FontRenderer.isCustomFontEnabled) {
            graphics.drawImage(GameManager.headerImage, 0, screenHeight + 2, 20);
        }
    }

    public UIComponent findComponentByID(int componentId) {
        int componentIndex = this.componentCount;

        while (--componentIndex >= 0) {
            UIComponent currentComponent;
            if ((currentComponent = (UIComponent) this.components.elementAt(componentIndex)).id == componentId) {
                return currentComponent;
            }
        }

        return null;
    }

    public void focusFirstComponent() {
        if (this.componentCount > 0 && this.hasSpecialComponent && ((UIComponent) this.components.elementAt(0)).isPressed) {
            ((UIComponent) this.components.elementAt(0)).onFocusGained();
        }
    }

    public void renderSpecialComponent(Graphics graphics) {
        if (this.componentCount > 0 && this.hasSpecialComponent && ((UIComponent) this.components.elementAt(0)).isPressed) {
            ((UIComponent) this.components.elementAt(0)).renderFocusIndicator(graphics);
        } else {
            ScrollBar.render(graphics, this.selectedIndex);
        }
    }
}