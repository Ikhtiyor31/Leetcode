class Solution {
    public char generateNextCharacter(char c) {
        int ascii = (int) c;
        if (ascii == 122) {
            return (char) (ascii + 1);
        }
        int next = ascii + 1;
        return (char) (next);
    }
    public char kthCharacter(int k) {
        String word = "a";
        
        for (int i = 0; i < k - 1; i++) {
            StringBuilder sb = new StringBuilder(word);
            for (char c: word.toCharArray()) {
                char next = generateNextCharacter(c);
                sb.append(next);
            }
            
            word = sb.toString();
            if (word.length() >= k) break;
        }
        return word.charAt(k - 1);
    }
}