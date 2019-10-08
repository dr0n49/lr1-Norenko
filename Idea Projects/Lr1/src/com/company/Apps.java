package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Apps
{
    private int num;
    private String nameApp;
    private int numErrors;

    public int getNumErrors()
    {
        try
        {
            ResultSet rs = DBConnector.executeQuery("SELECT error FROM errors WHERE nameApps='" + nameApp + "')");
            ArrayList<String> temp = new ArrayList<String>();
            while (rs.next())
            {
                temp.add(rs.getString("error"));
            }
            DBConnector.execute("INSERT INTO apps (numErrors) VALUES('" + temp.size() + "') WHERE nameApp='" + nameApp +"')");
            return temp.size();
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return 0;
    }

    public int getNum()
    {
        try
        {
            ResultSet rs = DBConnector.executeQuery("SELECT num FROM apps WHERE nameApp='" + nameApp + "'");
            while (rs.next())
            {
                return rs.getInt("num");
            }
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return 0;
    }

    public String getNameApp()
    {
        ResultSet rs = DBConnector.executeQuery("SELECT nameApp FROM apps");
        try
        {
            while (rs.next())
            {
                return rs.getString("nameApp");
            }
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    public void setNameApp(String nameApp)
    {
        this.nameApp = nameApp;
        DBConnector.execute("INSERT INTO apps (nameApp) VALUES('" + nameApp + "') WHERE num='" + num + "'");
    }

    public Apps(String nameApp)
    {
        this.nameApp = nameApp;
        ResultSet rs = DBConnector.executeQuery("INSERT INTO apps (nameApp) VALUES('" + nameApp + "')");
        try
        {
            while (rs.next())
            {
                this.num = rs.getInt("num");
            }
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
    }
}
