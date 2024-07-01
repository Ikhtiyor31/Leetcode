class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String num = "";
           for(int j = 0; j < m; j++) {
                num += grid[i][j];
                 if (j != m - 1) num += ",";
           }
           System.out.println(num);
           if (!map.containsKey(num))
             map.put(num, 0);
            
            map.put(num, map.get(num) + 1);
        }
        int answer = 0;
        for(int i = 0; i < m; i++) {
            String num = "";
            for(int j = 0; j < n; j++) {
                 num = num + grid[j][i];
                 if (j != n - 1) num += ",";
            }
            System.out.println(num);
            System.out.println(map.getOrDefault(num, 0));
            if (map.containsKey(num) && map.get(num) > 0) {
                answer += map.get(num);
                //map.put(num, map.get(num) - 1);
            }
        }

        return answer;
    } 
} // 11 1
  // 1 11