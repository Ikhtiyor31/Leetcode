class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
        }

        Collections.sort(list);
        
        int length = list.size();
        int middleElement = list.get(length / 2);

        int operation = 0;
        for (int num: list) {

            if (middleElement % x != num % x) {
                return -1;
            }

            operation += Math.abs(middleElement - num) / x; 
        }

        return operation;
    }
}