class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int indx = 0;
        for (char c: s.toCharArray()) {
            int spaceIndx = indx < spaces.length ? spaces[indx] : -1;
            if (i == spaceIndx) {
                sb.append(" ");
                indx++;
            }
            sb.append(c);
            i++;

        }

        return sb.toString();
    }
}