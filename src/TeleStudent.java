public class TeleStudent extends Student {

    public TeleStudent(String name1, String name2, int rocnik) {
        super(name1, name2, rocnik);
    }

    @Override
    public String dovednost() {
        
        return Morse.toMorse(getName1() + " " + getName2());

}}
