package ss7_dsaList.my_linked_list;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        // a. addFirst
        myLinkedList.addFirst(10);
        myLinkedList.addFirst(20);
        myLinkedList.addFirst(30);
        // b. toString()
        System.out.println(" List: " + myLinkedList.toString());
        // c. addLast(int value)
        myLinkedList.addLast(50);
        // d. add
        myLinkedList.add(2,35);
        System.out.println("Danh sau sau khi them:" + myLinkedList.toString());
        // e. removeFirst()
        myLinkedList.removeFirst();
        System.out.println(" Danh sach sau khi xoa phan tu dau tien: " + myLinkedList.toString());
        // f. removeLast()
        myLinkedList.removeLast();
        System.out.println(" Danh sach sau khi xoa phan tu cuoi cung: " + myLinkedList.toString());
        // g. remove(int index)
        myLinkedList.remove(2);
        System.out.println("Danh sach sau khi remove mot so tai index");
        // h. getFirst()
        Integer firstValue = myLinkedList.getFirst();
        System.out.println("First value is " + firstValue);
        // i. getLast()
        Integer lastVal = myLinkedList.getLast();
        System.out.println(lastVal);
        // j. get ( index)
        Integer valAt = myLinkedList.get(2);
        System.out.println(valAt);
        // k. set ( int index, int value)
        myLinkedList.set(1,100);
        System.out.println(myLinkedList);
        // l. indexOf(int value)
        Integer index  = myLinkedList.indexOf(300);
        // m. lastIndexOf(int value)
        Integer lastIndex = myLinkedList.lastIndexOf(10);
        System.out.println(lastIndex);
    }
}
