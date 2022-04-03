package com.pruebatyba.travelocity.stepdefinitions;

import static com.pruebatyba.travelocity.utils.GetData.getFlightReservationData;
import static com.pruebatyba.travelocity.utils.GlobalVariables.TRAVELOCITY_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.pruebatyba.travelocity.exceptions.SearchFilterNotAppliedException;
import com.pruebatyba.travelocity.interactions.SelectFlightFilter;
import com.pruebatyba.travelocity.interactions.SelectReservationOption;
import com.pruebatyba.travelocity.models.FlightReservation;
import com.pruebatyba.travelocity.questions.TheSelectedFlightFilter;
import com.pruebatyba.travelocity.tasks.SearchFlightReservation;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class FlightReservationStepDefinition {

  private FlightReservation flightReservation;

  @Managed(driver = "chrome")
  WebDriver herBrowser;

  @Before
  public void setStage() {
    OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(herBrowser)));
  }

  @Given("that {word} wants to use the {string} reservation service on Travelocity")
  public void selectReservationOption(String actor, String reservationOption) {
    theActorCalled(actor)
        .wasAbleTo(Open.url(TRAVELOCITY_URL), SelectReservationOption.named(reservationOption));
  }

  @When("she searches for the required flight {string}")
  public void searchFlightReservation(String reservationFeature) throws IOException {
    flightReservation = getFlightReservationData(reservationFeature);
    theActorInTheSpotlight()
        .attemptsTo(SearchFlightReservation.withTheFollowingInformation(flightReservation));
  }

  @When("she filters available flights by: {string}, {string}")
  public void selectFlightFilter(String filterCategory, String option) {
    theActorInTheSpotlight()
        .attemptsTo(SelectFlightFilter.withTheFollowingInformation(filterCategory, option));
  }

  @Then("she should see that the flight list was filtered with the option {string}")
  public void validateFlightSearchFilter(String option) {
    theActorInTheSpotlight()
        .should(
            seeThat(TheSelectedFlightFilter.named(option).wasAppliedInTheFlightList())
                .orComplainWith(
                    SearchFilterNotAppliedException.class,
                    String.format(
                        "The search filter %s was not applied to the available items", option)));
  }
}
