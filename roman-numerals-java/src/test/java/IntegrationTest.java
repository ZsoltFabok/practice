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
    public void setUp() {
        System.setOut(new PrintStream(stdout));
        System.setErr(new PrintStream(stderr));
    }

    @After
    public void tearDown() {
        System.setOut(null);
        System.setErr(null);
    }

    /**
     * this name is better than shouldReturnBlahBlah because should is not necessary because we are in a test case
     * plus there is the <code>@Test</code> annotation and one can read a sentence better than a [camel cased] word.
     */
    @Test
    public void prints_ix_for_nine() {
        RomanNumerals.main("2");
        assertEquals("II\n", stdout.toString());
        assertEquals("", stderr.toString());
    }
}
