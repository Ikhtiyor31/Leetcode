class Solution {
    public int minSwaps(String s) {
        int stackSize = 0;
        for (char bracket: s.toCharArray()) {

            if (bracket == '[') {
                stackSize++;
            } else {
                if (stackSize > 0) stackSize--;
            }
        }

        return (stackSize + 1) / 2;
    }
}