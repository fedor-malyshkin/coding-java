package coding.leetcode.study;

import coding.leetcode.study.AlgorithmOne.Problem035;
import coding.leetcode.study.AlgorithmOne.Problem167;
import coding.leetcode.study.AlgorithmOne.Problem189;
import coding.leetcode.study.AlgorithmOne.Problem283;
import coding.leetcode.study.AlgorithmOne.Problem704;
import coding.leetcode.study.AlgorithmOne.Problem977;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AlgorithmOneTest {

  @Test
  public void test704BinarySearch() {
    Assertions.assertThat(
            Problem704.search(new int[] {-1, 0, 3, 5, 9, 12}, 9))
        .isEqualTo(4);

    Assertions.assertThat(
            Problem704.search(new int[] {-1, 0, 3, 5, 9, 12}, 2))
        .isEqualTo(-1);

  }

  @Test
  public void test278FirstBadVersion() {
    class TestableSolution extends AlgorithmOne.Problem278.Solution {

      private final int answer;

      TestableSolution(int answer) {
        this.answer = answer;
      }

      @Override
      public boolean isBadVersion(int version) {
        return version >= answer;
      }
    }

    Assertions.assertThat(
            new TestableSolution(4).firstBadVersion(5))
        .isEqualTo(4);
    Assertions.assertThat(
            new TestableSolution(4).firstBadVersion(100))
        .isEqualTo(4);
    Assertions.assertThat(
            new TestableSolution(1).firstBadVersion(1))
        .isEqualTo(1);
  }

  @Test
  public void test035SearchInsertPosition() {
    Assertions.assertThat(
            Problem035.searchInsert(new int[] {1, 3, 5, 6}, 5))
        .isEqualTo(2);

    Assertions.assertThat(
            Problem035.searchInsert(new int[] {1, 3, 5, 6}, 2))
        .isEqualTo(1);

    Assertions.assertThat(
            Problem035.searchInsert(new int[] {1, 3, 5, 6}, 7))
        .isEqualTo(4);

  }

  @Test
  public void test977SquaresOfASortedArray() {
    Assertions.assertThat(
            Problem977.sortedSquares(new int[] {-4, -1, 0, 3, 10}))
        .containsExactly(0, 1, 9, 16, 100);

    Assertions.assertThat(
            Problem977.sortedSquares(new int[] {-7, -3, 2, 3, 11}))
        .containsExactly(4, 9, 9, 49, 121);
  }


  @Test
  public void test189RotateArray() {
    int[] array = new int[] {1, 2, 3, 4, 5, 6};
    Problem189.rotate(array, 2);
    Assertions.assertThat(array).containsExactly(5, 6, 1, 2, 3, 4);

    array = new int[] {1, 2, 3, 4, 5, 6, 7};
    Problem189.rotate(array, 3);
    Assertions.assertThat(array).containsExactly(5, 6, 7, 1, 2, 3, 4);

    array = new int[] {-1, -100, 3, 99};
    Problem189.rotate(array, 2);
    Assertions.assertThat(array).containsExactly(3, 99, -1, -100);
  }

  @Test
  public void test283MoveZeroes() {
    int[] array = new int[] {0, 1, 0, 3, 12};
    Problem283.moveZeroes(array);
    Assertions.assertThat(array).containsExactly(1, 3, 12, 0, 0);

    array = new int[] {0};
    Problem283.moveZeroes(array);
    Assertions.assertThat(array).containsExactly(0);

    array = new int[] {1,0};
    Problem283.moveZeroes(array);
    Assertions.assertThat(array).containsExactly(1,0);
  }

  @Test
  public void test167TwoSum2InputArrayIsSorted() {
    Assertions.assertThat(
        Problem167.twoSum(new int[] {2,7,11,15}, 9)
                         ).containsExactly(1, 2);

    Assertions.assertThat(
        Problem167.twoSum(new int[] {2, 3, 4}, 6)
                         ).containsExactly(1, 3);

    Assertions.assertThat(
        Problem167.twoSum(new int[] {-1, 0}, -1)
                         ).containsExactly(1, 2);
  }
}