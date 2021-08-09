public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E v, Node node){
            this.e = v;
            this.next = node;
        }

        public Node(E e){
            this(e, null);
        }
        public Node(){
            this(null, null);
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node();
        size = 0;
    }

    public void add(int index, E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i ++)
            prev = prev.next;
        prev.next = new Node(e, prev.next);
        size ++;
    }

    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i ++)
            prev = prev.next;
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    public void removeElement(E e){
        Node cur = dummyHead;
        while (cur.next != null){
            if (cur.next.e.equals(e))
                break;
            cur = cur.next;
        }
        if (cur.next != null){
            Node deleteNode = cur.next;
            cur.next = deleteNode.next;
            deleteNode.next = null;
            size --;
        }
    }

    public void set(int index, E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        Node prev = dummyHead.next;
        for (int i = 0; i < index; i ++)
            prev = prev.next;
        prev.e = e;
    }

    public boolean contains(E e){
        Node cur = dummyHead;
        while (cur.next != null){
            if (cur.next.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }
}
