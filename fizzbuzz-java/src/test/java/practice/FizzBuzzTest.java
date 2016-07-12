package practice;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    private FizzBuzz fizzbuzz;

    @Before
    public void setup() {
        this.fizzbuzz = new FizzBuzz();
    }

    /**
     * this name is better than shouldReturnBlahBlah because should is not necessary because we are in a test case
     * plus there is the <code>@Test</code> annotation and one can read a sentence better than a [camel cased] word.
     */
    @Test
    public void returns_one_for_one() {
        assertEquals(Arrays.asList("1"), this.fizzbuzz.go(1, 1));
    }

    @Test
    public void returns_two_for_two() {
        assertEquals(Arrays.asList("2"), this.fizzbuzz.go(2, 2));
    }

    @Test
    public void returns_fizz_for_three() {
        assertEquals(Arrays.asList("Fizz"), this.fizzbuzz.go(3, 3));
    }

    @Test
    public void returns_fizz_for_six() {
        assertEquals(Arrays.asList("Fizz"), this.fizzbuzz.go(6, 6));
    }

    @Test
    public void returns_buzz_for_five() {
        assertEquals(Arrays.asList("Buzz"), this.fizzbuzz.go(5, 5));
    }

    @Test
    public void returns_fizzbuzz_for_fifteen() {
        assertEquals(Arrays.asList("FizzBuzz"), this.fizzbuzz.go(15, 15));
    }

    @Test
    public void returns_fizz_four_buzz_for_three_to_five() {
        assertEquals(Arrays.asList("Fizz", "4", "Buzz"), this.fizzbuzz.go(3, 5));
    }
}
