import java.util.*;
import java.sql.*;

// Import all required Query classes
import Queries.IntermediateTrails;
import Queries.RecordManipulation;
import Queries.RidesAndRentals;
import Queries.SkiLessons;
import Queries.InstructorLessons; // Added from Program 1 analysis

public class Prog4 {
	//Oracle connection details
	// Magic lectura -> aloe access spell
	private static final String oracleURL = "jdbc:oracle:thin:@aloe.cs.arizona.edu:1521:oracle";
	private static String username = null;
	private static String password = null;

    // Definitions from Program 2
    private static final Set<String> VALID_TABLES = Set.of(
            "MEMBER", "EMPLOYEE", "LESSON", "PASS", "LESSON_LOG",
            "TRAIL", "LIFT", "LIFT_LOG", "INVENTORY", "RENTAL_LOG"
    );

    private static final Map<String, List<String>> TABLE_SCHEMAS = createSchemaMap();

    // Method from Program 2
    private static Map<String, List<String>> createSchemaMap() {
        Map<String, List<String>> schemas = new HashMap<>();
        schemas.put("MEMBER", List.of("memID", "firstName", "lastName", "phone", "email", "emergencyContact"));
        schemas.put("EMPLOYEE", List.of("empID", "name", "phone", "salary"));
        schemas.put("LESSON", List.of("lessonID", "\"date\"", "\"time\"", "empID", "\"level\""));
        schemas.put("PASS", List.of("passNo", "memID", "type", "remainingUses", "totalUses", "purchaseTime", "expDate", "price", "isActive"));
        schemas.put("LESSON_LOG", List.of("orderID", "lessonID", "passNo", "lessonsPurchased", "lessonsRemaining"));
        schemas.put("TRAIL", List.of("trailID", "category", "name", "\"start\"", "\"end\"", "\"level\"", "status"));
        schemas.put("LIFT", List.of("liftID", "trailID", "name", "\"open\"", "\"close\"", "\"level\"", "status"));
        schemas.put("LIFT_LOG", List.of("xactID", "liftID", "passNo", "scanTime"));
        schemas.put("INVENTORY", List.of("eID", "type", "\"size\"", "isActive", "isAvailable"));
        schemas.put("RENTAL_LOG", List.of("rentalID", "passNo", "rentalTime", "returnTime", "isReturned", "eID"));
        return Collections.unmodifiableMap(schemas);
    }

	public static void main(String args[]) {
		//Argument Parsing
        if (args.length == 2) {
            username = args[0];
            password = args[1];
        } else {
            System.out.println("\nUsage:  java Prog4 <username> <password>\n" // Corrected usage message from first script
                    + "    where <username> is your Oracle DBMS username,\n    and <password> is your Oracle"
                    + " password.\n");
            System.exit(-1);
        }

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
        System.out.println("Available commands: insert, delete, update, trails, rides, lessons, instructors, exit/quit");
        System.out.println("For insert/delete/update, use format: <command> <TABLE_NAME>");


        //Main Query Loop
        while (true) {
            System.out.print("\nEnter query: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split("\\s+", 2);
            String command = parts[0].toLowerCase();

            if (command.equals("exit") || command.equals("quit")) {
                System.out.println("Exiting program.");
                break;
            }

            switch (command) {
                case "insert":
                case "delete":
                case "update":
                    handleModificationCommand(command, parts, scanner, conn);
                    break;
                case "trails":
                    IntermediateTrails.intermediateTrails(conn);
                    break;
                case "rides":
                    RidesAndRentals.ridesAndRentals(conn, scanner);
                    break;
                case "lessons":
                    SkiLessons.skiLessons(conn, scanner);
                    break;
                case "instructors":
                    InstructorLessons.instructorLessons(conn, scanner);
                    break;
                default:
                    System.out.println("Error: Invalid command. Please choose from insert, delete, update, trails, rides, lessons, instructors, exit, quit.");
                    break;
            }
        }

        scanner.close();
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
             System.err.println("*** SQLException: Could not close JDBC connection.");
             System.err.println("\tMessage:   " + e.getMessage());
        }
	}

    private static void handleModificationCommand(String command, String[] parts, Scanner scanner, Connection conn) {
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            System.out.println("Error: Missing table name for '" + command + "'. Usage: " + command + " <TABLE_NAME>");
            return;
        }

        String tableName = parts[1].trim().split("\\s+")[0].toUpperCase();

