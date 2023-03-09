package coding.leetcode.crashcourse;

import lombok.experimental.UtilityClass;

class Arrays {

  /**
   * <a href="https://leetcode.com/problems/is-subsequence/">392. Is Subsequence</a>
   */
  @UtilityClass
  static class Problem392 {

    boolean isSubsequence(String s, String t) {
      var ps = 0;
      var pt = 0;

      while (ps < s.length()) {
        if (pt >= t.length()) {
          return false;
        }
        if (s.codePointAt(ps) == t.codePointAt(pt)) {
          ps++;
        }
        pt++;
      }
      return true;
    }
  }


  /**
   * <a href="https://leetcode.com/problems/reverse-string/">344. Reverse String</a>
   */
  @UtilityClass
  class Problem344 {

    void reverseString(char[] s) {
      int left = 0;
      int right = s.length - 1;
      while (left < right) {
        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
      }
    }
  }

  /**
   * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">977. Squares of a Sorted Array</a>
   */
  @UtilityClass
  class Problem977 {

    // we will use 2 pointers to create the resulting list
    // after squaring we could have the list of similar structure  - [100, 30, 9, 0, 9, 30, 100]
    int[] sortedSquares(int[] nums) {
      int n = nums.length;
      int[] result = new int[n];

      int left = 0;
      int right = n - 1;
      int square;
      for (int i = 0; i < n; i++) {
        if (Math.abs(nums[left]) < Math.abs(nums[right])) {
          square = nums[right];
          right--;
        } else {
          square = nums[left];
          left++;
        }
        result[n - i - 1] = square * square;
      }
      return result;
    }
  }


  /**
   * <a href="https://leetcode.com/problems/maximum-average-subarray-i/">643. Maximum Average Subarray I</a>
   */
  @UtilityClass
  class Problem643 {

    public double findMaxAverage(int[] nums, int k) {
      var pl = 0;
      var pr = k - 1;
      double resAcc = 0;
      for (int i = 0; i < k; i++) {
        resAcc += nums[i];
      }
      double res = resAcc / k;

      while (pr < nums.length - 1) {
        resAcc -= nums[pl];
        pl++;
        pr++;
        resAcc += nums[pr];
        res = Math.max(res, resAcc / k);
      }
      return res;
    }
  }

}
