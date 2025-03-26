package Model;

public class Multiplicacao implements Operador {
    @Override
    public double calcular(double a, double b) {
        return a * b;
    }
}
