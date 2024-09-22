package com.ruslan.vacationCalculator.service;

import com.ruslan.vacationCalculator.util.HolidayUtils;
import com.ruslan.vacationCalculator.util.RoundUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CalculateService {

    private static final int WORK_DAYS_PER_MONTH = 22;

    public double calculateVacationPay(double averageSalary, int vacationDays) {
        return RoundUtil.round(averageSalary * vacationDays / WORK_DAYS_PER_MONTH);
    }

    public double calculateWithHolidays(double averageSalary, List<LocalDate> vacationDates) {
        int workDaysWithoutHolidays = (int) vacationDates.stream()
                .filter(date -> !HolidayUtils.isHoliday(date))
                .count();
        return RoundUtil.round(averageSalary * workDaysWithoutHolidays / WORK_DAYS_PER_MONTH);
    }
}
