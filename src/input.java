import java.util.Scanner;

    public class Input {
        public static int pouzeCelaCisla(Scanner sc, int min, int max) {
			int cislo = 0;
			try
			{
				cislo = sc.nextInt();
				if (cislo < min || cislo > max) {
					System.out.println("Zadali ste cislo mimo rozsah, zadajte prosim znova.");
					cislo = pouzeCelaCisla(sc, min, max);
				}
			}
			catch(Exception e)
			{
				System.out.println("Nastala vynimka typu "+e.toString());
				System.out.println("zadejte prosim cele cislo ");
				sc.nextLine();
				cislo = pouzeCelaCisla(sc, min, max);
			}
			return cislo;
		}

		public static int pouzeCelaCisla(Scanner sc) {
			int cislo = 0;
			try
			{
				cislo = sc.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("Nastala vynimka typu "+e.toString());
				System.out.println("zadejte prosim cele cislo ");
				sc.nextLine();
				cislo = pouzeCelaCisla(sc);
			}
			return cislo;
		}

    	public static boolean mainMenu(Scanner sc) {
            int volba;
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

            volba=Input.pouzeCelaCisla(sc, 1, 12);
			switch(volba)
			{
				case 1:
                    System.out.println("Vytvorenie novej databaze");
					break;
				case 2:
					System.out.println("Vyberte obor studenta:");
					System.out.println("1 .. Telekomunikacie");
					System.out.println("2 .. Kyberbezpecnost");
					volba=Input.pouzeCelaCisla(sc, 1, 2);
					//Dokoncit vytvorenie studenta
					break;
				case 3:
					System.out.println("Zadajte ID studenta:");
					volba=Input.pouzeCelaCisla(sc);
					//Dokoncit zadanie znamky
					break;
				case 4:
					System.out.println("Zadajte ID studenta:");
					volba=Input.pouzeCelaCisla(sc);
					//Dokoncit vypis informacii o studentovi
					break;
				case 5:
					System.out.println("Zadajte ID studenta:");
					volba=Input.pouzeCelaCisla(sc);
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
					volba=Input.pouzeCelaCisla(sc);
					//Dokoncit ulozenie studenta do suboru
					break;
				case 10:
					System.out.println("Zadajte ID studenta:");
					volba=Input.pouzeCelaCisla(sc);
					//Dokoncit nacitanie studenta zo suboru
					break;
				case 11:
					System.out.println("Zadajte ID studenta:");
					volba=Input.pouzeCelaCisla(sc);
					//Dokoncit odstranenie studenta
					break;
                case 12:
                    if (Database.saveDatabaseToFile()) {
                        System.out.println("Data boli uspesne ulozene.");
                        return false;
                    } 
                    else {
                        System.out.println("Chyba pri ukladani dát.");
                        System.out.println("Zelate si napriek tomu program ukoncit? (1/0)");
                        volba=Input.pouzeCelaCisla(sc, 0, 1);
                        if (volba == 1) {
                            return false;
                        } 
						else if (volba == 0) {
                            System.out.println("Pokracujete v praci s databazou.");
                        }
                    }    
                    break;
                    
            }
            return true;
        } 
}

