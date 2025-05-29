package model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorModel {
    private String equation;
    private double result;
    private boolean isValid;

    public void setEquation(String equation) {
        this.equation = equation;
        validateEquation();
        if (isValid) {
            calculateResult();
        }
    }

    private void validateEquation() {
        // Проверка, что уравнение начинается и заканчивается числом
        String regex = "^[-+]?\\d+(\\.\\d+)?([+\\-*/^]|//).*$";
        isValid = equation.matches("^[-+]?\\d+.*\\d+$") &&
                !equation.matches(regex) &&
                countOperands() <= 100;
    }

    private int countOperands() {
        String[] parts = equation.split("[+\\-*/^]|//");
        return parts.length;
    }

    private void calculateResult() {
        try {
            // Обработка скобок
            String processedEquation = processBrackets(equation);

            // Разбиваем на токены
            List<String> tokens = tokenize(processedEquation);

            // Вычисляем результат
            result = evaluateExpression(tokens);
        } catch (Exception e) {
            isValid = false;
        }
    }

    private String processBrackets(String eq) {
        Pattern pattern = Pattern.compile("\\(([^()]+)\\)");
        Matcher matcher = pattern.matcher(eq);

        while (matcher.find()) {
            String group = matcher.group(1);
            List<String> tokens = tokenize(group);
            double value = evaluateExpression(tokens);
            eq = eq.replace(matcher.group(), String.valueOf(value));
            matcher = pattern.matcher(eq);
        }

        return eq;
    }

    private List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile("([+-]?\\d+\\.?\\d*)|([+\\-*/^]|//)");
        Matcher matcher = pattern.matcher(expression.replaceAll("\\s+", ""));

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens;
    }

    private double evaluateExpression(List<String> tokens) {
        // Обработка степеней
        evaluateOperations(tokens, new String[]{"^"});

        // Обработка умножения и деления
        evaluateOperations(tokens, new String[]{"*", "/", "//"});

        // Обработка сложения и вычитания
        evaluateOperations(tokens, new String[]{"+", "-"});

        return Double.parseDouble(tokens.get(0));
    }

    private void evaluateOperations(List<String> tokens, String[] operations) {
        for (int i = 1; i < tokens.size() - 1; i++) {
            String token = tokens.get(i);

            for (String op : operations) {
                if (token.equals(op)) {
                    double left = Double.parseDouble(tokens.get(i - 1));
                    double right = Double.parseDouble(tokens.get(i + 1));
                    double result = 0;

                    switch (op) {
                        case "^":
                            result = Math.pow(left, right);
                            break;
                        case "*":
                            result = left * right;
                            break;
                        case "/":
                            result = left / right;
                            break;
                        case "//":
                            result = (int)(left / right);
                            break;
                        case "+":
                            result = left + right;
                            break;
                        case "-":
                            result = left - right;
                            break;
                    }

                    tokens.set(i - 1, String.valueOf(result));
                    tokens.remove(i);
                    tokens.remove(i);
                    i = 0; // Сброс индекса после изменения списка
                    break;
                }
            }
        }
    }

    public double getResult() {
        return result;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getEquation() {
        return equation;
    }
}