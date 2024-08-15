class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int fiveDollars = 0;
        int tenDollars = 0;
        for (int bill: bills) {
            if (bill == 5) {
                fiveDollars++;
            } else if (bill == 10) {
                if (fiveDollars > 0) {
                    fiveDollars--;
                    tenDollars++;
                } else {
                    return false;
                }
            } else {
                if (tenDollars > 0 && fiveDollars > 0) {
                    tenDollars--;
                    fiveDollars--;
                } else if (fiveDollars >= 3) {
                    fiveDollars -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}