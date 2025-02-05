class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
 
        int[] notEquals = new int[2];
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                if (diffCount > 2) return false;
                if (diffCount == 1)
                    notEquals[0] = i;
                else 
                    notEquals[1] = i;
            }
        }



        return (s1.charAt(notEquals[0]) == s2.charAt(notEquals[1]) && s1.charAt(notEquals[1]) == s2.charAt(notEquals[0]));
        
    }
}