package kadai2.問題5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class WordDAO {
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	static String URL = "jdbc:mysql://localhost/testdb/dictionary?useUnicode=true&characterEncoding=utf8";
	static String USER = "testuser";
	static String PW = "testpass";

	public int registWords(List<Word> words) {
		int result = 0;
		try {
			String SQL = "INSERT INTO dictionary VALUES (?, ?)";
			Class.forName("com.mysgl.idbc.Driver");
			con = DriverManager.getConnection(URL, USER, PW);

			for (Word tmp : words) {
				st = con.prepareStatement(SQL);
				st.setString(1, tmp.getEnglish());
				st.setString(2, tmp.getJapanese());
				st. executeUpdate();
				result++;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if ( con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
