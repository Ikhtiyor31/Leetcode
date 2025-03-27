class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] copy = str.toCharArray();
            Arrays.sort(copy);
            String strCopy = new String(copy);
            if (!map.containsKey(strCopy)) {
                map.put(strCopy, new ArrayList<>());
            }
            map.get(strCopy).add(str);
        }

        for (List<String> list: map.values()) {
            answer.add(list);
        }

        return answer;
    }
}