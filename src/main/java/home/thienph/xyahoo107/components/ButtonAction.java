package home.thienph.xyahoo107.components;

import home.thienph.xyahoo107.actions.Action;
import home.thienph.xyahoo107.actions.quyen_cl;
import home.thienph.xyahoo107.actions.quyen_cm;
import home.thienph.xyahoo107.actions.quyen_cn;
import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.data.game.ContextMenu;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatRoomScreen;
import home.thienph.xyahoo107.screens.DialogScreen;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Image;

public class ButtonAction {
    public String text;
    public Action action;
    public ContextMenu parentContainer;

    public ButtonAction(String text, Action action) {
        this.text = text;
        this.action = action;
    }

    public static TextInputComponent createTextInputPopup(Screen screen, String helpText, int inputConstraint, Action confirmAction) {
        TextInputComponent inputComponent = new TextInputComponent("", inputConstraint);
        inputComponent.setBounds(10, GameGraphics.screenHeight + 1000, Screen.screenWidth - 21, FontRenderer.paragraphSpacing);
        inputComponent.showHelpText(helpText);
        inputComponent.alternateAction = confirmAction;
        inputComponent.isVisible = false;
        inputComponent.leftSoftKey = GameManager.createCloseButton();

        ButtonAction closeButton = new ButtonAction(TextConstant.close(), new quyen_cl(screen, inputComponent));
        inputComponent.rightSoftKey = closeButton;
        inputComponent.onCompleteAction = new quyen_cm(inputComponent, closeButton);
        inputComponent.middleSoftKey = new ButtonAction("OK", new quyen_cn(inputComponent, screen));

        screen.addComponent(inputComponent);
        return inputComponent;
    }

    public static TextInputComponent createTextInput(DialogScreen dialog, String label, int constraint) {
        return createLabeledTextInput(dialog, label, 0, -1);
    }

    public static TextInputComponent createTextInputWithID(DialogScreen dialog, String label, int constraint, int id) {
        TextComponent labelComponent;
        (labelComponent = new TextComponent(label, UIUtils.leftColumnX, dialog.nextComponentY, FontRenderer.fontHeight, -1)).id = -1;

        int currentY = dialog.nextComponentY;
        dialog.addComponent(labelComponent);
        dialog.nextComponentY = currentY - 3;

        TextInputComponent inputField;
        (inputField = new TextInputComponent()).selectedIndex = -1;
        inputField.setBounds(UIUtils.rightColumnX, dialog.nextComponentY, UIUtils.rightColumnWidth, FontRenderer.paragraphSpacing);
        labelComponent.width = FontRenderer.getTextWidth(label) + 5;
        inputField.setInputConstraint(constraint);

        dialog.addComponent(inputField);
        return inputField;
    }

    public static TextInputComponent createLabeledTextInput(DialogScreen dialog, String label, int constraint, int id) {
        TextComponent labelComponent;
        (labelComponent = new TextComponent(label, dialog.dialogX, dialog.nextComponentY, FontRenderer.fontHeight, id)).id = -1;
        dialog.addComponent(labelComponent);

        TextInputComponent inputField;
        (inputField = new TextInputComponent()).selectedIndex = id;
        inputField.setBounds(dialog.dialogX, dialog.nextComponentY, dialog.dialogWidth, FontRenderer.paragraphSpacing);
        inputField.setInputConstraint(constraint);
        inputField.textInputHandler = labelComponent;

        dialog.addComponent(inputField);
        dialog.nextComponentY += 2;
        return inputField;
    }

    public static DropdownComponent createChoiceBox(DialogScreen dialog, String label, String[] options) {
        return createChoiceBoxWithID(dialog, label, options, -1);
    }

    public static DropdownComponent createChoiceBoxWithID(DialogScreen dialog, String label, String[] options, int selectedIndex) {
        TextComponent labelComponent = new TextComponent(label, dialog.dialogX, dialog.nextComponentY, FontRenderer.fontHeight, selectedIndex);
        dialog.addComponent(labelComponent);

        DropdownComponent dropdown;
        (dropdown = new DropdownComponent(options, dialog.dialogX, dialog.nextComponentY, dialog.dialogWidth, FontRenderer.paragraphSpacing))
                .selectedIndex = selectedIndex;
        dropdown.textInputHandler = labelComponent;

        dialog.addComponent(dropdown);
        dialog.nextComponentY += 2;
        return dropdown;
    }

