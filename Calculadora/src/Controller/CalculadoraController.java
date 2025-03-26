package Controller;

import Model.Operador;

public class CalculadoraController {
    private Operador operador;

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public double realizarCalculo(double a, double b) {
        if (operador == null) {
            throw new IllegalStateException("Nenhuma operação selecionada");
        }
        return operador.calcular(a, b);
    }
}
