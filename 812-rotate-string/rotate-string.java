class Solution {
    public boolean rotateString(String s, String goal) {
        

        int n = s.length();
        for (int i = 0; i < goal.length(); i++) {
            if ((goal.substring(i) + goal.substring(0, i)).equals(s)) {
                return true;
            }
        }

        return false;
    }
}