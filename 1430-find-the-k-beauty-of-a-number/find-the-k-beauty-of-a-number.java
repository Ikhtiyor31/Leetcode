class Solution {
    public int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        int count = 0;
        int result = 0;
        for (int i = 0; i < Math.min(k, str.length()); i++) {
            result = result * 10 + (int) str.charAt(i) - '0';
        }
        System.out.println(result);
        if (result != 0 && num % result == 0) count++;
        for (int i = k; i < str.length(); i++) {
            int prev = ((int) str.charAt(i - k) - '0') * (int) Math.pow(10, k - 1);
            result -= prev;
            result = result * 10 + (int) str.charAt(i) - '0';
            if (result != 0 && num % result == 0) count++;
            System.out.println(result);
        }

        return count;
    }
}

/*
430043



*/