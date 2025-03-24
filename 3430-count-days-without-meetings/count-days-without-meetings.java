class Solution {
    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        //System.out.println(Arrays.deepToString(meetings));
        List<Integer> list = new ArrayList<>();
        list.add(meetings[0][0]);
        list.add(meetings[0][1]);
        int countDays = 0;
        for (int i = 1; i < n; i++) {
            if (meetings[i][1] > list.get(list.size() - 1)) {
                list.add(Math.max(list.get(list.size() - 1), meetings[i][0]));
                list.add(meetings[i][1]);
            }
        }
        //System.out.println(list);
        for (int i = 2; i < list.size(); i += 2) {
            if (list.get(i) - list.get(i-1) - 1 > 0) {
                System.out.println(list.get(i) + " " + list.get(i-1));
                countDays += list.get(i) - list.get(i-1) - 1;
            }
        }
        if (list.get(0) - 1 > 0) {
            countDays += list.get(0) - 1;
        }

        if (days - list.get(list.size() - 1) > 0) {
            countDays += days - list.get(list.size()-1);
        }

        return countDays;
    }
}