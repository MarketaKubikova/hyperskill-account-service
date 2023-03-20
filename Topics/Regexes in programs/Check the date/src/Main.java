import java.util.*;

class Date {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String date = scn.nextLine();
        String dateRegex = "((0[1-9])|([12]\\d)|(3[01])|((19|20)\\d\\d))([\\-\\\\/\\.])(0[1-9]|1[0-2])([\\-\\\\/\\.])((0[1-9])|([12]\\d)|(3[01])|((19|20)\\d\\d))";

        System.out.println(date.matches(dateRegex) ? "Yes" : "No");
    }
}
