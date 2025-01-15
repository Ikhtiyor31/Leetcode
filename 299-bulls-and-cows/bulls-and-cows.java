class Solution {
    public String getHint(String secret, String guess) {
        Set<Integer> visited1 = new HashSet<>();
        Set<Integer> visited2 = new HashSet<>();
        int bullCount = 0;
        int cowCount = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bullCount++;
                visited1.add(i);
            }
        }
        System.out.println(visited1);
        for (int i = 0; i < secret.length(); i++) {
            if (visited1.contains(i)) continue;
             for (int j = 0; j < guess.length(); j++) {
                if (secret.charAt(i) == guess.charAt(j) && !visited1.contains(j) && !visited2.contains(j)) {
                    cowCount++;
                    visited2.add(j);
                    break;
                }
            }
        }
       




        return bullCount + "A" + cowCount + "B";
    }
}

/*
1807
7810

1 -> 7
0 -> 1
7 -> 0


7 -> 1
1 -> 0
0 -> 7


*/