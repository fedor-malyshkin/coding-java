package coding.leetcode.structures.graph;

import coding.leetcode.structures.graph.GraphSolutions.QuickFind;
import coding.leetcode.structures.graph.GraphSolutions.UnionFindDraft;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GraphSolutionsTest {

  @Test
  public void testCompressedPath() {
    UnionFindDraft uf = new UnionFindDraft(10);
    // 1-2-5-6-7 3-8-9 4
    uf.union(1, 2);
    uf.union(2, 5);
    uf.union(5, 6);
    uf.union(6, 7);
    uf.union(3, 8);
    uf.union(8, 9);
    System.out.println(uf.connected(1, 5)); // true
    System.out.println(uf.connected(5, 7)); // true
    System.out.println(uf.connected(4, 9)); // false
    // 1-2-5-6-7 3-8-9-4
    uf.union(9, 4);
    System.out.println(uf.connected(4, 9)); // true
  }

  @Test
  public void testMyCompressedPath() {
    QuickFind testable = new QuickFind(10);
    //1-2 + 2-3
    testable.union(1, 2);
    testable.union(2, 3);
    // 5-6 + 6-7
    testable.union(5, 6);
    testable.union(6, 7);

    // 5-3
    testable.union(5, 3);

    Assertions.assertThat(testable.getRoots()).
        containsSequence(0, 5, 5, 5, 4, 5, 5, 5, 8, 9);
  }

  @Test
  public void testFindCircleNum() {
    Assertions.assertThat(GraphSolutions.findCircleNum(
            new int[][] {new int[] {1, 0, 0},
                         new int[] {0, 1, 0},
                         new int[] {0, 0, 1}}))
        .isEqualTo(3);
    Assertions.assertThat(GraphSolutions.findCircleNum(
            new int[][] {new int[] {1,1,0},
                         new int[] {1,1,0},
                         new int[] {0,0,1}}))
        .isEqualTo(2);
  }
}
