import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Resume {
    private Student student;
    private ArrayList<Education> educations;
    private ArrayList<String> skills;
    private ArrayList<Experience> workExperiences;
    private ArrayList<Experience> extraCurriculars;

    public Resume(Student student, ArrayList<Education> educations, ArrayList<String> skills, ArrayList<Experience> workExperiences, ArrayList<Experience> extraCurriculars) {
        this.educations = educations;
        this.skills = skills;
        this.workExperiences = workExperiences;
        this.extraCurriculars = extraCurriculars;
        this.student = student;
    }

    public Resume(Student student) {
        this.student = student;
        this.educations = new ArrayList<Education>();
        this.skills = new ArrayList<String>();
        this.workExperiences = new ArrayList<Experience>();
        this.extraCurriculars = new ArrayList<Experience>();
    }

    public void addSkill(String skill) {
        skills.add(skill);
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

    public void printResume() throws IOException{
        FileWriter file = new FileWriter("Resume.txt");
        PrintWriter output = new PrintWriter(file);
        output.println(toString());
        output.close();
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
            educationSection += educations.get(i).toString() + "\n";
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
