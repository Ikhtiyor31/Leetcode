class Solution {
    HashSet<Integer> isTravelNeeded = new HashSet<>();
    int[] memo;
    public int mincostTickets(int[] days, int[] costs, int day) {
        if (day > days[days.length - 1]) {
            return 0;
        }

        if (!isTravelNeeded.contains(day)) {
            return mincostTickets(days, costs, day + 1);
        }
        if (memo[day] != -1) {
            return memo[day];
        }

        return memo[day] = Math.min(Math.min(mincostTickets(days, costs, day + 1) + costs[0], 
                        mincostTickets(days, costs, day + 7) + costs[1]),
                        mincostTickets(days, costs, day + 30) + costs[2]);
    }
    public int mincostTickets(int[] days, int[] costs) {
       // Mark the days on which we need to travel.
        for (int day : days) {
            isTravelNeeded.add(day);
        }

        
        memo = new int[400];
        Arrays.fill(memo, -1);
        return mincostTickets(days, costs, 1);
    }
}

/*
[1, 2, 3,4,5,6,7,8,9,10,30,31]


[1, 4, 6, 7, 8, 20]   [2,7,15]

 2  2  2  2  2  2 = 12
 7 
*/