package ss3_static.exercise2;

public class MathUtilManagement {
    public static void main(String[] args) {
        double num1 = 10.0;
        double num2 = 20.0;

        double sum = MathUtil.add(num1, num2);
        double difference = MathUtil.subtract(num1, num2);
        double product = MathUtil.multipy(num1, num2);
        double quotient = MathUtil.divide(num1, num2);

        System.out.println("Tong: " + sum);
        System.out.println("Hieu: " + difference);
        System.out.println("Tich: " + product);
        System.out.println("Thuong: " + quotient);
    }
}
