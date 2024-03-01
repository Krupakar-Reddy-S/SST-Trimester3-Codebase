public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        
        System.out.println(trie.search("apple")); // returns true
        System.out.println(trie.search("app")); // returns false
        System.out.println(trie.startsWith("app")); // returns true
        System.out.println(trie);

        trie.insert("app");
        System.out.println(trie.search("app")); // returns true
        System.out.println(trie);

        trie.delete("app");
        System.out.println(trie.search("app")); // returns false
        System.out.println(trie);

        trie.insert("Kaka");
        System.out.println(trie.search("Kaka")); // returns true
        System.out.println(trie);

        trie.insert("Kakarot");
        System.out.println(trie.search("Kakarot")); // returns true
        System.out.println(trie);

        trie.delete("Kaka");
        System.out.println(trie.search("Kaka")); // returns false
        System.out.println(trie);
    }
}
