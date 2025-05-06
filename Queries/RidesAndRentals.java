package Queries;

import java.sql.*;
import java.util.Scanner;

/*
* File: RidesAndRentals.java
* 
* This class contains a method which executes the following query:
* 	QUERY: For a given ski pass, list all lift rides 
*   and equipment rentals associated with it, along with timestamps
*   and return status.
* 
* USES: LIFT_LOG, LIFT tables
*/

public class RidesAndRentals {
    /**
     * Purpose:
     * Executes a parameterized SQL query 
     *
     * Preconditions:
     * - A valid JDBC Connection object (conn) is established
     * - A Scanner object (scanner) must be passed
     * - The LIFT_LOG and LIFT tables must be populated and created.
     *
     * Postconditions:
     * - Executes a SQL query with a user-supplied ski pass number.
     * - Outputs the results to the console.
     * - Displays a message if no records are found.
     *
     * @param conn    The active JDBC connection to the database.
     * @param scanner A Scanner object for reading input from the user.
    */
	public static void ridesAndRentals(Connection conn, Scanner scanner) {
        System.out.print("Enter ski pass number: ");
        String passNo = scanner.nextLine().trim();
        if (passNo.isEmpty()) {
            System.out.println("Pass number cannot be empty.");
            return;
        }

        // 1) Lift rides
        String sqlRides =
            "SELECT LL.xactID, L.name AS liftName, LL.scanTime " +
            "FROM LIFT_LOG LL " +
            "JOIN LIFT L ON LL.liftID = L.liftID " +
            "WHERE LL.passNo = ? " +
            "ORDER BY LL.scanTime";
        try (PreparedStatement stmt = conn.prepareStatement(sqlRides)) {
            stmt.setString(1, passNo);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("\n--- Lift Rides for Pass " + passNo + " ---");
                System.out.printf("%-10s %-30s %-20s%n", "RideID", "LiftName", "ScanTime");
                System.out.println("--------------------------------------------------------------");
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    int rideID = rs.getInt("xactID");
                    String liftName = rs.getString("liftName");
                    java.sql.Timestamp scanTime = rs.getTimestamp("scanTime");
                    System.out.printf("%-10d %-30s %-20s%n", rideID, liftName, scanTime.toString());
                }
                if (!found) {
                    System.out.println("(No lift rides found for this pass.)");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching lift rides: " + e.getMessage());
            return;
        }

        // 2) Equipment rentals
        String sqlRentals =
            "SELECT RL.rentalID, RL.eID, RL.rentalTime, RL.returnTime, RL.isReturned " +
            "FROM RENTAL_LOG RL " +
            "WHERE RL.passNo = ? " +
            "ORDER BY RL.rentalTime";
        try (PreparedStatement stmt = conn.prepareStatement(sqlRentals)) {
            stmt.setString(1, passNo);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("\n--- Equipment Rentals for Pass " + passNo + " ---");
                System.out.printf("%-10s %-8s %-20s %-20s %-12s%n", "RentalID", "ItemID", "RentalTime", "ReturnTime", "Returned");
                System.out.println("---------------------------------------------------------------------------");
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    int rentalID = rs.getInt("rentalID");
                    int itemID = rs.getInt("eID");
                    java.sql.Timestamp rentalTime = rs.getTimestamp("rentalTime");
                    java.sql.Timestamp returnTime = rs.getTimestamp("returnTime");
                    boolean isReturned = rs.getInt("isReturned") == 1;
                    String returnedStr = isReturned ? "Yes" : "No";
                    String returnTimeStr = (returnTime != null ? returnTime.toString() : "--");
                    System.out.printf("%-10d %-8d %-20s %-20s %-12s%n",
                                      rentalID, itemID, rentalTime.toString(), returnTimeStr, returnedStr);
                }
                if (!found) {
                    System.out.println("(No equipment rentals found for this pass.)");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching equipment rentals: " + e.getMessage());
        }
    }
}
