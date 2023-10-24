package dev.leitzke.rest_apis_with_spring_boot.service;

import dev.leitzke.rest_apis_with_spring_boot.exceptions.InvalidOperandException;

public class MathService {
    public MathService() {
    }

    public Double sum(String firstOperand, String secondOperand) {
        return convertToDouble(firstOperand) + convertToDouble(secondOperand);
    }

    public Double subtract(String firstOperand, String secondOperand) {
        return convertToDouble(firstOperand) - convertToDouble(secondOperand);
    }

    public Double multiply(String firstOperand, String secondOperand) {
        return convertToDouble(firstOperand) * convertToDouble(secondOperand);
    }

    public Double divide(String firstOperand, String secondOperand) {
        return convertToDouble(firstOperand) / convertToDouble(secondOperand);
    }

    public Double power(String firstOperand, String secondOperand) {
        return Math.pow(convertToDouble(firstOperand), convertToDouble(secondOperand));
    }

    public Double squareRoot(String firstOperand) {
        return Math.sqrt(convertToDouble(firstOperand));
    }

    private Double convertToDouble(String number) {
        String strNumber = number.replaceAll(",", ".");
        if (isNumeric(strNumber)) {
            return Double.parseDouble(strNumber);
        }
        throw new InvalidOperandException("One of the operands is not a number, please check and adjust accordingly.");
    }

    private boolean isNumeric(String number) {
        if (number.isBlank()) return false;
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }
}
