package dev.leitzke.rest_apis_with_spring_boot;

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
        return Double.valueOf(number);
    }

}
