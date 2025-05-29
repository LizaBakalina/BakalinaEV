package controller;

import model.CalculatorModel;
import view.CalculatorView;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void processEquation() {
        String equation = view.getInputEquation();
        model.setEquation(equation);

        if (model.isValid()) {
            view.displayResult(model.getResult());
        } else {
            view.displayError("Уравнение неверно. Убедитесь, что оно начинается и заканчивается числом, " +
                    "и содержит не более 100 слагаемых.");
        }
    }

    public void run() {
        boolean running = true;

        while (running) {
            try {
                processEquation();
                System.out.println("Хотите продолжить? (да/нет)");
                String answer = view.getInputEquation().trim().toLowerCase();
                if (!answer.equals("да")) {
                    running = false;
                }
            } catch (Exception e) {
                view.displayError("Произошла ошибка при обработке уравнения.");
            }
        }

        view.close();
    }
}