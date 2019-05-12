import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Scanner; 


public class BrewDay {
	static Set<Recipe> RecipeList = new HashSet<Recipe>();
	static Map<String,Double> Storage = new TreeMap<String, Double>(); 
	
	static StorageIngredient water = new StorageIngredient("water",1000);
	static StorageIngredient suger = new StorageIngredient("suger",500);
	static StorageIngredient yeast = new StorageIngredient("yeast",100);
	
	static RecipeIngredient beer1water = new RecipeIngredient("water",500);
	static RecipeIngredient beer1suger = new RecipeIngredient("suger",300);
	static RecipeIngredient beer1yeast = new RecipeIngredient("yeast",200);
	
	static RecipeIngredient beer2water = new RecipeIngredient("water",500);
	static RecipeIngredient beer2suger = new RecipeIngredient("suger",100);
	static RecipeIngredient beer2yeast = new RecipeIngredient("yeast",100);
	
	static RecipeIngredient beer3water = new RecipeIngredient("water",800);
	static RecipeIngredient beer3suger = new RecipeIngredient("suger",300);
	static RecipeIngredient beer3yeast = new RecipeIngredient("yeast",200);		
	
	static Recipe beer1 = new Recipe("Beer1",1000);
	static Recipe beer2 = new Recipe("Beer2",500);
	static Recipe beer3 = new Recipe("Beer3",800);
	
	
	public static Set<Recipe> RecommendRecipe(double batchSize){
		Set<Recipe> recommendRecipeList = new HashSet<Recipe>();
		
		for (Recipe recipe : RecipeList) {  
			Map<String, Double> convertedMap = recipe.convertValue(batchSize);
			int i = 0;
			for(String name : convertedMap.keySet()) {
				if(convertedMap.get(name)<Storage.get(name))
					i++;
			}
			if(i == convertedMap.size())
				recommendRecipeList.add(recipe);
		}  
		
		
		return recommendRecipeList;
	}
	
	public static void main(String arg[]) {

		beer1.AddIngredient(beer1water);
		beer1.AddIngredient(beer1suger);
		beer1.AddIngredient(beer1yeast);
		beer2.AddIngredient(beer2water);
		beer2.AddIngredient(beer2suger);
		beer2.AddIngredient(beer2yeast);
		beer3.AddIngredient(beer3water);
		beer3.AddIngredient(beer3suger);
		beer3.AddIngredient(beer3yeast);
		
		
		RecipeList.add(beer1);
		RecipeList.add(beer2);
		RecipeList.add(beer3);
		
		Storage.put(water.GetName(),water.GetAmount());
		Storage.put(suger.GetName(),suger.GetAmount());
		Storage.put(yeast.GetName(),yeast.GetAmount());
		
		double value = 0;
		
		System.out.println("Please set the batch num:");
		Scanner scan = new Scanner(System.in);
        if (scan.hasNextLine()) {
            String input = scan.nextLine();
            value = Double.valueOf(input.toString());
        }
		
        //System.out.println("Please set the storage water:");
		
		for(Recipe recipe : RecommendRecipe(value)) {
			System.out.println(recipe.GetRecipeName());
		}
	}
}
