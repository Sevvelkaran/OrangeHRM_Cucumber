Feature: Admin Functionalities
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
  And the user click the Add Employee button
  And the user fill the Employee form with details:
    |Firstname|Thoushi|
    |Middlename||
    |Lastname|F|
    |Employeeid|61|
  And the user click the Save button
  And the user click the Report-to
  And the user click the Add button under Assigned Supervisors
  And the user fill the Supervisor form with:
    |Name|Gayu R|
    |ReportingMethod|Direct|
  And the user click the Save button
  Then the user should be added to the employee Records