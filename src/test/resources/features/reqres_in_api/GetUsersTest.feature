@GetUsersTestReqresApi
Feature: Test https://reqres.in/api APIs functionalities

  Scenario Outline: Test get user with valid user name
    Given setup api "<baseuri>" and "<basepath>"
    And set <usernumber> to get user info
    When call GET request to get user info
    Then verify that status code is <statusCode>
    And verify that response body data id is <id>
    And verify that response body data email is "<email>"
    Examples:
      | baseuri           | basepath | usernumber | statusCode | id | email                  |
      | https://reqres.in | /api     | 2          | 200        | 2  | janet.weaver@reqres.in |