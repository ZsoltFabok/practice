package fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class Arguments {
    public List<Integer> parse(String... args) {
        if (args.length == 2) {
            try {
                List<Integer> numbers = new ArrayList<>();
                for (String arg : args) {
                    numbers.add(Integer.parseInt(arg));
                }
                return numbers;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
