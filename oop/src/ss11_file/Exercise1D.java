package ss11_file;

import java.io.File;
import java.io.IOException;

public class Exercise1D {
    public static void main(String[] args) throws IOException {
        String path = "src/ss11_file/input.txt";
        File file = new File(path);
        if (file.exists()){
            if (file.isFile()){
                System.out.println("Path is file");
            } else if (file.isDirectory()){
                System.out.println("Path is package");
            } else {
                System.out.println("Path is not a file and a package");
            }
        } else {
            System.out.println("Not found");
        }
    }
}
