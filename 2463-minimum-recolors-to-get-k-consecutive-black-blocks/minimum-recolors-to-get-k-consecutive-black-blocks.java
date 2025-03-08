class Solution {
    public int minimumRecolors(String blocks, int k) {
        int black = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'B') black++;
        }
        int l = 0;
        int maxBlock = black;
        for (int i = k; i < blocks.length(); i++, l++) {
            if (blocks.charAt(l) == 'B') black -= 1;
            if (blocks.charAt(i) == 'B') black += 1;
            maxBlock = Math.max(black, maxBlock);
        }

        return k - maxBlock;
    }
}