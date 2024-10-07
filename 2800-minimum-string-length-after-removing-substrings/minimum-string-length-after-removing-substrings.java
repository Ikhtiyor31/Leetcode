class Solution {
    public int minLength(String s) {
        boolean processed = false;
        while (!processed) {
            int n = s.length();
            if (s.indexOf("AB") != -1) {
                int indx = s.indexOf("AB");
                s = s.substring(0, indx) + s.substring((int)Math.min(indx+2, n), n);
                processed = false;
            } else if (s.indexOf("CD") != -1) {
                int indx = s.indexOf("CD");
                s = s.substring(0, indx) + s.substring((int)Math.min(indx+2, n), n);
                processed = false;
            } else {
                processed = true;
            }
        }

        return s.length();
    }
}