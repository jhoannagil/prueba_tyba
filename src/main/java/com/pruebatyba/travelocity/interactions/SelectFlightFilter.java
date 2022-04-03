package com.pruebatyba.travelocity.interactions;

import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.FLIGHT_FILTER;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SelectFlightFilter implements Interaction {

  private String filterCategory;
  private String option;

  public SelectFlightFilter(String filterCategory, String option) {
    this.filterCategory = filterCategory;
    this.option = option;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(FLIGHT_FILTER.of(filterCategory, option), isEnabled()),
        Click.on(FLIGHT_FILTER.of(filterCategory, option)));
  }

  public static SelectFlightFilter withTheFollowingInformation(
      String filterCategory, String option) {
    return instrumented(SelectFlightFilter.class, filterCategory, option);
  }
}
