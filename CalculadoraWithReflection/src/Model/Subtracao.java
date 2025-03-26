package Model;

public class Subtracao implements Operador {
    @Override
    public double calcular(double a, double b) {
        return a - b;
    }
}
