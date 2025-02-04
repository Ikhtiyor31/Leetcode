class Solution {
    public int findDuplicate(int[] nums) {
        
        int tortoise = nums[0];
        int hare = nums[tortoise];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }

        //System.out.println(tortoise + " " + hare);
        hare = 0;
        while (hare != tortoise) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}