class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;


        Comparator<Pair<Integer, Integer>> comparator = (p1, p2) -> {
            int cmp = p1.getValue().compareTo(p2.getValue());
            if (cmp != 0) {
                return cmp;
            }
            return p1.getKey().compareTo(p2.getKey());
        };


        PriorityQueue<Pair<Integer, Integer>> pQueue = new PriorityQueue<>(comparator);

        for(int num: arr) {
            
            int bits = 0;
            int bit_num = num;
            while(bit_num > 0) {
                bits += bit_num & 1;
                bit_num >>= 1;
            }

            pQueue.add(new Pair<>(num, bits));
        }
        int i = 0;
     
        while(!pQueue.isEmpty()) {
            arr[i++] = pQueue.peek().getKey();
            pQueue.remove();
        }

        

        return arr;

    }
    
}