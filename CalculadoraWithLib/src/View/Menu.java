package View;

import Controller.CalculadoraController;
import lib.MatematicaAvancada;
import Model.Operador;

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
            System.out.println("5. Potência");
            System.out.println("6. Raiz Quadrada");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            if (opcao == 0) break;

            try {
                if (opcao >= 1 && opcao <= 4) {
                    System.out.print("Digite o primeiro número: ");
                    double a = scanner.nextDouble();
                    System.out.print("Digite o segundo número: ");
                    double b = scanner.nextDouble();

                    Operador operacao = controller.criarOperacao(opcao);
                    double resultado = controller.realizarCalculo(operacao, a, b);
                    System.out.println("Resultado: " + resultado);
                } else if (opcao == 5) {
                    System.out.print("Digite a base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Digite o expoente: ");
                    double expoente = scanner.nextDouble();

                    double resultado = MatematicaAvancada.potencia(base, expoente);
                    System.out.println("Resultado: " + resultado);
                } else if (opcao == 6) {
                    System.out.print("Digite o número: ");
                    double numero = scanner.nextDouble();

                    double resultado = MatematicaAvancada.raiz(numero);
                    System.out.println("Resultado: " + resultado);
                } else {
                    System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
