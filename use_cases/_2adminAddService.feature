Feature: Admin add a service to the clinic
Description: The process of adding services to the system by the admin
Actor: Admin
Background: The clinic has services, each of the them has its price
And these are the services
|Massage Therapy|200|
|Sports Injuries|120|
|Custom Orthotics|300|
|Acupuncture|200|

Scenario: Can add a service 
 	Given that the admin is logged in
 	And the service does not pre-exist
 	And the service is "Pre and Post-Surgical Care" and its price is 200.0 
 	When admin tries to add the service to the clinic
 	Then the service can be added
 	Then the service is added
 	
 	
Scenario: Can not add a service
  	Given that the admin is logged in
 	And the service does pre-exist
 	And the service is "Massage Therapy" and its price is 200.0
 	When admin tries to add the service to the clinic
 	Then the service cannot be added
 	Then the service is not added
 	
