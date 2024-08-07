class Solution {

    private static final String[] LESS_THAN_20 = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
        "Eighteen", "Nineteen"
    };

    private static final String[] TENS = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] THOUSANDS = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String words = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            }

            num /= 1000;
            i++;
        }
        words = Arrays.stream(words.split(" "))
            .filter(str -> !str.isEmpty())
            .map(String::trim).collect(Collectors.joining(" "));
        return words.trim();

    }

    private String helper(int num) {
        if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + LESS_THAN_20[num % 10] + " ";
        }
        return LESS_THAN_20[num / 100] + " Hundred " + TENS[num % 100 / 10] + " " + LESS_THAN_20[num % 100 > 19 ? num % 10 : num % 20] + " ";
    }
}