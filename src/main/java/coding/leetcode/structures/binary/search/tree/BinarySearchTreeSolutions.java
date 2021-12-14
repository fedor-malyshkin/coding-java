package coding.leetcode.structures.binary.search.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Binary Search Tree Solutions.
 */
public class BinarySearchTreeSolutions {

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


  static boolean isValidBST(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    Integer prev = null;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      // If next element in inorder traversal
      // is smaller than the previous one
      // that's not BST.
      if (prev != null && root.val <= prev) {
        return false;
      }
      prev = root.val;
      root = root.right;
    }
    return true;
  }


  static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      // If next element in inorder traversal
      // is smaller than the previous one
      // that's not BST.
      if (root.val > p.val) {
        return root;
      }
      root = root.right;
    }
    return null;
  }

  class BSTIterator {

    ArrayList<Integer> nodesSorted;
    int index;

    public BSTIterator(TreeNode root) {

      // Array containing all the nodes in the sorted order
      this.nodesSorted = new ArrayList<Integer>();

      // Pointer to the next smallest element in the BST
      this.index = -1;

      // Call to flatten the input binary search tree
      this._inorder(root);
    }

    private void _inorder(TreeNode root) {

      if (root == null) {
        return;
      }

      this._inorder(root.left);
      this.nodesSorted.add(root.val);
      this._inorder(root.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
      return this.nodesSorted.get(++this.index);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
      return this.index + 1 < this.nodesSorted.size();
    }
  }

  static TreeNode searchBST(TreeNode root, int val) {
    TreeNode currentNode = root;
    while (currentNode != null) {
      if (currentNode.val == val) {
        return currentNode;
      }
      if (currentNode.val > val) {
        currentNode = currentNode.left;
        continue;
      }
      currentNode = currentNode.right;
    }
    return null;
  }

  static TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);   // return a new node if root is null
    }
    if (root.val < val) {           // insert to the right subtree if val > root->val
      root.right = insertIntoBST(root.right, val);
    } else {                        // insert to the left subtree if val <= root->val
      root.left = insertIntoBST(root.left, val);
    }
    return root;
  }

  /**
   * findSuccesor - Helper function for finding successor
   * In BST, succesor of root is the leftmost child in root's right subtree
   */
  private static TreeNode findSuccessor(TreeNode root) {
    TreeNode cur = root.right;
    while (cur != null && cur.left != null) {
      cur = cur.left;
    }
    return cur;
  }

  static TreeNode deleteNode(TreeNode root, int key) {
    // return null if root is null
    if (root == null) {
      return root;
    }

    // delete current node if root is the target node
    if (root.val == key) {
      // replace root with root->right if root->left is null
      if (root.left == null) {
        return root.right;
      }

      // replace root with root->left if root->right is null
      if (root.right == null) {
        return root.left;
      }

      // replace root with its successor if root has two children
      TreeNode p = findSuccessor(root);
      root.val = p.val;
      root.right = deleteNode(root.right, p.val);
      return root;
    }
    if (root.val < key) {
      // find target in right subtree if root->val < key
      root.right = deleteNode(root.right, key);
    } else {
      // find target in left subtree if root->val > key
      root.left = deleteNode(root.left, key);
    }
    return root;
  }
}
