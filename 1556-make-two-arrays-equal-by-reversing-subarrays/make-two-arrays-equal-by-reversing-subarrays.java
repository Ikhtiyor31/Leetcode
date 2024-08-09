class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> visit = new HashMap<>();
        for (int num: target) {
            visit.put(num, visit.getOrDefault(num, 0) + 1);
        }
        int c = target.length;
        for (int num: arr) {
            if (visit.containsKey(num) && visit.get(num) > 0) {
                visit.put(num, visit.get(num) - 1);
                c -= 1;
            }
        }

        return c == 0;
    }
}