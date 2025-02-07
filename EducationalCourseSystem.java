class Course {
    String courseName;
    int duration;

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " weeks");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayCourseInfo() {
        System.out.println("Online Course: " + courseName + ", Duration: " + duration + " weeks, Platform: " + platform + ", Recorded: " + isRecorded);
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    public void displayCourseInfo() {
        System.out.println("Paid Online Course: " + courseName + ", Duration: " + duration + " weeks, Platform: " + platform +
                ", Recorded: " + isRecorded + ", Fee: $" + fee + ", Discount: " + discount + "%");
    }
}

public class EducationalCourseSystem {
    public static void main(String[] args) {
        Course course = new Course("Mathematics", 8);
        OnlineCourse onlineCourse = new OnlineCourse("Java Programming", 6, "Udemy", true);
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Data Science", 10, "Coursera", true, 500, 20);

        course.displayCourseInfo();
        onlineCourse.displayCourseInfo();
        paidCourse.displayCourseInfo();
    }
}
