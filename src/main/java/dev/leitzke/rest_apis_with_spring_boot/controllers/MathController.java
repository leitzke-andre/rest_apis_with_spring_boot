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
