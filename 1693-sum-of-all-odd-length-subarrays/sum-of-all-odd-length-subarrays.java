class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int prefixSum[] = new int[n];
        for(int i = 0; i < n; i++) {
            if (i == 0)
                prefixSum[i] = arr[i];
            else
                prefixSum[i] = prefixSum[i-1] + arr[i];
            System.out.print(prefixSum[i] + " ");
        }
      
        int answer = prefixSum[n-1];
        int odd = 0;
        int index = 0;
        for(int i = 0; i < n; i++) {
            index += 2;
            int k = -1;
            for(int j = index; j < n; j++, k++) {
                if (k == -1) 
                    answer += prefixSum[j];
                else
                    answer += (prefixSum[j] - prefixSum[k]);
            }
           
        }

        return answer;
    }
} 
//  [1,4,2,5,3]
//    [1, 5, 7, 12, 15]
//7,
//11,
//10