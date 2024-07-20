package ss1_oop_overview.Excercise3;

public class Distance {
    public static void main(String[] args) {
        Point point1 = new Point();
        Point point2 = new Point();

        System.out.println("Nhap toa do diem thu 1");
        point1.input();

        System.out.println("Nhap toa do diem thu 2");
        point2.input();

        double distance = point1.distanceTo(point2);

        System.out.println("Khoang cach 2 diem la: " + distance);
    }
}
