class Solution {
public:
    string addStrings(string num1, string num2) {
           string ret;
           int carry = 0;
            if(num1.empty() && num2.empty()) {
                    return "0";
            }
            if(num1.empty() && !num2.empty()) {
                    return num2;
            }
            if(!num1.empty() && num2.empty()) {
                    return num1;
            }
           int n1 = num1.size() - 1;
           int n2 = num2.size() - 1;
           
           int i = 0; int j = 0;
            while(i <= n1 || j <= n2) {
               
                int first_int = i <= n1  ? (int)(num1[n1-i] - '0') : 0;
                int second_int = j <= n2  ? (int)(num2[n2-j] - '0') : 0;
                    
                int add = first_int + second_int + carry;
                 int actual_num = add % 10;
                    
                 ret.push_back('0' + actual_num);
                 carry = add  / 10;    
                  
                   i++;
                   j++;
            }
          
            if(carry == 1) {
                    ret.push_back('1');
            }
            reverse(ret.begin(), ret.end());
            
            return ret;
    }
};