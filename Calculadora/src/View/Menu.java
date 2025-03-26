package View;

import Controller.CalculadoraController;
import Model.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    private CalculadoraController controller;
    private Scanner scanner;

    public Menu() {
        this.controller = new CalculadoraController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("--- Calculadora ---");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            if (opcao == 0) break;

            if (opcao < 1 || opcao > 4) {
                System.out.println("Opção inválida!");
                continue;
            }

            System.out.print("Digite o primeiro número: ");
            double a = scanner.nextDouble();
            System.out.print("Digite o segundo número: ");
            double b = scanner.nextDouble();

            try {
                Operador operacaoSelecionada = selecionarOperacao(opcao);
                controller.setOperador(operacaoSelecionada);
                double resultado = controller.realizarCalculo(a, b);
                System.out.println("Resultado: " + resultado);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private Operador selecionarOperacao(int opcao) {
        switch (opcao) {
            case 1: return new Soma();
            case 2: return new Subtracao();
            case 3: return new Multiplicacao();
            case 4: return new Divisao();
            default: throw new IllegalArgumentException("Operação inválida");
        }
    }
}