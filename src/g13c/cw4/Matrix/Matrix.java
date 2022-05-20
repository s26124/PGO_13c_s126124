package g13c.cw4.Matrix;

public class Matrix {
    //
    private final int M;              // liczba wierszy
    private final int N;              // liczba kolumn
    private final int[][] data;       // macierz M na N

    // Tymczasowe atrybuty
    private static int tmpM;        // liczba wierszy
    private static int tmpN;        // liczba kolumn
    private static int tmpFreeRow;  // indeks na pierwszy wolny wiersz

    // Wymaganie: Matrix zawiera prywatną dwuwymiarowa tablice typu int
    private static int[][] tmpData;   // macierz M na N

    // Prywatny konstruktor
    private Matrix(int inpM, int inpN, int[][] inpData) {
        M=inpM;
        N=inpN;
        data=inpData;
    }

    /* Wymaganie: void SetUpMatrix(int rowCount, int columnCount) - pobiera liczbę
	wierszy i kolumn macierzy, która ma zostać utworzona i konfiguruje tymczasową
	tablicę dwuwymiarową. */
    public static void setUpMatrix(int rowCount, int columnCount) {
        tmpM=rowCount;
        tmpN=columnCount;
        tmpFreeRow=0;
        tmpData = new int[tmpM][tmpN];
    }

    /*  Wymaganie: void insertRow(int[] row) - pobiera tablicę liczb całkowitych i kopiuje ją do
	    następnego pustego wiersza tymczasowej tablicy dwuwymiarowej. */
    public static void insertRow(int[] row) {
        // jezeli jest jeszcze wolny niezaalokowany wiersz
        if (tmpFreeRow<tmpM){
            tmpData[tmpFreeRow]=row;
            tmpFreeRow++;
        }
    }

    /*  Wymaganie: Matrix Create() - tworzy nowy obiekt macierzy z dostarczonymi danymi, zwraca
        je i zwalnia wszystkie dane tymczasowe. */
    public static Matrix create() {
        Matrix newMatrix = new Matrix(tmpM,tmpN,tmpData);

        // Wyczyszczenia danych tymczasowych:
        tmpM=0;
        tmpN=0;
        tmpFreeRow=0;
        tmpData=null;

        return newMatrix;
    }

    // Wymaganie:void print() - wypisuje do konsoli tablice wybranej macierzy.
     public void print() {
        int[] colWidths = new int[M];
        for (int[] row : data) {
            for (int c = 0; c < M; c++) {
                int width = String.valueOf(row[c]).length();
                colWidths[c] = Math.max(colWidths[c], width);
            }
        }
        for (int[] row : data) {
            for (int c = 0; c < M; c++) {
                String fmt = String.format("%s%%%dd%s",
                        c == 0 ? "|" : "  ",
                        colWidths[c],
                        c < M - 1 ? "" : "|%n");
                System.out.printf(fmt, row[c]);
            }
        }
    }

    /* wymaganie: Matrix add(Matrix m) - dodaje macierz m do macierzy i zwraca this */
    public Matrix add(Matrix m) {
        // Sprawdzenie wymiarów macierzy
        if (m.M != this.M || m.N != this.N) throw new RuntimeException("Błąd: Niezgodne wymiary macierzy");
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                this.data[i][j] = this.data[i][j] + m.data[i][j];
        return this;
    }


    /* wymaganie: Matrix add(Matrix m1, Macierz m2) - pobiera 2 macierze i zwraca nową
macierz będącą wynikiem ich dodania */
    public static  Matrix add(Matrix m1, Matrix m2) {

        // Sprawdzenie wymiarów macierzy
        if (m2.M != m1.M || m2.N != m1.N) throw new RuntimeException("Błąd: Niezgodne wymiary macierzy");

        Matrix m3 = new Matrix(m1.M, m1.N, new int[m1.M][m1.N]);
        for (int i = 0; i < m1.M; i++)
            for (int j = 0; j < m1.N; j++)
                m3.data[i][j] = m1.data[i][j] + m2.data[i][j];
        return m3;
    }

    /* Matrix subtract(Macierz m) - odejmuje macierz m od macierzy i zwraca this */
    public Matrix subtract(Matrix m) {
        // Sprawdzenie wymiarów macierzy
        if (m.M != this.M || m.N != this.N) throw new RuntimeException("Błąd: Niezgodne wymiary macierzy");
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                this.data[i][j] = this.data[i][j] - m.data[i][j];
        return this;
    }

    /* Matrix subtract(Macierz m1, Macierz m2) - pobiera 2 macierze i zwraca
    nową macierz będącą wynikiem ich odejmowania */
    public Matrix subtract(Matrix m1, Matrix m2) {
        // Sprawdzenie wymiarów macierzy
        if (m2.M != m1.M || m2.N != m1.N) throw new RuntimeException("Błąd: Niezgodne wymiary macierzy");

        Matrix m3 = new Matrix(m1.M, m1.N, new int[m1.M][m1.N]);
        for (int i = 0; i < m1.M; i++)
            for (int j = 0; j < m1.N; j++)
                m3.data[i][j] = m1.data[i][j] - m2.data[i][j];
        return m3;
    }

    /* mnozene macierzy */
    public static Matrix times(Matrix m1, Matrix m2) {
        // Sprawdzenie wymiarów macierzy
        if (m1.N != m2.M ) throw new RuntimeException("Błąd: Mnożenie macierzy niemożliwe - niezgodne wymiary macierzy.");

        Matrix m3 = new Matrix(m1.M, m2.N, new int[m1.M][m2.N]);
        for (int i = 0; i < m3.M; i++)
            for (int j = 0; j < m3.N; j++)
                for (int k = 0; k < m1.N; k++)
                    m3.data[i][j] += (m1.data[i][k] * m2.data[k][j]);
        return m3;
    }




        /*
        Test mnożenia:

		Matrix.setUpMatrix(2,2);
 		Matrix.insertRow(new int[]{1,2});
 		Matrix.insertRow(new int[]{3,4});
 		Matrix matrixD= Matrix.create();
 		System.out.println("Matrix D:");
 		matrixD.print();
 		Matrix.setUpMatrix(2,1);
 		Matrix.insertRow(new int[]{1});
 		Matrix.insertRow(new int[]{2});
 		Matrix matrixE= Matrix.create();
 		System.out.println("Matrix E:");
 		matrixE.print();
 		System.out.println("Matrix D times E");
 		Matrix.times(matrixD,matrixE).print();

        Matrix D:
        | 1 2 |
        | 3 4 |
        Matrix E:
        | 1 |
        | 2 |
        Matrix D times E
        | 5 |
        | 11 |
        */
}