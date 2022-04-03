package com.pruebatyba.travelocity.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class FlightInformation {

  public static final Target AVAILABLE_FLIGHTS =
      Target.the("Element containing the flights available information")
          .locatedBy("//ul[@data-test-id='listings']/li[@data-test-id='offer-listing']");

  public FlightInformation() {}
}
