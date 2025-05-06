package Queries;

import java.sql.*;
import java.util.Scanner;

/*
* File: InstructorLessons.java
* 
* This class contains a method which executes the following query:
* 	QUERY: For a date entered by the user, 
* 	show all instructors who had scheduled lessons 
* 	and how many students each taught.
* 
* USES: EMPLOYEE, LESSON, LESSON_LOG tables.
*/

public class InstructorLessons{
	
    /**
     * Purpose:
     * Executes a parameterized SQL query 
     *
     * Preconditions:
     * - A valid JDBC Connection object (conn) is established
     * - A Scanner object (scanner) must be passed
     * - The EMPLOYEE, LESSON, and LESSON_LOG tables must be populated and created.
     *
     * Postconditions:
     * - Executes a SQL query with a user-supplied date.
     * - Outputs the results to the console.
     * - Displays a message if no records are found.
     *
     * @param conn    The active JDBC connection to the database.
     * @param scanner A Scanner object for reading input from the user.
     */

	public static void instructorLessons(Connection conn, Scanner scanner) {
		String lessonDate;
		
		while (true){
			System.out.print("Enter lesson date (YYYY-MM-DD):");
			lessonDate = scanner.nextLine();

			if (lessonDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
				break;
			}
			else {
				System.out.println("Invalid format. Please use YYYY-MM-DD.");
			}
	
		String sql =
			"SELECT E.empID, E.name AS instructorName, "
            + "COUNT(DISTINCT LL.orderID) AS totalStudents "
            + "FROM EMPLOYEE E "
            + "JOIN LESSON L ON E.empID = L.empID "
            + "JOIN LESSON_LOG LL ON L.lessonID = LL.lessonID "
            + "WHERE L.date = :lessonDate "
            + "GROUP BY E.empID, E.name; ";
	
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setDate(1, Date.valueOf(lessonDate));
	
			try (ResultSet rs = stmt.executeQuery()) {
				boolean found = false;
				System.out.printf("%-10s %-25s %s\n", "empID", "Instructor Name", "Total Students");
                System.out.println("----------------------------------------------------------");
	
				while (rs.next()) {
                    found = true;
                    int empID = rs.getInt("empID");
                    String name = rs.getString("instructorName");
                    int total = rs.getInt("totalStudents");
                    System.out.printf("%-10d %-25s %d\n", empID, name, total);
                }
	
				if (!found) {
					System.out.println("No lessons or instructors found on " + lessonDate + ".");
				}
			}
		} catch (SQLException e) {
			System.err.println("Error executing instructor lessons query: " + e.getMessage());
		}
	}
}
