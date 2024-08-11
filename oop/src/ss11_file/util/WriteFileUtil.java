package ss11_file.util;


import ss4_inheritance.exercise1.Phone;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileUtil {
    public static  void writeFile(String path, String data) throws IOException{
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }
    public static void writePhoneFiles(String path, List<Phone> phones) throws IOException {
        StringBuilder data = new StringBuilder("ID, Name, Price, Warranty, Manafuture, Battery, Description, Quantity");
        for ( Phone phone : phones){
            data.append("\n").append(phone.toString());
        }
        writeFile(path, data.toString());
    }
}
