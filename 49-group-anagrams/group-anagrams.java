class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedResult= Arrays.stream(strs)
        .collect(Collectors.groupingBy(str -> getSortedResult(str.chars())));
        List<List<String>> answer = new ArrayList<>();
        for (List<String> result: sortedResult.values()) {
            answer.add(result);
        }

        return answer;
    }

    String getSortedResult(IntStream str) {
        return str.mapToObj(c -> String.valueOf((char) c))
            .sorted()
            .collect(Collectors.joining());
    }
}