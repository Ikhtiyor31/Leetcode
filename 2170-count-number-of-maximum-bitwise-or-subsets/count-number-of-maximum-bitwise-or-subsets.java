class Solution {

    public void backtrack(List<List<Integer>> list, List<Integer> tempList, int curr, int[] nums) {
        
        if (!tempList.isEmpty())
            list.add(new ArrayList<>(tempList));

        for (int i = curr; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, i + 1, nums);
            tempList.remove(tempList.size()-1);
        }
    }
    public int countMaxOrSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(result, new ArrayList<>(), 0, nums);
        TreeMap<Integer, Integer> countBits = new TreeMap<>();
        for(List<Integer> list: result) {
            int curr = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                curr |= list.get(i);
            }
            countBits.put(curr, countBits.getOrDefault(curr,0) + 1);
        }


        return countBits.lastEntry().getValue();
    }
}

/*
[3,2,1,5]
'0011'
'0010'
'0001'
'0101'

group subsets with number of bitwise or and bitwise or itself key
*/