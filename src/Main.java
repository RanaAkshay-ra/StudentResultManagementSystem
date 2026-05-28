import java.util.Scanner;
 public class Main{
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 StudentDAO studentDAO = new StudentDAO();
		 ResultDAO resultDAO = new ResultDAO();
		 
		 while (true) {
			 System.out.println("\n===== Student Result Management System =====");
					              System.out.println("1. Add Student");
					              System.out.println("2. View Students");
					              System.out.println("3. Add Marks");
					              System.out.println("4. View Result");
					              System.out.println("5. Exit");
					              System.out.print("Enter your choice: ");
					              
					              int choice = sc.nextInt();
					              sc.nextLine();
					              
					              switch (choice) {
				                  case 1:
				                      System.out.print("Enter name: ");
				                      String name = sc.nextLine();

				                      System.out.print("Enter roll no: ");
				                      String rollNo = sc.nextLine();

				                      System.out.print("Enter course: ");
				                      String course = sc.nextLine();

				                      Student student = new Student(name, rollNo, course);
				                      studentDAO.addStudent(student);
				                      break;

				                  case 2:
				                      studentDAO.viewStudents();
				                      break;

				                  case 3:
				                      System.out.print("Enter student ID: ");
				                      int studentId = sc.nextInt();
				                      sc.nextLine();

				                      System.out.print("Enter subject: ");
				                      String subject = sc.nextLine();

				                      System.out.print("Enter marks: ");
				                      int marks = sc.nextInt();

				                      resultDAO.addMarks(studentId, subject, marks);
				                      break;

				                  case 4:
				                      System.out.print("Enter student ID: ");
				                      int id = sc.nextInt();

				                      resultDAO.viewResult(id);
				                      break;

				                  case 5:
				                      System.out.println("Exiting...");
				                      sc.close();
				                      System.exit(0);

				                  default:
				                      System.out.println("Invalid choice.");
					              }
		 }
	 }
 }