package dev.leitzke.rest_apis_with_spring_boot.controllers;

import dev.leitzke.rest_apis_with_spring_boot.exceptions.InvalidOperandException;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {
    @RequestMapping(value = "/sum/{firstOperand}/{secondOperand}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "firstOperand") String firstOperand,
            @PathVariable(value = "secondOperand") String secondOperand
    ) {
        return convertToDouble(firstOperand) + convertToDouble(secondOperand);
    }

    @RequestMapping(value = "/subtract/{firstOperand}/{secondOperand}", method = RequestMethod.GET)
    public Double subtract(
            @PathVariable(value = "firstOperand") String firstOperand,
            @PathVariable(value = "secondOperand") String secondOperand
    ) {
        return convertToDouble(firstOperand) - convertToDouble(secondOperand);
    }

    @RequestMapping(value = "/multiply/{firstOperand}/{secondOperand}", method = RequestMethod.GET)
    public Double multiply(
            @PathVariable(value = "firstOperand") String firstOperand,
            @PathVariable(value = "secondOperand") String secondOperand
    ) {
        return convertToDouble(firstOperand) * convertToDouble(secondOperand);
    }

    @RequestMapping(value = "/divide/{firstOperand}/{secondOperand}", method = RequestMethod.GET)
    public Double divide(
            @PathVariable(value = "firstOperand") String firstOperand,
            @PathVariable(value = "secondOperand") String secondOperand
    ) {
        return convertToDouble(firstOperand) / convertToDouble(secondOperand);
    }

    @RequestMapping(value = "/power/{firstOperand}/{secondOperand}", method = RequestMethod.GET)
    public Double power(
            @PathVariable(value = "firstOperand") String firstOperand,
            @PathVariable(value = "secondOperand") String secondOperand
    ) {
        return Math.pow(convertToDouble(firstOperand), convertToDouble(secondOperand));
    }

    @RequestMapping(value = "/root/{firstOperand}", method = RequestMethod.GET)
    public Double root(
            @PathVariable(value = "firstOperand") String firstOperand
    ) {
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
