class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }

        int answer = 0;
        for (int value: map.values()) {
            if (value > 2) answer += comb(value / 2) * 8;
        }


        return answer;
    }

    public int comb(int n) {
        return n * (n - 1) / 2;
    }
}


