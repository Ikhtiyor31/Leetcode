class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();

        for (char c: s.toCharArray()) {
            sb.append(c);
            int startIndex = sb.length() - part.length();
            int endIndex = startIndex + part.length();
            if (sb.length() >= part.length() && sb.substring(startIndex, endIndex).equals(part)) {
                sb.delete(startIndex, endIndex);
            }
           
        }

      


        return sb.toString();
        
    }
}
/*
daabcba 

*/