import java.io.*;
import java.util.*;

class Node {
    char character;
    boolean isTerminal;
    Node[] children;

    Node(char character) {
        this.character = character;
        this.isTerminal = false;
        this.children = new Node[26]; // Assuming only lowercase alphabets
    }
}

class Trie {
    Node root;

    Trie() {
        this.root = new Node('\0'); // Root node with null character
    }

    void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Assuming only lowercase alphabets
            if (curr.children[index] == null)
                curr.children[index] = new Node(c);
            curr = curr.children[index];
        }
        curr.isTerminal = true;
    }

    boolean contains(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Assuming only lowercase alphabets
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.isTerminal;
    }

    String[] getPrefixes(String word) {
        Deque<String> prefixes = new ArrayDeque<>();
        StringBuilder prefix = new StringBuilder();
        Node curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Assuming only lowercase alphabets
            if (curr.children[index] == null) {
                return prefixes.toArray(new String[0]);
            }
            curr = curr.children[index];
            prefix.append(c);
            if (curr.isTerminal) {
                prefixes.addLast(prefix.toString());
            }
        }
        return prefixes.toArray(new String[0]);
    }
}

public class Solution {
    private Trie trie;
    private Deque<String[]> queue;

    public Solution() {
        this.trie = new Trie();
        this.queue = new ArrayDeque<>();
    }

    public void buildTrie(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.trim();
                String[] prefixes = trie.getPrefixes(word);
                for (String prefix : prefixes) {
                    queue.addLast(new String[] { word, word.substring(prefix.length()) });
                }
                trie.insert(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public String[] findLongestCompoundWords() {
        String longestWord = "";
        int longestLength = 0;
        String secondLongest = "";

        while (!queue.isEmpty()) {
            String[] entry = queue.pollFirst();
            String word = entry[0];
            String suffix = entry[1];

            if (trie.contains(suffix) && word.length() > longestLength) {
                secondLongest = longestWord;
                longestWord = word;
                longestLength = word.length();
            } else {
                String[] prefixes = trie.getPrefixes(suffix);
                for (String prefix : prefixes) {
                    queue.addLast(new String[] { word, suffix.substring(prefix.length()) });
                }
            }
        }

        return new String[] { longestWord, secondLongest };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long startTime = System.currentTimeMillis();
        solution.buildTrie("Input_01.txt");
        // solution.buildTrie("Input_02.txt");
        String[] result = solution.findLongestCompoundWords();
        long endTime = System.currentTimeMillis();

        System.out.println("Longest Compound Word: " + result[0]);
        System.out.println("Second Longest Compound Word: " + result[1]);
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
    }
}
