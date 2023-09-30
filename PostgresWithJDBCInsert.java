import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
public class PostgresWithJDBCInsert {
	public static void main(String[] args) {
		String SQL_INSERT = "INSERT INTO STUDENT (ROLL, NAME, SECTION, CREATED_DATE) VALUES (?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ysj", "ysj", "sejin@1234");
			PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

			preparedStatement.setInt(1, 06);
			preparedStatement.setString(2, "Sejin");
			preparedStatement.setString(3, "Y");
			preparedStatement.setTimestamp(4, new Timestamp(new Date().getTime()));
			preparedStatement.executeUpdate();
			System.out.print("record inserted successfully");
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

