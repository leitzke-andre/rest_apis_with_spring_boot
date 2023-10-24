package dev.leitzke.rest_apis_with_spring_boot.controllers;

import dev.leitzke.rest_apis_with_spring_boot.exceptions.InvalidOperandException;
import dev.leitzke.rest_apis_with_spring_boot.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    private final MathService mathService;

    public MathController(@Autowired MathService mathService) {
        this.mathService = mathService;
    }

    @RequestMapping(value = "/sum/{firstOperand}/{secondOperand}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "firstOperand") String firstOperand,
            @PathVariable(value = "secondOperand") String secondOperand
    ) {
        return mathService.sum(firstOperand, secondOperand);
    }

    @RequestMapping(value = "/subtract/{firstOperand}/{secondOperand}", method = RequestMethod.GET)
    public Double subtract(
            @PathVariable(value = "firstOperand") String firstOperand,
            @PathVariable(value = "secondOperand") String secondOperand
    ) {
        return mathService.subtract(firstOperand, secondOperand);
    }

    @RequestMapping(value = "/multiply/{firstOperand}/{secondOperand}", method = RequestMethod.GET)
    public Double multiply(
            @PathVariable(value = "firstOperand") String firstOperand,
            @PathVariable(value = "secondOperand") String secondOperand
    ) {
        return mathService.multiply(firstOperand, secondOperand);
    }

    @RequestMapping(value = "/divide/{firstOperand}/{secondOperand}", method = RequestMethod.GET)
    public Double divide(
            @PathVariable(value = "firstOperand") String firstOperand,
            @PathVariable(value = "secondOperand") String secondOperand
    ) {
        return mathService.divide(firstOperand, secondOperand);
    }

    @RequestMapping(value = "/power/{firstOperand}/{secondOperand}", method = RequestMethod.GET)
    public Double power(
            @PathVariable(value = "firstOperand") String firstOperand,
            @PathVariable(value = "secondOperand") String secondOperand
    ) {
        return mathService.power(firstOperand, secondOperand);
    }

    @RequestMapping(value = "/root/{firstOperand}", method = RequestMethod.GET)
    public Double root(
            @PathVariable(value = "firstOperand") String firstOperand
    ) {
        return mathService.squareRoot(firstOperand);
    }
}
