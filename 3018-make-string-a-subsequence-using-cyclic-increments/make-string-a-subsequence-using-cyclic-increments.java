class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {

        int j = 0;
        int i;
        int found = 0;
        for (i = 0; i < str2.length(); i++) {
            boolean done = false;
            for (; j < str1.length() && !done; j++) {
                //System.out.println((char) ((int) str1.charAt(j) + 1));
                int tt = ((int) str1.charAt(j) - 97);
                //System.out.println(tt + " " + (tt + 1) % 26);
                if (str1.charAt(j) == str2.charAt(i) || (char) (((tt + 1) % 26) + 97)== str2.charAt(i)) {
                    done = true;
                    found++;
                }
            }
        }
        //System.out.println(found);
        return found == str2.length();
    }
}