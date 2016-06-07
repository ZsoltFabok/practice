package fizzbuzz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class IntegrationTest {
    private ByteArrayOutputStream stdout = new ByteArrayOutputStream();
    private ByteArrayOutputStream stderr = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(stdout));
        System.setErr(new PrintStream(stderr));
    }

    @After
    public void teardown() {
        System.setOut(null);
        System.setErr(null);
    }

    /**
     * this name is better than shouldReturnBlahBlah because should is not necessary because we are in a test case
     * plus there is the <code>@Test</code> annotation and one can read a sentence better than a [camel cased] word.
     */
    @Test
    public void prints_fizzbuzz_from_ten_to_sixteen() {
        Main.main("10", "16");
        assertEquals("Buzz 11 Fizz 13 14 FizzBuzz 16" + System.getProperty("line.separator"), stdout.toString());
        assertEquals("", stderr.toString());
    }

    @Test
    public void prints_error_message_for_wrong_number_of_arguments() {
        Main.main("10");
        assertEquals("", stdout.toString());
        assertEquals("wrong arguments, try: <number> <number>" + System.getProperty("line.separator"), stderr.toString());
    }

    @Test
    public void prints_error_message_for_wrong_arguments() {
        Main.main("10", "buzz");
        assertEquals("", stdout.toString());
        assertEquals("wrong arguments, try: <number> <number>" + System.getProperty("line.separator"), stderr.toString());
    }
}
