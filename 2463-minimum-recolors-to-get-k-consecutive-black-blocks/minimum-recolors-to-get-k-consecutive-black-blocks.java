class Solution {
    public int minimumRecolors(String blocks, int k) {
        int black = 0;
        int l = 0;
        int maxBlock = black;
        for (int i = 0; i < blocks.length(); i++) {
            if (i < k) {
                if (blocks.charAt(i) == 'B') black++;
                maxBlock = Math.max(black, maxBlock);
                continue;
            }
            if (blocks.charAt(l++) == 'B') black -= 1;
            if (blocks.charAt(i) == 'B') black += 1;
            maxBlock = Math.max(black, maxBlock);
        }

        return k - maxBlock;
    }
}