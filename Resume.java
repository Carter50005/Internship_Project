import java.util.ArrayList;

public class Resume {
    private Student student;
    private ArrayList<Education> educations;
    private ArrayList<String> skills;
    private ArrayList<Experience> workExperiences;
    private ArrayList<Experience> extraCurriculars;

    public Resume(Student student, String school, int classYear, String major, double gpa, ArrayList<String> skills, ArrayList<Experience> workExperiences, ArrayList<Experience> extraCurriculars) {
        educations = new ArrayList<Education>();
        skills = new ArrayList<String>();
        workExperiences = new ArrayList<Experience>();
        extraCurriculars = new ArrayList<Experience>();
        this.student = student;
    }

    public ArrayList<Education> getEducations() {
        return this.educations;
    }

    public ArrayList<String> getSkills() {
        return this.skills;
    }

    public ArrayList<Experience> getWorkExperiences() {
        return this.workExperiences;
    }

    public ArrayList<Experience> getExtraCurriculars() {
        return this.extraCurriculars;
    }

    public void addWorkExperience(Experience experience) {
        workExperiences.add(experience);
    }

    public void addExtraCurricular(Experience experience) {
        extraCurriculars.add(experience);
    }

    public void addEducation(Education education) {
        educations.add(education);
    }

    public String toString() {
        return student.getFirstName() + " " + student.getLastName() + "\n" + student.getEmail() + " " + 
        student.getPhoneNumber() + "\nEducation:\n" + printEducation() + "Work Experience:\n" + 
        printExperiences(workExperiences) + "Extra Curriculars:\n" + printExperiences(extraCurriculars);
    }

    private String printEducation() {
        String educationSection = "";

        for(int i = 0; i < educations.size(); i++) {
            educationSection = educationSection + educations.get(i).toString() + "\n";
        }

        return educationSection;
    }

    private String printExperiences(ArrayList<Experience> experiences) {
        String experienceSection = "";

        for(int i = 0; i < experiences.size(); i++) {
            experienceSection = experienceSection + experiences.get(i).toString() + "\n";
        }

        return experienceSection;
    }


}
