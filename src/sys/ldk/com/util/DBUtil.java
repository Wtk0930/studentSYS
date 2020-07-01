package sys.ldk.com.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*���������þ���������װ��ȡ���ݿ�����ӷ���
 *��ȡ���ݿ������ļ�����
 *�ر����Ӷ��� 
 */
public class DBUtil {
	private static String driver;
	private static String name;
	private static String url;
	private static String password;
	private static Connection conn;
	//д�ɾ�̬�����static
	static {

		try {
			//�������ݿ������ļ�
			Properties p=new Properties();
			InputStream in = DBUtil.class.
					getResourceAsStream("db.properties");
			p.load(in);
			//����k��ȡv
			driver=p.getProperty("db.driver");
			url=p.getProperty("db.url");
			name=p.getProperty("db.username");
			password=p.getProperty("db.password");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//��װһ����ȡ���ݿ����Ӷ���ķ���
	public static Connection getConn(){
		try {
			//��������
			Class.forName(driver);
			//�������Ӷ���
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


		return conn;//�������Ӷ���
	}



	//��װһ���ر����ӵķ���
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
