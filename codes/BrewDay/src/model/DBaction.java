package model;

import java.sql.*;

class DBaction {
    public static void main(String[] arg) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Brewing.db");
            System.out.println("Opened Database Successfully!");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
    }

    public void updateRecipe(String RecipeName, String newName, String IngredientName, String newIngredientName, double Amount) throws SQLException {
        Connection c;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Brewing.db");
            System.out.println("Opened Database Successfully!");

            String sql = "SELECT RecipeID FROM Recipe WHERE RecipeName = ?";
            PreparedStatement psmt = c.prepareStatement(sql);
            psmt.setString(1, RecipeName);

            ResultSet rs = psmt.executeQuery(sql);
            int id_1 = 0;
            while (rs.next()) {
                id_1 = rs.getInt(1);
            }
            sql = "UPDATE Recipe set RecipeName = ? WHERE RecipeID = ?";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, newName);
            psmt.setInt(2, id_1);
            psmt.execute();

            sql = "SELECT IngredientID FROM RecipeIngredient WHERE IngredientName LIKE ?";
            psmt = c.prepareStatement(sql);
            psmt.setString(1, IngredientName);

            rs = psmt.executeQuery(sql);
            int id_2 = 0;
            while (rs.next()) {
                id_2 = rs.getInt(id_2);
            }
            sql = "UPDATE RecipeIngredient set Amount = ? AND IngredientName = ? WHERE IngredientID = ? AND RecipeID = ?";
            psmt = c.prepareStatement(sql);
            psmt.setDouble(1, Amount);
            psmt.setString(2, IngredientName);
            psmt.setInt(3, id_2);
            psmt.setInt(4, id_1);
            psmt.execute();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
    }
}
