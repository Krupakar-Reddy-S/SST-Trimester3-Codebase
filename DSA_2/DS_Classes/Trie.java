import java.util.Map;

public class Trie {
    private TrieNode root;

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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } 
            else {
                return null;
            }
        }

        return node;
    }

    // Deletes a word from the trie.
    public TrieNode delete(String word) {
        return delete(root, word, 0);
    }

    private TrieNode delete(TrieNode node, String word, int index) {
        if (index == word.length()) {
            if (!node.isEnd()) {
                return null;
            }
            node.setEnd(false);

            return node;
        }

        char ch = word.charAt(index);
        TrieNode child = node.get(ch);
        if (child == null) {
            return null;
        }

        TrieNode next = delete(child, word, index + 1);
        if (next == null && !child.isEnd() && child.getChildren().isEmpty()) {
            node.getChildren().remove(ch);
        }

        return node;
    }

    @Override
    public String toString() {
        return printTrie(root, "", new StringBuilder()).toString();
    }

    private StringBuilder printTrie(TrieNode node, String prefix, StringBuilder sb) {
        for (Map.Entry<Character, TrieNode> child : node.getChildren().entrySet()) {
            sb.append("|" + prefix);
            sb.append("'-- ");
            sb.append(child.getKey());
            sb.append(child.getValue().isEnd() ? " *" : "");
            sb.append("\n");
            printTrie(child.getValue(), prefix + "    ", sb);
        }

        return sb;
    }
}

