class Solution {
    public int maximumWealth(int[][] accounts) {
        
        return Arrays.stream(accounts)
            .mapToInt(x -> Arrays.stream(x).sum())
            .max()
            .orElse(0);
    }
}