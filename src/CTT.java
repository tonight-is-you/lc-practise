import com.sun.org.apache.xml.internal.security.utils.resolver.implementations.ResolverAnonymous;
import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.LinkedList;

public class CTT {
    private class Node{
        public int key, val;
        public Node prev, next;

        public Node(int k, int v){
            this.key = k;
            this.val = v;
        }
    }

    private class DlinkedList{
        private int size;
        private Node head, tail;

        public int size(){
            return size;
        }

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
                head.next.prev = null;
                head = node.next;
            }
            else if (node == tail){
                tail.prev.next = null;
                tail = node.prev;
            }
            else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size --;
        }

        public Node removeLast2(){
            Node node = tail;
            remove(tail);
            return node;
        }
    }

    private int cap;
    private DlinkedList cache;
    private Map<Integer, Node> map;

    public CTT(int capacity){
        this.cap = capacity;
        this.cache = new DlinkedList();
        this.map = new HashMap<Integer, Node>();
    }

    public int get(int key){
        if (!map.containsKey(key))
            return -1;
        int v = map.get(key).val;
        put(key, v);
        return v;
    }

    public void put(int k, int v){
        Node x = new Node(k, v);
        if (map.containsKey(k)){
            cache.remove(map.get(k));
            cache.addFirst(x);
            map.put(k, x);
        } else{
            if (cap == cache.size()){
                Node del = cache.removeLast2();
                map.remove(del.key);
            }
            cache.addFirst(x);
            map.put(k, x);
        }
    }

    public void sort(int[] nums){
        Random rnd = new Random();
        sort(nums, 0, nums.length - 1, rnd);
    }
    private void sort(int[] nums, int l, int r, Random rnd){
        if (l >= r) return;
        int p = partition(nums, l, r, rnd);
        sort(nums, l, p - 1, rnd);
        sort(nums, p + 1, r, rnd);
    }
    // 单路
    private int partition(int[] arr, int l, int r, Random rnd){
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);
        int j = l;
        for (int i = l + 1; i <= r; i ++){
            if (arr[i] < arr[l]){
                j ++;
                swap(arr, i, j);
            }
        }
        swap(arr, j, l);
        return j;
    }
    // 双路
    private int partition2(int[] arr, int l ,int r, Random rnd){
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);
        int i = l + 1, j = r;
        while (true){
            while (i <= j && arr[i] < arr[l])
                i ++;
            while (j >= i && arr[j] > arr[j])
                j --;
            if (i >= j) break;
            swap(arr, i, j);
            i ++;
            j --;
        }
        swap(arr, l, j);
        return j;
    }
    // 三路
    public void sort3ways(int[] arr, int l, int r, Random rnd){
        if (l >= r) return;
        int p = rnd.nextInt(r - l + 1);
        swap(arr, l, p);
        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt){
            if (arr[i] < arr[l]){
                lt ++;
                swap(arr, i, lt);
                i ++;
            }
            else if (arr[i] > arr[l]){
                gt --;
                swap(arr, gt, i);
            }
            else
                i ++;
        }
        swap(arr, lt, l);
        sort3ways(arr, l, lt - 1, rnd);
        sort3ways(arr, gt, r, rnd);
    }
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
