package account.util;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Formatter {
    private Formatter() {
    }

    public static String formatSalary(Long salary) {
        return String.format("%d dollar(s) %d cent(s)",
                salary / 100,
                salary % 100);
    }

    public static LocalDate stringToDate(String period) {
        return YearMonth.parse(period, DateTimeFormatter.ofPattern("MM-yyyy")).atDay(1);
    }

    public static String dateToString(LocalDate period) {
        return period.format(DateTimeFormatter.ofPattern("MMMM-yyyy"));
    }
}
