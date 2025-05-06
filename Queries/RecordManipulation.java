package Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/*
* File: RecordManipulation.java
* 
* Purpose: Provides methods for performing basis create, update and delete
* 		   operations on a SQL database table.
*
*/

public class RecordManipulation {

	/**
     * Inserts a new record into the specified table using the provided attribute values.
     * 
     * @param conn        A valid database connection
     * @param tableName   Name of the table into which the record will be inserted
     * @param attributes  A list of attribute values to be inserted in order
     * 
     * Preconditions:
     * - conn is not null
     * - tableName is a valid non-empty string corresponding to a real table
     * - attributes is not null or empty
     * 
     * Postconditions:
     * - A new row is inserted if no SQL errors occur
     * 
     * @return A message indicating whether the insertion was successful
     */
	public static String insert(Connection conn, String tableName, List<String> attributes) {
		if (attributes == null || attributes.isEmpty()) {
			return "Error: No values provided for insertion.";
		}
		if (tableName == null || tableName.trim().isEmpty()) {
		    return "Error: Table name cannot be empty for insertion.";
		}
		if (conn == null) {
            return "Error: Database connection is null.";
        }


		String placeholders = String.join(", ", Collections.nCopies(attributes.size(), "?"));
		String sql = "INSERT INTO " + tableName + " VALUES (" + placeholders + ")";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			for (int i = 0; i < attributes.size(); i++) {
				stmt.setString(i + 1, attributes.get(i));
			}

			int rowsAffected = stmt.executeUpdate();
			return "Success: " + rowsAffected + " row(s) inserted into " + tableName + ".";

		} catch (SQLException e) {
			return "Error inserting record into " + tableName + ": " + e.getMessage() +
				   " (SQLState: " + e.getSQLState() + ", ErrorCode: " + e.getErrorCode() + ")";
		} catch (Exception e) {
            return "Unexpected error during insert into " + tableName + ": " + e.getMessage();
        }
	}

	/**
     * Deletes records from a specified table that match a given condition
     * 
     * @param conn       A valid database connection
     * @param tableName  Name of the table from which records will be deleted
     * @param condition  SQL WHERE clause condition string (without "WHERE")
     * 
     * Preconditions:
     * - conn is not null
     * - tableName and condition are non-empty strings
     * 
     * Postconditions:
     * - Matching rows are deleted from the database
     * 
     * @return A message indicating whether the deletion was successful or not.
     */
	public static String delete(Connection conn, String tableName, String condition) {
		if (condition == null || condition.trim().isEmpty()) {
			return "Error: Delete condition cannot be empty.";
		}
        if (tableName == null || tableName.trim().isEmpty()) {
            return "Error: Table name cannot be empty for deletion.";
        }
		if (conn == null) {
            return "Error: Database connection is null.";
        }

		String sql = "DELETE FROM " + tableName + " WHERE " + condition;

		try (Statement stmt = conn.createStatement()) {
			int rowsAffected = stmt.executeUpdate(sql);

			if (rowsAffected == 0) {
				return "Warning: Delete executed successfully, but 0 rows matched the condition '" + condition + "' in table " + tableName + ".";
			} else {
				return "Success: " + rowsAffected + " row(s) deleted from " + tableName + ".";
			}
		} catch (SQLException e) {
			return "Error deleting record(s) from " + tableName + ": " + e.getMessage() +
				   " (SQLState: " + e.getSQLState() + ", ErrorCode: " + e.getErrorCode() + ")";
		} catch (Exception e) {
            return "Unexpected error during delete from " + tableName + ": " + e.getMessage();
        }
	}

	/**
     * Updates existing records in a table that match a specified condition with new values.
     * 
     * @param conn       A valid database connection
     * @param tableName  Name of the table to update
     * @param updates    A map of column names to new values
     * @param condition  SQL WHERE clause condition string (without "WHERE")
     * 
     * Preconditions:
     * - conn is not null
     * - tableName is a non-empty string
     * - updates is not null or empty
     * - condition is a non-empty string to prevent full table updates
     * 
     * Postconditions:
     * - Matching rows are updated with the new values
     * 
     * @return A message indicating whether the update was successful or not.
     */
	public static String update(Connection conn, String tableName, Map<String, String> updates, String condition) {
		if (updates == null || updates.isEmpty()) {
			return "Error: No update clauses (column = value pairs) provided.";
		}
		if (condition == null || condition.trim().isEmpty()) {
			return "Error: Update condition cannot be empty to prevent accidental update of all data.";
		}
        if (tableName == null || tableName.trim().isEmpty()) {
            return "Error: Table name cannot be empty for update.";
        }
		if (conn == null) {
            return "Error: Database connection is null.";
        }

		StringBuilder setClause = new StringBuilder();
		List<String> updateValues = new ArrayList<>();

		boolean first = true;
		for (Map.Entry<String, String> entry : updates.entrySet()) {
			if (!first) {
				setClause.append(", ");
			}
			setClause.append(entry.getKey()).append(" = ?");
			updateValues.add(entry.getValue());
			first = false;
		}

		String sql = "UPDATE " + tableName + " SET " + setClause.toString() + " WHERE " + condition;

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			for (int i = 0; i < updateValues.size(); i++) {
				stmt.setString(i + 1, updateValues.get(i));
			}

			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected == 0) {
				return "Warning: Update executed successfully, but 0 rows matched the condition '" + condition + "' in table " + tableName + ".";
			} else {
				return "Success: " + rowsAffected + " row(s) updated in " + tableName + ".";
			}
		} catch (SQLException e) {
			return "Error updating record(s) in " + tableName + ": " + e.getMessage() +
				   " (SQLState: " + e.getSQLState() + ", ErrorCode: " + e.getErrorCode() + ")";
		} catch (Exception e) {
            return "Unexpected error during update of " + tableName + ": " + e.getMessage();
        }
	}
}
