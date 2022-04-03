Feature: Consult flight information to reserve
  As a user of the Travelocity system
  I want to be able to consult the information of the available flight
  To be able to make a flight reservation

  Background:
    Given that Jhoa wants to use the "Flights" reservation service on Travelocity

  Scenario: Flights available according to search filters
    When she searches for the required flight "Roundtrip"
    And she filters available flights by: "Airlines", "LATAM Airlines Group"
    Then she should see that the flight list was filtered with the option "LATAM Airlines Group"