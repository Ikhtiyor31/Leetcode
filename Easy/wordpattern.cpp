class Solution {
public:
    bool wordPattern(string pattern, string str) {
          unordered_map<char, string> char_str;
          unordered_map<string, char> str_char;
          stringstream take(str);
         string ext;
         
         int i = 0;
         while(take >> ext) {
             if(i == pattern.size())
                 return false;
             if(char_str.count(pattern[i]) != str_char.count(ext)) {
                    return false;
             }
             if(char_str.count(pattern[i])) {
                      if(char_str[pattern[i]] != ext || str_char[ext] != pattern[i]) {
                          return false;
                      }
             
             } else {
                 char_str[pattern[i]] = ext;
                 str_char[ext] = pattern[i];
             }
            i++;
         }
         // check again 
         if(i != pattern.size()) return false;
        return true;
    }
};
