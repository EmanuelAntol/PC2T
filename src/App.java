import java.util.Scanner;

public class App {

    public static int pouzeCelaCisla(Scanner sc) 
	{
		int cislo = 0;
		try
		{
			cislo = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			cislo = pouzeCelaCisla(sc);
		}
		return cislo;
	}
	
	public static float pouzeCisla(Scanner sc) 
	{
		float cislo = 0;
		try
		{
			cislo = sc.nextFloat();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cislo ");
			sc.nextLine();
			cislo = pouzeCisla(sc);
		}
		return cislo;
	}

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        Boolean run = true;
        int volba;

        while (run) {
            System.out.println("Vyberte pozadovanu cinnost:");
			System.out.println("1 .. vytvorenie novej databaze");
            System.out.println("10 .. Koniec");
        volba=pouzeCelaCisla(sc);
			switch(volba)
			{
				case 1:
                    System.out.println("Vytvorenie novej databaze");
					break;
                case 10:
                    if (Databaza.uloz()) {
                        System.out.println("Data boli uspesne ulozene.");
                        run = false;
                    } else {
                        System.out.println("Chyba pri ukladani dát.");
                        System.out.println("Zelate si napriek tomu program ukoncit? (1/0)");
                        volba = pouzeCelaCisla(sc);
                        if (volba == 1) {
                            run = false;
                        } 
                        else {
                            System.out.println("Pokračujeme v práci s databázou.");
                        }
                    }    
                    break;
            }        
        }
        sc.close();
    }
}