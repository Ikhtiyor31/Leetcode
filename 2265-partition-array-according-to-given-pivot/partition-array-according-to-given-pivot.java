class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] answer = new int[nums.length];
        int countPivot = 0;
        int index = 0;
        for (int num: nums) {
            if (num < pivot) {
                answer[index++] = num;
            }
            if (num == pivot) countPivot++;
        }

        for (int i = 1; i <= countPivot; i++){
            answer[index++] = pivot;
        }

        for (int num: nums) {
            if (num > pivot) {
                answer[index++] = num;
            }
        }
        
        return answer;
    }
}