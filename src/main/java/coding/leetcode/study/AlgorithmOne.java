package coding.leetcode.study;

/**
 * https://leetcode.com/study-plan/algorithm
 */
public class AlgorithmOne {

  /**
   * <a href="https://leetcode.com/problems/binary-search/">704. Binary search</a>
   */
  static class Problem704 {

    static int search(int[] nums, int target) {
      int pivot, left = 0, right = nums.length - 1;
      while (left <= right) {
        pivot = left + (right - left) / 2;
        if (nums[pivot] == target) {
          return pivot;
        }
        if (target < nums[pivot]) {
          right = pivot - 1;
        } else {
          left = pivot + 1;
        }
      }
      return -1;
    }
  }

  /**
   * <a href="https://leetcode.com/problems/first-bad-version/">278. First Bad Version</a>
   */
  static class Problem278 {

    interface VersionControl {

      boolean isBadVersion(int version);
    }

    abstract static class Solution implements VersionControl {

      public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
          int mid = left + (right - left) / 2;
          if (isBadVersion(mid)) {
            right = mid;
          } else {
            left = mid + 1;
          }
        }
        return left;
      }
    }
  }

  /**
   * <a href="https://leetcode.com/problems/search-insert-position/">35. Search Insert Position</a>
   */
  static class Problem035 {

    static int searchInsert(int[] nums, int target) {
      int pivot;
      int left = 0;
      int right = nums.length - 1;
      while (left <= right) {
        pivot = left + (right - left) / 2;
        if (nums[pivot] == target) {
          return pivot;
        }
        if (target < nums[pivot]) {
          right = pivot - 1;
        } else {
          left = pivot + 1;
        }
      }
      return left;
    }
  }

  /**
   * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">977. Squares of a Sorted Array</a>
   */
  static class Problem977 {

    // we will use 2 pointers to create the resulting list
    // after squaring we could have the list of similar structure  - [100, 30, 9, 0, 9, 30, 100]
    static int[] sortedSquares(int[] nums) {
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
   * <a href="https://leetcode.com/problems/rotate-array/">189. Rotate Array</a>
   */
  static class Problem189 {

    static void rotate(int[] nums, int k) {
      rotate2(nums, k);
    }

    static void rotate1(int[] nums, int k) {
      int[] a = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        a[(i + k) % nums.length] = nums[i];
      }
      System.arraycopy(a, 0, nums, 0, nums.length);
    }

    static void rotate2(int[] nums, int k) {
      k %= nums.length;
      reverse(nums, 0, nums.length - 1);
      reverse(nums, 0, k - 1);
      reverse(nums, k, nums.length - 1);
    }

    static void reverse(int[] nums, int start, int end) {
      while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
      }
    }
  }


  /**
   * <a href="https://leetcode.com/problems/move-zeroes/">283. Move Zeroes</a>
   */
  static class Problem283 {

    static void moveZeroes(int[] nums) {
      int nzPointer = 0;
      for (int pointer = 0; pointer < nums.length; pointer++) {
        while (nzPointer < nums.length && nums[nzPointer] == 0) {
          nzPointer += 1;
        }
        if (nzPointer >= nums.length) {
          return;
        }
        int val = nums[nzPointer];
        nums[nzPointer] = nums[pointer];
        nums[pointer] = val;
        nzPointer++;
      }

    }

  }

  /**
   * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">167. Two Sum II - Input Array Is Sorted</a>
   */
  static class Problem167 {

    static int[] twoSum(int[] numbers, int target) {
      int leftPointer = 0;
      int rightPointer = numbers.length - 1;
      while (leftPointer < rightPointer) {
        int curSum = numbers[leftPointer] + numbers[rightPointer];
        if (curSum == target) {
          return new int[] {leftPointer + 1, rightPointer + 1};
        } else if (curSum > target) {
          rightPointer -= 1;
        } else {
          leftPointer += 1;
        }
      }
      return new int[] {-1, -1};
    }
  }
}
