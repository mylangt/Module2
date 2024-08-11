package ss11_file.util;

import ss10_exception.exception.EmptyFIeldException;
import ss10_exception.exception.NegativeNumberException;
import ss10_exception.exception.NumberOutOfRangeException;
import ss10_exception.validation.CommonValidation;
import ss4_inheritance.exercise1.NewPhone;
import ss4_inheritance.exercise1.OldPhone;
import ss4_inheritance.exercise1.Phone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileUtil {
    private static List<String> readFile(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        List<String> strings = new ArrayList<>();
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            strings.add(line);
        }
        bufferedReader.close();
        return strings;
    }

    public static List<Phone> readPhoneFile(String path) throws IOException {
        List<String> lines = readFile(path);
        List<Phone> phones = new ArrayList<>();
        Phone phone;
        String[] info;
        for (String line : lines) {
            info = line.split(",");
            if (info[0].startsWith("DTC")) {
                OldPhone oldPhone = new OldPhone();
                oldPhone.setBatteryStatus(Integer.parseInt(info[7]));
                oldPhone.setDescription(info[6]);
                phone = oldPhone;
            } else {
                NewPhone newPhone = new NewPhone();
                newPhone.setQuantity(Integer.parseInt(info[5]));
                phone = newPhone;
            }
            phone.setId(info[0]);
            phone.setName(info[1]);
            phone.setPrice(Double.parseDouble(info[2]));
            phone.setWarranty(Integer.parseInt(info[3]));
            phone.setManufacturer(info[4]);
            phones.add(phone);
        }
        return phones;
    }

    public static List<String> validatePhones(String path) throws IOException {
        List<String> linesValidated = new ArrayList<>();
        List<String> lines = readFile(path);
        String[] info;
        StringBuilder errorMessage = new StringBuilder();
        StringBuilder errorLineMessage;

        for (int i = 0; i < lines.size(); i++) {
            errorLineMessage = new StringBuilder();
            info = lines.get(i).split(",");
            if (!info[0].startsWith("DTC") && !info[0].startsWith("DTM")) {
                addMessage(errorLineMessage, "Code is not corrrect with format", i);
            }
            try {
                CommonValidation.validateIsEmpty(info[1], "name");
            } catch (EmptyFIeldException e) {
                e.printStackTrace();
                addMessage(errorLineMessage, e.getMessage(), i);
            }

            try {
                CommonValidation.validateIsEmpty(info[2], "price");
            } catch (EmptyFIeldException e) {
                e.printStackTrace();
                addMessage(errorLineMessage, e.getMessage(), i);
            }
            double price = 0;

            try {
                CommonValidation.validateIsNegativeNumber(price, "price");
            } catch (NegativeNumberException e) {
                e.printStackTrace();
                addMessage(errorLineMessage, e.getMessage(), i);
            }

            try {
                CommonValidation.validateIsEmpty(info[3], "warranty");
            } catch (EmptyFIeldException e) {
                e.printStackTrace();
                addMessage(errorLineMessage, e.getMessage(), i);
            }
            int warranty = 0;

            try {
                CommonValidation.validateIsEmpty(info[1], "name");
            } catch (EmptyFIeldException e) {
                e.printStackTrace();
                addMessage(errorLineMessage, e.getMessage(), i);
            }
            try {
                CommonValidation.validateIsNegativeNumber(warranty, "warranty");
            } catch (NegativeNumberException e) {
                e.printStackTrace();
                addMessage(errorLineMessage, e.getMessage(), i);
            }
            try {
                CommonValidation.validateIsEmpty(info[4], "manufacturer");
            } catch (EmptyFIeldException e) {
                e.printStackTrace();
                addMessage(errorLineMessage, e.getMessage(), i);
            }
            if (info[0].startsWith("DTC")) {
                try {
                    CommonValidation.validateIsEmpty(info[7], "batteryStatus");
                } catch (EmptyFIeldException e) {
                    e.printStackTrace();
                    addMessage(errorLineMessage, e.getMessage(), i);
                }
                int battery = 0;
                try {
                    battery = CommonValidation.parseInt(info[7], "batteryStatus");
                } catch (NumberOutOfRangeException e) {
                    e.printStackTrace();
                    addMessage(errorLineMessage, e.getMessage(), i);
                }
                try {
                    CommonValidation.validateNumberOutOfRangeException(battery, "batteryStatus", 0, 100);
                } catch (NumberOutOfRangeException e) {
                    e.printStackTrace();
                    addMessage(errorLineMessage, e.getMessage(), i);
                }

                try {
                    CommonValidation.validateIsEmpty(info[6], "description");
                } catch (EmptyFIeldException e) {
                    e.printStackTrace();
                    addMessage(errorLineMessage, e.getMessage(), i);
                }
            }
            if (info[0].startsWith("DTM")) {
                try {
                    CommonValidation.validateIsEmpty(info[5], "quantity");
                } catch (EmptyFIeldException e) {
                    e.printStackTrace();
                    addMessage(errorLineMessage, e.getMessage(), i);
                }
                int quantity = 0;
                try {
                    quantity = CommonValidation.parseInt(info[7], "batteryStatus");
                } catch (NumberOutOfRangeException e) {
                    e.printStackTrace();
                    addMessage(errorLineMessage, e.getMessage(), i);
                }
                try {
                    CommonValidation.validateIsNegativeNumber(quantity, "batteryStatus");
                } catch (NegativeNumberException e) {
                    e.printStackTrace();
                    addMessage(errorLineMessage, e.getMessage(), i);
                }
            }
            if (errorMessage.length() != 0) {
                if (errorMessage.length() != 0) {
                    errorMessage.append("\n");
                }
                errorMessage.append(errorLineMessage);
            } else {
                linesValidated.add(lines.get(i));
            }
        }
        WriteFileUtil.writeFile("src/ss11_file/error.txt", errorMessage.toString());
        return linesValidated;
    }

    private static void addMessage(StringBuilder errorLineMessage, String message, int lineNumber) {
        if (errorLineMessage.length() == 0) {
            errorLineMessage.append(String.format("Dong %s: ", lineNumber + 1));
        } else {
            errorLineMessage.append(",");
        }
        errorLineMessage.append(message);
    }

}
