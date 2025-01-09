class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        Map<Character, Integer> map = new HashMap<>();
        int answer = 0;
        map = new HashMap<>();
        map.put('c', 0);
        map.put('r', 0);
        map.put('o', 0);
        map.put('a', 0);
        map.put('k', 0);
        int maxCount = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            map.put(croakOfFrogs.charAt(i), map.get(croakOfFrogs.charAt(i)) + 1);
            if (!isStateValid(map)) return -1;
            if (croakOfFrogs.charAt(i) == 'c') {
                answer++;
            } else if (croakOfFrogs.charAt(i) == 'k') {
                answer--;
            }

            maxCount = Math.max(maxCount, answer);

        }

        return answer == 0 ? maxCount : -1;
    }

    public boolean isStateValid(Map<Character, Integer> map) {
         return (map.get('c') >= map.get('r')) &&
                (map.get('r') >= map.get('o')) &&
                (map.get('o') >= map.get('a')) && 
                (map.get('a') >= map.get('k'));
    }
}

/*
"croakcroak"
 1111122222
 12345
      1
*/