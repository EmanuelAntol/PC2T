import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\n");
        Scanner sc=new Scanner(System.in);
        Database Database = new Database();
        Student student;
        boolean loadedFromSql;
		boolean run = true;

        Database.getConnection();
        loadedFromSql = Database.loadDatabaseFromSql();
        if (!loadedFromSql) {

            System.out.println("Data neboli nacitane z SQL. Pracujete s lokalnou databazou!");
            System.out.println("Stlacte Enter pre pokracovanie.  \n");
            sc.nextLine();
        }
        
        
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
            System.out.println("10 .. Odstranit studenta z databazy");
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
                    } 
                    else if (volba == 2) {
                        Database.addStudent(new KyberStudent(meno, priezvisko, rokNarodenia));
                    }
                    System.out.println("\nStudent bol uspesne vytvoreny. Studentovi bolo pridelene ID:  " + Database.getLastId());    
					
					break;

				case 2:
					System.out.println("Zadajte ID studenta:");
					volba=Input.pouzeCelaCisla(sc);
					System.out.println("Zadajte znamku studenta:");
                    int znamka=Input.pouzeCelaCisla(sc, 1, 5);
                    student = Database.getStudent(volba);
                    
                    if (student != null) {
                        student.addZnamka(znamka);
                        System.out.println("Znamka bola uspesne pridana.");
                    } 
                    else {
                        System.out.println("Student s ID " + volba + " neexistuje.");
                    }

					break;

				case 3:
					System.out.println("Zadajte ID studenta:");
					volba=Input.pouzeCelaCisla(sc);
                    student = Database.getStudent(volba);
                    System.out.println("\n");

                    if (student != null) {
                        System.out.println(student.toString());
                    } 
                    else {
                        System.out.println("Student s ID " + volba + " neexistuje.");
                    }

					break;

				case 4:
                System.out.println("Zadajte ID studenta:");
                volba=Input.pouzeCelaCisla(sc);
                student = Database.getStudent(volba);

                if (student != null) {
                    System.out.println(student.dovednost());
                }
                else {
                    System.out.println("Student s ID " + volba + " neexistuje.");
                }

				break;

				case 5:
					System.out.println("Vsetci studenti v abecednom poradí: \n");
                    if (Database.getAllStudents().isEmpty()) {
                        System.out.println("Databaza studentov je prazdna.");
                    } 
                    else {
                        System.out.println("\n");
                        for (Student std : Database.getAllStudents()) {
                            System.out.println(std.toString());
                        }
                    }
					
					break;

				case 6:
					System.out.println("Priemer oboru telekomunikacie je " + Database.getpiemer()[0] + ".");
                    System.out.println("Priemer oboru kyberbezpecnost je " + Database.getpiemer()[1] + ".");

					break;

				case 7:
					System.out.println("Pocet studentov v obore telekomunikacie je " + Database.getPocetStudentov()[0] + ".");
					System.out.println("Pocet studentov v obore kyberbezpecnost je  " + Database.getPocetStudentov()[1] + ".");

					break;

				case 8:
					System.out.println("Zadajte ID studenta:");
					volba=Input.pouzeCelaCisla(sc);
					System.out.println(Database.saveStudentToFile(volba, sc));

					break;

				case 9:
					System.out.println("Zadajte ID studenta:");
					volba=Input.pouzeCelaCisla(sc);
                    System.out.println(Database.loadStudentFromFile(volba));
                    
					break;
                    
				case 10:
                    System.out.println("Zadajte ID studenta:");
                    volba=Input.pouzeCelaCisla(sc);
                    student = Database.getStudent(volba);

                    if (student != null) {
                        Database.removeStudent(volba);
                        System.out.println("Student bol uspesne odstraneny.");
                    } 
                    else {
                        System.out.println("Student s ID " + volba + " neexistuje.");
                    }

					break;

                case 11:
                    System.out.println("\n");
                    
                    if (!loadedFromSql) {
                        System.out.println("Zelate si pokusit ulozit data do SQL databaze? (1/0)");
                        volba=Input.pouzeCelaCisla(sc, 0, 1);
                        if (volba == 1) {
                            Database.getConnection();
                            if (Database.saveDatabaseToSql()) {
                                    System.out.println("\nData boli uspesne ulozene.");
                                    run = false;
                                    break;
                            }
                            
                            System.out.println("\nChyba pri ukladani dát.");
                            run = false;
                            break;
                            
                        } 
						else if (volba == 0) {
                            run = false;
                            break;
                        }
                    }


                    if (Database.saveDatabaseToSql()) {
                        System.out.println("\nData boli uspesne ulozene.");
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
                            System.out.println("\nPokracujete v praci s databazou.");
                        }
                    }    

                    break;
            }

            System.out.println("\n");
            System.out.println("Stlacte Enter pre pokracovanie.");
            sc.nextLine();
            sc.nextLine();
        
    	}
		sc.close();
	}
}