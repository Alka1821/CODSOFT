import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int filledSlots;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.filledSlots = 0;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getFilledSlots() {
        return filledSlots;
    }

    public void incrementFilledSlots() {
        filledSlots++;
    }

    public void decrementFilledSlots() {
        filledSlots--;
    }
}

class Student {
    private int id;
    private String name;
    private List<String> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }
}

class CourseDatabase {
    private List<Course> courses;

    public CourseDatabase() {
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayAvailableCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            int availableSlots = course.getCapacity() - course.getFilledSlots();
            System.out.println("Course Code: " + course.getCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("Available Slots: " + availableSlots);
            System.out.println(" ");
        }
    }

    public Course getCourseByCode(String code) {
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null;
    }
}

class StudentDatabase {
    private List<Student> students;

    public StudentDatabase() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}

public class CourseManagementSystem {
    public static void main(String[] args) {
        CourseDatabase courseDB = new CourseDatabase();
        StudentDatabase studentDB = new StudentDatabase();

        
        courseDB.addCourse(new Course("CSE101", "Python Programming", "Learn basic programming concepts", 50, "Mon-Wed-Fri 9:00-10:00"));
        courseDB.addCourse(new Course("MATH201", "Probability & Statistics", "Learn about Statistics", 60, "Tue-Thu 11:00-12:00"));
        courseDB.addCourse(new Course("CS315", "Theory Of Computation", "Learn about model ", 40, "Mon-Wed 14:00-15:00"));

       
        studentDB.addStudent(new Student(12, "Aishwarya"));
        studentDB.addStudent(new Student(25, "Nandini"));
        studentDB.addStudent(new Student(15, "Guriya"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to Course Management System");
            System.out.println("1. Display Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    courseDB.displayAvailableCourses();
                    break;
                case 2:
                    System.out.print("Enter your student ID: ");
                    int studentId = scanner.nextInt();
                    Student student = studentDB.getStudentById(studentId);
                    if (student != null) {
                        System.out.print("Enter course code to register: ");
                        String courseCode = scanner.next();
                        Course courseToRegister = courseDB.getCourseByCode(courseCode);
                        if (courseToRegister != null && courseToRegister.getFilledSlots() < courseToRegister.getCapacity()) {
                            student.registerCourse(courseCode);
                            courseToRegister.incrementFilledSlots();
                            System.out.println("Course registered successfully!");
                        } else {
                            System.out.println("Course not available or no slots left!");
                        }
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter your student ID: ");
                    int studentIdDrop = scanner.nextInt();
                    Student studentDrop = studentDB.getStudentById(studentIdDrop);
                    if (studentDrop != null) {
                        System.out.print("Enter course code to drop: ");
                        String courseCodeDrop = scanner.next();
                        Course courseToDrop = courseDB.getCourseByCode(courseCodeDrop);
                        if (courseToDrop != null && studentDrop.getRegisteredCourses().contains(courseCodeDrop)) {
                            studentDrop.dropCourse(courseCodeDrop);
                            courseToDrop.decrementFilledSlots();
                            System.out.println("Course dropped successfully!");
                        } else {
                            System.out.println("Course not found in your registered courses!");
                        }
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 4:
                    System.out.println("Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

