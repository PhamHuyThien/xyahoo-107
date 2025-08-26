package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;

public final class ContactListClickChatAction implements Action {
    private final ContactListComponent contactListComponent;

    public ContactListClickChatAction(ContactListComponent var1) {
        this.contactListComponent = var1;
    }

    public void action() {
        String var1 = this.contactListComponent.isChatMode ? "Y! " + ContactListComponent.getSelectedItem(this.contactListComponent).groupName : ContactListComponent.getSelectedItem(this.contactListComponent).groupName;
        ChatScreen var2;
        if ((var2 = (ChatScreen) GameManager.instance.setActiveScreen(var1)) != null) {
            var2.startSlideAnimation(1);
            GameManager.instance.switchToScreenByTitle(var1);
        } else {
            if (this.contactListComponent.isChatMode) {
                var2 = new ChatScreen(var1, this.contactListComponent.isChatMode, null, ContactListComponent.getSelectedItem(this.contactListComponent).groupName);
            } else {
                (var2 = new ChatScreen(var1, this.contactListComponent.isChatMode, ContactListComponent.getSelectedItem(this.contactListComponent).rawData, null)).chatTitle = ContactListComponent.getSelectedItem(this.contactListComponent).displayName.equals("") ? ContactListComponent.getSelectedItem(this.contactListComponent).groupName : ContactListComponent.getSelectedItem(this.contactListComponent).displayName;
                var2.setChatId(ContactListComponent.getSelectedItem(this.contactListComponent).contactId);
                GameManager.instance.friendScreen.addToFavorites(ContactListComponent.getSelectedItem(this.contactListComponent).contactId);
            }

            var2.startSlideAnimation(1);
            GameManager.instance.addScreenToStack(var2);
            GameManager.instance.switchToScreenByTitle(var2.title);
        }
    }
}
