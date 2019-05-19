package model;

import java.lang.*;
import java.sql.*;

public class Cerf_BrewDay_CreateDB {
    public static void main(String[] args) {
        try{
            Class.forName("org.sqlite.JDBC");
            DriverManager.getConnection("jdbc:sqlite:Brewing.db");
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened Brewing Database Successfully");
    }
}
