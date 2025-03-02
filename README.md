FarmLine Project Documentation
Overview
FarmLine is a Java-based application that leverages JavaFX for the user interface and MySQL for database management. The project is built using Maven for dependency management and build automation.


Project Structure
src/main/java/com/farmline/farmline/MainApp.java: The main entry point of the application.
src/main/java/com/farmline/farmline/services/DatabaseService.java: Manages database connections.
src/main/java/com/farmline/farmline/services/UserService.java: Handles user registration and login functionalities.
pom.xml: Maven configuration file.
Dependencies
The project uses the following dependencies:


MySQL Connector/J: mysql:mysql-connector-java:8.0.33
JavaFX: org.openjfx:javafx-controls:19.0.2, org.openjfx:javafx-fxml:19.0.2, org.openjfx:javafx-web:19.0.2, org.openjfx:javafx-swing:19.0.2, org.openjfx:javafx-media:19.0.2
ControlsFX: org.controlsfx:controlsfx:11.2.1
FormsFX: com.dlsc.formsfx:formsfx-core:11.6.0
ValidatorFX: net.synedra:validatorfx:0.5.0
Ikonli: org.kordamp.ikonli:ikonli-javafx:12.3.1
BootstrapFX: org.kordamp.bootstrapfx:bootstrapfx-core:0.4.0
TilesFX: eu.hansolo:tilesfx:21.0.3
FXGL: com.github.almasb:fxgl:17.3
JUnit: org.junit.jupiter:junit-jupiter-api:5.10.2, org.junit.jupiter:junit-jupiter-engine:5.10.2
JSON: org.json:json:20231013
Configuration
Database Configuration
The database connection details are configured in DatabaseService.java:
URL: jdbc:mysql://localhost:3307/farmers_market
User: root
Password: (empty by default, replace with your MySQL password)
Maven Configuration
The pom.xml file includes all necessary dependencies and plugins. The JavaFX Maven plugin is configured to run the application with mvn clean javafx:run.


Services
DatabaseService
Manages the connection to the MySQL database.

public class DatabaseService {
    private static final String DB_URL = "jdbc:mysql://localhost:3307/farmers_market";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}

UserService
Handles user registration and login.
public class UserService {
    public boolean registerUser(String username, String password) {
        try (Connection conn = DatabaseService.getConnection()) {
            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean loginUser(String username, String password) {
        try (Connection conn = DatabaseService.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            return stmt.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
Running the Application
To run the application, use the following Maven command:
mvn clean javafx:run
