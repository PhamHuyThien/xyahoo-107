import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Graphics;

public final class ContactListComponent extends UIComponent {
   public boolean isChatMode;
   public boolean isFilterActive;
   public boolean isLoading;
   private String searchKeyword;
   private boolean isSearching;
   private int targetScrollY;
   private int scrollVelocity;
   private int scrollAcceleration;
   private int currentScrollY;
   private int maxScrollY;
   private Vector requestedContacts;
   private int itemHeight;
   private int firstVisibleIndex;
   private int visibleItemCount;
   public int contactSelectedIndex;
   private UIFactory selectAction = new UIFactory("Chọn", null);
   private UIFactory emptyAction = new UIFactory("", null);
   private UIFactory multiSelectAction = new UIFactory("Chọn", null);
   private boolean isMultiSelectMode = false;
   public DownloadDataManager contactData;
   public Vector displayItems;
   public String[] emptyMessageLines;
   private int avatarAreaX;
   private int avatarAreaY;
   private int totalItemCount;
   private quyen_bj selectedItem;
   private UIFactory chatAction;
   private ContextMenu contextMenu;
   private int lastVisibleIndex;
   private int itemCountLimit;
   private int itemSpacing;
   private boolean needsTextAnimation;
   private boolean animationDirection;
   private int textAnimationX;
   private int animationTimer;
   private int maxTextWidth;
   private int fullTextWidth;
   private boolean shouldLoadAvatar;
   private int avatarLoadTimer;
   private int componentWidth;
   private int nameTextWidth;
   private int updateCounter;
   private boolean isDragging;
   private int lastPointerX;
   private int lastPointerY;
   private boolean selectAllState;

   static {
      int[][] var10000 = new int[][]{{0, 13}, {13, 11}, {24, 11}, {35, 11}, {46, 11}, {57, 13}, {70, 8}};
   }

   public final void setMultiSelectMode(boolean var1) {
      this.isMultiSelectMode = true;
   }

   public final DownloadDataManager getContactData() {
      return this.contactData;
   }

   public final void setContactData(DownloadDataManager var1, int var2) {
      this.contactData = var1;
      this.contactSelectedIndex = -1;
      this.refreshDisplayList();
      this.onFocusGained();
   }

   public ContactListComponent(int var1, int var2, int var3, int var4, boolean var5) {
      super(0, 1, var3, var4, true);
      System.currentTimeMillis();
      this.selectAllState = false;
      super.isFocused = true;
      this.isChatMode = true;
      this.itemHeight = FontRenderer.fontHeight + 4;
      if (this.itemHeight < GameManager.statusIcons[0].getHeight()) {
         this.itemHeight = GameManager.statusIcons[0].getHeight();
      }

      this.avatarAreaX = var3 - 4 - 35;
      this.avatarAreaY = 54;
      this.emptyMessageLines = FontRenderer.wrapTextToLines(quyen_cr.a, GameGraphics.screenWidth - 30);
      this.maxTextWidth = super.width - 23 - 5;
      this.requestedContacts = new Vector();
   }

   public final void updateContactAvatar(final long n, final int[] k) {
      if (this.contactData != null) {
         final DownloadDataManager e;
         int i = (e = this.contactData).downloadCategories.size() - 1;
         Label_0130:
         while (i >= 0) {
            final DownloadCategory DownloadCategory;
            int size = (DownloadCategory = (DownloadCategory) e.downloadCategories.elementAt(i)).downloads.size();
            while (true) {
               while (--size >= 0) {
                  final DownloadData DownloadData;
                  if ((DownloadData = (DownloadData) DownloadCategory.downloads.elementAt(size)).timestamp == n) {
                     final DownloadData downloadData3;
                     final DownloadData downloadData2 = downloadData3 = DownloadData;
                     final DownloadData downloadData4 = downloadData3;
                     if (downloadData2 != null) {
                        downloadData4.setRawDataArray(k);
                     }
                     --i;
                     continue Label_0130;
                  }
               }
               DownloadData downloadData3;
               final DownloadData downloadData2 = downloadData3 = null;
               continue;
            }
         }
      }
      quyen_bj quyen_bj3 = null;
      quyen_bj quyen_bj2 = null;
      Label_0200: {
         if (this.displayItems != null) {
            int size2 = this.displayItems.size();
            while (--size2 >= 0) {
               final quyen_bj quyen_bj = (quyen_bj) this.displayItems.elementAt(size2);
               if (quyen_bj.m == n) {
                  quyen_bj2 = (quyen_bj3 = quyen_bj);
                  break Label_0200;
               }
            }
         }
         quyen_bj2 = (quyen_bj3 = null);
      }
      final quyen_bj quyen_bj4 = quyen_bj3;
      if (quyen_bj2 != null) {
         quyen_bj4.k = k;
      }
   }

