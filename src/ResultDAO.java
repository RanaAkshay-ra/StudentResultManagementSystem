import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResultDAO{
	public void addMarks(int studentId, String subject, int marks) {
		String sql = "INSERT INTO result(student_id, subject, marks) VALUES (?, ?, ?)";
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, studentId);
			ps.setString(2, subject);
			ps.setInt(3, marks);
			
			int rows = ps.executeUpdate();
			if(rows > 0) {
				System.out.println("Marks added successfully.");
				
			}
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void viewResult(int studentId) {
		String studentsql = "SELECT * FROM students WHERE student_id = ?";
		String resultsql = "SELECT * FROM result WHERE student_id = ?";
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement studentPs = con.prepareStatement(studentsql);
			studentPs.setInt(1, studentId);
			ResultSet studentRs = studentPs.executeQuery();
			
			if(!studentRs.next()) {
				System.out.println("Student not found.");
				con.close();
				return;
			}
			System.out.println("\n--- Student Result ---");
			System.out.println("Name: " + studentRs.getString("name"));
			System.out.println("Roll No: " + studentRs.getString("roll_no"));
			System.out.println("Course:" + studentRs.getString("course"));
			
			PreparedStatement resultPs = con.prepareStatement(resultsql);
			resultPs.setInt(1, studentId);
			ResultSet resultRs = resultPs.executeQuery();
			
			int total =0;
			int subjectCount = 0;
			
			System.out.println("\nSubjects:");
			
			while (resultRs.next()) {
				String subject = resultRs.getString("subject");
				int marks = resultRs.getInt("marks");
				
				System.out.println(subject + ": " + marks);
				
				total += marks;
				subjectCount++;
			}
			if(subjectCount == 0) {
				System.out.println("No marks found.");
			} else {
				double percentage = total /(double) subjectCount;
				String grade = calculateGrade(percentage);
				System.out.println("\nTotal Marks:" + total);
				
				System.out.println("Percentage:" + percentage);
				System.out.println("Grade:" + grade);
				
			}
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private String calculateGrade(double percentage) {
		if (percentage >=90) {
			return "A+";
		} else if (percentage >=80) {
			return "A";
		} else if (percentage >=70) {
			return "B";
		} else if (percentage >=60) {
			return "C";
		} else if (percentage >=50) {
			return "D";
		} else {
			return "Fail";
		}
	}
}