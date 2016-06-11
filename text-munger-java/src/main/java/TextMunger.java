import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class TextMunger {
    private static Pattern pattern = Pattern.compile("([a-zA-z])([a-zA-Z]{2,})([a-zA-z])");

    public static void main(String... args) {
        if (args.length == 1) {
            System.out.println(munge(args[0]));
        } else {
            System.err.println("Wrong arguments, try: \"input string\"");
        }
    }

    static String munge(String arg) {
        Matcher m = pattern.matcher(arg);
        StringBuffer s = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(s, m.group(1) + shuffle(m.group(2)) + m.group(3));
        }
        m.appendTail(s);
        return s.toString();
    }

    private static String shuffle(String arg) {
        List<String> temp = Arrays.asList(arg.split(""));
        Collections.shuffle(temp);
        return temp.stream().reduce("", (x, y) -> x + y);
    }
}
