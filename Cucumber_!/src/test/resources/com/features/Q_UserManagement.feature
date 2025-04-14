Feature: User Management functionality in OrangeHRM
@Adduser
 Scenario: Add a new user 
  Given the user is on the DashBoard page
  When the user click the Admin menu
  And the user click on User Management and select Users
  And the user click the Add button
  And the user fills in the user details:
    | EmployeeName  | Thoushi F  |
    | Username      | Admin1     |
    | Password      | Admin@123  |
    | Confirm       | Admin@123  |
  And clicks the Save button
  Then the user should be added to the records
  
  
  @Viewuserwith_validcredentials
  Scenario Outline: View user with valid credentials
  Given the user is on the DashBoard page
  When the user click the Admin menu
  And the user fills in the filter fields with "<username>","<userrole>","<employeename>","<status>"
  And click the search button
  Then the user should be able to see the specific user in the list 
  Examples:
  | username | userrole     | employeename | status   |
  |Admin1    |              |              |          |
  |          |              | Thoushi F    |          |
  |Admin1    | Admin        |              |          |
  |Admin1    |              | Thoushi F    |          |
  |Admin1    |              |              | Enabled  |
  |          | Admin        | Thoushi F    |          |
  |Admin1    | Admin        | Thoushi F    |          |
  |Admin1    | Admin        | Thoushi F    | Enabled  |
  |Admin1    | Admin        |              | Enabled  | 
  |Admin1    |              | Thoushi F    | Enabled  |
  |          | Admin        | Thoushi F    | Enabled  |
  |          |              | Thoushi F    | Enabled  |  
  
  
  @Viewuserwith_Invalidcredentials
  Scenario Outline: View user with Invalid credentials
  Given the user is on the DashBoard page
  When the user click the Admin menu
  And the user fills in the filter fields with "<username>","<userrole>","<employeename>","<status>"
  And click the search button
  Then the user should see the message "message"
  Examples:
  | username | userrole     | employeename | status   |message|
  | abcd     |              |              |          |No Records Found|
  |          |              |  abcd        |          |Invalid|
  | abcd     |  Admin       |  abcd        | Enabled  |Invalid|
  | Admin1   |              |  abcd        |          |Invalid|
  | abcd     |              |  Thoushi F   |          |No Records Found|
  