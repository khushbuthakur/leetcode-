public class _7 {

  /**
   * 7. Reverse Integer
   *
   * https://leetcode.com/problems/reverse-integer/
   *
   * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the
   * value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
   *
   * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
   *
   *
   *
   * Example 1:
   *
   * Input: x = 123 Output: 321 Example 2:
   *
   * Input: x = -123 Output: -321 Example 3:
   *
   * Input: x = 120 Output: 21 Example 4:
   *
   * Input: x = 0 Output: 0
   *
   *
   * Constraints:
   *
   * -231 <= x <= 231 - 1
   */

  public static void main(String[] args) {
    System.out.println(reverse(123)); // 321
    System.out.println(reverse(-9812));
    System.out.println(reverse(1534236469));
  }

  public static int reverse(int x) {

    int res = 0,
        cur = 0,
        prev = 0,
        s = 1;

    // make number positive if it was negative, but also save it to again make it negative at the end
    if (x < 0) {
      s = -1;
      x *= s;
    }

    while (x > 0) {
      cur = x % 10; // get last digit
      x /= 10; // remove last digit

      res = res * 10 + cur; // add this last digit to reverse number

      // undo last action and see if the numbers are same
      /**
       * based on 2's complement,
       *  7 : 0111
       *  8 : 1000
       *
       *  so if we remove from 1 from 8, it is 7
       *
       *  in the same way, like we multiplied number by 10 and added last digit,
       *  if we undo it, it should be same
       */
      if ((res - cur) / 10 != prev) {
        return 0;
      }
      prev = res;
    }

    return res * s; // multiply by factor, in case the number was negative
  }
}
