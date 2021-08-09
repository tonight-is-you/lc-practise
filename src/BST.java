import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public void add(E e){
        root = add(root, e);
    }
    private Node add(Node node, E e){
        if (node == null){
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }

    public boolean contains(E e){
        return contains(root, e);
    }
    private boolean contains(Node node, E e){
        if (node == null)
            return false;
        if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else if (e.compareTo(node.e) > 0)
            return contains(node.right, e);
        else
            return true;
    }

    public E minimum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty.");
        return minimum(root).e;
    }
    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    public E maximun(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty.");
        return maximum(root).e;
    }
    private Node maximum(Node node){
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }
    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax(){
        E ret = maximun();
        root = removeMax(root);
        return ret;
    }
    private Node removeMax(Node node){
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e){
        root = remove(root, e);
    }
    private Node remove(Node node, E e){
        if (node == null)
            return null;
        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }
        else if (e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }
        else{
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                return rightNode;
            }
            else if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                return leftNode;
            }
            else {
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = node.right = null;
                return successor;
            }
        }
    }

    public void preOrder(Node node){
        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR(Node node){
        if (node == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    public void levelOrder(Node node){
        if (node == null)
            return;
        Deque<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()){
            Node cur = q.poll();
            System.out.println(cur.e);
            if (cur.left != null)
                q.offer(cur.left);
            if (cur.right != null)
                q.offer(cur.right);
        }
    }
}
