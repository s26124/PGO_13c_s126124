package g13c.cw6;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/*
I dane wyjściowe będą::
Original functions
-4.0
-2.5
0.0
Functions increased by 1.2
-7.6
-1.4
Pavlo Zinevych
PGO lato 21/22
0.1
Functions decreased by 1.2
-4.0
-2.5
0.0

Notatka: jako minimum funkcji wartosc y a nie wstazanie na x
Main kopia z pdfa
*/
public class Main {
    private static final DecimalFormat df = new DecimalFormat("0.0");
    public static void main(String[] args) {
        List<Function> functions = new ArrayList<>();
        functions.add(new LinearFunction(2,4));
        functions.add(new SquareFunction(2,0,-2.5));
        functions.add(new AbsoluteLinearFunction(2,4));
        List<Fun> funList = new ArrayList<>(functions);
        System.out.println("Original functions");
        funList.forEach(f ->
                System.out.println(df.format(Fun.minimum(f,-4,0,0.1))));
        functions.forEach(f -> f.increaseCoefficientsBy(1.2));
        System.out.println("Functions increased by 1.2");
        funList.forEach(f ->
                System.out.println(df.format(Fun.minimum(f,-4,0,0.1))));
        functions.forEach(f -> f.decreaseCoefficientsBy(1.2));
        System.out.println("Functions decreased by 1.2");
        funList.forEach(f ->
                System.out.println(df.format(Fun.minimum(f,-4,0,0.1))));

		/*
		 * Aby uzyskać dodatkowe 5 punktów, wymyśl sposób wykorzystania interface Fun, bez
        tworzenia klasy, która go implementuje. Pokaż to na końcu metody main, opisując w
        komentarzach swoje rozwiązanie (co dokładnie się tam dzieje). Rozwiązanie bez
        wyjaśnienia nie zostanie ocenione.
		 */

        /*
         * 2 propozycje i proste przyklady ponizej:
         * 	- klasa anonimowa, definicja w kodzie, niemniej bez definicji samej klasy z poleceniem implements
         *  - wykorzystanie tylko metody minimum, ktora po zapewnieniu argumentow jest do uzycia
         */

        // Klasa anonimowa i definicja w kodzie - dokonuje override metody, dodając (body), bez klauzuli "implements"
        System.out.println("Option 1: anonymous class - without implements statement; example y=2x+4 ; dla x=-4");
        Fun i = x -> {
            return (2*x+4);	// y=2x+4
        };
        System.out.println(df.format(i.f(-4)));

        // Opcja 2: Wykorzystanie metody minimum interface Fun:
            // krok 1: przekazuje definicję funkcji - (pierwszy argument): (p1) -> { return 2*p1 + 4; }, odpowiednik y=2x+4
            // krok 2: przekazuje pozostale argumety zakresu: -4 do 0 i krok delta=0.1
            // krok 3: wykorzystanie
        System.out.println("Option 2: just use it's minimum method (static method)");
        double result;
        result=Fun.minimum((p1) -> 2*p1 + 4, -4, 0, 0.1);
        System.out.println(df.format(result));


    }
}
