package home.thienph.xyahoo107.constants;

public final class TextConstant {
   private static int LANGUAGE_ID = 1;
   private static final String[] CLOSE = new String[]{"Close", "Đóng"};
   private static final String[] CLICK_HERE = new String[]{"Click here:", "Bấm vào đây:"};
   private static final String[] BACK = new String[]{"Back", "Trở về"};
   private static final String[] SENDING = new String[]{"Sending: ", "Đang gửi: "};
   public static String BAN_CHUA_CO_TRONG_DANH_SACH = "Chưa có bạn trong danh sách";
   private static final String[] DECLINE = new String[]{"Decline", "Từ chối"};
   private static String[] START = new String[]{"Start", "Bắt đầu"};

   public static String sending() {
      return SENDING[LANGUAGE_ID];
   }

   public static String back() {
      return BACK[LANGUAGE_ID];
   }

   public static String close() {
      return CLOSE[LANGUAGE_ID];
   }

   public static String clickHere() {
      return CLICK_HERE[LANGUAGE_ID];
   }

   public static String decline() {
      return DECLINE[LANGUAGE_ID];
   }

   public static String start() {
      return START[LANGUAGE_ID];
   }
}
