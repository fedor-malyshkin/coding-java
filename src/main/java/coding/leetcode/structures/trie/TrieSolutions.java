package coding.leetcode.structures.trie;

/**
 * Trie Solutions.
 */
public class TrieSolutions {

  static class Trie {

    static class TrieNode {

      // R links to node children
      private TrieNode[] links;

      private final int R = 26;

      private boolean isEnd;

      public TrieNode() {
        links = new TrieNode[R];
      }

      public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
      }

      TrieNode get(char ch) {
        return links[ch - 'a'];
      }

      void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
      }

      void setEnd() {
        isEnd = true;
      }

      boolean isEnd() {
        return isEnd;
      }
    }


    private final TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
      TrieNode node = root;
      for (int i = 0; i < word.length(); i++) {
        char currentChar = word.charAt(i);
        if (!node.containsKey(currentChar)) {
          node.put(currentChar, new TrieNode());
        }
        node = node.get(currentChar);
      }
      node.setEnd();
    }

    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word) {
      TrieNode node = root;
      for (int i = 0; i < word.length(); i++) {
        char curLetter = word.charAt(i);
        if (node.containsKey(curLetter)) {
          node = node.get(curLetter);
        } else {
          return null;
        }
      }
      return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
      TrieNode node = searchPrefix(word);
      return node != null && node.isEnd();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
      TrieNode node = searchPrefix(prefix);
      return node != null;
    }


  }


}
