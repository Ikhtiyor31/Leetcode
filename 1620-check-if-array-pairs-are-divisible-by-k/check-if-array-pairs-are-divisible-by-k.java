class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            int remainder = ((num % k) + k) % k;
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        for (int num: arr) {
            int remainder = ((num % k) + k) % k;
            if (remainder == 0) {
                if (map.get(remainder) % 2 == 1) return false;
            } 

              else if (
                !Objects.equals(
                    map.get(remainder),
                    map.get(k - remainder)
                )
            ) return false;

        }

        return true;
    }
}