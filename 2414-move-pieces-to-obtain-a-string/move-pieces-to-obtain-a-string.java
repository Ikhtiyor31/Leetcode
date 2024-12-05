class Solution {
    public boolean canChange(String start, String target) {
        

        int l = 0;
        int r = 0;
        int n = target.length();
        Queue<Pair<Character, Integer>> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (start.charAt(i) != '_')
                q.add(new Pair<>(start.charAt(i), i));
            if (start.charAt(i) == 'L') l++;
            if (target.charAt(i) == 'L') l--;
            if (start.charAt(i) == 'R') r++;
            if (target.charAt(i) == 'R') r--;
        }
        if (r != 0 || l != 0) {
            return false;
        }       

        while (r < n) {
            if (target.charAt(r) == 'L') {
                Pair<Character, Integer> p = q.poll();
                if (p.getKey() != 'L' || p.getValue() < r) {
                    System.out.println(l + " " + r);
                    return false;
                }
            } else if (target.charAt(r) == 'R') {
                Pair<Character, Integer> p = q.poll();
                if (p.getKey() != 'R' || p.getValue() > r) {
                    System.out.println(r);
                    return false;
                }
            }
            r++;
        }

        return true;
    }
}