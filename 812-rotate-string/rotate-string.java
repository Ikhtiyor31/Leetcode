class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        s = s + s;
        for (int i = 0; i < s.length() - goal.length(); i++) {
            if (s.substring(i, i + goal.length()).equals(goal)) {
                return true;
            }
        }

        return false;
    }
}

//"abcde", goal = "cdeab"
// abcdeabcde