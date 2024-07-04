class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;

        int answer = 0;
        for(int num = 0; num < n; num++) {
            int s = num + 1;
            int e = n - num;
            int current = (s * e);
            int oddSubarrays = (current + 1) / 2;
            answer += (oddSubarrays * arr[num]);
        }

        return answer;
    }
} 
//  [1,4,2,5,3]
//    [1, 5, 7, 12, 15]
//7,
//11,
//10