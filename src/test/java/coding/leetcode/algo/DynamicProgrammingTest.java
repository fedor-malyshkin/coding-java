package coding.leetcode.algo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DynamicProgrammingTest {

  @Test
  void minCostClimbingStairs() {
    Assertions.assertThat(
        DynamicProgramming.minCostClimbingStairs(new int[] {10, 15, 20})
                         ).isEqualTo(15);

    Assertions.assertThat(
        DynamicProgramming.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1})
                         ).isEqualTo(6);
  }
}