class Solution {
    static class Pair<K, V> {
        K first;
        V second;
        public Pair(K first, V second){
            this.first = first;
            this.second = second;
        }
    }
    public int maxWidthRamp(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        int[][] soFarMaxNums = new int[n][2];
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || soFarMaxNums[i+1][0] < nums[i]) {
                soFarMaxNums[i][0] = nums[i]; // value
                soFarMaxNums[i][1] = i;
            } else {
                soFarMaxNums[i][0] = soFarMaxNums[i+1][0];
                soFarMaxNums[i][1] = soFarMaxNums[i+1][1]; 
            }
        }
        int left = 0;
        int right = 0;
        while (right < n) {
            while (left < right && nums[left] > soFarMaxNums[right][0]) {
                left++;
            }
            max = Math.max(max, right - left);
            right++;
        }
       
      
        

        return max;
    }
}

// [6,0,8,2,1,5]
//          8:2 8:2 8:2 5:5 5:5 5:5

