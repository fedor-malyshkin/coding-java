package coding.leetcode.crashcourse;

import coding.leetcode.crashcourse.Arrays.Problem1004;
import coding.leetcode.crashcourse.Arrays.Problem1208;
import coding.leetcode.crashcourse.Arrays.Problem1413;
import coding.leetcode.crashcourse.Arrays.Problem1456;
import coding.leetcode.crashcourse.Arrays.Problem1480;
import coding.leetcode.crashcourse.Arrays.Problem1732;
import coding.leetcode.crashcourse.Arrays.Problem2000;
import coding.leetcode.crashcourse.Arrays.Problem209;
import coding.leetcode.crashcourse.Arrays.Problem303;
import coding.leetcode.crashcourse.Arrays.Problem392;
import coding.leetcode.crashcourse.Arrays.Problem643;
import coding.leetcode.crashcourse.Arrays.Problem724;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ArraysTest {

  @Test
  void testProblem392() {
    Assertions.assertThat(Problem392.isSubsequence("abc", "ahbgdc")).isTrue();
    Assertions.assertThat(Problem392.isSubsequence("axc", "ahbgdc")).isFalse();
  }

  @Test
  void testProblem643() {
    Assertions.assertThat(Problem643.findMaxAverage(new int[] {1, 12, -5, -6, 50, 3}, 4))
        .isEqualTo(12.75000);
    Assertions.assertThat(Problem643.findMaxAverage(new int[] {5}, 1)).isEqualTo(5);
  }

  @Test
  void testProblem1004() {
    Assertions.assertThat(Problem1004.longestOnes(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2))
        .as("tests case 1")
        .isEqualTo(6);
    Assertions.assertThat(
            Problem1004.longestOnes(new int[] {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                                    3))
        .as("tests case 2")
        .isEqualTo(10);
  }

  @Test
  void testProblem1480() {
    Assertions.assertThat(Problem1480.runningSum(new int[] {1, 2, 3, 4}))
        .as("tests case 1")
        .containsExactly(1, 3, 6, 10);
    Assertions.assertThat(
            Problem1480.runningSum(new int[] {1, 1, 1, 1, 1}))
        .as("tests case 2")
        .containsExactly(1, 2, 3, 4, 5);
    Assertions.assertThat(
            Problem1480.runningSum(new int[] {3, 1, 2, 10, 1}))
        .as("tests case 3")
        .containsExactly(3, 4, 6, 16, 17);
  }


  @Test
  void testProblem1413() {
    Assertions.assertThat(Problem1413.minStartValue(new int[] {-3, 2, -3, 4, 2}))
        .as("tests case 1")
        .isEqualTo(5);
    Assertions.assertThat(Problem1413.minStartValue(new int[] {1, 2}))
        .as("tests case 2")
        .isEqualTo(1);
    Assertions.assertThat(Problem1413.minStartValue(new int[] {1, -2, -3}))
        .as("tests case 3")
        .isEqualTo(5);
  }

  @Test
  void testProblem2000() {
    Assertions.assertThat(Problem2000.reversePrefix("abcdefd", 'd'))
        .as("tests case 1")
        .isEqualTo("dcbaefd");
    Assertions.assertThat(Problem2000.reversePrefix("xyxzxe", 'z'))
        .as("tests case 2")
        .isEqualTo("zxyxxe");
    Assertions.assertThat(Problem2000.reversePrefix("abcd", 'z'))
        .as("tests case 3")
        .isEqualTo("abcd");
  }

  @Test
  void testProblem209() {
    Assertions.assertThat(Problem209.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}))
        .as("tests case 1")
        .isEqualTo(2);
    Assertions.assertThat(Problem209.minSubArrayLen(4, new int[] {1, 4, 4}))
        .as("tests case 2")
        .isEqualTo(1);
    Assertions.assertThat(Problem209.minSubArrayLen(11, new int[] {1, 1, 1, 1, 1, 1, 1, 1}))
        .as("tests case 3")
        .isEqualTo(0);
  }

  @Test
  void testProblem1456() {
    Assertions.assertThat(Problem1456.maxVowels("abciiidef", 3))
        .as("tests case 1")
        .isEqualTo(3);
    Assertions.assertThat(Problem1456.maxVowels("aeiou", 2))
        .as("tests case 2")
        .isEqualTo(2);
    Assertions.assertThat(Problem1456.maxVowels("leetcode", 3))
        .as("tests case 3")
        .isEqualTo(2);
  }


  @Test
  void testProblem1208() {
    Assertions.assertThat(Problem1208.equalSubstring("abcd", "bcdf", 3))
        .as("tests case 1")
        .isEqualTo(3);
    Assertions.assertThat(Problem1208.equalSubstring("abcd", "cdef", 3))
        .as("tests case 2")
        .isEqualTo(1);
    Assertions.assertThat(Problem1208.equalSubstring("abcd", "acde", 0))
        .as("tests case 3")
        .isEqualTo(1);
  }

  @Test
  void testProblem1732() {
    Assertions.assertThat(Problem1732.largestAltitude(new int[] {-5, 1, 5, 0, -7}))
        .as("tests case 1")
        .isEqualTo(1);
    Assertions.assertThat(Problem1732.largestAltitude(new int[] {-4, -3, -2, -1, 4, 3, 2}))
        .as("tests case 2")
        .isEqualTo(0);
  }


  @Test
  void testProblem724() {
    Assertions.assertThat(Problem724.pivotIndex(new int[] {1, 7, 3, 6, 5, 6}))
        .as("tests case 1")
        .isEqualTo(3);
    Assertions.assertThat(Problem724.pivotIndex(new int[] {1, 2, 3}))
        .as("tests case 2")
        .isEqualTo(-1);
    Assertions.assertThat(Problem724.pivotIndex(new int[] {2, 1, -1}))
        .as("tests case 3")
        .isEqualTo(0);
    Assertions.assertThat(Problem724.pivotIndex(new int[] {0}))
        .as("tests case 4")
        .isEqualTo(0);
  }


  @Test
  void testProblem303() {
    var o = new Problem303.NumArray(new int[]{-2, 0, 3, -5, 2, -1});
    Assertions.assertThat(o.sumRange(0, 2))
        .as("tests case 1")
        .isEqualTo(1);
    Assertions.assertThat(o.sumRange(2, 5))
        .as("tests case 2")
        .isEqualTo(-1);
    Assertions.assertThat(o.sumRange(0,5))
        .as("tests case 3")
        .isEqualTo(-3);
  }

}