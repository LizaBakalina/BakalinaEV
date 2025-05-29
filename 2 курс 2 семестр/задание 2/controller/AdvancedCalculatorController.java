package controller;

import model.AdvancedCalculatorModel;
import view.CalculatorView;

public class AdvancedCalculatorController {
    private AdvancedCalculatorModel model;
    private CalculatorView view;

    public AdvancedCalculatorController(AdvancedCalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void processEquation() {
        String equation = view.getInputEquation();
        model.setEquation(equation);

        if (model.isValid()) {
            view.displayResult(model.getResult());
        } else {
            view.displayError(model.getErrorMessage());
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
                view.displayError("Произошла ошибка при обработке уравнения: " + e.getMessage());
            }
        }

        view.close();
    }
}