class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(Arrays.asList(1));
        for (int row = 1; row < numRows; row++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int col = 1; col < answer.get(row-1).size(); col++) {
                int add = answer.get(row-1).get(col-1) + answer.get(row-1).get(col);
                temp.add(add);
            }
            temp.add(1);
            answer.add(new ArrayList<>(temp));
        }

        return answer;
    }
}