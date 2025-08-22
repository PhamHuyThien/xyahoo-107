import java.util.Vector;

final class quyen_ii implements Action {
   private FriendScreen a;
   private final ListComponent b;

   quyen_ii(FriendScreen var1, ListComponent var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void action() {
      String var1 = this.b.getSelectedItem().c;
      long var2 = this.b.getSelectedItem().m;
      Vector var4 = (Vector)this.a.offlineMessages.get(var1);
      this.a.offlineMessages.remove(var1);
      GameManager.instance.a(var1, var4, var2);
      this.b.dataSource.removeDownload(var1, 0L);
      this.b.buildListItems();
      this.a.updateOfflineMessageButton();
   }
}
