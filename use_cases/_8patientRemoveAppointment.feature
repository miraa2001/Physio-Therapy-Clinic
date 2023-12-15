Feature: Remove Appointement to clinic system
	Description: edit an appointement to our clinic
	Actors: patient

Background:
Given we have patient appointements table. 
 	 |ayaayman|13/10/2022|13:00| 
	 |leenh|18/10/2022|12:00| 
	 |suha2001|20/10/2022|11:00|


Scenario: remove a date or time of appointement successfully 
 	Given that the patient  "leenh" is logged in 
 	And the entered date is "19/10/2022" and time is "13:00"
 	And the date and time exist in the patient's appointment's
 	Then the date and time can be removed
 	And the date and time are removed
 	
Scenario: remove a date or time of appointement unsuccessfully
 	Given that the patient  "leenh" is logged in 
 	And the entered date is "13/10/2022" and time is "13:00"
 	And the date and time do not exist in the patient's appointment's
 	Then the date and time can not be removed
 	And the date and time are not removed