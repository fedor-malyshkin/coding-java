package coding.leetcode.structures.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
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
}
