Feature: Login
Actor: User
Description: The User's login process to the system gui
Scenario: Patient can login -> gui
Given that the patient "leenh" is not logged in -> gui
When patient tries to login -> gui
And username is "leenh" and password is "leen21"  -> gui
Then the patient login succeeds -> gui
And the patient is logged in -> gui

Scenario: Patient cannot login -> gui
Given that the patient "leenh" is not logged in -> gui
When patient tries to log in -> gui
And username is "leenh" and password is "wrongpassword"  -> gui
Then the patient login fails -> gui
And the patient is not logged in 

Scenario: Admin can login -> gui
Given that the admin "miraj" is not logged in -> gui
When admin tries to log in -> gui
And username is "miraj" and password is "1212001"  -> gui
Then the admin login succeeds -> gui
And the admin is logged in -> gui

Scenario: Admin cannot login -> gui
Given that the admin "miraj" is not logged in -> gui
When admin tries to log in -> gui
And username is "miraj" and password is "wrongpassword"  -> gui
Then the admin login fails -> gui
And the admin is not logged in -> gui

Scenario: Credentials do not match with an admin's nor a patient's -> gui
Given that no one is not logged in -> gui
When user tries to log in -> gui
And username is "nonexistent" and password is "wrongpassword"  -> gui
Then login fails -> gui
And the user is redirected to sign up page -> gui