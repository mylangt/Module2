package ss9_set_map.map;

import java.util.*;

public class Exercise2B {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("My", "La", "Say","Hii");
        Map<String , Integer> nameCount = new HashMap<>();
        for ( String name : names){
            nameCount.put(name, nameCount.getOrDefault(name,0) + 1);
        }
        System.out.println("List of unique name");
        for ( String name : nameCount.keySet()){
            if ( nameCount.get(name) == 1){
                System.out.println(name);
            }
        }
        System.out.println("List of name appear x times");
        for ( String name : nameCount.keySet()){
            if ( nameCount.get(name) > 1){
                System.out.println(name);
            }
        }
    }
}
