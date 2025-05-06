package Controller;

import Model.*;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class CalculadoraController {
    // Mapa para mapear números de opção para classes de operação
    private static final Map<Integer, Class<? extends Operador>> OPERACOES = new HashMap<>();

    // Bloco estático para registrar as operações
    static {
        OPERACOES.put(1, Soma.class);
        OPERACOES.put(2, Subtracao.class);
        OPERACOES.put(3, Multiplicacao.class);
        OPERACOES.put(4, Divisao.class);
    }

    // Método para criar operação usando Reflection
    public Operador criarOperacao(int tipoOperacao) throws Exception {
        // Busca a classe da operação no mapa
        Class<? extends Operador> operacaoClass = OPERACOES.get(tipoOperacao);

        if (operacaoClass == null) {
            throw new IllegalArgumentException("Operação inválida");
        }

        // Usa Reflection para criar uma instância da operação
        Constructor<? extends Operador> construtor = operacaoClass.getDeclaredConstructor();
        return construtor.newInstance();
    }

    // Método para realizar o cálculo
    public double realizarCalculo(Operador operador, double a, double b) {
        return operador.calcular(a, b);
    }
}
