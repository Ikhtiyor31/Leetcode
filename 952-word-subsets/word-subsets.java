class Solution {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> answer = new ArrayList<>();
       
        int[] maxFreq = new int[26];
        for (String word2: words2) {
            int[] freq = new int[26];
            for (char c: word2.toCharArray()) {
                freq[c - 'a']++;
            }
            //System.out.println(Arrays.toString(freq));
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }

        }
        //System.out.println(Arrays.toString(maxFreq));
        for (String word1: words1) {
            int[] inFreq = new int[26];
            boolean found = true;
            for (char c: word1.toCharArray()) {
                inFreq[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (inFreq[i] < maxFreq[i]) {
                    found = false;
                    break;
                }
            }

            if (found) {
                answer.add(word1);
            }
            
        }

        return answer;
    }
}