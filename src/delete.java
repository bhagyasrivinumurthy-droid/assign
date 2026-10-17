import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class delete {
    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "root";
    private static final String PASSWORD = "Bhagya@23";

    public static void main(String[] args) {
        // ID of the student to delete (Modify this as needed)
        int studentId = 4;

        String query = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Bind value to the placeholder (?)
            pstmt.setInt(1, studentId);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Success: Student record deleted successfully for ID: " + studentId);
            } else {
                System.out.println("Failed: No student found with ID: " + studentId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}