// 实现最大堆
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 添加元素，上浮
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }
    private void siftUp(int k){
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 看堆中最大元素
    public E findMax(){
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }
    // 取出元素，下沉
    public E extractMax(){
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }
    private void siftDown(int k){
        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                j = rightChild(k);
            if (data.get(j).compareTo(data.get(k)) < 0)
                break;
            data.swap(j, k);
            k = j;
        }
    }

    private int parent(int index){
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent");
        return (index - 1) / 2;
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }
}
