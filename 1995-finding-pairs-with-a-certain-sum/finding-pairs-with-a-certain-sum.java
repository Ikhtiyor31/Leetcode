class FindSumPairs {
    private Map<Integer, Integer> map;
    private Map<Integer, Integer> indexMap;
    private int[] nums1;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.map = new HashMap<>();
        this.indexMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
            indexMap.put(i, nums2[i]);
        }
    }
    
    public void add(int index, int val) {
        int value = indexMap.get(index);
        map.put(value, map.get(value) - 1);
        map.put(value + val, map.getOrDefault(value + val, 0) + 1);
        indexMap.put(index, value + val);
    }
    
    public int count(int tot) {
        int count = 0;
        for (int num: nums1) {
            if (map.containsKey(tot - num)) {
                count += map.get(tot - num);
            }
        }

        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */