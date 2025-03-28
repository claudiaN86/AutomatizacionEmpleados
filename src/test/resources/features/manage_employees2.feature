#Autor: Claudia Nieto
#Email: cmarce86@yahoo.es
#language: en

@AddingCart
Feature: Manage employee data
  I as administrator
  want manage employee data
  to keep employee information up-to-date and organized

  Background: Access the OrangeHRM's homepage
    Given I log in on the main page


  Scenario Outline: Add a new employee
    When I add an employee with the data "<firstName>" "<lastName>" "<email>" "<department>"
    Then I should see the employee's data
    Examples:
      | firstName | lastName | email               | department |
      | Sandra    | Perez    | pruebas@yopmail.com | xxx        |





