class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] sortedNums = Arrays.copyOf(nums, n);
        Arrays.sort(sortedNums);
        int group = 0;
        HashMap<Integer, Integer> numGroups = new HashMap<>();
        Map<Integer, ArrayList<Integer>> groupToList = new HashMap<>();
        
        numGroups.put(sortedNums[0], group);
        groupToList.put(group, new ArrayList<>(Arrays.asList(sortedNums[0])));
        for (int i = 1; i < n; i++) {
            if (Math.abs(sortedNums[i-1]-sortedNums[i]) <= limit) {
                numGroups.put(sortedNums[i], group);
            } else {
                group++;
                numGroups.put(sortedNums[i], group);
            }

            if (!groupToList.containsKey(group)) {
                groupToList.put(group, new ArrayList<>());
            }

            groupToList.get(group).add(sortedNums[i]);
        }
       
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int g = numGroups.get(num);
            nums[i] = groupToList.get(g).get(0);
            groupToList.get(g).remove(0);
        }

        return nums;
    }
}