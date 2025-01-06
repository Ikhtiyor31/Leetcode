class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();

        Map<Character, List<Integer>> mapList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!mapList.containsKey(s.charAt(i))) {
                mapList.put(s.charAt(i), new ArrayList<>());
                mapList.get(s.charAt(i)).add(i);
            } else {
                if (mapList.get(s.charAt(i)).size() > 1) {
                    mapList.get(s.charAt(i)).set(1, i);
                } else {
                    mapList.get(s.charAt(i)).add(i);
                }
            }
        }
      
        int count = 0;
        for (List<Integer> list: mapList.values()) {
            if (list.size() > 1) {
                Set<Character> set = new HashSet<>();
                int f = list.get(0);
                int l = list.get(list.size()-1);
                for (int j = l - 1; j > f; j--) {
                    set.add(s.charAt(j));
                }
                count += set.size();
            }
        }
        
        return count;
    }
}
/*
aabca
aabb
36
bbcbaba

bbcbbb


*/