   public final void refreshDisplayList() {
      if (this.displayItems == null) {
         this.displayItems = new Vector();
      } else {
         this.displayItems.removeAllElements();
      }

      System.gc();
      if (this.contactData != null && this.contactData.downloadCategories != null && this.contactData.downloadCategories.size() != 0) {
         Vector var1 = this.contactData.downloadCategories;
         boolean var2 = false;
         int var3 = var1.size();
         int var4 = 0;

         for (int var5 = 0; var5 < var3; var5++) {
            DownloadCategory var11 = (DownloadCategory)var1.elementAt(var5);
            quyen_bj var6;
            (var6 = new quyen_bj()).a = 1;
            var6.g = var11.categoryType;
            var6.c = var11.getCategoryId();
            var6.d = UIUtils.concatStrings(var11.getCategoryId(), " (", String.valueOf(var11.downloads.size()), ")");
            this.displayItems.addElement(var6);
            if (var6.g != 1) {
               Vector var13 = var11.downloads;
               var4 = var11.downloads.size();

               for (int var7 = 0; var7 < var4; var7++) {
                  DownloadData var8 = (DownloadData)var13.elementAt(var7);
                  quyen_bj var9;
                  (var9 = new quyen_bj()).m = var8.timestamp;
                  var9.k = var8.getRawDataArray();
                  var9.c = var8.downloadId;
                  var9.g = var8.downloadStatus;
                  var9.d = var8.displayName;
                  var8.getDefaultColor();
                  var9.b = null;
                  var9.b = new Integer(var8.getDefaultColor());
                  var9.h = var8.isSelected;
                  var9.e = var8.filePath;
                  if (var9.e != null && var9.e.length() != 0) {
                     var9.f = var9.d + " - " + var9.e;
                  } else {
                     var9.f = var9.d;
                  }

                  var9.i = var8;
                  if (!this.isFilterActive || var9.g != 0 && var9.g != 0 && var9.g != -1) {
                     if (this.isSearching) {
                        if (var9.c.indexOf(this.searchKeyword) == -1 && var9.d.indexOf(this.searchKeyword) == -1) {
                           continue;
                        }

                        if (!var2) {
                           this.contactSelectedIndex = this.displayItems.size();
                           var2 = true;
                        }
                     }

                     this.displayItems.addElement(var9);
                  }
               }
            }
         }

         System.gc();
         this.totalItemCount = this.displayItems.size();
         if (this.contactSelectedIndex < 0) {
            this.contactSelectedIndex = 0;
         }

         if (this.contactSelectedIndex >= this.totalItemCount) {
            this.contactSelectedIndex = this.totalItemCount - 1;
         }

         this.visibleItemCount = super.height / this.itemHeight + 1;
         this.maxScrollY = this.totalItemCount * this.itemHeight - super.height + 3 + this.itemHeight;
         this.targetScrollY = this.contactSelectedIndex * this.itemHeight - (super.height >> 1);
         this.firstVisibleIndex = this.contactSelectedIndex - (this.visibleItemCount >> 1);
         if (this.displayItems.size() - this.contactSelectedIndex < this.visibleItemCount >> 1) {
            this.firstVisibleIndex = this.totalItemCount - this.visibleItemCount;
         }

         if (this.firstVisibleIndex < 0) {
            this.firstVisibleIndex = 0;
         }

         this.updateSoftKeys();
      } else {
         this.firstVisibleIndex = 0;
         this.visibleItemCount = 0;
         this.totalItemCount = this.displayItems.size();
         this.maxScrollY = 0;
      }
   }

   private void updateSoftKeys() {
      if (((quyen_bj)this.displayItems.elementAt(this.contactSelectedIndex)).a == 1) {
         super.middleSoftKey = this.emptyAction;
      } else if (this.isMultiSelectMode) {
         super.middleSoftKey = this.multiSelectAction;
      } else {
         super.middleSoftKey = this.selectAction;
      }
   }

