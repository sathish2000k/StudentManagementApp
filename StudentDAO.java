package schoolManagementApp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class StudentDAO {
	final int NAMEINDEX = 2;
	final int DOBINDEX = 3;
	final int GENDERINDEX = 4;
	final int PHONENUMBERINDEX = 5;
	final int CITYINDEX = 6;
	
	
	public static int insert(Student student) throws SQLException{
		int result = 0;
		try {	
			Connection connection = DatabaseUtil.sqlConnection(); 
			if(connection!=null) {
				System.out.println("Connection established");
			}	
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT into studentdetails (StudentName, DOB, Gender, PhoneNumber, City) VALUES (?,?,?,?,?) ");
			preparedStatement.setString(1, student.name);
			preparedStatement.setString(2, student.DOB);
			preparedStatement.setString(3, student.gender);
			preparedStatement.setString(4, student.phoneNumber);
			preparedStatement.setString(5, student.city);
			result = preparedStatement.executeUpdate();
		}
		catch(Exception exception){
			System.err.println(exception);
		}
		return result;
	}
	
	public static void read() {
		try {
			Connection connection = DatabaseUtil.sqlConnection();
			Statement statement = connection.createStatement();
			if(connection!=null) {
				System.out.println("Connection established");
			}
			String sql = "SELECT * From studentdetails";
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("Rollno:\tName:\tDOB\tGender\tPhoneNumber\tcity");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t"+resultSet.getString(6));
			}
			resultSet.close();			
		}
		catch(Exception exception) {
			System.err.println(exception);
		}
	}
	
	public static int delete(int id) {
		int result;
		try {
			Connection connection = DatabaseUtil.sqlConnection();
			if(connection!=null) {
				System.out.println("Connection established");
			}
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE from studentdetails where ID = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate();
						
		}
		catch(Exception exception) {
			result=1;
			System.err.println(exception);
		}
		return result; 
	}

	public static int update(int updateId, String column, String columnValue) {
		int result = 0;
		try {
		Connection connection = DatabaseUtil.sqlConnection();
		if(connection!=null) {
			System.out.println("Connection established");
		}
		switch(column) {
		case "NAME":
			PreparedStatement preparedStatementName = connection.prepareStatement("UPDATE studentdetails SET StudentName = ? WHERE ID = ?");
			preparedStatementName.setString(1, columnValue);
			preparedStatementName.setInt(2, updateId);
			result = preparedStatementName.executeUpdate();
			break;
		case "DOB":
			PreparedStatement preparedStatementDOB = connection.prepareStatement("UPDATE studentdetails SET DOB = ? WHERE ID = ?");
			preparedStatementDOB.setString(1, columnValue);
			preparedStatementDOB.setInt(2, updateId);
			result = preparedStatementDOB.executeUpdate();
			break;
		case "GENDER":
			PreparedStatement preparedStatementGender = connection.prepareStatement("UPDATE studentdetails SET Gender = ? WHERE ID = ?");
			preparedStatementGender.setString(1, columnValue);
			preparedStatementGender.setInt(2, updateId);
			result = preparedStatementGender.executeUpdate();
			break;
		case "PHONENUMBER":
			PreparedStatement preparedStatementPhoneNumber = connection.prepareStatement("UPDATE studentdetails SET PhoneNumber = ? WHERE ID = ?");
			preparedStatementPhoneNumber.setString(1, columnValue);
			preparedStatementPhoneNumber.setInt(2, updateId);
			result = preparedStatementPhoneNumber.executeUpdate();
			break;
		case "CITY":
			PreparedStatement preparedStatementCity = connection.prepareStatement("UPDATE studentdetails SET City = ? WHERE ID = ?");
			preparedStatementCity.setString(1, columnValue);
			preparedStatementCity.setInt(2, updateId);
			result = preparedStatementCity.executeUpdate();
			break;
		}
		}
	catch(Exception exception) {
		System.err.println(exception);
	}
	return result;
	}	

}
