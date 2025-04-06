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

    public float[] getrpiemer() {
        float[] priemer = new float[2];
        int pocetTele = 0;
        int pocetKyber = 0;

        for (Student student : databazaStudentov.values()) {
            if (student instanceof TeleStudent) {
                priemer[0] += student.getPriemer();
                pocetTele++;
            } else if (student instanceof KyberStudent) {
                priemer[1] += student.getPriemer();
                pocetKyber++;
            }
        }
        if (pocetTele > 0) {
            priemer[0] /= pocetTele;
        } else {
            priemer[0] = 0;
        }

        if (pocetKyber > 0) {
            priemer[1] /= pocetKyber;
        } else {
            priemer[1] = 0;
        }

        return priemer;
    }   

    public int[] getPocetStudentov() {
        int [] pocet = new int[2];

        for (Student student : databazaStudentov.values()) {
            if (student instanceof TeleStudent) {
                pocet[0]++;
            }
            else if (student instanceof KyberStudent) {
                pocet[1]++;
            }
        }

        return pocet;
    }

    public boolean saveStudentToFile(int ID) {
        
        return true; 
    }

    public static boolean saveDatabaseToFile() {
        return true; 
    }

}
