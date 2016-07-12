package practice;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;


public class TextMungerTest {

    @Test
    public void works_with_a_one_char_long_word() {
        assertEquals("a",TextMunger.munge("a"));
    }

    @Test
    public void works_with_a_two_char_long_word() {
        assertEquals("ab",TextMunger.munge("ab"));
    }

    @Test
    public void works_with_a_three_char_long_word() {
        assertEquals("abc",TextMunger.munge("abc"));
    }

    @Test
    public void works_with_a_four_char_long_word() {
        assertEquals("abcd", sortMiddle(TextMunger.munge("abcd")));
    }

    @Test
    public void works_with_a_word_which_is_followed_by_a_punctuation() {
        String result = TextMunger.munge("abcd!");
        assertEquals("abcd!", sortMiddle(result.substring(0, result.length() - 1)) + "!");
    }

    @Test
    public void works_with_two_words() {
        assertEquals("abc ab", TextMunger.munge("abc ab"));
    }

    @Test
    public void works_with_three_words() {
        assertEquals("abc ab dbe", TextMunger.munge("abc ab dbe"));
    }

    @Test
    public void works_with_a_sentence_that_has_a_number() {
        assertEquals("abc 712 ab", TextMunger.munge("abc 712 ab"));
    }

    @Test
    public void works_with_a_tricky_sentence() {
        assertEquals("abc  712 ab! go.\nwho?", TextMunger.munge("abc  712 ab! go.\nwho?"));
    }

    private String sortMiddle(String str) {
        return  str.charAt(0) +
                sortCharacter(str.substring(1, str.length() - 1)) +
                str.charAt(str.length() - 1);
    }

    private String sortCharacter(String str) {
        return Arrays.stream(str.split("")).sorted().reduce("", (x, y) -> x + y);
    }
}
