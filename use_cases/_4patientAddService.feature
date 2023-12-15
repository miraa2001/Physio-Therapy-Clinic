Feature: Patient add a service to his appointment
Description: The patient add service or services to his appointment
Actor: Patient

Scenario: Patient can choose the service
 	Given that the  patient "ayaayman" is logged in
 	And has booked an appointment with date "13/10/2022" and time "13:00"
 	And the service name is "MassaGe Therapy" with price 200.0
 	When patient tries to add the service to his appointment
 	Then the service can be chosen
 	And the service is added to the patient's appointment
 
  	