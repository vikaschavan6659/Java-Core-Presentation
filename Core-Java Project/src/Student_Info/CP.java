package Student_Info;
import java.sql.Connection;
import java.sql.DriverManager;

public  class CP {
   static	Connection con;
	public static Connection createC() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage","root","Vikas123@");
			 
		//	String url,user,passworld;
			//con=DriverManager.getConnection(url,user,passworld);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}

}
