Feature: Add Appointement to clinic system
	Description:add an appointement to our clinic
	Actors: patient

Background:
Given we have patient appointements table. 
 	 |ayaayman|13/10/2022|13:00| 
	 |leenh|18/10/2022|12:00| 
	 |suha2001|31/10/2022|11:00|
	 
	
Scenario: Add an appointement successfully
 	Given that the patient "leenh" is logged in
    And the wanted date "19/10/2022" and time "14:00" is available
 	Then the date and time are available to be added
 	And the appointment is added to the patient's information

 	
Scenario: Add an appointement unsuccessfully
 	Given that the patient "leenh" is logged in
    And the wanted date "18/10/2022" and time "12:00" is unavailable
 	Then the date is not added to the patient's appointements
 	