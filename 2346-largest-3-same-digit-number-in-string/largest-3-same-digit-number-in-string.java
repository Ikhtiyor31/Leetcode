class Solution {
    public String largestGoodInteger(String num) {
        String largest = "";
        int max = 0;
        for (int i = 0; i <= num.length() - 3; i++) {
            String each = num.substring(i, i + 3);
            if (each.charAt(0) == each.charAt(1) && each.charAt(1) == each.charAt(2)) {
                if (max <= Integer.parseInt(each)) {
                    max = Integer.parseInt(each);
                    largest = each;
                }
            }
        }

        return largest;
    }
}