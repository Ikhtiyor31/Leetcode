class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] runningLeftMax = new int[n];
        int[] runningRightMax = new int[n];
        for (int i = 0; i < n; i++) {
            runningLeftMax[i] = Math.max(runningLeftMax[i - 1 >= 0 ? i - 1 : 0], height[i]);
            runningRightMax[n-i-1] = Math.max(runningRightMax[n - i == n ? n - i - 1 : n - i], height[n - i - 1]);
        } 
 
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += (Math.min(runningLeftMax[i], runningRightMax[i]) - height[i]);
        }

        return answer;
    }
}

/*
0,1,0,2,1,0,1,3,2,1,2,1
0 1 1 2 2 2 2 3 3 3 3 3
3 3 3 3 3 3 3 3 2 2 2 1
0 0 1 0 1 2 1 0 0 1 0 0




*/