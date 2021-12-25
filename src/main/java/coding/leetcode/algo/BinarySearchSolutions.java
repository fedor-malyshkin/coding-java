package coding.leetcode.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Search Solutions.
 */
public class BinarySearchSolutions {

  /**
   * https://leetcode.com/explore/learn/card/binary-search/126/template-ii/948/
   */
  static int findPeakElement(int[] nums) {
    return findPeakElementSearch(nums, 0, nums.length - 1);
  }

  static int findPeakElementSearch(int[] nums, int l, int r) {
    if (l == r) {
      return l;
    }
    int mid = (l + r) / 2;
    if (nums[mid] > nums[mid + 1]) {
      return findPeakElementSearch(nums, l, mid);
    }
    return findPeakElementSearch(nums, mid + 1, r);
  }

  static int findMin(int[] nums) {
    // If the list has just one element then return that element.
    if (nums.length == 1) {
      return nums[0];
    }

    // initializing left and right pointers.
    int left = 0, right = nums.length - 1;

    // if the last element is greater than the first element then there is no rotation.
    // e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
    // Hence the smallest element is first element. A[0]
    if (nums[right] > nums[0]) {
      return nums[0];
    }

    // Binary search way
    while (right >= left) {
      // Find the mid element
      int mid = left + (right - left) / 2;

      // if the mid element is greater than its next element then mid+1 element is the smallest
      // This point would be the point of change. From higher to lower value.
      if (nums[mid] > nums[mid + 1]) {
        return nums[mid + 1];
      }

      // if the mid element is lesser than its previous element then mid element is the smallest
      if (nums[mid - 1] > nums[mid]) {
        return nums[mid];
      }

      // if the mid elements value is greater than the 0th element this means
      // the least value is still somewhere to the right as we are still dealing with elements
      // greater than nums[0]
      if (nums[mid] > nums[0]) {
        left = mid + 1;
      } else {
        // if nums[0] is greater than the mid value then this means the smallest value is somewhere to
        // the left
        right = mid - 1;
      }
    }
    return -1;
  }

  /**
   * https://leetcode.com/explore/learn/card/binary-search/135/template-iii/944/
   */
  public int[] searchRange(int[] nums, int target) {

    int firstOccurrence = this.findBound(nums, target, true);

    if (firstOccurrence == -1) {
      return new int[] {-1, -1};
    }

    int lastOccurrence = this.findBound(nums, target, false);

    return new int[] {firstOccurrence, lastOccurrence};
  }

  private int findBound(int[] nums, int target, boolean isFirst) {
    int N = nums.length;
    int begin = 0, end = N - 1;

    while (begin <= end) {

      int mid = (begin + end) / 2;

      if (nums[mid] == target) {

        if (isFirst) {

          // This means we found our lower bound.
          if (mid == begin || nums[mid - 1] != target) {
            return mid;
          }

          // Search on the left side for the bound.
          end = mid - 1;

        } else {

          // This means we found our upper bound.
          if (mid == end || nums[mid + 1] != target) {
            return mid;
          }

          // Search on the right side for the bound.
          begin = mid + 1;
        }

      } else if (nums[mid] > target) {
        end = mid - 1;
      } else {
        begin = mid + 1;
      }
    }

    return -1;
  }

  /**
   * https://leetcode.com/explore/learn/card/binary-search/135/template-iii/945/
   */
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> result = new ArrayList<>();

    // Base case
    if (arr.length == k) {
      for (int i = 0; i < k; i++) {
        result.add(arr[i]);
      }

      return result;
    }

    // Binary search to find the closest element
    int left = 0;
    int right = arr.length;
    int mid = 0;
    while (left < right) {
      mid = (left + right) / 2;
      if (arr[mid] >= x) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    // Initialize our sliding window's bounds
    left -= 1;
    right = left + 1;

    // While the window size is less than k
    while (right - left - 1 < k) {
      // Be careful to not go out of bounds
      if (left == -1) {
        right += 1;
        continue;
      }

      // Expand the window towards the side with the closer number
      // Be careful to not go out of bounds with the pointers
      if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
        left -= 1;
      } else {
        right += 1;
      }
    }

    // Build and return the window
    for (int i = left + 1; i < right; i++) {
      result.add(arr[i]);
    }

    return result;
  }
}
