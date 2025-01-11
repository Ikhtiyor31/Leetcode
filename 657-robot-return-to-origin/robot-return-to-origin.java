class Solution {
    public boolean judgeCircle(String moves) {
        int pos1 = 0, pos2 = 0;
        for (char c: moves.toCharArray()) {
            if (c == 'U') pos1++;
            else if (c == 'D') pos1--;
            else if (c == 'R') pos2++;
            else pos2--;
        }

        return pos1 == 0 && pos2 == 0;
    }
}