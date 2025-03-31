import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        Boolean run = true;
        int volba;

        while (run) {
            System.out.println("Vyberte pozadovanu cinnost:");
			System.out.println("1 .. Vytvorenie novej databaze studentov");
			System.out.println("2 .. Novy student");
			System.out.println("3 .. Pridat známku");
			System.out.println("4 .. Vypis informacii o studentovi");
			System.out.println("5 .. Spustit schopnost studenta");
			System.out.println("6 .. Vypis vsetkych studentov");
			System.out.println("7 .. Vypis primeru podla oboru");
			System.out.println("8 .. Vypis pocet studentov v oboroch");
			System.out.println("9 .. Ulozit studenta do suboru");
			System.out.println("10 .. Nacitat studenta zo suboru");
			System.out.println("11 .. Odstranit studenta");
            System.out.println("12 .. Koniec");
        	
			volba=input.pouzeCelaCisla(sc);
			switch(volba)
			{
				case 1:
                    System.out.println("Vytvorenie novej databaze");
					break;
				case 2:
					System.out.println("Vyberte obor studenta:");
					System.out.println("1 .. Telekomunikacie");
					System.out.println("2 .. Kyberbezpecnost");
					volba=input.pouzeCelaCisla(sc);
					//Dokoncit vytvorenie studenta
					break;
				case 3:
					System.out.println("Zadajte ID studenta:");
					volba=input.pouzeCelaCisla(sc);
					//Dokoncit zadanie znamky
					break;
				case 4:
					System.out.println("Zadajte ID studenta:");
					volba=input.pouzeCelaCisla(sc);
					//Dokoncit vypis informacii o studentovi
					break;
				case 5:
					System.out.println("Zadajte ID studenta:");
					volba=input.pouzeCelaCisla(sc);
					//Dokoncit urobenie schopnosti studenta
					break;
				case 6:
					System.out.println("Vsetci studenti:");
					//Dokoncit vypis vsetkych studentov
					break;
				case 7:
					System.out.println("Priemer oboru telekomunikacie je     .");
					System.out.println("Priemer oboru kyberbezpecnost je     .");
					//Dokoncit vypis priemeru podla oboru
					break;
				case 8:
					System.out.println("Pocet studentov v obore telekomunikacie je     .");
					System.out.println("Pocet studentov v obore kyberbezpecnost je     .");
					//Dokoncit vypis pocet studentov v oboroch
					break;
				case 9:
					System.out.println("Zadajte ID studenta:");
					volba=input.pouzeCelaCisla(sc);
					//Dokoncit ulozenie studenta do suboru
					break;
				case 10:
					System.out.println("Zadajte ID studenta:");
					volba=input.pouzeCelaCisla(sc);
					//Dokoncit nacitanie studenta zo suboru
					break;
				case 11:
					System.out.println("Zadajte ID studenta:");
					volba=input.pouzeCelaCisla(sc);
					//Dokoncit odstranenie studenta
					break;
                case 12:
                    if (true) {
                        System.out.println("Data boli uspesne ulozene.");
                        run = false;
                    } else {
                        System.out.println("Chyba pri ukladani dát.");
                        System.out.println("Zelate si napriek tomu program ukoncit? (1/0)");
                        volba=input.pouzeCelaCisla(sc);
                        if (volba == 1) {
                            run = false;
                        } 
						else if (volba == 0) {
                            System.out.println("Pokracujete v praci s databazou.");
                        }
                    }    
                    break;
            }        
        }
        sc.close();
    }
}