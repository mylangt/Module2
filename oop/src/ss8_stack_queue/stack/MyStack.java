package ss8_stack_queue.stack;

public class MyStack<E> {
    private  int capacity;
    private Object[] arr;

    private int size;

    private  Object[] emptyArray = {};

    public  MyStack(){
        arr = emptyArray;
    }
    public MyStack(int capacity){
        this.capacity = capacity;
        this.arr = new Object[this.capacity];
    }
    // a. push: them
    public  void push(E element){
        if(arr == emptyArray){
            this.capacity = 10;
            this.arr = new Object[this.capacity];
        }

        if (size == capacity){
            this.capacity *=1.5;
            if (size == capacity){
                capacity++;
            }

            Object[] newArr = new Object[this.capacity];

            for (int i = 0; i < size; i ++){
                newArr[i] =arr[i];
            }
            arr = newArr;
        }
        arr[size] = element;
        size++;
    }
    // b. peek()
    public E peek(){
        if (size ==0){
            System.out.println("Empty");
            return null;
        }
        return (E) arr[size-1];
    }
    // c. pop()
    public E pop(){
        if (size ==0){
            System.out.println(" Empty");
        }
        E element = (E) arr[size-1];
        arr[size - 1] = null;
        size--;
        return  element;
    }
    // d. isEmpty()
    public boolean isEmpty(){
        return size ==0;
    }
    // e.size()
    public  int size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(arr[i]).append("\t");
        }
        return stringBuilder.toString();
    }
}