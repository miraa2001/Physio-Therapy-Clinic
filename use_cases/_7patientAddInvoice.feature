Feature: Patient add invoice
Description: The patient adds an invoice for each visit
Actor: Patient


Scenario: Patient can add an invoice successfully
 	Given that the patient "ayaayman" is logged  in
 	And they have an appointment with date "13/10/2022" and time is "13:00"
 	And its status is 1
 	When the patient tries to add the invoice 
 	Then the invoice can be generated
 	And the invoice is generated
 	 	
Scenario: Patient can not add invoice successfully
    Given that the patient "suha2001" is logged  in
 	And they have an appointment with date "31/10/2022" and time is "11:00"
 	And its status is 0
 	When the patient tries to add the invoice 
 	Then the invoice cannot be generated
 	And the invoice is not generated

Scenario: Patient can not add invoice
	Given that the patient "ayaayman" is logged  in 
	And they do not have an appointment 
 	When the patient tries to add the invoice 
 	Then the invoice cannot be generated
 	And the invoice is not generated 	