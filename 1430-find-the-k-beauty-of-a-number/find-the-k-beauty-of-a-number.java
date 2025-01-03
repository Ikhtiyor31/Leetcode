class Solution {
    public int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        int count = 0;
        for (int i = 0; i <= str.length() - k; i++) {
            String take = str.substring(i, i + k);
            System.out.println(take);
            int sub = Integer.parseInt(take);
            if (sub != 0 && num % sub == 0) count++;
        }

        return count;
    }
}

/*
430043



*/