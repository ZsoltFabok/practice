package practice;

import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class RomanDecimalNumeralsTest {

    private RomanNumerals romanNumerals = new RomanNumerals();

    @Test
    public void all_variations() throws IOException {
        Properties numbers = new Properties();
        numbers.load(getClass().getResourceAsStream("/numbers.properties"));

        numbers.entrySet().stream().forEach((entry) -> {
            String expectedRoman = (String) entry.getValue();
            Integer arabic = Integer.parseInt((String) entry.getKey());
            String roman = romanNumerals.get(arabic);
            assertEquals( arabic + " should be " + expectedRoman + ", but was " + roman, expectedRoman, roman);
        });
    }
}
