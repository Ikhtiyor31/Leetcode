class StockSpanner {
    private List<Integer> list;
    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        
      
        int count = 1;
        int i = list.size();
        while (i > 0 && list.get(i - 1) <= price) {
            count++;
            i--;
        }
        list.add(price);

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



