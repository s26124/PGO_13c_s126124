package g13c.cw6;
import static java.lang.Math.abs;

/*
 * Utwórz class AbsoluteLinearFunction , która dziedziczy po class LinearFunction i
implementuje interface Fun.
Implementacja interface Fun powinna zapewnić możliwość uzyskania współrzędnej y od
funkcji, przekazując x jako parametr. Wzór na modułową funkcję liniową to:
𝑦 = |𝑎𝑥 + 𝑏|
, gdzie y jest zawsze dodatni lub zero.
 */


public class AbsoluteLinearFunction extends LinearFunction implements Fun {


    public AbsoluteLinearFunction(double ia, double ib) {
        super(ia, ib);
    }

    @Override
    public double f(double x) {
        return abs(super.f(x)); // y=|ax+b|, super bo ax+b to f klasy nadrzednej
    }

}
