package coding.leetcode.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * https://leetcode.com/study-plan/algorithm
 */
public class AlgorithmOne {

  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  static class ListNode {

    int val;
    ListNode next;

    @Override
    public String toString() {
      return "[" + val
          + ", " + next
          + ']';
    }
  }


  @Getter
  @RequiredArgsConstructor
  @AllArgsConstructor
  static class TreeNode {

    final int val;
    TreeNode left;
    TreeNode right;
  }

  @Getter
  @RequiredArgsConstructor
  @AllArgsConstructor
  static class TreeNodeWithNext {

    final int val;
    TreeNodeWithNext left;
    TreeNodeWithNext right;
    TreeNodeWithNext next;

    @Override
    public String toString() {
      return "{" + val
          + ", " + (next == null ? "#" : "")
          + '}';
    }
  }

  /**
   * <a href="https://leetcode.com/problems/binary-search/">704. Binary search</a>
   */
  static class Problem704 {

    static int search(int[] nums, int target) {
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

  /**
   * <a href="https://leetcode.com/problems/reverse-string/">344. Reverse String</a>
   */
  static class Problem344 {

    public static void reverseString(char[] s) {
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
   * <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/">557. Reverse Words in a String III</a>
   */
  static class Problem557 {

    static String reverseWords(String s) {
      char[] input = s.toCharArray();
      int start = 0;
      int end;
      while (start < input.length) {
        if (input[start] != ' ') {
          end = start;
          while (end < input.length && input[end] != ' ') {
            end++;
          }
          reverseString(input, start, end - 1);
          start = end;
        } else {
          start++;
        }
      }
      return new String(input);
    }

    static void reverseString(char[] s, int left, int right) {
      while (left < right) {
        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
      }
    }
  }

  /**
   * <a href="https://leetcode.com/problems/middle-of-the-linked-list/">876. Middle of the Linked List</a>
   */
  static class Problem876 {

    static ListNode middleNode(ListNode head) {
      // count size
      int size = 1;
      ListNode el = head;
      while (el.next != null) {
        el = el.next;
        size++;
      }
      int pos = size / 2 + 1;
      el = head;
      for (int i = 1; i < pos; i++) {
        el = el.next;
      }
      // find the middle node
      return el;
    }
  }


  /**
   * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">19. Remove Nth Node From End of List</a>
   */
  static class Problem019 {

    static ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode(0, null);
      dummy.next = head;
      ListNode first = dummy;
      ListNode second = dummy;
      // Advances first pointer so that the gap between first and second is n nodes apart
      for (int i = 1; i <= n + 1; i++) {
        first = first.next;
      }
      // Move first to the end, maintaining the gap
      while (first != null) {
        first = first.next;
        second = second.next;
      }
      second.next = second.next.next;
      return dummy.next;
    }
  }


  /**
   * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">3. Longest Substring Without Repeating Characters</a>
   */
  static class Problem003 {

    static int lengthOfLongestSubstring(String s) {
      int[] chars = new int[128];

      int left = 0;
      int right = 0;

      int res = 0;
      while (right < s.length()) {
        char r = s.charAt(right);
        chars[r]++;

        while (chars[r] > 1) {
          char l = s.charAt(left);
          chars[l]--;
          left++;
        }

        res = Math.max(res, right - left + 1);

        right++;
      }
      return res;
    }
  }

  /**
   * <a href="https://leetcode.com/problems/permutation-in-string/">567. Permutation in String</a>
   */
  static class Problem567 {

    static boolean checkInclusion(String s1, String s2) {
      if (s1.length() > s2.length()) {
        return false;
      }
      int[] s1map = new int[26];
      int[] s2map = new int[26];
      for (int i = 0; i < s1.length(); i++) {
        s1map[s1.charAt(i) - 'a']++;
        s2map[s2.charAt(i) - 'a']++;
      }
      for (int i = 0; i < s2.length() - s1.length(); i++) {
        if (matches(s1map, s2map)) {
          return true;
        }
        s2map[s2.charAt(i + s1.length()) - 'a']++;
        s2map[s2.charAt(i) - 'a']--;
      }
      return matches(s1map, s2map);
    }

    static boolean matches(int[] s1map, int[] s2map) {
      for (int i = 0; i < 26; i++) {
        if (s1map[i] != s2map[i]) {
          return false;
        }
      }
      return true;
    }
  }


  /**
   * <a href="https://leetcode.com/problems/flood-fill/">733. Flood Fill</a>
   */
  static class Problem733 {

    static Set<String> cache = null;

    static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      cache = new HashSet<>();
      helper(image, sr - 1, sc, image[sr][sc], newColor);
      helper(image, sr, sc - 1, image[sr][sc], newColor);
      helper(image, sr + 1, sc, image[sr][sc], newColor);
      helper(image, sr, sc + 1, image[sr][sc], newColor);
      image[sr][sc] = newColor;
      return image;
    }

    private static void helper(int[][] image, int r, int c, int oldColor, int newColor) {
      if (r < 0 || r >= image.length) {
        return;
      }
      if (c < 0 || c >= image[r].length) {
        return;
      }
      if (isInCache(r, c)) {
        return;
      }
      if (image[r][c] == oldColor) {
        image[r][c] = newColor;
        putInCache(r, c);
        helper(image, r - 1, c, oldColor, newColor);
        helper(image, r, c - 1, oldColor, newColor);
        helper(image, r + 1, c, oldColor, newColor);
        helper(image, r, c + 1, oldColor, newColor);
      }
    }

    static boolean isInCache(int r, int c) {
      return cache.contains(r + "-" + c);
    }

    static void putInCache(int r, int c) {
      cache.add(r + "-" + c);
    }
  }


  /**
   * <a href="https://leetcode.com/problems/max-area-of-island/">695. Max Area of Island</a>
   */
  static class Problem695 {

    static int maxAreaOfIsland(int[][] grid) {
      // the biggest count
      int res = 0;
      // iterate through area looking for islands(1s)
      for (int r = 0; r < grid.length; r++) {
        for (int c = 0; c < grid[r].length; c++) {
          if (grid[r][c] == 1) {
            res = Math.max(dfs(grid, r, c), res);
          }
        }
      }
      return res;
    }

    // depth-first-search with calculations
    private static int dfs(int[][] grid, int r, int c) {
      if (r < 0 || r >= grid.length) {
        return 0;
      }
      if (c < 0 || c >= grid[r].length) {
        return 0;
      }
      if (grid[r][c] == 1) {
        grid[r][c] = -1; // mark as visited
        return 1
            + dfs(grid, r - 1, c)
            + dfs(grid, r, c - 1)
            + dfs(grid, r + 1, c)
            + dfs(grid, r, c + 1);
      } else {
        return 0;
      }
    }
  }

  /**
   * <a href="https://leetcode.com/problems/merge-two-binary-trees/">617. Merge Two Binary Trees</a>
   */
  static class Problem617 {

    static TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
      if (node1 == null && node2 == null) {
        return null;
      }

      return new TreeNode(getVal(node1, node2),
                          mergeTrees(node1 != null ? node1.left : null,
                                     node2 != null ? node2.left : null),
                          mergeTrees(node1 != null ? node1.right : null,
                                     node2 != null ? node2.right : null));
    }

    private static int getVal(TreeNode node1, TreeNode node2) {
      int res = 0;
      if (node1 != null) {
        res += node1.val;
      }
      if (node2 != null) {
        res += node2.val;
      }
      return res;
    }
  }

