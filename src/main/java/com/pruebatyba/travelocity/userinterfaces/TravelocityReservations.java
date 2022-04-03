package com.pruebatyba.travelocity.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class TravelocityReservations {

  public static final Target RESERVATION_OPTION =
      Target.the("Reservation option in Travelocity system").locatedBy("//ul//span[text()='{0}']");

  private TravelocityReservations() {}
}
