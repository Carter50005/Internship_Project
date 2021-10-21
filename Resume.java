import java.util.ArrayList;

public class Resume {
    private String school;
    private int classYear;
    private String major;
    private String minor;
    private double gpa;
    private ArrayList<String> skills;
    private ArrayList<Experience> workExperiences;
    private ArrayList<Experience> extraCurriculars;

    public Resume() {
        skills = new ArrayList<String>();
        workExperiences = new ArrayList<Experience>();
        extraCurriculars = new ArrayList<Experience>();
    }

    public String getSchool() {
        return this.school;
    }

    public int getClassYear() {
        return this.classYear;
    }

    public String getMajor() {
        return this.major;
    }

    public String getMinor() {
        return this.minor
    }

    public double getGpa() {
        return this.gpa;
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

}
