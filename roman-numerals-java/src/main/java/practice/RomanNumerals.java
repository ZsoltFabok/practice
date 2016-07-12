package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class RomanNumerals {

    public static void main(String... args) {
        RomanNumerals romanNumerals = new RomanNumerals();
        System.out.println(romanNumerals.get(Integer.parseInt(args[0])));
    }

    private class RomanDecimal {
        int value;
        String letterForMaxValue;
        String letterForMiddleValue;
        String letterForMinValue;

        RomanDecimal(int value, String letterForMaxValue, String letterForMiddleValue, String letterForMinValue) {
            this.value = value;
            this.letterForMaxValue = letterForMaxValue;
            this.letterForMiddleValue = letterForMiddleValue;
            this.letterForMinValue = letterForMinValue;
        }
    }

    private List<RomanDecimal> decimals = Arrays.asList(
            new RomanDecimal(1000, "", "", "M"),
            new RomanDecimal(100 , "M", "D", "C"),
            new RomanDecimal(10  , "C", "L", "X"),
            new RomanDecimal(1   , "X", "V", "I"));

    private StringBuilder get(int number, List<RomanDecimal> decimals) {
        StringBuilder result = new StringBuilder();

        // convert the actual decimal to roman
        RomanDecimal currentDecimal = decimals.get(0);
        int decimalValue = 0;
        if (number >= currentDecimal.value) {
            decimalValue = number / currentDecimal.value;
            result.append(convert(decimalValue, currentDecimal));
        }

        // see if the rest of the original number has to be converted
        int numberWithoutDecimalValue = number - decimalValue * currentDecimal.value;
        if (numberWithoutDecimalValue > 0) {
            result.append(get(numberWithoutDecimalValue, decimals.subList(1, decimals.size())));
        }
        return result;
    }

    String get(int number) {
        return get(number, decimals).toString();
    }

    private String convert(int number, RomanDecimal decimal) {
        StringBuilder result = new StringBuilder();

        switch (number) {
            case 4:
                // For example IV, XL (40)
                result.append(decimal.letterForMinValue);
                result.append(decimal.letterForMiddleValue);
                break;
            case 5:
                result.append(decimal.letterForMiddleValue);
                break;
            case 9:
                // For example CX
                result.append(decimal.letterForMinValue);
                result.append(decimal.letterForMaxValue);
                break;
            case 1:
            case 2:
            case 3:
                IntStream.range(0, number).forEach(x -> result.append(decimal.letterForMinValue));
                break;
            case 6:
            case 7:
            case 8:
                result.append(decimal.letterForMiddleValue);
                IntStream.range(0, Math.abs(5-number)).forEach(x -> result.append(decimal.letterForMinValue));
        }
        return result.toString();
    }
}
