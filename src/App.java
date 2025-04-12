import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        Database Database = new Database();
		boolean run = true;
        

        while (run) {
            int volba;
            System.out.println("Vyberte pozadovanu cinnost:");
            System.out.println("1 .. Novy student");
            System.out.println("2 .. Pridat známku");
            System.out.println("3 .. Vypis informacii o studentovi");
            System.out.println("4 .. Spustit schopnost studenta");
            System.out.println("5 .. Vypis vsetkych studentov");
            System.out.println("6 .. Vypis primeru podla oboru");
            System.out.println("7 .. Vypis pocet studentov v oboroch");
            System.out.println("8 .. Ulozit studenta do suboru");
            System.out.println("9 .. Nacitat studenta zo suboru");
            System.out.println("10 .. Odstranit studenta");
            System.out.println("11 .. Koniec");

            volba=Input.pouzeCelaCisla(sc, 1, 12);
			switch(volba)
			{
				case 1:
					System.out.println("Vyberte obor studenta:");
					System.out.println("1 .. Telekomunikacie");
					System.out.println("2 .. Kyberbezpecnost \n");

					volba=Input.pouzeCelaCisla(sc, 1, 2);

					System.out.println("Zadajte meno studenta:");
					String meno=Input.textIn(sc);
					System.out.println("Zadajte priezvisko studenta:");
					String priezvisko=Input.textIn(sc);
					System.out.println("Zadajte rok narodenia studenta:");
					int rokNarodenia=Input.pouzeCelaCisla(sc);

                    if (volba == 1) {
                        Database.addStudent(new TeleStudent(meno, priezvisko, rokNarodenia));
                    } else if (volba == 2) {
                        Database.addStudent(new KyberStudent(meno, priezvisko, rokNarodenia));
                    }
                    System.out.println("\n Student bol uspesne vytvoreny. Studentovi bolo pridelene ID:  " + Database.getLastId()+ " \n");    
					
                    sc.nextLine();
					break;

				case 2:
					System.out.println("Zadajte ID studenta:");
					volba=Input.pouzeCelaCisla(sc);
					System.out.println("Zadajte znamku studenta:");
                    int znamka=Input.pouzeCelaCisla(sc, 1, 5);
                    
                    if (Database.getStudent(volba) != null) {
                        Database.getStudent(volba).addZnamka(znamka);
                        System.out.println("Znamka bola uspesne pridana. \n");
                    } else {
                        System.out.println("Student s ID " + volba + " neexistuje. \n");
                    }

                    sc.nextLine();
					break;
				case 3:
					System.out.println("Zadajte ID studenta:");
					volba=Input.pouzeCelaCisla(sc);
					//Dokoncit vypis informacii o studentovi
					break;
				case 4:
					System.out.println("Zadajte ID studenta:");
					volba=Input.pouzeCelaCisla(sc);
					//Dokoncit urobenie schopnosti studenta
					break;
				case 5:
					System.out.println("Vsetci studenti:");
					//Dokoncit vypis vsetkych studentov
					break;
				case 6:
					System.out.println("Priemer oboru telekomunikacie je     .");
					System.out.println("Priemer oboru kyberbezpecnost je     .");
					//Dokoncit vypis priemeru podla oboru
					break;
				case 7:
					System.out.println("Pocet studentov v obore telekomunikacie je     .");
					System.out.println("Pocet studentov v obore kyberbezpecnost je     .");
					//Dokoncit vypis pocet studentov v oboroch
					break;
				case 8:
					System.out.println("Zadajte ID studenta:");
					volba=Input.pouzeCelaCisla(sc);
					//Dokoncit ulozenie studenta do suboru
					break;
				case 9:
					System.out.println("Zadajte ID studenta:");
					volba=Input.pouzeCelaCisla(sc);
					//Dokoncit nacitanie studenta zo suboru
					break;
				case 10:
					System.out.println("Zadajte ID studenta:");
					volba=Input.pouzeCelaCisla(sc);
					//Dokoncit odstranenie studenta
					break;
                case 11:
                    if (Database.saveDatabaseToFile()) {
                        System.out.println("Data boli uspesne ulozene.");
                        run = false;
                    } 
                    else {
                        System.out.println("Chyba pri ukladani dát.");
                        System.out.println("Zelate si napriek tomu program ukoncit? (1/0)");
                        volba=Input.pouzeCelaCisla(sc, 0, 1);
                        if (volba == 1) {
                            run = false;
                        } 
						else if (volba == 0) {
                            System.out.println("Pokracujete v praci s databazou.");
                        }
                    }    
                    break;
                    
            }
            System.out.println("Stlacite Enter pre pokracovanie.");
            sc.nextLine();
        
    	}
		sc.close();
	}
}