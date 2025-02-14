class ProductOfNumbers {
    private List<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        if (num == 0) {
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) != 0) {
                    list.set(i, 0);
                } else {
                    break;
                }
            }
        }

        if (list.size()  >= 1 && num != 0) {
            list.add(num * (list.get(list.size() - 1) == 0 ? 1 : list.get(list.size() - 1)));
        } else { 
            list.add(num);
        }
        //System.out.println("here " + list);
    }
    
    public int getProduct(int k) {
        int product = 1;
      
        if (list.get(list.size() - k) == 0) {
            return 0;
        }
     

        return list.get(list.size() - 1) / (list.size() > k ?  list.get(list.size() - k - 1) == 0 ? 1 : list.get(list.size() - k - 1): 1 );
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