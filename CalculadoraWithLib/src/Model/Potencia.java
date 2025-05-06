package Model;

public class Potencia {
    public static double calcular(double base, double expoente) {
        if (expoente == 0) return 1;  // Qualquer número elevado a 0 é 1
        double resultado = 1;
        boolean expoenteNegativo = expoente < 0;
        
        // Se o expoente for negativo, vamos inverter a base
        if (expoenteNegativo) expoente = -expoente;
        
        // Multiplicação repetida
        for (int i = 0; i < expoente; i++) {
            resultado *= base;
        }
        
        // Se o expoente for negativo, invertemos o resultado
        if (expoenteNegativo) {
            return 1 / resultado;
        }
        return resultado;
    }
}
