import java.util.*;

class TrieNode {
    // Initialize your data structure here.
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    public TrieNode() {}
    public TrieNode(char c) {
        this.c = c;
    }
}

