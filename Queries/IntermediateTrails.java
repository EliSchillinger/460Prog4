package Queries;

import java.sql.*;

public class IntermediateTrails {
	public static void intermediateTrails(Connection conn) {
        String sql =
            "SELECT T.trailID, T.name AS trailName, T.category, L.name AS liftName " +
            "FROM TRAIL T " +
            "LEFT JOIN LIFT L " +
            "  ON L.trailID = T.trailID AND L.status = 'Operating' " +
            "WHERE T.\"level\" = 'Intermediate' AND T.status = 'Open' " +
            "ORDER BY T.name, liftName";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            boolean found = false;
            System.out.printf("%-8s %-25s %-15s %-25s%n",
                              "TrailID", "TrailName", "Category", "LiftName");
            System.out.println("------------------------------------------------------------------");

            while (rs.next()) {
                found = true;
                int trailID   = rs.getInt("trailID");
                String trailName = rs.getString("trailName");
                String category  = rs.getString("category");
                String liftName  = rs.getString("liftName");
                if (liftName == null) {
                    liftName = "(no operating lifts)";
                }

                System.out.printf("%-8d %-25s %-15s %-25s%n",
                                  trailID, trailName, category, liftName);
            }

            if (!found) {
                System.out.println("No open intermediate trails found.");
            }
        } catch (SQLException e) {
            System.err.println("Error executing intermediate trails query: " + e.getMessage());
        }
    }
}