  /**
   * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">116. Populating Next Right Pointers in Each Node</a>
   */
  static class Problem116 {

    static TreeNodeWithNext connect(TreeNodeWithNext theMostLeftNode) {
      if (theMostLeftNode == null) {
        return null;
      }
      if (theMostLeftNode.left != null) {
        TreeNodeWithNext nodeIter = theMostLeftNode;
        TreeNodeWithNext lastNode = null;
        do {
          if (lastNode != null) {
            lastNode.next = nodeIter.left;
          }
          lastNode = nodeIter.left;
          lastNode.next = nodeIter.right;
          lastNode = nodeIter.right;
          nodeIter = nodeIter.next;
        } while (nodeIter != null);
        connect(theMostLeftNode.left);
      }
      return theMostLeftNode;
    }
  }


  /**
   * <a href="https://leetcode.com/problems/rotting-oranges/">https://leetcode.com/problems/rotting-oranges/</a>
   */
  static class Problem994 {

    static class Pair {

      int row;
      int col;

      public Pair(int row, int col) {
        this.row = row;
        this.col = col;
      }
    }


    static boolean hasFresh(int[][] grid) {
      for (int[] row : grid) {
        for (int cell : row) {
          if (cell == 1) {
            return true;
          }
        }
      }
      return false;
    }

