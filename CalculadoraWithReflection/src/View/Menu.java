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
                // Cria a operação usando Reflection
                Operador operacaoSelecionada = controller.criarOperacao(opcao);

                // Realiza o cálculo
                double resultado = controller.realizarCalculo(operacaoSelecionada, a, b);
                System.out.println("Resultado: " + resultado);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}