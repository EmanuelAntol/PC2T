import java.util.List;
import java.util.ArrayList;

public abstract class Student implements Comparable<Student> {
    protected String name1;
    protected String name2;
    private int id;
    private int rocnik;
    List<Integer> znamky;

    public Student(String name1, String name2, int rocnik) {
        this.name1 = name1;
        this.name2 = name2;
        this.rocnik = rocnik;
        this.znamky = new ArrayList<>();
    }
    
    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public int getRocnik() {
        return rocnik;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public void setRocnik(int rocnik) {
        this.rocnik = rocnik;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addZnamka(int znamka) {
        znamky.add(znamka);
    }

    public List<Integer> getZnamky() {
        return znamky;
    }

    public float getPriemer() {
        if (znamky.isEmpty()) {
            return 0;
        }
        float suma = 0;
        for (int znamka : znamky) {
            suma += znamka;
        }
        return suma / znamky.size();
    }

    @Override
    public int compareTo(Student other) {
        if (this.name2.compareTo(other.name2) < 0) {
            return -1;
        } 
        else if (this.name2.compareTo(other.name1) > 0) {
            return 1;
        } 
        else {
            return 0;
        }
    
    }

    @Override
    public String toString() {

        if (this instanceof TeleStudent) {
            return "ID: " + id + ", Meno: " + name1 + ", Priezvisko: " + name2 + ", Rocnik: " + rocnik + ", Priemer: " + getPriemer() + ", Obor: Telekomunikacie";
        } 
        else if (this instanceof KyberStudent) {
            return "ID: " + id + ", Meno: " + name1 + ", Priezvisko: " + name2 + ", Rocnik: " + rocnik + ", Priemer: " + getPriemer() + ", Obor: Kyberbezpecnost";
        }
        else {
            return null;
        }
          
    }

    public abstract String dovednost();
}
