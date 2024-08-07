class Solution {

    public void dfs(List<List<Integer>> rooms, int node, Set<Integer> visit) {
        if (visit.contains(node)) {
            return;
        }
        visit.add(node);
        for (int key: rooms.get(node)) {
            dfs(rooms, key, visit);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(); 
        
        Set<Integer> visit = new HashSet<>();
        dfs(rooms, 0, visit);
        System.out.println(visit.size());
        return visit.size() == n;
    }
}