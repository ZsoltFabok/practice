package practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

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


    @Test
    public void prints_a_munged_sentence() {
        TextMunger.main("10 abc de! who");
        assertEquals("10 abc de! who" + System.getProperty("line.separator"), stdout.toString());
        assertEquals("", stderr.toString());
    }

    @Test
    public void prints_error_message_for_wrong_number_of_arguments() {
        TextMunger.main("something", "other");
        assertEquals("", stdout.toString());
        assertEquals("Wrong arguments, try: \"input string\"" + System.getProperty("line.separator"), stderr.toString());
    }
}
