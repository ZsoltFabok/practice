package fizzbuzz;

import java.util.List;

public class Main {
    private Arguments arguments;
    private Converter converter;
    private FizzBuzz fizzbuzz;

    /**
     * dependency injection point, but for this simple class I won't add spring or guice
     */
    public Main(Arguments arguments, Converter converter, FizzBuzz fizzbuzz) {
        this.arguments = arguments;
        this.converter = converter;
        this.fizzbuzz = fizzbuzz;
    }

    public static void main(String... args) {
        new Main(new Arguments(), new Converter(), new FizzBuzz()).run(args);
    }

    void run(String... args) {
        try {
            List<Integer> arguments = this.arguments.parse(args);
            List<String> result = this.fizzbuzz.go(arguments.get(0), arguments.get(1));
            System.out.println(this.converter.list_to_string(result));
        } catch (IllegalArgumentException e) {
            System.err.println("wrong arguments, try: <number> <number>");
        }
    }
}
