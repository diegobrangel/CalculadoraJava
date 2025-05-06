package Model;

public class Raiz {
    public static double calcular(double numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("Não é possível calcular a raiz quadrada de um número negativo.");
        }
        
        double erro = 0.0001;  // Precisão da aproximação
        double raiz = numero / 2;  // Aproximação inicial
        
        // Método de Newton-Raphson
        while (Math.abs(raiz * raiz - numero) > erro) {
            raiz = (raiz + numero / raiz) / 2;
        }
        
        return raiz;
    }
}