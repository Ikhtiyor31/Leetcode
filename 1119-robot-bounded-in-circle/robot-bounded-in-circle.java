class Solution {
    public boolean isRobotBounded(String instructions) {
        int pos = 0;
        int direction = 0;
        int x = 0, y = 0;
        while (pos < 1000) {
            for (char c: instructions.toCharArray()) {
                if (c == 'G') {
                    if (direction == 0) {
                        y++;
                    } else if (direction == 1) {
                        x++;
                    } else if (direction == 2) {
                        y--;
                    } else {
                        x--;
                    }
                } else if (c == 'R') {
                    direction = (direction + 1) % 4;
                } else {
                    direction = (direction + 3) % 4;
                }
            }
            if (x == 0 && y == 0) {
                return true;
            }
            pos++;
        }

        return false;
        
    }
}

// "GGLLGG"