package com.pruebatyba.travelocity.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utilities {

  private static final Logger LOGGER = LoggerFactory.getLogger(Utilities.class);

  public static boolean validateStartDate(String date, String format) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
    Date startDate = new Date();
    Date currentDate = new Date(System.currentTimeMillis());
    try {
      startDate = dateFormat.parse(date);
    } catch (ParseException e) {
      LOGGER.error(e.getMessage());
    }
    return startDate.compareTo(currentDate) >= 0;
  }

  public static int getMonthFromFullDate(String date, String format) {
    Calendar c = new GregorianCalendar();
    try {
      c.setTime(new SimpleDateFormat(format).parse(date));
    } catch (ParseException e) {
      LOGGER.error(String.valueOf(e));
    }
    return c.get(Calendar.MONTH) + 1;
  }

  public static int getDayDate(String date, String format) {
    Calendar c = new GregorianCalendar();
    try {
      c.setTime(new SimpleDateFormat(format).parse(date));
    } catch (ParseException e) {
      LOGGER.error(String.valueOf(e));
    }
    return c.get(Calendar.DAY_OF_MONTH);
  }

  public static String getCurrentDate(String format) {
    Date date = new Date();
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(date);
    return (new SimpleDateFormat(format)).format(calendar.getTime());
  }

  public static boolean validateDates(String date, String date2, String format) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
    Date startDate = new Date();
    Date endDate = new Date();
    try {
      endDate = dateFormat.parse(date);
      startDate = dateFormat.parse(date2);
    } catch (ParseException e) {
      LOGGER.error(e.getMessage());
    }
    return endDate.after(startDate);
  }

  public static boolean validateEndDate(String date, String format) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
    Date endDate = new Date();
    Date currentDate = new Date(System.currentTimeMillis());
    try {
      endDate = dateFormat.parse(date);
    } catch (ParseException e) {
      LOGGER.error(e.getMessage());
    }
    return endDate.compareTo(currentDate) >= 1;
  }

  public static String getFutureOrPastDate(String format, int days) {
    Date date = new Date();
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(date);
    calendar.add(6, days);
    return (new SimpleDateFormat(format)).format(calendar.getTime());
  }

  public static String getFutureOrPastDate(String date, String format, int days) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
    Date d;
    Calendar calendar = new GregorianCalendar();
    try {
      d = dateFormat.parse(date);
      calendar.setTime(d);
      calendar.add(Calendar.DAY_OF_YEAR, days);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return (new SimpleDateFormat(format)).format(calendar.getTime());
  }
}
