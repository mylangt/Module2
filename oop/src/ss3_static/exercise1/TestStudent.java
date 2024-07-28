package ss3_static.exercise1;

public class TestStudent {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Nguyen Thi My La", 10);
        Student student2 = new Student(2, "Nguyen Van Hoang Vuong", 9.9);
        Student student3 = new Student(1, "Tran Thi Thu Trang", 8.5);

        System.out.println("So luong sinh vien: " + Student.getStudentCount());
    }
}
