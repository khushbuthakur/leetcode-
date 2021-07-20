import java.util.*;

public class _448 {

  /**
   * 448. Find All Numbers Disappeared in an Array
   * Problem: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
   *
   * Given an array nums of n integers where nums[i] is in the range [1, n],
   * return an array of all the integers in the range [1, n] that do not appear in nums.
   *
   * Example 1:
   *
   * Input: nums = [4,3,2,7,8,2,3,1]
   * Output: [5,6]
   * Example 2:
   *
   * Input: nums = [1,1]
   * Output: [2]
   *
   * Constraints:
   *
   * n == nums.length
   * 1 <= n <= 105
   * 1 <= nums[i] <= n
   *
   *
   * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
   *
   * Video Explanation : https://www.youtube.com/watch?v=jSfDPVIYe1s
   */

  /**
   * Time complexity : O(n) Space complexity : O(1)
   */

  public static class Solution {

    public static void main(String[] args) {
      Solution solution = new Solution();
      int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
      solution.findDisappereadNumbers(nums); // [5,6];
    }

    public List<Integer> findDisappereadNumbers(int[] nums) {
      // [4, 3, 2, 7, 8, 2, 3, 1]
      //  0  1  2  3  4  5  6  7

      for (int i = 0; i < nums.length; i++) {

        /**
         * i = 0
         * nums[i] = 4
         * nums[4-1] = nums[3] = 7
         * nums[3] = -7
         *
         * i = 1
         * nums[i] = 3
         * nums[3-1] = nums[2] = 2
         * nums[2] = -2
         *
         * i = 2
         * nums[2] = -2
         * Math.abs(-2) = 2
         *
         * nums[2-1] = nums[1] = 3
         * nums[1] = -3
         */

        /***
         * always take abs value, as this might be already negated in some operation,
         * like in above at index 2
         *
         * as we have values from 1 to n
         * so 1 to 8
         * and index start from 0
         *
         * so for 1, we will change value at 0th index
         * for 8 we will change value at 7th index
         *
         * and when looking up, we will add 1 again
         */

        int current = Math.abs(nums[i]) - 1;

        /*** change value only if it is not negative,
         * we do not want to make negative value, positive again
         */

        if (nums[current] > 0) {
          nums[current] = -nums[current];
        }
      }

      // [-4, -3, -2, -7, 8, 2, -3, -1]
      // 0    1    2   3  4  5   6   7

      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < nums.length; i++) {
        /**
         * in above array since value 5 and 6 is missing, so values at that index are positive
         */
        if (nums[i] > 0) {
          /**
           * we are adding 1 again, because we did all manipulations at i - 1 index
           */
          list.add(i + 1);
        }
      }

      return list;
    }
  }





}
