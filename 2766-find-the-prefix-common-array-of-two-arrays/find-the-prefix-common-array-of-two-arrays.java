class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] answer = new int[n];
        int[] freq = new int[n];
        int commonNumber = 0;

        for (int i = 0; i < A.length; i++) {
            int a = A[i]-1, b = B[i]-1;
            if (++freq[a] == 2) commonNumber++;
            if (++freq[b] == 2) commonNumber++;

            answer[i] = commonNumber;
        }

        return answer;
    }
}
// A = [1,3,2,4], B = [3,1,2,4]
/*
 A   1,3 2    
 B   3 1 2
     0 2 3

*/