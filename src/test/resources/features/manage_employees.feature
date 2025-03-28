@ManageEmployee
Feature: Employee Management in OrangeHRM
  I as administrator
  want manage employee data
  to keep employee information up-to-date and organized

  Background: Login on OrangeHRM
    Given the user is logged into OrangeHRM

  @AddingEmployee
  Scenario Outline: Add a new employee
    When the user adds a new employee with the data
      | <firstName> | <lastName> | <otherEmail> | <province> | <messageTitle> | <messageBody> |
    Then the employee should be created successfully with your data

    Examples:
      | firstName | lastName | otherEmail         | province | messageTitle | messageBody        |
      | Sandra    | Perez    | Test_#@yopmail.com | Testone  | Success      | Successfully Saved |

  @EditEmployee
  Scenario Outline: Edit an existing employee
    When the user updates an existing employee's details
      | <firstName> | <lastName> | <otherEmail> | <province> | <messageTitle> | <messageBody> |
    Then the updated details should be visible in the list

    Examples:
      | firstName | lastName | otherEmail         | province | messageTitle | messageBody          |
      | Emilio    | Guzman   | Test_#@yopmail.com | Testone  | Success      | Successfully Updated |

  @SearchEmployee
  Scenario Outline: Search for an employee
    When the user on Employee List page searches an employee "<nameEmployed>"
    Then the correct employee "<nameEmployed>" should appear in the results

    Examples:
      | nameEmployed |
      | Sara         |
      | emilina      |
      | 14           |


  @DeleteEmployee
  Scenario Outline: Delete an employee
    When the user on Employee List page deleted an employee "<nameEmployed>" in the list
    Then the employee deleted show "<messageTitle>" "<messageBody>" and should no longer be in the list

    Examples:
      | nameEmployed | messageTitle | messageBody      |
      | 1            | Info         | No Records Found |


  Scenario Outline: Upload a file in My Info on Contact Details
    Given the user is in My Info on Contact Details
    When the user uploads a valid file <fileName>
    Then the file should be visible <fileName> below the form

    Examples:
      | fileName |
      | img.png  |


  Scenario Outline:: Delete an uploaded file
    Given the user has a file in My Info on Contact Details
    When the user deletes the file <fileName>
    Then it should no be visible <fileName>

    Examples:
      | fileName |
      | img.png  |



