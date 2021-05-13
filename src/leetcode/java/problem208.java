package leetcode.java;

import java.util.HashMap;

public class problem208 {

    class Trie {
        class TrieNode {
            char val;
            boolean isEnd;
            HashMap<Character, TrieNode> map;
            TrieNode () {
            }
        }
        TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length();i ++) {
                char c = word.charAt(i);
                if (node.map == null) {
                    node.map = new HashMap<>();
                }
                if (!node.map.containsKey(c)) {
                    node.map.put(c, new TrieNode());
                }
                node = node.map.get(c);
            }
            node.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.map == null) {
                    return false;
                }
                if (!node.map.containsKey(c)) {
                    return false;
                }
                node = node.map.get(c);
            }
            return node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (node.map == null) {
                    return false;
                }
                if (!node.map.containsKey(c)) {
                    return false;
                }
                node = node.map.get(c);
            }
            return true;
        }
    }
}
