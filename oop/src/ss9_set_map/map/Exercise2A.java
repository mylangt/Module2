package ss9_set_map.map;

import java.util.HashMap;
import java.util.Map;

/**
 a. Đếm số lần xuất hiện của từ trong một văn bản
 Viết một chương trình nhận vào một chuỗi văn bản và sử dụng Map để đếm số lần xuất hiện của từng từ trong văn bản.

 b. Kiểm tra tính duy nhất của tên
 Viết một chương trình nhận vào một danh sách các tên và sử dụng Map để kiểm tra xem tên nào là duy nhất (xuất hiện một lần) và tên nào xuất hiện nhiều lần.
 *
 */
public class Exercise2A {
    public static void main(String[] args) {
        String string = "My La Say Hii Nguyen Thi My La";
        Map<String, Integer> count = new HashMap<>();
        String[] words = string.split(" ");

        for ( String word : words){
            word = word.toLowerCase();

            if ( count.containsKey(word)){
                int counts = count.get(word);
                count.put(word, counts + 1);
            } else {
                count.put(word, 1);
            }
        }
        for ( String word : count.keySet()){
            int counts = count.get(word);
            System.out.println(word + ": " + counts);
        }
    }
}
