package Model;

public class Soma implements Operador {
    @Override
    public double calcular(double a, double b) {
        return a + b;
    }
}
