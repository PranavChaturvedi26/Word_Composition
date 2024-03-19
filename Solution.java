import java.io.*;
import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    char ch;
    boolean isTerminal;

    TrieNode(char ch) {
        this.ch = ch;
        this.isTerminal = false;
        this.children = new HashMap<>();
    }
}

class Trie {
    TrieNode root;

    Trie() {
        this.root = new TrieNode('\0');
    }

    void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c))
                curr.children.put(c, new TrieNode(c));
            curr = curr.children.get(c);
        }
        curr.isTerminal = true;
    }

    boolean contains(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isTerminal;
    }

    List<String> getPrefixes(String word) {
        List<String> prefixes = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return prefixes;
            }
            curr = curr.children.get(c);
            prefix.append(c);
            if (curr.isTerminal) {
                prefixes.add(prefix.toString());
            }
        }
        return prefixes;
    }
}

public class Solution {
    private Trie trie;
    private Queue<String[]> queue;

    public Solution() {
        this.trie = new Trie();
        this.queue = new LinkedList<>();
    }

    public void buildTrie(String fPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fPath))) {
            String l;
            while ((l = reader.readLine()) != null) {
                String word = l.trim();
                List<String> prefixes = trie.getPrefixes(word);
                for (String prefix : prefixes)
                    queue.add(new String[] { word, word.substring(prefix.length()) });
                trie.insert(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public String[] findLongestCompoundWords() {
        String longestWord = "";
        String secondLongest = "";
        int longestLength = 0;

        while (!queue.isEmpty()) {
            String[] entry = queue.poll();
            String word = entry[0];
            String suffix = entry[1];

            if (trie.contains(suffix) && word.length() > longestLength) {
                secondLongest = longestWord;
                longestWord = word;
                longestLength = word.length();
            } else {
                List<String> prefixes = trie.getPrefixes(suffix);
                for (String prefix : prefixes) {
                    queue.add(new String[] { word, suffix.substring(prefix.length()) });
                }
            }
        }

        return new String[] { longestWord, secondLongest };
    }

    public static void main(String[] args) {
        Solution wordCompounder = new Solution();
        long startTime = System.currentTimeMillis();
        wordCompounder.buildTrie("Input_01.txt");
        String[] result = wordCompounder.findLongestCompoundWords();
        long endTime = System.currentTimeMillis();

        System.out.println("Longest Compound Word Is: " + result[0]);
        System.out.println("Second Longest Compound Word Is: " + result[1]);
        System.out.println("Time taken : " + (endTime - startTime) + " ms");
    }
}
