class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c: word.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }


        List<Character> characters = new ArrayList<>(frequencyMap.keySet());
        characters.sort((a, b) -> frequencyMap.get(b).compareTo(frequencyMap.get(a)));
        
        int count = 0;
        int pushes = 1;
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c: characters) {
            count++;
            if (count != 1 && (count - 1) % 8 == 0) {
                pushes++;
            }
            map.put(c, frequencyMap.get(c) * pushes);
        }

        for (int entry: map.values()) {
            answer += entry;
        }


        return answer;
    }
}