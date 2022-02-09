package tutorials.inheritance.Assignment9.problem3;

public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    private static int gcd(int numerator, int denominator){
        int n1 = Math.abs(numerator);
        int n2 = Math.abs(denominator);
        int gcd = 1;

        for(int i = 1; i<= n1&& i<=n2; i++){
            if(n1 % i == 0 && n2 % i == 0){
                gcd = i;
            }
        }
        return gcd;
    }

    public Rational add(Rational nextR){
        int n = numerator * nextR.getDenominator()+ denominator * nextR.getNumerator();
        int d = denominator * nextR.getDenominator();
        return new Rational(n,d);
    }

    public Rational sub(Rational nextR){
        int n = numerator * nextR.getDenominator()- denominator * nextR.getNumerator();
        int d = denominator * nextR.getDenominator();
        return new Rational(n,d);
    }

    public Rational mul(Rational nextR){
        int n = numerator * nextR.getNumerator();
        int d = denominator * nextR.getDenominator();
        return new Rational(n,d);
    }

    public Rational div(Rational nextR){
        int n = numerator * nextR.getDenominator();
        int d = denominator * nextR.getNumerator();
        return new Rational(n,d);
    }

    @Override
    public String toString() {
        if (denominator == 1)
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }

}
