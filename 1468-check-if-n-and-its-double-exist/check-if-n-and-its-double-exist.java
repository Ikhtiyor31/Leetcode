class Solution {
    public boolean checkIfExist(int[] arr) {
        
        Set<Integer> set = new HashSet<>();
        for (int num: arr) {
            if (set.contains(num * 2) || (set.contains(num / 2) && num % 2 == 0)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}