package com.ruslan.vacationCalculator.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

public class HolidayUtils {
    private static final Set<LocalDate> HOLIDAYS = Set.of(
            LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 1, 2),
            LocalDate.of(2024, 1, 3),
            LocalDate.of(2024, 1, 4),
            LocalDate.of(2024, 1, 5),
            LocalDate.of(2024, 1, 6),
            LocalDate.of(2024, 1, 7),
            LocalDate.of(2024, 2, 23),
            LocalDate.of(2024, 3, 8),
            LocalDate.of(2024, 5, 1),
            LocalDate.of(2024, 5, 9),
            LocalDate.of(2024, 6, 12)
    );

    public static boolean isHoliday(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        date = date.withYear(2024);
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY || HOLIDAYS.contains(date);
    }
}
