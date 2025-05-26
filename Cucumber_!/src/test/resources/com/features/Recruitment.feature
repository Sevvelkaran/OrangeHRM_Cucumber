Feature: Karan_26MAY2025_OrangeHRM_RECUIRTMENT
  Add New Candidate

  @Recruitment_Candidates
  Scenario Outline: Add new candidates
    Given I want to go into OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters  username "<Username>" and password "<Password>" to login
    And The user clicks on the Recruitment tab and clicks on the Candidates page
    And Clicks on Add 
    When The user enters Firstname as "<FirstName>", MiddleName as "<MiddleName>" and LastName as "<LastName>"
    And Selects Vacancy 
    And The user enters Email as "<Email>" and Contact as "<ContactNumber>"
    And Enters keyword as "<KeyWords>"
    And Clicks on Save
    Then Assert to check its presence

    Examples:
    
    |Username|Password| FirstName | MiddleName | LastName | Email         | ContactNumber | KeyWords      | 
    |	Admin	 |admin123| Dhanush   | Chandru    | Gowri    | dcg@gmail.com | 9876543210    | I am The best |