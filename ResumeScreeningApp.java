import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    @Override
    public String toString() {
        return candidateName + " - Applying for: " + jobRole.getRoleName();
    }
}

class ResumeScreeningSystem {
    private List<Resume<? extends JobRole>> resumes = new ArrayList<>();

    public void addResume(Resume<? extends JobRole> resume) {
        resumes.add(resume);
    }

    public void processResumes() {
        System.out.println("\nProcessing Resumes:");
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println("Screening: " + resume);
        }
    }

    public static <T extends JobRole> void evaluateResume(Resume<T> resume) {
        System.out.println("Evaluating Resume for " + resume.getCandidateName() + " - Role: " + resume.getJobRole().getRoleName());
    }
}

public class ResumeScreeningApp {
    public static void main(String[] args) {
        SoftwareEngineer softwareEngineer = new SoftwareEngineer();
        DataScientist dataScientist = new DataScientist();
        ProductManager productManager = new ProductManager();

        Resume<SoftwareEngineer> resume1 = new Resume<>("Alice Johnson", softwareEngineer);
        Resume<DataScientist> resume2 = new Resume<>("Bob Smith", dataScientist);
        Resume<ProductManager> resume3 = new Resume<>("Charlie Brown", productManager);

        ResumeScreeningSystem screeningSystem = new ResumeScreeningSystem();
        screeningSystem.addResume(resume1);
        screeningSystem.addResume(resume2);
        screeningSystem.addResume(resume3);

        screeningSystem.processResumes();

        ResumeScreeningSystem.evaluateResume(resume1);
        ResumeScreeningSystem.evaluateResume(resume2);
        ResumeScreeningSystem.evaluateResume(resume3);
    }
}
