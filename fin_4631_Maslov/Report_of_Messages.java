import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Report_of_Messages {
    public static void arrayEnteredData(String[] userData) {
        int count = 0;
        if (userData.length != 6) {
            System.out.println("You have entered more or less data than required, enter the line again");
            count++;
        } else {
            if (!userData[0].matches("[а-яА-Яa-zA-Z]+")) {
                System.out.println("The last name was entered incorrectly, enter the line again");
                count++;
            }
            if (!userData[1].matches("[а-яА-Яa-zA-Z]+")) {
                System.out.println("The name is entered incorrectly, enter the line again");
                count++;
            }
            if (!userData[2].matches("[а-яА-Яa-zA-Z]+")) {
                System.out.println("The patronymic was entered incorrectly, enter the line again");
                count++;
            }
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            try {
                df.parse(userData[3]);
            } catch (ParseException e) {
                System.out.println("Invalid date format, enter the line again");
                count++;
            }
            try {
                Long.parseLong(userData[4]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid phone format, enter the line again");
                count++;
            }
            if (!userData[5].equalsIgnoreCase("f") && !userData[5].equalsIgnoreCase("m")) {
                System.out.println("The gender is entered incorrectly, enter the line again");
                count++;
            }
        }
        if (count == 0) {
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < userData.length; i++) {
                if (i == userData.length - 1) {
                    text.append(userData[i]);
                } else {
                    text.append(userData[i]).append(" ");
                }
            }
            WriteFile.creatingFile(text.toString(), userData[0]);
        }
    }
}