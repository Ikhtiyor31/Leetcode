class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int answer = 0;

        int n = nums1.length;
        int m = nums2.length;

    
        if (m % 2 != 0) {
            for (int num : nums1) {
                answer ^= num;
            }
        }
    
        
        if (n % 2 != 0) {
            for (int num : nums2) {
                answer ^= num;
            }
        }
      
       
        return answer;
    }
}

/*

0: 1 -> 0
1: 1 -> 1
2: 2 -> 0
3: 1 -> 3
5: 1 -> 5
10: 1 -> 10


1: 1 -> 1
2: 1 -> 2
3: 1 -> 3
4: 1 -> 4

*/