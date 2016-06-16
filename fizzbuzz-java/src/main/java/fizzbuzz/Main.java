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
            List<Integer> commandArgs = this.arguments.parse(args);
            List<String> result = this.fizzbuzz.go(commandArgs.get(0), commandArgs.get(1));
            System.out.println(this.converter.listToString(result)); // NOSONAR
        } catch (IllegalArgumentException e) {
            System.err.println("wrong arguments, try: <number> <number>"); // NOSONAR
        }
    }
}
