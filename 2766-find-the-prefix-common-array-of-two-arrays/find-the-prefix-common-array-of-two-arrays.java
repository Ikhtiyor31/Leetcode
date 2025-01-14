class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] answer = new int[n];
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        int commonNumber = 0;

        for (int i = 0; i < A.length; i++) {
            if (setA.contains(B[i])) {
                commonNumber++;
            } else {
                setB.add(B[i]);
            }

            if (setB.contains(A[i])) {
                commonNumber++;
            } else {
                setA.add(A[i]);
            }

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