class Solution {
    public int nthUglyNumber(int n) {
        
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        Long current = 1L;
        for (int i = 0; i < n; i++) {
            current = set.pollFirst();
            set.add(current * 2);
            set.add(current * 3);
            set.add(current * 5);
        }

        return current.intValue();
    }
}