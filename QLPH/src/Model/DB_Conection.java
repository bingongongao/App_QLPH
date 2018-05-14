package Model;

import java.util.Vector;
import java.sql.*;

public class DB_Conection {
	public static int conect(String ROOM, String CLASS, String STATE, String DETAIL) throws SQLException, ClassNotFoundException {
		
		String tmpp = ROOM.substring(3, 5);
		ROOM = ROOM.substring(0, 3);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql1 = "UPDATE `nha6` SET `Class`='"+CLASS+"',`State`='"+STATE+"',`Detail`='"+DETAIL+"' WHERE `Room`='"+ROOM+"';";
			String sql2 = "UPDATE `nha7` SET `Class`='"+CLASS+"',`State`='"+STATE+"',`Detail`='"+DETAIL+"' WHERE `Room`='"+ROOM+"';";
			String dbURL = "jdbc:mysql://50.62.209.83:3306/appql?useUnicode=yes&characterEncoding=UTF-8";
			String username = "huanthemenk55";
			String password = "abc123";
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			Statement st = (Statement) conn.createStatement();
			if(tmpp.equals("N6")) {
				int rs1 = ((java.sql.Statement) st).executeUpdate(sql1);
				return rs1;
			}
			else {
				int rs2 = ((java.sql.Statement) st).executeUpdate(sql2);
				return rs2;
			}
		} catch (SQLException err) {
			System.out.println(err);
			return 0;
		}
	}

}
