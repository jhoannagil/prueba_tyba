package com.pruebatyba.travelocity.questions;

import static com.pruebatyba.travelocity.userinterfaces.FlightInformation.AVAILABLE_FLIGHTS;

import java.util.List;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;

public class TheSelectedFlightFilter implements Question<Boolean> {
  private String option;

  public TheSelectedFlightFilter(String option) {
    this.option = option;
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    List<WebElementFacade> availableFlights =
        AVAILABLE_FLIGHTS
            .resolveAllFor(actor)
            .subList(0, AVAILABLE_FLIGHTS.resolveAllFor(actor).size());
    for (WebElementFacade availableFlight : availableFlights) {
      if (!availableFlight
          .findElement(By.xpath(".//div[@data-test-id='flight-operated']"))
          .getText()
          .contains(option)) {
        return false;
      }
    }
    return true;
  }

  public static TheSelectedFlightFilter named(String option) {
    return new TheSelectedFlightFilter(option);
  }

  public TheSelectedFlightFilter wasAppliedInTheFlightList() {
    return this;
  }
}
