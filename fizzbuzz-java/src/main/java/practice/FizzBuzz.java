package practice;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    /**
     * would be way easier with java 8 and <code>.stream().map()</code>
     */
    public List<String> go(int start, int end) {
        List<String> list = new ArrayList<>();
        for (int number = start; number <= end; number++) {
            list.add(convert(number));
        }
        return list;
    }

    /**
     * <code>number % 15 == 0</code> is cleaner and uses less objects than creating a <code>StringBuilder</code>
     * and adding 'Fizz' or later 'Buzz' to it based on the result of '%'.
     */
    private String convert(int number) {
        String result;
        if (number % 15 == 0) {
            result = "FizzBuzz";
        } else if (number % 3 == 0) {
            result = "Fizz";
        } else if (number % 5 == 0) {
            result = "Buzz";
        } else {
            result = Integer.toString(number);
        }
        return result;
    }
}
