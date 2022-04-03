package com.pruebatyba.travelocity.tasks;

import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.ADD_CAR_CHECKBOX;
import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.ADD_HOTEL_CHECKBOX;
import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.CHECKIN_DATE_BUTTON;
import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.CHECKOUT_DATE_BUTTON;
import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.END_DATE_BUTTON;
import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.FLIGHT_CLASS_BUTTON;
import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.FLIGHT_CLASS_LIST;
import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.FLIGHT_TYPE_BUTTON;
import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.GOING_TO_BUTTON;
import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.LEAVING_FROM_BUTTON;
import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.SEARCH_BUTTON;
import static com.pruebatyba.travelocity.userinterfaces.FlightSearchFilters.START_DATE_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebatyba.travelocity.interactions.SearchPlace;
import com.pruebatyba.travelocity.interactions.SelectEndDate;
import com.pruebatyba.travelocity.interactions.SelectStartDate;
import com.pruebatyba.travelocity.models.FlightReservation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

public class SearchFlightReservation implements Task {

  private FlightReservation flightReservation;

  public SearchFlightReservation(FlightReservation flightReservation) {
    this.flightReservation = flightReservation;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(FLIGHT_TYPE_BUTTON.of(flightReservation.getFlightType())),
        Click.on(LEAVING_FROM_BUTTON),
        SearchPlace.named(flightReservation.getDeparturePlace()).into("origin"),
        Click.on(GOING_TO_BUTTON),
        SearchPlace.named(flightReservation.getDestinationPlace()).into("destination"),
        Click.on(START_DATE_BUTTON),
        SelectStartDate.onTheCalendar(flightReservation.getStartDate()),
        Click.on(END_DATE_BUTTON),
        SelectEndDate.onTheCalendar(
            flightReservation.getEndDate(), flightReservation.getStartDate()),
        Click.on(FLIGHT_CLASS_BUTTON),
        Click.on(FLIGHT_CLASS_LIST.of(flightReservation.getPreferredClass())),
        Check.whether(flightReservation.isAddAHotel())
            .andIfSo(
                Click.on(ADD_HOTEL_CHECKBOX),
                Click.on(CHECKIN_DATE_BUTTON),
                SelectStartDate.onTheCalendar(flightReservation.getCheckInDate()),
                Click.on(CHECKOUT_DATE_BUTTON),
                SelectEndDate.onTheCalendar(
                    flightReservation.getCheckOutDate(), flightReservation.getCheckInDate())),
        Check.whether(flightReservation.isAddACar()).andIfSo(Click.on(ADD_CAR_CHECKBOX)),
        Click.on(SEARCH_BUTTON));

    /*actor.attemptsTo(
    Click.on(FLIGHT_TYPE_BUTTON.of(flightReservation.getFlightType())),
    Click.on(LEAVING_FROM_BUTTON),
    SearchPlace.named(flightReservation.getDeparturePlace()),
    Click.on(GOING_TO_BUTTON),
    SearchPlace.named(flightReservation.getDestinationPlace()),
    Click.on(START_DATE_BUTTON));

    actor.attemptsTo(
        Click.on(START_DATE_BUTTON),
        SelectStartDate.onTheCalendar(flightReservation.getStartDate()),
        Click.on(END_DATE_BUTTON),
        SelectEndDate.onTheCalendar(
            flightReservation.getEndDate(), flightReservation.getStartDate()),
        Click.on(FLIGHT_CLASS_BUTTON),
        Click.on(FLIGHT_CLASS_LIST.of(flightReservation.getPreferredClass())),
        Check.whether(flightReservation.isAddAHotel())
            .andIfSo(
                Click.on(ADD_HOTEL_CHECKBOX),
                Click.on(CHECKIN_DATE_BUTTON),
                SelectStartDate.onTheCalendar(flightReservation.getCheckInDate()),
                Click.on(CHECKOUT_DATE_BUTTON),
                SelectEndDate.onTheCalendar(
                    flightReservation.getCheckOutDate(), flightReservation.getCheckInDate())),
        Check.whether(flightReservation.isAddACar()).andIfSo(Click.on(ADD_CAR_CHECKBOX)),
        Click.on(SEARCH_BUTTON));*/
  }

  public static SearchFlightReservation withTheFollowingInformation(
      FlightReservation flightReservation) {
    return instrumented(SearchFlightReservation.class, flightReservation);
  }
}
