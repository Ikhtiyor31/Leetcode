class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>();
        for (String num: nums) {
            set.add(num);
        }
        
        StringBuilder sb = new StringBuilder(nums[0]);
        for (int i = 0; i < n; i++) {
            char prev = sb.charAt(i);
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '1');
            } else {
                sb.setCharAt(i, '0');
            }
            if (!set.contains(sb.toString())) {
                return sb.toString();
            }
            sb.setCharAt(i, prev);
        }

        return "";
    }
}