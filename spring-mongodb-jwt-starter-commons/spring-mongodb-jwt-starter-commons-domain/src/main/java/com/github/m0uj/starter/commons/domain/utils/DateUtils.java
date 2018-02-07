package com.github.m0uj.starter.commons.domain.utils;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by m0uj on 5/10/17.
 */
public class DateUtils {
    public static int getDifferenceInDays(Date startDate, Date endDate) {
        return Days.daysBetween(new DateTime(startDate), new DateTime(endDate)).getDays();
    }

    public static List<Date> getDaysInBtw(Date startDate, Date endDate) {
        return Stream
                .iterate(startDate
                        .toInstant()
                        .atZone(ZoneId
                                .systemDefault())
                        .toLocalDate(), date -> date.plusDays(1))
                .limit((getDifferenceInDays(startDate, endDate)))
                .distinct()
                .collect(Collectors.toList())
                .stream()
                .map(date -> java.sql.Date.valueOf(date))
                .distinct()
                .collect(Collectors.toList());
    }

    public static Date getFirstDayOfMonth(Date date) {
        return java.sql.Date.valueOf(date
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()
                        .with(TemporalAdjusters.firstDayOfMonth()));
    }

    public static Date getLastDayOfMonth(Date date) {
        return java.sql.Date.valueOf(date
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()
                        .with(TemporalAdjusters.lastDayOfMonth()));
    }

    public static int getMonth(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .getMonthValue();
    }
}
