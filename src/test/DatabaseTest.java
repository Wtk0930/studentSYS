package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sys.ldk.com.util.DBUtil;

public class DatabaseTest {
	public static void main(String[] args) throws SQLException {
		
		Connection conn = DBUtil.getConn();
		String sql = "insert into tb_student(id,name,password,email,sex)"
				+"values (?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, 1);
		ps.setString(2,"");
		ps.setString(3, "");
		ps.setString(4, "");
		ps.
		ps.executeUpdate();
	}

}
