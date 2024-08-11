package ss9_set_map.set;

import java.util.HashSet;

public class Exercise1B {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 5, 6, 5, 7};

        HashSet<Integer> uniqueSet = new HashSet<>();
        int sum = 0;

        for ( int num : arr){
            if ( !uniqueSet.contains(num)){
                uniqueSet.add(num);
                sum += num;
            }
        }
        System.out.println("SUM: " + sum);
    }
}
