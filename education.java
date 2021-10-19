public class education {
    private String school;
    private int classYear;
    private String major;
    private String minor;
    private double gpa;

    public String toString() {
        return this.school + "\nClass Year: " + this.classYear + "\nMajor: " + this.major +
        "\nMinor: " + this.minor + "\nGPA: " + this.gpa;
    }
}
