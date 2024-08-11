package ss11_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * c. Viết chương trình đếm số lần xuất hiện của 1 từ nào đó trong 1 file. Mỗi từ được đặt ở trên 1 dòng của file.
 */
public class Exercise1C {
    public static void main(String[] args) throws IOException {
        File file = new File("src/ss11_file/input.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String word = "Nguyen";
        String line;
        int count = 0;
        while ((line = bufferedReader.readLine()) != null){
           if ( line.equals(word)){
               count++;
           }
        }
        System.out.println("Time appear of word " + word + " is: " + count);
        bufferedReader.close();
    }
}
