package home.thienph.xyahoo107.components;

import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.data.game.Card;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.GameScreen;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.FontRenderer;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class CardGameComponent extends UIComponent {
    private static int selectedCount;
    public static int handCardCount;
    private static Card[] selectedCards;
    public static Card[] handCards;
    private byte[] handCardValues;
    private byte[] selectedCardValues;
    private int currentCardIndex;
    private final int menuIndicatorY;
    public String currentPlayer;
    private static int currentMoveType;
    public int lastMoveType;
    public Card[] animationCards;
    private Card[] waitingDots;
    public boolean isFirstMove;
    public boolean gameEnded;
    public boolean isWaiting;
    public static boolean isAnimating;
    private boolean isCardMoving;
    private int animationCardIndex;
    private int animationFrame;
    private long animationDelay;
    private long lastAnimationTime;
    private static int cardBottomY;
    private static boolean gameInitialized;
    private int targetX;
    private int targetY;
    private int velocityX;
    private int velocityY;
    private int currentX;
    private int currentY;
    public Card[] oldAnimationCards;
    public boolean moveSentThisTurn;
    public static boolean isViewingOtherPlayers;
    private Card[][] otherPlayersCards;
    private int arrayLength;
    private int innerArrayLength;
    private int cardSpacing;
    private final int cardWidth = 39;
    private int handStartX;
    private static int[] cardValueOffsets;

    public CardGameComponent() {
        GameManager.loadChatImages();
        this.menuIndicatorY = Screen.screenHeight - 48;
        if (Screen.screenWidth > 130) {
        }

        cardBottomY = 73;
        super.posX = 0;
        super.posY = 0;
        super.width = Screen.screenWidth;
        super.height = Screen.screenHeight;
        super.isFocused = true;
        cardValueOffsets = new int[]{0, 6, 12, 18, 24, 30, 36, 42, 50, 56, 62, 68, 74};
    }

    public void initializeHand(byte[] var1) {
        handCards = null;
        selectedCards = null;
        this.animationCards = null;
        this.waitingDots = null;
        System.gc();
        selectedCount = 0;
        this.handCardValues = var1;
        gameInitialized = true;
        this.moveSentThisTurn = false;
        handCards = new Card[handCardCount = this.handCardValues.length];
        selectedCards = new Card[selectedCount];
        this.animationCards = new Card[selectedCount];
        this.waitingDots = new Card[3];

        for (int var2 = 0; var2 < this.waitingDots.length; var2++) {
            this.waitingDots[var2] = new Card();
            this.waitingDots[var2].setPosition((Screen.screenWidth >> 1) - 30 + var2 * 14, Screen.screenHeight - 130 >> 1);
        }

        for (int var3 = 0; var3 < selectedCount; var3++) {
            this.animationCards[var3] = new Card();
        }

        for (int var4 = 0; var4 < handCardCount; var4++) {
            handCards[var4] = new Card();
            handCards[var4].cardValue = this.handCardValues[var4];
            handCards[var4].rank = (byte) (this.handCardValues[var4] >> 2);
            handCards[var4].suit = (byte) (this.handCardValues[var4] % 4);
            handCards[var4].setPosition(50 + var4 * 14, Screen.screenHeight - 100);
            if (var4 == handCardCount - 1) {
                handCards[var4].isLast = true;
            }
        }

        this.currentCardIndex = 0;
        this.arrangeHandCards();
        this.animationCardIndex = 0;
        this.animationFrame = 0;
        this.animationDelay = 10L;
        this.lastAnimationTime = System.currentTimeMillis();
    }

    public void handlePointerPress(int var1, int var2) {
        if (!isViewingOtherPlayers && handCardCount > 0) {
            int var5 = var2;
            int var4 = var1;
            CardGameComponent var3 = this;
            int var6 = 0;
            int var7 = 0;
            int var8 = 0;

            int var10000;
            while (true) {
                if (var8 >= handCardCount) {
                    var10000 = -1;
                    break;
                }

                var6 = handCards[var8].posX;
                var7 = handCards[var8].posY;
                if (var4 > var6 && var4 < var6 + (var8 == handCardCount - 1 ? 40 : var3.cardSpacing) && var5 > var7 && var5 < var7 + 54) {
                    var10000 = var8;
                    break;
                }

                var8++;
            }

            int var9 = var10000;
            if (var10000 != -1) {
                this.currentCardIndex = var9;
                if (!handCards[this.currentCardIndex].isSelected) {
                    this.handleKeyPress(12);
                } else {
                    this.handleKeyPress(13);
                }

                int var10 = FontRenderer.getTextWidth(GameScreen.instance.centerSoftkey.text);
                var4 = (super.width >> 1) - (var10 >> 1);
                var5 = super.height;
                if (var1 > var4 && var1 < var4 + var10 && var2 > var5 && var2 < var5 + GameManager.footerHeight) {
                    this.handleKeyPress(16);
                }
            }
        }
    }

    private static void selectCard(int var0) {
        handCards[var0].isSelected = true;
        handCards[var0].posY -= 16;
        handCards[var0].isLast = true;
        if (var0 > 0) {
            handCards[var0 - 1].isLast = true;
        }
    }

    public boolean handleKeyPress(int var1) {
        if (isAnimating) {
            return false;
        } else {
            boolean var2 = true;
            switch (var1) {
                case 12:
                    if (!isViewingOtherPlayers && handCardCount > 0 && !handCards[this.currentCardIndex].isSelected) {
                        selectCard(this.currentCardIndex);
                    }

                    var2 = false;
                    return var2;
                case 13:
                    if (!isViewingOtherPlayers && handCardCount > 0 && handCards[this.currentCardIndex].isSelected) {
                        handCards[this.currentCardIndex].isSelected = false;
                        handCards[this.currentCardIndex].posY += 16;
                        if (this.currentCardIndex != handCardCount - 1) {
                            handCards[this.currentCardIndex].isLast = true;
                        }

                        if (this.currentCardIndex > 0) {
                            handCards[this.currentCardIndex - 1].isLast = true;
                        }

                        var2 = false;
                    }

                    if (!GameScreen.instance.isChatMode) {
                        var2 = false;
                    }

                    return var2;
                case 14:
                    this.currentCardIndex--;
                    if (this.currentCardIndex >= 0) {
                        var2 = false;
                        return var2;
                    }

                    this.currentCardIndex = 0;
                    break;
                case 15:
                    this.currentCardIndex++;
                    if (this.currentCardIndex <= handCardCount - 1) {
                        var2 = false;
                        return var2;
                    }

                    this.currentCardIndex = handCardCount - 1;
                    break;
                case 16:
                    System.out.println("==>");
                    System.out.println(FriendScreen.username);
                    System.out.println(this.currentPlayer);
                    if (!isViewingOtherPlayers && FriendScreen.username.equals(this.currentPlayer) && !this.moveSentThisTurn) {
                        System.out.println("=> 111");

                        for (int var3 = 0; var3 < handCardCount; var3++) {
                            if (handCards[var3].isSelected) {
                                selectedCount++;
                            }
                        }

                        selectedCards = null;
                        this.selectedCardValues = null;
                        System.gc();
                        selectedCards = new Card[selectedCount];
                        this.selectedCardValues = new byte[selectedCount];
                        var1 = 0;

                        for (int var6 = 0; var6 < handCardCount; var6++) {
                            if (handCards[var6].isSelected) {
                                selectedCards[var1] = handCards[var6];
                                var1++;
                            }
                        }

                        var2 = this.validateMove(selectedCards);
                        System.out.println("isValidMove ==");
                        System.out.println(var2);
                        System.out.println("isSentThisTurn ==");
                        System.out.println(this.moveSentThisTurn);
                        if (!this.moveSentThisTurn && var2) {
                            System.out.println("is sending");

                            for (int var5 = 0; var5 < selectedCount; var5++) {
                                this.selectedCardValues[var5] = (byte) selectedCards[var5].cardValue;
                            }

                            PacketSender.requestSendDataUIComponent(GameScreen.currentRoomId, FriendScreen.username, currentMoveType, this.selectedCardValues);
                            this.moveSentThisTurn = true;
                        } else {
                            selectedCount = 0;
                            this.moveSentThisTurn = false;
                            if (!var2) {
                                GameManager.instance.showNotification("Nước đi không hợp lệ", (Image) null, 1);
                            }
                        }
                    }
                case 17:
                    break;
                default:
                    return var2;
            }

            return true;
        }
    }

    public void selectAllCards() {
        for (int var1 = 0; var1 < handCardCount; var1++) {
            selectCard(var1);
        }
    }

    public void deselectAllCards() {
        for (int var1 = 0; var1 < handCardCount; var1++) {
            if (handCards[var1].isSelected) {
                handCards[var1].isSelected = false;
            }
        }

        this.arrangeHandCards();
        this.validateSelection();
        selectedCount = 0;
        this.moveSentThisTurn = false;
    }

    private void validateSelection() {
        if (this.currentCardIndex < 0) {
            this.currentCardIndex = 0;
        }

        if (this.currentCardIndex >= handCardCount) {
            this.currentCardIndex = handCardCount - 1;
        }
    }

    public void removeCards(byte[] var1) {
        int var2 = 0;

        for (int var3 = 0; var3 < handCardCount; var3++) {
            for (int var4 = 0; var4 < var1.length; var4++) {
                if (handCards[var3].cardValue == var1[var4]) {
                    handCards[var3].isSelected = true;
                    handCards[var3].isRemoved = true;
                } else {
                    handCards[var3].isSelected = false;
                }
            }
        }

        for (int var5 = 0; var5 < handCardCount; var5++) {
            if (!handCards[var5].isRemoved) {
                handCards[var2] = handCards[var5];
                var2++;
            }
        }

        handCardCount -= var1.length;
        this.arrangeHandCards();

        for (int var6 = 0; var6 < selectedCount; var6++) {
            if (var6 == selectedCount - 1) {
                selectedCards[var6].isLast = true;
            }
        }

        selectedCount = 0;
        this.validateSelection();
    }

    public void render(Graphics var1) {
        if (GameScreen.isInGame) {
            var1.setClip(0, -5, Screen.screenWidth, Screen.screenHeight);
            if (isAnimating) {
                Graphics var15 = var1;
                CardGameComponent var13 = this;
                int var18 = (Screen.screenWidth >> 1) - 50;
                int var10 = Screen.screenHeight - 140 >> 1;
                drawCardBack(var1, var18, var10);
                if (this.animationCardIndex < handCardCount) {
                    var18 += (handCards[this.animationCardIndex].posX - var18) * (this.animationFrame + 1) / 3;
                    var10 += (handCards[this.animationCardIndex].posY - var10) * (this.animationFrame + 1) / 3;
                    drawCardBack(var1, var18, var10);
                }

                for (int var7 = 0; var7 < var13.animationCardIndex; var7++) {
                    if (!handCards[var7].isRemoved && var13.animationCardIndex < handCardCount) {
                        var13.drawCard(var15, handCards[var7]);
                    }
                }
            } else {
                if (isViewingOtherPlayers) {
                    Graphics var4 = var1;
                    CardGameComponent var3 = this;
                    this.arrayLength = this.otherPlayersCards.length;

                    for (int var5 = 0; var5 < var3.arrayLength; var5++) {
                        var3.innerArrayLength = var3.otherPlayersCards[var5].length;

                        for (int var2 = 0; var2 < var3.innerArrayLength; var2++) {
                            if (var3.otherPlayersCards[var5][var2] != null) {
                                var3.drawCard(var4, var3.otherPlayersCards[var5][var2]);
                            }
                        }
                    }
                } else {
                    for (int var8 = 0; var8 < handCardCount; var8++) {
                        if (handCards[var8] != null && !handCards[var8].isRemoved) {
                            if (var8 != this.currentCardIndex && !handCards[var8].isSelected) {
                                this.drawCard(var1, handCards[var8]);
                            } else {
                                Card var16 = handCards[var8];
                                var1.drawRegion(GameManager.cardImage, 40, 0, 40, 54, 0, var16.posX, var16.posY, 20);
                                this.drawCardContent(var1, var16.posX, var16.posY, var16.isLast, var16.rank, var16.suit);
                            }
                        }
                    }
                }

                if (GameScreen.instance.isGameActive && gameInitialized) {
                    if (this.isWaiting) {
                        if (this.waitingDots != null) {
                            this.arrayLength = this.waitingDots.length;

                            for (int var9 = 0; var9 < this.arrayLength; var9++) {
                                if (this.waitingDots[var9] != null) {
                                    Card var17 = this.waitingDots[var9];
                                    drawCardBack(var1, var17.posX, var17.posY);
                                }
                            }
                        }
                    } else {
                        Graphics var14 = var1;
                        CardGameComponent var12 = this;

                        try {
                            if (var12.oldAnimationCards != null) {
                                var12.drawCards(var14, var12.oldAnimationCards);
                            }

                            if (var12.animationCards != null) {
                                var12.drawCards(var14, var12.animationCards);
                            }
                        } catch (NullPointerException var6) {
                            var6.printStackTrace();
                        }
                    }
                }

                if (!isViewingOtherPlayers && !GameScreen.instance.isSpectating) {
                    var1.drawImage(GameManager.menuImage, this.handStartX + this.currentCardIndex * this.cardSpacing + (this.cardSpacing - 6 >> 1), this.menuIndicatorY, 0);
                }
            }
        }
    }

    public void startMoveAnimation(byte[] var1, int var2, int var3) {
        this.animationCards = null;
        System.gc();
        this.isCardMoving = true;
        this.oldAnimationCards = this.animationCards;
        this.arrayLength = var1.length;
        this.animationCards = new Card[this.arrayLength];

        for (int var4 = 0; var4 < this.arrayLength; var4++) {
            this.animationCards[var4] = new Card();
            this.animationCards[var4].cardValue = var1[var4];
            this.animationCards[var4].rank = (byte) (var1[var4] >> 2);
            this.animationCards[var4].suit = (byte) (var1[var4] % 4);
            if (var4 == var1.length - 1) {
                this.animationCards[var4].isLast = true;
            }
        }

        this.targetX = Screen.screenWidth - ((this.arrayLength > 1 ? (this.arrayLength - 1) * 14 : 0) + 40) >> 1;
        this.targetY = Screen.screenHeight - 120 >> 1;
        this.velocityX = (this.targetX - var2) / 5;
        this.velocityY = (this.targetY - var3) / 5;
        this.currentX = var2;
        this.currentY = var3;
        this.arrayLength = this.animationCards.length;

        for (int var5 = 0; var5 < this.arrayLength; var5++) {
            this.animationCards[var5].setPosition(var2 + var5 * 14, var3);
        }
    }

    private void drawCards(Graphics var1, Card[] var2) {
        try {
            this.arrayLength = var2.length;

            for (int var3 = 0; var3 < this.arrayLength; var3++) {
                if (var2[var3] != null) {
                    this.drawCard(var1, var2[var3]);
                }
            }
        } catch (NullPointerException var4) {
            var4.printStackTrace();
        }
    }

    public void update() {
        long var2;
        if (isAnimating && (var2 = System.currentTimeMillis()) - this.lastAnimationTime >= this.animationDelay) {
            this.lastAnimationTime = var2;
            this.animationFrame = (this.animationFrame + 1) % 2;
            if (this.animationFrame == 0) {
                this.animationCardIndex++;
                if (this.animationCardIndex > handCardCount) {
                    isAnimating = false;
                    this.animationCardIndex = 0;
                }
            }
        }

        if (this.isCardMoving) {
            CardGameComponent var1;
            int var3;
            label45:
            {
                var1 = this;
                int var4 = this.currentX;
                var3 = this.currentY;
                if (ContactListComponent.abs(this.targetX - this.currentX) > ContactListComponent.abs(this.velocityX)) {
                    this.currentX = this.currentX + this.velocityX;
                    if (this.currentX != var4) {
                        break label45;
                    }
                }

                this.currentX = this.targetX;
            }

            label40:
            {
                if (ContactListComponent.abs(this.targetY - this.currentY) > ContactListComponent.abs(this.velocityY)) {
                    this.currentY = this.currentY + this.velocityY;
                    if (this.currentY != var3) {
                        break label40;
                    }
                }

                this.currentY = this.targetY;
            }

            this.arrayLength = this.animationCards.length;

            for (int var5 = 0; var5 < var1.arrayLength; var5++) {
                var1.animationCards[var5].setPosition(var1.currentX + var5 * 14, var1.currentY);
            }

            if (var1.currentX == var1.targetX && var1.currentY == var1.targetY) {
                var1.oldAnimationCards = null;
                var1.isCardMoving = false;
                if (!GameScreen.instance.isGameStarted) {
                    GameScreen.instance.showContinueButton();
                }
            }
        }
    }

    private void arrangeHandCards() {
        this.cardSpacing = (Screen.screenWidth - this.cardWidth) / (handCardCount > 1 ? handCardCount - 1 : 1);
        if (this.cardSpacing > this.cardWidth) {
            this.cardSpacing = this.cardWidth;
        }

        this.handStartX = Screen.screenWidth - ((handCardCount > 1 ? (handCardCount - 1) * this.cardSpacing : 0) + this.cardWidth) >> 1;

        for (int var1 = 0; var1 < handCardCount; var1++) {
            handCards[var1].setPosition(this.handStartX + this.cardSpacing * var1, Screen.screenHeight - cardBottomY);
        }
    }

    public void setupOtherPlayersView() {
        this.otherPlayersCards = null;
        System.gc();
        this.otherPlayersCards = new Card[GameScreen.instance.gameResult][];
        this.arrayLength = GameScreen.instance.resultPlayerNames.length;

        for (int var1 = 0; var1 < GameScreen.instance.gameResult; var1++) {
            String var2 = GameScreen.instance.playerComponents[var1].playerName;
            int var3 = GameScreen.instance.playerComponents[var1].position;

            for (int var4 = 0; var4 < this.arrayLength; var4++) {
                if (GameScreen.instance.resultPlayerNames[var4].equals(var2)) {
                    this.otherPlayersCards[var1] = new Card[GameScreen.instance.playerCards[var4].length];
                    this.innerArrayLength = this.otherPlayersCards[var1].length;
                    int var7;
                    if ((var7 = (Screen.screenWidth - this.cardWidth) / (this.innerArrayLength > 1 ? this.innerArrayLength - 1 : 1)) > this.cardWidth) {
                        var7 = this.cardWidth;
                    }

                    int var5 = Screen.screenWidth - ((this.innerArrayLength > 1 ? (this.innerArrayLength - 1) * var7 : 0) + this.cardWidth) >> 1;
                    int var6 = 0;
                    if (var3 == 0) {
                        var6 = Screen.screenHeight - cardBottomY;
                    } else if (var3 == 1) {
                        var5 = Screen.screenWidth - this.cardWidth - (this.innerArrayLength > 1 ? this.innerArrayLength - 1 : 1) * var7 - 1;
                        var6 = Screen.screenHeight >> 1;
                    } else if (var3 != 2 && var3 == 3) {
                        var5 = 1;
                        var6 = (Screen.screenHeight >> 1) - 65;
                    }

                    for (int var8 = 0; var8 < this.innerArrayLength; var8++) {
                        this.otherPlayersCards[var1][var8] = new Card();
                        this.otherPlayersCards[var1][var8].cardValue = GameScreen.instance.playerCards[var4][var8];
                        this.otherPlayersCards[var1][var8].rank = (byte) (GameScreen.instance.playerCards[var4][var8] >> 2);
                        this.otherPlayersCards[var1][var8].suit = (byte) (GameScreen.instance.playerCards[var4][var8] % 4);
                        this.otherPlayersCards[var1][var8].posX = var5 + var8 * var7;
                        this.otherPlayersCards[var1][var8].posY = var6;
                        if (var8 == this.otherPlayersCards[var1].length - 1) {
                            this.otherPlayersCards[var1][var8].isLast = true;
                        }
                    }
                    break;
                }
            }
        }
    }

    private boolean validateMove(Card[] var1) {
        System.gc();
        boolean var2 = false;

        int[] var9;
        try {
            Card[] var3 = var1;
            int var4;
            int[] var5 = new int[var4 = var1.length];
            var4 = var4;

            while (--var4 >= 0) {
                var5[var4] = var3[var4].cardValue;
            }

            var9 = var5;
        } catch (Exception var6) {
            return false;
        }

        if (!this.gameEnded && FriendScreen.username.equals(this.currentPlayer)) {
            if (this.isFirstMove && getFirstCardValue(var1) == getFirstCardValue(handCards)) {
                if (var2 = this.isValidCombination(var9, 0)) {
                    this.isFirstMove = false;
                }
            } else if (!this.isFirstMove && (var2 = this.isValidCombination(var9, 0)) && !this.isWaiting) {
                int var13 = 0;
                Card[] var16 = this.animationCards;
                var13 = this.lastMoveType;
                var1 = selectedCards;
                int var10 = currentMoveType;
                var2 = false;
                if (var10 == var13) {
                    if (var1.length == var16.length && var1[var1.length - 1].cardValue > var16[var16.length - 1].cardValue) {
                        var2 = true;
                    }
                } else if (var16[var16.length - 1].rank == 15) {
                    if (var16.length != 1 || var10 != 10 && var10 != 11 && var10 != 12) {
                        if (var16.length == 2 && (var10 == 11 || var10 == 12)) {
                            var2 = true;
                        }
                    } else {
                        var2 = true;
                    }
                } else if (var13 != 10 || var10 != 12 && var10 != 11) {
                    if (var13 == 11 && var10 == 12) {
                        var2 = true;
                    }
                } else {
                    var2 = true;
                }

                var2 = var2;
            }
        } else {
            boolean var12 = false;
            boolean var15 = var9.length == 8 && this.isDoubleStraight(var9, 0);

            if (var15) {
                if (this.lastMoveType != 10 && this.lastMoveType != 11 && (this.animationCards.length != 1 && this.animationCards.length != 2 || this.animationCards[this.animationCards.length - 1].rank != 15)) {
                    var2 = false;
                } else {
                    currentMoveType = 12;
                    var2 = true;
                }
            } else {
                var2 = false;
            }
        }

        System.gc();
        return var2;
    }

    private static int getFirstCardValue(Card[] var0) {
        return var0.length == 0 ? 0 : var0[0].cardValue;
    }

    private boolean isValidCombination(int[] var1, int var2) {
        boolean var6 = false;
        byte var3 = 0;
        boolean var4;
        if (var1.length == 1) {
            currentMoveType = 1;
            var4 = true;
        } else if (var1.length == 2) {
            var4 = false;
            int[] var5;
            if ((var5 = this.getCardRanks(var1)).length == 2 && var5[0] == var5[1]) {
                var4 = true;
            }

            if (var4 && var3 == 1 && !this.isOppositeColor(var1[0], var1[1]) && var5[0] != 15) {
                var4 = false;
            }

            if (var4 = var4) {
                currentMoveType = 2;
            }
        } else if (var1.length == 3) {
            if (var4 = this.isStraight(var1, var3)) {
                currentMoveType = 4;
            } else {
                int[] var8;
                if (var4 = (var8 = this.getCardRanks(var1)).length == 3 && var8[0] == var8[1] && var8[1] == var8[2]) {
                    currentMoveType = 3;
                }
            }
        } else if (var1.length == 4) {
            if (var4 = this.isStraight(var1, var3)) {
                currentMoveType = 4;
            } else {
                var4 = false;
                int[] var10;
                if ((var10 = this.getCardRanks(var1)).length == 4 && var10[0] == var10[1] && var10[2] == var10[3] && var10[0] == var10[2]) {
                    var4 = true;
                }

                if (var4 = var4) {
                    currentMoveType = 11;
                }
            }
        } else if (var1.length == 5) {
            if (var4 = this.isStraight(var1, var3)) {
                currentMoveType = 4;
            }
        } else if (var1.length == 6) {
            if (var4 = this.isStraight(var1, var3)) {
                currentMoveType = 4;
            } else if (var4 = this.isDoubleStraight(var1, var3)) {
                currentMoveType = 10;
            }
        } else if (var1.length == 7) {
            if (var4 = this.isStraight(var1, var3)) {
                currentMoveType = 4;
            }
        } else if (var1.length == 8) {
            if (var4 = this.isStraight(var1, var3)) {
                currentMoveType = 4;
            } else if (var4 = this.isDoubleStraight(var1, var3)) {
                currentMoveType = 12;
            }
        } else if (var1.length == 9) {
            if (var4 = this.isStraight(var1, var3)) {
                currentMoveType = 4;
            }
        } else if (var1.length == 10) {
            if (var4 = this.isStraight(var1, var3)) {
                currentMoveType = 4;
            }
        } else if (var1.length == 11) {
            if (var4 = this.isStraight(var1, var3)) {
                currentMoveType = 4;
            }
        } else if (var1.length == 12) {
            if (var4 = this.isStraight(var1, var3)) {
                currentMoveType = 4;
            }
        } else {
            var4 = false;
        }

        return var4;
    }

    private boolean isDoubleStraight(int[] var1, int var2) {
        boolean var3 = false;
        if (var1.length % 2 == 0) {
            int var4;
            int[] var5 = new int[var4 = var1.length >> 1];
            int[] var6 = new int[var4];

            for (int var7 = 0; var7 < var4; var7++) {
                var5[var7] = var1[var7 << 1];
                var6[var7] = var1[1 + (var7 << 1)];
            }

            int var8;
            int var9;
            if (this.isStraight(var5, var2) && this.isStraight(var6, var2) && (var8 = var5[0]) >> 2 == (var9 = var6[0]) >> 2) {
                var3 = var2 != 1 || this.isOppositeColor(var5[0], var6[0]);
            }
        }

        return var3;
    }

    private boolean isStraight(int[] var1, int var2) {
        boolean var3 = true;
        int var4 = 0;
        int[] var5;
        if ((var5 = this.getCardRanks(var1))[var5.length - 1] == 15) {
            var3 = false;
        } else {
            int var6 = 0;

            for (int var9 = var5.length - 1; var6 < var9; var6++) {
                if (var5[var6 + 1] - 1 != var5[var6]) {
                    var3 = false;
                    break;
                }
            }
        }

        if (var2 == 1 && var3) {
            var4 = var1.length;

            for (int var11 = 1; var11 < var4; var11++) {
                if ((var2 = var1[var11]) % 4 != (var2 = var1[var11 - 1]) % 4) {
                    var3 = false;
                    break;
                }
            }
        }

        return var3;
    }

    private int[] getCardRanks(int[] var1) {
        int var2;
        int[] var3 = new int[var2 = var1.length];
        var2 = var2;

        while (--var2 >= 0) {
            int var4;
            var3[var2] = (var4 = var1[var2]) >> 2;
        }

        return var3;
    }

    private boolean isOppositeColor(int var1, int var2) {
        return var1 % 4 + var2 % 4 == 1 || var1 % 4 + var2 % 4 == 5;
    }

    public boolean handleDirectKeyPress(int var1) {
        return false;
    }

    private void drawCard(Graphics var1, Card var2) {
        int var5 = var2.posY;
        int var4 = var2.posX;
        var1.drawRegion(GameManager.cardImage, 0, 0, 40, 54, 0, var4, var5, 20);
        this.drawCardContent(var1, var2.posX, var2.posY, var2.isLast, var2.rank, var2.suit);
    }

    private void drawCardContent(Graphics var1, int var2, int var3, boolean var4, int var5, int var6) {
        int var10004 = var2 + 7;
        int var11 = var3 + 8;
        int var10 = var10004;
        int var10003 = var5 - 3;
        boolean var17 = var6 == 0 || var6 == 1;
        boolean var15 = var5 == 10;
        boolean var13 = var17;
        int var9 = var10003;
        var1.drawRegion(GameManager.chatBackground, cardValueOffsets[var9], var13 ? 0 : 9, var15 ? 8 : 6, 9, 0, var10, var11, 3);
        var10003 = var2 + 7;
        var10 = var3 + 19;
        var9 = var10003;
        var1.drawRegion(GameManager.gameBackground, var6 << 3, 0, 8, 8, 0, var9, var10, 3);
        switch (var5) {
            case 11:
                if (var6 != 0 && var6 != 1) {
                    var1.drawRegion(GameManager.decorationImage, 23, 0, 23, 37, 0, var9 + 5, var10 - 7, 20);
                    return;
                }

                var1.drawRegion(GameManager.decorationImage, 0, 0, 23, 37, 0, var9 + 5, var10 - 7, 20);
                return;
            case 12:
                if (var6 != 0 && var6 != 1) {
                    var1.drawRegion(GameManager.decorationImage, 26, 37, 26, 43, 0, var9 + 3, var10 - 13, 20);
                    return;
                }

                var1.drawRegion(GameManager.decorationImage, 0, 37, 26, 43, 0, var9 + 3, var10 - 13, 20);
                return;
            case 13:
                if (var6 != 0 && var6 != 1) {
                    var1.drawRegion(GameManager.decorationImage, 23, 80, 23, 41, 0, var9 + 5, var10 - 11, 20);
                    return;
                }

                var1.drawRegion(GameManager.decorationImage, 0, 80, 23, 41, 0, var9 + 5, var10 - 11, 20);
                return;
            default:
                switch (var6) {
                    case 0:
                        var1.drawRegion(GameManager.emojiImage, 72, 0, 22, 31, 0, var9 + 6, var10 - 3, 20);
                        return;
                    case 1:
                        var1.drawRegion(GameManager.emojiImage, 47, 0, 26, 31, 0, var9 + 2, var10 - 3, 20);
                        return;
                    case 2:
                        var1.drawRegion(GameManager.emojiImage, 23, 0, 24, 31, 0, var9 + 2, var10 - 2, 20);
                        return;
                    case 3:
                        var1.drawRegion(GameManager.emojiImage, 0, 0, 23, 31, 0, var9 + 4, var10 - 3, 20);
                }
        }
    }

    private static void drawCardBack(Graphics var0, int var1, int var2) {
        var0.drawRegion(GameManager.cardImage, 80, 0, 40, 54, 0, var1, var2, 20);
    }
}
