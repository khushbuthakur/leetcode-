public class _14 {

  public static void main(String[] args) {
    String[] str2 = {"c", "acc", "ccc"};
    System.out.println(longestCommonPrefix(str2));

    String[] strs = {"flower", "flow", "flight"};
    System.out.println(longestCommonPrefix(strs));

    String[] strs1 = {"aa", "ab"};
    System.out.println(longestCommonPrefix(strs1));
  }

  public static String longestCommonPrefix(String[] strs) {
    String s = strs[0];

    for (int i = 1; i < strs.length; i++) {


    }

    return s;
  }

  public static String longestCommonPrefix1(String[] strs) {
    StringBuilder sb = new StringBuilder();
    int totalLength = strs.length - 1;

    for (char c : strs[0].toCharArray()) {
      int count = 0;
      String s = sb.toString() + String.valueOf(c);
      for (int i = 1; i < strs.length; i++) {
        if (strs[i].contains(s)) {
          count++;
        }
      }

      if (count == totalLength) {
        sb.append(c);
      } else {
        break;
      }
    }

    return sb.toString();
  }
}
