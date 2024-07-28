package ss1_oop_overview.excercise2;
import java.util.Scanner;

/*
Viết chương trình nhập vào một phân số (gồm tử & mẫu).
    a. Viết method nhập, xuất cho phân số.
        i.  Đối với method nhập sẽ không cho nhập mẫu vào số 0
        ii. Đối với method xuất nên ở dạng rút gọn nhất (2/8 nên là 1/4, 8/-4 nên là -2, …)
    b. Tính Tổng, Hiệu, tích thương của 2 phân số
    c. Hãy cho biết phân số đó là phân số âm hay dương hay bằng không
 */
public class PhanSo {
    int tuSo;
    int mauSo;

    void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap tu so: ");
        tuSo = scanner.nextInt();

        do {
            System.out.print("Nhap mau so: ");
            mauSo = scanner.nextInt();
        } while (mauSo == 0 );
    }
    int uocChungLonNhat(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        a = Math.abs(a);
        b = Math.abs(b);


        for (int i = a; i >=1; i-- ) {
            if (a % i ==0 && b %i == 0) {
                return i;
            }
        }
        return 1;
    }

    void rutGon() {
        int ucln = uocChungLonNhat(tuSo, mauSo);
        tuSo /= ucln;
        mauSo /= ucln;

        if (mauSo < 0) {
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
    }

    public void xuat() {
        rutGon();
        if (mauSo == 1) {
            System.out.println(tuSo);
        } else {
            System.out.println(tuSo + "/" + mauSo);
        }
    }
    PhanSo cong(PhanSo phanSoKhac) {
        PhanSo ketQua = new PhanSo();
        ketQua.tuSo = this.tuSo * phanSoKhac.mauSo + phanSoKhac.tuSo * this.mauSo;
        ketQua.mauSo = this.mauSo * phanSoKhac.mauSo;
        return ketQua;
    }

    PhanSo tru(PhanSo phanSoKhac) {
        PhanSo ketQua = new PhanSo();
        ketQua.tuSo = this.tuSo * phanSoKhac.mauSo - phanSoKhac.tuSo * this.mauSo;
        ketQua.mauSo = this.mauSo * phanSoKhac.mauSo;
        return ketQua;
    }

    PhanSo nhan(PhanSo phanSoKhac) {
        PhanSo ketQua = new PhanSo();
        ketQua.tuSo = this.tuSo * phanSoKhac.tuSo;
        ketQua.mauSo = this.mauSo * phanSoKhac.mauSo;
        return ketQua;
    }

    PhanSo chia(PhanSo phanSoKhac) {
        PhanSo ketQua = new PhanSo();
        ketQua.tuSo = this.tuSo * phanSoKhac.mauSo;
        ketQua.mauSo = this.mauSo * phanSoKhac.tuSo;
        return ketQua;
    }

    boolean laPhanSoDuong() {
        return tuSo * mauSo > 0 || tuSo == 0;
    }

    boolean laPhanSoKhong() {
        return tuSo == 0;
    }
}
