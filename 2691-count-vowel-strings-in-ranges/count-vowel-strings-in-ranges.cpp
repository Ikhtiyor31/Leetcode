class Solution {
public:
    bool isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        int n = words.size();
        vector<int> prefix_sum = vector<int>(n);
        int sum = 0;
        for(int i = 0; i < n; i++) {
            string word = words[i];
            //cout << isVowel(word[0]) << " " << isVowel(word[word.size() - 1]) << "\n";
            if (isVowel(word[0]) && isVowel(word[word.size() - 1])) {
                sum++;
                prefix_sum[i] = sum;
                //cout << sum << "\n";
            } else {
                prefix_sum[i] = sum;
            }
            
        }
        vector<int> answer;
        for (vector<int> query: queries) {
            int sum = prefix_sum[query[1]] - (query[0] == 0 ? 0 : prefix_sum[query[0] - 1]);
            answer.push_back(sum);
        }

        return answer;
    }
};
/*
  1           2    3    4
"aba","bcb","ece","aa","e"

*/