package com.ruslan.vacationCalculator.model;

import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value(staticConstructor = "of")
public class CalculateRequest {

    double averageSalary;
    int vacationDays;
    List<LocalDate> vacationDates;
}
