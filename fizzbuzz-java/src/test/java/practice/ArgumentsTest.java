package practice;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class ArgumentsTest {

    private Arguments arguments;

    @Before
    public void setup() {
        this.arguments = new Arguments();
    }

    /**
     * this name is better than shouldReturnBlahBlah because should is not necessary because we are in a test case
     * plus there is the <code>@Test</code> annotation and one can read a sentence better than a [camel cased] word.
     */
    @Test
    public void two_numbers_are_fine() {
        assertEquals(Arrays.asList(1, 2), this.arguments.parse("1", "2"));
    }

    @Test(expected=IllegalArgumentException.class)
    public void exception_for_less_arguments() {
        this.arguments.parse("1");
    }

    @Test(expected=IllegalArgumentException.class)
    public void exception_for_more_arguments() {
        this.arguments.parse("1", "3", "4");
    }

    @Test(expected=IllegalArgumentException.class)
    public void exception_for_invalid_arguments() {
        this.arguments.parse("1", "buzz");
    }
}
