class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Arrays.stream(piles).max().getAsInt();

        int low = 1; 
        int high = max;
        int answer = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println(mid);
            long spentHour = 0;
            for (int pile: piles) {
                int eat = (int)Math.ceil((double)pile / mid);
                spentHour += eat;
            }
            
            if (h >= spentHour) {
                high = mid - 1;
                answer = mid;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }
}


// 88, h = 5
/*
k = 30
 [30,11,23,4,20]
  0,  0, 0 0, 0

[30,11,23,4,20] h = 6
 7, 0, 0, 0, 0. */