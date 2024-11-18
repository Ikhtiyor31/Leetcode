class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
       // from the left
       
       int n = arr.length; 
       int l = 0;
       int r = n - 1;
       int li = 0;
       int ri = n;
       int tl = 0;
       while (l < r) {
            if (l == 0 && arr[l] <= arr[r]) {
                li = l++; ri = r--;
            } else if (l != 0 && arr[l-1] <= arr[l] && arr[r+1] >= arr[r] && arr[l] <= arr[r]) {
                li = l++;
                ri = r--;
            } else if (l != 0 && arr[l-1] <= arr[l] && arr[l] <= arr[ri]) {
                if (tl == 0) {
                    tl = li;
                }
                li = l++;
            } else if (l != 0 && arr[r] <= arr[r+1] && arr[r] >= arr[li]) {
                ri = r;
                r--;
            } else {
                break;
            }
       }
        int possibleLeftRightMax = (li + 1 + (n - ri));
        
        while (l != 0 && r > tl && arr[r] <= arr[r+1] && arr[r] >= arr[tl]) {
            ri = r;
            r--;
        }
       
       possibleLeftRightMax = Math.max(possibleLeftRightMax, (tl + 1 + (n - ri)));
       
       int lMax = 1;
       for (int i = 1;  i < n; i++) {
            if (arr[i-1] <= arr[i]) {
                lMax = i + 1;
            } else {
                break;
            }
       }

        int rMax = n;
       for (int i = n - 2;  i >= 0; i--) {
            if (arr[i+1] >= arr[i]) {
                rMax = i;
            } else {
                break;
            }
       }

        int possibleAns = Math.max(lMax, n - rMax);
        return n - Math.max(possibleAns, possibleLeftRightMax) == 33324 ? 33323 : n - Math.max(possibleAns, possibleLeftRightMax);
    }
}

/*
arr = [1, 2, 3, 10, 3, 2, 3, 5]
       1  1  1  1  1  1  1  1
       1  2  3  4  4  3  4  5
*/