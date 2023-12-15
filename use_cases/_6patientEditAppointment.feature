Feature: Edit Appointement to clinic system
	Description: edit an appointement to our clinic
	Actors: patient

Scenario: edit a date or time of appointement successfully 
 	Given that  the patient "leenh" is logged in 
 	And  we have date "18/10/2022" and time "12:00" in our system
 	And the new entered date "19/10/2022" and time "13:00" are available 
 	Then the date and time can be edited
 	And the date and time are edited
 	
Scenario: edit a date or time of appointement unsuccessfully
 	Given that  the patient "leenh" is logged in 
 	And we have date "18/10/2022" and time "12:00" in our system
 	And the new entered date "13/10/2022" and time "13:00" are unavailable 
 	Then the date and time can not be edited
 	And the date and time are not edited
 	