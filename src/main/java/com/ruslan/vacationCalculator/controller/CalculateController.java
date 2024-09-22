package com.ruslan.vacationCalculator.controller;

import com.ruslan.vacationCalculator.model.CalculateRequest;
import com.ruslan.vacationCalculator.model.CalculateResponse;
import com.ruslan.vacationCalculator.service.CalculateService;
import com.ruslan.vacationCalculator.util.InvalidParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculateController {


    private final CalculateService calculateService;

    @Autowired
    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping
    public CalculateResponse calculateVacation(@RequestBody CalculateRequest request) {
        double vacationPay;

        double averageSalary = request.getAverageSalary();
        int vacationDays = request.getVacationDays();

        if (vacationDays <= 0 || averageSalary <= 0) {
            throw new InvalidParameterException("Vacation Days and Average Salary should be greater than 0");
        }

        if (request.getVacationDates() == null || request.getVacationDates().isEmpty()) {
            vacationPay = calculateService.calculateVacationPay(averageSalary, vacationDays);
        } else {
            vacationPay = calculateService.calculateWithHolidays(averageSalary, request.getVacationDates());
        }
        return CalculateResponse.of(vacationPay);
    }
}
