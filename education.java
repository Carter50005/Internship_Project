public class education {
    private String school;
    private int classYear;
    private String major;
    private String minor;
    private double gpa;

    public education(String school, int classYear, String major, String minor, double gpa) {
        this.school = school;
        this.classYear = classYear;
        this.major = major;
        this.minor = minor;
        this.gpa = gpa;
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
        return this.minor;
    }

    public double getGpa() {
        return this.gpa;
    }

    public String toString() {
        return this.school + "\nClass Year: " + this.classYear + "\nMajor: " + this.major +
        "\nMinor: " + this.minor + "\nGPA: " + this.gpa;
    }

}
