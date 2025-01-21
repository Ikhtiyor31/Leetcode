class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Boolean> marbles = new TreeMap<>();
        for (int i = 0; i < moveFrom.length; i++) {
            if (!map.containsKey(moveFrom[i])) {
                map.put(moveFrom[i], new ArrayList<>());
            }
            map.get(moveFrom[i]).add(moveTo[i]);
        }

        for (int num: nums) {
            marbles.put(num, false);
        }

        for (int mfrom: moveFrom) {
            int mto = map.get(mfrom).get(0);
            map.get(mfrom).remove(0);
            marbles.put(mfrom, true);
            marbles.put(mto, false);
        }

        List<Integer> list = new ArrayList<>();
        //System.out.println(marbles);
        for (Map.Entry<Integer, Boolean> entries: marbles.entrySet()) {
            if (!entries.getValue()) {
                list.add(entries.getKey());
            }
        }
        

        return list;
    }
}