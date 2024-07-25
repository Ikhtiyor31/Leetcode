class RecentCounter {
    List<Integer> requests;
    public RecentCounter() {
        requests = new ArrayList<>();
    }
    
    public int ping(int t) {
        
        requests.add(t);
        while(!requests.isEmpty() && requests.get(0) < t - 3000) {
            requests.remove(0);
        }
        

        return requests.size();
    }
}
/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */