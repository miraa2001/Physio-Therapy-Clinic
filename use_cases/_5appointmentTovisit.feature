Feature: Visits
  Description: Review the patient's visits to the clinic
  Actor: User 
   
 
Scenario: The patient's appointment turns into a visit
    Given  that the patient "ayaayman" is logged in to the system
    And the date "13/10/2022" and time "13:00" of the appointment have passed
    Then the appointment is turned into a visit
    And it is stored in the patient's record