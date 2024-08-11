package ss4_inheritance.exercise1;

import ss11_file.util.ReadFileUtil;
import ss11_file.util.WriteFileUtil;

import java.io.IOException;
import java.util.*;

public class MenuPhone {
    static List<Phone> phones = new ArrayList<>();
    private static final String PATH_FILE_PHONE = "src/ss11_file/data/phone.csv";

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
        try {
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
                        System.out.println("Tổng giá của tất cả các điện thoại: "
                                + calculateTotalPriceInStore());
                        break;
                    case 8:
                        System.out.println("Nhập vào phần trăm muốn giảm giá: ");
                        double percentDiscount = Double.parseDouble(scanner.nextLine());
                        applyDiscountToOldPhones(percentDiscount);
                        System.out.println("Đã giảm giá thành công!!!");
                        break;
                }
            } while (menuId != 9);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Có một số lỗi!!!" +
                    "xin vui lòng thử lại.");
        }
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
            menuSearchPhone = Integer.parseInt(scanner.nextLine());

            switch (menuSearchPhone) {
                case 1:
                    menuSearchAllPhone(scanner);
                    break;
                case 2:
                    menuSearchOldPhone(scanner);
                    break;
                case 3:
                    menuSearchNewPhone(scanner);
                    break;
            }
        } while (menuSearchPhone != 4);

    }

    private static void menuSearchAllPhone(Scanner scanner) {
        int menuSubSearchPhone;
        do {
            System.out.println("1. Tìm kiếm theo giá (Nhập khoảng từ bao nhiêu đến bao nhiêu)");
            System.out.println("2. Tìm kiếm theo tên");
            System.out.println("3. Tìm kiếm theo hãng");
            System.out.println("4. Trở về menu chính");

            System.out.println("Vui lòng lựa chọn trong tìm kiếm");
            menuSubSearchPhone = Integer.parseInt(scanner.nextLine());

            switch (menuSubSearchPhone) {
                case 1:
                    System.out.println("Nhập vào khoảng giá muốn tìm");
                    System.out.print("Nhập vào giá từ: ");
                    int priceFrom = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nhập vào giá đến: ");
                    int priceTo = Integer.parseInt(scanner.nextLine());

                    int count = 1;
                    for (Phone phone : phones) {
                        if (phone.getPrice() >= priceFrom && phone.getPrice() <= priceTo) {
                            System.out.print("Thông tin điện thoại thứ " + count++ + ": ");
                            System.out.println(phone);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Nhập vào tên cần tìm: ");
                    String name = scanner.nextLine();
                    count = 1;
                    for (Phone phone : phones) {
                        if (phone.getName().contains(name)) {
                            System.out.print("Thông tin điện thoại thứ " + count++ + ": ");
                            System.out.println(phone);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhập vào hãng điện thoại cần tìm: ");
                    String manufacturer = scanner.nextLine();
                    count = 1;
                    for (Phone phone : phones) {
                        if (phone.getManufacturer().contains(manufacturer)) {
                            System.out.print("Thông tin điện thoại thứ " + count++ + ": ");
                            System.out.println(phone);
                        }
                    }
                    break;
            }
        } while (menuSubSearchPhone != 4);
    }

    private static void menuSearchOldPhone(Scanner scanner) {
        int menuSubSearchPhone;
        do {
            System.out.println("1. Tìm kiếm theo giá (Nhập khoảng từ bao nhiêu đến bao nhiêu)");
            System.out.println("2. Tìm kiếm theo tên");
            System.out.println("3. Tìm kiếm theo hãng");
            System.out.println("4. Trở về menu chính");

            System.out.println("Vui lòng lựa chọn trong tìm kiếm");
            menuSubSearchPhone = Integer.parseInt(scanner.nextLine());

            ArrayList<OldPhone> oldPhones = new ArrayList<>();

            for (Phone value : phones) {
                if (value instanceof OldPhone) {
                    oldPhones.add((OldPhone) value);
                }
            }

            switch (menuSubSearchPhone) {
                case 1:
                    System.out.println("Nhập vào khoảng giá muốn tìm");
                    System.out.print("Nhập vào giá từ: ");
                    int priceFrom = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nhập vào giá đến: ");
                    int priceTo = Integer.parseInt(scanner.nextLine());

                    int count = 1;
                    for (Phone phone : oldPhones) {
                        if (phone.getPrice() >= priceFrom && phone.getPrice() <= priceTo) {
                            System.out.print("Thông tin điện thoại thứ " + count++ + ": ");
                            System.out.println(phone);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Nhập vào tên cần tìm: ");
                    String name = scanner.nextLine();
                    count = 1;
                    for (Phone phone : oldPhones) {
                        if (phone.getName().contains(name)) {
                            System.out.print("Thông tin điện thoại thứ " + count++ + ": ");
                            System.out.println(phone);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhập vào hãng điện thoại cần tìm: ");
                    String manufacturer = scanner.nextLine();
                    count = 1;
                    for (Phone phone : oldPhones) {
                        if (phone.getManufacturer().contains(manufacturer)) {
                            System.out.print("Thông tin điện thoại thứ " + count++ + ": ");
                            System.out.println(phone);
                        }
                    }
                    break;
            }
        } while (menuSubSearchPhone != 4);
    }

    private static void menuSearchNewPhone(Scanner scanner) {
        int menuSubSearchPhone;
        do {
            System.out.println("1. Tìm kiếm theo giá (Nhập khoảng từ bao nhiêu đến bao nhiêu)");
            System.out.println("2. Tìm kiếm theo tên");
            System.out.println("3. Tìm kiếm theo hãng");
            System.out.println("4. Trở về menu chính");

            System.out.println("Vui lòng lựa chọn trong tìm kiếm");
            menuSubSearchPhone = Integer.parseInt(scanner.nextLine());

            ArrayList<NewPhone> newPhones = new ArrayList<>();

            for (Phone value : phones) {
                if (value instanceof NewPhone) {
                    newPhones.add((NewPhone) value);
                }
            }

            switch (menuSubSearchPhone) {
                case 1:
                    System.out.println("Nhập vào khoảng giá muốn tìm");
                    System.out.print("Nhập vào giá từ: ");
                    int priceFrom = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nhập vào giá đến: ");
                    int priceTo = Integer.parseInt(scanner.nextLine());

                    int count = 1;
                    for (Phone phone : newPhones) {
                        if (phone.getPrice() >= priceFrom && phone.getPrice() <= priceTo) {
                            System.out.print("Thông tin điện thoại thứ " + count++ + ": ");
                            System.out.println(phone);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Nhập vào tên cần tìm: ");
                    String name = scanner.nextLine();
                    count = 1;
                    for (Phone phone : newPhones) {
                        if (phone.getName().contains(name)) {
                            System.out.print("Thông tin điện thoại thứ " + count++ + ": ");
                            System.out.println(phone);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhập vào hãng điện thoại cần tìm: ");
                    String manufacturer = scanner.nextLine();
                    count = 1;
                    for (Phone phone : newPhones) {
                        if (phone.getManufacturer().contains(manufacturer)) {
                            System.out.print("Thông tin điện thoại thứ " + count++ + ": ");
                            System.out.println(phone);
                        }
                    }
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
            menuSortPhone = Integer.parseInt(scanner.nextLine());

            switch (menuSortPhone) {
                case 1:
                    Collections.sort(phones);
//                    for (int i = 0; i < phones.size() - 1; i++) {
//                        for (int j = i + 1; j < phones.size(); j++) {
//                            if (phones.get(i).getPrice() > phones.get(j).getPrice()) {
//                                Phone temp = phones.get(i);
//                                phones.set(i, phones.get(j));
//                                phones.set(j, temp);
//                            }
//                        }
//                    }
                    System.out.println("Sắp xếp thành công!!!");
                    break;
                case 2:
                    phones.sort(Collections.reverseOrder());
//                    for (int i = 0; i < phones.size() - 1; i++) {
//                        for (int j = i + 1; j < phones.size(); j++) {
//                            if (phones.get(i).getPrice() < phones.get(j).getPrice()) {
//                                Phone temp = phones.get(i);
//                                phones.set(i, phones.get(j));
//                                phones.set(j, temp);
//                            }
//                        }
//                    }
                    System.out.println("Sắp xếp thành công!!!");
                    break;
            }
        } while (menuSortPhone != 3);
    }

    private static void addPhone(Scanner scanner) throws IOException {
        List<Phone> phones = ReadFileUtil.readPhoneFile((PATH_FILE_PHONE));
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
                    addNewPhone(newPhoneId);
                    break;
                case 2:
                    String oldPhoneId = getOldPhoneId();
                    addOldPhone(oldPhoneId);
                    break;
            }
        } while (menuAddPhone != 3);
    }

    private static void addNewPhone(String newPhoneId) throws IOException {
        NewPhone newPhone = new NewPhone();
        newPhone.input();
        newPhone.setId(newPhoneId);
        phones.add(newPhone);
        WriteFileUtil.writePhoneFiles(PATH_FILE_PHONE, phones);
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

    private static void addOldPhone(String oldPhoneId) throws IOException {
        OldPhone oldPhone = new OldPhone();
        oldPhone.input();
        oldPhone.setId(oldPhoneId);
        phones.add(oldPhone);
        WriteFileUtil.writePhoneFiles(PATH_FILE_PHONE, phones);
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

    private static double calculateTotalPriceInStore() {
        double total = 0.0;
        for (Phone phone: phones) {
            total += phone.calculateTotalPrice();
        }
        return total;
    }

    public static void applyDiscountToOldPhones(double percentDiscount) {
        for (Phone phone: phones) {
            if (phone instanceof OldPhone) {
                ((OldPhone) phone).applyDiscount(percentDiscount);
            }
        }
    }

}
