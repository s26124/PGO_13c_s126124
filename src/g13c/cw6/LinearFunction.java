package g13c.cw6;

public class LinearFunction extends Function implements Fun {
        private double a;
        private double b;

        public LinearFunction (double ia, double ib){
            a=ia;
            b=ib;
        }

        @Override
        public double f(double x) {
            return a*x+b; // y=ax+b
        }

        @Override
        void increaseCoefficientsBy(double delta) {
            a+=delta;
            b+=delta;
        }

        @Override
        void decreaseCoefficientsBy(double delta) {
            a-=delta;
            b-=delta;

        }

}

