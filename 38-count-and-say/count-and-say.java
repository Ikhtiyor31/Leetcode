class Solution {
    public String generate(String str) {
        int left = 0;
        StringBuilder answer = new StringBuilder();
        for (int right = 1; right <= str.length(); right++) {
            if (right == str.length() || str.charAt(left) != str.charAt(right)) {
                answer.append(right - left).append(str.charAt(left));
                left = right;
            }
        }
        return answer.toString();
    }
    public String countAndSay(int n) {
        String prev = "1";
        for (int i = 1; i < n; i++) {
            prev = generate(prev);
        
        }

        return prev;
    }
}