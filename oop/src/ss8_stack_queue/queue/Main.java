package ss8_stack_queue.queue;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Hang doi: " + queue.toString());

        // b Peek()
        Integer value = queue.peek();
        System.out.println("Gia tri dau hang doi: " +value);
        // c. pop()
        Integer pop = queue.poll();
        System.out.println("Gia tri lay ra: " +pop);
        // d. isEmpty
        boolean isEmpty = queue.isEmpty();
        System.out.println("Hang doi co trong khong: " + isEmpty);
        // e. size()
        int size = queue.size();
        System.out.println("Kich thuoc hang doi: " + size);
    }
}
