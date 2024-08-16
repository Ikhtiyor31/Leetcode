class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int answer = 0;
        int n = arrays.size();
        int firstMin = arrays.get(0).get(0);
        int firstMax = arrays.get(0).get(arrays.get(0).size()-1);
        int firstMinIndex = 0;
        int firstMaxIndex = 0;
        for (int i = 1; i < n; i++) {
            int min1 = arrays.get(i).get(0);
            int max1 = arrays.get(i).get(arrays.get(i).size() - 1);
            answer = Math.max(answer, Math.abs(firstMax - min1));
            answer = Math.max(answer, Math.abs(firstMin - max1));
            firstMin = Math.min(firstMin, min1);
            firstMax = Math.max(firstMax, max1);
        }

        return answer;
    }
}