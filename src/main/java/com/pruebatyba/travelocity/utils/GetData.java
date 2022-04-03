package com.pruebatyba.travelocity.utils;

import static com.pruebatyba.travelocity.utils.GlobalVariables.FLIGHT_RESERVATION_FILE;

import com.pruebatyba.travelocity.models.FlightReservation;
import java.io.IOException;

public class GetData {

  public static FlightReservation getFlightReservationData(String filter) throws IOException {
    FlightReservation flightReservationData;
    try {
      flightReservationData =
          FlightReservation.getFlightReservations(
                  CsvUtilities.getDataTest(FLIGHT_RESERVATION_FILE, filter))
              .get(0);
    } catch (IOException e) {
      throw new IOException("Required resource not found", e);
    }
    return flightReservationData;
  }
}
