Feature: Dharani_28APR2025_OrangeHRM_Admin-Configuration
Scenario: Disable the recruitment module 
  Given the user is on the DashBoard page
  When the user click the Admin menu
  And the user click on Configuration and select Modules
  And the user disables the Recruitment module
  And the user submits the changes by selecting Save
  Then the Recruitment module should be hidden from the menu

Scenario: Modify Localization
  Given the user is on the DashBoard page
  When the user click the Admin menu
  And the user clicks on Configuration and selects Localization
  And the user selects "English (United States)" as the language
  And the user selects the date format as "yyyy-dd-mm"
  And the user click the Save 
  Then the user should see the interface in the selected language


