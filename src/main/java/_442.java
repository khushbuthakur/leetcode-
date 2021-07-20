import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _442 {

  /**
   * Given an integer array nums of length n where all the integers of nums are
   * in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
   *
   * You must write an algorithm that runs in O(n) time and uses only constant extra space.
   *
   * Example 1:
   *
   * Input: nums = [4,3,2,7,8,2,3,1]
   * Output: [2,3]
   * Example 2:
   *
   * Input: nums = [1,1,2]
   * Output: [1]
   * Example 3:
   *
   * Input: nums = [1]
   * Output: []
   *
   *
   * Constraints:
   *
   * n == nums.length
   * 1 <= n <= 105
   * 1 <= nums[i] <= n
   * Each element in nums appears once or twice.
   */


  /**
   * when find a number i, flip the number at position i-1 to negative. if the number at position
   * i-1 is already negative, i is the number that occurs twice.
   */

  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> list = new ArrayList<>();
    if (nums.length < 2) {
      return list;
    }

    for (int i = 0; i < nums.length; i++) {
      int val = Math.abs(nums[i]);

      if (nums[val - 1] > 0) {
        nums[val - 1] = -1 * nums[val - 1];
      } else {
        list.add(val);
      }
    }

    return list;
  }

  /**
   * Runtime: 5 ms, faster than 89.97% of Java online submissions for Find All Duplicates in an
   * Array. Memory Usage: 47.8 MB, less than 70.99% of Java online submissions for Find All
   * Duplicates in an Array.
   */

  // alternative but is not O(n)
  public List<Integer> findDuplicates1(int[] nums) {
    List<Integer> list = new ArrayList<>();
    if (nums.length < 2) {
      return list;
    }

    HashSet<Integer> res = new HashSet<>();

    for (int n : nums) {
      if (res.contains(n)) {
        list.add(n);
      } else {
        res.add(n);
      }
    }

    return list;
  }

  /**
   * For above solution
   * Runtime: 16 ms, faster than 29.62% of Java online submissions for Find All Duplicates in an Array.
   * Memory Usage: 47.9 MB, less than 70.99% of Java online submissions for Find All Duplicates in an Array.
   */
}
