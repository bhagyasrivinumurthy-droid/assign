import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class update {
    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "root";
    private static final String PASSWORD = "Bhagya@23";

    public static void main(String[] args) {
        // Values to update (Modify these as needed)
        int studentId = 3;
        String newCourse = "Computer Science";

        String query = "UPDATE students SET course = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Bind values to the placeholders (?)
            pstmt.setString(1, newCourse);
            pstmt.setInt(2, studentId);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Success: Course updated successfully for Student ID: " + studentId);
            } else {
                System.out.println("Failed: No student found with ID: " + studentId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}