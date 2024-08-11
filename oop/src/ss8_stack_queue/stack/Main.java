package ss8_stack_queue.stack;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Ngan xep: " + stack.toString());

        // b Peek()
        Integer value = stack.peek();
        System.out.println("Gia tri o dau ngan xep: " + value);
        // c. pop()
        Integer pop = stack.pop();
        System.out.println("Gia tri lay ra: " +pop);
        // d. isEmpty
        boolean isEmpty = stack.isEmpty();
        System.out.println("Ngan xep co rong khong: " + isEmpty);
        // e. size()
        int size = stack.size();
        System.out.println("Kich thuoc ngan xep: " +size);
    }
}
