import java.util.List;
import java.util.ArrayList;

public abstract class Student {
    private String name1;
    private String name2;
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

    public void addZnamka(int znamka) {
        znamky.add(znamka);
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

    public abstract String dovednost();
}
