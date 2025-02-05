class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
 
        int[] notEquals = new int[2];
        Arrays.fill(notEquals, -1);    

        System.out.println(notEquals[0]);

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (notEquals[0] == -1)
                    notEquals[0] = i;
                else 
                    notEquals[1] = i;
            }
        }

        if (notEquals[0] == -1 ||  notEquals[1] == -1) {
            return notEquals[0] == notEquals[1];
        }
        
        StringBuilder sb1 = new StringBuilder(s1);
        char take = sb1.charAt(notEquals[0]);
        sb1.setCharAt(notEquals[0], sb1.charAt(notEquals[1]));
        sb1.setCharAt(notEquals[1], take);

        return sb1.toString().equals(s2);
        
    }
}