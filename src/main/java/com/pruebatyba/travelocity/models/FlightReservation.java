package com.pruebatyba.travelocity.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlightReservation {

  private String departurePlace;
  private String destinationPlace;
  private String startDate;
  private String endDate;
  private String flightType;
  private boolean addAHotel;
  private String checkInDate;
  private String checkOutDate;
  private boolean addACar;
  private String preferredClass;

  private FlightReservation(Map<String, String> flightReservationData) {
    this.departurePlace = flightReservationData.get("departurePlace");
    this.destinationPlace = flightReservationData.get("destinationPlace");
    this.startDate = flightReservationData.get("startDate");
    this.endDate = flightReservationData.get("endDate");
    this.flightType = flightReservationData.get("flightType");
    this.checkInDate = flightReservationData.get("checkInDate");
    this.checkOutDate = flightReservationData.get("checkOutDate");
    this.addAHotel = Boolean.parseBoolean(flightReservationData.get("addAHotel"));
    this.addACar = Boolean.parseBoolean(flightReservationData.get("addACar"));
    this.preferredClass = flightReservationData.get("preferredClass");
  }

  public String getDeparturePlace() {
    return departurePlace;
  }

  public void setDeparturePlace(String departurePlace) {
    this.departurePlace = departurePlace;
  }

  public String getDestinationPlace() {
    return destinationPlace;
  }

  public void setDestinationPlace(String destinationPlace) {
    this.destinationPlace = destinationPlace;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getFlightType() {
    return flightType;
  }

  public void setFlightType(String flightType) {
    this.flightType = flightType;
  }

  public String getCheckInDate() {
    return checkInDate;
  }

  public void setCheckInDate(String checkInDate) {
    this.checkInDate = checkInDate;
  }

  public String getCheckOutDate() {
    return checkOutDate;
  }

  public void setCheckOutDate(String checkOutDate) {
    this.checkOutDate = checkOutDate;
  }

  public boolean isAddAHotel() {
    return addAHotel;
  }

  public void setAddAHotel(boolean addAHotel) {
    this.addAHotel = addAHotel;
  }

  public boolean isAddACar() {
    return addACar;
  }

  public void setAddACar(boolean addACar) {
    this.addACar = addACar;
  }

  public String getPreferredClass() {
    return preferredClass;
  }

  public void setPreferredClass(String preferredClass) {
    this.preferredClass = preferredClass;
  }

  public static List<FlightReservation> getFlightReservations(
      List<Map<String, String>> flightReservationList) {
    List<FlightReservation> flightReservations = new ArrayList<>();
    flightReservationList.forEach(
        flightReservation -> flightReservations.add(new FlightReservation(flightReservation)));
    return flightReservations;
  }
}
