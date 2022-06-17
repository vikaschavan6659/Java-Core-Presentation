package Student_Info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

public class StudentDao {
	public static boolean insertStudentToDB(Student st)
	{
		boolean f = false;
		try {
			
			// jdbc code...
			Connection con =CP.createC();
			String q = "insert into students(sname,sphone,scity) values(?,?,?)";
			
			//prepared stmt
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the values of parameters
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute
			pstmt.executeUpdate();
			f=true;
			
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}

	public static boolean deleteStudent(int userId) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			
			// jdbc code...
			Connection con = CP.createC();
			String q = "delete from students where sid=?";
			
			//prepared stmt
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the values of parameters
			pstmt.setInt(1, userId);
			
			//execute
			pstmt.executeUpdate();
			f=true;
			
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}

	public static void showAllStudents() {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			
			// jdbc code...
			Connection con = CP.createC();
			String q = "select * from students;";
		 Statement stmt = con.createStatement();
			
			
			// stmt
			stmt.executeQuery(q);
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next())
			{
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString("scity");
				
				System.out.println("ID : "+id);
				System.out.println("NAME : "+name);
				System.out.println("PHONE : "+phone);
				System.out.println("CITY : "+city);
				System.out.println("++++++++++++++++++++++++++");
			}
			
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}