class Solution {
    public String compressedString(String word) {
        
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i-1) == word.charAt(i) && cnt < 9) {
                cnt++;
            } else {
                sb.append(cnt +  "" + word.charAt(i-1));
                cnt = 1;
            }
        }

        sb.append(cnt + "" + word.charAt(word.length()-1));

        return sb.toString();
    }
}