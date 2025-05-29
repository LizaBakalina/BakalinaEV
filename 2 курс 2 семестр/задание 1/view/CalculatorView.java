package view;

import java.util.Scanner;

public class CalculatorView {
    private Scanner scanner;

    public CalculatorView() {
        scanner = new Scanner(System.in);
    }

    public String getInputEquation() {
        System.out.println("Введите математическое уравнение (например: -3234+843/3234-4232123/(34+123+32+5)*3234):");
        return scanner.nextLine();
    }

    public void displayResult(double result) {
        System.out.printf("Результат: %.4f%n", result);
    }

    public void displayError(String message) {
        System.out.println("Ошибка: " + message);
    }

    public void close() {
        scanner.close();
    }
}