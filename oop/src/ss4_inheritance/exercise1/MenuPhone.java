package ss4_inheritance.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPhone {
    static List<Phone> phones = new ArrayList<>();

    static {
        phones.add(new NewPhone("DTM001", "iphone11", 1000, 6, "apple", 4));
        phones.add(new NewPhone("DTM002", "iphone12", 2000, 8, "apple", 6));
        phones.add(new NewPhone("DTM003", "iphone13", 3000, 10, "apple", 8));
        phones.add(new NewPhone("DTM004", "iphone14", 4000, 12, "apple", 10));
        phones.add(new OldPhone("DTC001", "iphone11", 1000, 6, "apple", "Da su dung 1 nam", 70));
        phones.add(new OldPhone("DTC002", "iphone12", 2000, 5, "apple", "Da su dung 2 nam", 80));
        phones.add(new OldPhone("DTC003", "iphone13", 3000, 3, "apple", "Da su dung 3 nam", 0));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int menuId;
        do {
            System.out.println("-- CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI -");
            System.out.println("1. Xem danh sách điện thoại");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp theo giá");
            System.out.println("6. Tìm kiếm");
            System.out.println("7. Tính tổng tiền");
            System.out.println("8. Giảm giá cho điện thoại cũ");
            System.out.println("9. Thoát");

            System.out.println("Vui lòng chọn menu");
            menuId = Integer.parseInt(scanner.nextLine());

            switch (menuId) {
                case 1:
                    listPhone(scanner);
                    break;

                case 2:
                    addPhone(scanner);
                    break;

                case 3:
                    getAllPhone();
                    updatePhone(scanner);
                    break;
                case 4:
                    getAllPhone();
                    deletePhone(scanner);
                    break;

                case 5:
                    sortPricePhone(scanner);
                    break;

                case 6:
                    searchPhone(scanner);
                    break;

                case 7:
                    break;

                case 8:
                    break;


            }
        } while (menuId != 9);
    }
    private static void deletePhone(Scanner scanner) {
        System.out.print("Vui lòng nhập id sản phẩm bạn muốn xóa: ");
        String idDelelte = scanner.nextLine();
        boolean isExistPhone = false;
        if (idDelelte.startsWith("DTC")) {
            for (Phone phone : phones) {
                if (phone.getId().equals(idDelelte)) {
                    isExistPhone = true;
                    System.out.printf("Bạn có xóa điện thoại có mã %s không?\n", phone.getId());
                    System.out.println("Chọn Yes để xác nhận xóa, No để hủy");
                    if ("yes".equalsIgnoreCase(scanner.nextLine())) {
                        phones.remove(phone);
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Đã hủy việc xóa!");
                    }
                    break;
                }
            }
        } else if (idDelelte.startsWith("DTM")) {
            for (Phone phone : phones) {
                if (phone.getId().equals(idDelelte)) {
                    isExistPhone = true;
                    System.out.printf("Bạn có xóa điện thoại có mã %s không?\n", phone.getId());
                    System.out.println("Chọn Yes để xác nhận xóa, No để hủy");
                    if ("yes".equalsIgnoreCase(scanner.nextLine())) {
                        phones.remove(phone);
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Đã hủy việc xóa!");
                    }
                    break;
                }
            }
        }
        if (!isExistPhone) {
            System.out.println("Không tìm thấy mã muốn xóa!");
        }
    }
    private static void updatePhone(Scanner scanner) {
        System.out.print("Vui lòng nhập id sản phẩm bạn muốn chỉnh sửa: ");
        String idUpdate = scanner.nextLine();
        boolean isExistPhone = false;
        if (idUpdate.startsWith("DTC")) {
            for (Phone phone : phones) {
                if (phone.getId().equals(idUpdate)) {
                    isExistPhone = true;
                    OldPhone oldPhone = (OldPhone) phone;

                    System.out.print("Vui lòng chỉnh sửa tên điện thoại cũ: ");
                    String name = scanner.nextLine();
                    oldPhone.setName(name);

                    System.out.print("Vui lòng chỉnh sửa giá bán điện thoại cũ: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    oldPhone.setPrice(price);

                    System.out.print("Vui lòng chỉnh sửa thời hạn bảo hành điện thoại cũ: ");
                    int warranty = Integer.parseInt(scanner.nextLine());
                    oldPhone.setWarranty(warranty);

                    System.out.print("Vui lòng chỉnh sửa hãng sản xuất điện thoại cũ: ");
                    String manufacturer = scanner.nextLine();
                    oldPhone.setManufacturer(manufacturer);

                    System.out.print("Vui lòng chỉnh sửa tình trạng pin điện thoại cũ: ");
                    int batteryStatus = Integer.parseInt(scanner.nextLine());
                    oldPhone.setBatteryStatus(batteryStatus);

                    System.out.print("Vui lòng chỉnh sửa mô tả điện thoại cũ: ");
                    String description = scanner.nextLine();
                    oldPhone.setDescription(description);

                    System.out.println("Cập nhật thành công!");
                    break;
                }
            }

        } else if (idUpdate.startsWith("DTM")) {
            for (Phone phone : phones) {
                if (phone.getId().equals(idUpdate)) {
                    isExistPhone = true;
                    NewPhone newPhone = (NewPhone) phone;

                    System.out.print("Vui lòng nhập tên điện thoại mới: ");
                    String name = scanner.nextLine();
                    newPhone.setName(name);

                    System.out.print("Vui lòng nhập giá bán điện thoại mới: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    newPhone.setPrice(price);

                    System.out.print("Vui lòng nhập thời hạn bảo hành điện thoại mới: ");
                    int warranty = Integer.parseInt(scanner.nextLine());
                    newPhone.setWarranty(warranty);

                    System.out.print("Vui lòng nhập hãng sản xuất điện thoại mới: ");
                    String manufacturer = scanner.nextLine();
                    newPhone.setManufacturer(manufacturer);

                    System.out.print("Vui lòng nhập số lượng điện thoại mới: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    newPhone.setQuantity(quantity);

                    System.out.println("Cập nhật thành công!");
                    break;
                }
            }
        }
        if (!isExistPhone) {
            System.out.println("Không tìm thấy mã muốn cập nhật!");
        }
    }

    private static void searchPhone(Scanner scanner) {
        int menuSearchPhone;
        do {
            System.out.println("--  TÌM KIẾM   --");
            System.out.println("1. Tìm kiếm tất cả điện thoại");
            System.out.println("2. Tìm kiếm điện thoại cũ");
            System.out.println("3. Tìm kiếm điện thoại mới");
            System.out.println("4. Trở về menu chính");

            System.out.println("Vui lòng lựa chọn trong tìm kiếm");
            menuSearchPhone = scanner.nextInt();

            switch (menuSearchPhone) {
                case 1, 2, 3:
                    subSearchPhone(scanner);
                    break;
            }
        } while (menuSearchPhone != 4);

    }

    private static void subSearchPhone(Scanner scanner) {
        int menuSubSearchPhone;
        do {
            System.out.println("1. Tìm kiếm theo giá (Nhập khoảng từ bao nhiêu đến bao nhiêu)");
            System.out.println("2. Tìm kiếm theo tên");
            System.out.println("3. Tìm kiếm theo hãng");
            System.out.println("4. Trở về menu chính");

            System.out.println("Vui lòng lựa chọn trong tìm kiếm");
            menuSubSearchPhone = scanner.nextInt();

            switch (menuSubSearchPhone) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        } while (menuSubSearchPhone != 4);

    }

    private static void sortPricePhone(Scanner scanner) {
        int menuSortPhone;
        do {
            System.out.println("-- SẮP XẾP GIÁ  --");
            System.out.println("1. Tăng dần");
            System.out.println("2. Giảm dần");
            System.out.println("3. Trở về menu chính");

            System.out.println("Vui lòng lựa chọn trong sắp xếp giá");
            menuSortPhone = scanner.nextInt();

            switch (menuSortPhone) {
                case 1:
                    break;
                case 2:
                    break;
            }
        } while (menuSortPhone != 3);
    }

    private static void addPhone(Scanner scanner) {
        int menuAddPhone;
        do {
            System.out.println("-- THÊM MỚI --");
            System.out.println("1. Thêm mới điện thoại mới");
            System.out.println("2. Thêm mới điện thoại cũ");
            System.out.println("3. Trở về menu chính");

            System.out.println("Vui lòng lựa chọn trong thêm mới");
            menuAddPhone = Integer.parseInt(scanner.nextLine());

            switch (menuAddPhone) {
                case 1:
                    String newPhoneId = getNewPhoneId();
                    addNewPhone(scanner, newPhoneId);
                    break;
                case 2:
                    String oldPhoneId = getOldPhoneId();
                    addOldPhone(scanner, oldPhoneId);
                    break;
            }
        } while (menuAddPhone != 3);
    }

    private static void addNewPhone(Scanner scanner, String newPhoneId) {
        System.out.print("Vui lòng nhập tên điện thoại mới: ");
        String name = scanner.nextLine();

        System.out.print("Vui lòng nhập giá bán điện thoại mới: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Vui lòng nhập thời hạn bảo hành điện thoại mới: ");
        int warranty = Integer.parseInt(scanner.nextLine());

        System.out.print("Vui lòng nhập hãng sản xuất điện thoại mới: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Vui lòng nhập số lượng điện thoại mới: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        NewPhone newPhone = new NewPhone(newPhoneId, name, price, warranty, manufacturer, quantity);
        phones.add(newPhone);

        System.out.println("Thêm mới điện thoại mới thành công !!! ");
    }

    private static String getNewPhoneId() {
        String newPhoneId;
        if (phones.isEmpty()) {
            newPhoneId = "DTM001";
        }
        int maxId = Integer.parseInt(phones.get(0).getId().substring(3));
        for (int i = 0; i < phones.size(); i++) {
            int id = Integer.parseInt(phones.get(i).getId().substring(3));
            if (maxId < id) {
                maxId = id;
            }
        }
        newPhoneId = String.format("DTM%3d", maxId + 1).replace(" ", "0");
        return newPhoneId;
    }

    private static String getOldPhoneId() {
        String oldPhoneId;
        if (phones.isEmpty()) {
            oldPhoneId = "DTC001";
        }
        int maxId = Integer.parseInt(phones.get(0).getId().substring(3));
        for (int i = 0; i < phones.size(); i++) {
            int id = Integer.parseInt(phones.get(i).getId().substring(3));
            if (maxId < id) {
                maxId = id;
            }
        }
        oldPhoneId = String.format("DTC%3d", maxId + 1).replace(" ", "0");
        return oldPhoneId;
    }

    private static void addOldPhone(Scanner scanner, String oldPhoneId) {
        System.out.print("Vui lòng nhập tên điện thoại cũ: ");
        String name = scanner.nextLine();

        System.out.print("Vui lòng nhập giá bán điện thoại cũ: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Vui lòng nhập thời hạn bảo hành điện thoại cũ: ");
        int warranty = Integer.parseInt(scanner.nextLine());

        System.out.print("Vui lòng nhập hãng sản xuất điện thoại cũ: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Vui lòng nhập tình trạng pin điện thoại cũ: ");
        int batteryStatus = Integer.parseInt(scanner.nextLine());

        System.out.print("Vui lòng nhập mô tả điện thoại cũ: ");
        String description = scanner.nextLine();

        OldPhone oldPhone = new OldPhone(oldPhoneId, name, price, warranty, manufacturer, description, batteryStatus);
        phones.add(oldPhone);

        System.out.println("Thêm mới điện thoại cũ thành công !!! ");
    }

    private static void listPhone(Scanner scanner) {
        int menuListPhone;
        do {
            System.out.println("-- XEM DANH SÁCH ĐIỆN THOẠI --");
            System.out.println("1. Xem tất cả");
            System.out.println("2. Xem điện thoại cũ");
            System.out.println("3. Xem điện thoại mới");
            System.out.println("4. Trở về menu chính");

            System.out.println("Vui lòng lựa chọn trong danh sách điện thoại");
            menuListPhone = Integer.parseInt(scanner.nextLine());

            switch (menuListPhone) {
                case 1:
                    getAllPhone();
                    break;
                case 2:
                    getOldPhone();
                    break;
                case 3:
                    getNewPhone();
                    break;
            }
        } while (menuListPhone != 4);
    }

    private static void getNewPhone() {
        int newPhoneCount = 0;

        for (int i = 0; i < phones.size(); i++ ) {
            if (phones.get(i) instanceof NewPhone) {
                newPhoneCount++;
                System.out.print("Thông tin điện thoại mới thứ " + newPhoneCount + " là: ");
                System.out.println(phones.get(i));
            }
        }
    }

    private static void getOldPhone() {
        int oldPhoneCount = 0;

        for (int i = 0; i < phones.size(); i++ ) {
            if (phones.get(i) instanceof OldPhone) {
                oldPhoneCount++;
                System.out.print("Thông tin điện thoại cũ thứ " + oldPhoneCount + " là: ");
                System.out.println(phones.get(i));
            }
        }
    }

    private static void getAllPhone() {
        int newPhoneCount = 0;
        int oldPhoneCount = 0;

        for (int i = 0; i < phones.size(); i++ ) {
            if (phones.get(i) instanceof NewPhone) {
                newPhoneCount++;
                System.out.print("Thông tin điện thoại mới thứ " + newPhoneCount + " là: ");
            } else {
                oldPhoneCount++;
                System.out.print("Thông tin điện thoại cũ thứ " + oldPhoneCount + " là: ");
            }
            System.out.println(phones.get(i));
        }
    }
}
