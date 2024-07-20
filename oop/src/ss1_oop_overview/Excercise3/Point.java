package ss1_oop_overview.Excercise3;

import java.util.Scanner;

public class Point {
    double x;
    double y;

    void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap toa do x: ");
        x = scanner.nextDouble();

        System.out.print("Nhap toa do y: ");
        y = scanner.nextDouble();
    }

    double distanceTo(Point other) {
        return Math.sqrt(Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2));
    }
}
