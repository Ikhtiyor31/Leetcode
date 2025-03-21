class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> availableSupply = new HashSet<>();
        for (String supply: supplies) {
            availableSupply.add(supply);
        }

        Queue<Integer> recipeIndex = new LinkedList<>();
        for (int i = 0; i < recipes.length; i++) {
            recipeIndex.add(i);
        }

        int lastSize = -1;
        List<String> answer = new ArrayList<>();
        while (availableSupply.size() > lastSize) {
            lastSize = availableSupply.size();
            int size = recipeIndex.size();
            while (size-- > 0) {
                int index = recipeIndex.poll();
                boolean canCreate = true;
                for (String ingredient : ingredients.get(index)) {
                    if (!availableSupply.contains(ingredient)) {
                        canCreate = false;
                        break;
                    }
                }
                if (!canCreate) {
                    recipeIndex.add(index);
                } else {
                    availableSupply.add(recipes[index]);
                    answer.add(recipes[index]);
                }
            }

            
        }

        return answer;
    }
}