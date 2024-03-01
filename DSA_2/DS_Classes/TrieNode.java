import java.util.HashMap;

class TrieNode {
    private HashMap<Character, TrieNode> children;
    private boolean isEnd;

    public TrieNode() {
        children = new HashMap<>();
        isEnd = false;
    }

    public boolean containsKey(char ch) {
        return children.containsKey(ch);
    }

    public TrieNode get(char ch) {
        return children.get(ch);
    }

    public void put(char ch, TrieNode node) {
        children.put(ch, node);
    }

    public void setEnd() {
        isEnd = true;
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return children.toString();
    }
}