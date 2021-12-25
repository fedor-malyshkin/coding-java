package coding.leetcode.algo;

import java.util.HashMap;
import java.util.Map;


/**
 * Dynamic Programming Exercise.
 */
public class DynamicProgramming {

  /**
   * https://leetcode.com/explore/learn/card/dynamic-programming/631/strategy-for-solving-dp-problems/4040/
   */
  private static Map<Integer, Integer> minCostClimbingStairsCache = new HashMap<>();

  static int minCostClimbingStairs(int[] cost) {
    minCostClimbingStairsCache.clear();
    return Math.min(cost[cost.length - 1] + minCostClimbingStairsInternal(cost, cost.length - 1),
                    cost[cost.length - 2] + minCostClimbingStairsInternal(cost, cost.length - 2));
  }

  static int minCostClimbingStairsInternal(int[] cost, int step) {
    if (step == 0 || step == 1) {
      return 0;
    }
    if (!minCostClimbingStairsCache.containsKey(step)) {
      int value = Math.min(cost[step - 1] + minCostClimbingStairsInternal(cost, step - 1),
                           cost[step - 2] + minCostClimbingStairsInternal(cost, step - 2));
      minCostClimbingStairsCache.put(step, value);
    }
    return minCostClimbingStairsCache.get(step);
  }

}
