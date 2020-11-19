class Solution {
public:
    bool isOneBitCharacter(vector<int>& bits) {
        int n = bits.size();
        bool ok = false;
        for(int i = 0; i < n; i++) {
            
           if( (i + 1 < n) && (bits[i] == 1 && bits[i + 1] == 0) || (bits[i] == 1 && bits[i + 1] == 1) ) {
               //cout << i << ": " << bits[i] << " and " << i + 1 << ":" << bits[i+1] << "\n";
                   i++;
               ok = false;
           } else {
               //cout << i;
               ok = true;
               continue;
           }
        }
        
        return ok;
    }
};
