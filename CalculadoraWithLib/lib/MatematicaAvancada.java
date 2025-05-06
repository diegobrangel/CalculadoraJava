package lib;

public class MatematicaAvancada {
    public static double potencia(double base, double expoente) {
        if (expoente == 0) return 1;
        double resultado = 1;
        boolean expoenteNegativo = expoente < 0;
        if (expoenteNegativo) expoente = -expoente;

        for (int i = 0; i < expoente; i++) {
            resultado *= base;
        }

        return expoenteNegativo ? 1 / resultado : resultado;
    }

    public static double raiz(double numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("Não é possível calcular a raiz quadrada de um número negativo.");
        }

        double erro = 0.0001;
        double raiz = numero / 2;

        while (Math.abs(raiz * raiz - numero) > erro) {
            raiz = (raiz + numero / raiz) / 2;
        }

        return raiz;
    }
}

