package coding.leetcode.crashcourse;

import java.util.Set;
import lombok.experimental.UtilityClass;

class Arrays {

  /**
   * @see <a href="https://leetcode.com/problems/is-subsequence/">392. Is Subsequence</a>
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
   * @see <a href="https://leetcode.com/problems/reverse-string/">344. Reverse String</a>
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
   * @see <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">977. Squares of a Sorted Array</a>
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
   * @see <a href="https://leetcode.com/problems/maximum-average-subarray-i/">643. Maximum Average Subarray I</a>
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

  /**
   * @see <a href="https://leetcode.com/problems/max-consecutive-ones-iii/">1004. Max Consecutive Ones III</a>
   */
  @UtilityClass
  class Problem1004 {

    public int longestOnes(int[] nums, int k) {
      int pl = 0;
      int pr = 0;
      int res = 0;
      int zs = 0;
      while (pr < nums.length) {
        // right
        while (pr < nums.length) {
          if (zs == k && nums[pr] == 0) {
            break;
          }
          if (nums[pr] == 0) {
            zs++;
          }
          pr++;
        }
        res = Math.max(res, pr - pl);
        // left
        while (pl < nums.length) {
          if (zs < k) {
            break;
          }
          if (nums[pl] == 0) {
            zs--;
          }
          pl++;
        }

      }

      res = Math.max(res, pr - pl);
      return res;
    }

  }


  /**
   * @see <a href="https://leetcode.com/problems/running-sum-of-1d-array/">1480. Running Sum of 1d Array</a>
   */
  @UtilityClass
  class Problem1480 {

    public int[] runningSum(int[] nums) {
      int[] result = new int[nums.length];
      result[0] = nums[0];
      for (int i = 1; i < nums.length; i++) {
        result[i] = nums[i] + result[i - 1];
      }
      return result;
    }

  }

  /**
   * @see <a href="https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/">1413. Minimum Value to Get Positive Step by Step Sum</a>
   */
  @UtilityClass
  class Problem1413 {

    public int minStartValue(int[] nums) {
      var limit = 1;
      var res = 1;
      var acc = 1;
      for (int num : nums) {
        acc += num;
        if (acc < limit) {
          res += Math.abs(limit - acc);
          acc = limit;
        }
      }
      return res;
    }

  }

  /**
   * @see <a href="https://leetcode.com/problems/reverse-prefix-of-word/">2000. Reverse Prefix of Word</a>
   */
  @UtilityClass
  class Problem2000 {

    String reversePrefix(String word, char ch) {
      var ca = word.toCharArray();
      for (var p = 0; p < ca.length; p++) {
        if (ca[p] == ch) {
          reverseString(ca, 0, p);
          return new String(ca);
        }
      }
      return word;
    }

    void reverseString(char[] s, int left, int right) {
      while (left < right) {
        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
      }
    }
  }


  /**
   * @see <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">209. Minimum Size Subarray Sum</a>
   */
  @UtilityClass
  class Problem209 {

    public int minSubArrayLen(int target, int[] nums) {
      var res = Integer.MAX_VALUE;
      var sum = 0;
      var pl = 0;
      var pr = 0;
      while (pr < nums.length) {
        // reach sum
        while (pr < nums.length && sum < target) {
          sum += nums[pr];
          pr++;
          if (sum >= target) {
            res = Math.min(res, pr - pl);
          }
        }
        // shorten windows
        while (pl < nums.length && sum >= target) {
          sum -= nums[pl];
          pl++;
          if (sum >= target) {
            res = Math.min(res, pr - pl);
          }
        }
      }
      return res == Integer.MAX_VALUE ? 0 : res;
    }


  }


  /**
   * @see <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">1456. Maximum Number of Vowels in a Substring of Given Length</a>
   */
  @UtilityClass
  class Problem1456 {

    public int maxVowels(String s, int k) {
      var vowels = Set.of('a', 'e', 'i', 'o', 'u');
      var cs = s.toCharArray();
      var pl = 0;
      var pr = k;
      var res = 0;
      var acc = 0;
      for (var i = 0; i < k; i++) {
        if (vowels.contains(cs[i])) {
          acc++;
        }

      }

      res = Math.max(res, acc);
      while (pr < cs.length) {
        if (vowels.contains(cs[pr])) {
          acc++;
        }
        pr++;
        if (vowels.contains(cs[pl])) {
          acc--;
        }
        pl++;
        res = Math.max(res, acc);
      }
      return res;
    }

  }

  /**
   * @see <a href="https://leetcode.com/problems/get-equal-substrings-within-budget/">1208. Get Equal Substrings Within Budget</a>
   */
  @UtilityClass
  class Problem1208 {

    public int equalSubstring(String s, String t, int maxCost) {
      var as = s.toCharArray();
      var at = t.toCharArray();
      var pl = 0;
      var pr = 0;
      var res = 0;
      var cost = 0;
      while (pr < as.length) {

        while (pr < as.length && cost <= maxCost) {
          cost += Math.abs(as[pr] - at[pr]);
          pr++;
          if (cost <= maxCost) {
            res = Math.max(res, pr - pl);
          }
        }
        // shorten windows
        while (pl < as.length && cost > maxCost) {
          cost -= Math.abs(as[pl] - at[pl]);
          pl++;
          if (cost <= maxCost) {
            res = Math.max(res, pr - pl);
          }
        }
      }
      return res;
    }
  }

  /**
   * @see <a href="https://leetcode.com/problems/find-the-highest-altitude/">1732. Find the Highest Altitude</a>
   */
  @UtilityClass
  class Problem1732 {

    public int largestAltitude(int[] gain) {
      var prev = 0;
      var max = 0;
      for (var g : gain) {
        max = Math.max(max, prev + g);
        prev = prev + g;
      }
      return max;
    }
  }

  /**
   * @see <a href="https://leetcode.com/problems/find-the-highest-altitude/">1732. Find the Highest Altitude</a>
   */
  @UtilityClass
  class Problem724 {

    public int pivotIndex(int[] nums) {
      if (nums.length == 1) {
        return 0;
      }
      var lrsa = new int[nums.length];
      var rlsa = new int[nums.length];
      var prev = 0;
      for (var i = 0; i < nums.length; i++) {
        lrsa[i] = prev + nums[i];
        prev = lrsa[i];
      }
      prev = 0;
      for (var i = nums.length - 1; i > -1; i--) {
        rlsa[i] = prev + nums[i];
        prev = rlsa[i];
      }
      if (rlsa[1] == 0) {
        return 0;
      }

      for (var i = 1; i < nums.length - 1; i++) {
        if (lrsa[i - 1] == rlsa[i + 1]) {
          return i;
        }
      }

      if (lrsa[nums.length - 2] == 0) {
        return nums.length - 1;
      }

      return -1;
    }

  }

  /**
   * @see <a href="https://leetcode.com/problems/range-sum-query-immutable/">303. Range Sum Query - Immutable</a>
   */

  @UtilityClass
  class Problem303 {

    static class NumArray {

      private int[] prefixSum;

      public NumArray(int[] nums) {
        buildArraySuffix(nums);
      }

      private void buildArraySuffix(int[] nums) {
        prefixSum = new int[nums.length];
        var prev = 0;
        for (int i = 0; i < nums.length; i++) {
          prefixSum[i] = prev + nums[i];
          prev = prev + nums[i];
        }
      }

      public int sumRange(int left, int right) {
        return prefixSum[right] - (left == 0 ? 0 : prefixSum[left-1]);
      }
    }

  }




}