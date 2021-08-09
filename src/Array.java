// 实现一个动态数组
public class Array<E> {
    private int size;
    private E[] data;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Index is illegal");
        return data[index];
    }

    public void add(int index, E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
        if (size == data.length)
            resize(2 * data.length);
        for (int i = size - 1; i >= index; i --)
            data[i + 1] = data[i];
        data[index] = e;
        size ++;
    }

    public void addLast(E e){
        add(size, e);
    }

    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size");

        E res = data[index];
        for (int i = index; i < size - 1; i ++)
            data[i] = data[i + 1];
        data[size - 1] = null;
        size --;
        if (size == data.length / 2)
            resize(data.length / 2);
        return res;
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public void swap(int i, int j){
        if (i < 0 || j < 0 || i >= size || j >= size)
            throw new IllegalArgumentException("Index is illegal");
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    private void resize(int newCapacity){
        E[] arr = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i ++)
            arr[i] = data[i];
        data = arr;
    }
}
