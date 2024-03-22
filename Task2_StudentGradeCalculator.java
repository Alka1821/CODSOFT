import java.util.Scanner;

public class Task2_StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the marks of(out of 100)each subject.");
        int numSubjects = 5;
        int totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("enter the marks obtained in Subject " + i + ": ");
            int marks = sc.nextInt();
            totalMarks += marks;
        }

        System.out.println("Total Marks: " + totalMarks);

        double averagePercentage = (double) totalMarks / numSubjects;
        System.out.println("Average Percentage: " + averagePercentage + "%");

        char grade;
        if (averagePercentage >= 95) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 50) {
            grade = 'C';
        } else {
            grade = 'D';
        }

        System.out.println("Grade: " + grade);
        sc.close();
    }
}
