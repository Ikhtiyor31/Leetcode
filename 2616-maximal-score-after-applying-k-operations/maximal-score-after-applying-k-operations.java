class Solution {
    private static class CustomComparator implements Comparator<Integer> {

        @Override 
        public int compare(Integer a, Integer b) {
              int value =  a.compareTo(b);
        // elements are sorted in reverse order
            if (value > 0) {
                    return -1;
                }
                else if (value < 0) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
    }
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>( new CustomComparator());
        
        for (int num: nums) {
            pq.add(num);
        }
        Long answer = 0L;
        while (!pq.isEmpty() && k > 0) {
            answer += pq.peek();
            int toReplace = (int) Math.ceil((double) pq.poll() / 3);
            pq.add(toReplace);
            k--;
        }

        return answer;
    }
}