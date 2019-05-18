import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Scanner;


public class BrewDay {
    private static Set<Recipe> RecipeList = new HashSet<>();
    private static Map<String, Double> Storage = new TreeMap<>();

    public static void main(String[] arg) {
        System.out.println("Please set the batch num:");
        Scanner scan = new Scanner(System.in);
        double value = (double) 0;
        if (scan.hasNextLine()) {
            String input = scan.nextLine();
            value = Double.parseDouble(input);
        }

        Set<Recipe> recipes = ShoppingList.RecommendRecipe(value, RecipeList, Storage);

        for (Recipe recipe : recipes) {
            System.out.println(recipe.GetRecipeName());
        }
    }
}
