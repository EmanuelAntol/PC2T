public class KyberStudent extends Student {

    public KyberStudent(String name1, String name2, int rocnik) {
        super(name1, name2, rocnik);
    }

    @Override
    public String dovednost() {
        return "Kyberbezpecnost";
    }

}
