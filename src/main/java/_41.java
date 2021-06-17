public class _41 {

  /**
   * Problem : https://leetcode.com/problems/first-missing-positive/
   * Solution : https://www.youtube.com/watch?v=9SnkdYXNIzM
   *
   * Given an unsorted integer array nums, find the smallest missing positive integer.
   *
   * You must implement an algorithm that runs in O(n) time and uses constant extra space.
   *
   * Example 1:
   *
   * Input: nums = [1,2,0] Output: 3 Example 2:
   *
   * Input: nums = [3,4,-1,1] Output: 2 Example 3:
   *
   * Input: nums = [7,8,9,11,12] Output: 1
   *
   * Constraints:
   *
   * 1 <= nums.length <= 5 * 105 -231 <= nums[i] <= 231 - 1
   */

  public static class Solution {

    public int firstMissingPositive(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }

      int n = nums.length;
      boolean foundOne = false;

      /* swap all negative numbers and numbers
          greater than length + 1 of array with 1
       */

      for (int i = 0; i < n; i++) {
        if (nums[i] == 1) {
          foundOne = true;
        } else if (nums[i] <= 0 || nums[i] > n + 1) {
          nums[i] = 1;
        }
      }

      if (foundOne == false) {
        return 1;
      }

       /*
           to indicate that we have seen current number,
           we will change the value at the index of this number to a
           negative number.

           mark numbers as negative to indicate that
           we have seen this index + 1
        */

      for (int i = 0; i < n; i++) {
        int num = Math.abs(nums[i]) - 1;

        if (nums[num] > 0) {
          nums[num] = -1 * nums[num];
        }
      }

      for (int i = 0; i < n; i++) {
        if (nums[i] > 0) {
          return i + 1;
        }
      }

      return n + 1;
    }
  }
}
