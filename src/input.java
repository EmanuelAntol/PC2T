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
				System.out.println("Zadajte prosim cele cislo v rozsahu " + min + " - " + max);
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
				System.out.println("Zadajte prosim cele cislo ");
				sc.nextLine();
				cislo = pouzeCelaCisla(sc);
			}
			return cislo;
		}

		public static String textIn(Scanner sc) {
			String text;
			try
			{
				text = sc.next();
			}
			catch(Exception e)
			{
				System.out.println("Nastala vynimka typu "+e.toString());
				System.out.println("zadejte platny text ");
				sc.nextLine();
				text = textIn(sc);
			}
			return text;
		}


}

