package Student_Info;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class start {
	 public static void main (String []args) throws  IOException {
			// TODO Auto-generated method stub
			System.out.println("Welcome to student Management App");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.println("Press 1 to add student");
				System.out.println("Press 2 to delete the student");
				System.out.println("Press 3 to display the student");
				System.out.println("Press 4 to exit");
				int c = Integer.parseInt(br.readLine());
				
				if(c==1)
				{
					//add student
					System.out.println("Enter user name : ");
					String name = br.readLine();
					
					System.out.println("Enter user phone : ");
					String phone = br.readLine();
					
					System.out.println("Enter user city : ");
					String city = br.readLine();
					
					//create student object to store student
					Student st = new Student(name,phone,city);
					boolean answer = StudentDao.insertStudentToDB(st);
					if(answer)
					{
						System.out.println("Student is successfully added...");
					}else
					{
						System.out.println("something went wrong..");
					}
					
					System.out.println(st);
					
					
				}
				else if(c==2)
				{
					//delete student
					System.out.println("Enter student id to delete : ");
					int userId = Integer.parseInt(br.readLine());
					boolean f = StudentDao.deleteStudent(userId);
					if(f)
					{
						System.out.println("Deleted");
					}else
					{
						System.out.println("something went wrong...");
					}
				}
				else if(c==3)
				{
					//display student
					StudentDao.showAllStudents();
				}
				else if(c==4)
				{
					//exit
					break;
				} else {
					
				}
			}
			System.out.println("Thank you for using this application");

		}

	}