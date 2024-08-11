package ss7_dsaList.my_linked_list;

public class MyLinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    private int size;

    // addFirstElement
    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // b. toString(): Trả về thông tin
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(temp.value).append("\t");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }

    // c. addLastElement
    public void addLast(int value) {
        if (head == null) {
            addFirst(value);
        } else {
            Node newNode = new Node(value);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    // d. add ( int index, int value)
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("Index range out of");
        } else if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node newNode = new Node(value);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    // e. removeFirst()
    public Integer removeFirst() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return temp.value;
    }

    // f. removeLast()
    public Integer removeLast() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        if (size == 1) {

            head = null;
            tail = null;
        } else {
            for (int i = 2; i < size; i++) {
                temp = temp.next;
            }
            tail = temp;
            temp = temp.next;
            tail.next = null;
        }
        size--;
        return temp.value;
    }

    // g. Remove ( int index)
    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println(" Index range out of");
            return;
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

    // h. getFirst()
    public Integer getFirst() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    // i. getLast()
    public Integer getLast() {
        if (tail == null) {
            return null;
        }
        return tail.value;
    }

    // j. get ( int index)
    public Integer get(int index) {
        if (index < 0 || index >= 0) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    // k. set ( int index, int value)
    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            System.out.println(" Index range out of");
        } else {
            Node temp = head;
            for ( int i = 0; i < index; i++){
                temp = temp.next;
            }
            temp.value = value;
        }
    }
    // l. indexOf(int value)
    public Integer indexOf(int value){
        Node temp = head;
        for(int i =0; i < size; i++){
            if (temp.value == value){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }
    // lastIndexOf( int element)
    public Integer lastIndexOf (int value){
        int lastIndex =-1;
        Node temp = head;
        for(int i =0; i < size; i++){
            if (temp.value == value){
                lastIndex = i;
            }
            temp = temp.next;
        }
        return lastIndex;
    }
}
