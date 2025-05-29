package model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdvancedCalculatorModel {
    private String equation;
    private double result;
    private boolean isValid;
    private String errorMessage;

    public void setEquation(String equation) {
        this.equation = equation;
        this.errorMessage = "";
        validateEquation();
        if (isValid) {
            calculateResult();
        }
    }

    private void validateEquation() {
        // Проверка баланса скобок
        if (!checkParenthesesBalance()) {
            isValid = false;
            errorMessage = "Несбалансированные скобки в уравнении";
            return;
        }

        // Проверка количества операндов
        if (countOperands() > 15) {
            isValid = false;
            errorMessage = "Превышено максимальное количество слагаемых (15)";
            return;
        }

        // Проверка формата уравнения
        String regex = "^[-+]?(\\d+|exp\\(.*\\)|log\\(.*\\))([+\\-*/^|]|\\*\\*|//).*$";
        if (!equation.matches("^[-+]?(\\d+|exp\\(.*\\)|log\\(.*\\)).*\\d+$") ||
                equation.matches(regex)) {
            isValid = false;
            errorMessage = "Уравнение должно начинаться и заканчиваться числом или функцией";
            return;
        }

        isValid = true;
    }

    private boolean checkParenthesesBalance() {
        int balance = 0;
        for (char c : equation.toCharArray()) {
            if (c == '(') balance++;
            if (c == ')') balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }

    private int countOperands() {
        String[] parts = equation.split("[+\\-*/^|]|\\*\\*|//");
        return parts.length;
    }

    private void calculateResult() {
        try {
            String processedEquation = processFunctions(equation);
            processedEquation = processBrackets(processedEquation);
            List<String> tokens = tokenize(processedEquation);
            result = evaluateExpression(tokens);
        } catch (Exception e) {
            isValid = false;
            errorMessage = "Ошибка при вычислении: " + e.getMessage();
        }
    }

    private String processFunctions(String eq) {
        // Обработка exp()
        Pattern expPattern = Pattern.compile("exp\\(([^()]+)\\)");
        Matcher expMatcher = expPattern.matcher(eq);
        while (expMatcher.find()) {
            String inner = expMatcher.group(1);
            double value = evaluateExpression(tokenize(inner));
            eq = eq.replace(expMatcher.group(), String.valueOf(Math.exp(value)));
            expMatcher = expPattern.matcher(eq);
        }

        // Обработка log()
        Pattern logPattern = Pattern.compile("log\\(([^()]+)\\)");
        Matcher logMatcher = logPattern.matcher(eq);
        while (logMatcher.find()) {
            String inner = logMatcher.group(1);
            double value = evaluateExpression(tokenize(inner));
            eq = eq.replace(logMatcher.group(), String.valueOf(Math.log(value)/Math.log(2)));
            logMatcher = logPattern.matcher(eq);
        }

        return eq;
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
        Pattern pattern = Pattern.compile("([+-]?\\d+\\.?\\d*)|([+\\-*/^|]|\\*\\*|//)");
        Matcher matcher = pattern.matcher(expression.replaceAll("\\s+", ""));

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens;
    }

    private double evaluateExpression(List<String> tokens) {
        // Обработка факториалов
        evaluateFactorials(tokens);

        // Обработка степеней
        evaluateOperations(tokens, new String[]{"^", "**"});

        // Обработка умножения и деления
        evaluateOperations(tokens, new String[]{"*", "/", "//"});

        // Обработка сложения и вычитания
        evaluateOperations(tokens, new String[]{"+", "-"});

        return Double.parseDouble(tokens.get(0));
    }

    private void evaluateFactorials(List<String> tokens) {
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).equals("|")) {
                if (i > 0) {
                    double num = Double.parseDouble(tokens.get(i-1));
                    if (num < 0 || num != (int)num) {
                        throw new IllegalArgumentException("Факториал определен только для целых неотрицательных чисел");
                    }
                    long factorial = 1;
                    for (int j = 2; j <= (int)num; j++) {
                        factorial *= j;
                    }
                    tokens.set(i-1, String.valueOf(factorial));
                    tokens.remove(i);
                    i--;
                }
            }
        }
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
                        case "**":
                            result = Math.pow(left, right);
                            break;
                        case "*":
                            result = left * right;
                            break;
                        case "/":
                            if (right == 0) throw new ArithmeticException("Деление на ноль");
                            result = left / right;
                            break;
                        case "//":
                            if (right == 0) throw new ArithmeticException("Деление на ноль");
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
                    i = 0;
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

    public String getErrorMessage() {
        return errorMessage;
    }
}