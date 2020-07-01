package sys.ldk.com.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*这个类的作用就是用来封装获取数据库的连接方法
 *读取数据库配置文件参数
 *关闭连接对象 
 */
public class DBUtil {
	private static String driver;
	private static String name;
	private static String url;
	private static String password;
	private static Connection conn;
	//写成静态代码块static
	static {

		try {
			//加载数据库配置文件
			Properties p=new Properties();
			InputStream in = DBUtil.class.
					getResourceAsStream("db.properties");
			p.load(in);
			//根据k获取v
			driver=p.getProperty("db.driver");
			url=p.getProperty("db.url");
			name=p.getProperty("db.username");
			password=p.getProperty("db.password");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//封装一个获取数据库连接对象的方法
	public static Connection getConn(){
		try {
			//加载驱动
			Class.forName(driver);
			//创建连接对象
			try {
				conn = DriverManager.getConnection(url, name, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return conn;//返回连接对象
	}



	//封装一个关闭连接的方法
	public static void closeConn(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
