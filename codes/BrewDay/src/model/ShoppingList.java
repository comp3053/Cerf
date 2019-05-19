package model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ShoppingList {
    static Set<Recipe> RecommendRecipe(double batchSize, Set<Recipe> RecipeList, Map<String, Double> Storage) {
        Set<Recipe> recommendRecipeList = new HashSet<>();

//        for (Recipe recipe : RecipeList) {
////            Map<String, Double> convertedMap = recipe.convertValue(batchSize);
//            int i = 0;
//            for (String name : convertedMap.keySet()) {
//                if (convertedMap.get(name) < Storage.get(name))
//                    i++;
//            }
//            if (i == convertedMap.size())
//                recommendRecipeList.add(recipe);
//        }

        return recommendRecipeList;
    }
}
