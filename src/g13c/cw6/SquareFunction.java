package g13c.cw6;
/*
 * Utwórz class SquareFunction , która dziedziczy po class Function i implementuje
interface Fun. Klasa zawiera:
Pavlo Zinevych
PGO lato 21/22
● private double a - współczynnik szerokości i kierunku paraboli
● private double b - współczynnik przesunięcia osi symetrii
● private double c - współczynnik przecięcia y paraboli
Implementacja interface Fun powinna zapewnić możliwość uzyskania współrzędnej y od
funkcji, przekazując x jako parametr. Wzór na funkcję kwadratową to:
𝑦 = 𝑎𝑥2 + 𝑏𝑥 + 𝑐

 */

public class SquareFunction extends Function implements Fun {
    private double a;
    private double b;
    private double c;

    public SquareFunction(double ia, double ib, double ic){
        a=ia;
        b=ib;
        c=ic;
    }

    @Override
    public double f(double x) {

        return (a*x*x +b*x + c); // ax^2 + bx + c
    }

    @Override
    void increaseCoefficientsBy(double delta) {
        a+=delta;
        b+=delta;
        c+=delta;

    }

    @Override
    void decreaseCoefficientsBy(double delta) {
        a-=delta;
        c-=delta;
        c-=delta;
    }
}
