class Solution {
    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        List<Integer> frequencies = new ArrayList<>(freqMap.values());
        Collections.sort(frequencies);
        
        int minDeletions = Integer.MAX_VALUE;
        
        for (int i = 0; i < frequencies.size(); i++) {
            int target = frequencies.get(i);
            int totalDeletions = 0;
            for (int f : frequencies) {
                if (f < target) {
                    totalDeletions += f;
                } else if (f > target + k) {
                    totalDeletions += f - (target + k);
                }
            }
            minDeletions = Math.min(minDeletions, totalDeletions);
        }
        
        return minDeletions;    }
}