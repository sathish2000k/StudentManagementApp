package schoolManagementApp;
import java.sql.SQLException;
import java.util.Scanner;


public class StudentManagementApp{
	enum Operation{
		INSERT,UPDATE,DELETE,READ,EXIT
	}
	public static void main(String[] args) throws SQLException {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to School Management App");	
		System.out.println("Enter INSERT,DELETE,UPDATE,READ,EXIT operation to be done:");
		while(true) {
			String inputOperation = input.nextLine();
			try {
			Operation operation = Operation.valueOf(inputOperation.toUpperCase());
			System.out.println("Executing "+operation+" operation");
			switch(operation) {
			case INSERT:
				System.out.println("Enter student name:");
				String name = input.nextLine();
				System.out.println("Enter student DOB:");
				String DOB = input.nextLine();
				System.out.println("Enter student gender:");
				String gender = input.nextLine();
				System.out.println("Enter student phone number:");
				String phoneNumber = input.nextLine();
				System.out.println("Enter student city:");
				String city = input.nextLine();
				Student student = new Student(name,DOB,gender,phoneNumber,city);
				int result = StudentDAO.insert(student);
				if(result == 1) {
					System.out.println(result+" row inserted");
				}
				else {
					System.out.println("Insertion opertion failed");
				}
				break;
			case UPDATE:
				System.out.println("Enter column name to update:");
				String column = input.nextLine();
				System.out.println("Enter column value to update:");
				String columnValue = input.nextLine();
				System.out.println("Enter student Id to update:");
				int updateId = input.nextInt();
				int updateResult = StudentDAO.update(updateId,column.toUpperCase(),columnValue);
				if(updateResult == 1) {
					System.out.println(updateResult+" row updated");
				}
				else {
					System.out.println("Updation opertion failed");
				}
				break;
			case DELETE:
				System.out.println("Enter student Id to delete:");
				int id = input.nextInt();
				StudentDAO.delete(id);
				int deleteResult = StudentDAO.delete(id);
				if(deleteResult == 0) {
					System.out.println("Deleted Sucessfully");
				}
				else {
					System.out.println("Deletion opertion failed");
				}
				break;
			case READ:
				StudentDAO.read();
				System.out.println("Displayed Sucessfully");
				break;
			case EXIT:
				System.out.println("Exiting School Management App");
				System.exit(0);
			default:
				System.out.println("Invalid operation");
			}	
			}
			catch(IllegalArgumentException exception) {
				continue;
			}
		}
	}
}