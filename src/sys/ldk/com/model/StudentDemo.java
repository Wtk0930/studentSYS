package sys.ldk.com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sys.ldk.com.entity.Student;
import sys.ldk.com.util.DBUtil;;


/**
 * dao 数据访问层对象
 * @author zwdn
 *
 */

public class StudentDemo {
	
	
	
	public static int addStudent(Student s) throws SQLException{
		Connection conn = DBUtil.getConn();
		String sql = "insert into tb_student(name,password,email)"
		+"values (?,?,?)";
		
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, s.getName());
		ps.setString(2, s.getPassword());
		ps.setString(3, s.getEmail());
	
		ps.executeUpdate();
        
		
		return 0;
	}
	
	
	public static boolean searchStudent(Student s) throws SQLException
	{
		Connection conn = DBUtil.getConn();
		String sql = "select * from tb_student where name="+s.getName()+" and "+"password="
		+s.getPassword();
		
		Statement s1 = conn.createStatement();
		if(s1.executeQuery(sql).next() == false )
			return false;
		
		return true;
	}

}
