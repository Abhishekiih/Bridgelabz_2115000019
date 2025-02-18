import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String typeName;

    public CourseType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based");
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private String department;
    private T courseType;

    public Course(String courseName, String department, T courseType) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return department;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return courseName + " (" + department + ") - " + courseType.getTypeName();
    }
}

class University {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public void displayCourses() {
        System.out.println("\nUniversity Course List:");
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        ExamCourse examCourse = new ExamCourse();
        AssignmentCourse assignmentCourse = new AssignmentCourse();
        ResearchCourse researchCourse = new ResearchCourse();

        Course<ExamCourse> mathCourse = new Course<>("Mathematics", "Science", examCourse);
        Course<AssignmentCourse> literatureCourse = new Course<>("English Literature", "Arts", assignmentCourse);
        Course<ResearchCourse> aiResearch = new Course<>("AI Research", "Computer Science", researchCourse);

        University university = new University();
        university.addCourse(mathCourse);
        university.addCourse(literatureCourse);
        university.addCourse(aiResearch);

        university.displayCourses();
    }
}
