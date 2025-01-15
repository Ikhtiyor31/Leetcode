class Solution {
    public int minimizeXor(int num1, int num2) {
        int x = 0;
        int countNum2 = Integer.bitCount(num2); 
        int countX = 0;    
        
        if (countNum2 == countX) {
            return x;
        }
       
        for (int i = 31; i >= 0; i--) {
            if (countNum2 > countX && (isSet(num1, i) || countNum2 - countX > i)) {
                x = x | (1 << i);   
                countX++; 
            }
          
           
        }

        return x;
    }

    public boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }
}
