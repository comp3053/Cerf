package model;

import java.util.*;
import java.lang.*;
import java.sql.*;
import java.io.*;

public class Data {
	private ArrayList<Recipe> recipeList;
	private ArrayList<StorageIngredient> storageIngredientList;
	private ArrayList<Equipment> equipmentList;
	private ArrayList<Note> noteList;
	//private ArrayList<Brewing> brewingList;
	
	
	
	public Data() {
		init();
	}
	
	public static void init(){
		ArrayList<Recipe> A_r = new ArrayList<Recipe>();
		ArrayList<Recipe> A_a = new ArrayList<Recipe>();//
		
		ArrayList<StorageIngredient> A_si = new ArrayList<StorageIngredient>();
		
		ArrayList<Equipment> A_e = new ArrayList<Equipment>();
		
		ArrayList<Note> A_n = new ArrayList<Note>();
		
		//ArrayList<Brewing> A_b = new ArrayList<Brewing>();
  		
		Connection c = null;
		Statement stmt = null;
		try {
			
			
			
			//Connect to the Database : Brewing.db
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:Brewing.db");
			
			stmt = c.createStatement();
			
			
			
			
			
			//-------------------------------------------
			//Select the RecipeName For ArrayList<Recipe>
			ResultSet rs = stmt.executeQuery("SELECT RecipeName FROM Recipe;");
            int recipeNum = 0;
			while(rs.next()){
				
				Recipe r = new Recipe(null,0);
                
				//int RecipeID = rs.getInt("IngredientID");
                r.SetRecipeName(rs.getString("RecipeName"));;
                

                System.out.println("RecipeName = " + rs.getString("RecipeName"));
                System.out.println("RecipeName = " + r.GetRecipeName());
                A_a.add(r);
                //System.out.println("RecipeName = " + A_a.get(0).GetRecipeName());
                recipeNum++;
                //System.out.println(recipeNum);
            }
			rs.close();
			
			
			for (int i = 0;i<recipeNum;i++) {
				
				Recipe r = new Recipe(null,0);
				
				String sql = "SELECT IngredientName,Amount,Unit FROM RecipeIngredient WHERE RecipeID LIKE ?";
				PreparedStatement psmt = c.prepareStatement(sql);
				psmt.setInt(1,i+1);
				System.out.println(sql);
				ResultSet rss = psmt.executeQuery();
	            //Recipe rr = null;
				while(rss.next()){
	                //int RecipeID = rs.getInt("IngredientID");
	                r.SetIngredientAmount(rss.getString("IngredientName"), rss.getDouble("Amount"));
	                r.SetRecipeName(A_a.get(i).GetRecipeName());
	
	                //System.out.println("RecipeID = " + RecipeID);
	                System.out.println("IngredientName = " + rss.getString("IngredientName"));
	                System.out.println("Amount = " + rss.getDouble("Amount"));
	                
	                //System.out.println();
	                A_r.add(r);
					}
				
				rss.close();
			}
			
			for(int j = 0;j<A_r.size();j++) {
				System.out.println(A_r.size() + A_r.get(j).GetRecipeName() + "|" + A_r.get(j).GetIngredientList());
			}
			//----------------------------------------------------------------
			
			
			//----------------------------------------------------------------
			//Select IngredientName,Amount For ArrayList<Ingredient>
			ResultSet rsss = stmt.executeQuery("SELECT IngredientName,Amount FROM StorageIngredient WHERE 1=1;");
            //int recipeNum = 0;
			while(rsss.next()){
				
				StorageIngredient si = new StorageIngredient(null,0);
                
				//int RecipeID = rs.getInt("IngredientID");
                si.SetName(rsss.getString("IngredientName"));
                si.SetAmount(rsss.getDouble("Amount"));
                

                
                System.out.println("IngredientName = " + rsss.getString("IngredientName"));
                System.out.println("IngredientName = " + rsss.getDouble("Amount"));
                
                A_si.add(si);
            }
			rsss.close();
			
			
			for(int k = 0;k<A_si.size();k++) {
				System.out.println(A_si.get(k).GetName() + "|" + A_si.get(k).GetAmount());
			}
			//-----------------------------------------------------------------
			
			
			
			//-----------------------------------------------------------------
			//Select EquipmentName,EquipmentSize For ArrayList<Equipment>
			ResultSet rs4 = stmt.executeQuery("SELECT EquipmentName,EquipmentSize FROM Equipment WHERE 1=1");
			
			while(rs4.next()){
				
				Equipment e = new Equipment(null,0);
                
				//int RecipeID = rs.getInt("IngredientID");
                e.SetName(rs4.getString("EquipmentName"));
                e.SetSize(rs4.getDouble("EquipmentSize"));
                

                
                System.out.println("EquipmentName = " + rs4.getString("EquipmentName"));
                System.out.println("EquipmentSize = " + rs4.getDouble("EquipmentSize"));
                
                A_e.add(e);
            }
			rs4.close();
			
			
			for(int k = 0;k<A_e.size();k++) {
				System.out.println(A_e.get(k).GetName() + "|" + A_e.get(k).GetSize());
			}
			//----------------------------------------------------------------
			
			
			//-----------------------------------------------------------------
			//Select Content For ArrayList<Note>
			ResultSet rs5 = stmt.executeQuery("SELECT Content FROM Note WHERE 1=1");
			
			while(rs5.next()){
				
				Note n = new Note(null);
                
				//int RecipeID = rs.getInt("IngredientID");
                n.SetContent(rs5.getString("Content"));
                

                
                System.out.println("Content = " + rs5.getString("Content"));
                
                A_n.add(n);
            }
			rs5.close();
			
			
			for(int k = 0;k<A_n.size();k++) {
				System.out.println(A_n.get(k).GetContent());
			}
			//----------------------------------------------------------------
			
			
			//----------------------------------------------------------------
			
			
			
			
			
			
			
			
			
			
			//------------------------------
			//close statement and connection
			stmt.close();
            c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
		}
		
		System.out.println("Opened Database successfully!");
	}
	
	public ArrayList<Recipe> GetRecipeList(){
		return this.recipeList;
	}
	
	public void SetRecipeList(ArrayList<Recipe> recipeList) {
		this.recipeList = recipeList;
	}
	
	public ArrayList<StorageIngredient> GetStorageIngredientList(){
		return this.storageIngredientList;
	}
	
	public void SetStorageIngredientList(ArrayList<StorageIngredient> storageIngredientList) {
		this.storageIngredientList = storageIngredientList;
	}
	
	public static void main(String[] args) {
		init();
	}
}