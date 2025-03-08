class Solution {
    public int minimumRecolors(String blocks, int k) {
        int black = 0;
        int l = 0;
        int maxBlock = black;
        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'B') black++;
            if (i >= k && blocks.charAt(i-k) == 'B') black--;
            if (i >= k - 1)
                maxBlock = Math.max(black, maxBlock);
        }

        return k - maxBlock;
    }
}