import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private static ArrayList<User> users;
    private static ArrayList<Student> students;
    private static ArrayList<Employer> employers;
    private static ArrayList<Admin> admins;

    private UserList() {
        if(DataLoader.getUsers() != null) {
            users = DataLoader.getUsers();
        }
        else {
            users = new ArrayList<User>();
        }
        students = setStudents();
        employers = setEmployers();
        admins = setAdmins();
    }

    private ArrayList<Student> setStudents() {
        if(DataLoader.getStudents() == null) {
            return new ArrayList<Student>();
        }
        return DataLoader.getStudents();
    }

    private ArrayList<Employer> setEmployers() {
        if(DataLoader.getEmployers() == null) {
            return new ArrayList<Employer>();
        }
        return DataLoader.getEmployers();
    }

    private ArrayList<Admin> setAdmins() {
        if(DataLoader.getAdmins() == null) {
            return new ArrayList<Admin>();
        }
        return DataLoader.getAdmins();
    }

    public static UserList getInstance() {
        if(userList == null) {
            return new UserList();
        }
        return userList;
    }

    public User login(String username, String password) {
        for(int i=0;i<users.size();i++) {
            if(users.get(i).getUsername().equalsIgnoreCase(username) && users.get(i).getPassword().equalsIgnoreCase(password)) {
                return users.get(i);
            }
        }
        return null;
    }

    public User findUser(String uUID) {
        for(int i=0;i<users.size();i++) {
            if(users.get(i).getUUID() == uUID) {
                return users.get(i);
            }
        }
        return null;
    }

    public User findType() {
        return null;
    }

    public boolean findAccount(String username, String password) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUsername() == username && users.get(i).getPassword() == password) {
                return true;
            }
        }
        return false;
    }
    public boolean containsUser(String username) {
        for(int i=0;i<users.size();i++) {
            if(users.get(i).getUsername() == username) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public ArrayList<Employer> getEmployers() {
        return this.employers;
    }

    public void addResume(Student student, Resume resume) {
        for(Student aStudent : students) {
            if(aStudent.getUUID().equalsIgnoreCase(student.getUUID())) {
                aStudent.addResume(resume);
            }
        }
    }

    public ArrayList<Admin> getAdmins() {
        return this.admins;
    }

    public void addStudent(Student student) {
        users.add(student);
        students.add(student);
    }

    public void addEmployer(Employer employer) {
        users.add(employer);
        employers.add(employer);
    }

}
