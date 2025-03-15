class Solution {
    public int maxPoints(int[][] points) {
        
        int answer = 1;
        for (int[] point: points) {
            int x = point[0];
            int y = point[1];
            Map<Double, Integer> cache = new HashMap<>();
            //System.out.println(x + "," + y);
            for (int[] point2: points) {
                int x1 = point2[0];
                int y1 = point2[1];
                if (x == x1 && y == y1) {
                    continue;
                }
                double slope;
                if (x == x1) {
                    slope = Double.MAX_VALUE; // since value / 0 is to handle division by zero exception
                } else {
                    slope = (double)(y1 - y) / (x1 - x);
                }

                //System.out.println(x1 + "," + y1 + " : " + slope);
                cache.put(slope, cache.getOrDefault(slope, 0) + 1);
                answer = Math.max(answer, cache.get(slope) + 1);
            }
            //System.out.println("here");
        }

        return answer;
    }
}