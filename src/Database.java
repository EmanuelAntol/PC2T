import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Database {

    private int lastId = 0;
    private Map<Integer, Student> databazaStudentov;

    Database() {
        databazaStudentov = new HashMap<Integer, Student>();
    }

    public int getLastId() {
        return lastId;
    }

    public void addStudent(Student student) {
        lastId++;
        databazaStudentov.put(lastId, student);
        databazaStudentov.get(lastId).setId(lastId);
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

    public float[] getpiemer() {
        float[] priemer = new float[2];
        int pocetTele = 0;
        int pocetKyber = 0;

        for (Student student : databazaStudentov.values()) {
            if (student instanceof TeleStudent) {
                priemer[0] += student.getPriemer();
                pocetTele++;
            } 
            else if (student instanceof KyberStudent) {
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

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> abecedne = new ArrayList<Student>(databazaStudentov.values());
        abecedne.sort(Student::compareTo);
        return abecedne;
    }

    public String saveStudentToFile(Integer ID, Scanner sc) {
        if (!databazaStudentov.containsKey(ID)) {
            return "Student s ID " + ID + " neexistuje.";
        }

        Student student = databazaStudentov.get(ID);
        File subor = new File(ID.toString() + ".txt");
        FileWriter fw = null;
	    BufferedWriter bw = null;

        if (!subor.exists()){
            try {
                subor.createNewFile();
            } 
            catch (Exception e) {
                return "Chyba pri vytvarani suboru.";
            }
        }
        else {
            System.out.println("Subor uz existuje. Zelate si ho prepisat?.");
            System.out.println("1. Ano\n2. Nie");
            int volba = Input.pouzeCelaCisla(sc, 1, 2);
            if (volba == 2){
                return "Ziadne data neboli zapisane";
            }
        }
        

        try {
            fw = new FileWriter(subor);
            bw = new BufferedWriter(fw);

            if (student instanceof TeleStudent) {
                bw.write("Obor: Telekomunikacie\n");
            } 
            else if (student instanceof KyberStudent) {
                bw.write("Obor: Kyberbezpecnost\n");
            }
            bw.write("ID: " + student.getId() + "\n");
            bw.write("name1: " + student.getName1() + "\n");
            bw.write("name2: " + student.getName2() + "\n");
            bw.write("rokNarodenia: " + student.getRocnik() + "\n");
            bw.write("znamky: " + student.getZnamky() + "\n");

        }
        catch (Exception e) {
            return "Chyba pri zapisovani do suboru.";
        }
        finally{
            try {
			    bw.close();
			    fw.close();
		    }
		    catch (IOException e){
			    return "Nastala neocakavana chyba";
		    }
        }
        return "Ulozenie prebehlo uspesne";
    }
    
    public String loadStudentFromFile(Integer ID) {
        if (databazaStudentov.containsKey(ID)) {
            return "Student s ID " + ID + " uz existuje. Pred nacitanim zo suboru ho prosim odstrante.";
        }
        File subor;
        Scanner sc_subor;
        String obor;
        String name1;
        String name2;
        int rocnik;
        int read_id;
        String znamkaString;

        try {
            subor = new File(ID.toString() + ".txt");
            sc_subor = new Scanner(subor);
        }
        catch (Exception e) {
            subor = null;
            sc_subor = null;
            return "Subor s ID " + ID + " neexistuje.";
        }

        try {
            String obory [] = {"Telekomunikacie", "Kyberbezpecnost"};
            obor = sc_subor.nextLine().split(": ")[1].trim().toString();
            if (obor.equals(obory[0])) {
            }
            else if (obor.equals (obory[1])) {  
            }
            else {
                return "Obor v subore je poskodeny.";
            }

            read_id = Integer.parseInt(sc_subor.nextLine().split(": ")[1]);
            if (read_id != ID) {
                return "ID v subore sa nezhoduje so zadanym ID studenta.";
            }

            name1 = sc_subor.nextLine().split(": ")[1];
            name2 = sc_subor.nextLine().split(": ")[1];
            rocnik = Integer.parseInt(sc_subor.nextLine().split(": ")[1]);
            
            if (obor.equals("Telekomunikacie")) {
                databazaStudentov.put(ID, new TeleStudent(name1, name2, rocnik));
                databazaStudentov.get(read_id).setId(read_id);

            } 
            else if (obor.equals("Kyberbezpecnost")) {
                databazaStudentov.put(ID, new KyberStudent(name1, name2, rocnik));
                databazaStudentov.get(read_id);
            }

            znamkaString = sc_subor.nextLine().split(": ")[1];
            String[] znamkyArray = znamkaString.split("");
            for (String znamka : znamkyArray){

                if (znamka.equals("1") || znamka.equals("2") || znamka.equals("3") || znamka.equals("4") || znamka.equals("5")) {
                    databazaStudentov.get(read_id).addZnamka(Integer.parseInt(znamka.trim()));
                }
            }
           
        }
        catch (Exception e) {
            return "Subor je poskodeny.";
        }
        finally {
            sc_subor.close();
        }
        
        sc_subor.close();
        return "Student bol uspesne nacitany zo suboru a pridany do databaze.";
    }

    public boolean saveDatabaseToFile() {
        return true; 
    }

}

