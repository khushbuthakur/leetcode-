public class _9 {

  /**
   * Given an integer x, return true if x is palindrome integer.
   * <p>
   * An integer is a palindrome when it reads the same backward as forward. For example, 121 is
   * palindrome while 123 is not.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: x = 121 Output: true Example 2:
   * <p>
   * Input: x = -121 Output: false Explanation: From left to right, it reads -121. From right to
   * left, it becomes 121-. Therefore it is not a palindrome. Example 3:
   * <p>
   * Input: x = 10 Output: false Explanation: Reads 01 from right to left. Therefore it is not a
   * palindrome. Example 4:
   * <p>
   * Input: x = -101 Output: false
   * <p>
   * <p>
   * Constraints:
   * <p>
   * -231 <= x <= 231 - 1
   * <p>
   * <p>
   * Follow up: Could you solve it without converting the integer to a string?
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(isPalindrome(121)); // true
    System.out.println(isPalindrome(1221)); // true
    System.out.println(isPalindrome(12321)); // true
    System.out.println(isPalindrome(-12321)); // false
    System.out.println(isPalindrome(-10)); // false
    System.out.println(isPalindrome(100)); // false

    /**
     * true
     * true
     * true
     * false
     * false
     * true
     */
  }

  public static boolean isPalindrome(int x) {

    /**
     * we can do early exit for negative numbers, and also numbers which have 0 the end
     * because reverse would be
     * 100 -> 001
     */

    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }
    /**
     * 1221
     * 12321
     *
     * we can check half number
     *
     * i.e. take 12
     * reverse 2nd half
     * if they are equal, then numbers are equal
     */

    int rev = 0;

    while (x > rev) {
      // add last digit to reverse number
      rev = rev * 10 + x % 10;
      // remove last digit from reverse number
      x /= 10;
    }

    /**
     * in case of even digit
     * first half and 2nd half will have equal number of digits
     *
     * but in case of odd,
     * one half will have 1 extra
     * so we can just drop this digit
     * for e.g. in case of 12321
     *
     * 12,  123
     * drop 3
     * 123 / 10
     *
     * 12 == 123 / 10 -> true
     *
     */
    return rev == x || x == rev / 10;
  }
}
