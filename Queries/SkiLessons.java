package Queries;

import java.sql.*;
import java.util.Scanner;

public class SkiLessons{
	public static void skiLessons(Connection conn, Scanner scanner) {
		System.out.print("Enter member ID: ");
		int memID;
		try {
			memID = Integer.parseInt(scanner.nextLine().trim());
		} catch (NumberFormatException e) {
			System.out.println("Invalid member ID format.");
			return;
		}
	
		String sql =
			"SELECT LL.orderID, LL.lessonsRemaining, E.name AS instructorName, " +
			"       L.\"date\", L.\"time\" " +
			"FROM LESSON_LOG LL " +
			"JOIN LESSON L ON LL.lessonID = L.lessonID " +
			"JOIN EMPLOYEE E ON L.empID = E.empID " +
			"JOIN PASS P     ON LL.passNo = P.passNo " +
			"WHERE P.memID = ? " +
			"ORDER BY L.\"date\", L.\"time\"";
	
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, memID);
	
			try (ResultSet rs = stmt.executeQuery()) {
				boolean found = false;
				System.out.printf("%-10s %-18s %-20s %-12s %-8s%n",
								  "OrderID", "LessonsRem", "Instructor", "Date", "Time");
				System.out.println("---------------------------------------------------------------------");
	
				while (rs.next()) {
					found = true;
					int orderID          = rs.getInt("orderID");
					int lessonsRemaining = rs.getInt("lessonsRemaining");
					String instructor    = rs.getString("instructorName");
					java.sql.Date date   = rs.getDate("date");
					String time          = rs.getString("time");
	
					System.out.printf("%-10d %-18d %-20s %-12s %-8s%n",
									  orderID, lessonsRemaining, instructor,
									  date.toString(), time);
				}
	
				if (!found) {
					System.out.println("No lessons found for member ID " + memID + ".");
				}
			}
		} catch (SQLException e) {
			System.err.println("Error executing ski lessons query: " + e.getMessage());
		}
	}
}
