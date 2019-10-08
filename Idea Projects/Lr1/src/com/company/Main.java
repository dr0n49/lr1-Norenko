package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String command;
        do {
            System.out.print("Enter command: ");
            command = scanner.nextLine();
            if(command.equalsIgnoreCase("find solution"))
            {
                System.out.print("Enter name of error: ");
                command = scanner.nextLine();
                try
                {
                    ResultSet rs = DBConnector.executeQuery("SELECT solution FROM errors WHERE error='" + command + "')");
                    while (rs.next())
                    {
                        System.out.println(rs.getString("solution"));
                    }
                }
                catch (SQLException ex)
                {
                    System.err.println(ex.getMessage());
                }
            }

            if(command.equalsIgnoreCase("find errors for app"))
            {
                System.out.println("Enter name of app");
                command = scanner.nextLine();

                try
                {
                    ResultSet rs = DBConnector.executeQuery("SELECT error FROM errors WHERE nameApp='" + command + "')");
                    while (rs.next())
                    {
                        System.out.println(rs.getString("error"));
                    }
                }
                catch (SQLException ex)
                {
                    System.err.println(ex.getMessage());
                }
            }


        }while (!command.equalsIgnoreCase("quit"));

    }
} 
