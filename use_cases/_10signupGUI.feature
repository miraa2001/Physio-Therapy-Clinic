Feature: Sign up GUI
Actor: An outsider to the system

Scenario: The sign up is successful ->gui
Given that the user "moh2001" is  not logged in ->gui 
And they do not have an account in the system ->gui
And they choose username "moh2001" password "mo1212" and name "mohammed" ->gui
Then the sign up succeeds ->gui
And the user is redirected to the login page ->gui

Scenario: The sign up is unsuccessful ->gui
Given that the user "ayaayman" is  not logged in ->gui
And they does have an account in the system ->gui
And they choose username "ayaayman" password "aya2001" and name "Aya Ayman" ->gui
And they choose username "miraj" password "1212001" and name "Mira Jamous" ->gui
Then the sign up fails ->gui
And the user is prompted to try again ->gui