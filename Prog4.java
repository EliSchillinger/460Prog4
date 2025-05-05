import java.util.Arrays;
import java.util.Scanner;

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
                	System.out.println(RecordManipulation.insert());
                } else if (command.equals("delete")) {
                	System.out.println(RecordManipulation.delete());
                } else if (command.equals("update")) {
                	System.out.println(RecordManipulation.update());
                } else if (command.equals("trails")) {
                	System.out.println(IntermediateTrails.intermediateTrails());
                } else if (command.equals("rides")) {
                	System.out.println(RidesAndRentals.ridesAndRentals());
                } else if (command.equals("lessons")) {
                	System.out.println(SkiLessons.skiLessons());
                } else {
                    System.out.println("Error: Invalid command. Please choose from Exit, or Lessons.");
                }
            } 
        } 

        scanner.close();
	}
}
