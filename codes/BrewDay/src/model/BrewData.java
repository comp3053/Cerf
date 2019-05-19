package model;

import java.sql.*;
import java.util.ArrayList;

public class BrewData {
    private static ArrayList<Recipe> recipeList;
    public static ArrayList<StorageIngredient> storageIngredientList;
    private static ArrayList<Note> noteList;
    private static ArrayList<Equipment> equipmentList;

    public static void init() {
        recipeList = new ArrayList<>();
        storageIngredientList = new ArrayList<>();
        equipmentList = new ArrayList<>();

        /*
        Recipe beer = new Recipe("Beer", 1000);
        beer.AddIngredient(new RecipeIngredient("Water", 500, "ml"));
        recipeList.add(beer);

        storageIngredientList.add(new StorageIngredient("Water", 5000, "ml"));
        storageIngredientList.add(new StorageIngredient("Suger", 5000, "ml"));
        storageIngredientList.add(new StorageIngredient("Yeast", 5000, "ml"));

        equipmentList.add(new Equipment("Brewer One", 1000));
        */

        Connection c;
        Statement stmt;
        try {
            //Connect to the Database : Brewing.db
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Brewing.db");

            stmt = c.createStatement();

            //Select the RecipeName For ArrayList<Recipe>
            ResultSet rs = stmt.executeQuery("SELECT RecipeName FROM Recipe;");
            int recipeNum = 0;
            while (rs.next()) {
                String recipeName = rs.getString("RecipeName");
                String recipeSize = rs.getString("Quantity");
                Recipe recipe = new Recipe(recipeName, Double.valueOf(recipeSize));
                recipeList.add(recipe);
                recipeNum++;
            }
            rs.close();

            for (int i = 0; i < recipeNum; i++) {
                Recipe r = new Recipe(null, 0);
                String sql = "SELECT IngredientName,Amount,Unit FROM RecipeIngredient WHERE RecipeID LIKE ?";
                PreparedStatement psmt = c.prepareStatement(sql);
                psmt.setInt(1, i + 1);
                System.out.println(sql);
                ResultSet rss = psmt.executeQuery();
                while (rss.next()) {
                    r.setIngredientAmount(rss.getString("IngredientName"), rss.getDouble("Amount"), rss.getString("Unit"));
                    r.setRecipeName(recipeList.get(i).getRecipeName());

                    System.out.println("IngredientName = " + rss.getString("IngredientName"));
                    System.out.println("Amount = " + rss.getDouble("Amount"));

                    //System.out.println();
                    recipeList.add(r);
                }
                rss.close();
            }

            //Select IngredientName,Amount For ArrayList<Ingredient>
            ResultSet rsss = stmt.executeQuery("SELECT IngredientName,Amount,Unit FROM StorageIngredient WHERE 1=1;");
            //int recipeNum = 0;
            while (rsss.next()) {
                StorageIngredient si = new StorageIngredient(null, 0, null);

                si.setName(rsss.getString("IngredientName"));
                si.setAmount(rsss.getDouble("Amount"));

                storageIngredientList.add(si);
            }
            rsss.close();


            for (StorageIngredient storageIngredient : storageIngredientList) {
                System.out.println(storageIngredient.getName() + "|" + storageIngredient.getAmount());
            }

            //Select EquipmentName,EquipmentSize For ArrayList<Equipment>
            ResultSet rs4 = stmt.executeQuery("SELECT EquipmentName,EquipmentSize FROM Equipment WHERE 1=1");

            while (rs4.next()) {

                Equipment e = new Equipment(null, 0);

                //int RecipeID = rs.getInt("IngredientID");
                e.SetName(rs4.getString("EquipmentName"));
                e.SetSize(rs4.getDouble("EquipmentSize"));


                System.out.println("EquipmentName = " + rs4.getString("EquipmentName"));
                System.out.println("EquipmentSize = " + rs4.getDouble("EquipmentSize"));

                equipmentList.add(e);
            }
            rs4.close();


            for (Equipment equipment : equipmentList) {
                System.out.println(equipment.GetName() + "|" + equipment.GetSize());
            }

            //Select Content For ArrayList<Note>
            ResultSet rs5 = stmt.executeQuery("SELECT Content FROM Note WHERE 1=1");

            while (rs5.next()) {
                Note n = new Note(null, null, null);

                //int RecipeID = rs.getInt("IngredientID");
                n.setContent(rs5.getString("Content"));


                System.out.println("Content = " + rs5.getString("Content"));

                noteList.add(n);
            }
            rs5.close();


            for (Note note : noteList) {
                System.out.println(note.getContent());
            }

            //close statement and connection
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
    }

    public static ArrayList<Recipe> getRecipeList() {
        return BrewData.recipeList;
    }

    public static void setRecipeList(ArrayList<Recipe> recipeList) {
        BrewData.recipeList = recipeList;
    }

    public static ArrayList<StorageIngredient> getStorageIngredientList() {
        return BrewData.storageIngredientList;
    }

    public static void setStorageIngredientList(ArrayList<StorageIngredient> storageIngredientList) {
        BrewData.storageIngredientList = storageIngredientList;
    }

    public static ArrayList<Note> getNoteList() {
        return BrewData.noteList;
    }

    public static void setNoteList(ArrayList<Note> noteList) {
        BrewData.noteList = noteList;
    }

    public static ArrayList<Equipment> getEquipmentList() {
        return BrewData.equipmentList;
    }

    public static void setEquipmentList(ArrayList<Equipment> equipmentList) {
        BrewData.equipmentList = equipmentList;
    }
}