package coding.leetcode.structures.binarytree;

import coding.leetcode.structures.binarytree.BinaryTreeSolutions.TreeNode;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

class BinaryTreeSolutionsTest {

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
    TreeNode root = new TreeNode(3, new TreeNode(1, new TreeNode(7), new TreeNode(8)),
                                 new TreeNode(2, new TreeNode(9), new TreeNode(10)));
    Assertions.assertThat(BinaryTreeSolutions.postorderTraversal(root))
        .containsSequence(7, 8, 1, 9, 10, 2, 3);
  }

  @Test
  public void testLevelOrderTraversalComplex() {
    TreeNode root = new TreeNode(3, new TreeNode(1, new TreeNode(7), new TreeNode(8)),
                                 new TreeNode(2, new TreeNode(9), new TreeNode(10)));
    Assertions.assertThat(BinaryTreeSolutions.levelOrder(root))
        .containsSequence(Lists.list(3),
                          Lists.list(1, 2),
                          Lists.list(7, 8, 9, 10));
  }


}