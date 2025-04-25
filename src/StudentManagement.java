import javax.xml.stream.events.StartDocument;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("*****STUDENT GRADE MANAGEMENT SYSTEM*****");
            System.out.println("1.Register new student. ");
            System.out.println("2.View all registered students. ");
            System.out.println("3.Add grades for a student. ");
            System.out.println("4.View grades & average. ");
            System.out.println("5.Update student details. ");
            System.out.println("6.Delete a student. ");
            System.out.println("7.Exit the application. ");
            System.out.println("-----ENTER YOUR CHOICE-----");

            try {
                choice = scanner.nextInt();
            } catch (ArithmeticException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 7.");
                scanner.next();
                choice = 0;
                continue;
            }
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    viewRegisteredStudents();
                    break;
                case 3:
                    addGrades();
                    break;
                case 4:
                    viewGradesandAverage();
                    break;
                case 5:
                    UpdateStudentDetails();
                    break;
                case 6:
                    deleteStudent();
                    break;
                case 7:
                    System.out.println("Signed out. ");
                    break;
                default:
                    System.out.println("Invalid! Please try again. ");
            }
        } while (choice != 7);
    }

    private static void registerStudent() {
        System.out.println("Please proceed to register the new student.");
        System.out.println("Enter Student ID: ");
        String studentID = scanner.nextLine();
        System.out.println("Enter Full Name: ");
        String fullName = scanner.nextLine();

        //Checking if student with same ID exists.
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                System.out.println("Student with ID " + studentID + " already exists.");
                return;
            }
        }
        Student newStudent = new Student(studentID,fullName,new ArrayList<>());
        students.add(newStudent);
        System.out.println("Student " + fullName + " registered successfully with ID: " + studentID);
    }
    private  static void viewRegisteredStudents() {
        System.out.println("Registered students: ");
        if (students.isEmpty()) {
            System.out.println("No students registered yet. ");
            return;
        }
        for (Student student : students) {
            if (student.getStudentID().equals(student.StudentID)) {
                System.out.println("Student ID: " + student.getStudentID() + ", Name: " + student.getFullName());
                return;
            } else {
                System.out.println("Student not found. ");
                return;
            }
        }
    }

    private static void addGrades() {
        System.out.println("Please proceed to add grades for the student. ");
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();

        Student student = findStudentByID();
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println("Enter grades (enter 900 to finish):");
        int grade;
        try {
            while ((grade = scanner.nextInt()) != 900) {
                student.addGrade(grade);
            }
        } catch (ArithmeticException e) {
            System.out.println("Invalid input. Please enter a valid integer for the grade, or 900 to finish.");
            scanner.next();
        }
        scanner.nextLine();
        System.out.println("Grades added successfully for student: " + student.getFullName());
    }

    private static  void viewGradesandAverage(){
        System.out.println("Please proceed to view the student's grades and average. ");
        System.out.println("Enter student ID: ");
        String studentID=scanner.nextLine();

        Student student= findStudentByID();
        if(student != null){
            System.out.println("Grades for "+student.getFullName()+" with ID "+student.getStudentID()+":");
            if(student.getGrades().isEmpty()) {
                System.out.println("No grades recorded yet! ");
            }else{
                System.out.println(student.getGrades());
                System.out.println("Average grade: "+String.format("%.2f ",student.calculateAverage()));
                System.out.println("Performance remark: "+student.getPerformanceRemark());
            }
        }
    }
    private static void UpdateStudentDetails() {
        System.out.println("Please proceed to update student details. ");
        System.out.println("Enter the Student ID to update: ");
        String studentID = scanner.nextLine();

        Student student = findStudentByID();
        if (student != null) {
            System.out.println("Enter new full name: ");
            String newFullName = scanner.nextLine();
            student.setFullName(newFullName);
            System.out.println("Updated student name: " + student.getFullName());
        }
    }
    private static void deleteStudent() {
        System.out.println("Please proceed to delete a student. ");
        System.out.println("Enter Student ID to delete");
        String studentID = scanner.nextLine();

        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student with ID " + studentID + " " + studentToRemove.getFullName() + " has been successfully deleted.");
        } else {
            System.out.println("Student with ID " + studentID + " not found. ");
        }
    }
    private static Student findStudentByID(){
        for (Student student : students) {
            if (student.getStudentID().equals(student.StudentID)){
                return student;
            }
        }
        return null;
    }}







