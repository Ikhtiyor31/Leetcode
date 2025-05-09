class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> answer = Arrays.stream(strs)
            .collect(Collectors.groupingBy(item -> {
                char[] charArray = item.toCharArray();
                Arrays.sort(charArray);
                return new String(charArray);
            })).values().stream().toList();
        
        return answer;
    }
}