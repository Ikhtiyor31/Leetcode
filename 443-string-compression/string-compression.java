class Solution {
    public int compress(char[] chars) {
       
        int idx = 0;
        int n = chars.length;
        for (int i = 0; i < n; i++) {
          char currentChar = chars[i];
           int cnt = 1;
          while (i +  1 < n && chars[i+1] == currentChar) {
            cnt++;
            i++;
          }
          
          chars[idx++] = currentChar;
          if (cnt > 1) {
            for (char c: String.valueOf(cnt).toCharArray()) {
                chars[idx++] = c;
            }
          }
        }   
        

       
        return idx;
    }

}