class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String detail: details) {
            String substr = detail.substring(11, 13);
            int age = Integer.parseInt(substr);
            if (age > 60) {
                count += 1;
            }
        }

        return count;
    }
}