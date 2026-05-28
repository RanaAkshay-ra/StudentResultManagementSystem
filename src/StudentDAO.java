import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {
	public void addStudent(Student student) {
		String sql = "INSERT INTO students(name, roll_no, course) VALUES(?,?,?)";
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, student.getName());
			ps.setString(2, student.getRollNo());
			ps.setString(3, student.getCourse());
			
			int rows = ps.executeUpdate();
			if(rows > 0) {
				System.out.println("Student added successfully.");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void viewStudents() {
		String sql = "SELECT * FROM students";
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("\n--- Student List ---");
			while(rs.next()) {
				System.out.println(
						rs.getInt("student_id") + "|" +
						rs.getString("name") + "|" +
						rs.getString("roll_no") + "|"+
						rs.getString("course")
				);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}