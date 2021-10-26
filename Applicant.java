public class Applicant {
    private Student student;
    private ArrayList<String> AdditionalMaterials;

    public Applicant(Student aStudent) {
        this.student = aStudent;
    }
    public Applicant(Student aStudent, ArrayList<String> anAdditionalMaterials) {
        this.student = aStudent;
        this.AdditionalMaterials = anAdditionalMaterials;
    }

    public Student getStudent() {
        return this.student;
    }
    public ArrayList<String> getAdditionalMaterials() {
        return this.AdditionalMaterials;
    }

    public void addAdditionalMaterial(String material) {
        AdditionalMaterials.add(material);
    }
}