package coding.leetcode.structures.graph;


import java.util.HashSet;
import java.util.Set;

/**
 * Graph Structure Solutions.
 */
public class GraphSolutions {

  // UnionFind.class
  static class UnionFindDraft {

    private int[] root;

    public UnionFindDraft(int size) {
      root = new int[size];
      for (int i = 0; i < size; i++) {
        root[i] = i;
      }
    }

    public int find(int x) {
      if (x == root[x]) {
        return x;
      }
      return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      if (rootX != rootY) {
        root[rootY] = rootX;
      }
    }

    public boolean connected(int x, int y) {
      return find(x) == find(y);
    }
  }

  static class QuickFind {

    private final int size;
    private final int[] root;

    QuickFind(int size) {
      this.size = size;
      this.root = new int[size];
      for (int i = 0; i < size; i++) {
        root[i] = i;
      }
    }

    public void union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      if (rootX != rootY) {
        for (int i = 0; i < root.length; i++) {
          if (root[i] == rootY) {
            root[i] = rootX;
          }
        }
      }
    }

    public int find(int x) {
      return root[x];
    }

    int[] getRoots() {
      return root;
    }


    public boolean connected(int x, int y) {
      return find(x) == find(y);
    }
  }

  /**
   * https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3845/
   */
  static int findCircleNum(int[][] isConnected) {
    QuickFind graph = new QuickFind(isConnected.length);

    for (int c1 = 0; c1 < isConnected.length; c1++) {
      for (int c2 = 0; c2 < isConnected[c1].length; c2++) {
        if (isConnected[c1][c2] == 1) {
          graph.union(c1, c2);
        }
      }
    }

    Set<Integer> set = new HashSet<>();
    for (int i : graph.getRoots()) {
      set.add(i);
    }
    return set.size();
  }

}
