class Solution {
    public int numberOfSubstrings(String s, int k) {
        
        int n = s.length();
        int answer = 0;
        int r = 0;
        int count = 0;
        while (r < n) {
            Map<Character, Integer> freq = new HashMap<>();
            int maxFreq = 0;
            for (int l = r; l < n; l++) {
                freq.put(s.charAt(l), freq.getOrDefault(s.charAt(l), 0) + 1);
                maxFreq = (int) Math.max(freq.get(s.charAt(l)), maxFreq);
                
                if (maxFreq >= k) {
                    answer += n - l;
                    break;
                }
            }
            r++;
        }


        return answer;
    }
}
/*
// "askjasdlkasdfa" "askjasdlkasdfaas"
// askjasdlka 1      askjasdlka
// askjasdlkas 2     askjasdlkas
// askjasdlkasd 3    askjasdlkasd
// askjasdlkasdf 4   askjasdlkasdf
// askjasdlkasdfa 5  askjasdlkasdfa
// skjasdlkas 6      askjasdlkasdfaa
// skjasdlkasd 7     askjasdlkasdfaas
// skjasdlkasdf 8    skjasdlkas
// skjasdlkasdfa 9   skjasdlkasd
// asdlkasdfa 10     skjasdlkasdf
// jasdlkasdfa 11    skjasdlkasdfa
// kjasdlkasdfa 12   skjasdlkasdfaa
                     skjasdlkasdfaas
                     kjasdlkasdfa
                     kjasdlkasdfaa
                     kjasdlkasdfaas
                     jasdlkasdfa
                     jasdlkasdfaa
                     jasdlkasdfaas
                     asdlkasdfa
                     asdlkasdfaa
                     asdlkasdfaas
                     sdlkasdfaa
                     sdlkasdfaas
                     dlkasdfaa
                     dlkasdfaas
                     lkasdfaa
                     lkasdfaas
                     kasdfaa
                     kasdfaas
                     asdfaa
                     asdfaas  */









