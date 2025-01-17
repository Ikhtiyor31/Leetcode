class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int answer = 0;
        for (int x: derived) {
            answer ^= x;
        }

        return answer == 0;

    }
}

/*
  1 1 1 1
  0 1 0 1
  
  1 1 1 1
  0 1 0 1 0
  1 1 1 1 0

  0 ^ 1 = 1
  0 ^ 0 = 0
  0 ^ 1 = 1
  1 ^ 0 = 1
  0 ^ 1 = 1
*/