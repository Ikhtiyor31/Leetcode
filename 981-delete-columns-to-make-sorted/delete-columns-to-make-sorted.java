class Solution {
    public int minDeletionSize(String[] strs) {
        
        List<char[]> grid = new ArrayList<>();
        for (String str: strs) {
            char[] arr = str.toCharArray();
            grid.add(arr);
        }
        int count = 0;
        for (int i = 0; i < grid.get(0).length; i++) {
            ///System.out.println(Arrays.toString(grid.get(i)));
            for (int j = 1; j < grid.size(); j++) {
                if (grid.get(j-1)[i] > grid.get(j)[i]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}