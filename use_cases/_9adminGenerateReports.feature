Feature: Admin generates reports 
Description: The admin generates the needed reports 
Actor: Admin 

Scenario: Admin can generate patients' names report with their appointments details
	Given that the admin "talahamad" is logged in
	And there are patients in the clinic
	And at least one patient has an appointment
	Then the report can be generated
	And the report is generated

Scenario: Admin can display services and the team
	Given that the admin "talahamad" is logged in
	And there are services
	Then the services and the team report can be generated
	And the report of the services and team is generated
