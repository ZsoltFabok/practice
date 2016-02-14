package fizzbuzz;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class ConverterTest {

    /**
     * this name is better than shouldReturnBlahBlah because should is not necessary because we are in a test case
     * plus there is the <code>@Test</code> annotation and one can read a sentence better than a [camel cased] word.
     */
    @Test
    public void list_to_string_works_fine() {
        assertEquals("1 2 3", new Converter().list_to_string(Arrays.asList(1, 2, 3)));
    }
}
