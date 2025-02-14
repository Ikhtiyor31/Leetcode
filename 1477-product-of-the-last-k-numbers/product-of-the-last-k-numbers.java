class ProductOfNumbers {
    private List<Integer> list;
    int lastIndex;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        lastIndex = -1;
    }
    
    public void add(int num) {
        if (num == 0) {
            list.clear();
            lastIndex = list.size();
        } else {
            int last = list.isEmpty() ? 1 : list.get(list.size() - 1);
            list.add(num * last);
        }
    }
    
    public int getProduct(int k) {
        if (k > list.size() || lastIndex > list.size() - k) return 0;
        
        return list.get(list.size() - 1) / (list.size() ==  k ? 1 : list.get(list.size() - k - 1));
    }
}

/**
* 3, 0, 0
*
*/
/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */