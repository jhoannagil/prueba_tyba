package com.pruebatyba.travelocity.interactions;

import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.APPLY_DATE_BUTTON;
import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.CALENDAR_MONTH;
import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.DATE_SELECT;
import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.NEXT_MONTH;
import static com.pruebatyba.travelocity.utils.GlobalVariables.FULL_DATE_FORMAT;
import static com.pruebatyba.travelocity.utils.Months.getMonthNumber;
import static com.pruebatyba.travelocity.utils.Utilities.getCurrentDate;
import static com.pruebatyba.travelocity.utils.Utilities.getDayDate;
import static com.pruebatyba.travelocity.utils.Utilities.getMonthFromFullDate;
import static com.pruebatyba.travelocity.utils.Utilities.validateStartDate;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class SelectStartDate implements Interaction {

  private String date;

  public SelectStartDate(String date) {
    this.date = date;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    if (validateStartDate(date, FULL_DATE_FORMAT)) {
      int month = getMonthNumber(CALENDAR_MONTH.resolveFor(actor).getText());
      while (month != getMonthFromFullDate(date, FULL_DATE_FORMAT)) {
        actor.attemptsTo(Click.on(NEXT_MONTH));
        month = getMonthNumber(CALENDAR_MONTH.resolveFor(actor).getText());
      }
      selectDate(actor, date);
    } else {
      selectDate(actor, getCurrentDate(FULL_DATE_FORMAT));
    }
  }

  public static void selectDate(Actor actor, String date) {
    actor.attemptsTo(
        Click.on(DATE_SELECT.of(Integer.toString(getDayDate(date, FULL_DATE_FORMAT)))),
        Click.on(APPLY_DATE_BUTTON));
  }

  public static SelectStartDate onTheCalendar(String date) {
    return instrumented(SelectStartDate.class, date);
  }
}
