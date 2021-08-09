import java.util.*;
import java.util.LinkedList;

public class CTT {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 双指针找中点
    public ListNode firstHalfEnd(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    // 翻转链表
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

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
        private int size;
        private Node root;

        public Trie(){
            this.size = 0;
            this.root = new Node();
        }

        public int getSize(){
            return size;
        }

        public void add(String word){
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
        public boolean contains(String word){
            Node cur = root;
            for (int i = 0; i < word.length(); i ++){
                char c = word.charAt(i);
                if (cur.next.get(c) == null)
                    return false;
                cur = cur.next.get(c);
            }
            return cur.isWord;
        }

        public boolean isPrefix(String prefix){
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

    public void sort(int[] arr){
        Random rnd = new Random();
        sort(arr, 0, arr.length - 1, rnd);
    }

    private void sort(int[] arr, int l ,int r, Random rnd){
        if (l >= r) return;
        int p = partition(arr, l, r, rnd);
        sort(arr, l, p - 1, rnd);
        sort(arr, p + 1, r, rnd);
    }

    private int partition(int[] arr, int l, int r, Random rnd){
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l , p);
        int i = l + 1, j = r;
        while (true){
            while (i <= j && arr[i] < arr[l])
                i ++;
            while (j >= i && arr[j] > arr[l])
                j --;
            if (i >= j) break;
            swap(arr, i , j);
            i ++;
            j --;
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private int partition2(int[] arr, int l, int r, Random rnd){
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        int j = l;
        for (int i = l + 1; i <= r; i ++){
            if (arr[i] < arr[l]){
                j ++;
                swap(arr, i, j);
            }
            else
                i ++;
        }
        swap(arr, j, l);
        return j;
    }

    public void sort3ways(int[] arr){
        Random rnd = new Random();
        sort3ways(arr, 0, arr.length - 1, rnd);
    }

    private void sort3ways(int[] arr, int l, int r, Random rnd){
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l , p);

        // arr[l + 1, lt] < v, arr[lt + 1, i - 1] == v, arr[gt, r] > v
        int lt = l, gt = r + 1, i = l + 1;
        while (i < gt){
            if (arr[i] < arr[l]){
                lt ++;
                swap(arr, i, lt);
                i ++;
            }
            else if (arr[i] > arr[l]){
                gt --;
                swap(arr, i, gt);
            }
            else{
                i ++;
            }
        }
        swap(arr, lt, l);

        // arr[l, lt - 1] < v, arr[lt, gt - 1] == v, arr[gt, r] > v
        sort3ways(arr, l, lt - 1, rnd);
        sort3ways(arr, gt, r, rnd);
    }

    // LRU
    private class Node2{
        private int key, val;
        private Node2 prev,next;
        public Node2(int k, int v){
            this.key = k;
            this.val = v;
        }
    }

    private class DLinkedList{
        private Node2 head, tail;
        private int size;

        public void addFirst(Node2 node){
            if (head == null)
                head = tail = node;
            else {
                head.prev = node;
                node.next = head;
                head = node;
            }
            size ++;
        }

        public void remove(Node2 node){
            if (head == node && tail == node){
                head = null;
                tail = null;
            } else if (head == node){
                node.next.prev = null;
                head = node.next;
            } else if (tail == node){
                node.prev.next = null;
                tail = node.prev;
            } else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size --;
        }

        public Node2 removeLast(){
            Node2 node = tail;
            remove(tail);
            return node;
        }
        public int size(){
            return size;
        }
    }

    private class LRU{
        private Map<Integer, Node2> map;
        private DLinkedList cache;
        private int cap;

        public LRU(int capacity){
            this.cap = capacity;
            map = new HashMap<>();
            cache = new DLinkedList();
        }

        public int get(int key){
            if (!map.containsKey(key))
                return -1;
            int v = map.get(key).val;
            put(key, v);
            return v;
        }

        public void put(int k, int v){
            Node2 x = new Node2(k, v);
            if (map.containsKey(k)){
                cache.remove(map.get(k));
                cache.addFirst(x);
                map.put(k, x);
            } else{
                if (cap == cache.size()){
                    Node2 del = cache.removeLast();
                    map.remove(del.key);
                }
                cache.addFirst(x);
                map.put(k, x);
            }
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return false;
        if (prerequisites == null || prerequisites.length == 0) return true;
        HashSet<Integer>[] adj = new HashSet[numCourses];
        int[] indgree = new int[numCourses];
        for (int i = 0; i < numCourses; i ++)
            adj[i] = new HashSet<>();
        for (int[] p : prerequisites){
            indgree[p[0]] ++;
            adj[p[1]].add(p[0]);
        }

        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i ++){
            if (indgree[i] == 0)
                q.offer(i);
        }
        int cnt = 0;
        while (!q.isEmpty()){
            int top = q.pop();
            cnt ++;
            for (int successor : adj[top]){
                indgree[successor] --;
                if (indgree[successor] == 0)
                    q.offer(successor);
            }
        }
        return cnt == numCourses;
    }

    private class Node3{
        public boolean isWord;
        public TreeMap<Character, Node3> next;
        public Node3(boolean isWord){
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }
        public Node3(){
            this(false);
        }
    }
    public class Trie2{
        public Node3 root;
        public int size;
        public Trie2(){
            this.root = new Node3();
            this.size = 0;
        }

        public void add(String word){
            Node3 cur = root;
            for (int i = 0; i < word.length(); i ++){
                char c = word.charAt(i);
                if (cur.next.get(c) == null){
                    cur.next.put(c, new Node3());
                }
                cur = cur.next.get(c);
            }
            if (!cur.isWord){
                cur.isWord = true;
                size ++;
            }
        }

        public boolean contains(String word){
            Node3 cur = root;
            for (int i = 0; i < word.length(); i ++){
                char c = word.charAt(i);
                if (cur.next.get(c) == null)
                    return false;
                cur = cur.next.get(c);
            }
            return cur.isWord;
        }

        public boolean isPrefix(String prefix){
            Node3 cur = root;
            for (int i = 0; i < prefix.length(); i ++){
                char c = prefix.charAt(i);
                if (cur.next.get(c) == null)
                    return false;
                cur = cur.next.get(c);
            }
            return true;
        }
    }

    public void quickSort(int[] arr){
        Random rnd = new Random();
        quickSort(arr, 0, arr.length - 1, rnd);
    }
    private void quickSort(int[] arr, int l, int r, Random rnd){
        if (l >= r) return;
        int p = quickSortPartition(arr, l, r, rnd);
        quickSort(arr, l, p - 1, rnd);
        quickSort(arr, p + 1, r, rnd);
    }
    private int quickSortPartition(int[] arr, int l, int r, Random rnd){
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);
        int j = l;
        for (int i = l + 1; i <= r; i ++){
            if (arr[i] < arr[l]){
                j ++;
                swap(arr, i, j);
            } else {
                i ++;
            }
        }
        swap(arr, l, j);
        return j;
    }

    private int quickSortPartition2(int[] arr, int l, int r, Random rnd){
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);
        int i = l + 1, j = r;
        while (true){
            while (i <= j && arr[i] < arr[l])
                i ++;
            while (j >= i && arr[j] > arr[l])
                j --;
            if (i >= j) break;
            swap(arr, i, j);
            i ++;
            j --;
        }
        swap(arr, l, j);
        return j;
    }

    private void quickSort3(int[] arr, int l, int r, Random rnd){
        if (l >= r) return;
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, p, l);
        // [l + 1, lt] [lt + 1, i - 1] [gt, r]
        int i = l + 1, lt = l, gt = r + 1;
        while (i < gt){
            if (arr[i] < arr[l]){
                lt ++;
                swap(arr, lt, i);
                i ++;
            } else if (arr[i] > arr[l]){
                gt --;
                swap(arr, gt, i);
            } else{
                i ++;
            }
        }
        swap(arr, lt, l);
        // [l, lt - 1] [lt, gt - 1] [gt, r]
        quickSort3(arr, l, lt - 1, rnd);
        quickSort3(arr, gt, r, rnd);
    }
    // max area of square
    public int maxSquare(char[][] mat){
        int row = mat.length;
        int col = mat[0].length;
        int maxSide = 0;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                if (mat[i][j] == '1'){
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else{
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
    // 身高排序
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(p1,p2)->{
            if (p1[0] != p2[0])
                return p2[0] - p1[0];
            else{
                return p1[1] - p2[1];
            }
        });
        int n = people.length;
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i ++){
            if (people[i][1] >= i)
                res[i] = people[i];
            else{
                int target = people[i][1];
                for (int j = i; j > target; j --){
                    res[j] = res[j - 1];
                }
                res[target] = people[i];
            }
        }
        return res;
    }

}
