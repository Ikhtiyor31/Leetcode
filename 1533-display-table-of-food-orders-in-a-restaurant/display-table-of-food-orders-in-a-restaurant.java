class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        int n = orders.size();
        Map<Integer, Map<String, Integer>> tableData = new TreeMap<>();
        Set<String> foodNames = new TreeSet<>();
        for (List<String> order: orders) {
            int tableNumber = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);

            tableData.computeIfAbsent(tableNumber, k -> new HashMap<>())
            .put(foodItem, tableData.get(tableNumber).getOrDefault(foodItem, 0) + 1);

            foodNames.add(order.get(2));

        }
        List<String> header = new ArrayList<String>(foodNames); 
        header.add(0, "Table");

        List<List<String>> answer = new ArrayList<>();
        answer.add(header);

        for (Map.Entry<Integer, Map<String, Integer>> entry : tableData.entrySet()) {
            List<String> temp = new ArrayList<>();
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(entry.getKey()));  
            for (String foodItem : header.subList(1, header.size())) {
                row.add(String.valueOf(entry.getValue().getOrDefault(foodItem, 0)));
            }
            answer.add(row);
        }

        return answer;
    }
}