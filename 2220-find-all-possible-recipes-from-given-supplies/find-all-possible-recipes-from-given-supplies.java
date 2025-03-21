class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        // store available supplies 
        Set<String> availableSupplies = new HashSet<>();
        // Map recipe to its index 
        Map<String, Integer> indegree = new HashMap<>();
        // Map ingredient to recipes that need it
        Map<String, List<String>> dependencyGraph = new HashMap<>();
        // Initialize available supplies
        for (String supply: supplies) {
            availableSupplies.add(supply);
        }


        for (int i = 0; i < n; i++) {
            indegree.put(recipes[i], 0);
            for (String ingredient: ingredients.get(i)) {
                if (!availableSupplies.contains(ingredient)) {
                    dependencyGraph.putIfAbsent(ingredient, new ArrayList<String>());
                    dependencyGraph.get(ingredient).add(recipes[i]);
                    indegree.put(recipes[i], indegree.get(recipes[i]) + 1);
                }
            }
        }

        Queue<String> queue = new LinkedList<>();
        for (Map.Entry<String, Integer> entries: indegree.entrySet()) {
            System.out.println(entries);
            if (entries.getValue() == 0) {
                queue.add(entries.getKey());
            }
        }

        List<String> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            String current = queue.poll();
            answer.add(current);
            if (!dependencyGraph.containsKey(current)) continue;

            for (String children: dependencyGraph.get(current)) {
                indegree.put(children, indegree.getOrDefault(children, 0) - 1);
                if (indegree.get(children) == 0) {
                    queue.add(children);
                }
            }
        }

        return answer;
    }
}