    static int orangesRotting(int[][] grid) {
      if (!hasFresh(grid)) {
        return 0;
      }
      Set<Pair> rotten = collectRotten(grid);
      boolean hasChanges = true;
      int steps = 0;
      while (hasFresh(grid) && hasChanges) {
        Set<Pair> newRotten = new HashSet<>();
        hasChanges = false;
        for (Pair cell : rotten) {
          if (isRotable(cell.row - 1, cell.col, grid)
              || isRotable(cell.row, cell.col + 1, grid)
              || isRotable(cell.row + 1, cell.col, grid)
              || isRotable(cell.row, cell.col - 1, grid)) {
            hasChanges = true;
            rote(cell.row - 1, cell.col, grid, newRotten);
            rote(cell.row, cell.col + 1, grid, newRotten);
            rote(cell.row + 1, cell.col, grid, newRotten);
            rote(cell.row, cell.col - 1, grid, newRotten);
          }
        }
        steps += 1;
        rotten = newRotten;
      }
      if (!hasChanges && hasFresh(grid)) {
        return -1;
      }
      if (steps == 1 && !hasChanges) {
        return -1;
      }
      return steps;
    }

    private static void rote(int row, int col, int[][] grid, Set<Pair> newRotten) {
      if (row < 0 || row >= grid.length) {
        return;
      }
      if (col < 0 || col >= grid[row].length) {
        return;
      }
      if (grid[row][col] == 1) {
        newRotten.add(new Pair(row, col));
        grid[row][col] = 2;
      }
    }

    private static boolean isRotable(int row, int col, int[][] grid) {
      if (row < 0 || row >= grid.length) {
        return false;
      }
      if (col < 0 || col >= grid[row].length) {
        return false;
      }
      return grid[row][col] == 1;
    }

    private static Set<Pair> collectRotten(int[][] grid) {
      Set<Pair> result = new HashSet<>();
      for (int r = 0; r < grid.length; r++) {
        for (int c = 0; c < grid[r].length; c++) {
          if (grid[r][c] == 2) {
            result.add(new Pair(r, c));
          }
        }
      }
      return result;
    }
  }


  /**
   * <a href="https://leetcode.com/problems/combinations/">77. Combinations</a>
   */
  static class Problem77 {

    private static List<List<Integer>> helper(List<Integer> prevLevelEntry,
                                              int from,
                                              int currentLevel,
                                              int n,
                                              int k) {
      List<List<Integer>> result = new LinkedList<>();
      for (int i = from + 1; i <= n; i++) {
        ArrayList<Integer> entry = new ArrayList<>(prevLevelEntry);
        entry.add(i);
        if (currentLevel + 1 < k) {
          result.addAll(helper(entry, i, currentLevel + 1, n, k));
        } else {
          result.add(entry);
        }
      }
      return result;
    }


    static List<List<Integer>> combine(int n, int k) {
      return new LinkedList<>(helper(Collections.emptyList(), 0, 0, n, k));
    }
  }


  /**
   * <a href="https://leetcode.com/problems/permutations/">46. Permutations</a>
   */
  static class Problem46 {

    public void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
      // if all integers are used up
      if (first == n) {
        output.add(new ArrayList<Integer>(nums));
      }
      for (int i = first; i < n; i++) {
        // place i-th integer first
        // in the current permutation
        Collections.swap(nums, first, i);
        // use next integers to complete the permutations
        backtrack(n, nums, output, first + 1);
        // backtrack
        Collections.swap(nums, first, i);
      }
    }

    public List<List<Integer>> permute(int[] nums) {
      // init output list
      List<List<Integer>> output = new LinkedList();

      // convert nums into list since the output is a list of lists
      ArrayList<Integer> nums_lst = new ArrayList<Integer>();
      for (int num : nums) {
        nums_lst.add(num);
      }

      int n = nums.length;
      backtrack(n, nums_lst, output, 0);
      return output;
    }
  }

  /**
   * <a href="https://leetcode.com/problems/climbing-stairs/">70. Climbing Stairs</a>
   */
  static class Problem70 {

    static int climbStairs(int n) {
      int memo[] = new int[n + 1];
      return helper(0, n, memo);
    }

    static int helper(int i, int n, int memo[]) {
      if (i > n) {
        return 0;
      }
      if (i == n) {
        return 1;
      }
      if (memo[i] > 0) {
        return memo[i];
      }
      memo[i] = helper(i + 1, n, memo) + helper(i + 2, n, memo);
      return memo[i];
    }
  }

  /**
   * <a href="https://leetcode.com/problems/power-of-two/">231. Power of Two</a>
   */
  static class Problem231 {

    static boolean isPowerOfTwo(int n) {
      if (n<=0)return false;
      int counter = 0;
      for (int i = 0; i < 32; i++) {
        int value = n & (1 << i);
        if (value > 0) {
          counter++;
        }
      }
      return counter == 1;
    }
  }

}
