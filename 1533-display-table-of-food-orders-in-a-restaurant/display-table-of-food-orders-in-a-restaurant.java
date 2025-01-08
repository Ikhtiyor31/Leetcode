class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        int n = orders.size();
        Map<Integer, Map<String, Integer>> displayTable = new TreeMap<>();
        Set<String> foodNames = new HashSet<>();
        for (List<String> order: orders) {
            Map<String, Integer> temp;
            int tableNumber = Integer.parseInt(order.get(1));
            if (displayTable.containsKey(tableNumber)) {
                temp = displayTable.get(tableNumber);
            } else {
                temp = new HashMap<>();
            }
           
            temp.put(order.get(2), temp.getOrDefault(order.get(2), 0) + 1);
            displayTable.put(tableNumber, temp);  
            foodNames.add(order.get(2));

        }
        List<List<String>> answer = new ArrayList<>();
        List<String> list = new ArrayList<String>(foodNames); 
        Collections.sort(list);
        list.add(0, "Table");
        answer.add(list);

        for (Map.Entry<Integer, Map<String, Integer>> mapOrders: displayTable.entrySet()) {
            List<String> temp = new ArrayList<>();
            for (String foodItem: list) {
                if (mapOrders.getValue().containsKey(foodItem)) {
                    temp.add(mapOrders.getValue().get(foodItem) + "");
                } else {
                    if (foodItem.equals("Table")) {
                        temp.add(mapOrders.getKey() + "");
                    } else 
                    temp.add("0");
                }
            }
            answer.add(temp);
        }

        return answer;
    }
}