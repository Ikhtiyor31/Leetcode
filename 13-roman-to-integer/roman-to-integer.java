class Solution {
    public int romanToInt(String s) {
        
        Map<Character, Integer> m = new HashMap<>();
        
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int answer = 0;
        char prev = 'c';
        for (char c: s.toCharArray()) {
            if (prev != 'c' && m.get(prev) < m.get(c)) {
                answer -= m.get(prev);
                answer += m.get(c) - m.get(prev);
            } else {
                answer += m.get(c);
            }
            prev = c;
        }
        
        return answer;
    }
}