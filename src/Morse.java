public class Morse {
    public static String toMorse (String text) {
        String morseCode ="";
        String[] morseAbeceda = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        
        for (char c : text.toUpperCase().toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                morseCode += morseAbeceda[c - 'A'] + " ";
            } 
            else if (c == ' ') {
                morseCode += " ";
            }
            else {
                return "Text obsahuje znaky mimo rozsah A-Z";
            }
        }
        
        return morseCode;
}
}