   public final boolean handleDirectKeyPress(int var1) {
      if (var1 != 13 && var1 != 12) {
         return true;
      } else {
         this.handleKeyPress(var1);
         return false;
      }
   }

   public final boolean handleKeyPress(int var1) {
      if (this.isLoading) {
         return true;
      } else if (this.displayItems != null && this.totalItemCount != 0) {
         if (var1 == 12) {
            System.currentTimeMillis();
            this.contactSelectedIndex--;
            if (this.contactSelectedIndex < 0) {
               this.contactSelectedIndex = this.totalItemCount - 1;
            }
         }

         if (var1 == 13) {
            System.currentTimeMillis();
            this.contactSelectedIndex++;
            if (this.contactSelectedIndex >= this.totalItemCount) {
               this.contactSelectedIndex = 0;
            }
         }

         if (var1 == 12 || var1 == 13) {
            this.updateSoftKeys();
            this.targetScrollY = this.contactSelectedIndex * this.itemHeight - (super.height >> 1);
            this.firstVisibleIndex = this.contactSelectedIndex - (this.visibleItemCount >> 1);
            if (this.totalItemCount - this.contactSelectedIndex < this.visibleItemCount >> 1) {
               this.firstVisibleIndex = this.totalItemCount - this.visibleItemCount;
            }

            if (this.firstVisibleIndex < 0) {
               this.firstVisibleIndex = 0;
            }

            this.resetAnimation();
            GameGraphics.clearKeyStates();
            quyen_cq.a(true);
            this.resetTextAnimation();
            UIUtils.markScreenForUpdate(this);
         }

         if (var1 == 16) {
            this.selectCurrentItem();
            GameGraphics.clearKeyStates();
         }

         return true;
      } else {
         return true;
      }
   }

   public final void resetAnimation() {
      this.avatarLoadTimer = 0;
      this.shouldLoadAvatar = false;
   }

   private void selectCurrentItem() {
      if (this.contactSelectedIndex != -1) {
         this.selectedItem = (quyen_bj)this.displayItems.elementAt(this.contactSelectedIndex);
         if (this.selectedItem.a == 0) {
            if (this.selectedItem.g == 8) {
               if (this.selectedItem.c.startsWith("http://")) {
                  try {
                     Xuka.instance.platformRequest(this.selectedItem.c);
                     return;
                  } catch (ConnectionNotFoundException var6) {
                     return;
                  }
               }
            } else if (this.selectedItem.g == 4) {
               return;
            }

            if (this.isMultiSelectMode) {
               quyen_bj var8 = (quyen_bj)this.displayItems.elementAt(this.contactSelectedIndex);
               var8.h = !var8.h;
               var8.i.isSelected = !var8.i.isSelected;
            } else {
               if (this.chatAction == null) {
                  this.chatAction = new UIFactory("Chat", new quyen_c(this));
               }

               if (this.isChatMode) {
                  this.chatAction.action.action();
               } else {
                  if (this.contextMenu == null) {
                     Vector var7 = new Vector();
                     UIFactory var2 = new UIFactory("Hồ sơ", new quyen_d(this));
                     UIFactory var3 = new UIFactory("Media", new quyen_e(this));
                     if (FriendScreen.currentViewMode == 1) {
                        UIFactory var4 = new UIFactory("Từ chối ID", new quyen_f(this));
                        UIFactory var5 = new UIFactory("Xóa ID", new quyen_g(this));
                        var7.addElement(this.chatAction);
                        var7.addElement(var3);
                        var7.addElement(var2);
                        var7.addElement(var5);
                        var7.addElement(var4);
                     } else if (FriendScreen.currentViewMode == 2) {
                        UIFactory var9 = new UIFactory("Bỏ từ chối", new quyen_i(this));
                        var7.addElement(var2);
                        var7.addElement(var9);
                     } else {
                        UIFactory var10 = new UIFactory("Đồng ý", new quyen_j(this));
                        UIFactory var11 = new UIFactory(quyen_cr.e(), new quyen_k(this));
                        var7.addElement(var2);
                        var7.addElement(var10);
                        var7.addElement(var11);
                     }

                     this.contextMenu = new ContextMenu(var7);
                  }

                  GameManager.getInstance().showContextMenu(this.contextMenu, 1);
               }
            }
         } else {
            DownloadCategory var1;
            if ((var1 = this.contactData.findCategoryById(this.selectedItem.c)) != null) {
               var1.categoryType = this.selectedItem.g == 0 ? 1 : 0;
            }

            this.refreshDisplayList();
         }
      }
   }

