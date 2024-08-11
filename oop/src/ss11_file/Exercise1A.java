package ss11_file;

import java.io.*;

/**
 * a. Viết chương trình đọc vào tất cả các dòng của 1 file. Sau đó hiển thị tất cả thông tin đọc được trên cùng 1 dòng.
 *
 * b. Viết chương trình đọc vào đúng 3 dòng của 1 file. Sau đó hiển thị các dòng đọc được ra màn hình console.
 *
 * c. Viết chương trình đếm số lần xuất hiện của 1 từ nào đó trong 1 file. Mỗi từ được đặt ở trên 1 dòng của file.
 *
 * d. Viết chương trình kiểm tra xem 1 đường dẫn đang chỉ đến 1 file hay 1 thư mục.
 *
 * e. Viết chương trình xóa 1 file hoặc 1 thư mục cho trước.
 *
 * f. Viết chương trình đổi tên 1 file hoặc 1 thư mục cho trước.
 */
public class Exercise1A {
    public static void main(String[] args) throws IOException {
        File file = new File("src/ss11_file/input.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        bufferedReader.close();

    }
}
