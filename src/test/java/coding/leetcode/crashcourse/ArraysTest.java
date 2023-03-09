package coding.leetcode.crashcourse;

import static org.junit.jupiter.api.Assertions.*;

import coding.leetcode.crashcourse.Arrays.Problem392;
import coding.leetcode.crashcourse.Arrays.Problem643;
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
}