package fizzbuzz;

import java.util.List;

/**
 * with java 8 we won't need this class at all, <code>String.join(" ", list)</code> would do the trick.
 */
public class Converter {
    /**
     * 'list_to_string' is an better read than 'listToString'.
     */
    public String list_to_string(List<? extends Object> list) {
        return list.toString().substring(1, list.toString().length() - 1).replaceAll(", ", " ");
    }
}
