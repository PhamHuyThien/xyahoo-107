package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;

public final class quyen_c implements Action {
    private final ContactListComponent a;

    public quyen_c(ContactListComponent var1) {
        this.a = var1;
    }

    public void action() {
        String var1 = this.a.isChatMode ? "Y! " + ContactListComponent.getSelectedItem(this.a).groupName : ContactListComponent.getSelectedItem(this.a).groupName;
        ChatScreen var2;
        if ((var2 = (ChatScreen) GameManager.instance.setActiveScreen(var1)) != null) {
            var2.startSlideAnimation(1);
            GameManager.instance.switchToScreenByTitle(var1);
        } else {
            if (this.a.isChatMode) {
                var2 = new ChatScreen(var1, this.a.isChatMode, null, ContactListComponent.getSelectedItem(this.a).groupName);
            } else {
                (var2 = new ChatScreen(var1, this.a.isChatMode, ContactListComponent.getSelectedItem(this.a).rawData, null)).chatTitle = ContactListComponent.getSelectedItem(this.a).displayName.equals("") ? ContactListComponent.getSelectedItem(this.a).groupName : ContactListComponent.getSelectedItem(this.a).displayName;
                var2.setChatId(ContactListComponent.getSelectedItem(this.a).timestamp);
                GameManager.instance.friendManager.addToFavorites(ContactListComponent.getSelectedItem(this.a).timestamp);
            }

            var2.startSlideAnimation(1);
            GameManager.instance.addScreenToStack(var2);
            GameManager.instance.switchToScreenByTitle(var2.title);
        }
    }
}
