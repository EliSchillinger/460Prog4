package Queries;

import java.sql.*;
import java.util.Scanner;

/*
QUERY: For a date entered by the user, 
show all instructors who had scheduled lessons 
and how many students each taught.

USES: EMPLOYEE, LESSON, LESSON_LOG
*/

public class InstructorLessons{
	public static void instructorLessons(Connection conn, Scanner scanner) {
		System.out.print("Enter lesson date (YYYY-MM-DD):");

		String lessonDate = scanner.nextLine();
	
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
