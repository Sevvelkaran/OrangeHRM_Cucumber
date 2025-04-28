Feature: Dharani_28APR2025_OrangeHRM_Admin-Configuration
Scenario: Add a new user 
  Given the user is on the DashBoard page
  When the user click the Admin menu
  And the user click on Configuration and select Modules
  And the user disables the Recruitment module
  And the user submits the changes by selecting Save
  Then the Recruitment module should be hidden from the menu

