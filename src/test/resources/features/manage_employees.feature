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
      | <firstName> | <lastName> | <otherEmail> | <province> | <message> |
    Then the employee should be created successfully with your data

    Examples:
      | firstName | lastName | otherEmail         | province | message |
      | Sandra    | Perez    | Test_#@yopmail.com | Testone  | Success |

  @EditEmployee
  Scenario Outline: Edit an existing employee
    When the user updates an existing employee's details
      | <firstName> | <lastName> | <otherEmail> | <province> | <message> |
    Then the updated details should be visible in the list

    Examples:
      | firstName | lastName | otherEmail         | province | message |
      | Emilio    | Guzman    | Test_#@yopmail.com | Testone  | Success |

  Scenario Outline: Search for an employee
    Given the user is on the Employee List page
    When the user searches for an employee by <nameEmployed>
    Then the correct employee <nameEmployed> should appear in the results
    Examples:
      | nameEmployed |
      | Sara         |


  Scenario Outline: Delete an employee
    Given the user is on the Employee List page
    When the user deletes an employee <idEmployed> in the list
    Then the employee deleted <idEmployed> should no longer be in the list

    Examples:
      | idEmployed |
      | Sara       |


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



