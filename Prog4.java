import java.util.Arrays;
import java.util.Scanner;
import java.sql.*;

import Queries.IntermediateTrails;
import Queries.RecordManipulation;
import Queries.RidesAndRentals;
import Queries.SkiLessons;

public class Prog4 {

	private static String username = null;
	private static String password = null;
	
	public static void main(String args[]) {
		//Argument Parsing
        if (args.length == 2) {
            username = args[0];
            password = args[1];
        } else {
            System.out.println("\nUsage:  java Prog3 <username> <password>\n"
                    + "    where <username> is your Oracle DBMS username,\n    and <password> is your Oracle"
                    + " password.\n");
            System.exit(-1);
        }

        // Magic lectura -> aloe access spell
        final String oracleURL = "jdbc:oracle:thin:@aloe.cs.arizona.edu:1521:oracle";

        // load the (Oracle) JDBC driver by initializing its base
        // class, 'oracle.jdbc.OracleDriver'.
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("*** ClassNotFoundException: Error loading Oracle JDBC driver.");
            System.err.println("\tPerhaps the driver is not on the Classpath?");
            System.exit(-1);
        }

        // make and return a database connection to the user's
        // Oracle database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(oracleURL, username, password);
        } catch (SQLException e) {
            System.err.println("*** SQLException: Could not open JDBC connection.");
            System.err.println("\tMessage:   " + e.getMessage());
            System.err.println("\tSQLState:  " + e.getSQLState());
            System.err.println("\tErrorCode: " + e.getErrorCode());
            System.exit(-1);
        }
		
        Scanner scanner = new Scanner(System.in);

        //Display Menu
        System.out.println("Welcome to Mountain ski resort database");

        //Main Query Loop
        while (true) {
            System.out.print("Enter query: ");
            String input = scanner.nextLine();
            String[] parts = input.trim().split("\\s+");

            if (parts.length > 0) {
                String command = parts[0].toLowerCase();

                if (command.equals("exit") || command.equals("quit")) {
                    System.out.println("Exiting program.");
                    break; 
                } else if (command.equals("insert")) {
                	System.out.println(RecordManipulation.insert(conn));
                } else if (command.equals("delete")) {
                	System.out.println(RecordManipulation.delete(conn));
                } else if (command.equals("update")) {
                	System.out.println(RecordManipulation.update(conn));
                } else if (command.equals("trails")) {
                	IntermediateTrails.intermediateTrails(conn);
                } else if (command.equals("rides")) {
                	RidesAndRentals.ridesAndRentals(conn, scanner);
                } else if (command.equals("lessons")) {
                	SkiLessons.skiLessons(conn, scanner);
                } else {
                    System.out.println("Error: Invalid command. Please choose from Exit, or Lessons.");
                }
            } 
        } 

        scanner.close();
	}
}
