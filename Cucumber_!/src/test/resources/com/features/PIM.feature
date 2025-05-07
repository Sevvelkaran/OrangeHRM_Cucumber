Feature: Dharani_10APR2025_OrangeHRM_PIM
@AddEmployee  
Scenario: Add two new employees and assign a supervisor
  Given the user is on the DashBoard page
  When the user click the PIM menu
  And the user click the Add Button
  And the user fill the Employee form with details:
    |Firstname|Gayu| 
    |Middlename||
    |Lastname|R|
    |Employeeid|60|
  And the user click the Save Button
  
  @AddEmergencycontacts
Scenario: Add a Emergency contact
  Given the user is on the DashBoard page
  When the user click the PIM menu
  And the user click the Add Button
  And the user fill the Employee form with details:
    |Firstname|Gayu|
    |Middlename||
    |Lastname|R|
    |Employeeid|61|
  And the user click the Save Button
 And the user clicks the Emergency Contacts section
  And the user clicks the Add button in Emergency Contacts
  And the user fills the emergency contact form with:
    | Name         | Priya         |
    | Relationship | Sister        |
    | Mobile       | 9876543210    |
  And the user clicks the Save button in Emergency Contacts
  Then the contact should be saved in the Emergency Contacts records
  
  @Assignasupervisor
  Scenario: Assign a supervisor
  Given the user is on the DashBoard page
  When the user click the PIM menu
  And the user click the Add Employee button
  And the user fill the Employee form with details:
    |Firstname|Thoushi|
    |Middlename||
    |Lastname|F|
    |Employeeid|62|
  And the user click the Save Button
  And the user click the Report-to
  And the user click the Add button under Assigned Supervisors
  And the user fill the Supervisor form with:
    |Name|Gayu R|
    |ReportingMethod|Direct|
  And the user click the Save button
  And the user click the Add button under Assigned Supervisors
  And the user fill the Supervisor form with:
    |Name|Thoushi F|
    |ReportingMethod|Direct|
  And the user click the Save button
  Then the user should be added to the supervisor Records
  
  @SearchEmployee
Scenario Outline: Search employee with Invalid credentials
  Given the user is on the DashBoard page
  When the user click the PIM menu
  And the user click the Add Button
  And the user fills the employee form with "<Firstname>", "<Middlename>", "<Lastname>", and "<Employeeid>"
  And the user click the Save button
  Then the user should get the error message"<message>"
Examples:
  | Firstname | Middlename | Lastname | Employeeid |message |
  |           |            | M        | 102        |Required|
  | Guhanathan|    Mary    |          | 10921      |Required|
  |           |            |          |            |Required| 