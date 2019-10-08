package com.company;

import java.sql.*;

public class DBConnector
{
    private static final String path = "jdbc:sqlite:D:/Documents/Idea Projects/Lr1/LR1.db";

    private static Connection connection()
    {
        try
        {
            Connection conn = DriverManager.getConnection(path);
            return conn;
        }
        catch (SQLException ex)
        {
            System.err.println("connection" + ex.getMessage());
        }
        return null;
    }

    public static boolean execute(String sql)
    {
        try
        {
            Statement statement = connection().createStatement();
            statement.execute(sql);
            return true;
        }
        catch (SQLException ex)
        {
            System.err.println("execute" + ex.getMessage());
            return false;
        }
    }

    public static ResultSet executeQuery(String sql)
    {
        try
        {
            Statement statement = connection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            return rs;
        }
        catch (SQLException ex)
        {
            System.err.println("executeQuery" + ex.getMessage());
            return null;
        }
    }
}
