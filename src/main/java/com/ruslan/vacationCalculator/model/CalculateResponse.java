package com.ruslan.vacationCalculator.model;

import lombok.Value;

@Value(staticConstructor = "of")
public class CalculateResponse {
    double vacationPay;
}
