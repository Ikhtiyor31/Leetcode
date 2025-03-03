class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> beforePivot = new ArrayList<>();
        List<Integer> afterPivot = new ArrayList<>();
        int countPivot = 0;
        for (int num: nums) {
            if (num < pivot) {
                beforePivot.add(num);
            }
            if (num == pivot) countPivot++;
        }

        for (int num: nums) {
            if (num > pivot) {
                afterPivot.add(num);
            }
        }
        for (int i = 1; i <= countPivot; i++) beforePivot.add(pivot);
        beforePivot.addAll(afterPivot);
        int[] answer = beforePivot.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}