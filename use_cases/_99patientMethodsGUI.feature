Feature: Patient GUI Test
Scenario: Book Apointment funtions properly
Given that user is logged in ->Patient GUI
And the username is "suha2001" ->Patient GUI
And Book Appointment is clicked ->Patient GUI
And Message Label says "Appointment is added" ->Patient GUI
Then button is operating correctly ->Patient GUI

Scenario: Book Apointment does not funtion properly
Given that user is logged in ->Patient GUI
And the username is "suha2001" ->Patient GUI
And Book Appointment is clicked ->Patient GUI
And Message Label says "Appointment is unavailable" ->Patient GUI
Then button is not operating correctly ->Patient GUI

Scenario: Show Apointment funtions properly
Given that user is logged in ->Patient GUI
And the username is "suha2001" ->Patient GUI
And Show Appointment is clicked ->Patient GUI
And textarea is not empty->Patient GUI
Then textarea is operating correctly ->Patient GUI

Scenario: Get a bill button funtions properly
Given that user is logged in ->Patient GUI
And the username is "suha2001" ->Patient GUI
And Get a bill is clicked ->Patient GUI
And at least one appointment exists->Patient GUI
Then bill button is operating correctly ->Patient GUI