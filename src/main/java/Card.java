public final class Card {
   public int cardValue;
   public int rank; //95% Lý do: Rank/số của lá bài (3-15), tính bằng cardValue >> 2
   public int suit; //95% Lý do: Chất của lá bài (0-3: spades, clubs, diamonds, hearts), tính bằng cardValue % 4
   public boolean isLast; //Lý do: Đánh dấu lá bài cuối cùng trong nhóm/tay bài
   public boolean isSelected;
   public boolean isRemoved;
   public int posX;
   public int posY;

   public final void setPosition(int var1, int var2) {
      this.posX = var1;
      this.posY = var2;
   }
}
