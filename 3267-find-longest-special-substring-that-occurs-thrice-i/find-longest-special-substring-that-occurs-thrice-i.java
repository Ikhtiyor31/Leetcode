class Solution {
    public int maximumLength(String s) {
        Map<Character, List<Integer>> mapList = new HashMap<>();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                count++;
            }else {
                mapList.computeIfAbsent(s.charAt(i - 1), k -> new ArrayList<>()).add(count);
                count = 1;
            }
        }
        mapList.computeIfAbsent(s.charAt(s.length() - 1), k -> new ArrayList<>()).add(count);
        int maxLength = -1;
        for (char c = 'a'; c <= 'z'; c++) {
            if (mapList.containsKey(c)) {
                List<Integer> list = mapList.get(c);
                //System.out.println(c + ": " + list);
                int maxOne = 0, maxTwo = 0, maxThree = 0;
                for (int freq: list) {
                    if (freq >= 3) {
                        maxLength = Math.max(maxLength, freq - 2);
                    }
                    maxThree = Math.max(maxThree, Math.min(freq, maxTwo));
                    maxTwo = Math.max(maxTwo, Math.min(freq, maxOne));
                    maxOne = Math.max(maxOne, freq);
                }
                //System.out.println(list.size() + " " + maxOne + " " + maxTwo + " " + maxThree);
                if (list.size() > 2) {
                    maxLength = Math.max(maxLength, Math.min(maxThree, Math.min(maxOne, maxTwo)));
                }

                if (list.size() >= 2 && maxOne > 1 || maxTwo > 1 || maxThree > 1) {
                    maxLength = Math.max(maxLength, maxOne == maxTwo ? maxOne - 1 : Math.min(maxOne, maxTwo));
                }
            }
        }

        return maxLength;
        
    }
}
