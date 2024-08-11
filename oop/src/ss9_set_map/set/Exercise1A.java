package ss9_set_map.set;

import java.util.HashSet;
import java.util.Set;

/** a. Loại bỏ các phần tử trùng lặp
 Viết một chương trình nhận vào một mảng số nguyên và sử dụng Set để loại bỏ các phần tử trùng lặp, sau đó hiển thị danh sách các phần tử duy nhất.

 b. Tính tổng của các phần tử không trùng lặp
 Viết một chương trình nhận vào một mảng số nguyên và sử dụng Set để tính tổng của các phần tử không trùng lặp trong mảng.

 c. Tìm các phần tử chung trong hai mảng
 Viết một chương trình nhận vào hai mảng số nguyên và sử dụng hai Set để tìm các phần tử chung giữa hai mảng.

 d. Tìm phần tử lớn nhất và nhỏ nhất
 Viết một chương trình nhận vào một mảng số nguyên và sử dụng Set để tìm phần tử lớn nhất và nhỏ nhất trong mảng.
 **/
public class Exercise1A {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 5, 6, 5, 7};
        int[] uniqueArr = removeDuplicate(arr);
        System.out.println("List unique array: ");
        for ( int num : uniqueArr) {
            System.out.println(num);
        }
    }
    static int[] removeDuplicate(int[] arr){
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : arr){
            uniqueSet.add(num);
        }

        int[] uniqueArray = new int[uniqueSet.size()];
        int index = 0;
        for (int num : uniqueSet){
            uniqueArray[index] = num;
            index++;
        }
        return uniqueArray;
    }
}
