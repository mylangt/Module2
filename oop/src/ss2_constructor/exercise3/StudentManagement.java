package ss2_constructor.exercise3;

public class StudentManagement {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Nguyen Thi My La", 10);

        System.out.println("Kiem tra thong tin ban dau");
        System.out.println("ID: " + student1.getId());
        System.out.println("Ten: " + student1.getName());
        System.out.println("Diem so: " + student1.getScore());

        student1.setName("Phan Thi Hong");
        student1.setScore(9.0);

        System.out.println("\nThong tin sau khi cap nhat");
        System.out.println("ID: " + student1.getId());
        System.out.println("Ten: " + student1.getName());
        System.out.println("Diem so: " + student1.getScore());

        student1.setName("    ");
        student1.setScore(11);
    }
}
