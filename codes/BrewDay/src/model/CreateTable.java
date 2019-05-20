package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        Connection c;
        Statement stmt;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Brewing.db");
            System.out.println("Opened Brewing Database Successfully");

            //-------------------------------------
            //Table Recipe
            //-------------------------------------
            stmt = c.createStatement();
            String sql = "CREATE TABLE Recipe(" +
                    "RecipeID INT PRIMARY KEY NOT NULL ," +
                    "RecipeName CHAR(50)," +
                    "Quantity   REAL," +
                    "Unit       CHAR(50))";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Recipe (RecipeID,RecipeName,Quantity,Unit)" +
                    "VALUES (1,'Gin',1000,'ml'),(2,'Sherry',1000,'ml'),(3,'Vermouth',1000,'ml');";
            stmt.executeUpdate(sql);

            //-------------------------------------
            //Table Ingredient
            //-------------------------------------

            sql = "CREATE TABLE Ingredient(" +
                    "IngredientID INT PRIMARY KEY NOT NULL ," +
                    "IngredientName CHAR(50))";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Ingredient (IngredientID,IngredientName)" +
                    "VALUES (1,'Water');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Ingredient (IngredientID,IngredientName)" +
                    "VALUES (2,'Suger');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Ingredient (IngredientID,IngredientName)" +
                    "VALUES (3,'Yeast');";
            stmt.executeUpdate(sql);

            //-------------------------------------
            //Table RecipeIngredient
            //-------------------------------------

            sql = "CREATE TABLE RecipeIngredient(" +
                    "RI_ID INT PRIMARY KEY NOT NULL," +
                    "IngredientID INT NOT NULL ," +
                    "IngredientName CHAR(50)," +
                    "Amount REAL ," +
                    "Unit CHAR(50) ," +
                    "RecipeID INT NOT NULL ," +
                    "FOREIGN KEY (IngredientID) REFERENCES Ingredient(IngredientID) " +
                    "FOREIGN KEY (RecipeID) REFERENCES Recipe(RecipeID))";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO RecipeIngredient (RI_ID,IngredientID,IngredientName,Amount,Unit,RecipeID)" +
                    "VALUES (1,1,'Water',1500,'ml',1),(2,1,'Water',1600,'ml',2),(3,1,'Water',1400,'ml',3),(4,2,'Suger',50,'ml',1),(5,2,'Suger',70,'ml',2),(6,3,'Yeast',100,'ml',1),(7,3,'Yeast',80,'ml',2);";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE StorageIngredient(" +
                    "IngredientID INT NOT NULL ," +
                    "IngredientName CHAR(50) ," +
                    "Amount REAL ," +
                    "Unit CHAR(50) ," +
                    "FOREIGN KEY (IngredientID) REFERENCES Ingredient(IngredientID))";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO StorageIngredient (IngredientID,IngredientName,Amount,Unit)" +
                    "VALUES (1,'Water',6000,'ml'),(1,'Suger',4000,'ml'),(1,'Yeast',5000,'ml');";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE Brewing(" +
                    "BrewingID INT PRIMARY KEY NOT NULL ," +
                    "Time DATE ," +
                    "RecipeID INT  NOT NULL ," +
                    "EquipmentID INT  ," +
                    "batchSize REAL ," +
                    "FOREIGN KEY (RecipeID)REFERENCES Recipe(RecipeID) " +
                    "FOREIGN KEY (EquipmentID)REFERENCES Equipment(EquipmentID))";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Brewing (BrewingID,Time,RecipeID,EquipmentID,batchSize)" +
                    "VALUES (1,'Now',1,2,2000),(2,'Now',2,1,500),(3,'Now',3,2,2500);";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE Equipment(" +
                    "EquipmentID INT PRIMARY KEY NOT NULL ," +
                    "EquipmentName CHAR(50) ," +
                    "EquipmentSize REAL )";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Equipment (EquipmentID,EquipmentName,EquipmentSize)" +
                    "VALUES (1,'Pot',500),(2,'Bucket',1000);";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE Note(" +
                    "NoteID INT PRIMARY KEY NOT NULL ," +
                    "Time Date ," +
                    "Title CHAR(50) ," +
                    "Content MESSAGE_TEXT ," +
                    "BrewingID INT ," +
                    "FOREIGN KEY (BrewingID) REFERENCES Brewing(BrewingID))";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Note (NoteID,Time,Title,Content,BrewingID)" +
                    "VALUES (1,'Now','xx','xxx',1),(2,'Now','yy','yyy',2),(3,'Now','zz','zzz',3);";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }

    }
}
