package com.pruebatyba.travelocity.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class FlightSearchFilters {

  public static final Target PLACE_SEARCH_TEXT =
      Target.the("Text field to enter place").locatedBy("//input[@id='location-field-leg1-{0}']");
  public static final Target PLACE_SEARCH_LIST =
      Target.the("List of the different places")
          .locatedBy(
              "//div[@class='uitk-typeahead-results']//li//strong[text()='{0}']//ancestor::button");
  public static final Target START_DATE_BUTTON =
      Target.the("Button that enables calendar to select start date").located(By.id("d1-btn"));
  public static final Target END_DATE_BUTTON =
      Target.the("Button that enables calendar to select end date").located(By.id("d2-btn"));
  public static final Target CHECKIN_DATE_BUTTON =
      Target.the("Button that enables calendar to select check-in date")
          .locatedBy("//input[@placeholder='Check-in']/..");
  public static final Target CHECKOUT_DATE_BUTTON =
      Target.the("Button that enables calendar to select check-out date")
          .locatedBy("//input[@placeholder='Check-out']/..");
  public static final Target CALENDAR_MONTH =
      Target.the("Element that gets the month in the calendar")
          .locatedBy("//div[@class='uitk-date-picker-month'][1]/h2");
  public static final Target DATE_SELECT =
      Target.the("Button to select date")
          .locatedBy("//div[@class='uitk-date-picker-month'][1]//td/button[@data-day='{0}']");
  public static final Target NEXT_MONTH =
      Target.the("Button to select next month")
          .locatedBy("//div[@class='uitk-calendar']//button[2]");
  public static final Target APPLY_DATE_BUTTON =
      Target.the("Button to apply the selected date")
          .locatedBy("//button[@data-stid='apply-date-picker']");
  public static final Target SEARCH_BUTTON =
      Target.the("Button to search for information")
          .locatedBy("//button[@data-testid='submit-button' and text()='Search']");
  public static final Target FLIGHT_TYPE_BUTTON =
      Target.the("Button to select type of flight")
          .locatedBy("//div[@class='uitk-tabs-inner-container']//span[text()='{0}']");
  public static final Target LEAVING_FROM_BUTTON =
      Target.the("Button that enables list to select leaving from")
          .locatedBy("//div[@id='location-field-leg1-origin-menu']");
  public static final Target GOING_TO_BUTTON =
      Target.the("Button that enables list to select going to")
          .locatedBy("//button[@aria-label='Going to']");
  public static final Target FLIGHT_CLASS_BUTTON =
      Target.the("Button that enables list to select flight class")
          .located(By.id("preferred-class-input"));
  public static final Target FLIGHT_CLASS_LIST =
      Target.the("List of flight class")
          .locatedBy("//div[@id='preferred-class-input']//div//span[text()='{0}']");
  public static final Target ADD_HOTEL_CHECKBOX =
      Target.the("Check box to select add hotel").located(By.id("add-hotel-checkbox"));
  public static final Target ADD_CAR_CHECKBOX =
      Target.the("Check box to select add car").located(By.id("add-car-checkbox"));
  public static final Target FLIGHT_FILTER =
      Target.the("Item to select flight search filters")
          .locatedBy(
              "//fieldset[@data-test-id='filter-container']//legend[contains(@id, '{0}')]//ancestor::fieldset[@class='uitk-spacing uitk-spacing-margin-blockend-six']//span//div[contains(text(),'{1}')]/../../../../input[@type='checkbox']");

  public FlightSearchFilters() {}
}
