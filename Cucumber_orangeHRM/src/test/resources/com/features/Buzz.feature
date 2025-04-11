@Buzz
Feature: Post a message to Buzz in OrangeHRM
  @BuzzNewsFeed
  Scenario: User posts a message to the Buzz newsfeed
    Given The user logs into the OrangeHRM application
    When The user navigates to the Buzz section
    And The user enters the following message in the Buzz feed
      | Message                                                                                        |
      | Successfully completed the automation of Performance Tracker module using Selenium and Cucumber|
    And The user clicks the Post button
    Then The message should be displayed on the Buzz feed