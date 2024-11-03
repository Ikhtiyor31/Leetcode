class Solution {
    public boolean rotateString(String s, String goal) {

        if (goal.length() != s.length()) {
            return false;
        }
        String concat = s + s;


        return concat.contains(goal);
    }
}