class Solution {
    public String generate(String str) {
        if (str.length() == 1) {
            return "11";
        }
        String answer = "";
        int l = 0;
        int r = 1;
        while (r < str.length()) {
            if (str.charAt(l) == str.charAt(r)) {
                r++;
            } else {
                answer = answer +  "" + (r - l) + str.charAt(l);
                l = r;
                r++;
            }
        }
        answer += "" + (r - l) + str.charAt(l);

        return answer;

    }
    public String countAndSay(int n) {
        String prev = "1";
        for (int i = 1; i < n; i++) {
            prev = generate(prev);
        }

        return prev;
    }
}