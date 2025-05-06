package Model;

public class Divisao implements Operador {
    @Override
    public double calcular(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida");
        }
        return a / b;
    }
}
