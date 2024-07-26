class Triple {
    Integer first;
    Integer second;
    Integer third;
    
    public Triple(Integer first, Integer second, Integer third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public Integer getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }

    public Integer getThird() {
        return third;
    }
}
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Triple> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int copyNum = num;
            int result = 0;
            int placeValue = 1;
            StringBuilder sb = new StringBuilder();
            while(copyNum > 0) {
                int digit = copyNum % 10;
                sb.append(mapping[digit]);
                copyNum /= 10;
            }

          
          
            if (num == 0) {
                result = mapping[result];
            } else {
                result = Integer.parseInt(sb.reverse().toString());
            }

            
            list.add(new Triple(result, num, i));
        }

        list.sort(Comparator
        .comparing(Triple::getFirst)
        .thenComparing(Triple::getThird));
       
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i).getSecond();
        }        
      
        return nums;
    }
}