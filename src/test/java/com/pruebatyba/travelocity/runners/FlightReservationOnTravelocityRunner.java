package com.pruebatyba.travelocity.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/flight_reservation_on_travelocity.feature",
    glue = "com.pruebatyba.travelocity.stepdefinitions",
    snippets = CucumberOptions.SnippetType.CAMELCASE)
public class FlightReservationOnTravelocityRunner {}
