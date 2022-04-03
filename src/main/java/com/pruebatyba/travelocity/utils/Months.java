package com.pruebatyba.travelocity.utils;

public enum Months {
  JANUARY(1, "January"),
  FEBRUARY(2, "February"),
  MARCH(3, "March"),
  APRIL(4, "April"),
  MAY(5, "May"),
  JUNE(6, "June"),
  JULY(7, "July"),
  AUGUST(8, "August"),
  SEPTEMBER(9, "September"),
  OCTOBER(10, "October"),
  NOVEMBER(11, "November"),
  DECEMBER(12, "December");

  private int monthNumber;
  private String monthName;

  Months(int monthNumber, String monthName) {
    this.monthNumber = monthNumber;
    this.monthName = monthName;
  }

  public int getMonthNumber() {
    return monthNumber;
  }

  public String getMonthName() {
    return monthName;
  }

  public static int getMonthNumber(String monthName) {
    String[] month = monthName.split(" ");

    int monthNumber = 0;
    for (Months m : Months.values()) {
      if (m.getMonthName().equalsIgnoreCase(month[0])) {
        monthNumber = m.getMonthNumber();
        break;
      }
    }
    return monthNumber;
  }
}
