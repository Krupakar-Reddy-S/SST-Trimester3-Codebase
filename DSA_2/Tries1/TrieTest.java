public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        System.out.println(trie);

        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
        System.out.println(trie);

        trie.delete("app");
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie);
    }
}
