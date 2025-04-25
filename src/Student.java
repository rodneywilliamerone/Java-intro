import java.util.ArrayList;
import java.util.List;

public class Student {
    String StudentID;
    String FullName;
    ArrayList<Integer> Grades;

    Student(String StudentID, String FullName, ArrayList<Integer> Grades) {
        this.StudentID = StudentID;
        this.FullName = FullName;
        this.Grades = Grades;
    }

    String getStudentID() {
        return StudentID;
    }
    String findStudentByID(){
        return  StudentID;
    }

    String getFullName() {
        return FullName;
    }

    void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public List<Integer> getGrades() {
        return Grades;
    }

    void addGrade(int Grade) {
        if (Grade >= 0 && Grade <= 100) {
            this.Grades.add(Grade);
        } else {
            System.out.println("Our system only reads grades in the range, 0-100.");
        }
    }

    double calculateAverage() {
        if (Grades.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int Grade : Grades) {
            sum = sum + Grade;
        }
        return (double) sum / Grades.size();
    }

    String getPerformanceRemark() {
        double average = calculateAverage();
        String response = "";
        if (average >= 90) {
            response = "Excellent. ";
        } else if (average >= 70) {
            response = "Good. ";
        } else if (average >= 50) {
            response = "Passed. ";
        } else if (average < 50) {
            response = "Failed. ";
        }
        return response;
    }
}
