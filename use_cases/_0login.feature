Feature: Login
Actor: User
Description: The User's login process to the system
Background: The clinic has admins and patients
And these are the users
|miraj|1212001|Mira Jamous|
|talahamad|tala2001|Tala Hamad|
|areenateeq|areen2002|Areen Ateeq|

Scenario: Patient can login
Given that the patient "ayaayman" is not logged in
When patient tries to login
And username is "ayaayman" and password is "aya2001"
Then the patient login succeeds
And the patient is logged in

Scenario: Patient cannot login
Given that the patient "ayaayman" is not logged in
When patient tries to log in
And username is "ayaayman" and password is "wrongpassword"
Then the patient login fails
And the patient is not logged in

Scenario: Admin can login
Given that the admin "miraj" is not logged in
When admin tries to log in
And username is "miraj" and password is "1212001"
Then the admin login succeeds
And the admin is logged in

Scenario: Admin cannot login
Given that the admin "miraj" is not logged in
When admin tries to log in
And username is "miraj" and password is "wrongpassword"
Then the admin login fails
And the admin is not logged in

Scenario: Credentials do not match with an admin's nor a patient's
Given that no one is not logged in
When user tries to log in
And username is "nonexistent" and password is "wrongpassword"
Then login fails
And the user is redirected to sign up page