import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class display {
    // Database credentials (change these to match your local setup)
    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "root";
    private static final String PASSWORD = "Bhagya@23";

    public static void main(String[] args) {
        String query = "SELECT id, name, age, course FROM students";

        // try-with-resources automatically closes connections and resources
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("--- Student Records ---");
            System.out.printf("%-5s %-20s %-5s %-20s\n", "ID", "Name", "AGE", "Course");
            System.out.println("----------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age=rs.getInt("age");
                String course = rs.getString("course");

                System.out.printf("%-5d %-20s %-5d %-20s\n", id, name, age, course);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}