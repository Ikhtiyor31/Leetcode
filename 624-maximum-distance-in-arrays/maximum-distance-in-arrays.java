class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int answer = 0;
        int n = arrays.size();
        int firstMin = arrays.get(0).get(0);
        int firstMax = arrays.get(0).get(arrays.get(0).size()-1);
        int firstMinIndex = 0;
        int firstMaxIndex = 0;
        for (int i = 0; i < n; i++) {
            int min1 = arrays.get(i).get(0);
            int max1 = arrays.get(i).get(arrays.get(i).size() - 1);
            if (firstMin > min1) {
                firstMin = min1;
                firstMinIndex = i;
            }

            if (firstMax < max1) {
                firstMax = max1;
                firstMaxIndex = i;
            }
        }
        
        for (int i = 0; i < n; i++) {
            int min1 = arrays.get(i).get(0);
            int max1 = arrays.get(i).get(arrays.get(i).size() - 1);
            if (firstMaxIndex != i) {
                answer = Math.max(answer, Math.abs(firstMax - min1));
            }

            if (firstMinIndex != i) {
                answer = Math.max(answer, Math.abs(firstMin - max1));
            }
        }
        
        return answer;
    }
}