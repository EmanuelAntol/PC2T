import java.util.Map;
import java.util.HashMap;


public class Database {

    private int lastId = 0;
    private Map<Integer, Student> databazaStudentov;

    Database() {
        databazaStudentov = new HashMap<Integer, Student>();
    }

    public int getLastId() {
        return lastId;
    }

    public boolean addStudent(Student student, int skupina) {
        if (student != null) {
            lastId++;
            databazaStudentov.put(lastId, student);
            return true;
        }
        return false;
    }

    public boolean removeStudent(int ID) {
        if (databazaStudentov.containsKey(ID)) {
            databazaStudentov.remove(ID);
            return true;
        }
        return false;
    }

    public Student getStudent(int ID) {
        if (databazaStudentov.containsKey(ID)) {
            return databazaStudentov.get(ID);
        }
        return null;
    }

    public boolean saveStudentToFile(int ID) {
        
        return true; 
    }
    public static boolean saveDatabaseToFile() {
        return true; 
    }

}
