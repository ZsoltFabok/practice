import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanDecimalNumeralsTDDStepsTest {

    private final RomanNumerals romanNumerals = new RomanNumerals();

    @Test
    public void return_i_for_one() {
        assertEquals("I", romanNumerals.get(1));
    }

    @Test
    public void return_ii_for_two() {
        assertEquals("II", romanNumerals.get(2));
    }

    @Test
    public void return_iii_for_three() {
        assertEquals("III", romanNumerals.get(3));
    }

    @Test
    public void return_iv_for_four() {
        assertEquals("IV", romanNumerals.get(4));
    }

    @Test
    public void return_v_for_five() {
        assertEquals("V", romanNumerals.get(5));
    }

    @Test
    public void return_vi_for_six() {
        assertEquals("VI", romanNumerals.get(6));
    }

    @Test
    public void return_viii_for_eight() {
        assertEquals("VIII", romanNumerals.get(8));
    }

    @Test
    public void return_ix_for_nine() {
        assertEquals("IX", romanNumerals.get(9));
    }

    @Test
    public void return_x_for_ten() {
        assertEquals("X", romanNumerals.get(10));
    }

    @Test
    public void return_lvi_for_sixty_five() {
        assertEquals("LVI", romanNumerals.get(56));
    }

    @Test
    public void return_ccclvi_for_three_hundred_and_fifty_six() {
        assertEquals("CCCLVI", romanNumerals.get(356));
    }

    @Test
    public void return_mmccclvi_for_two_thousand_three_hundred_and_fifty_six() {
        assertEquals("MMCCCLVI", romanNumerals.get(2356));
    }
}
