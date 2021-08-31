import java.util.TreeMap;

// 实现Trie
public class Hot208 {
    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }

    private class Trie{
        private Node root;
        private int size;

        public Trie(){
            this.root = new Node();
            this.size = 0;
        }

        public void insert(String word){
            Node cur = root;
            for (int i = 0; i < word.length(); i ++){
                char c = word.charAt(i);
                if (cur.next.get(c) == null)
                    cur.next.put(c, new Node());
                cur = cur.next.get(c);
            }
            if (!cur.isWord){
                cur.isWord = true;
                size ++;
            }
        }

        public boolean search(String word){
            Node cur = root;
            for (int i = 0; i < word.length(); i ++){
                char c = word.charAt(i);
                if (cur.next.get(c) == null)
                    return false;
                cur = cur.next.get(c);
            }
            return cur.isWord;
        }

        public boolean startWith(String prefix){
            Node cur = root;
            for (int i = 0; i < prefix.length(); i ++){
                char c = prefix.charAt(i);
                if (cur.next.get(c) == null)
                    return false;
                cur = cur.next.get(c);
            }
            return true;
        }
    }

}
