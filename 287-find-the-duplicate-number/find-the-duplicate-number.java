class Solution {
    public int findDuplicate(int[] nums) {
        
        int tortoise = nums[0];
        int hare = nums[0];

        do  {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        int answer = nums[0];
        while (answer != tortoise) {
            tortoise = nums[tortoise];
            answer = nums[answer];
        }

        return tortoise;
    }
}