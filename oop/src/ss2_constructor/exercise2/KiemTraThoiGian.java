package ss2_constructor.exercise2;

/*
Đề bài: Tạo lớp ThoiGian với các constructor và phương thức xuat() để đáp ứng yêu cầu đề bài
 */

public class KiemTraThoiGian {
    public static void main(String[] args) {
        ThoiGian a = new ThoiGian();
        a.output();

        ThoiGian b = new ThoiGian(7);
        b.output();

        ThoiGian c = new ThoiGian(7, 30);
        c.output();

        ThoiGian d = new ThoiGian(7, 30, 50);
        d.output();

        ThoiGian f = new ThoiGian(d);
        f.output();
    }
}
