import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class Main {
    private static final Pattern[] INPUT_REGEXES = new Pattern[3];

    static {
        INPUT_REGEXES[0] = Pattern.compile(".*[A-Z].*");
        INPUT_REGEXES[1] = Pattern.compile(".*[a-z].*");
        INPUT_REGEXES[2] = Pattern.compile(".*\\d.*");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        System.out.println(isMatchingRegex(password) ? "YES" : "NO");
    }

    private static boolean isMatchingRegex(String input) {
        boolean isUpperCase = Stream.of(input).anyMatch(i -> i.matches(String.valueOf(INPUT_REGEXES[0])));
        boolean isLowerCase = Stream.of(input).anyMatch(i -> i.matches(String.valueOf(INPUT_REGEXES[1])));
        boolean isDigit = Stream.of(input).anyMatch(i -> i.matches(String.valueOf(INPUT_REGEXES[2])));

        return input.length() >= 12 && isUpperCase && isLowerCase && isDigit;
    }
}
