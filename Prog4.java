import java.util.*;
import java.sql.*;

// Import all required Query classes
import Queries.IntermediateTrails;
import Queries.RecordManipulation;
import Queries.RidesAndRentals;
import Queries.SkiLessons;
import Queries.InstructorLessons;

/*
* File: Prog4.java
*
* Purpose: Establishes an Oracle JDBC connection and provides a text-based
*          user-interface for interacting with a ski-resort database. Provides input handling.
*
*/

public class Prog4 {
	//Oracle connection details
	// Magic lectura -> aloe access spell
	private static final String oracleURL = "jdbc:oracle:thin:@aloe.cs.arizona.edu:1521:oracle"; // JDBC URL for Oracle database
	private static String username = null; // Database username
	private static String password = null; // Database password

    private static final Set<String> VALID_TABLES = Set.of( // Set of valid table names for modification
            "MEMBER", "EMPLOYEE", "LESSON", "PASS", "LESSON_LOG",
            "TRAIL", "LIFT", "LIFT_LOG", "INVENTORY", "RENTAL_LOG"
    );

    private static final Map<String, List<String>> TABLE_SCHEMAS = createSchemaMap(); // Map to store table schemas

	/**
     * Initializes and returns a map containing the schema (column names) for each valid table.
     *
     * Preconditions:
     * - None
     *
     * Postconditions:
     * - Returns an unmodifiable map where keys are table names and values are lists of column names.
     *
     * @return A map of table names to their respective column lists.
     */
    private static Map<String, List<String>> createSchemaMap() {
        Map<String, List<String>> schemas = new HashMap<>(); // Create a new HashMap to store schemas
        // Populate schema for MEMBER table
        schemas.put("MEMBER", List.of("memID", "firstName", "lastName", "phone", "email", "emergencyContact"));
        // Populate schema for EMPLOYEE table
        schemas.put("EMPLOYEE", List.of("empID", "name", "phone", "salary"));
        // Populate schema for LESSON table (note quoted date, time, level)
        schemas.put("LESSON", List.of("lessonID", "\"date\"", "\"time\"", "empID", "\"level\""));
        // Populate schema for PASS table
        schemas.put("PASS", List.of("passNo", "memID", "type", "remainingUses", "totalUses", "purchaseTime", "expDate", "price", "isActive"));
        // Populate schema for LESSON_LOG table
        schemas.put("LESSON_LOG", List.of("orderID", "lessonID", "passNo", "lessonsPurchased", "lessonsRemaining"));
        // Populate schema for TRAIL table (note quoted start, end, level)
        schemas.put("TRAIL", List.of("trailID", "category", "name", "\"start\"", "\"end\"", "\"level\"", "status"));
        // Populate schema for LIFT table (note quoted open, close, level)
        schemas.put("LIFT", List.of("liftID", "trailID", "name", "\"open\"", "\"close\"", "\"level\"", "status"));
        // Populate schema for LIFT_LOG table
        schemas.put("LIFT_LOG", List.of("xactID", "liftID", "passNo", "scanTime"));
        // Populate schema for INVENTORY table (note quoted size)
        schemas.put("INVENTORY", List.of("eID", "type", "\"size\"", "isActive", "isAvailable"));
        // Populate schema for RENTAL_LOG table
        schemas.put("RENTAL_LOG", List.of("rentalID", "passNo", "rentalTime", "returnTime", "isReturned", "eID"));
        return Collections.unmodifiableMap(schemas); // Return an unmodifiable view of the schemas map
    }

