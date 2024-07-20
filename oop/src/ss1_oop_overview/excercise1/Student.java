package ss1_oop_overview.excercise1;

import java.util.Scanner;

/*
Viết chương trình cho phép nhập thông tin học sinh, bao gồm: tên học sinh, điểm toán, và điểm văn.
 Tính điểm trung bình và hiển thị kết quả.
 */
public class Student {
    String name;
    double mathScore;
    double literatureScore;

    void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap vao ten hoc sinh: ");
        name = scanner.nextLine();

        System.out.print("Nhap vao diem Toan: ");
        mathScore = scanner.nextDouble();

        System.out.print("Nhap vao diem Van: ");
        literatureScore = scanner.nextDouble();
    }

    double calculateAverageScore() {
        return (mathScore + literatureScore) / 2;
    }

    void output() {
        System.out.println("Ten hoc sinh: " + name);
        System.out.println("Diem Toan la: " + mathScore);
        System.out.println("Diem Van la: " + literatureScore);
        System.out.println("Diem trung binh la: " + calculateAverageScore());
    }
}
