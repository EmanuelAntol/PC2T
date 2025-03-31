import java.util.Scanner;

    public class input {
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
}
