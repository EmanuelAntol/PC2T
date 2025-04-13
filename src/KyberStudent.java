public class KyberStudent extends Student {

    public KyberStudent(String name1, String name2, int rocnik) {
        super(name1, name2, rocnik);
    }

    @Override
    public int hashCode() {
        String meno = name1.toLowerCase() + " " + name2.toLowerCase();
        return meno.hashCode();
    }

    @Override
    public String dovednost() {
        Integer result = hashCode();
        return result.toString();
    }


}
