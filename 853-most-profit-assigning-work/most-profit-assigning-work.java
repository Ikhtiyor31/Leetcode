class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        Arrays.sort(worker);
        int maxProfit = 0;
        int n = profit.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        int maxProfitSofar = 0;
        for (int i = 0; i < n; i++) {
            maxProfitSofar = Math.max(maxProfitSofar, jobs[i][1]);
            jobs[i][1] = maxProfitSofar;
        }


        int i = 0;
        int currentMax = 0;
        for (int j : worker) {
           while (i < n && jobs[i][0] <= j) {
                currentMax = Math.max(currentMax, jobs[i][1]);
                i++;
           }
    
           maxProfit += currentMax;
        }


        return maxProfit;
    }
}

/*

 [2, 4, 6, 8, 10]
 [10,20,30,40,50]
 [4, 5, 6, 7]

[3, 2, 1, 4, 6, 5]
[60,50,30,80,50,56]
80 + 80 + 56 + 
[4,4,5,7]
*/