import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Graphics;

public final class quyen_p extends DialogScreen {
   public String a;
   private boolean D;
   public ChatComponent b;
   TextInputComponent c;
   public boolean d = true;
   private final ContextMenu E;
   private final Vector F;
   private UIFactory G = new UIFactory(quyen_cr.c(), new quyen_q(this));

   public quyen_p(String var1, String var2, boolean var3) {
      super.isScrollLocked = true;
      super.title = var1;
      this.a = var2;
      this.D = var3;
      this.c = new TextInputComponent();
      this.c.isEnabled = false;
      this.c.setBounds(1, Screen.screenHeight - GameManager.footerHeight - FontRenderer.paragraphSpacing - 1, Screen.screenWidth - 3, FontRenderer.fontHeight + 6);
      this.c.rightSoftKey = this.G;
      this.c.onCompleteAction = new quyen_y(this);
      UIFactory.createWrappedText(UIUtils.concatStrings("Chào mừng bạn vào ", var1, null, null), this, -1, 16777215, false, true);
      this.b = new ChatComponent(0, 0, Screen.screenWidth, Screen.screenHeight - (GameManager.footerHeight + FontRenderer.paragraphSpacing));
      this.addComponent(this.c);
      UIUtils.focusComponent(this, (UIComponent)this.c);
      this.F = new Vector();
      this.F.addElement(new UIFactory("Biểu cảm", new quyen_z(this)));
      this.F.addElement(new UIFactory("Copy", new quyen_aa(this)));
      this.F.addElement(new UIFactory("Dán", new quyen_ab(this)));
      this.F.addElement(new UIFactory("Bạn trong phòng", new quyen_ac(this)));
      if (this.D) {
         UIFactory var4 = new UIFactory("Chức năng khác", null);
         Vector var5;
         (var5 = new Vector()).addElement(new UIFactory("Mời bạn chat", new quyen_ad(this)));
         var5.addElement(new UIFactory("Đá khỏi phòng", new quyen_ae(this)));
         var5.addElement(new UIFactory("Đổi tên phòng", new quyen_r(this)));
         var5.addElement(new UIFactory("Đổi mật khẩu", new quyen_s(this)));
         var5.addElement(new UIFactory("Gia hạn phòng", new quyen_t(this)));
         var5.addElement(new UIFactory("Xóa phòng", new quyen_u(this)));
         var4.parentContainer = new ContextMenu(var5);
         this.F.addElement(var4);
      }

      this.E = new ContextMenu(this.F);
      super.leftSoftkey = new UIFactory("Menu", new quyen_w(this));
      super.centerSoftkey = new UIFactory("Chat", null);
   }

   public final void a() {
      this.removeAllComponents();
      this.addComponent(this.b);
      this.addComponent(this.c);
      UIUtils.focusComponent(this, (UIComponent)this.c);
      this.d = false;
   }

   public final boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      if (var1[16]) {
         var1[16] = false;
         this.c.setText(quyen_hs.b(this.c.getText()));
         if (this.c.getText().equals("")) {
            String var5;
            int var7;
            if ((var7 = (var5 = this.b.getFullSelectedMessage()).indexOf("http://")) >= 0) {
               String var6 = var5.substring(var7);

               try {
                  Xuka.instance.platformRequest(var6);
               } catch (ConnectionNotFoundException var4) {
               }

               return false;
            } else {
               this.c.openNativeTextBox();
               return false;
            }
         } else {
            quyen_a.a(this.a, this.c.getText());
            this.c.setText("");
            return false;
         }
      } else if (var1[12] || var2[12]) {
         var1[12] = false;
         this.b.handleDirectKeyPress(12);
         return false;
      } else if (!var1[13] && !var2[13]) {
         return super.handleInput(var1, var2, var3);
      } else {
         var1[13] = false;
         this.b.handleDirectKeyPress(13);
         return false;
      }
   }

   public final void focusFirstComponent() {
      this.b.onFocusGained();
   }

   public final void renderSpecialComponent(Graphics var1) {
      this.b.renderFocusIndicator(var1);
   }

   static UIFactory a(quyen_p var0) {
      return var0.G;
   }

   static ContextMenu b(quyen_p var0) {
      return var0.E;
   }
}
