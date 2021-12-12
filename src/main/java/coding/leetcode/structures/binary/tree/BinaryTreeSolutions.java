package coding.leetcode.structures.binary.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

/**
 * Binary Tree Solutions.
 */
public class BinaryTreeSolutions {

  @Data
  @AllArgsConstructor
  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  /**
   * Binary Tree Preorder Traversal.
   */
  static List<Integer> preorderTraversal(TreeNode root) {

    if (root == null) {
      return Collections.emptyList();
    }
    Deque<TreeNode> nodeProcessingQueue = new LinkedList<>();
    List<Integer> result = new LinkedList<>();
    nodeProcessingQueue.add(root);
    do {
      TreeNode currentNode = nodeProcessingQueue.poll();
      visitNode(currentNode, result);
      if (currentNode.right != null) {
        nodeProcessingQueue.offerFirst(currentNode.right);
      }
      if (currentNode.left != null) {
        nodeProcessingQueue.offerFirst(currentNode.left);
      }
    } while (!nodeProcessingQueue.isEmpty());
    return result;
  }

  static void visitNode(TreeNode node, List<Integer> aggregator) {
    aggregator.add(node.val);
  }

  static List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    Deque<TreeNode> nodeProcessingQueue = new LinkedList<>();
    List<Integer> result = new LinkedList<>();
    TreeNode currentNode = root;
    while (currentNode != null || !nodeProcessingQueue.isEmpty()) {
      while (currentNode != null) {
        nodeProcessingQueue.offerFirst(currentNode);
        currentNode = currentNode.left;
      }
      currentNode = nodeProcessingQueue.pop();
      visitNode(currentNode, result);
      currentNode = currentNode.right;
    }
    return result;
  }

  enum NodeType {
    RIGHT, CENTER
  }

  @Value
  static class StackEntry {

    TreeNode node;
    NodeType nodeType;
  }

  static List<Integer> postorderTraversal(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    Deque<StackEntry> nodeProcessingQueue = new LinkedList<>();
    List<Integer> result = new LinkedList<>();
    TreeNode currentNode = root;
    while (currentNode != null || !nodeProcessingQueue.isEmpty()) {
      while (currentNode != null) {
        nodeProcessingQueue.offerFirst(new StackEntry(currentNode, NodeType.CENTER));
        if (currentNode.right != null) {
          nodeProcessingQueue.offerFirst(new StackEntry(currentNode.right, NodeType.RIGHT));
        }
        currentNode = currentNode.left;
      }
      StackEntry storedNode = nodeProcessingQueue.pop();
      switch (storedNode.getNodeType()) {
        case RIGHT:
          currentNode = storedNode.getNode();
          break;
        case CENTER:
          visitNode(storedNode.getNode(), result);
          break;
      }

    }
    return result;
  }

  static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    BiConsumer<Integer, Integer> consumer = (level, value) -> {
      if (result.size() <= level) {
        result.add(new LinkedList<>());
      }
      final List<Integer> values = result.get(level);
      values.add(value);
    };

    if (root != null) {
      levelOrderInt(root, 0, consumer);
    }
    return result;
  }

  static void levelOrderInt(TreeNode node, Integer level, BiConsumer<Integer, Integer> consumer) {
    consumer.accept(level, node.val);

    if (node.left != null) {
      levelOrderInt(node.left, level + 1, consumer);
    }
    if (node.right != null) {
      levelOrderInt(node.right, level + 1, consumer);
    }
  }

  static int maxDepth(TreeNode root) {
    if (Objects.isNull(root)) {
      return 0;
    }
    return maxDepthInt(root, 0);
  }

  static int maxDepthInt(TreeNode node, int level) {
    if (Objects.isNull(node)) {
      return level;
    } else {
      return Math.max(maxDepthInt(node.left, level + 1), maxDepthInt(node.right, level + 1));
    }
  }

  static boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
  }

  static boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return true;
    }
    if (t1 == null || t2 == null) {
      return false;
    }
    return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
  }

  static boolean hasPathSum(TreeNode node, int sum) {
    if (node == null) {
      return false;
    }
    sum -= node.val;
    if ((node.left == null) && (node.right == null)) {
      return (sum == 0);
    }
    return hasPathSum(node.left, sum) || hasPathSum(node.right, sum);
  }


  int count = 0;

  boolean isUni(TreeNode node) {

    //base case - if the node has no children this is a univalue subtree
    if (node.left == null && node.right == null) {
      // found a univalue subtree - increment
      count++;
      return true;
    }

    boolean isUnival = true;

    // check if all of the node's children are univalue subtrees and if they have the same value
    // also recursively call is_uni for children
    if (node.left != null) {
      isUnival = isUni(node.left) && isUnival && node.left.val == node.val;
    }

    if (node.right != null) {
      isUnival = isUni(node.right) && isUnival && node.right.val == node.val;
    }

    // return if a univalue tree exists here and increment if it does
    if (!isUnival) {
      return false;
    }
    count++;
    return true;
  }

  public int countUnivalSubtrees(TreeNode root) {
    if (root == null) {
      return 0;
    }
    isUni(root);
    return count;
  }

}