	/**
     * Main entry point for the application. Parses command-line arguments for database credentials,
     * establishes a database connection, and enters a loop to process user commands.
     *
     * @param args Command-line arguments, expecting username and password.
     *
     * Preconditions:
     * - args should contain two elements: username and password.
     *
     * Postconditions:
     * - Program connects to the database and processes user input until 'exit' or 'quit' is entered.
     * - Database connection is closed upon termination.
     */
	public static void main(String args[]) {
		//Argument Parsing
        if (args.length == 2) { // Check if two arguments (username, password) are provided
            username = args[0]; // Assign first argument to username
            password = args[1]; // Assign second argument to password
        } else { // If incorrect number of arguments
            System.out.println("\nUsage:  java Prog4 <username> <password>\n" // Print usage message
                    + "    where <username> is your Oracle DBMS username,\n    and <password> is your Oracle"
                    + " password.\n");
            System.exit(-1); // Exit the program
        }

        // load the (Oracle) JDBC driver by initializing its base
        // class, 'oracle.jdbc.OracleDriver'.
        try {
            Class.forName("oracle.jdbc.OracleDriver"); // Attempt to load the Oracle JDBC driver
        } catch (ClassNotFoundException e) { // Handle case where driver class is not found
            System.err.println("*** ClassNotFoundException: Error loading Oracle JDBC driver.");
            System.err.println("\tPerhaps the driver is not on the Classpath?");
            System.exit(-1); // Exit the program
        }

        // make and return a database connection to the user's
        // Oracle database
        Connection conn = null; // Initialize connection object
        try {
            conn = DriverManager.getConnection(oracleURL, username, password); // Attempt to establish a database connection
        } catch (SQLException e) { // Handle SQL errors during connection attempt
            System.err.println("*** SQLException: Could not open JDBC connection.");
            System.err.println("\tMessage:   " + e.getMessage());
            System.err.println("\tSQLState:  " + e.getSQLState());
            System.err.println("\tErrorCode: " + e.getErrorCode());
            System.exit(-1); // Exit the program
        }

        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input

        //Display Menu
        System.out.println("Welcome to Mountain ski resort database");
        System.out.println("Available commands: insert, delete, update, trails, rides, lessons, instructors, exit/quit");
        System.out.println("For insert/delete/update, use format: <command> <TABLE_NAME>");


        //Main Query Loop
        while (true) { // Start the main loop for processing user commands
            System.out.print("\nEnter query: "); // Prompt user for input
            String input = scanner.nextLine().trim(); // Read and trim user input
            if (input.isEmpty()) { // If input is empty, continue to next iteration
                continue;
            }

            String[] parts = input.split("\\s+", 2); // Split input into command and potential arguments
            String command = parts[0].toLowerCase(); // Convert command to lowercase

            if (command.equals("exit") || command.equals("quit")) { // Check for exit commands
                System.out.println("Exiting program.");
                break; // Exit the loop
            }

            switch (command) { // Process the command
                case "insert": // Handle insert command
                case "delete": // Handle delete command
                case "update": // Handle update command
                    handleModificationCommand(command, parts, scanner, conn); // Delegate to modification handler
                    break;
                case "trails": // Handle trails command
                    IntermediateTrails.intermediateTrails(conn); // Call trails query method
                    break;
                case "rides": // Handle rides command
                    RidesAndRentals.ridesAndRentals(conn, scanner); // Call rides and rentals query method
                    break;
                case "lessons": // Handle lessons command
                    SkiLessons.skiLessons(conn, scanner); // Call ski lessons query method
                    break;
                case "instructors": // Handle instructors command
                    InstructorLessons.instructorLessons(conn, scanner); // Call instructor lessons query method
                    break;
                default: // Handle invalid command
                    System.out.println("Error: Invalid command. Please choose from insert, delete, update, trails, rides, lessons, instructors, exit, quit.");
                    break;
            }
        }

        scanner.close(); // Close the scanner
        try {
            if (conn != null && !conn.isClosed()) { // Check if connection is valid and open
                conn.close(); // Close the database connection
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) { // Handle SQL errors during connection closing
             System.err.println("*** SQLException: Could not close JDBC connection.");
             System.err.println("\tMessage:   " + e.getMessage());
        }
	}

	/**
     * Handles dispatching of database modification commands (insert, delete, update)
     * by validating the table name and calling the appropriate specific handler.
     *
     * @param command The modification command (insert, delete, or update).
     * @param parts   The user input split into parts; parts[1] is expected to contain the table name.
     * @param scanner The Scanner object for further user input if needed.
     * @param conn    The active database connection.
     *
     * Preconditions:
     * - command is one of "insert", "delete", or "update".
     * - conn is a valid, open database connection.
     * - scanner is a valid Scanner object.
     *
     * Postconditions:
     * - The appropriate handler (handleInsert, handleDelete, or handleUpdate) is called if input is valid.
     * - Error messages are printed if input is invalid (e.g., missing table name, invalid table name).
     */
    private static void handleModificationCommand(String command, String[] parts, Scanner scanner, Connection conn) {
        if (parts.length < 2 || parts[1].trim().isEmpty()) { // Check if table name is provided
            System.out.println("Error: Missing table name for '" + command + "'. Usage: " + command + " <TABLE_NAME>");
            return; // Exit method if table name is missing
        }

        String tableName = parts[1].trim().split("\\s+")[0].toUpperCase(); // Extract and uppercase the table name

        if (!VALID_TABLES.contains(tableName)) { // Check if the table name is valid
            System.out.println("Error: Invalid table name '" + tableName + "'.");
            System.out.println("Valid tables are: " + String.join(", ", VALID_TABLES));
            return; // Exit method if table name is invalid
        }

        switch (command) { // Call the appropriate handler based on the command
            case "insert":
                handleInsert(tableName, scanner, conn); // Call insert handler
                break;
            case "delete":
                handleDelete(tableName, scanner, conn); // Call delete handler
                break;
            case "update":
                handleUpdate(tableName, scanner, conn); // Call update handler
                break;
        }
    }

	/**
     * Handles the user interaction for inserting a new record into a specified table.
     * Prompts the user for values for each column of the table.
     *
     * @param tableName The name of the table to insert into.
     * @param scanner   The Scanner object for reading user input.
     * @param conn      The active database connection.
     *
     * Preconditions:
     * - tableName is a valid table name present in TABLE_SCHEMAS.
     * - scanner is a valid Scanner object.
     * - conn is a valid, open database connection.
     *
     * Postconditions:
     * - A record insertion is attempted via RecordManipulation.insert.
     * - The result of the insertion is printed to the console.
     */
    private static void handleInsert(String tableName, Scanner scanner, Connection conn) {
        List<String> columns = TABLE_SCHEMAS.get(tableName); // Get the list of columns for the table
        if (columns == null) { // Check if schema definition exists
            System.out.println("Error: Schema definition not found for table " + tableName);
            return; // Exit method if no schema
        }

        System.out.println("Inserting into table: " + tableName);
        System.out.println("Please enter values for the following columns:");

        List<String> valuesList = new ArrayList<>(); // Create a list to store input values

        for (String column : columns) { // Loop through each column to get user input
            System.out.print("Enter value for " + column + ": "); // Prompt for column value
            String value = scanner.nextLine().trim(); // Read and trim the input value
            valuesList.add(value); // Add the value to the list
        }

        String result = RecordManipulation.insert(conn, tableName, valuesList); // Call the insert method
        System.out.println("Result: " + result); // Print the result of the insertion
    }

	/**
     * Handles the user interaction for deleting records from a specified table.
     * Prompts the user for a WHERE condition to specify which records to delete.
     *
     * @param tableName The name of the table to delete from.
     * @param scanner   The Scanner object for reading user input.
     * @param conn      The active database connection.
     *
     * Preconditions:
     * - tableName is a valid table name.
     * - scanner is a valid Scanner object.
     * - conn is a valid, open database connection.
     *
     * Postconditions:
     * - A record deletion is attempted via RecordManipulation.delete.
     * - The result of the deletion is printed to the console.
     * - Warns against empty conditions to prevent accidental deletion of all rows.
     */
    private static void handleDelete(String tableName, Scanner scanner, Connection conn) {
        System.out.println("Deleting from table: " + tableName);
        System.out.print("Enter the WHERE condition (e.g., memID = 10): "); // Prompt for WHERE condition
        String condition = scanner.nextLine().trim(); // Read and trim the condition

        if (condition.isEmpty()) { // Check if the condition is empty
            System.out.println("Error: Delete condition cannot be empty.");
            System.out.println("If you intend to delete all rows, use a condition like '1=1' (use with extreme caution!).");
            return; // Exit method if condition is empty
        }

        String result = RecordManipulation.delete(conn, tableName, condition); // Call the delete method
        System.out.println("Result: " + result); // Print the result of the deletion
    }

	/**
     * Handles the user interaction for updating records in a specified table.
     * Prompts the user for SET clauses (column-value pairs) and a WHERE condition.
     *
     * @param tableName The name of the table to update.
     * @param scanner   The Scanner object for reading user input.
     * @param conn      The active database connection.
     *
     * Preconditions:
     * - tableName is a valid table name present in TABLE_SCHEMAS.
     * - scanner is a valid Scanner object.
     * - conn is a valid, open database connection.
     *
     * Postconditions:
     * - A record update is attempted via RecordManipulation.update.
     * - The result of the update is printed to the console.
     * - Warns against empty SET clauses or WHERE conditions.
     */
    private static void handleUpdate(String tableName, Scanner scanner, Connection conn) {
        List<String> columns = TABLE_SCHEMAS.get(tableName); // Get the list of columns for the table
         if (columns == null) { // Check if schema definition exists
             System.out.println("Error: Schema definition not found for table " + tableName);
             return; // Exit method if no schema
         }

        System.out.println("Updating table: " + tableName);
        System.out.println("Available columns: " + String.join(", ", columns));
        System.out.print("Enter the SET clause(s) (e.g., column1 = newValue1, column2 = 'new text'): "); // Prompt for SET clauses
        String setClausesInput = scanner.nextLine().trim(); // Read and trim SET clauses

        System.out.print("Enter the WHERE condition (e.g., id = 5): "); // Prompt for WHERE condition
        String condition = scanner.nextLine().trim(); // Read and trim WHERE condition

        if (setClausesInput.isEmpty()) { // Check if SET clauses are empty
            System.out.println("Error: SET clauses cannot be empty for an update.");
            return; // Exit method if SET clauses are empty
        }
        if (condition.isEmpty()) { // Check if WHERE condition is empty
            System.out.println("Error: Update condition cannot be empty to prevent accidental update of all rows.");
             System.out.println("If you intend to update all rows, use a condition like '1=1' (use with extreme caution!).");
            return; // Exit method if WHERE condition is empty
        }

        Map<String, String> updates = new HashMap<>(); // Create a map to store column-value pairs for update
        String[] clauses = setClausesInput.split(","); // Split SET clauses by comma
        boolean parseError = false; // Flag for parsing errors
        for (String clause : clauses) { // Loop through each SET clause
            String[] parts = clause.split("=", 2); // Split clause into column name and value
            if (parts.length == 2) { // Check if split was successful
                String colName = parts[0].trim(); // Get column name
                String value = parts[1].trim(); // Get new value

                boolean isValidColumn = false; // Flag for column validity
                // Clean column name (remove quotes if present) for comparison
                String cleanColName = colName.startsWith("\"") && colName.endsWith("\"") ? colName.substring(1, colName.length() - 1) : colName;
                 for (String schemaCol : columns) { // Loop through schema columns to validate
                    // Clean schema column name for comparison
                    String cleanSchemaCol = schemaCol.startsWith("\"") && schemaCol.endsWith("\"") ? schemaCol.substring(1, schemaCol.length() - 1) : schemaCol;
                     if (cleanColName.equalsIgnoreCase(cleanSchemaCol)) { // Case-insensitive comparison
                        isValidColumn = true; // Mark column as valid
                         colName = schemaCol; // Use the schema's version of the column name (preserves quotes)
                        break; // Exit loop once column is validated
                    }
                 }


                if (!isValidColumn) { // If column is not in schema
                     System.out.println("Warning: Column '" + cleanColName + "' is not explicitly listed in the schema for table " + tableName +". Proceeding anyway.");
                      updates.put(colName, value); // Add to updates map (original user input for colName)
                } else { // If column is valid
                     updates.put(colName, value); // Add to updates map (potentially schema-corrected colName)
                }
            } else { // If SET clause is malformed
                System.out.println("Error: Malformed SET clause: '" + clause + "'. Expected format 'column = value'.");
                parseError = true; // Set parse error flag
                break; // Exit loop
            }
        }


        if (parseError) { // If there was a parsing error
            return; // Exit method
        }

        if (updates.isEmpty()) { // If no valid updates were parsed
            System.out.println("Error: No valid SET clauses provided.");
            return; // Exit method
        }

        String result = RecordManipulation.update(conn, tableName, updates, condition); // Call the update method
        System.out.println("Result: " + result); // Print the result of the update
    }
}
