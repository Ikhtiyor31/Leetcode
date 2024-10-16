class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        StringBuilder answer = new StringBuilder();
        int n = a + b + c;
        int countA = 0, countB = 0, countC = 0;
        for (int i = 0; i < n; i++) {
            // a has the highest occurance
            if ((a >= b && a >= c && countA != 2) || a > 0 && (countC == 2 || countB == 2)) {
                countA++;
                a--;
                countB = 0;
                countC = 0;
                answer.append("a");
            } else if (b >= a && b >= c && countB != 2 || b > 0 && (countA == 2 || countC == 2)) {
                countB++;
                countC = 0;
                countA = 0;
                b--;
                answer.append("b");
            } else if (c >= a && c >= b && countC != 2 || c > 0 && (countA == 2 || countB == 2)) {
                countC++;
                countA = 0;
                countB = 0;
                c--;
                answer.append("c");
            }
            
        }



        return  answer.reverse().toString();
    }
}