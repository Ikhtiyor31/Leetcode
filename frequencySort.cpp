class Solution {
       set<pair<int, int>> sp;
public:
    string frequencySort(string s) {
       int n = s.size();
       vector<int> freq(256);
       for(char each_char : s) { // O(256) to count frequence
               freq[(int)each_char]++;
       }     
        
         
        for(int i = 0; i < 256; i++) { // O(256) take only occured frequences
                if(freq[i] != 0) 
              sp.insert({freq[i], i});
        }    
           
          string ret;
            for(pair<int, int> p: sp) { // O(set_size_upto_256 * letter_frequence_size) => maybe O(n)
                    while(p.first--) {
                            ret += (char)p.second;
                    }
            }
            
           reverse(ret.begin(), ret.end()); // O(n) or O(n/2)
            // in total, O(set_size_upto_256 * letter_frequence_size) +  O(n) or O(n/2) ==> O(n)
            // memory usage O(1)
            return ret;
    }
};