   private void resetTextAnimation() {
      this.animationTimer = 0;
      this.fullTextWidth = 0;
      this.needsTextAnimation = false;
   }

   public final void render(Graphics var1) {
      var1.setClip(super.posX, super.posY, super.width + 1, super.height);
      if (this.isLoading) {
         FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText("Vui lòng chờ", Screen.screenWidth - FontRenderer.getTextWidth("Vui lòng chờ") >> 1, 20, var1);
         GameManager.instance.drawLoading(var1, quyen_cp.d, FontRenderer.fontHeight + 35);
      } else if (this.visibleItemCount == 0) {
         int var12 = this.emptyMessageLines.length;

         while (--var12 >= 0) {
            FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.emptyMessageLines[var12], Screen.screenWidth - FontRenderer.getTextWidth(this.emptyMessageLines[var12]) >> 1, 20 + var12 * FontRenderer.fontHeight, var1);
         }
      } else if (this.displayItems != null) {
         var1.translate(2, 2);
         var1.translate(0, -this.currentScrollY);
         int var2 = this.firstVisibleIndex * this.itemHeight;
         this.lastVisibleIndex = this.firstVisibleIndex + this.visibleItemCount;
         this.itemCountLimit = this.totalItemCount;
         this.itemSpacing = this.itemHeight + 2;
         int var3 = 0;
         this.componentWidth = super.width + 4;
         quyen_bj var4 = null;

         for (int var5 = this.firstVisibleIndex; var5 <= this.lastVisibleIndex && var5 < this.itemCountLimit; var5++) {
            var4 = (quyen_bj)this.displayItems.elementAt(var5);
            var3 = this.itemHeight;
            if (var5 == this.contactSelectedIndex) {
               if (((quyen_bj)var4).a == 0) {
                  var3 <<= 1;
               }

               var1.setColor(66826);
               var1.fillRect(-2, var2 + 1, this.componentWidth, var3);
               var1.setColor(9478569);
               var1.drawRect(-3, var2 + 1, this.componentWidth, var3);
               if (var3 > this.itemHeight) {
                  if (this.fullTextWidth == 0) {
                     this.textAnimationX = 23;
                     this.fullTextWidth = FontRenderer.getTextWidth(((quyen_bj)var4).f);
                     this.nameTextWidth = FontRenderer.getTextWidth(((quyen_bj)var4).c);
                     this.fullTextWidth = this.fullTextWidth > this.nameTextWidth ? this.fullTextWidth : this.nameTextWidth;
                     if (this.fullTextWidth > this.maxTextWidth) {
                        this.needsTextAnimation = this.animationDirection = true;
                     } else {
                        this.needsTextAnimation = false;
                     }
                  }

                  if (this.needsTextAnimation && this.animationTimer++ > 20) {
                     this.animationTimer = 21;
                     if (this.animationDirection) {
                        if (this.textAnimationX > -(this.fullTextWidth - this.maxTextWidth) + 23 - 5) {
                           this.textAnimationX--;
                        } else {
                           this.animationDirection = false;
                        }
                     } else if (this.textAnimationX < 23) {
                        this.textAnimationX++;
                     } else {
                        this.animationDirection = true;
                     }
                  }
               }
            }

            if (((quyen_bj)var4).a == 1) {
               var1.drawImage(GameManager.arrowIcons[((quyen_bj)var4).g], 9, var2 + (this.itemHeight >> 1) + 2, 3);
               FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(((quyen_bj)var4).d, 18, var2 + 3, var1);
            } else {
               FontRenderer.getFontInstance(((quyen_bj)var4).b).drawText(((quyen_bj)var4).f, var5 == this.contactSelectedIndex ? this.textAnimationX : 23, var2 + 3, var1);
               if (var5 == this.contactSelectedIndex) {
                  FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(((quyen_bj)var4).c, this.textAnimationX, var2 + this.itemSpacing, var1);
               }

               var1.drawImage(GameManager.statusIcons[((quyen_bj)var4).g == 1 ? 1 : 0], var5 == this.contactSelectedIndex ? this.textAnimationX - 12 : 11, var2 + (this.itemHeight >> 1) + 2, 3);
               if (this.isMultiSelectMode && ((quyen_bj)var4).g != 3) {
                  var1.drawRegion(GameManager.loadingImage, 0, ((quyen_bj)var4).h ? 13 : 0, 13, 13, 0, super.width - 12, var2 + (this.itemHeight >> 1), 3);
               }
            }

            var2 += var3;
         }

         var1.translate(0, this.currentScrollY);
         var1.translate(-2, -2);
         if (FriendScreen.isAvatarEnabled && !this.isChatMode && !this.isMultiSelectMode) {
            if (++this.avatarLoadTimer > 30) {
               this.avatarLoadTimer = 31;
               if (!this.shouldLoadAvatar) {
                  this.shouldLoadAvatar = true;
                  if ((var4 = (quyen_bj)this.displayItems.elementAt(this.contactSelectedIndex)).a != 1) {
                     String var17 = var4.c;
                     if (var4.c != null && !this.requestedContacts.contains(var17)) {
                        this.requestedContacts.addElement(var17);
                        long var8 = var4.m;
                        Packet var10 = new Packet(3, 6);
                        quyen_a.a(var8, var10);
                        NetworkManager.sendPacket(var10);
                     }
                  }
               }
            }

            int[] var11;
            DownloadData var18;
            if (((quyen_bj)this.displayItems.elementAt(this.contactSelectedIndex)).a != 1
                && (var18 = (this.contactSelectedIndex < 0 ? null : (quyen_bj)this.displayItems.elementAt(this.contactSelectedIndex)).i) != null
                && (var11 = var18.getRawDataArray()) != null
                && var11.length > 0) {
               this.lastVisibleIndex = var11.length;

               for (int var14 = 0; var14 < this.lastVisibleIndex; var14++) {
                  var1.drawImage(quyen_ea.a(var18.processedDataArray[var14]), this.avatarAreaX + (var11[var14] >> 24), this.avatarAreaY + (var11[var14] << 8 >> 24), 0);
               }
            }
         }
      }
   }

   public final void update() {
      this.updateCounter++;
      if (this.updateCounter > 1000) {
         this.updateCounter = 0;
      }

      if (this.currentScrollY != this.targetScrollY) {
         this.scrollVelocity = this.targetScrollY - this.currentScrollY << 2;
         this.scrollAcceleration = this.scrollAcceleration + this.scrollVelocity;
         this.currentScrollY = this.currentScrollY + (this.scrollAcceleration >> 4);
         this.scrollAcceleration &= 15;
         if (this.currentScrollY > this.maxScrollY) {
            this.currentScrollY = this.maxScrollY;
         }

         if (this.currentScrollY < 0) {
            this.currentScrollY = 0;
         }

         this.firstVisibleIndex = this.currentScrollY / this.itemHeight - 1;
         if (this.firstVisibleIndex < 0) {
            this.firstVisibleIndex = 0;
         }
      }
   }

   public final void onFocusGained() {
      if (this.displayItems != null) {
         if (super.posY + this.totalItemCount * this.itemHeight >= super.height) {
            quyen_cq.a = true;
            quyen_cq.a(this.totalItemCount);
         } else {
            quyen_cq.a = false;
         }
      }
   }

   public final void renderFocusIndicator(Graphics var1) {
      quyen_cq.a(var1, this.contactSelectedIndex);
   }

   public final void handlePointerRelease(int var1, int var2) {
      this.lastPointerX = var1;
      this.lastPointerY = var2;
   }

   public final void handlePointerPress(int var1, int var2) {
      if (this.isDragging) {
         this.isDragging = false;
         this.targetScrollY = this.targetScrollY - (var2 - this.lastPointerY) * 5;
         if (this.targetScrollY < 0) {
            this.targetScrollY = 0;
         } else if (this.targetScrollY > this.maxScrollY) {
            this.targetScrollY = this.maxScrollY;
         }
      } else {
         if (this.displayItems == null) {
            return;
         }

         if ((var1 = (var2 + this.currentScrollY) / this.itemHeight) < 0) {
            var1 = 0;
         }

         if (var1 > this.totalItemCount - 1) {
            var1 = this.totalItemCount - 1;
         }

         if (this.contactSelectedIndex == var1) {
            this.selectCurrentItem();
            return;
         }

         if (this.contactSelectedIndex > var1) {
            this.contactSelectedIndex = var1;
         } else {
            quyen_bj var4;
            if ((var4 = (quyen_bj)this.displayItems.elementAt(this.contactSelectedIndex)).d != null && !var4.d.equals("")) {
               if (this.contactSelectedIndex == var1 - 1) {
                  this.selectCurrentItem();
                  return;
               }

               this.contactSelectedIndex = var1 - 1;
            } else {
               this.contactSelectedIndex = var1;
            }
         }

         this.updateSoftKeys();
         this.resetAnimation();
         this.resetTextAnimation();
         UIUtils.markScreenForUpdate(this);
      }

      quyen_cq.a(true);
   }

   public final void handlePointerDrag(int var1, int var2) {
      if (abs(var1 - this.lastPointerX) > 1 || abs(var2 - this.lastPointerY) > 1) {
         this.isDragging = true;
         this.targetScrollY = this.targetScrollY - (var2 - this.lastPointerY);
         if (this.targetScrollY < 0) {
            this.targetScrollY = 0;
         } else if (this.targetScrollY > this.maxScrollY) {
            this.targetScrollY = this.maxScrollY;
         }

         this.currentScrollY = this.targetScrollY;
         this.firstVisibleIndex = this.currentScrollY / this.itemHeight - 1;
         if (this.firstVisibleIndex < 0) {
            this.firstVisibleIndex = 0;
         }

         this.lastPointerX = var1;
         this.lastPointerY = var2;
      }

      quyen_cq.a(true);
   }

   public static int abs(int var0) {
      return var0 > 0 ? var0 : -var0;
   }

   public final boolean updateContactStatus(String var1, int var2) {
      if (this.contactData == null) {
         return false;
      } else {
         int var5 = var2;
         String var4 = var1;
         DownloadDataManager var3 = this.contactData;

         for (int var6 = this.contactData.downloadCategories.size() - 1; var6 >= 0; var6--) {
            DownloadData var7;
            if ((var7 = ((DownloadCategory)var3.downloadCategories.elementAt(var6)).findDownloadById(var4)) != null) {
               var7.downloadStatus = var5;
            }
         }

         if (this.displayItems == null) {
            return false;
         } else {
            boolean var10 = false;
            int var11 = this.totalItemCount;

            while (--var11 >= 0) {
               quyen_bj var12;
               if ((var12 = (quyen_bj)this.displayItems.elementAt(var11)).a == 0 && var12.c.equals(var1) && var12.g != var2) {
                  var12.g = var2;
                  var10 = true;
               }
            }

            if (this.isFilterActive) {
               this.refreshDisplayList();
            }

            return var10;
         }
      }
   }

   public final boolean updateContactStatus(long var1, int var3) {
      if (this.contactData == null) {
         return false;
      } else {
         int var5 = var3;
         long var8 = var1;
         DownloadDataManager var4 = this.contactData;
         int var6 = 0;
         int var7 = var4.downloadCategories.size();

         label45:
         while (--var7 >= 0) {
            DownloadCategory var10;
            int var11 = (var10 = (DownloadCategory)var4.downloadCategories.elementAt(var7)).downloads.size();

            while (--var11 >= 0) {
               DownloadData var12;
               if ((var12 = (DownloadData)var10.downloads.elementAt(var11)).timestamp == var8) {
                  var12.downloadStatus = var5;
                  if (++var6 > 1) {
                     break label45;
                  }
               }
            }
         }

         if (this.displayItems == null) {
            return false;
         } else {
            boolean var13 = false;
            var5 = this.totalItemCount;

            while (--var5 >= 0) {
               quyen_bj var15;
               if ((var15 = (quyen_bj)this.displayItems.elementAt(var5)).a == 0 && var15.m == var1 && var15.g != var3) {
                  var15.g = var3;
                  var13 = true;
               }
            }

            if (this.isFilterActive) {
               this.refreshDisplayList();
            }

            return var13;
         }
      }
   }

   public final boolean updateContactSubtext(long var1, String var3) {
      if (this.contactData == null) {
         return false;
      } else {
         String var5 = var3;
         long var8 = var1;
         DownloadDataManager var4 = this.contactData;
         int var6 = 0;
         int var7 = var4.downloadCategories.size();

         label46:
         while (--var7 >= 0) {
            DownloadCategory var10;
            int var11 = (var10 = (DownloadCategory)var4.downloadCategories.elementAt(var7)).downloads.size();

            while (--var11 >= 0) {
               DownloadData var12;
               if ((var12 = (DownloadData)var10.downloads.elementAt(var11)).timestamp == var8) {
                  var12.filePath = var5;
                  if (++var6 > 1) {
                     break label46;
                  }
               }
            }
         }

         if (this.displayItems == null) {
            return false;
         } else {
            boolean var13 = false;
            int var14 = this.totalItemCount;

            while (--var14 >= 0) {
               quyen_bj var15;
               if ((var15 = (quyen_bj)this.displayItems.elementAt(var14)).a == 0 && var15.m == var1) {
                  var15.e = var3;
                  if (var3 != null && var3.length() > 0) {
                     var15.f = var15.d + " - " + var3;
                     var13 = true;
                  } else {
                     var15.f = var15.d;
                  }
               }
            }

            return var13;
         }
      }
   }

   public final void updateContactSubtext(String var1, String var2, int var3) {
      if (this.contactData != null) {
         String var5 = var2;
         String var4 = var1;
         DownloadDataManager var10 = this.contactData;

         for (int var6 = this.contactData.downloadCategories.size() - 1; var6 >= 0; var6--) {
            DownloadData var7;
            if ((var7 = ((DownloadCategory)var10.downloadCategories.elementAt(var6)).findDownloadById(var4)) != null) {
               var7.filePath = var5;
            }
         }

         if (this.displayItems != null) {
            var3 = this.totalItemCount;

            while (--var3 >= 0) {
               quyen_bj var12;
               if ((var12 = (quyen_bj)this.displayItems.elementAt(var3)).a == 0 && var12.c.equals(var1)) {
                  var12.e = var2;
                  if (var2 != null && var2.length() != 0) {
                     var12.f = var12.d + " - " + var2;
                  }
               }
            }

            if (this.isFilterActive) {
               this.refreshDisplayList();
            }
         }
      }
   }

   public final void removeContact(String var1) {
      String var2 = var1;
      DownloadDataManager var4 = this.contactData;

      for (int var3 = this.contactData.downloadCategories.size() - 1; var3 >= 0; var3--) {
         if (((DownloadCategory)var4.downloadCategories.elementAt(var3)).getCategoryId().equals(var2)) {
            var4.downloadCategories.removeElementAt(var3);
            break;
         }
      }

      this.refreshDisplayList();
      this.resetAnimation();
   }

   public final boolean hasContact(String var1) {
      int var2 = this.totalItemCount;

      while (--var2 >= 0) {
         quyen_bj var3;
         if ((var3 = (quyen_bj)this.displayItems.elementAt(var2)).a == 0 && var3.c.equals(var1)) {
            return true;
         }
      }

      return false;
   }

   public final void setSearchFilter(String var1) {
      if (var1.equals("")) {
         this.isSearching = false;
      } else {
         this.isSearching = true;
         this.searchKeyword = var1;
         this.isFilterActive = false;
      }

      this.refreshDisplayList();
      this.resetAnimation();
   }

   public final String[] getGroupNames() {
      int var1;
      String[] var2 = new String[var1 = this.contactData.downloadCategories.size()];

      for (int var3 = 0; var3 < var1; var3++) {
         var2[var3] = ((DownloadCategory)this.contactData.downloadCategories.elementAt(var3)).getCategoryId();
      }

      return var2;
   }

   public final void toggleSelectAll() {
      if (this.isMultiSelectMode) {
         this.selectAllState = !this.selectAllState;

         for (int var1 = this.totalItemCount - 1; var1 >= 0; var1--) {
            quyen_bj var2;
            if ((var2 = (quyen_bj)this.displayItems.elementAt(var1)).a == 0) {
               var2.h = this.selectAllState;
               var2.i.isSelected = this.selectAllState;
            }
         }
      }
   }

   public final void selectAll() {
      this.selectAllState = true;
      this.toggleSelectAll();
   }

   public final long[] getSelectedContactIds() {
      final Vector vector = new Vector();
      if (this.isMultiSelectMode) {
         for (int i = this.totalItemCount - 1; i >= 0; --i) {
            final quyen_bj quyen_bj;
            if ((quyen_bj = (quyen_bj) this.displayItems.elementAt(i)).a == 0 && quyen_bj.h) {
               quyen_bj.h = false;
               vector.addElement(new Long(quyen_bj.m));
            }
         }
      }
      if (vector.size() > 0) {
         final long[] array = new long[vector.size()];
         int size = vector.size();
         while (--size >= 0) {
            array[size] = ((Long) vector.elementAt(size)).longValue();
         }
         return array;
      }
      return null;
   }

   static quyen_bj getSelectedItem(ContactListComponent var0) {
      return var0.selectedItem;
   }
}
