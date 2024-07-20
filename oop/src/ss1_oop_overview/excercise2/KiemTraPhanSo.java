package ss1_oop_overview.excercise2;

public class KiemTraPhanSo {
    public static void main(String[] args) {
        PhanSo phanSo1 = new PhanSo();
        PhanSo phanSo2 = new PhanSo();

        System.out.println("Nhap phan so thu nhat");
        phanSo1.input();

        System.out.println("Nhap phan so thu hai");
        phanSo2.input();

        System.out.println("Phan so thu nhat la: ");
        phanSo1.xuat();

        System.out.println("Phan so thu hai la: ");
        phanSo2.xuat();

        System.out.println("Tong hai phan so: ");
        PhanSo tong = phanSo1.cong(phanSo2);
        tong.xuat();

        System.out.println("Hieu hai phan so: ");
        PhanSo hieu = phanSo1.tru(phanSo2);
        hieu.xuat();

        System.out.println("Tich hai phan so: ");
        PhanSo tich = phanSo1.nhan(phanSo2);
        tich.xuat();

        System.out.println("Thuong hai phan so: ");
        PhanSo thuong = phanSo1.chia(phanSo2);
        thuong.xuat();

        System.out.println("Phan so thu nhat la phan so " + (phanSo1.laPhanSoDuong() ? "duong" : "am"));

        System.out.println("Phan so thu hai la phan so " + (phanSo1.laPhanSoDuong() ? "duong" : "am"));

        System.out.println("Phan so thu nhat " + (phanSo1.laPhanSoKhong() ? "bang khong" : "khong bang khong"));

        System.out.println("Phan so thu nhat la phan so " + (phanSo1.laPhanSoDuong() ? " bang khong" : "khong bang khong"));

    }
}
