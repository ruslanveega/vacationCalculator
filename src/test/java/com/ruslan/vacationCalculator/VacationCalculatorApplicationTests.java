package com.ruslan.vacationCalculator;

import com.ruslan.vacationCalculator.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VacationCalculatorApplicationTests {

	private static final int WORK_DAYS_PER_MONTH = 22;


	@Autowired
	private CalculateService calculateService;

	@Test
	public void testCalculateVacationPay() {
		double averageSalary = 120000;
		int vacationDays = 10;
		double expectedVacationPay = (averageSalary / WORK_DAYS_PER_MONTH) * 10;

		double actualVacationPay = calculateService.calculateVacationPay(averageSalary, vacationDays);

		assertEquals(expectedVacationPay, actualVacationPay, 0.01);
	}

	@Test
	public void testCalculateVacationPayWithHolidays() {
		double averageSalary = 100000;
		List<LocalDate> vacationDates = List.of(
				LocalDate.of(2024, 5, 1),
				LocalDate.of(2024, 5, 2),
				LocalDate.of(2024, 5, 3),
				LocalDate.of(2024, 5, 4),
				LocalDate.of(2024, 5, 5)
		);

		double expectedVacationPay = (averageSalary / WORK_DAYS_PER_MONTH) * 2;

		double actualVacationPay = calculateService.calculateWithHolidays(averageSalary, vacationDates);

		assertEquals(expectedVacationPay, actualVacationPay, 0.01);
	}
}
