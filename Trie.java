import java.util.*;

public class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode child;
            if (children.containsKey(c)) {
                child = children.get(c);
            }else{
                child = new TrieNode(c);
                children.put(c, child);
            }
            if (i == word.length() - 1) {
                child.isLeaf = true;
            }
            children = child.children;
        }
    }
    
    // Returns if the word is in the trie.
    public boolean search(String word) {
        HashMap<Character, TrieNode> child = root.children;
        for (int i = 0; i < word.length() - 1; i++) {
            char c = word.charAt(i);
            if (!child.containsKey(c)) {
                return false;
            }
            child = child.get(c).children;
        }
        if (child.containsKey(word.charAt(word.length() - 1)) && child.get(word.charAt(word.length() - 1)).isLeaf) {
            return true;
        }else{
            return false;
        }
    }
    
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        HashMap<Character, TrieNode> child = root.children;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!child.containsKey(c)) {
                return false;
            }
            child = child.get(c).children;
        }
        return true;
    }
    
    public ArrayList<String> strStartWith(String prefix) {
        ArrayList<String> res = new ArrayList<String>();
        HashMap<Character, TrieNode> child = root.children;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!child.containsKey(c)) {
                return res;
            }else{
                if (i == prefix.length() - 1 && child.get(c).isLeaf) {
                    res.add(prefix);
                }
                child = child.get(c).children;
            }
        }
        helper(res,prefix,child);
        return res;
    }
    private static void helper(ArrayList<String> res, String temp, HashMap<Character, TrieNode> child) {
        if (child == null || child.isEmpty()) {
            return;
        }
        for (TrieNode node : child.values()) {
            StringBuilder str = new StringBuilder(temp);
            str.append(node.c);
            if (node.isLeaf) {
                res.add(str.toString());
            }
            helper(res, str.toString(), node.children);
        }
        return;
    }
    
    
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("application");
        trie.insert("apple");
        boolean res = trie.startsWith("app");
        if (res) {
            System.out.println("Found");
        }else{
            System.out.println("Could not found");
        }
        System.out.println(trie.strStartWith("appl"));
    }
}