        if (!VALID_TABLES.contains(tableName)) {
            System.out.println("Error: Invalid table name '" + tableName + "'.");
            System.out.println("Valid tables are: " + String.join(", ", VALID_TABLES));
            return;
        }

        switch (command) {
            case "insert":
                handleInsert(tableName, scanner, conn);
                break;
            case "delete":
                handleDelete(tableName, scanner, conn);
                break;
            case "update":
                handleUpdate(tableName, scanner, conn);
                break;
        }
    }

    private static void handleInsert(String tableName, Scanner scanner, Connection conn) {
        List<String> columns = TABLE_SCHEMAS.get(tableName);
        if (columns == null) {
            System.out.println("Error: Schema definition not found for table " + tableName);
            return;
        }

        System.out.println("Inserting into table: " + tableName);
        System.out.println("Please enter values for the following columns:");

        List<String> valuesList = new ArrayList<>();

        for (String column : columns) {
            System.out.print("Enter value for " + column + ": ");
            String value = scanner.nextLine().trim();
            valuesList.add(value);
        }

        String result = RecordManipulation.insert(conn, tableName, valuesList);
        System.out.println("Result: " + result);
    }

    private static void handleDelete(String tableName, Scanner scanner, Connection conn) {
        System.out.println("Deleting from table: " + tableName);
        System.out.print("Enter the WHERE condition (e.g., memID = 10): ");
        String condition = scanner.nextLine().trim();

        if (condition.isEmpty()) {
            System.out.println("Error: Delete condition cannot be empty.");
            System.out.println("If you intend to delete all rows, use a condition like '1=1' (use with extreme caution!).");
            return;
        }

        String result = RecordManipulation.delete(conn, tableName, condition);
        System.out.println("Result: " + result);
    }

    private static void handleUpdate(String tableName, Scanner scanner, Connection conn) {
        List<String> columns = TABLE_SCHEMAS.get(tableName);
         if (columns == null) {
             System.out.println("Error: Schema definition not found for table " + tableName);
             return;
         }

        System.out.println("Updating table: " + tableName);
        System.out.println("Available columns: " + String.join(", ", columns));
        System.out.print("Enter the SET clause(s) (e.g., column1 = newValue1, column2 = 'new text'): ");
        String setClausesInput = scanner.nextLine().trim();

        System.out.print("Enter the WHERE condition (e.g., id = 5): ");
        String condition = scanner.nextLine().trim();

        if (setClausesInput.isEmpty()) {
            System.out.println("Error: SET clauses cannot be empty for an update.");
            return;
        }
        if (condition.isEmpty()) {
            System.out.println("Error: Update condition cannot be empty to prevent accidental update of all rows.");
             System.out.println("If you intend to update all rows, use a condition like '1=1' (use with extreme caution!).");
            return;
        }

        Map<String, String> updates = new HashMap<>();
        String[] clauses = setClausesInput.split(",");
        boolean parseError = false;
        for (String clause : clauses) {
            String[] parts = clause.split("=", 2);
            if (parts.length == 2) {
                String colName = parts[0].trim();
                String value = parts[1].trim();

                boolean isValidColumn = false;
                String cleanColName = colName.startsWith("\"") && colName.endsWith("\"") ? colName.substring(1, colName.length() - 1) : colName;
                 for (String schemaCol : columns) {
                    String cleanSchemaCol = schemaCol.startsWith("\"") && schemaCol.endsWith("\"") ? schemaCol.substring(1, schemaCol.length() - 1) : schemaCol;
                     if (cleanColName.equalsIgnoreCase(cleanSchemaCol)) {
                        isValidColumn = true;
                         colName = schemaCol;
                        break;
                    }
                 }


                if (!isValidColumn) {
                     System.out.println("Warning: Column '" + cleanColName + "' is not explicitly listed in the schema for table " + tableName +". Proceeding anyway.");
                      updates.put(colName, value);
                } else {
                     updates.put(colName, value);
                }
            } else {
                System.out.println("Error: Malformed SET clause: '" + clause + "'. Expected format 'column = value'.");
                parseError = true;
                break;
            }
        }


        if (parseError) {
            return;
        }

        if (updates.isEmpty()) {
            System.out.println("Error: No valid SET clauses provided.");
            return;
        }

        String result = RecordManipulation.update(conn, tableName, updates, condition);
        System.out.println("Result: " + result);
    }
}
