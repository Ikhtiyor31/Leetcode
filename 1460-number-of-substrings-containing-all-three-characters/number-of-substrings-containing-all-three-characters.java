class Solution {

    public int numberOfSubstrings(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int answer = 0;
        int count = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
            
            while (freq.size() == 3) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                if (freq.get(s.charAt(l)) == 0) 
                    freq.remove(s.charAt(l));
                answer += s.length() - i;
                l++;
            }
        }

        return answer;
    }
}