@ManageEmployee
Feature: Employee Management in OrangeHRM
  As administrator
  I want manage employee data
  To keep employee information up-to-date and organized

  Background: Login on OrangeHRM
    Given the user is logged into OrangeHRM

  @AddingEmployee
  Scenario Outline: Add a new employee
    When the user adds a new employee with the data
      | <firstName> | <lastName> | <otherEmail> | <province> | <messageTitle> | <messageBody> |
    Then the employee should be created successfully with your data

    Examples:
      | firstName | lastName | otherEmail         | province | messageTitle | messageBody          |
      | Sandra    | Perez    | Test_#@yopmail.com | Testone  | Success      | Successfully Updated |

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
    When the user on Employee List page deleted an employee in the list
    Then the employee deleted show "<messageTitle>" "<messageBody>" and should no longer be in the list

    Examples:
      | messageTitle | messageBody      |
      | Info         | No Records Found |


  @UploadFile
  Scenario Outline: Upload a file in My Info on Contact Details
    When the user on Contact Details uploads a valid file "<fileName>"
    Then the file should be visible below the form

    Examples:
      | fileName  |
      | img_#.png |

  @DeleteUploadFile
  Scenario Outline: Delete an uploaded file
    When the user on Contact Details deletes the file "<fileName>"
    Then messages must be visible "<messageTitle>" "<messageBody>" and the file is no longer visible in the list

    Examples:
      | fileName  | messageTitle | messageBody          |
      | img_#.png | Success      | Successfully Deleted |