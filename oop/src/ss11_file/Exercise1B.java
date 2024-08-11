package ss11_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * b. Viết chương trình đọc vào đúng 3 dòng của 1 file. Sau đó hiển thị các dòng đọc được ra màn hình console.
 */
public class Exercise1B {
    public static void main(String[] args)  throws IOException {
        File file = new File("src/ss11_file/input.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        int count = 0;
        while ((line = bufferedReader.readLine()) != null && count < 3){
            count++;
            System.out.println(line);
        }
        bufferedReader.close();

    }
}
