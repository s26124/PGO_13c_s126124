package g13c.cw6;

public interface Fun {

    // double f(double x) - metoda deklarowana do późniejszej implementacji, przyjmująca double x jako parametr
    double f(double x);

	/*
	static double minimum(Fun func, double a, double b, double alpha) -
	metoda obliczająca minimum funkcji podaną jako pierwszy parametr w zakresie od
	liczby a do b (gdzie a powinno być zawsze mniejsze od b) . Obliczenie minimum
	odbywa się iteracyjnie, sprawdzając wyjście f(x) od a do b zwiększając wartość o
	alpha. Ta metoda jest zdefiniowana w interfejsie.
	*/

    static double minimum(Fun func, double a, double b, double alpha) {
        double min;
        double i;

        // obsługa, gdzie a powinno być zawsze mniejsze od b
        if (a>b){
            i=a;
            a=b;
            b=i;
        }
        min = a;
        i = a;

        while (i<=b) {
            if(func.f(i)<func.f(min))
                min = i;
            i+=alpha;
            //i=(double) Math.round(i*10)/10; // drobna punktowa poprawka wynikajaca z niedokladnosci maszynowej
        }

        // Minimum funkcji jako y a nie x - przynajmniej wynika z wyników pdf'a
        return func.f(min);
    }

}
