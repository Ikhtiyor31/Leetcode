class StockSpanner {
    private Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        
        int count = 1;
        
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            count += stack.peek()[1];
            stack.pop();
        }
        
        stack.push(new int[]{price, count});

        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
 /*
   I'll put each number in list 
   every time I get new price I iterate over array and check how many 
    less than or equal to the new price 

 */



