class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        Map<Integer, Integer> changes = new HashMap<>();
        changes.put(5, 0);
        changes.put(10, 0);
        for (int bill: bills) {
            int change = bill - 5;
            int i = 0;
            while (changes.get(10) > 0 && change >= 10) {
                changes.put(10, changes.get(10) - 1);
                change -= 10;
            }

            while (changes.get(5) > 0 && change >= 5) {
                changes.put(5, changes.get(5) - 1);
                change -= 5;
            }
            changes.put(bill, changes.getOrDefault(bill, 0) + 1);
            if (change != 0) 
                return false;
        }

        return true;
    }
}