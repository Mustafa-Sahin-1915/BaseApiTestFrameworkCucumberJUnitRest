@PostUsersTestReqresApi
Feature: Test https://reqres.in/api APIs functionalities

  Scenario Outline: Test post user
    Given setup api "<baseuri>" and "<basepath>"
    And create user pojo with name as "<name>" and email as "<email>"
    When call POST request to create user
    Then verify that status code is <statusCode>
    And verify that response body name is "<name>"
    And verify that response body email is "<email>"
    Examples:
      | baseuri           | basepath | name | statusCode | email           |
      | https://reqres.in | /api     | test1    | 201        | test1@reqres.in |