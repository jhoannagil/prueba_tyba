package com.pruebatyba.travelocity.interactions;

import static com.pruebatyba.travelocity.interactions.SelectStartDate.selectDate;
import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.CALENDAR_MONTH;
import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.NEXT_MONTH;
import static com.pruebatyba.travelocity.utils.GlobalVariables.FULL_DATE_FORMAT;
import static com.pruebatyba.travelocity.utils.Months.getMonthNumber;
import static com.pruebatyba.travelocity.utils.Utilities.getFutureOrPastDate;
import static com.pruebatyba.travelocity.utils.Utilities.getMonthFromFullDate;
import static com.pruebatyba.travelocity.utils.Utilities.validateDates;
import static com.pruebatyba.travelocity.utils.Utilities.validateEndDate;
import static com.pruebatyba.travelocity.utils.Utilities.validateStartDate;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class SelectEndDate implements Interaction {

  private String endDate;
  private String startDate;

  public SelectEndDate(String endDate, String startDate) {
    this.endDate = endDate;
    this.startDate = startDate;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    if (validateDates(endDate, startDate, FULL_DATE_FORMAT)) {
      if (validateEndDate(endDate, FULL_DATE_FORMAT)) {
        int month = getMonthNumber(CALENDAR_MONTH.resolveFor(actor).getText());
        while (month != getMonthFromFullDate(endDate, FULL_DATE_FORMAT)) {
          actor.attemptsTo(Click.on(NEXT_MONTH));
          month = getMonthNumber(CALENDAR_MONTH.resolveFor(actor).getText());
        }
        selectDate(actor, endDate);
      } else {
        selectDate(actor, getFutureOrPastDate(FULL_DATE_FORMAT, 1));
      }
    } else {
      if (validateStartDate(startDate, FULL_DATE_FORMAT)) {
        selectDate(actor, getFutureOrPastDate(startDate, FULL_DATE_FORMAT, 1));
      } else {
        selectDate(actor, getFutureOrPastDate(FULL_DATE_FORMAT, 1));
      }
    }
  }

  public static SelectEndDate onTheCalendar(String endDate, String startDate) {
    return instrumented(SelectEndDate.class, endDate, startDate);
  }
}
