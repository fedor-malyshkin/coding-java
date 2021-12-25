package coding.leetcode.algo;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.math3.util.Pair;

/**
 * Recursion Solutions.
 */
public class RecursionSolutions {

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  static class ListNode {

    int val;
    ListNode next;

  }


  static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

  private static int[][] matrix;
  private static int target;

  static boolean searchRec(int left, int up, int right, int down) {
    // this submatrix has no height or no width.
    if (left > right || up > down) {
      return false;
      // `target` is already larger than the largest element or smaller
      // than the smallest element in this submatrix.
    } else if (target < matrix[up][left] || target > matrix[down][right]) {
      return false;
    }

    int mid = left + (right - left) / 2;

    // Locate `row` such that matrix[row-1][mid] < target < matrix[row][mid]
    int row = up;
    while (row <= down && matrix[row][mid] <= target) {
      if (matrix[row][mid] == target) {
        return true;
      }
      row++;
    }

    return searchRec(left, row, mid - 1, down) || searchRec(mid + 1, up, right, row - 1);
  }

  static boolean searchMatrix(int[][] mat, int targ) {
    // cache input values in object to avoid passing them unnecessarily
    // to `searchRec`
    matrix = mat;
    target = targ;

    // an empty matrix obviously does not contain `target`
    if (matrix == null || matrix.length == 0) {
      return false;
    }

    return searchRec(0, 0, matrix[0].length - 1, matrix.length - 1);
  }

  // This is the robot's control interface.
  // You should not implement it, or speculate about its implementation
  interface Robot {

    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();

    void turnRight();

    // Clean the current cell.
    public void clean();
  }


  // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
  static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  static Set<Pair<Integer, Integer>> visited = new HashSet<>();
  static Robot robot;

  static void goBack() {
    robot.turnRight();
    robot.turnRight();
    robot.move();
    robot.turnRight();
    robot.turnRight();
  }

  static void backtrack(int row, int col, int d) {
    visited.add(new Pair(row, col));
    robot.clean();
    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    for (int i = 0; i < 4; ++i) {
      int newD = (d + i) % 4;
      int newRow = row + directions[newD][0];
      int newCol = col + directions[newD][1];

      if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
        backtrack(newRow, newCol, newD);
        goBack();
      }
      // turn the robot following chosen direction : clockwise
      robot.turnRight();
    }
  }

  public void cleanRoom(Robot robot) {
    RecursionSolutions.robot = robot;
    backtrack(0, 0, 0);
  }
}