    public static TextComponent createSpacer(DialogScreen dialog, int index) {
        TextComponent spacer;
        (spacer = new TextComponent("", 5, dialog.nextComponentY, 10)).selectedIndex = index;
        spacer.width = Screen.screenWidth - spacer.posX - 5;
        dialog.addComponent(spacer);
        return spacer;
    }

    public static TextComponent createLabel(String text, DialogScreen dialog, int index) {
        if (text.equals("")) {
            return createSpacer(dialog, -1);
        } else {
            TextComponent labelComponent;
            (labelComponent = new TextComponent(text, dialog.dialogX, dialog.nextComponentY, FontRenderer.fontHeight + 2)).selectedIndex = -1;
            dialog.addComponent(labelComponent);
            return labelComponent;
        }
    }

    public static TextComponent[] createWrappedText(String content, DialogScreen dialog, int index, int color, boolean visible, boolean checkEmpty) {
        String[] wrappedLines;
        TextComponent[] textComponents = new TextComponent[(wrappedLines = FontRenderer.wrapTextToLines(content, Screen.screenWidth - 10)).length];

        for (int i = 0; i < wrappedLines.length; i++) {
            textComponents[i] = new TextComponent(wrappedLines[i], 5, dialog.nextComponentY, FontRenderer.fontHeight + 2);
            textComponents[i].selectedIndex = index;
            textComponents[i].isVisible = true;
            textComponents[i].textColor = new Integer(color);
            textComponents[i].isVisible = visible && !content.trim().equals("");
            dialog.addComponent(textComponents[i]);
        }

        return textComponents;
    }

    public static ButtonComponent createButton(DialogScreen dialog, String label, Action action, int posY, int width) {
        int minWidth = FontRenderer.getTextWidth(label) + 20;
        if (width < minWidth) {
            width = minWidth;
        }

        ButtonComponent button;
        (button = new ButtonComponent(label, width, FontRenderer.fontHeight + 10)).posX = Screen.screenWidth - width >> 1;
        button.posY = posY + 3;
        button.buttonAction = action;
        button.middleSoftKey.action = action;

        if (dialog != null) {
            dialog.addComponent(button);
            dialog.nextComponentY += 3;
        }
        return button;
    }

    public static TextLinkComponent createCustomButton(DialogScreen dialog, String label, int index, Action action, int x, int y, int height) {
        TextLinkComponent customButton;
        (customButton = new TextLinkComponent(label, x, y, FontRenderer.fontHeight + 4)).selectedIndex = index;
        customButton.setLinkAction(action);

        if (dialog != null) {
            dialog.addComponent(customButton);
        }

        return customButton;
    }

    public static CheckboxComponent createCheckbox(DialogScreen dialog, String label, boolean checked) {
        int checkboxWidth = FontRenderer.getTextWidth(label) + 13 + 4;
        CheckboxComponent checkbox;
        (checkbox = new CheckboxComponent(label, dialog.dialogX, dialog.nextComponentY, checkboxWidth, FontRenderer.fontHeight + 4)).isChecked = checked;

        if (dialog != null) {
            dialog.addComponent(checkbox);
        }

        return checkbox;
    }

    public static TextComponent[] createSimpleText(DialogScreen dialog, String content) {
        return createWrappedText(content, dialog, -1, 16777215, true, true);
    }

    public static ImageComponent createImageComponent(DialogScreen dialog, int imageId, Image image, int width, int height, boolean visible, boolean hasBorder) {
        ImageComponent imageComponent;
        (imageComponent = new ImageComponent()).setSize(width, height);
        imageComponent.isVisible = visible;

        if (image != null) {
            imageComponent.setCustomImage(image);
        } else {
            imageComponent.setSingleImageId(imageId);
        }

        imageComponent.setPosition(Screen.screenWidth - width >> 1,
                dialog.nextComponentY == 6 ? dialog.nextComponentY : dialog.nextComponentY + 2);
        imageComponent.hasBorder = hasBorder;

        dialog.addComponent(imageComponent);
        dialog.nextComponentY += 2;
        return imageComponent;
    }
}
