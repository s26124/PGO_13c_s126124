package g13c.cw6;

/*
 * Utwórz abstract class Function, która implementuje interface Fun i posiada metody
abstrakcyjne (bez body):
- void increaseCoefficientsBy(double delta) - zwiększanie wszystkich
współczynników klasy funkcji o delta
- void decreaseCoefficientsBy(double delta) - zmniejszanie wszystkich
współczynników klasy funkcji o delta
 */

public abstract class Function implements Fun {
    abstract void increaseCoefficientsBy(double delta);
    abstract void decreaseCoefficientsBy(double delta);
}



