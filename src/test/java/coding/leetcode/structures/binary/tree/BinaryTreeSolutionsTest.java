package coding.leetcode.structures.binary.tree;

import coding.leetcode.structures.binary.tree.BinaryTreeSolutions.TreeNode;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

class BinaryTreeSolutionsTest {

  public static final TreeNode COMPLEX_TREE =
      new TreeNode(3, new TreeNode(1, new TreeNode(7), new TreeNode(8)),
                   new TreeNode(2, new TreeNode(9), new TreeNode(10)));

  @Test
  public void testPreorderTraversal() {
    TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(2));
    Assertions.assertThat(BinaryTreeSolutions.preorderTraversal(root)).containsSequence(3, 1, 2);
  }

  @Test
  public void testPostorderTraversal() {
    TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(2));
    Assertions.assertThat(BinaryTreeSolutions.postorderTraversal(root)).containsSequence(1, 2, 3);
  }

  @Test
  public void testPostorderTraversalComplex() {
    Assertions.assertThat(BinaryTreeSolutions.postorderTraversal(COMPLEX_TREE))
        .containsSequence(7, 8, 1, 9, 10, 2, 3);
  }

  @Test
  public void testLevelOrderTraversalComplex() {
    Assertions.assertThat(BinaryTreeSolutions.levelOrder(COMPLEX_TREE))
        .containsSequence(Lists.list(3),
                          Lists.list(1, 2),
                          Lists.list(7, 8, 9, 10));
  }


  @Test
  public void testMaxDepth() {
    Assertions.assertThat(BinaryTreeSolutions.maxDepth(COMPLEX_TREE))
        .isEqualTo(3);
  }

}