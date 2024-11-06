class Solution {
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public boolean isSameSetbits(int a, int b) {
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < 32; i++) {
            c1 += (a >> i) & 1;
            c2 += (b >> i) & 1;
        }
     
        return c1 == c2;
    }
    public boolean canSortArray(int[] nums) {
        
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i-1]) {
               break;
            }
            if (i == n - 1) {
                return true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j+1] && isSameSetbits(nums[j], nums[j + 1])) {
                    //System.out.println(nums[j] + " " + nums[j+1]);
                    swap(nums, j, j+1);
                }
            }
        }
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i-1]) {
                return false;
            }
        }

        return true;
    }
}

/*
[8, 4, 2, 30, 15]





*/