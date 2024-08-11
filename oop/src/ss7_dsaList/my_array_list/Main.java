package ss7_dsaList.my_array_list;

public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();

        // a. add (int element): Thêm phần tử element vào cuối.
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);
        myArrayList.add(30);
        myArrayList.add(30);

        // b. toString (): Trả về thông tin đối tượng
        System.out.println("Danh sach ban dau: " + myArrayList.toString());

        // c. add (int index, int element): Thêm phần tử vào vị trí index
        myArrayList.add(3, 24);
        System.out.println("Danh sach sau khi them 24 vao vi tri 3: " + myArrayList.toString());

        //  d. set (int index, int element): Thay thế phần tử tại vị trí index
        myArrayList.set(3, 24);
        System.out.println("Danh sach sau khi thay the o vi tri 3 bang 35: " + myArrayList.toString());

        // e. get (int index): Trả về phần tử tại index
        int elementAtIndex = myArrayList.get(4);
        System.out.println("Phan tu o vi tri thu 4 la: " + elementAtIndex);

        // f. indexOf (int element): Lấy vị trí index phần tử đầu tiên tìm thấy
        int elementToFind = 30;
        int indexOfElement = myArrayList.indexOf(elementToFind);
        if (indexOfElement != -1) {
            System.out.println("Vi tri index cua phan tu " + elementToFind + " la: " + indexOfElement);
        } else {
            System.out.println("Khong tim thay phan tu " + elementToFind + "trong danh sach");
        }

        // g. lastIndexOf (int element o): Lấy vị trí index phần tử cuối cùng tìm thấy
        int lastIndexOfElement = myArrayList.lastIndexOf(elementToFind);
        if (lastIndexOfElement != -1) {
            System.out.println();
        }
    }
}
