package coding.leetcode.study;

import coding.leetcode.study.AlgorithmOne.ListNode;
import coding.leetcode.study.AlgorithmOne.Problem003;
import coding.leetcode.study.AlgorithmOne.Problem019;
import coding.leetcode.study.AlgorithmOne.Problem035;
import coding.leetcode.study.AlgorithmOne.Problem116;
import coding.leetcode.study.AlgorithmOne.Problem167;
import coding.leetcode.study.AlgorithmOne.Problem189;
import coding.leetcode.study.AlgorithmOne.Problem231;
import coding.leetcode.study.AlgorithmOne.Problem283;
import coding.leetcode.study.AlgorithmOne.Problem344;
import coding.leetcode.study.AlgorithmOne.Problem557;
import coding.leetcode.study.AlgorithmOne.Problem567;
import coding.leetcode.study.AlgorithmOne.Problem695;
import coding.leetcode.study.AlgorithmOne.Problem704;
import coding.leetcode.study.AlgorithmOne.Problem733;
import coding.leetcode.study.AlgorithmOne.Problem77;
import coding.leetcode.study.AlgorithmOne.Problem876;
import coding.leetcode.study.AlgorithmOne.Problem977;
import coding.leetcode.study.AlgorithmOne.Problem994;
import coding.leetcode.study.AlgorithmOne.TreeNodeWithNext;
import java.util.Arrays;
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

    array = new int[] {1, 0};
    Problem283.moveZeroes(array);
    Assertions.assertThat(array).containsExactly(1, 0);
  }

  @Test
  public void test167TwoSum2InputArrayIsSorted() {
    Assertions.assertThat(
        Problem167.twoSum(new int[] {2, 7, 11, 15}, 9)
                         ).containsExactly(1, 2);

    Assertions.assertThat(
        Problem167.twoSum(new int[] {2, 3, 4}, 6)
                         ).containsExactly(1, 3);

    Assertions.assertThat(
        Problem167.twoSum(new int[] {-1, 0}, -1)
                         ).containsExactly(1, 2);
  }

  @Test
  public void test344ReverseString() {
    char[] input = "hello".toCharArray();
    Problem344.reverseString(input);
    Assertions.assertThat(input).isEqualTo("olleh".toCharArray());

    input = "".toCharArray();
    Problem344.reverseString(input);
    Assertions.assertThat(input).isEqualTo("".toCharArray());
  }


  @Test
  public void test557ReverseWordsInAString3() {
    Assertions.assertThat(Problem557.reverseWords("Let's take LeetCode contest")
                         ).isEqualTo("s'teL ekat edoCteeL tsetnoc");

    Assertions.assertThat(Problem557.reverseWords(" Let's take LeetCode contest")
                         ).isEqualTo(" s'teL ekat edoCteeL tsetnoc");

    Assertions.assertThat(Problem557.reverseWords("")
                         ).isEqualTo("");
  }

  @Test
  public void test876MiddleOfTheLinkedList() {
    ListNode list =
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
    Assertions.assertThat(Problem876.middleNode(list).getVal()
                         ).isEqualTo(3);
    list =
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,
                                                                                     new ListNode(6,
                                                                                                  null))))));
    Assertions.assertThat(Problem876.middleNode(list).getVal()
                         ).isEqualTo(4);
  }


  @Test
  public void test019RemoveNthNodeFromEndOfList() {
    ListNode list =
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
    Assertions.assertThat(Problem019.removeNthFromEnd(list, 2).toString())
        .isEqualTo("[1, [2, [3, [5, null]]]]");
    list =
        new ListNode(1, null);
    Assertions.assertThat(Problem019.removeNthFromEnd(list, 1)).isNull();

    list =
        new ListNode(1, new ListNode(2, null));
    Assertions.assertThat(Problem019.removeNthFromEnd(list, 1).toString()).isEqualTo("[1, null]");
  }


  @Test
  public void test003LongestSubstringWithoutRepeatingCharacters() {
    Assertions.assertThat(
        Problem003.lengthOfLongestSubstring("abcabcbb")
                         ).isEqualTo(3);
    Assertions.assertThat(
        Problem003.lengthOfLongestSubstring("bbbbb")
                         ).isEqualTo(1);
    Assertions.assertThat(
        Problem003.lengthOfLongestSubstring("pwwkew")
                         ).isEqualTo(3);
  }

  @Test
  public void test567PermutationInString() {
    Assertions.assertThat(
        Problem567.checkInclusion("ab", "eidbaooo")).isTrue();
    Assertions.assertThat(
        Problem567.checkInclusion("ab", "eidboaoo")).isFalse();
  }


  @Test
  public void test733FloodFill() {
    Assertions.assertThat(
            Problem733.floodFill(
                new int[][] {new int[] {1, 1, 1}, new int[] {1, 1, 0}, new int[] {1, 0, 1}},
                1, 1, 2))
        .isEqualTo(new int[][] {new int[] {2, 2, 2}, new int[] {2, 2, 0}, new int[] {2, 0, 1}});
    Assertions.assertThat(
            Problem733.floodFill(
                new int[][] {new int[] {0, 0, 0}, new int[] {0, 0, 0}},
                1, 1, 2))
        .isEqualTo(new int[][] {new int[] {2, 2, 2}, new int[] {2, 2, 2}});

    Assertions.assertThat(
            Problem733.floodFill(
                new int[][] {new int[] {0, 0, 0}, new int[] {0, 1, 0}},
                1, 1, 2))
        .isEqualTo(new int[][] {new int[] {0, 0, 0}, new int[] {0, 2, 0}});

    Assertions.assertThat(
            Problem733.floodFill(
                new int[][] {new int[] {0, 0, 0}, new int[] {0, 1, 1}},
                1, 1, 1))
        .isEqualTo(new int[][] {new int[] {0, 0, 0}, new int[] {0, 1, 1}});
  }

  @Test
  public void test695MaxAreaOfIsland() {
    Assertions.assertThat(
            Problem695.maxAreaOfIsland(
                new int[][] {new int[] {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                             new int[] {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                             new int[] {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                             new int[] {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                             new int[] {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                             new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                             new int[] {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                             new int[] {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}))
        .isEqualTo(6);
  }

  @Test
  public void test116PopulatingNextRightPointersInEachNode() {
    TreeNodeWithNext tree = new TreeNodeWithNext(1,
                                                 new TreeNodeWithNext(2,
                                                                      new TreeNodeWithNext(4),
                                                                      new TreeNodeWithNext(5),
                                                                      null),
                                                 new TreeNodeWithNext(3,
                                                                      new TreeNodeWithNext(6),
                                                                      new TreeNodeWithNext(7),
                                                                      null), null);
    Assertions.assertThat(Problem116.connect(tree).toString())
        .isEqualTo("{1, #}");
  }

  @Test
  public void test994RottingOranges() {
    Assertions.assertThat(
            Problem994.orangesRotting(
                new int[][] {new int[] {2, 1, 1},
                             new int[] {1, 1, 0},
                             new int[] {0, 1, 1}}))
        .isEqualTo(4);
    Assertions.assertThat(
            Problem994.orangesRotting(
                new int[][] {new int[] {2, 1, 1},
                             new int[] {0, 1, 1},
                             new int[] {1, 0, 1}}))
        .isEqualTo(-1);
    Assertions.assertThat(
            Problem994.orangesRotting(
                new int[][] {new int[] {0, 2}}))
        .isEqualTo(0);
  }


  @Test
  public void test77Combinations() {
    Assertions.assertThat(
        Problem77.combine(4, 2)).containsOnly(Arrays.asList(1, 2),
                                              Arrays.asList(1, 3),
                                              Arrays.asList(1, 4),
                                              Arrays.asList(2, 3),
                                              Arrays.asList(2, 4),
                                              Arrays.asList(3, 4));

    Assertions.assertThat(
        Problem77.combine(4, 3)).containsOnly(Arrays.asList(1, 2, 3),
                                              Arrays.asList(1, 2, 4),
                                              Arrays.asList(1, 3, 4),
                                              Arrays.asList(2, 3, 4));
    Assertions.assertThat(
        Problem77.combine(1, 1)).containsOnly(Arrays.asList(1));
  }

  @Test
  public void test231PowerOfTwo() {
    Assertions.assertThat(Problem231.isPowerOfTwo(1)).isTrue();
    Assertions.assertThat(Problem231.isPowerOfTwo(16)).isTrue();
    Assertions.assertThat(Problem231.isPowerOfTwo(3)).isFalse();
  }
}