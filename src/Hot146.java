import java.util.HashMap;

// LRU缓存机制
public class Hot146 {

    private class Node{
        public int key, val;
        public Node next, prev;
        public Node(int k, int v){
            this.key = k;
            this.val = v;
        }
    }

    private class DLinkedList{
        private Node head, tail;
        private int size;

        public void addFirst(Node node){
            if (head == null)
                head = tail = node;
            else{
                head.prev = node;
                node.next = head;
                head = node;
            }
            size ++;
        }

        public void remove(Node node){
            if (head == node && tail == node){
                head = null;
                tail = null;
            }
            else if (node == head){
                node.next.prev = null;
                head = node.next;
            }
            else if (node == tail){
                node.prev.next = null;
                tail = node.prev;
            }
            else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size --;
        }

        public Node removeLast(){
            Node node = tail;
            remove(tail);
            return node;
        }

        public int size(){
            return size;
        }
    }

    public class LRUCache{
        private HashMap<Integer, Node> map;
        private DLinkedList cache;
        private int cap;

        public LRUCache(int capacity){
            this.cap = capacity;
            map = new HashMap<>();
            cache = new DLinkedList();
        }

        public int get(int key){
            if (!map.containsKey(key))
                return -1;
            int val = map.get(key).val;
            put(key, val);
            return val;
        }

        public void put(int key, int value){
            Node x = new Node(key, value);
            if (map.containsKey(key)){
                cache.remove(map.get(key));
                cache.addFirst(x);
                map.put(key, x);
            }
            else {
                if (cap == cache.size){
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                cache.addFirst(x);
                map.put(key, x);
            }
        }
    }
}
