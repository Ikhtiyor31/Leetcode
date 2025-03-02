class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();


        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            if (firstList[i][1] >= secondList[j][0] && firstList[i][0] <= secondList[j][1]) {
                list.add(new int[]{Math.max(firstList[i][0], secondList[j][0]), Math.min(firstList[i][1], secondList[j][1])});
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        int[][] answer = new int[list.size()][2];
        int k = 0;
        for (int[] l: list) {
            answer[k++] = l;
        }

        return answer;
    }
}