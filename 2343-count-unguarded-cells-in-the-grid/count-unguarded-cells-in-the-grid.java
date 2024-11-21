class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        Set<Pair<Integer, Integer>> seenGuards = new HashSet<>();
        Set<Pair<Integer, Integer>> seenWalls = new HashSet<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        for (int[] guard: guards) {
            seenGuards.add(new Pair<>(guard[0], guard[1]));
        }

        for (int[] wall: walls) {
            seenWalls.add(new Pair<>(wall[0], wall[1]));
            visited.add(new Pair<>(wall[0], wall[1]));
        }
       
        for (int[] guard: guards) {
            int i = guard[0];
            int j = guard[1];
            //System.out.println( "starting " + i + " " + j);
           
            visited.add(new Pair<>(i, j));
            // up
            for (int up = i - 1; up >= 0; up--) {
                //System.out.println("one " + up + " " + j);
                if (seenGuards.contains(new Pair<>(up, j)) || seenWalls.contains(new Pair<>(up, j))) {
                    visited.add(new Pair<>(up, j));
                    break;
                }
                visited.add(new Pair<>(up, j));
            }
            // down
             for (int down = i + 1; down < m; down++) {
                //System.out.println("two " +down + " " + j);
                if (seenGuards.contains(new Pair<>(down, j)) || seenWalls.contains(new Pair<>(down, j))) {
                    visited.add(new Pair<>(down, j));
                    break;
                }
                visited.add(new Pair<>(down, j));
            }
            // left 
            for (int left = j - 1; left >= 0; left--) {
                 //System.out.println("three " +i + " " + left);
                if (seenGuards.contains(new Pair<>(i, left)) || seenWalls.contains(new Pair<>(i, left))) {
                    visited.add(new Pair<>(i, left));
                    break;
                }
                visited.add(new Pair<>(i, left));
            }

            // right 
            for (int right = j + 1; right < n; right++) {
                 //System.out.println("four " + i + " " + right);
                if (seenGuards.contains(new Pair<>(i, right)) || seenWalls.contains(new Pair<>(i, right))) {
                    visited.add(new Pair<>(i, right));
                    break;
                }
                visited.add(new Pair<>(i, right));
            }
        }

    
        
        //System.out.println(visited);
        return (n * m) - visited.size();
    }
}
/*
// 0 2, 0 4, 0 5, 1 5, 3 2, 3 4, 3 5
[5=0, 4=0, 5=1, 3=0, 4=1, 2=0, 3=1, 5=3, 1=0, 2=1, 4=3, 0=0, 1=1, 3=3, 2=2, 0=1, 1=2, 2=3, 1=3, 0=3]
[0=0, 0=1, 0=3, 1=0, 1=1, 1=2, 1=3, 2=0, 2=1, 2=2, 2=3, 3=0, 3=1, 3=3, 4=0, 4=1, 4=3, 5=0, 5=1, 5=3]
*/